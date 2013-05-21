
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for sLogAction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sLogAction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accessMethod" type="{http://shared.bimserver.org/}sAccessMethod" minOccurs="0"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="executorId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sLogAction", propOrder = {
    "accessMethod",
    "date",
    "executorId",
    "oid"
})
@XmlSeeAlso({
    SProjectDeleted.class,
    SPasswordChanged.class,
    SProjectUpdated.class,
    SNewRevisionAdded.class,
    SGeoTagUpdated.class,
    SRevisionBranched.class,
    SPasswordReset.class,
    SRevisionUpdated.class,
    SSettingsSaved.class,
    SUserUndeleted.class,
    SUserChanged.class,
    SDownload.class,
    SUserRemovedFromProject.class,
    SNewUserAdded.class,
    SProjectUndeleted.class,
    SDatabaseCreated.class,
    SServerStarted.class,
    SUserAddedToProject.class,
    SNewObjectIDMUploaded.class,
    SNewCheckoutAdded.class,
    SClashDetectionSettingsUpdated.class,
    SNewProjectAdded.class,
    SUserDeleted.class
})
public class SLogAction {

    protected SAccessMethod accessMethod;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    protected long executorId;
    protected long oid;

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
     * Gets the value of the executorId property.
     * 
     */
    public long getExecutorId() {
        return executorId;
    }

    /**
     * Sets the value of the executorId property.
     * 
     */
    public void setExecutorId(long value) {
        this.executorId = value;
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

}
