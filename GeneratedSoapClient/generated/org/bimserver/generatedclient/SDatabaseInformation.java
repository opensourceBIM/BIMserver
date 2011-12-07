
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
 * <p>Java class for sDatabaseInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sDatabaseInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="categories" type="{http://shared.bimserver.org/}sDatabaseInformationCategory" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="created" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="databaseSizeInBytes" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numberOfCheckouts" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numberOfProjects" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numberOfRevisions" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numberOfUsers" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="schemaVersion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sDatabaseInformation", propOrder = {
    "categories",
    "created",
    "databaseSizeInBytes",
    "location",
    "numberOfCheckouts",
    "numberOfProjects",
    "numberOfRevisions",
    "numberOfUsers",
    "oid",
    "schemaVersion",
    "type"
})
public class SDatabaseInformation {

    @XmlElement(nillable = true)
    protected List<SDatabaseInformationCategory> categories;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar created;
    protected long databaseSizeInBytes;
    protected String location;
    protected int numberOfCheckouts;
    protected int numberOfProjects;
    protected int numberOfRevisions;
    protected int numberOfUsers;
    protected long oid;
    protected int schemaVersion;
    protected String type;

    /**
     * Gets the value of the categories property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the categories property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategories().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SDatabaseInformationCategory }
     * 
     * 
     */
    public List<SDatabaseInformationCategory> getCategories() {
        if (categories == null) {
            categories = new ArrayList<SDatabaseInformationCategory>();
        }
        return this.categories;
    }

    /**
     * Gets the value of the created property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreated() {
        return created;
    }

    /**
     * Sets the value of the created property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreated(XMLGregorianCalendar value) {
        this.created = value;
    }

    /**
     * Gets the value of the databaseSizeInBytes property.
     * 
     */
    public long getDatabaseSizeInBytes() {
        return databaseSizeInBytes;
    }

    /**
     * Sets the value of the databaseSizeInBytes property.
     * 
     */
    public void setDatabaseSizeInBytes(long value) {
        this.databaseSizeInBytes = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Gets the value of the numberOfCheckouts property.
     * 
     */
    public int getNumberOfCheckouts() {
        return numberOfCheckouts;
    }

    /**
     * Sets the value of the numberOfCheckouts property.
     * 
     */
    public void setNumberOfCheckouts(int value) {
        this.numberOfCheckouts = value;
    }

    /**
     * Gets the value of the numberOfProjects property.
     * 
     */
    public int getNumberOfProjects() {
        return numberOfProjects;
    }

    /**
     * Sets the value of the numberOfProjects property.
     * 
     */
    public void setNumberOfProjects(int value) {
        this.numberOfProjects = value;
    }

    /**
     * Gets the value of the numberOfRevisions property.
     * 
     */
    public int getNumberOfRevisions() {
        return numberOfRevisions;
    }

    /**
     * Sets the value of the numberOfRevisions property.
     * 
     */
    public void setNumberOfRevisions(int value) {
        this.numberOfRevisions = value;
    }

    /**
     * Gets the value of the numberOfUsers property.
     * 
     */
    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    /**
     * Sets the value of the numberOfUsers property.
     * 
     */
    public void setNumberOfUsers(int value) {
        this.numberOfUsers = value;
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
     * Gets the value of the schemaVersion property.
     * 
     */
    public int getSchemaVersion() {
        return schemaVersion;
    }

    /**
     * Sets the value of the schemaVersion property.
     * 
     */
    public void setSchemaVersion(int value) {
        this.schemaVersion = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}
