
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sCheckinState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="sCheckinState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UPLOADING"/>
 *     &lt;enumeration value="PARSING"/>
 *     &lt;enumeration value="STORING"/>
 *     &lt;enumeration value="SEARCHING_CLASHES"/>
 *     &lt;enumeration value="DONE"/>
 *     &lt;enumeration value="ERROR"/>
 *     &lt;enumeration value="CLASHES_ERROR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "sCheckinState")
@XmlEnum
public enum SCheckinState {

    UPLOADING,
    PARSING,
    STORING,
    SEARCHING_CLASHES,
    DONE,
    ERROR,
    CLASHES_ERROR;

    public String value() {
        return name();
    }

    public static SCheckinState fromValue(String v) {
        return valueOf(v);
    }

}
