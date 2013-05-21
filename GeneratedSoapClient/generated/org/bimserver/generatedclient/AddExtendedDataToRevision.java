
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addExtendedDataToRevision complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addExtendedDataToRevision">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="roid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="extendedData" type="{org.buildingsmart.bimsie}sExtendedData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addExtendedDataToRevision", propOrder = {
    "roid",
    "extendedData"
})
public class AddExtendedDataToRevision {

    protected Long roid;
    protected SExtendedData extendedData;

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
     * Gets the value of the extendedData property.
     * 
     * @return
     *     possible object is
     *     {@link SExtendedData }
     *     
     */
    public SExtendedData getExtendedData() {
        return extendedData;
    }

    /**
     * Sets the value of the extendedData property.
     * 
     * @param value
     *     allowed object is
     *     {@link SExtendedData }
     *     
     */
    public void setExtendedData(SExtendedData value) {
        this.extendedData = value;
    }

}
