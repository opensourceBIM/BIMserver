
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
 * <p>Java class for sRevision complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sRevision">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bmi" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="checkouts" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="concreteRevisions" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="laid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="lastClashes" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="lastConcreteRevisionId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="lastError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nrClashes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="projectId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="size" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="state" type="{http://shared.bimserver.org/}sCheckinState" minOccurs="0"/>
 *         &lt;element name="tag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sRevision", propOrder = {
    "bmi",
    "checkouts",
    "comment",
    "concreteRevisions",
    "date",
    "id",
    "laid",
    "lastClashes",
    "lastConcreteRevisionId",
    "lastError",
    "nrClashes",
    "oid",
    "projectId",
    "size",
    "state",
    "tag",
    "userId"
})
public class SRevision {

    protected int bmi;
    @XmlElement(nillable = true)
    protected List<Long> checkouts;
    protected String comment;
    @XmlElement(nillable = true)
    protected List<Long> concreteRevisions;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    protected int id;
    protected long laid;
    @XmlElement(nillable = true)
    protected List<Long> lastClashes;
    protected long lastConcreteRevisionId;
    protected String lastError;
    protected int nrClashes;
    protected long oid;
    protected long projectId;
    protected long size;
    protected SCheckinState state;
    protected String tag;
    protected long userId;

    /**
     * Gets the value of the bmi property.
     * 
     */
    public int getBmi() {
        return bmi;
    }

    /**
     * Sets the value of the bmi property.
     * 
     */
    public void setBmi(int value) {
        this.bmi = value;
    }

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
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
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
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
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
     * Gets the value of the laid property.
     * 
     */
    public long getLaid() {
        return laid;
    }

    /**
     * Sets the value of the laid property.
     * 
     */
    public void setLaid(long value) {
        this.laid = value;
    }

    /**
     * Gets the value of the lastClashes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lastClashes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLastClashes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getLastClashes() {
        if (lastClashes == null) {
            lastClashes = new ArrayList<Long>();
        }
        return this.lastClashes;
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
     * Gets the value of the lastError property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastError() {
        return lastError;
    }

    /**
     * Sets the value of the lastError property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastError(String value) {
        this.lastError = value;
    }

    /**
     * Gets the value of the nrClashes property.
     * 
     */
    public int getNrClashes() {
        return nrClashes;
    }

    /**
     * Sets the value of the nrClashes property.
     * 
     */
    public void setNrClashes(int value) {
        this.nrClashes = value;
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
     * Gets the value of the size property.
     * 
     */
    public long getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     * 
     */
    public void setSize(long value) {
        this.size = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link SCheckinState }
     *     
     */
    public SCheckinState getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link SCheckinState }
     *     
     */
    public void setState(SCheckinState value) {
        this.state = value;
    }

    /**
     * Gets the value of the tag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTag() {
        return tag;
    }

    /**
     * Sets the value of the tag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTag(String value) {
        this.tag = value;
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

}
