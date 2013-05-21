
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sInternalServicePluginConfiguration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sInternalServicePluginConfiguration">
 *   &lt;complexContent>
 *     &lt;extension base="{org.buildingsmart.bimsie}sPluginConfiguration">
 *       &lt;sequence>
 *         &lt;element name="remoteAccessible" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="userSettingsId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sInternalServicePluginConfiguration", propOrder = {
    "remoteAccessible",
    "userSettingsId"
})
public class SInternalServicePluginConfiguration
    extends SPluginConfiguration
{

    protected boolean remoteAccessible;
    protected long userSettingsId;

    /**
     * Gets the value of the remoteAccessible property.
     * 
     */
    public boolean isRemoteAccessible() {
        return remoteAccessible;
    }

    /**
     * Sets the value of the remoteAccessible property.
     * 
     */
    public void setRemoteAccessible(boolean value) {
        this.remoteAccessible = value;
    }

    /**
     * Gets the value of the userSettingsId property.
     * 
     */
    public long getUserSettingsId() {
        return userSettingsId;
    }

    /**
     * Sets the value of the userSettingsId property.
     * 
     */
    public void setUserSettingsId(long value) {
        this.userSettingsId = value;
    }

}
