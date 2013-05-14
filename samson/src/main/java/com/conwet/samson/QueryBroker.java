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