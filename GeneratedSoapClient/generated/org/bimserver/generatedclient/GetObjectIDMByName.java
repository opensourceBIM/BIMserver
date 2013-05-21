
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getObjectIDMByName complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getObjectIDMByName">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="objectIDMName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getObjectIDMByName", propOrder = {
    "objectIDMName"
})
public class GetObjectIDMByName {

    protected String objectIDMName;

    /**
     * Gets the value of the objectIDMName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjectIDMName() {
        return objectIDMName;
    }

    /**
     * Sets the value of the objectIDMName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjectIDMName(String value) {
        this.objectIDMName = value;
    }

}
