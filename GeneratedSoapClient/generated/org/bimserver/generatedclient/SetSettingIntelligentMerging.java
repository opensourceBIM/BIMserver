
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for setSettingIntelligentMerging complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="setSettingIntelligentMerging">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="intelligentMerging" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setSettingIntelligentMerging", propOrder = {
    "intelligentMerging"
})
public class SetSettingIntelligentMerging {

    protected boolean intelligentMerging;

    /**
     * Gets the value of the intelligentMerging property.
     * 
     */
    public boolean isIntelligentMerging() {
        return intelligentMerging;
    }

    /**
     * Sets the value of the intelligentMerging property.
     * 
     */
    public void setIntelligentMerging(boolean value) {
        this.intelligentMerging = value;
    }

}
