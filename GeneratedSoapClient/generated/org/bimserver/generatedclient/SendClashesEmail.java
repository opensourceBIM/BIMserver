
package org.bimserver.generatedclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sendClashesEmail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sendClashesEmail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://shared.bimserver.org/}sClashDetectionSettings" minOccurs="0"/>
 *         &lt;element name="poid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="addressesTo" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sendClashesEmail", propOrder = {
    "sClashDetectionSettings",
    "poid",
    "addressesTo"
})
public class SendClashesEmail {

    @XmlElement(namespace = "http://shared.bimserver.org/")
    protected SClashDetectionSettings sClashDetectionSettings;
    protected Long poid;
    protected List<String> addressesTo;

    /**
     * Gets the value of the sClashDetectionSettings property.
     * 
     * @return
     *     possible object is
     *     {@link SClashDetectionSettings }
     *     
     */
    public SClashDetectionSettings getSClashDetectionSettings() {
        return sClashDetectionSettings;
    }

    /**
     * Sets the value of the sClashDetectionSettings property.
     * 
     * @param value
     *     allowed object is
     *     {@link SClashDetectionSettings }
     *     
     */
    public void setSClashDetectionSettings(SClashDetectionSettings value) {
        this.sClashDetectionSettings = value;
    }

    /**
     * Gets the value of the poid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPoid() {
        return poid;
    }

    /**
     * Sets the value of the poid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPoid(Long value) {
        this.poid = value;
    }

    /**
     * Gets the value of the addressesTo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addressesTo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddressesTo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAddressesTo() {
        if (addressesTo == null) {
            addressesTo = new ArrayList<String>();
        }
        return this.addressesTo;
    }

}
