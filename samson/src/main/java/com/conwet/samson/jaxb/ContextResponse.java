
package com.conwet.samson.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for contextResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contextResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;sequence>
 *           &lt;element name="contextResponseList" type="{}contextResponseList"/>
 *         &lt;/sequence>
 *         &lt;sequence>
 *           &lt;element name="errorCode" type="{}statusCode"/>
 *         &lt;/sequence>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contextResponse", propOrder = {
    "contextResponseList",
    "errorCode"
})
public class ContextResponse {

    protected ContextResponseList contextResponseList;
    protected StatusCode errorCode;

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

    /**
     * Gets the value of the errorCode property.
     * 
     * @return
     *     possible object is
     *     {@link StatusCode }
     *     
     */
    public StatusCode getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the value of the errorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusCode }
     *     
     */
    public void setErrorCode(StatusCode value) {
        this.errorCode = value;
    }

}
