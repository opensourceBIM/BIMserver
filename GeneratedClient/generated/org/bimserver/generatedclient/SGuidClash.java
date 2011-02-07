
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sGuidClash complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sGuidClash">
 *   &lt;complexContent>
 *     &lt;extension base="{http://shared.bimserver.org/}sClash">
 *       &lt;sequence>
 *         &lt;element name="guid1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guid2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sGuidClash", propOrder = {
    "guid1",
    "guid2"
})
public class SGuidClash
    extends SClash
{

    protected String guid1;
    protected String guid2;

    /**
     * Gets the value of the guid1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuid1() {
        return guid1;
    }

    /**
     * Sets the value of the guid1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuid1(String value) {
        this.guid1 = value;
    }

    /**
     * Gets the value of the guid2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuid2() {
        return guid2;
    }

    /**
     * Sets the value of the guid2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuid2(String value) {
        this.guid2 = value;
    }

}
