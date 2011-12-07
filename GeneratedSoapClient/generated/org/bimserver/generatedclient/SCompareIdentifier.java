
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sCompareIdentifier.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="sCompareIdentifier">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NAME_ID"/>
 *     &lt;enumeration value="GUID_ID"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "sCompareIdentifier")
@XmlEnum
public enum SCompareIdentifier {

    NAME_ID,
    GUID_ID;

    public String value() {
        return name();
    }

    public static SCompareIdentifier fromValue(String v) {
        return valueOf(v);
    }

}
