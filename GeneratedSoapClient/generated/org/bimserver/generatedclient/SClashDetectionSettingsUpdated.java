
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sClashDetectionSettingsUpdated complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sClashDetectionSettingsUpdated">
 *   &lt;complexContent>
 *     &lt;extension base="{http://shared.bimserver.org/}sLogAction">
 *       &lt;sequence>
 *         &lt;element name="clashDetectionSettingsId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sClashDetectionSettingsUpdated", propOrder = {
    "clashDetectionSettingsId"
})
public class SClashDetectionSettingsUpdated
    extends SLogAction
{

    protected long clashDetectionSettingsId;

    /**
     * Gets the value of the clashDetectionSettingsId property.
     * 
     */
    public long getClashDetectionSettingsId() {
        return clashDetectionSettingsId;
    }

    /**
     * Sets the value of the clashDetectionSettingsId property.
     * 
     */
    public void setClashDetectionSettingsId(long value) {
        this.clashDetectionSettingsId = value;
    }

}
