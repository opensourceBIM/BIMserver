
package org.bimserver.citygml.xbuilding;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StairTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StairTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="STRAIGHT_RUN_STAIR"/>
 *     &lt;enumeration value="TWO_STRAIGHT_RUN_STAIR"/>
 *     &lt;enumeration value="QUARTER_WINDING_STAIR"/>
 *     &lt;enumeration value="QUARTER_TURN_STAIR"/>
 *     &lt;enumeration value="HALF_TURN_STAIR"/>
 *     &lt;enumeration value="TWO_QUARTER_WINDING_STAIR"/>
 *     &lt;enumeration value="TWO_QUARTER_TURN_STAIR"/>
 *     &lt;enumeration value="THREE_QUARTER_WINDING_STAIR"/>
 *     &lt;enumeration value="THREE_QUARTER_TURN_STAIR"/>
 *     &lt;enumeration value="SPIRAL_STAIR"/>
 *     &lt;enumeration value="DOUBLE_RETURN_STAIR"/>
 *     &lt;enumeration value="CURVED_RUN_STAIR"/>
 *     &lt;enumeration value="TWO_CURVED_RUN_STAIR"/>
 *     &lt;enumeration value="USERDEFINED"/>
 *     &lt;enumeration value="NOTDEFINED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "StairTypeEnum")
@XmlEnum
public enum StairTypeEnum {

    @XmlEnumValue("STRAIGHT_RUN_STAIR")
    STRAIGHT___RUN___STAIR("STRAIGHT_RUN_STAIR"),
    @XmlEnumValue("TWO_STRAIGHT_RUN_STAIR")
    TWO___STRAIGHT___RUN___STAIR("TWO_STRAIGHT_RUN_STAIR"),
    @XmlEnumValue("QUARTER_WINDING_STAIR")
    QUARTER___WINDING___STAIR("QUARTER_WINDING_STAIR"),
    @XmlEnumValue("QUARTER_TURN_STAIR")
    QUARTER___TURN___STAIR("QUARTER_TURN_STAIR"),
    @XmlEnumValue("HALF_TURN_STAIR")
    HALF___TURN___STAIR("HALF_TURN_STAIR"),
    @XmlEnumValue("TWO_QUARTER_WINDING_STAIR")
    TWO___QUARTER___WINDING___STAIR("TWO_QUARTER_WINDING_STAIR"),
    @XmlEnumValue("TWO_QUARTER_TURN_STAIR")
    TWO___QUARTER___TURN___STAIR("TWO_QUARTER_TURN_STAIR"),
    @XmlEnumValue("THREE_QUARTER_WINDING_STAIR")
    THREE___QUARTER___WINDING___STAIR("THREE_QUARTER_WINDING_STAIR"),
    @XmlEnumValue("THREE_QUARTER_TURN_STAIR")
    THREE___QUARTER___TURN___STAIR("THREE_QUARTER_TURN_STAIR"),
    @XmlEnumValue("SPIRAL_STAIR")
    SPIRAL___STAIR("SPIRAL_STAIR"),
    @XmlEnumValue("DOUBLE_RETURN_STAIR")
    DOUBLE___RETURN___STAIR("DOUBLE_RETURN_STAIR"),
    @XmlEnumValue("CURVED_RUN_STAIR")
    CURVED___RUN___STAIR("CURVED_RUN_STAIR"),
    @XmlEnumValue("TWO_CURVED_RUN_STAIR")
    TWO___CURVED___RUN___STAIR("TWO_CURVED_RUN_STAIR"),
    USERDEFINED("USERDEFINED"),
    NOTDEFINED("NOTDEFINED");
    private final String value;

    StairTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StairTypeEnum fromValue(String v) {
        for (StairTypeEnum c: StairTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
