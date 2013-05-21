
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sDeserializerPluginConfiguration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sDeserializerPluginConfiguration">
 *   &lt;complexContent>
 *     &lt;extension base="{org.buildingsmart.bimsie}sPluginConfiguration">
 *       &lt;sequence>
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
@XmlType(name = "sDeserializerPluginConfiguration", propOrder = {
    "userSettingsId"
})
public class SDeserializerPluginConfiguration
    extends SPluginConfiguration
{

    protected long userSettingsId;

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
