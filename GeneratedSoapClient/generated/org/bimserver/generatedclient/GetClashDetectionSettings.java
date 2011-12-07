
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
 *         &lt;element name="cdsoid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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

    protected Long cdsoid;

    /**
     * Gets the value of the cdsoid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCdsoid() {
        return cdsoid;
    }

    /**
     * Sets the value of the cdsoid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCdsoid(Long value) {
        this.cdsoid = value;
    }

}
