
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sGeoTagUpdated complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sGeoTagUpdated">
 *   &lt;complexContent>
 *     &lt;extension base="{http://shared.bimserver.org/}sLogAction">
 *       &lt;sequence>
 *         &lt;element name="geoTagId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sGeoTagUpdated", propOrder = {
    "geoTagId"
})
public class SGeoTagUpdated
    extends SLogAction
{

    protected long geoTagId;

    /**
     * Gets the value of the geoTagId property.
     * 
     */
    public long getGeoTagId() {
        return geoTagId;
    }

    /**
     * Sets the value of the geoTagId property.
     * 
     */
    public void setGeoTagId(long value) {
        this.geoTagId = value;
    }

}
