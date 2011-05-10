
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
 *         &lt;element name="allowUsersToCreateTopLevelProjects" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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

    protected boolean allowUsersToCreateTopLevelProjects;

    /**
     * Gets the value of the allowUsersToCreateTopLevelProjects property.
     * 
     */
    public boolean isAllowUsersToCreateTopLevelProjects() {
        return allowUsersToCreateTopLevelProjects;
    }

    /**
     * Sets the value of the allowUsersToCreateTopLevelProjects property.
     * 
     */
    public void setAllowUsersToCreateTopLevelProjects(boolean value) {
        this.allowUsersToCreateTopLevelProjects = value;
    }

}
