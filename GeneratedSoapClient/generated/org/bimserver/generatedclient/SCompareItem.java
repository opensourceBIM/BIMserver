
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sCompareItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sCompareItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataObject" type="{org.bimserver}sDataObject" minOccurs="0"/>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="rid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sCompareItem", propOrder = {
    "dataObject",
    "oid",
    "rid"
})
@XmlSeeAlso({
    SObjectAdded.class,
    SObjectRemoved.class,
    SObjectModified.class
})
public class SCompareItem {

    protected SDataObject dataObject;
    protected long oid;
    protected int rid;

    /**
     * Gets the value of the dataObject property.
     * 
     * @return
     *     possible object is
     *     {@link SDataObject }
     *     
     */
    public SDataObject getDataObject() {
        return dataObject;
    }

    /**
     * Sets the value of the dataObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link SDataObject }
     *     
     */
    public void setDataObject(SDataObject value) {
        this.dataObject = value;
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

}
