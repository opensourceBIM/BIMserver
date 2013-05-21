
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addExtendedDataSchema complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addExtendedDataSchema">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="extendedDataSchema" type="{org.buildingsmart.bimsie}sExtendedDataSchema" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addExtendedDataSchema", propOrder = {
    "extendedDataSchema"
})
public class AddExtendedDataSchema {

    protected SExtendedDataSchema extendedDataSchema;

    /**
     * Gets the value of the extendedDataSchema property.
     * 
     * @return
     *     possible object is
     *     {@link SExtendedDataSchema }
     *     
     */
    public SExtendedDataSchema getExtendedDataSchema() {
        return extendedDataSchema;
    }

    /**
     * Sets the value of the extendedDataSchema property.
     * 
     * @param value
     *     allowed object is
     *     {@link SExtendedDataSchema }
     *     
     */
    public void setExtendedDataSchema(SExtendedDataSchema value) {
        this.extendedDataSchema = value;
    }

}
