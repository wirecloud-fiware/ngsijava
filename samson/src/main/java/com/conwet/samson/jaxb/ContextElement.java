
package com.conwet.samson.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for contextElement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contextElement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="entityId" type="{}entityId" minOccurs="0"/>
 *         &lt;element name="attributeDomainName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contextAttributeList" type="{}contextAttributeList"/>
 *         &lt;element name="domainMetadata" type="{}contextMetadata" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contextElement", propOrder = {
    "entityId",
    "attributeDomainName",
    "contextAttributeList",
    "domainMetadata"
})
public class ContextElement {

    protected EntityId entityId;
    protected String attributeDomainName;
    @XmlElement(required = true, nillable = true)
    protected ContextAttributeList contextAttributeList;
    @XmlElement(nillable = true)
    protected List<ContextMetadata> domainMetadata;

    /**
     * Gets the value of the entityId property.
     * 
     * @return
     *     possible object is
     *     {@link EntityId }
     *     
     */
    public EntityId getEntityId() {
        return entityId;
    }

    /**
     * Sets the value of the entityId property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityId }
     *     
     */
    public void setEntityId(EntityId value) {
        this.entityId = value;
    }

    /**
     * Gets the value of the attributeDomainName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttributeDomainName() {
        return attributeDomainName;
    }

    /**
     * Sets the value of the attributeDomainName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttributeDomainName(String value) {
        this.attributeDomainName = value;
    }

    /**
     * Gets the value of the contextAttributeList property.
     * 
     * @return
     *     possible object is
     *     {@link ContextAttributeList }
     *     
     */
    public ContextAttributeList getContextAttributeList() {
        return contextAttributeList;
    }

    /**
     * Sets the value of the contextAttributeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContextAttributeList }
     *     
     */
    public void setContextAttributeList(ContextAttributeList value) {
        this.contextAttributeList = value;
    }

    /**
     * Gets the value of the domainMetadata property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the domainMetadata property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDomainMetadata().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContextMetadata }
     * 
     * 
     */
    public List<ContextMetadata> getDomainMetadata() {
        if (domainMetadata == null) {
            domainMetadata = new ArrayList<ContextMetadata>();
        }
        return this.domainMetadata;
    }

}
