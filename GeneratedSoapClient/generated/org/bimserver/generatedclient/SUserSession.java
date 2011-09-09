
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for sUserSession complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sUserSession">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accessMethod" type="{http://shared.bimserver.org/}sAccessMethod" minOccurs="0"/>
 *         &lt;element name="activeSince" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="lastActive" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://shared.bimserver.org/}sUserType" minOccurs="0"/>
 *         &lt;element name="uoid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sUserSession", propOrder = {
    "accessMethod",
    "activeSince",
    "lastActive",
    "name",
    "type",
    "uoid",
    "username"
})
public class SUserSession {

    protected SAccessMethod accessMethod;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar activeSince;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastActive;
    protected String name;
    protected SUserType type;
    protected long uoid;
    protected String username;

    /**
     * Gets the value of the accessMethod property.
     * 
     * @return
     *     possible object is
     *     {@link SAccessMethod }
     *     
     */
    public SAccessMethod getAccessMethod() {
        return accessMethod;
    }

    /**
     * Sets the value of the accessMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link SAccessMethod }
     *     
     */
    public void setAccessMethod(SAccessMethod value) {
        this.accessMethod = value;
    }

    /**
     * Gets the value of the activeSince property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getActiveSince() {
        return activeSince;
    }

    /**
     * Sets the value of the activeSince property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setActiveSince(XMLGregorianCalendar value) {
        this.activeSince = value;
    }

    /**
     * Gets the value of the lastActive property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastActive() {
        return lastActive;
    }

    /**
     * Sets the value of the lastActive property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastActive(XMLGregorianCalendar value) {
        this.lastActive = value;
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
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link SUserType }
     *     
     */
    public SUserType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link SUserType }
     *     
     */
    public void setType(SUserType value) {
        this.type = value;
    }

    /**
     * Gets the value of the uoid property.
     * 
     */
    public long getUoid() {
        return uoid;
    }

    /**
     * Sets the value of the uoid property.
     * 
     */
    public void setUoid(long value) {
        this.uoid = value;
    }

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

}
