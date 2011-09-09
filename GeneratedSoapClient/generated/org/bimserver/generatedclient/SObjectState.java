
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sObjectState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="sObjectState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ACTIVE"/>
 *     &lt;enumeration value="DELETED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "sObjectState")
@XmlEnum
public enum SObjectState {

    ACTIVE,
    DELETED;

    public String value() {
        return name();
    }

    public static SObjectState fromValue(String v) {
        return valueOf(v);
    }

}
