
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServerException complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServerException">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="errorCode" type="{org.buildingsmart.bimsie1}errorCode"/>
 *         &lt;element name="userMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fullMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServerException", namespace = "bimserver", propOrder = {
    "errorCode",
    "userMessage",
    "fullMessage"
})
public class ServerException {

    @XmlElement(required = true, nillable = true)
    protected ErrorCode errorCode;
    @XmlElement(required = true, nillable = true)
    protected String userMessage;
    @XmlElement(required = true, nillable = true)
    protected String fullMessage;

    /**
     * Gets the value of the errorCode property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorCode }
     *     
     */
    public ErrorCode getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the value of the errorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorCode }
     *     
     */
    public void setErrorCode(ErrorCode value) {
        this.errorCode = value;
    }

    /**
     * Gets the value of the userMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserMessage() {
        return userMessage;
    }

    /**
     * Sets the value of the userMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserMessage(String value) {
        this.userMessage = value;
    }

    /**
     * Gets the value of the fullMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullMessage() {
        return fullMessage;
    }

    /**
     * Sets the value of the fullMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullMessage(String value) {
        this.fullMessage = value;
    }

}
