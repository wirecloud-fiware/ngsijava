/*
 *     (C) Copyright 2013 CoNWeT Lab - Universidad Politécnica de Madrid
 *
 *     This file is part of ngsijava.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

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
