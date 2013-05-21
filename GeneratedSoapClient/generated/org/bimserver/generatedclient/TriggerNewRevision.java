
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for triggerNewRevision complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="triggerNewRevision">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="roid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="soid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "triggerNewRevision", propOrder = {
    "roid",
    "soid"
})
public class TriggerNewRevision {

    protected Long roid;
    protected Long soid;

    /**
     * Gets the value of the roid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRoid() {
        return roid;
    }

    /**
     * Sets the value of the roid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRoid(Long value) {
        this.roid = value;
    }

    /**
     * Gets the value of the soid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSoid() {
        return soid;
    }

    /**
     * Sets the value of the soid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSoid(Long value) {
        this.soid = value;
    }

}
