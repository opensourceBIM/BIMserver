
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getSuggestedDeserializerForExtensionResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getSuggestedDeserializerForExtensionResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{org.buildingsmart.bimsie1}sDeserializerPluginConfiguration" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getSuggestedDeserializerForExtensionResponse", propOrder = {
    "_return"
})
public class GetSuggestedDeserializerForExtensionResponse {

    @XmlElement(name = "return")
    protected SDeserializerPluginConfiguration _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link SDeserializerPluginConfiguration }
     *     
     */
    public SDeserializerPluginConfiguration getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link SDeserializerPluginConfiguration }
     *     
     */
    public void setReturn(SDeserializerPluginConfiguration value) {
        this._return = value;
    }

}
