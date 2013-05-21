
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for setSettingAllowUsersToCreateTopLevelProjects complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="setSettingAllowUsersToCreateTopLevelProjects">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="allowUsersToCreateTopLevelProjects" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setSettingAllowUsersToCreateTopLevelProjects", propOrder = {
    "allowUsersToCreateTopLevelProjects"
})
public class SetSettingAllowUsersToCreateTopLevelProjects {

    protected Boolean allowUsersToCreateTopLevelProjects;

    /**
     * Gets the value of the allowUsersToCreateTopLevelProjects property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowUsersToCreateTopLevelProjects() {
        return allowUsersToCreateTopLevelProjects;
    }

    /**
     * Sets the value of the allowUsersToCreateTopLevelProjects property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowUsersToCreateTopLevelProjects(Boolean value) {
        this.allowUsersToCreateTopLevelProjects = value;
    }

}
