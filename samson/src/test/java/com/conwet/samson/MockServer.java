package com.conwet.samson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * This Single-Threaded server simply reply with HTTP headers.
 * 
 * @author sergio
 */
public class MockServer implements Runnable {

	private ServerSocket serverSocket;
	private Socket socket;
	private String reply;
	private String request;

	private AtomicBoolean isRunnning;
	private CountDownLatch ready;
	private AtomicReference<Thread> thread;

	/**
	 * Construct an instance of this class and bind it to an ephemeral port.
	 * 
	 * @see ServerSocket#ServerSocket(int)
	 * @throws IOException
	 *             if some error occur
	 */
	public MockServer() throws IOException {

		this(0);
	}

	/**
	 * Construct an instance of the server and binds to the given port.
	 * 
	 * @param port
	 *            the port number to bind the server
	 * @throws IOException
	 *             if some error occur
	 */
	public MockServer(int port) throws IOException {

		isRunnning = new AtomicBoolean();
		ready = new CountDownLatch(1);
		thread = new AtomicReference<>();
		serverSocket = new ServerSocket(port);
	}

	@Override
	public void run() {

		isRunnning.set(Boolean.TRUE);
		ready.countDown();

		while (isRunnning.get()) {

			try {
				socket = serverSocket.accept();
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				// read content after headers
				StringBuilder sb = new StringBuilder();
				char[] content = new char[readHeaders(reader, sb)];
				reader.read(content);
				sb.append(new String(content));

				request = sb.toString();
				
				// send the response
				writer.append("HTTP/1.1 200 OK\n\n"); // HTTP header
				writer.append(reply);
				writer.close();
				reader.close();

				socket.close();
			} catch (IOException ex) {

				if (isRunnning.getAndSet(Boolean.FALSE)) {

					ex.printStackTrace();
					try {
						serverSocket.close();
					} catch (IOException ex1) {
						ex1.printStackTrace();
					}
				}
			}
		}
	}

	private int readHeaders(BufferedReader reader, StringBuilder sb) throws IOException {
		
		int contentLength = 0;
		String line = "no empty string";

		// reads headers
		while (!line.isEmpty()) {

			line = reader.readLine();
			sb.append(line);
			sb.append("\n");

			if (line.contains("Content-Length:")) {

				int index = line.indexOf(":") + 2; // to strip space
				contentLength = Integer.valueOf(line.substring(index));
			}
		}
		
		return contentLength;
	}

	public void start() throws InterruptedException {

		Thread t = new Thread(this);
		t.start();
		thread.set(t);
		ready.await();
	}

	public void stop() {

		if (isRunnning.getAndSet(Boolean.FALSE)) {

			try {
				serverSocket.close();

				if (socket != null) {

					socket.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		Thread t = thread.get();
		if (t != null) {
			try {
				t.join();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getRequest() {
		return request;
	}

	public int getServerPort() {

		return serverSocket.getLocalPort();
	}
}