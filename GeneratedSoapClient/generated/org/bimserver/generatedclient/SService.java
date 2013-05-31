
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sService complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sService">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="internalServiceId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notificationProtocol" type="{org.bimserver}sAccessMethod" minOccurs="0"/>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="profileDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="profileIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="profileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="profilePublic" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="projectId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="providerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="readExtendedDataId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="readRevision" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="rid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="serviceIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serviceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trigger" type="{org.bimserver}sTrigger" minOccurs="0"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="writeExtendedDataId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="writeRevisionId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sService", propOrder = {
    "description",
    "internalServiceId",
    "name",
    "notificationProtocol",
    "oid",
    "profileDescription",
    "profileIdentifier",
    "profileName",
    "profilePublic",
    "projectId",
    "providerName",
    "readExtendedDataId",
    "readRevision",
    "rid",
    "serviceIdentifier",
    "serviceName",
    "token",
    "trigger",
    "url",
    "userId",
    "writeExtendedDataId",
    "writeRevisionId"
})
public class SService {

    protected String description;
    protected long internalServiceId;
    protected String name;
    protected SAccessMethod notificationProtocol;
    protected long oid;
    protected String profileDescription;
    protected String profileIdentifier;
    protected String profileName;
    protected boolean profilePublic;
    protected long projectId;
    protected String providerName;
    protected long readExtendedDataId;
    protected boolean readRevision;
    protected int rid;
    protected String serviceIdentifier;
    protected String serviceName;
    protected String token;
    protected STrigger trigger;
    protected String url;
    protected long userId;
    protected long writeExtendedDataId;
    protected long writeRevisionId;

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
     * Gets the value of the internalServiceId property.
     * 
     */
    public long getInternalServiceId() {
        return internalServiceId;
    }

    /**
     * Sets the value of the internalServiceId property.
     * 
     */
    public void setInternalServiceId(long value) {
        this.internalServiceId = value;
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
     * Gets the value of the profileDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProfileDescription() {
        return profileDescription;
    }

    /**
     * Sets the value of the profileDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProfileDescription(String value) {
        this.profileDescription = value;
    }

    /**
     * Gets the value of the profileIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProfileIdentifier() {
        return profileIdentifier;
    }

    /**
     * Sets the value of the profileIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProfileIdentifier(String value) {
        this.profileIdentifier = value;
    }

    /**
     * Gets the value of the profileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProfileName() {
        return profileName;
    }

    /**
     * Sets the value of the profileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProfileName(String value) {
        this.profileName = value;
    }

    /**
     * Gets the value of the profilePublic property.
     * 
     */
    public boolean isProfilePublic() {
        return profilePublic;
    }

    /**
     * Sets the value of the profilePublic property.
     * 
     */
    public void setProfilePublic(boolean value) {
        this.profilePublic = value;
    }

    /**
     * Gets the value of the projectId property.
     * 
     */
    public long getProjectId() {
        return projectId;
    }

    /**
     * Sets the value of the projectId property.
     * 
     */
    public void setProjectId(long value) {
        this.projectId = value;
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
     * Gets the value of the readExtendedDataId property.
     * 
     */
    public long getReadExtendedDataId() {
        return readExtendedDataId;
    }

    /**
     * Sets the value of the readExtendedDataId property.
     * 
     */
    public void setReadExtendedDataId(long value) {
        this.readExtendedDataId = value;
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
     * Gets the value of the serviceIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceIdentifier() {
        return serviceIdentifier;
    }

    /**
     * Sets the value of the serviceIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceIdentifier(String value) {
        this.serviceIdentifier = value;
    }

    /**
     * Gets the value of the serviceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Sets the value of the serviceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceName(String value) {
        this.serviceName = value;
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
     * Gets the value of the userId property.
     * 
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     */
    public void setUserId(long value) {
        this.userId = value;
    }

    /**
     * Gets the value of the writeExtendedDataId property.
     * 
     */
    public long getWriteExtendedDataId() {
        return writeExtendedDataId;
    }

    /**
     * Sets the value of the writeExtendedDataId property.
     * 
     */
    public void setWriteExtendedDataId(long value) {
        this.writeExtendedDataId = value;
    }

    /**
     * Gets the value of the writeRevisionId property.
     * 
     */
    public long getWriteRevisionId() {
        return writeRevisionId;
    }

    /**
     * Sets the value of the writeRevisionId property.
     * 
     */
    public void setWriteRevisionId(long value) {
        this.writeRevisionId = value;
    }

}
