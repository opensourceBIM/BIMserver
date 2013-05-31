
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addLocalServiceToProject complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addLocalServiceToProject">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="poid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element ref="{org.bimserver}sService" minOccurs="0"/>
 *         &lt;element name="internalServiceOid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addLocalServiceToProject", propOrder = {
    "poid",
    "sService",
    "internalServiceOid"
})
public class AddLocalServiceToProject {

    protected Long poid;
    @XmlElement(namespace = "org.bimserver")
    protected SService sService;
    protected Long internalServiceOid;

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

    /**
     * Gets the value of the sService property.
     * 
     * @return
     *     possible object is
     *     {@link SService }
     *     
     */
    public SService getSService() {
        return sService;
    }

    /**
     * Sets the value of the sService property.
     * 
     * @param value
     *     allowed object is
     *     {@link SService }
     *     
     */
    public void setSService(SService value) {
        this.sService = value;
    }

    /**
     * Gets the value of the internalServiceOid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInternalServiceOid() {
        return internalServiceOid;
    }

    /**
     * Sets the value of the internalServiceOid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInternalServiceOid(Long value) {
        this.internalServiceOid = value;
    }

}
