
package com.conwet.samson.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;


/**
 * <p>Java class for registerContextRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="registerContextRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contextRegistrationList" type="{}contextRegistrationList"/>
 *         &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}duration"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registerContextRequest", propOrder = {
    "contextRegistrationList",
    "duration"
})
public class RegisterContextRequest {

    @XmlElement(required = true)
    protected ContextRegistrationList contextRegistrationList;
    @XmlElement(required = true)
    protected Duration duration;

    /**
     * Gets the value of the contextRegistrationList property.
     * 
     * @return
     *     possible object is
     *     {@link ContextRegistrationList }
     *     
     */
    public ContextRegistrationList getContextRegistrationList() {
        return contextRegistrationList;
    }

    /**
     * Sets the value of the contextRegistrationList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContextRegistrationList }
     *     
     */
    public void setContextRegistrationList(ContextRegistrationList value) {
        this.contextRegistrationList = value;
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

}
