
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sServiceDescriptor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sServiceDescriptor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="identifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notificationProtocol" type="{org.bimserver}sAccessMethod" minOccurs="0"/>
 *         &lt;element name="providerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="readExtendedData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="readRevision" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trigger" type="{org.bimserver}sTrigger" minOccurs="0"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="writeExtendedData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="writeRevision" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sServiceDescriptor", propOrder = {
    "description",
    "identifier",
    "name",
    "notificationProtocol",
    "providerName",
    "readExtendedData",
    "readRevision",
    "token",
    "trigger",
    "url",
    "writeExtendedData",
    "writeRevision"
})
public class SServiceDescriptor {

    protected String description;
    protected String identifier;
    protected String name;
    protected SAccessMethod notificationProtocol;
    protected String providerName;
    protected String readExtendedData;
    protected boolean readRevision;
    protected String token;
    protected STrigger trigger;
    protected String url;
    protected String writeExtendedData;
    protected boolean writeRevision;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the identifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Sets the value of the identifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentifier(String value) {
        this.identifier = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the notificationProtocol property.
     * 
     * @return
     *     possible object is
     *     {@link SAccessMethod }
     *     
     */
    public SAccessMethod getNotificationProtocol() {
        return notificationProtocol;
    }

    /**
     * Sets the value of the notificationProtocol property.
     * 
     * @param value
     *     allowed object is
     *     {@link SAccessMethod }
     *     
     */
    public void setNotificationProtocol(SAccessMethod value) {
        this.notificationProtocol = value;
    }

    /**
     * Gets the value of the providerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * Sets the value of the providerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProviderName(String value) {
        this.providerName = value;
    }

    /**
     * Gets the value of the readExtendedData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReadExtendedData() {
        return readExtendedData;
    }

    /**
     * Sets the value of the readExtendedData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReadExtendedData(String value) {
        this.readExtendedData = value;
    }

    /**
     * Gets the value of the readRevision property.
     * 
     */
    public boolean isReadRevision() {
        return readRevision;
    }

    /**
     * Sets the value of the readRevision property.
     * 
     */
    public void setReadRevision(boolean value) {
        this.readRevision = value;
    }

    /**
     * Gets the value of the token property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the value of the token property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * Gets the value of the trigger property.
     * 
     * @return
     *     possible object is
     *     {@link STrigger }
     *     
     */
    public STrigger getTrigger() {
        return trigger;
    }

    /**
     * Sets the value of the trigger property.
     * 
     * @param value
     *     allowed object is
     *     {@link STrigger }
     *     
     */
    public void setTrigger(STrigger value) {
        this.trigger = value;
    }

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the writeExtendedData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWriteExtendedData() {
        return writeExtendedData;
    }

    /**
     * Sets the value of the writeExtendedData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWriteExtendedData(String value) {
        this.writeExtendedData = value;
    }

    /**
     * Gets the value of the writeRevision property.
     * 
     */
    public boolean isWriteRevision() {
        return writeRevision;
    }

    /**
     * Sets the value of the writeRevision property.
     * 
     */
    public void setWriteRevision(boolean value) {
        this.writeRevision = value;
    }

}
