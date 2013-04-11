/*
 *     (C) Copyright 2013 CoNWeT Lab - Universidad Politécnica de Madrid
 *
 *     This file is part of ngsijava.
 *
 *     Ngsijava is free software: you can redistribute it and/or modify it under
 *     the terms of the GNU Affero General Public License as published by the
 *     Free Software Foundation, either version 3 of the License, or (at your
 *     option) any later version.
 *
 *     Ngsijava is distributed in the hope that it will be useful, but WITHOUT
 *     ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 *     FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public
 *     License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with ngsijava. If not, see <http://www.gnu.org/licenses/>.
 *
 *     Linking this library statically or dynamically with other modules is
 *     making a combined work based on this library.  Thus, the terms and
 *     conditions of the GNU Affero General Public License cover the whole
 *     combination.
 *
 *     As a special exception, the copyright holders of this library give you
 *     permission to link this library with independent modules to produce an
 *     executable, regardless of the license terms of these independent
 *     modules, and to copy and distribute the resulting executable under
 *     terms of your choice, provided that you also meet, for each linked
 *     independent module, the terms and conditions of the license of that
 *     module.  An independent module is a module which is not derived from
 *     or based on this library.  If you modify this library, you may extend
 *     this exception to your version of the library, but you are not
 *     obligated to do so.  If you do not wish to do so, delete this
 *     exception statement from your version.
 *
 */

package com.conwet.samson;

import java.util.Objects;

import javax.ws.rs.core.MediaType;
import javax.xml.datatype.Duration;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import com.conwet.samson.jaxb.ContextElement;
import com.conwet.samson.jaxb.ContextElementList;
import com.conwet.samson.jaxb.ContextRegistration;
import com.conwet.samson.jaxb.ContextRegistrationList;
import com.conwet.samson.jaxb.ContextResponse;
import com.conwet.samson.jaxb.EntityId;
import com.conwet.samson.jaxb.EntityIdList;
import com.conwet.samson.jaxb.ObjectFactory;
import com.conwet.samson.jaxb.QueryContextRequest;
import com.conwet.samson.jaxb.RegisterContextRequest;
import com.conwet.samson.jaxb.RegisterContextResponse;
import com.conwet.samson.jaxb.UpdateActionType;
import com.conwet.samson.jaxb.UpdateContextRequest;

/**
 * This class execute queries to Context Broker and unmarshal its XML response
 * into Java object.
 *
 * @author sergio
 */
public class Querier implements QueryBroker {
	
	private static final String REGISTER = "/ngsi9/registerContext";
	private static final String QUERY = "/ngsi10/queryContext";
	private static final String UPDATE = "/ngsi10/updateContext";
	
	private String url;
	private ObjectFactory factory;
	
	/**
	 * Construct a {@linkplain Querier} object to query the context broker
	 * at the specified address.
	 * 
	 * @param host the hostname where the context broker is running
	 * @param port the port used by the context broker, must be greater than zero
	 */
	Querier(String host, int port) {
		
		Objects.requireNonNull(host, "Hostname is null");
		
		if (port <= 0) {

			throw new IllegalArgumentException("port must be positive: port=" + port);
		}
		
		this.url = "http://" + host + ":" + port;
		this.factory = new ObjectFactory();
	}
	
	@Override
	public EntityId newEntityId(String type, String id) {
		
		EntityId entityID = factory.createEntityId();
		entityID.setType(type);
		entityID.setId(id);
		entityID.setIsPattern(Boolean.FALSE);
		
		return entityID;
	}
	
	@Override
	public ContextResponse queryContext(EntityId entityId) throws Exception {
		
		EntityIdList list = factory.createEntityIdList();
		list.getEntityId().add(entityId);
		
		QueryContextRequest request = new QueryContextRequest();
		request.setEntityIdList(list);
		
		return response(QUERY, request, ContextResponse.class);
	}
	
	@Override
	public RegisterContextResponse registerContext(ContextRegistration cxtReg, Duration duration) throws Exception {
		
		ContextRegistrationList list = factory.createContextRegistrationList();
		list.getContextRegistration().add(cxtReg);
		
		RegisterContextRequest request = factory.createRegisterContextRequest();
		request.setContextRegistrationList(list);
		request.setDuration(duration);
		
		return response(REGISTER, request, RegisterContextResponse.class);
	}
	
	@Override
	public ContextResponse updateContext(ContextElement cxtElem, UpdateActionType action) throws Exception {
		
		ContextElementList list = factory.createContextElementList();
		list.getContextElement().add(cxtElem);
		
		UpdateContextRequest request = factory.createUpdateContextRequest();
		request.setContextElementList(list);
		request.setUpdateAction(action);
		
		return response(UPDATE, request, ContextResponse.class);
	}
	
	/**
	 * Creates a client request to the host with the given path and data as
	 * POST content.
	 * 
	 * @param path  the path to use for request
	 * @param data  the POST content
	 * @param clazz the class type to cast the result
	 * @return a {@linkplain ContextResponse} containing server's reply
	 * @throws Exception if some errors occur
	 */
	private <T> T response(String path, Object data, Class<T> clazz) throws Exception {
		
		ClientRequest req = new ClientRequest(url + path);
		req.body(MediaType.APPLICATION_XML_TYPE, data);
		
		ClientResponse<T> res = req.post(clazz);
		T response = res.getEntity();
		res.releaseConnection();
		
		return response;
	}
}
