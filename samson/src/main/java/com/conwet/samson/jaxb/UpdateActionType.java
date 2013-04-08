
package com.conwet.samson.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateActionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="updateActionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="APPEND"/>
 *     &lt;enumeration value="DELETE"/>
 *     &lt;enumeration value="UPDATE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "updateActionType")
@XmlEnum
public enum UpdateActionType {

    APPEND,
    DELETE,
    UPDATE;

    public String value() {
        return name();
    }

    public static UpdateActionType fromValue(String v) {
        return valueOf(v);
    }

}
