
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sProjectUpdated complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sProjectUpdated">
 *   &lt;complexContent>
 *     &lt;extension base="{http://shared.bimserver.org/}sLogAction">
 *       &lt;sequence>
 *         &lt;element name="projectId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sProjectUpdated", propOrder = {
    "projectId"
})
public class SProjectUpdated
    extends SLogAction
{

    protected long projectId;

    /**
     * Gets the value of the projectId property.
     * 
     */
    public long getProjectId() {
        return projectId;
    }

    /**
     * Sets the value of the projectId property.
     * 
     */
    public void setProjectId(long value) {
        this.projectId = value;
    }

}
