
package com.conwet.samson.jaxb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.conwet.samson.jaxb package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RegisterContextResponse_QNAME = new QName("", "registerContextResponse");
    private final static QName _QueryContextRequest_QNAME = new QName("", "queryContextRequest");
    private final static QName _RegisterContextRequest_QNAME = new QName("", "registerContextRequest");
    private final static QName _UpdateContextRequest_QNAME = new QName("", "updateContextRequest");
    private final static QName _SubscribeContextRequest_QNAME = new QName("", "subscribeContextRequest");
    private final static QName _NotifyContextRequest_QNAME = new QName("", "notifyContextRequest");
    private final static QName _UpdateContextResponse_QNAME = new QName("", "updateContextResponse");
    private final static QName _QueryContextResponse_QNAME = new QName("", "queryContextResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.conwet.samson.jaxb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RegisterContextResponse }
     * 
     */
    public RegisterContextResponse createRegisterContextResponse() {
        return new RegisterContextResponse();
    }

    /**
     * Create an instance of {@link QueryContextRequest }
     * 
     */
    public QueryContextRequest createQueryContextRequest() {
        return new QueryContextRequest();
    }

    /**
     * Create an instance of {@link RegisterContextRequest }
     * 
     */
    public RegisterContextRequest createRegisterContextRequest() {
        return new RegisterContextRequest();
    }

    /**
     * Create an instance of {@link UpdateContextRequest }
     * 
     */
    public UpdateContextRequest createUpdateContextRequest() {
        return new UpdateContextRequest();
    }

    /**
     * Create an instance of {@link SubscribeContext }
     * 
     */
    public SubscribeContext createSubscribeContext() {
        return new SubscribeContext();
    }

    /**
     * Create an instance of {@link NotifyContext }
     * 
     */
    public NotifyContext createNotifyContext() {
        return new NotifyContext();
    }

    /**
     * Create an instance of {@link ContextResponse }
     * 
     */
    public ContextResponse createContextResponse() {
        return new ContextResponse();
    }

    /**
     * Create an instance of {@link ContextElementList }
     * 
     */
    public ContextElementList createContextElementList() {
        return new ContextElementList();
    }

    /**
     * Create an instance of {@link NotifyCondition }
     * 
     */
    public NotifyCondition createNotifyCondition() {
        return new NotifyCondition();
    }

    /**
     * Create an instance of {@link ContextResponseList }
     * 
     */
    public ContextResponseList createContextResponseList() {
        return new ContextResponseList();
    }

    /**
     * Create an instance of {@link ContextAttributeList }
     * 
     */
    public ContextAttributeList createContextAttributeList() {
        return new ContextAttributeList();
    }

    /**
     * Create an instance of {@link EntityId }
     * 
     */
    public EntityId createEntityId() {
        return new EntityId();
    }

    /**
     * Create an instance of {@link ContextRegistrationAttribute }
     * 
     */
    public ContextRegistrationAttribute createContextRegistrationAttribute() {
        return new ContextRegistrationAttribute();
    }

    /**
     * Create an instance of {@link ContextMetadata }
     * 
     */
    public ContextMetadata createContextMetadata() {
        return new ContextMetadata();
    }

    /**
     * Create an instance of {@link StatusCode }
     * 
     */
    public StatusCode createStatusCode() {
        return new StatusCode();
    }

    /**
     * Create an instance of {@link CondValueList }
     * 
     */
    public CondValueList createCondValueList() {
        return new CondValueList();
    }

    /**
     * Create an instance of {@link ContextAttribute }
     * 
     */
    public ContextAttribute createContextAttribute() {
        return new ContextAttribute();
    }

    /**
     * Create an instance of {@link AttributeList }
     * 
     */
    public AttributeList createAttributeList() {
        return new AttributeList();
    }

    /**
     * Create an instance of {@link NotifyConditionList }
     * 
     */
    public NotifyConditionList createNotifyConditionList() {
        return new NotifyConditionList();
    }

    /**
     * Create an instance of {@link ContextElementResponse }
     * 
     */
    public ContextElementResponse createContextElementResponse() {
        return new ContextElementResponse();
    }

    /**
     * Create an instance of {@link EntityIdList }
     * 
     */
    public EntityIdList createEntityIdList() {
        return new EntityIdList();
    }

    /**
     * Create an instance of {@link ContextRegistrationAttributeList }
     * 
     */
    public ContextRegistrationAttributeList createContextRegistrationAttributeList() {
        return new ContextRegistrationAttributeList();
    }

    /**
     * Create an instance of {@link ContextElement }
     * 
     */
    public ContextElement createContextElement() {
        return new ContextElement();
    }

    /**
     * Create an instance of {@link ContextRegistration }
     * 
     */
    public ContextRegistration createContextRegistration() {
        return new ContextRegistration();
    }

    /**
     * Create an instance of {@link ContextRegistrationList }
     * 
     */
    public ContextRegistrationList createContextRegistrationList() {
        return new ContextRegistrationList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterContextResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "registerContextResponse")
    public JAXBElement<RegisterContextResponse> createRegisterContextResponse(RegisterContextResponse value) {
        return new JAXBElement<RegisterContextResponse>(_RegisterContextResponse_QNAME, RegisterContextResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryContextRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "queryContextRequest")
    public JAXBElement<QueryContextRequest> createQueryContextRequest(QueryContextRequest value) {
        return new JAXBElement<QueryContextRequest>(_QueryContextRequest_QNAME, QueryContextRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterContextRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "registerContextRequest")
    public JAXBElement<RegisterContextRequest> createRegisterContextRequest(RegisterContextRequest value) {
        return new JAXBElement<RegisterContextRequest>(_RegisterContextRequest_QNAME, RegisterContextRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateContextRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "updateContextRequest")
    public JAXBElement<UpdateContextRequest> createUpdateContextRequest(UpdateContextRequest value) {
        return new JAXBElement<UpdateContextRequest>(_UpdateContextRequest_QNAME, UpdateContextRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubscribeContext }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "subscribeContextRequest")
    public JAXBElement<SubscribeContext> createSubscribeContextRequest(SubscribeContext value) {
        return new JAXBElement<SubscribeContext>(_SubscribeContextRequest_QNAME, SubscribeContext.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotifyContext }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "notifyContextRequest")
    public JAXBElement<NotifyContext> createNotifyContextRequest(NotifyContext value) {
        return new JAXBElement<NotifyContext>(_NotifyContextRequest_QNAME, NotifyContext.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContextResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "updateContextResponse")
    public JAXBElement<ContextResponse> createUpdateContextResponse(ContextResponse value) {
        return new JAXBElement<ContextResponse>(_UpdateContextResponse_QNAME, ContextResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContextResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "queryContextResponse")
    public JAXBElement<ContextResponse> createQueryContextResponse(ContextResponse value) {
        return new JAXBElement<ContextResponse>(_QueryContextResponse_QNAME, ContextResponse.class, null, value);
    }

}
