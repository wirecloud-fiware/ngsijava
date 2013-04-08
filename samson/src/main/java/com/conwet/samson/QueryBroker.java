package com.conwet.samson;

import javax.xml.datatype.Duration;

import com.conwet.samson.jaxb.ContextElement;
import com.conwet.samson.jaxb.ContextRegistration;
import com.conwet.samson.jaxb.ContextResponse;
import com.conwet.samson.jaxb.EntityId;
import com.conwet.samson.jaxb.RegisterContextResponse;
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
	 * @param type the EntityId type (e.g. VendingMachine) 
	 * @param id   the EntityID id (e.g. ven*)
	 * @return the {@linkplain EntityId} object initialized 
	 */
	public EntityId newEntityId(String type, String id);
	
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
}