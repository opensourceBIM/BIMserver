
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addUserToExtendedDataSchema complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addUserToExtendedDataSchema">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="uoid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="edsid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addUserToExtendedDataSchema", propOrder = {
    "uoid",
    "edsid"
})
public class AddUserToExtendedDataSchema {

    protected Long uoid;
    protected Long edsid;

    /**
     * Gets the value of the uoid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUoid() {
        return uoid;
    }

    /**
     * Sets the value of the uoid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUoid(Long value) {
        this.uoid = value;
    }

    /**
     * Gets the value of the edsid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getEdsid() {
        return edsid;
    }

    /**
     * Sets the value of the edsid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setEdsid(Long value) {
        this.edsid = value;
    }

}
