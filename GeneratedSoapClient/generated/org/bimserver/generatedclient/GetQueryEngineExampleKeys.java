
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getQueryEngineExampleKeys complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getQueryEngineExampleKeys">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="qeid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getQueryEngineExampleKeys", propOrder = {
    "qeid"
})
public class GetQueryEngineExampleKeys {

    protected Long qeid;

    /**
     * Gets the value of the qeid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getQeid() {
        return qeid;
    }

    /**
     * Sets the value of the qeid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setQeid(Long value) {
        this.qeid = value;
    }

}
