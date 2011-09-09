
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for setSettingHeaderAddition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="setSettingHeaderAddition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="headerAddition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setSettingHeaderAddition", propOrder = {
    "headerAddition"
})
public class SetSettingHeaderAddition {

    protected String headerAddition;

    /**
     * Gets the value of the headerAddition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeaderAddition() {
        return headerAddition;
    }

    /**
     * Sets the value of the headerAddition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeaderAddition(String value) {
        this.headerAddition = value;
    }

}
