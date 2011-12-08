
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sNewProjectAdded complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sNewProjectAdded">
 *   &lt;complexContent>
 *     &lt;extension base="{http://shared.bimserver.org/}sLogAction">
 *       &lt;sequence>
 *         &lt;element name="parentProjectId" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
@XmlType(name = "sNewProjectAdded", propOrder = {
    "parentProjectId",
    "projectId"
})
public class SNewProjectAdded
    extends SLogAction
{

    protected long parentProjectId;
    protected long projectId;

    /**
     * Gets the value of the parentProjectId property.
     * 
     */
    public long getParentProjectId() {
        return parentProjectId;
    }

    /**
     * Sets the value of the parentProjectId property.
     * 
     */
    public void setParentProjectId(long value) {
        this.parentProjectId = value;
    }

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
