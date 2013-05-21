
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sWebModulePluginConfiguration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sWebModulePluginConfiguration">
 *   &lt;complexContent>
 *     &lt;extension base="{org.buildingsmart.bimsie}sPluginConfiguration">
 *       &lt;sequence>
 *         &lt;element name="serverSettingsId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sWebModulePluginConfiguration", propOrder = {
    "serverSettingsId"
})
public class SWebModulePluginConfiguration
    extends SPluginConfiguration
{

    protected long serverSettingsId;

    /**
     * Gets the value of the serverSettingsId property.
     * 
     */
    public long getServerSettingsId() {
        return serverSettingsId;
    }

    /**
     * Sets the value of the serverSettingsId property.
     * 
     */
    public void setServerSettingsId(long value) {
        this.serverSettingsId = value;
    }

}
