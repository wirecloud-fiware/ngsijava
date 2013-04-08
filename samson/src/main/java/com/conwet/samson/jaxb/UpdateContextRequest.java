
package com.conwet.samson.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateContextRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateContextRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contextElementList" type="{}contextElementList"/>
 *         &lt;element name="updateAction" type="{}updateActionType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateContextRequest", propOrder = {
    "contextElementList",
    "updateAction"
})
public class UpdateContextRequest {

    @XmlElement(required = true)
    protected ContextElementList contextElementList;
    @XmlElement(required = true)
    protected UpdateActionType updateAction;

    /**
     * Gets the value of the contextElementList property.
     * 
     * @return
     *     possible object is
     *     {@link ContextElementList }
     *     
     */
    public ContextElementList getContextElementList() {
        return contextElementList;
    }

    /**
     * Sets the value of the contextElementList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContextElementList }
     *     
     */
    public void setContextElementList(ContextElementList value) {
        this.contextElementList = value;
    }

    /**
     * Gets the value of the updateAction property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateActionType }
     *     
     */
    public UpdateActionType getUpdateAction() {
        return updateAction;
    }

    /**
     * Sets the value of the updateAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateActionType }
     *     
     */
    public void setUpdateAction(UpdateActionType value) {
        this.updateAction = value;
    }

}
