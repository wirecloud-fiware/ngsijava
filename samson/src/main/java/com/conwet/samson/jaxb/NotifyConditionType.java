
package com.conwet.samson.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NotifyConditionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NotifyConditionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ONTIMEINTERVAL"/>
 *     &lt;enumeration value="ONVALUE"/>
 *     &lt;enumeration value="ONCHANGE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NotifyConditionType")
@XmlEnum
public enum NotifyConditionType {

    ONTIMEINTERVAL,
    ONVALUE,
    ONCHANGE;

    public String value() {
        return name();
    }

    public static NotifyConditionType fromValue(String v) {
        return valueOf(v);
    }

}
