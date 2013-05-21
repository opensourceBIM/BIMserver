
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sTrigger.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="sTrigger">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NEW_REVISION"/>
 *     &lt;enumeration value="NEW_PROJECT"/>
 *     &lt;enumeration value="NEW_EXTENDED_DATA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "sTrigger")
@XmlEnum
public enum STrigger {

    NEW_REVISION,
    NEW_PROJECT,
    NEW_EXTENDED_DATA;

    public String value() {
        return name();
    }

    public static STrigger fromValue(String v) {
        return valueOf(v);
    }

}
