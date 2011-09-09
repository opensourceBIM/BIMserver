
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sCompareType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="sCompareType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ALL"/>
 *     &lt;enumeration value="ADD"/>
 *     &lt;enumeration value="MODIFY"/>
 *     &lt;enumeration value="DELETE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "sCompareType")
@XmlEnum
public enum SCompareType {

    ALL,
    ADD,
    MODIFY,
    DELETE;

    public String value() {
        return name();
    }

    public static SCompareType fromValue(String v) {
        return valueOf(v);
    }

}
