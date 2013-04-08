
package com.conwet.samson.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;


/**
 * <p>Java class for subscribeContext complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="subscribeContext">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="entityIdList" type="{}entityIdList"/>
 *         &lt;element name="attributeList" type="{}attributeList"/>
 *         &lt;element name="reference" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}duration"/>
 *         &lt;element name="notifyConditions" type="{}NotifyConditionList"/>
 *         &lt;element name="throttling" type="{http://www.w3.org/2001/XMLSchema}duration" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subscribeContext", propOrder = {
    "entityIdList",
    "attributeList",
    "reference",
    "duration",
    "notifyConditions",
    "throttling"
})
public class SubscribeContext {

    @XmlElement(required = true)
    protected EntityIdList entityIdList;
    @XmlElement(required = true)
    protected AttributeList attributeList;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String reference;
    @XmlElement(required = true)
    protected Duration duration;
    @XmlElement(required = true)
    protected NotifyConditionList notifyConditions;
    protected Duration throttling;

    /**
     * Gets the value of the entityIdList property.
     * 
     * @return
     *     possible object is
     *     {@link EntityIdList }
     *     
     */
    public EntityIdList getEntityIdList() {
        return entityIdList;
    }

    /**
     * Sets the value of the entityIdList property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityIdList }
     *     
     */
    public void setEntityIdList(EntityIdList value) {
        this.entityIdList = value;
    }

    /**
     * Gets the value of the attributeList property.
     * 
     * @return
     *     possible object is
     *     {@link AttributeList }
     *     
     */
    public AttributeList getAttributeList() {
        return attributeList;
    }

    /**
     * Sets the value of the attributeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttributeList }
     *     
     */
    public void setAttributeList(AttributeList value) {
        this.attributeList = value;
    }

    /**
     * Gets the value of the reference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference() {
        return reference;
    }

    /**
     * Sets the value of the reference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference(String value) {
        this.reference = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setDuration(Duration value) {
        this.duration = value;
    }

    /**
     * Gets the value of the notifyConditions property.
     * 
     * @return
     *     possible object is
     *     {@link NotifyConditionList }
     *     
     */
    public NotifyConditionList getNotifyConditions() {
        return notifyConditions;
    }

    /**
     * Sets the value of the notifyConditions property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotifyConditionList }
     *     
     */
    public void setNotifyConditions(NotifyConditionList value) {
        this.notifyConditions = value;
    }

    /**
     * Gets the value of the throttling property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getThrottling() {
        return throttling;
    }

    /**
     * Sets the value of the throttling property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setThrottling(Duration value) {
        this.throttling = value;
    }

}
