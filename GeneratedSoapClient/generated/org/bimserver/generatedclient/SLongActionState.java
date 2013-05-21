
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sLongActionState complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sLongActionState">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="progress" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="state" type="{http://shared.bimserver.org/}sActionState" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sLongActionState", propOrder = {
    "oid",
    "progress",
    "state"
})
public class SLongActionState {

    protected long oid;
    protected int progress;
    protected SActionState state;

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
     * Gets the value of the progress property.
     * 
     */
    public int getProgress() {
        return progress;
    }

    /**
     * Sets the value of the progress property.
     * 
     */
    public void setProgress(int value) {
        this.progress = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link SActionState }
     *     
     */
    public SActionState getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link SActionState }
     *     
     */
    public void setState(SActionState value) {
        this.state = value;
    }

}
