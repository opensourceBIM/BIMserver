
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sNewCheckoutAdded complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sNewCheckoutAdded">
 *   &lt;complexContent>
 *     &lt;extension base="{http://shared.bimserver.org/}sLogAction">
 *       &lt;sequence>
 *         &lt;element name="checkoutId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sNewCheckoutAdded", propOrder = {
    "checkoutId"
})
public class SNewCheckoutAdded
    extends SLogAction
{

    protected long checkoutId;

    /**
     * Gets the value of the checkoutId property.
     * 
     */
    public long getCheckoutId() {
        return checkoutId;
    }

    /**
     * Sets the value of the checkoutId property.
     * 
     */
    public void setCheckoutId(long value) {
        this.checkoutId = value;
    }

}
