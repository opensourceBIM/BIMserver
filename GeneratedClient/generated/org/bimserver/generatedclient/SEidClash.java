
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sEidClash complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sEidClash">
 *   &lt;complexContent>
 *     &lt;extension base="{http://shared.bimserver.org/}sClash">
 *       &lt;sequence>
 *         &lt;element name="eid1" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="eid2" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sEidClash", propOrder = {
    "eid1",
    "eid2"
})
public class SEidClash
    extends SClash
{

    protected long eid1;
    protected long eid2;

    /**
     * Gets the value of the eid1 property.
     * 
     */
    public long getEid1() {
        return eid1;
    }

    /**
     * Sets the value of the eid1 property.
     * 
     */
    public void setEid1(long value) {
        this.eid1 = value;
    }

    /**
     * Gets the value of the eid2 property.
     * 
     */
    public long getEid2() {
        return eid2;
    }

    /**
     * Sets the value of the eid2 property.
     * 
     */
    public void setEid2(long value) {
        this.eid2 = value;
    }

}
