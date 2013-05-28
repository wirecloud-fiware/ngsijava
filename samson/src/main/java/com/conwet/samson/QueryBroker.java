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

import java.util.List;

import javax.xml.datatype.Duration;

import com.conwet.samson.jaxb.ContextElement;
import com.conwet.samson.jaxb.ContextRegistration;
import com.conwet.samson.jaxb.ContextResponse;
import com.conwet.samson.jaxb.EntityId;
import com.conwet.samson.jaxb.NotifyConditionType;
import com.conwet.samson.jaxb.RegisterContextResponse;
import com.conwet.samson.jaxb.SubscribeResponse;
import com.conwet.samson.jaxb.UpdateActionType;

/**
 * Interface to perform queries to the Context Broker.
 * 
 * @author sergio
 */
public interface QueryBroker {
	
	/**
	 * Returns a new instance of {@linkplain EntityId} initialized with the
	 * given values.
	 * 
	 * @param type      the EntityId type (e.g. VendingMachine) 
	 * @param id        the EntityID id (e.g. ven.*)
	 * @param isPattern true if the id must be use as a pattern, false otherwise
	 * @return the {@linkplain EntityId} object initialized 
	 */
	public EntityId newEntityId(String type, String id, boolean isPattern);
	
	/**
	 * Returns the {@linkplain ContextResponse} received from the context
	 * broker for the requested type and id.
	 * 
	 * @param entityId the {@linkplain EntityId} to query
	 * @return the {@linkplain ContextResponse} returned by the context broker
	 * @throws Exception if some errors occur when decoding the response
	 */
	public ContextResponse queryContext(EntityId entityId) throws Exception;
	
	/**
	 * Returns the {@linkplain ContextResponse} for the register operation.
	 * 
	 * @param cxtReg   the {@linkplain ContextRegistration} to register
	 * @param duration the registration {@linkplain Duration}
	 * @return the contextResponse received from context broker
	 * @throws Exception if some errors occur when decoding the response
	 */
	public RegisterContextResponse registerContext(ContextRegistration cxtReg, Duration duration) throws Exception;
	
	/**
	 * Returns the {@linkplain ContextResponse} for the register operation.
	 * 
	 * @param cxtElem the {@linkplain ContextElement} to update
	 * @param action  the {@linkplain UpdateActionType} to perform
	 * @return the contextResponse received from context broker
	 * @throws Exception if some errors occur when decoding the response
	 */
	public ContextResponse updateContext(ContextElement cxtElem, UpdateActionType action) throws Exception;
	
	/**
	 * Returns the {@linkplain SubscribeResponse} for the subscription operation.
	 * 
	 * @param idList    the list of {@linkplain EntityId} to subscribe to
	 * @param condList  the list of attribute to subscribe to monitor change
	 * @param reference the URI to send notifications
	 * @param duration  the {@linkplain Duration} of subscription
	 * @param type      the subscription {@linkplain NotifyConditionType}
	 * @return the {@linkplain SubscribeResponse} received from context broker
	 * @throws Exception if some errors occur when decoding the response
	 */
	public SubscribeResponse subscribe(List<EntityId> idList, List<String> condList,
										String reference, Duration duration,
										NotifyConditionType type) throws Exception;
	
	/**
	 * Returns the {@linkplain SubscribeResponse} for the subscription operation.
	 * 
	 * @param subscriptionID the subscriptionID returned from the subscription
	 * @param idList    the list of {@linkplain EntityId} to update the subscription
	 * @param attrList  the new list of attribute to subscribe (empty subscribe to all)
	 * @param duration  the new {@linkplain Duration} of subscription
	 * @param type      the new subscription {@linkplain NotifyConditionType}
	 * @return the {@linkplain SubscribeResponse} received from context broker
	 * @throws Exception if some errors occur when decoding the response
	 */
	public SubscribeResponse subscribeUpdate(String subscriptionID, List<EntityId> idList,
											List<String> attrList, Duration duration,
											NotifyConditionType type) throws Exception;
}