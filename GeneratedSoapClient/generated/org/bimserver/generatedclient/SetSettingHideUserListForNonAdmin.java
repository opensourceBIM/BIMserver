
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for setSettingHideUserListForNonAdmin complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="setSettingHideUserListForNonAdmin">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hideUserListForNonAdmin" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setSettingHideUserListForNonAdmin", propOrder = {
    "hideUserListForNonAdmin"
})
public class SetSettingHideUserListForNonAdmin {

    protected Boolean hideUserListForNonAdmin;

    /**
     * Gets the value of the hideUserListForNonAdmin property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHideUserListForNonAdmin() {
        return hideUserListForNonAdmin;
    }

    /**
     * Sets the value of the hideUserListForNonAdmin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHideUserListForNonAdmin(Boolean value) {
        this.hideUserListForNonAdmin = value;
    }

}
