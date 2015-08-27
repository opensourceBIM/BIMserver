
package org.bimserver.generatedclient;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for sUser complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sUser">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createdById" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="createdOn" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="extendedData" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="hasRightsOn" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="lastSeen" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="logs" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="passwordHash" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="passwordSalt" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="revisions" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="rid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="schemas" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="services" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="state" type="{org.bimserver}sObjectState" minOccurs="0"/>
 *         &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userSettingsId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="userType" type="{org.bimserver}sUserType" minOccurs="0"/>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="validationToken" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="validationTokenCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sUser", propOrder = {
    "createdById",
    "createdOn",
    "extendedData",
    "hasRightsOn",
    "lastSeen",
    "logs",
    "name",
    "oid",
    "passwordHash",
    "passwordSalt",
    "revisions",
    "rid",
    "schemas",
    "services",
    "state",
    "token",
    "userSettingsId",
    "userType",
    "username",
    "validationToken",
    "validationTokenCreated"
})
public class SUser {

    protected long createdById;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdOn;
    @XmlElement(nillable = true)
    protected List<Long> extendedData;
    @XmlElement(nillable = true)
    protected List<Long> hasRightsOn;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastSeen;
    @XmlElement(nillable = true)
    protected List<Long> logs;
    protected String name;
    protected long oid;
    protected byte[] passwordHash;
    protected byte[] passwordSalt;
    @XmlElement(nillable = true)
    protected List<Long> revisions;
    protected int rid;
    @XmlElement(nillable = true)
    protected List<Long> schemas;
    @XmlElement(nillable = true)
    protected List<Long> services;
    protected SObjectState state;
    protected String token;
    protected long userSettingsId;
    protected SUserType userType;
    protected String username;
    protected byte[] validationToken;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar validationTokenCreated;

    /**
     * Gets the value of the createdById property.
     * 
     */
    public long getCreatedById() {
        return createdById;
    }

    /**
     * Sets the value of the createdById property.
     * 
     */
    public void setCreatedById(long value) {
        this.createdById = value;
    }

    /**
     * Gets the value of the createdOn property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedOn() {
        return createdOn;
    }

    /**
     * Sets the value of the createdOn property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedOn(XMLGregorianCalendar value) {
        this.createdOn = value;
    }

    /**
     * Gets the value of the extendedData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extendedData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtendedData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getExtendedData() {
        if (extendedData == null) {
            extendedData = new ArrayList<Long>();
        }
        return this.extendedData;
    }

    /**
     * Gets the value of the hasRightsOn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hasRightsOn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHasRightsOn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getHasRightsOn() {
        if (hasRightsOn == null) {
            hasRightsOn = new ArrayList<Long>();
        }
        return this.hasRightsOn;
    }

    /**
     * Gets the value of the lastSeen property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastSeen() {
        return lastSeen;
    }

    /**
     * Sets the value of the lastSeen property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastSeen(XMLGregorianCalendar value) {
        this.lastSeen = value;
    }

    /**
     * Gets the value of the logs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getLogs() {
        if (logs == null) {
            logs = new ArrayList<Long>();
        }
        return this.logs;
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
     * Gets the value of the oid property.
     * 
     */
    public long getOid() {
        return oid;
    }

    /**
     * Sets the value of the oid property.
     * 
     */
    public void setOid(long value) {
        this.oid = value;
    }

    /**
     * Gets the value of the passwordHash property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getPasswordHash() {
        return passwordHash;
    }

    /**
     * Sets the value of the passwordHash property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setPasswordHash(byte[] value) {
        this.passwordHash = value;
    }

    /**
     * Gets the value of the passwordSalt property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getPasswordSalt() {
        return passwordSalt;
    }

    /**
     * Sets the value of the passwordSalt property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setPasswordSalt(byte[] value) {
        this.passwordSalt = value;
    }

    /**
     * Gets the value of the revisions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the revisions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRevisions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getRevisions() {
        if (revisions == null) {
            revisions = new ArrayList<Long>();
        }
        return this.revisions;
    }

    /**
     * Gets the value of the rid property.
     * 
     */
    public int getRid() {
        return rid;
    }

    /**
     * Sets the value of the rid property.
     * 
     */
    public void setRid(int value) {
        this.rid = value;
    }

    /**
     * Gets the value of the schemas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the schemas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSchemas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getSchemas() {
        if (schemas == null) {
            schemas = new ArrayList<Long>();
        }
        return this.schemas;
    }

    /**
     * Gets the value of the services property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the services property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServices().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getServices() {
        if (services == null) {
            services = new ArrayList<Long>();
        }
        return this.services;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link SObjectState }
     *     
     */
    public SObjectState getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link SObjectState }
     *     
     */
    public void setState(SObjectState value) {
        this.state = value;
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
     * Gets the value of the userSettingsId property.
     * 
     */
    public long getUserSettingsId() {
        return userSettingsId;
    }

    /**
     * Sets the value of the userSettingsId property.
     * 
     */
    public void setUserSettingsId(long value) {
        this.userSettingsId = value;
    }

    /**
     * Gets the value of the userType property.
     * 
     * @return
     *     possible object is
     *     {@link SUserType }
     *     
     */
    public SUserType getUserType() {
        return userType;
    }

    /**
     * Sets the value of the userType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SUserType }
     *     
     */
    public void setUserType(SUserType value) {
        this.userType = value;
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

    /**
     * Gets the value of the validationToken property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getValidationToken() {
        return validationToken;
    }

    /**
     * Sets the value of the validationToken property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setValidationToken(byte[] value) {
        this.validationToken = value;
    }

    /**
     * Gets the value of the validationTokenCreated property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidationTokenCreated() {
        return validationTokenCreated;
    }

    /**
     * Sets the value of the validationTokenCreated property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidationTokenCreated(XMLGregorianCalendar value) {
        this.validationTokenCreated = value;
    }

}
