
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sRevisionUpdated complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sRevisionUpdated">
 *   &lt;complexContent>
 *     &lt;extension base="{http://shared.bimserver.org/}sLogAction">
 *       &lt;sequence>
 *         &lt;element name="revisionId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sRevisionUpdated", propOrder = {
    "revisionId"
})
public class SRevisionUpdated
    extends SLogAction
{

    protected long revisionId;

    /**
     * Gets the value of the revisionId property.
     * 
     */
    public long getRevisionId() {
        return revisionId;
    }

    /**
     * Sets the value of the revisionId property.
     * 
     */
    public void setRevisionId(long value) {
        this.revisionId = value;
    }

}
