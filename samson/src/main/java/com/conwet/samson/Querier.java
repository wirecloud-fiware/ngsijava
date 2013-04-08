
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
	
	/**
	 * Construct a {@linkplain Querier} object to query the context broker
	 * at the specified address.
	 * 
	 * @param host the hostname where the context broker is running
	 * @param port the port used by the context broker, must be greater than zero
	 */
	public Querier(String host, int port) {
		
		Objects.requireNonNull(host, "Hostname is null");
		
		if (port <= 0) {

			throw new IllegalArgumentException("port must be positive: port=" + port);
		}
		
		this.url = "http://" + host + ":" + port;
	}
	
	@Override
	public EntityId newEntityId(String type, String id) {
		
		EntityId entityID = new EntityId();
		entityID.setType(type);
		entityID.setId(id);
		entityID.setIsPattern(Boolean.FALSE);
		
		return entityID;
	}
	
	@Override
	public ContextResponse queryContext(EntityId entityId) throws Exception {
		
		EntityIdList list = new EntityIdList();
		list.getEntityId().add(entityId);
		
		QueryContextRequest request = new QueryContextRequest();
		request.setEntityIdList(list);
		
		return response(QUERY, request, ContextResponse.class);
	}
	
	@Override
	public RegisterContextResponse registerContext(ContextRegistration cxtReg, Duration duration) throws Exception {
		
		ContextRegistrationList list = new ContextRegistrationList();
		list.getContextRegistration().add(cxtReg);
		
		RegisterContextRequest request = new RegisterContextRequest();
		request.setContextRegistrationList(list);
		request.setDuration(duration);
		
		return response(REGISTER, request, RegisterContextResponse.class);
	}
	
	@Override
	public ContextResponse updateContext(ContextElement cxtElem, UpdateActionType action) throws Exception {
		
		ContextElementList list = new ContextElementList();
		list.getContextElement().add(cxtElem);
		
		UpdateContextRequest request = new UpdateContextRequest();
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
