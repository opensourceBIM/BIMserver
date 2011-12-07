
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sUserType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="sUserType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SYSTEM"/>
 *     &lt;enumeration value="ADMIN"/>
 *     &lt;enumeration value="USER"/>
 *     &lt;enumeration value="READ_ONLY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "sUserType")
@XmlEnum
public enum SUserType {

    SYSTEM,
    ADMIN,
    USER,
    READ_ONLY;

    public String value() {
        return name();
    }

    public static SUserType fromValue(String v) {
        return valueOf(v);
    }

}
