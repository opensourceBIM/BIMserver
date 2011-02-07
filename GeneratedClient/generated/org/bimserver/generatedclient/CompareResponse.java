
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for compareResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="compareResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://shared.bimserver.org/}sCompareResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "compareResponse", propOrder = {
    "_return"
})
public class CompareResponse {

    @XmlElement(name = "return")
    protected SCompareResult _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link SCompareResult }
     *     
     */
    public SCompareResult getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link SCompareResult }
     *     
     */
    public void setReturn(SCompareResult value) {
        this._return = value;
    }

}
