
package org.bimserver.generatedclient;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sObjectIDMPluginConfiguration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sObjectIDMPluginConfiguration">
 *   &lt;complexContent>
 *     &lt;extension base="{org.buildingsmart.bimsie1}sPluginConfiguration">
 *       &lt;sequence>
 *         &lt;element name="serializers" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "sObjectIDMPluginConfiguration", propOrder = {
    "serializers",
    "userSettingsId"
})
public class SObjectIDMPluginConfiguration
    extends SPluginConfiguration
{

    @XmlElement(nillable = true)
    protected List<Long> serializers;
    protected long userSettingsId;

    /**
     * Gets the value of the serializers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serializers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSerializers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getSerializers() {
        if (serializers == null) {
            serializers = new ArrayList<Long>();
        }
        return this.serializers;
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
