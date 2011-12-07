
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateDeserializer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateDeserializer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deserializer" type="{http://shared.bimserver.org/}sDeserializer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateDeserializer", propOrder = {
    "deserializer"
})
public class UpdateDeserializer {

    protected SDeserializer deserializer;

    /**
     * Gets the value of the deserializer property.
     * 
     * @return
     *     possible object is
     *     {@link SDeserializer }
     *     
     */
    public SDeserializer getDeserializer() {
        return deserializer;
    }

    /**
     * Sets the value of the deserializer property.
     * 
     * @param value
     *     allowed object is
     *     {@link SDeserializer }
     *     
     */
    public void setDeserializer(SDeserializer value) {
        this.deserializer = value;
    }

}
