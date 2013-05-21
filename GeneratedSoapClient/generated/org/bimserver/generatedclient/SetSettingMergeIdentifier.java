
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for setSettingMergeIdentifier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="setSettingMergeIdentifier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mergeIdentifier" type="{http://shared.bimserver.org/}sMergeIdentifier" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setSettingMergeIdentifier", propOrder = {
    "mergeIdentifier"
})
public class SetSettingMergeIdentifier {

    protected SMergeIdentifier mergeIdentifier;

    /**
     * Gets the value of the mergeIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link SMergeIdentifier }
     *     
     */
    public SMergeIdentifier getMergeIdentifier() {
        return mergeIdentifier;
    }

    /**
     * Sets the value of the mergeIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link SMergeIdentifier }
     *     
     */
    public void setMergeIdentifier(SMergeIdentifier value) {
        this.mergeIdentifier = value;
    }

}
