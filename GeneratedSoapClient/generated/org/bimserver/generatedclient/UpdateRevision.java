
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateRevision complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateRevision">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://shared.bimserver.org/}sRevision" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateRevision", propOrder = {
    "sRevision"
})
public class UpdateRevision {

    @XmlElement(namespace = "http://shared.bimserver.org/")
    protected SRevision sRevision;

    /**
     * Gets the value of the sRevision property.
     * 
     * @return
     *     possible object is
     *     {@link SRevision }
     *     
     */
    public SRevision getSRevision() {
        return sRevision;
    }

    /**
     * Sets the value of the sRevision property.
     * 
     * @param value
     *     allowed object is
     *     {@link SRevision }
     *     
     */
    public void setSRevision(SRevision value) {
        this.sRevision = value;
    }

}
