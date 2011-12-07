
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for findClashesByEid complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="findClashesByEid">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://shared.bimserver.org/}sClashDetectionSettings" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findClashesByEid", propOrder = {
    "sClashDetectionSettings"
})
public class FindClashesByEid {

    @XmlElement(namespace = "http://shared.bimserver.org/")
    protected SClashDetectionSettings sClashDetectionSettings;

    /**
     * Gets the value of the sClashDetectionSettings property.
     * 
     * @return
     *     possible object is
     *     {@link SClashDetectionSettings }
     *     
     */
    public SClashDetectionSettings getSClashDetectionSettings() {
        return sClashDetectionSettings;
    }

    /**
     * Sets the value of the sClashDetectionSettings property.
     * 
     * @param value
     *     allowed object is
     *     {@link SClashDetectionSettings }
     *     
     */
    public void setSClashDetectionSettings(SClashDetectionSettings value) {
        this.sClashDetectionSettings = value;
    }

}
