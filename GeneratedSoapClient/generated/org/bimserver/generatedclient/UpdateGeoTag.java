
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateGeoTag complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateGeoTag">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://shared.bimserver.org/}sGeoTag" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateGeoTag", propOrder = {
    "sGeoTag"
})
public class UpdateGeoTag {

    @XmlElement(namespace = "http://shared.bimserver.org/")
    protected SGeoTag sGeoTag;

    /**
     * Gets the value of the sGeoTag property.
     * 
     * @return
     *     possible object is
     *     {@link SGeoTag }
     *     
     */
    public SGeoTag getSGeoTag() {
        return sGeoTag;
    }

    /**
     * Sets the value of the sGeoTag property.
     * 
     * @param value
     *     allowed object is
     *     {@link SGeoTag }
     *     
     */
    public void setSGeoTag(SGeoTag value) {
        this.sGeoTag = value;
    }

}
