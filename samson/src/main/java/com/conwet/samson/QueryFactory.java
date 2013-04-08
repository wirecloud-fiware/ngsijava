
package com.conwet.samson;

/**
 * Factory class to instantiate an implementation of {@linkplain QueryBroker}
 * 
 * @author sergio
 */
public class QueryFactory {
	
	/**
	 * Returns a new instance of {@linkplain QueryBroker}.
	 * 
	 * @param host the hostname where the context broker is running
	 * @param port the port used by the context broker, must be greater than zero
	 * @return the {@linkplain QueryBroker} instantiated
	 */
	public static QueryBroker newQuerier(String host, int port) {
		
		return new Querier(host, port);
	}
}
