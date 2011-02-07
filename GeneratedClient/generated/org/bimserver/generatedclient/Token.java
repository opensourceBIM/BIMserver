
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for token complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="token">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="expires" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="tokenString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "token", propOrder = {
    "expires",
    "tokenString"
})
public class Token {

    protected long expires;
    protected String tokenString;

    /**
     * Gets the value of the expires property.
     * 
     */
    public long getExpires() {
        return expires;
    }

    /**
     * Sets the value of the expires property.
     * 
     */
    public void setExpires(long value) {
        this.expires = value;
    }

    /**
     * Gets the value of the tokenString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTokenString() {
        return tokenString;
    }

    /**
     * Sets the value of the tokenString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTokenString(String value) {
        this.tokenString = value;
    }

}
