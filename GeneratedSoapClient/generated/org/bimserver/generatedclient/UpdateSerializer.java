
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateSerializer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateSerializer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serializer" type="{http://shared.bimserver.org/}sSerializer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateSerializer", propOrder = {
    "serializer"
})
public class UpdateSerializer {

    protected SSerializer serializer;

    /**
     * Gets the value of the serializer property.
     * 
     * @return
     *     possible object is
     *     {@link SSerializer }
     *     
     */
    public SSerializer getSerializer() {
        return serializer;
    }

    /**
     * Sets the value of the serializer property.
     * 
     * @param value
     *     allowed object is
     *     {@link SSerializer }
     *     
     */
    public void setSerializer(SSerializer value) {
        this.serializer = value;
    }

}
