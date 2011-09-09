
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sClash complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sClash">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="revision1Id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="revision2Id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="type1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sClash", propOrder = {
    "name1",
    "name2",
    "oid",
    "revision1Id",
    "revision2Id",
    "type1",
    "type2"
})
@XmlSeeAlso({
    SGuidClash.class,
    SEidClash.class
})
public class SClash {

    protected String name1;
    protected String name2;
    protected long oid;
    protected long revision1Id;
    protected long revision2Id;
    protected String type1;
    protected String type2;

    /**
     * Gets the value of the name1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName1() {
        return name1;
    }

    /**
     * Sets the value of the name1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName1(String value) {
        this.name1 = value;
    }

    /**
     * Gets the value of the name2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName2() {
        return name2;
    }

    /**
     * Sets the value of the name2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName2(String value) {
        this.name2 = value;
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
     * Gets the value of the revision1Id property.
     * 
     */
    public long getRevision1Id() {
        return revision1Id;
    }

    /**
     * Sets the value of the revision1Id property.
     * 
     */
    public void setRevision1Id(long value) {
        this.revision1Id = value;
    }

    /**
     * Gets the value of the revision2Id property.
     * 
     */
    public long getRevision2Id() {
        return revision2Id;
    }

    /**
     * Sets the value of the revision2Id property.
     * 
     */
    public void setRevision2Id(long value) {
        this.revision2Id = value;
    }

    /**
     * Gets the value of the type1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType1() {
        return type1;
    }

    /**
     * Sets the value of the type1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType1(String value) {
        this.type1 = value;
    }

    /**
     * Gets the value of the type2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType2() {
        return type2;
    }

    /**
     * Sets the value of the type2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType2(String value) {
        this.type2 = value;
    }

}
