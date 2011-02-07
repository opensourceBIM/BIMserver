
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getClashDetectionSettings complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getClashDetectionSettings">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cdsoid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getClashDetectionSettings", propOrder = {
    "cdsoid"
})
public class GetClashDetectionSettings {

    protected long cdsoid;

    /**
     * Gets the value of the cdsoid property.
     * 
     */
    public long getCdsoid() {
        return cdsoid;
    }

    /**
     * Sets the value of the cdsoid property.
     * 
     */
    public void setCdsoid(long value) {
        this.cdsoid = value;
    }

}
