
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for downloadOfType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="downloadOfType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="roid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="className" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="formatIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sync" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "downloadOfType", propOrder = {
    "roid",
    "className",
    "formatIdentifier",
    "sync"
})
public class DownloadOfType {

    protected long roid;
    protected String className;
    protected String formatIdentifier;
    protected boolean sync;

    /**
     * Gets the value of the roid property.
     * 
     */
    public long getRoid() {
        return roid;
    }

    /**
     * Sets the value of the roid property.
     * 
     */
    public void setRoid(long value) {
        this.roid = value;
    }

    /**
     * Gets the value of the className property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassName() {
        return className;
    }

    /**
     * Sets the value of the className property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassName(String value) {
        this.className = value;
    }

    /**
     * Gets the value of the formatIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormatIdentifier() {
        return formatIdentifier;
    }

    /**
     * Sets the value of the formatIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormatIdentifier(String value) {
        this.formatIdentifier = value;
    }

    /**
     * Gets the value of the sync property.
     * 
     */
    public boolean isSync() {
        return sync;
    }

    /**
     * Sets the value of the sync property.
     * 
     */
    public void setSync(boolean value) {
        this.sync = value;
    }

}
