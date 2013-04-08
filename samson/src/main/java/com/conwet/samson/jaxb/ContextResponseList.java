
package com.conwet.samson.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for contextResponseList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contextResponseList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contextElementResponse" type="{}contextElementResponse" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contextResponseList", propOrder = {
    "contextElementResponse"
})
public class ContextResponseList {

    protected List<ContextElementResponse> contextElementResponse;

    /**
     * Gets the value of the contextElementResponse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contextElementResponse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContextElementResponse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContextElementResponse }
     * 
     * 
     */
    public List<ContextElementResponse> getContextElementResponse() {
        if (contextElementResponse == null) {
            contextElementResponse = new ArrayList<ContextElementResponse>();
        }
        return this.contextElementResponse;
    }

}
