
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sendCompareEmail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sendCompareEmail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://shared.bimserver.org/}sCompareType" minOccurs="0"/>
 *         &lt;element name="arg1" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="arg2" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="arg3" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="arg4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sendCompareEmail", propOrder = {
    "arg0",
    "arg1",
    "arg2",
    "arg3",
    "arg4"
})
public class SendCompareEmail {

    protected SCompareType arg0;
    protected long arg1;
    protected long arg2;
    protected long arg3;
    protected String arg4;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link SCompareType }
     *     
     */
    public SCompareType getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link SCompareType }
     *     
     */
    public void setArg0(SCompareType value) {
        this.arg0 = value;
    }

    /**
     * Gets the value of the arg1 property.
     * 
     */
    public long getArg1() {
        return arg1;
    }

    /**
     * Sets the value of the arg1 property.
     * 
     */
    public void setArg1(long value) {
        this.arg1 = value;
    }

    /**
     * Gets the value of the arg2 property.
     * 
     */
    public long getArg2() {
        return arg2;
    }

    /**
     * Sets the value of the arg2 property.
     * 
     */
    public void setArg2(long value) {
        this.arg2 = value;
    }

    /**
     * Gets the value of the arg3 property.
     * 
     */
    public long getArg3() {
        return arg3;
    }

    /**
     * Sets the value of the arg3 property.
     * 
     */
    public void setArg3(long value) {
        this.arg3 = value;
    }

    /**
     * Gets the value of the arg4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArg4() {
        return arg4;
    }

    /**
     * Sets the value of the arg4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArg4(String value) {
        this.arg4 = value;
    }

}
