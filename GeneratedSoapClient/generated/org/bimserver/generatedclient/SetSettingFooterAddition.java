
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for setSettingFooterAddition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="setSettingFooterAddition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="footerAddition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setSettingFooterAddition", propOrder = {
    "footerAddition"
})
public class SetSettingFooterAddition {

    protected String footerAddition;

    /**
     * Gets the value of the footerAddition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFooterAddition() {
        return footerAddition;
    }

    /**
     * Sets the value of the footerAddition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFooterAddition(String value) {
        this.footerAddition = value;
    }

}
