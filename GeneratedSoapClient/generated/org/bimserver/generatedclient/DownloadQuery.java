
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for downloadQuery complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="downloadQuery">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="roid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="qeid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sync" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="serializerOid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "downloadQuery", propOrder = {
    "roid",
    "qeid",
    "code",
    "sync",
    "serializerOid"
})
public class DownloadQuery {

    protected Long roid;
    protected Long qeid;
    protected String code;
    protected Boolean sync;
    protected Long serializerOid;

    /**
     * Gets the value of the roid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRoid() {
        return roid;
    }

    /**
     * Sets the value of the roid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRoid(Long value) {
        this.roid = value;
    }

    /**
     * Gets the value of the qeid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getQeid() {
        return qeid;
    }

    /**
     * Sets the value of the qeid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setQeid(Long value) {
        this.qeid = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the sync property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSync() {
        return sync;
    }

    /**
     * Sets the value of the sync property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSync(Boolean value) {
        this.sync = value;
    }

    /**
     * Gets the value of the serializerOid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSerializerOid() {
        return serializerOid;
    }

    /**
     * Sets the value of the serializerOid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSerializerOid(Long value) {
        this.serializerOid = value;
    }

}
