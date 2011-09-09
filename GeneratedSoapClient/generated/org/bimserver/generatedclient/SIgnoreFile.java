
package org.bimserver.generatedclient;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sIgnoreFile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sIgnoreFile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="data" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="serializers" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="settingsId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sIgnoreFile", propOrder = {
    "data",
    "name",
    "oid",
    "serializers",
    "settingsId"
})
public class SIgnoreFile {

    protected byte[] data;
    protected String name;
    protected long oid;
    @XmlElement(nillable = true)
    protected List<Long> serializers;
    protected long settingsId;

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setData(byte[] value) {
        this.data = ((byte[]) value);
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
     * Gets the value of the serializers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serializers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSerializers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getSerializers() {
        if (serializers == null) {
            serializers = new ArrayList<Long>();
        }
        return this.serializers;
    }

    /**
     * Gets the value of the settingsId property.
     * 
     */
    public long getSettingsId() {
        return settingsId;
    }

    /**
     * Sets the value of the settingsId property.
     * 
     */
    public void setSettingsId(long value) {
        this.settingsId = value;
    }

}
