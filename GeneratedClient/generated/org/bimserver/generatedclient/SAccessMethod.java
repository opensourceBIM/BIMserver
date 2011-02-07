
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sAccessMethod.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="sAccessMethod">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SOAP"/>
 *     &lt;enumeration value="WEB_INTERFACE"/>
 *     &lt;enumeration value="INTERNAL"/>
 *     &lt;enumeration value="REST"/>
 *     &lt;enumeration value="SYNDICATION"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "sAccessMethod")
@XmlEnum
public enum SAccessMethod {

    SOAP,
    WEB_INTERFACE,
    INTERNAL,
    REST,
    SYNDICATION;

    public String value() {
        return name();
    }

    public static SAccessMethod fromValue(String v) {
        return valueOf(v);
    }

}
