
package com.conwet.samson.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for notifyContext complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="notifyContext">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="subscriptionId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="originator" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="contextResponseList" type="{}contextResponseList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notifyContext", propOrder = {
    "subscriptionId",
    "originator",
    "contextResponseList"
})
public class NotifyContext {

    @XmlElement(required = true)
    protected String subscriptionId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String originator;
    @XmlElement(required = true)
    protected ContextResponseList contextResponseList;

    /**
     * Gets the value of the subscriptionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriptionId() {
        return subscriptionId;
    }

    /**
     * Sets the value of the subscriptionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriptionId(String value) {
        this.subscriptionId = value;
    }

    /**
     * Gets the value of the originator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginator() {
        return originator;
    }

    /**
     * Sets the value of the originator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginator(String value) {
        this.originator = value;
    }

    /**
     * Gets the value of the contextResponseList property.
     * 
     * @return
     *     possible object is
     *     {@link ContextResponseList }
     *     
     */
    public ContextResponseList getContextResponseList() {
        return contextResponseList;
    }

    /**
     * Sets the value of the contextResponseList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContextResponseList }
     *     
     */
    public void setContextResponseList(ContextResponseList value) {
        this.contextResponseList = value;
    }

}
