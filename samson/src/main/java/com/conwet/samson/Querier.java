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

import java.util.List;
import java.util.Objects;

import javax.ws.rs.core.MediaType;
import javax.xml.datatype.Duration;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import com.conwet.samson.jaxb.BaseContextRequest;
import com.conwet.samson.jaxb.CondValueList;
import com.conwet.samson.jaxb.ContextElement;
import com.conwet.samson.jaxb.ContextElementList;
import com.conwet.samson.jaxb.ContextRegistration;
import com.conwet.samson.jaxb.ContextRegistrationList;
import com.conwet.samson.jaxb.ContextResponse;
import com.conwet.samson.jaxb.EntityId;
import com.conwet.samson.jaxb.EntityIdList;
import com.conwet.samson.jaxb.NotifyCondition;
import com.conwet.samson.jaxb.NotifyConditionList;
import com.conwet.samson.jaxb.NotifyConditionType;
import com.conwet.samson.jaxb.ObjectFactory;
import com.conwet.samson.jaxb.QueryContextRequest;
import com.conwet.samson.jaxb.RegisterContextRequest;
import com.conwet.samson.jaxb.RegisterContextResponse;
import com.conwet.samson.jaxb.SubscribeContextRequest;
import com.conwet.samson.jaxb.SubscribeContextResponse;
import com.conwet.samson.jaxb.SubscribeResponse;
import com.conwet.samson.jaxb.UpdateActionType;
import com.conwet.samson.jaxb.UpdateContextRequest;
import com.conwet.samson.jaxb.UpdateContextSubscriptionRequest;

/**
 * This class execute queries to Context Broker and unmarshal its XML response
 * into Java object.
 *
 * @author sergio
 */
public class Querier implements QueryBroker {
	
	private static final String QUERY = "/ngsi10/queryContext";
	private static final String REGISTER = "/ngsi9/registerContext";
	private static final String UPDATE = "/ngsi10/updateContext";
	private static final String SUBSCRIBE = "/ngsi10/subscribeContext";
	private static final String UNSUBSCRIBE = "/ngsi10/unsubscribeContext";
	private static final String UPDATE_SUBSCRIBE = "/ngsi10/updateContextSubscription";
	
	private static final String DISCOVER_AVAIL = "/ngsi9/discoverContextAvailability";
	private static final String SUBSCRIBE_AVAIL = "/ngsi9/subscribeContextAvailability";
	private static final String UNSUBSCRIBE_AVAIL = "/ngsi9/unsubscribeContextAvailability";
	private static final String UPDATE_AVAIL = "/ngsi9/updateContextAvailabilitySubscription";
	
	
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
	
	@Override
	public EntityId newEntityId(String type, String id, boolean isPattern) {
		
		EntityId entityID = factory.createEntityId();
		entityID.setType(type);
		entityID.setId(id);
		entityID.setIsPattern(isPattern);
		
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
	
	@Override
	public SubscribeResponse subscribe(List<EntityId> idList, List<String> condList,
									String reference, Duration duration,
									NotifyConditionType type) throws Exception {
		
		SubscribeContextRequest request = factory.createSubscribeContextRequest();
		request.setReference(reference);
		
		setSubscriberField(request, idList, condList, duration, type);
		
		return response(SUBSCRIBE, request, SubscribeContextResponse.class).getSubscribeResponse();
	}
	
	@Override
	public SubscribeResponse subscribeUpdate(String subscriptionID, List<EntityId> idList,
											List<String> attrList, Duration duration,
											NotifyConditionType type) throws Exception {
		
		UpdateContextSubscriptionRequest request = factory.createUpdateContextSubscriptionRequest();
		request.setSubscriptionId(Objects.requireNonNull(subscriptionID, "SubscriptionID is null"));
		
		setSubscriberField(request, idList, attrList, duration, type);
		
		return response(UPDATE_SUBSCRIBE, request, SubscribeContextResponse.class).getSubscribeResponse();
	}
	
	private void setSubscriberField(BaseContextRequest request, List<EntityId> idList,
									List<String> condList, Duration duration,
									NotifyConditionType type) {
		
		EntityIdList entityList = factory.createEntityIdList();
		
		for (EntityId entityId : idList) {
			
			entityList.getEntityId().add(entityId);
		}
		
		CondValueList cList = factory.createCondValueList();
		
		for (String attribute : condList) {
			
			cList.getCondValue().add(attribute);
		}
		
		NotifyCondition notifyCond = factory.createNotifyCondition();
		notifyCond.setType(Objects.requireNonNull(type, "type is null"));
		notifyCond.setCondValueList(cList);
		NotifyConditionList notList = factory.createNotifyConditionList();
		notList.getNotifyCondition().add(notifyCond);
		
		request.setEntityIdList(entityList);
		request.setAttributeList(factory.createAttributeList());
		request.setNotifyConditions(notList);
		request.setDuration(duration);
	}
}
