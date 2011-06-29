
package org.bimserver.citygml.xbuilding;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RailingTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RailingTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HANDRAIL"/>
 *     &lt;enumeration value="GUARDRAIL"/>
 *     &lt;enumeration value="BALUSTRADE"/>
 *     &lt;enumeration value="USERDEFINED"/>
 *     &lt;enumeration value="NOTDEFINED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RailingTypeEnum")
@XmlEnum
public enum RailingTypeEnum {

    HANDRAIL,
    GUARDRAIL,
    BALUSTRADE,
    USERDEFINED,
    NOTDEFINED;

    public String value() {
        return name();
    }

    public static RailingTypeEnum fromValue(String v) {
        return valueOf(v);
    }

}
