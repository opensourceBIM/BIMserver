
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for setSettingSmtpServer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="setSettingSmtpServer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="smtpServer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setSettingSmtpServer", propOrder = {
    "smtpServer"
})
public class SetSettingSmtpServer {

    protected String smtpServer;

    /**
     * Gets the value of the smtpServer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmtpServer() {
        return smtpServer;
    }

    /**
     * Sets the value of the smtpServer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmtpServer(String value) {
        this.smtpServer = value;
    }

}
