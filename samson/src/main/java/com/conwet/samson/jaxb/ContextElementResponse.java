
package com.conwet.samson.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for contextElementResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contextElementResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contextElement" type="{}contextElement" minOccurs="0"/>
 *         &lt;element name="statusCode" type="{}statusCode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contextElementResponse", propOrder = {
    "contextElement",
    "statusCode"
})
public class ContextElementResponse {

    protected ContextElement contextElement;
    protected StatusCode statusCode;

    /**
     * Gets the value of the contextElement property.
     * 
     * @return
     *     possible object is
     *     {@link ContextElement }
     *     
     */
    public ContextElement getContextElement() {
        return contextElement;
    }

    /**
     * Sets the value of the contextElement property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContextElement }
     *     
     */
    public void setContextElement(ContextElement value) {
        this.contextElement = value;
    }

    /**
     * Gets the value of the statusCode property.
     * 
     * @return
     *     possible object is
     *     {@link StatusCode }
     *     
     */
    public StatusCode getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the value of the statusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusCode }
     *     
     */
    public void setStatusCode(StatusCode value) {
        this.statusCode = value;
    }

}
