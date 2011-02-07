
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for resultType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="resultType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CITYGML"/>
 *     &lt;enumeration value="COLLADA"/>
 *     &lt;enumeration value="IFC"/>
 *     &lt;enumeration value="IFCXML"/>
 *     &lt;enumeration value="O3D_JSON"/>
 *     &lt;enumeration value="OBJECT_INFO"/>
 *     &lt;enumeration value="TEXT"/>
 *     &lt;enumeration value="KML"/>
 *     &lt;enumeration value="KMZ"/>
 *     &lt;enumeration value="COBIE2"/>
 *     &lt;enumeration value="REPORT_SPACES"/>
 *     &lt;enumeration value="REPORT_TYPES"/>
 *     &lt;enumeration value="REPORT_COMPONENTS"/>
 *     &lt;enumeration value="REPORT_SYSTEMS"/>
 *     &lt;enumeration value="REPORT_ZONES"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "resultType")
@XmlEnum
public enum ResultType {

    CITYGML("CITYGML"),
    COLLADA("COLLADA"),
    IFC("IFC"),
    IFCXML("IFCXML"),
    @XmlEnumValue("O3D_JSON")
    O_3_D_JSON("O3D_JSON"),
    OBJECT_INFO("OBJECT_INFO"),
    TEXT("TEXT"),
    KML("KML"),
    KMZ("KMZ"),
    @XmlEnumValue("COBIE2")
    COBIE_2("COBIE2"),
    REPORT_SPACES("REPORT_SPACES"),
    REPORT_TYPES("REPORT_TYPES"),
    REPORT_COMPONENTS("REPORT_COMPONENTS"),
    REPORT_SYSTEMS("REPORT_SYSTEMS"),
    REPORT_ZONES("REPORT_ZONES");
    private final String value;

    ResultType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ResultType fromValue(String v) {
        for (ResultType c: ResultType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
