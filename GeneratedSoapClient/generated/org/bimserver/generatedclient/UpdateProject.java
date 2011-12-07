
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateProject complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateProject">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://shared.bimserver.org/}sProject" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateProject", propOrder = {
    "sProject"
})
public class UpdateProject {

    @XmlElement(namespace = "http://shared.bimserver.org/")
    protected SProject sProject;

    /**
     * Gets the value of the sProject property.
     * 
     * @return
     *     possible object is
     *     {@link SProject }
     *     
     */
    public SProject getSProject() {
        return sProject;
    }

    /**
     * Sets the value of the sProject property.
     * 
     * @param value
     *     allowed object is
     *     {@link SProject }
     *     
     */
    public void setSProject(SProject value) {
        this.sProject = value;
    }

}
