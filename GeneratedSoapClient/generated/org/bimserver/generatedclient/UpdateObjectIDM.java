
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateObjectIDM complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateObjectIDM">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="objectIDM" type="{http://shared.bimserver.org/}sObjectIDM" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateObjectIDM", propOrder = {
    "objectIDM"
})
public class UpdateObjectIDM {

    protected SObjectIDM objectIDM;

    /**
     * Gets the value of the objectIDM property.
     * 
     * @return
     *     possible object is
     *     {@link SObjectIDM }
     *     
     */
    public SObjectIDM getObjectIDM() {
        return objectIDM;
    }

    /**
     * Sets the value of the objectIDM property.
     * 
     * @param value
     *     allowed object is
     *     {@link SObjectIDM }
     *     
     */
    public void setObjectIDM(SObjectIDM value) {
        this.objectIDM = value;
    }

}
