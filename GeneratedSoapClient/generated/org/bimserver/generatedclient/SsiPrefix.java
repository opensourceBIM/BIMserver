
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ssiPrefix.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ssiPrefix">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="meter"/>
 *     &lt;enumeration value="attometer"/>
 *     &lt;enumeration value="femtometer"/>
 *     &lt;enumeration value="picometer"/>
 *     &lt;enumeration value="nanometer"/>
 *     &lt;enumeration value="micrometer"/>
 *     &lt;enumeration value="millimeter"/>
 *     &lt;enumeration value="centimeter"/>
 *     &lt;enumeration value="decimeter"/>
 *     &lt;enumeration value="decameter"/>
 *     &lt;enumeration value="hectometer"/>
 *     &lt;enumeration value="kilometer"/>
 *     &lt;enumeration value="megameter"/>
 *     &lt;enumeration value="gigameter"/>
 *     &lt;enumeration value="terameter"/>
 *     &lt;enumeration value="petameter"/>
 *     &lt;enumeration value="exameter"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ssiPrefix")
@XmlEnum
public enum SsiPrefix {

    @XmlEnumValue("meter")
    METER("meter"),
    @XmlEnumValue("attometer")
    ATTOMETER("attometer"),
    @XmlEnumValue("femtometer")
    FEMTOMETER("femtometer"),
    @XmlEnumValue("picometer")
    PICOMETER("picometer"),
    @XmlEnumValue("nanometer")
    NANOMETER("nanometer"),
    @XmlEnumValue("micrometer")
    MICROMETER("micrometer"),
    @XmlEnumValue("millimeter")
    MILLIMETER("millimeter"),
    @XmlEnumValue("centimeter")
    CENTIMETER("centimeter"),
    @XmlEnumValue("decimeter")
    DECIMETER("decimeter"),
    @XmlEnumValue("decameter")
    DECAMETER("decameter"),
    @XmlEnumValue("hectometer")
    HECTOMETER("hectometer"),
    @XmlEnumValue("kilometer")
    KILOMETER("kilometer"),
    @XmlEnumValue("megameter")
    MEGAMETER("megameter"),
    @XmlEnumValue("gigameter")
    GIGAMETER("gigameter"),
    @XmlEnumValue("terameter")
    TERAMETER("terameter"),
    @XmlEnumValue("petameter")
    PETAMETER("petameter"),
    @XmlEnumValue("exameter")
    EXAMETER("exameter");
    private final String value;

    SsiPrefix(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SsiPrefix fromValue(String v) {
        for (SsiPrefix c: SsiPrefix.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
