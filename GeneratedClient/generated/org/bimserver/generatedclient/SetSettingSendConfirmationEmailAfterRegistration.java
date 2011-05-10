
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for setSettingSendConfirmationEmailAfterRegistration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="setSettingSendConfirmationEmailAfterRegistration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sendConfirmationEmailAfterRegistration" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setSettingSendConfirmationEmailAfterRegistration", propOrder = {
    "sendConfirmationEmailAfterRegistration"
})
public class SetSettingSendConfirmationEmailAfterRegistration {

    protected boolean sendConfirmationEmailAfterRegistration;

    /**
     * Gets the value of the sendConfirmationEmailAfterRegistration property.
     * 
     */
    public boolean isSendConfirmationEmailAfterRegistration() {
        return sendConfirmationEmailAfterRegistration;
    }

    /**
     * Sets the value of the sendConfirmationEmailAfterRegistration property.
     * 
     */
    public void setSendConfirmationEmailAfterRegistration(boolean value) {
        this.sendConfirmationEmailAfterRegistration = value;
    }

}
