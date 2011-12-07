
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for setSettingShowVersionUpgradeAvailable complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="setSettingShowVersionUpgradeAvailable">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="showVersionUpgradeAvailable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setSettingShowVersionUpgradeAvailable", propOrder = {
    "showVersionUpgradeAvailable"
})
public class SetSettingShowVersionUpgradeAvailable {

    protected Boolean showVersionUpgradeAvailable;

    /**
     * Gets the value of the showVersionUpgradeAvailable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowVersionUpgradeAvailable() {
        return showVersionUpgradeAvailable;
    }

    /**
     * Sets the value of the showVersionUpgradeAvailable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowVersionUpgradeAvailable(Boolean value) {
        this.showVersionUpgradeAvailable = value;
    }

}
