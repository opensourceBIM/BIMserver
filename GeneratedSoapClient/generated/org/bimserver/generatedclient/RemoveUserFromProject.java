
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for removeUserFromProject complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="removeUserFromProject">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="uoid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="poid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "removeUserFromProject", propOrder = {
    "uoid",
    "poid"
})
public class RemoveUserFromProject {

    protected Long uoid;
    protected Long poid;

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
     * Gets the value of the poid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPoid() {
        return poid;
    }

    /**
     * Sets the value of the poid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPoid(Long value) {
        this.poid = value;
    }

}
