
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sRevisionBranched complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sRevisionBranched">
 *   &lt;complexContent>
 *     &lt;extension base="{http://shared.bimserver.org/}sLogAction">
 *       &lt;sequence>
 *         &lt;element name="newrevisionId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="oldrevisionId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sRevisionBranched", propOrder = {
    "newrevisionId",
    "oldrevisionId"
})
public class SRevisionBranched
    extends SLogAction
{

    protected long newrevisionId;
    protected long oldrevisionId;

    /**
     * Gets the value of the newrevisionId property.
     * 
     */
    public long getNewrevisionId() {
        return newrevisionId;
    }

    /**
     * Sets the value of the newrevisionId property.
     * 
     */
    public void setNewrevisionId(long value) {
        this.newrevisionId = value;
    }

    /**
     * Gets the value of the oldrevisionId property.
     * 
     */
    public long getOldrevisionId() {
        return oldrevisionId;
    }

    /**
     * Sets the value of the oldrevisionId property.
     * 
     */
    public void setOldrevisionId(long value) {
        this.oldrevisionId = value;
    }

}
