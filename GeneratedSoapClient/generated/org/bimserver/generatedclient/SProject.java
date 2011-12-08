
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
 * <p>Java class for sProject complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sProject">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="checkouts" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="clashDetectionSettingsId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="concreteRevisions" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="createdById" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="createdDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="exportLengthMeasurePrefix" type="{http://shared.bimserver.org/}ssiPrefix" minOccurs="0"/>
 *         &lt;element name="geoTagId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="hasAuthorizedUsers" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lastConcreteRevisionId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="lastRevisionId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="parentId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="revisions" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="state" type="{http://shared.bimserver.org/}sObjectState" minOccurs="0"/>
 *         &lt;element name="subProjects" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sProject", propOrder = {
    "checkouts",
    "clashDetectionSettingsId",
    "concreteRevisions",
    "createdById",
    "createdDate",
    "description",
    "exportLengthMeasurePrefix",
    "geoTagId",
    "hasAuthorizedUsers",
    "id",
    "lastConcreteRevisionId",
    "lastRevisionId",
    "name",
    "oid",
    "parentId",
    "revisions",
    "state",
    "subProjects"
})
public class SProject {

    @XmlElement(nillable = true)
    protected List<Long> checkouts;
    protected long clashDetectionSettingsId;
    @XmlElement(nillable = true)
    protected List<Long> concreteRevisions;
    protected long createdById;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdDate;
    protected String description;
    protected SsiPrefix exportLengthMeasurePrefix;
    protected long geoTagId;
    @XmlElement(nillable = true)
    protected List<Long> hasAuthorizedUsers;
    protected int id;
    protected long lastConcreteRevisionId;
    protected long lastRevisionId;
    protected String name;
    protected long oid;
    protected long parentId;
    @XmlElement(nillable = true)
    protected List<Long> revisions;
    protected SObjectState state;
    @XmlElement(nillable = true)
    protected List<Long> subProjects;

    /**
     * Gets the value of the checkouts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the checkouts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCheckouts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getCheckouts() {
        if (checkouts == null) {
            checkouts = new ArrayList<Long>();
        }
        return this.checkouts;
    }

    /**
     * Gets the value of the clashDetectionSettingsId property.
     * 
     */
    public long getClashDetectionSettingsId() {
        return clashDetectionSettingsId;
    }

    /**
     * Sets the value of the clashDetectionSettingsId property.
     * 
     */
    public void setClashDetectionSettingsId(long value) {
        this.clashDetectionSettingsId = value;
    }

    /**
     * Gets the value of the concreteRevisions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the concreteRevisions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConcreteRevisions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getConcreteRevisions() {
        if (concreteRevisions == null) {
            concreteRevisions = new ArrayList<Long>();
        }
        return this.concreteRevisions;
    }

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
     * Gets the value of the createdDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets the value of the createdDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedDate(XMLGregorianCalendar value) {
        this.createdDate = value;
    }

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
     * Gets the value of the exportLengthMeasurePrefix property.
     * 
     * @return
     *     possible object is
     *     {@link SsiPrefix }
     *     
     */
    public SsiPrefix getExportLengthMeasurePrefix() {
        return exportLengthMeasurePrefix;
    }

    /**
     * Sets the value of the exportLengthMeasurePrefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link SsiPrefix }
     *     
     */
    public void setExportLengthMeasurePrefix(SsiPrefix value) {
        this.exportLengthMeasurePrefix = value;
    }

    /**
     * Gets the value of the geoTagId property.
     * 
     */
    public long getGeoTagId() {
        return geoTagId;
    }

    /**
     * Sets the value of the geoTagId property.
     * 
     */
    public void setGeoTagId(long value) {
        this.geoTagId = value;
    }

    /**
     * Gets the value of the hasAuthorizedUsers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hasAuthorizedUsers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHasAuthorizedUsers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getHasAuthorizedUsers() {
        if (hasAuthorizedUsers == null) {
            hasAuthorizedUsers = new ArrayList<Long>();
        }
        return this.hasAuthorizedUsers;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the lastConcreteRevisionId property.
     * 
     */
    public long getLastConcreteRevisionId() {
        return lastConcreteRevisionId;
    }

    /**
     * Sets the value of the lastConcreteRevisionId property.
     * 
     */
    public void setLastConcreteRevisionId(long value) {
        this.lastConcreteRevisionId = value;
    }

    /**
     * Gets the value of the lastRevisionId property.
     * 
     */
    public long getLastRevisionId() {
        return lastRevisionId;
    }

    /**
     * Sets the value of the lastRevisionId property.
     * 
     */
    public void setLastRevisionId(long value) {
        this.lastRevisionId = value;
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
     * Gets the value of the parentId property.
     * 
     */
    public long getParentId() {
        return parentId;
    }

    /**
     * Sets the value of the parentId property.
     * 
     */
    public void setParentId(long value) {
        this.parentId = value;
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
     * Gets the value of the subProjects property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subProjects property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubProjects().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getSubProjects() {
        if (subProjects == null) {
            subProjects = new ArrayList<Long>();
        }
        return this.subProjects;
    }

}
