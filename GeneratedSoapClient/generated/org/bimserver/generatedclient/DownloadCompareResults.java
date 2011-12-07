
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for downloadCompareResults complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="downloadCompareResults">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serializerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="roid1" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="roid2" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="identifier" type="{http://shared.bimserver.org/}sCompareIdentifier" minOccurs="0"/>
 *         &lt;element name="type" type="{http://shared.bimserver.org/}sCompareType" minOccurs="0"/>
 *         &lt;element name="sync" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "downloadCompareResults", propOrder = {
    "serializerName",
    "roid1",
    "roid2",
    "identifier",
    "type",
    "sync"
})
public class DownloadCompareResults {

    protected String serializerName;
    protected Long roid1;
    protected Long roid2;
    protected SCompareIdentifier identifier;
    protected SCompareType type;
    protected Boolean sync;

    /**
     * Gets the value of the serializerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerializerName() {
        return serializerName;
    }

    /**
     * Sets the value of the serializerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerializerName(String value) {
        this.serializerName = value;
    }

    /**
     * Gets the value of the roid1 property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRoid1() {
        return roid1;
    }

    /**
     * Sets the value of the roid1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRoid1(Long value) {
        this.roid1 = value;
    }

    /**
     * Gets the value of the roid2 property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRoid2() {
        return roid2;
    }

    /**
     * Sets the value of the roid2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRoid2(Long value) {
        this.roid2 = value;
    }

    /**
     * Gets the value of the identifier property.
     * 
     * @return
     *     possible object is
     *     {@link SCompareIdentifier }
     *     
     */
    public SCompareIdentifier getIdentifier() {
        return identifier;
    }

    /**
     * Sets the value of the identifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link SCompareIdentifier }
     *     
     */
    public void setIdentifier(SCompareIdentifier value) {
        this.identifier = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link SCompareType }
     *     
     */
    public SCompareType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link SCompareType }
     *     
     */
    public void setType(SCompareType value) {
        this.type = value;
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

}
