
package org.bimserver.generatedclient;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for checkinSync complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="checkinSync">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="poid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fileSize" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ifcFile" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="merge" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkinSync", propOrder = {
    "poid",
    "comment",
    "fileSize",
    "ifcFile",
    "merge"
})
public class CheckinSync {

    protected long poid;
    protected String comment;
    protected long fileSize;
    @XmlMimeType("application/octet-stream")
    protected DataHandler ifcFile;
    protected boolean merge;

    /**
     * Gets the value of the poid property.
     * 
     */
    public long getPoid() {
        return poid;
    }

    /**
     * Sets the value of the poid property.
     * 
     */
    public void setPoid(long value) {
        this.poid = value;
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
     * Gets the value of the fileSize property.
     * 
     */
    public long getFileSize() {
        return fileSize;
    }

    /**
     * Sets the value of the fileSize property.
     * 
     */
    public void setFileSize(long value) {
        this.fileSize = value;
    }

    /**
     * Gets the value of the ifcFile property.
     * 
     * @return
     *     possible object is
     *     {@link DataHandler }
     *     
     */
    public DataHandler getIfcFile() {
        return ifcFile;
    }

    /**
     * Sets the value of the ifcFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataHandler }
     *     
     */
    public void setIfcFile(DataHandler value) {
        this.ifcFile = value;
    }

    /**
     * Gets the value of the merge property.
     * 
     */
    public boolean isMerge() {
        return merge;
    }

    /**
     * Sets the value of the merge property.
     * 
     */
    public void setMerge(boolean value) {
        this.merge = value;
    }

}
