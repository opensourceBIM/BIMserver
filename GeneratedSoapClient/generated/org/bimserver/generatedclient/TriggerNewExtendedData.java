
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for triggerNewExtendedData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="triggerNewExtendedData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="edid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "triggerNewExtendedData", propOrder = {
    "edid"
})
public class TriggerNewExtendedData {

    protected Long edid;

    /**
     * Gets the value of the edid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getEdid() {
        return edid;
    }

    /**
     * Sets the value of the edid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setEdid(Long value) {
        this.edid = value;
    }

}
