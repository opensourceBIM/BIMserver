
package org.bimserver.citygml.xbuilding;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoofTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoofTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FLAT_ROOF"/>
 *     &lt;enumeration value="SHED_ROOF"/>
 *     &lt;enumeration value="GABLE_ROOF"/>
 *     &lt;enumeration value="HIP_ROOF"/>
 *     &lt;enumeration value="HIPPED_GABLE_ROOF"/>
 *     &lt;enumeration value="GAMBREL_ROOF"/>
 *     &lt;enumeration value="MANSARD_ROOF"/>
 *     &lt;enumeration value="BARREL_ROOF"/>
 *     &lt;enumeration value="RAINBOW_ROOF"/>
 *     &lt;enumeration value="BUTTERFLY_ROOF"/>
 *     &lt;enumeration value="PAVILION_ROOF"/>
 *     &lt;enumeration value="DOME_ROOF"/>
 *     &lt;enumeration value="FREEFORM"/>
 *     &lt;enumeration value="NOTDEFINED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoofTypeEnum")
@XmlEnum
public enum RoofTypeEnum {

    @XmlEnumValue("FLAT_ROOF")
    FLAT___ROOF("FLAT_ROOF"),
    @XmlEnumValue("SHED_ROOF")
    SHED___ROOF("SHED_ROOF"),
    @XmlEnumValue("GABLE_ROOF")
    GABLE___ROOF("GABLE_ROOF"),
    @XmlEnumValue("HIP_ROOF")
    HIP___ROOF("HIP_ROOF"),
    @XmlEnumValue("HIPPED_GABLE_ROOF")
    HIPPED___GABLE___ROOF("HIPPED_GABLE_ROOF"),
    @XmlEnumValue("GAMBREL_ROOF")
    GAMBREL___ROOF("GAMBREL_ROOF"),
    @XmlEnumValue("MANSARD_ROOF")
    MANSARD___ROOF("MANSARD_ROOF"),
    @XmlEnumValue("BARREL_ROOF")
    BARREL___ROOF("BARREL_ROOF"),
    @XmlEnumValue("RAINBOW_ROOF")
    RAINBOW___ROOF("RAINBOW_ROOF"),
    @XmlEnumValue("BUTTERFLY_ROOF")
    BUTTERFLY___ROOF("BUTTERFLY_ROOF"),
    @XmlEnumValue("PAVILION_ROOF")
    PAVILION___ROOF("PAVILION_ROOF"),
    @XmlEnumValue("DOME_ROOF")
    DOME___ROOF("DOME_ROOF"),
    FREEFORM("FREEFORM"),
    NOTDEFINED("NOTDEFINED");
    private final String value;

    RoofTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RoofTypeEnum fromValue(String v) {
        for (RoofTypeEnum c: RoofTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
