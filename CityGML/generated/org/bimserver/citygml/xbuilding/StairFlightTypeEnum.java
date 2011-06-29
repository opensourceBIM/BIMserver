
package org.bimserver.citygml.xbuilding;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StairFlightTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StairFlightTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="STRAIGHT"/>
 *     &lt;enumeration value="WINDER"/>
 *     &lt;enumeration value="SPIRAL"/>
 *     &lt;enumeration value="CURVED"/>
 *     &lt;enumeration value="FREEFORM"/>
 *     &lt;enumeration value="USERDEFINED"/>
 *     &lt;enumeration value="NOTDEFINED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "StairFlightTypeEnum")
@XmlEnum
public enum StairFlightTypeEnum {

    STRAIGHT,
    WINDER,
    SPIRAL,
    CURVED,
    FREEFORM,
    USERDEFINED,
    NOTDEFINED;

    public String value() {
        return name();
    }

    public static StairFlightTypeEnum fromValue(String v) {
        return valueOf(v);
    }

}
