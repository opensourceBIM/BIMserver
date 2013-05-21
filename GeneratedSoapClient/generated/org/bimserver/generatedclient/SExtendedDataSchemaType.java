
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sExtendedDataSchemaType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="sExtendedDataSchemaType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="XSD"/>
 *     &lt;enumeration value="PDF"/>
 *     &lt;enumeration value="TXT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "sExtendedDataSchemaType")
@XmlEnum
public enum SExtendedDataSchemaType {

    XSD,
    PDF,
    TXT;

    public String value() {
        return name();
    }

    public static SExtendedDataSchemaType fromValue(String v) {
        return valueOf(v);
    }

}
