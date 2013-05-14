package com.conwet.samson.extra;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;


public class ProxyHTTP {
	
	private int localPort;
	private int brokerPort;
	private String brokerHost;
	private final ServerSocket serverSocket;
	
	public ProxyHTTP(String brokerHost, int brokerPort, int localPort) throws IOException  {
		
		this.localPort = localPort;
		this.brokerHost = brokerHost;
		this.brokerPort = brokerPort;
		this.serverSocket = new ServerSocket();
	}
	
	public void start() throws Exception {
		
		final CountDownLatch ready = new CountDownLatch(1);
		serverSocket.bind(new InetSocketAddress(localPort));
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				try {
					while(true) {
						
						ready.countDown();
						handleSocket(serverSocket.accept());
					}
				} catch (IOException e) {
					// do nothing, just exit
				}
			}
		}).start();
		
		ready.await();
	}
	
	private void handleSocket(Socket socket) {
		
		// spawn a new thread to handle the request
		new Thread(new ContentTypeFilter(brokerHost, brokerPort, socket)).start();
	}
	
	public void stop() throws IOException {
		
		serverSocket.close();
	}
	
	// filtering class
	private static class ContentTypeFilter implements Runnable {
		
		private Socket local;
		private Socket broker;
		
		public ContentTypeFilter(String brokerHost, int brokerPort, Socket local) {
			
			this.local = local;
			
			try {
				this.broker = new Socket(brokerHost, brokerPort);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
						
			try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
													local.getOutputStream()));
				BufferedReader br = new BufferedReader(new InputStreamReader(
													local.getInputStream()));
				BufferedWriter toBroker = new BufferedWriter(new OutputStreamWriter(
												broker.getOutputStream()));
				BufferedReader fromBroker = new BufferedReader(new InputStreamReader(
												broker.getInputStream()));) {
				
				writeRequest(br, toBroker);
				filterResponse(fromBroker, bw);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		private void writeRequest(BufferedReader input, BufferedWriter output) throws IOException {
			
			String line;
			int contentLength = 0;
			
			// read header
			while((line = input.readLine()) != null) {
				
				if (line.startsWith("Content-Length:")) {
					
					contentLength = Integer.parseInt(line.split(":")[1].trim());
				}
				
				// set proper WRONG Content-Type
				
				if (line.startsWith("Content-Type:")) {
					
//					line = "Content-Type: application/x-www-form-urlencoded; charset=utf-8";
				}
				
				output.append(line);
				output.append("\n");
				
				if (line.isEmpty()) {
					break;
				}
			}
			
			// here reads the content using its length
			char[] content = new char[contentLength];
			int read = 0;
			
			while (read < contentLength) {
				
				read += input.read(content, read, contentLength - read);
			}
			System.out.println("CONTENT=" + new String(content));
			output.append(new String(content));
			output.flush();
			
			broker.shutdownOutput();
		}
		
		private void filterResponse(BufferedReader input, BufferedWriter output) throws IOException {
			
			String line;
			
			while ((line = input.readLine()) != null) {
				
				if (line.startsWith("Content-Type:")) {
					// removes double quotes from Content-Type
//					line = line.replace("\"", "");
				}
				
				output.append(line);
				output.append("\n");
				
				if (!input.ready()) {
					break;
				}
			}
			
			input.close();
			output.close();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		//130.206.80.195
		ProxyHTTP proxy = new ProxyHTTP("130.206.80.195", 1026, 4444);
		proxy.start();
		System.out.println("press enter to exit...");
		new BufferedReader(new InputStreamReader(System.in)).readLine();
		System.out.println("exiting from proxy...");
		proxy.stop();
		System.out.println("done.");
	}
}
