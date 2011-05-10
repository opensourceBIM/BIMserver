
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for compare complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="compare">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="roid1" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="roid2" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="sCompareType" type="{http://shared.bimserver.org/}sCompareType" minOccurs="0"/>
 *         &lt;element name="sCompareIdentifier" type="{http://shared.bimserver.org/}sCompareIdentifier" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "compare", propOrder = {
    "roid1",
    "roid2",
    "sCompareType",
    "sCompareIdentifier"
})
public class Compare {

    protected long roid1;
    protected long roid2;
    protected SCompareType sCompareType;
    protected SCompareIdentifier sCompareIdentifier;

    /**
     * Gets the value of the roid1 property.
     * 
     */
    public long getRoid1() {
        return roid1;
    }

    /**
     * Sets the value of the roid1 property.
     * 
     */
    public void setRoid1(long value) {
        this.roid1 = value;
    }

    /**
     * Gets the value of the roid2 property.
     * 
     */
    public long getRoid2() {
        return roid2;
    }

    /**
     * Sets the value of the roid2 property.
     * 
     */
    public void setRoid2(long value) {
        this.roid2 = value;
    }

    /**
     * Gets the value of the sCompareType property.
     * 
     * @return
     *     possible object is
     *     {@link SCompareType }
     *     
     */
    public SCompareType getSCompareType() {
        return sCompareType;
    }

    /**
     * Sets the value of the sCompareType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SCompareType }
     *     
     */
    public void setSCompareType(SCompareType value) {
        this.sCompareType = value;
    }

    /**
     * Gets the value of the sCompareIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link SCompareIdentifier }
     *     
     */
    public SCompareIdentifier getSCompareIdentifier() {
        return sCompareIdentifier;
    }

    /**
     * Sets the value of the sCompareIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link SCompareIdentifier }
     *     
     */
    public void setSCompareIdentifier(SCompareIdentifier value) {
        this.sCompareIdentifier = value;
    }

}
