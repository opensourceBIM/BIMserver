
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for removeUserFromProject complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="removeUserFromProject">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="uoid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="poid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "removeUserFromProject", propOrder = {
    "uoid",
    "poid"
})
public class RemoveUserFromProject {

    protected long uoid;
    protected long poid;

    /**
     * Gets the value of the uoid property.
     * 
     */
    public long getUoid() {
        return uoid;
    }

    /**
     * Sets the value of the uoid property.
     * 
     */
    public void setUoid(long value) {
        this.uoid = value;
    }

    /**
     * Gets the value of the poid property.
     * 
     */
    public long getPoid() {
        return poid;
    }

    /**
     * Sets the value of the poid property.
     * 
     */
    public void setPoid(long value) {
        this.poid = value;
    }

}
