
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sSerializerPluginConfiguration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sSerializerPluginConfiguration">
 *   &lt;complexContent>
 *     &lt;extension base="{org.buildingsmart.bimsie}sPluginConfiguration">
 *       &lt;sequence>
 *         &lt;element name="objectIDMId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="renderEngineId" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
@XmlType(name = "sSerializerPluginConfiguration", propOrder = {
    "objectIDMId",
    "renderEngineId",
    "userSettingsId"
})
public class SSerializerPluginConfiguration
    extends SPluginConfiguration
{

    protected long objectIDMId;
    protected long renderEngineId;
    protected long userSettingsId;

    /**
     * Gets the value of the objectIDMId property.
     * 
     */
    public long getObjectIDMId() {
        return objectIDMId;
    }

    /**
     * Sets the value of the objectIDMId property.
     * 
     */
    public void setObjectIDMId(long value) {
        this.objectIDMId = value;
    }

    /**
     * Gets the value of the renderEngineId property.
     * 
     */
    public long getRenderEngineId() {
        return renderEngineId;
    }

    /**
     * Sets the value of the renderEngineId property.
     * 
     */
    public void setRenderEngineId(long value) {
        this.renderEngineId = value;
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
