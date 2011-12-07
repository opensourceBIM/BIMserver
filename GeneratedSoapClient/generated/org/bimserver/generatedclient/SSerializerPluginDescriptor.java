
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sSerializerPluginDescriptor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sSerializerPluginDescriptor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="defaultContentType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="defaultExtension" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="defaultName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="pluginClassName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sSerializerPluginDescriptor", propOrder = {
    "defaultContentType",
    "defaultExtension",
    "defaultName",
    "oid",
    "pluginClassName"
})
public class SSerializerPluginDescriptor {

    protected String defaultContentType;
    protected String defaultExtension;
    protected String defaultName;
    protected long oid;
    protected String pluginClassName;

    /**
     * Gets the value of the defaultContentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultContentType() {
        return defaultContentType;
    }

    /**
     * Sets the value of the defaultContentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultContentType(String value) {
        this.defaultContentType = value;
    }

    /**
     * Gets the value of the defaultExtension property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultExtension() {
        return defaultExtension;
    }

    /**
     * Sets the value of the defaultExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultExtension(String value) {
        this.defaultExtension = value;
    }

    /**
     * Gets the value of the defaultName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultName() {
        return defaultName;
    }

    /**
     * Sets the value of the defaultName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultName(String value) {
        this.defaultName = value;
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
     * Gets the value of the pluginClassName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPluginClassName() {
        return pluginClassName;
    }

    /**
     * Sets the value of the pluginClassName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPluginClassName(String value) {
        this.pluginClassName = value;
    }

}
