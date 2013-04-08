
package com.conwet.samson.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for contextRegistrationAttributeList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contextRegistrationAttributeList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contextRegistrationAttribute" type="{}contextRegistrationAttribute" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contextRegistrationAttributeList", propOrder = {
    "contextRegistrationAttribute"
})
public class ContextRegistrationAttributeList {

    protected List<ContextRegistrationAttribute> contextRegistrationAttribute;

    /**
     * Gets the value of the contextRegistrationAttribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contextRegistrationAttribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContextRegistrationAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContextRegistrationAttribute }
     * 
     * 
     */
    public List<ContextRegistrationAttribute> getContextRegistrationAttribute() {
        if (contextRegistrationAttribute == null) {
            contextRegistrationAttribute = new ArrayList<ContextRegistrationAttribute>();
        }
        return this.contextRegistrationAttribute;
    }

}
