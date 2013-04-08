
package com.conwet.samson.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for contextRegistration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contextRegistration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="entityIdList" type="{}entityIdList"/>
 *         &lt;element name="contextRegistrationAttributeList" type="{}contextRegistrationAttributeList"/>
 *         &lt;element name="providingApplication" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contextRegistration", propOrder = {
    "entityIdList",
    "contextRegistrationAttributeList",
    "providingApplication"
})
public class ContextRegistration {

    @XmlElement(required = true)
    protected EntityIdList entityIdList;
    @XmlElement(required = true)
    protected ContextRegistrationAttributeList contextRegistrationAttributeList;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String providingApplication;

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
     * Gets the value of the contextRegistrationAttributeList property.
     * 
     * @return
     *     possible object is
     *     {@link ContextRegistrationAttributeList }
     *     
     */
    public ContextRegistrationAttributeList getContextRegistrationAttributeList() {
        return contextRegistrationAttributeList;
    }

    /**
     * Sets the value of the contextRegistrationAttributeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContextRegistrationAttributeList }
     *     
     */
    public void setContextRegistrationAttributeList(ContextRegistrationAttributeList value) {
        this.contextRegistrationAttributeList = value;
    }

    /**
     * Gets the value of the providingApplication property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvidingApplication() {
        return providingApplication;
    }

    /**
     * Sets the value of the providingApplication property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvidingApplication(String value) {
        this.providingApplication = value;
    }

}
