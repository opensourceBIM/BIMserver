
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for setSettingAllowSelfRegistration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="setSettingAllowSelfRegistration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="allowSelfRegistration" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setSettingAllowSelfRegistration", propOrder = {
    "allowSelfRegistration"
})
public class SetSettingAllowSelfRegistration {

    protected boolean allowSelfRegistration;

    /**
     * Gets the value of the allowSelfRegistration property.
     * 
     */
    public boolean isAllowSelfRegistration() {
        return allowSelfRegistration;
    }

    /**
     * Sets the value of the allowSelfRegistration property.
     * 
     */
    public void setAllowSelfRegistration(boolean value) {
        this.allowSelfRegistration = value;
    }

}
