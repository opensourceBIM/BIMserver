
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sServerState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="sServerState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UNDEFINED"/>
 *     &lt;enumeration value="NOT_SETUP"/>
 *     &lt;enumeration value="MIGRATION_REQUIRED"/>
 *     &lt;enumeration value="MIGRATION_IMPOSSIBLE"/>
 *     &lt;enumeration value="FATAL_ERROR"/>
 *     &lt;enumeration value="RUNNING"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "sServerState")
@XmlEnum
public enum SServerState {

    UNDEFINED,
    NOT_SETUP,
    MIGRATION_REQUIRED,
    MIGRATION_IMPOSSIBLE,
    FATAL_ERROR,
    RUNNING;

    public String value() {
        return name();
    }

    public static SServerState fromValue(String v) {
        return valueOf(v);
    }

}
