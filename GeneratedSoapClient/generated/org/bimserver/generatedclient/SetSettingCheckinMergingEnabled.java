
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for setSettingCheckinMergingEnabled complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="setSettingCheckinMergingEnabled">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="checkinMergingEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setSettingCheckinMergingEnabled", propOrder = {
    "checkinMergingEnabled"
})
public class SetSettingCheckinMergingEnabled {

    protected boolean checkinMergingEnabled;

    /**
     * Gets the value of the checkinMergingEnabled property.
     * 
     */
    public boolean isCheckinMergingEnabled() {
        return checkinMergingEnabled;
    }

    /**
     * Sets the value of the checkinMergingEnabled property.
     * 
     */
    public void setCheckinMergingEnabled(boolean value) {
        this.checkinMergingEnabled = value;
    }

}
