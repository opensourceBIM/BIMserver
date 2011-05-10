
package org.bimserver.generatedclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for setSettingCacheOutputFiles complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="setSettingCacheOutputFiles">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cacheOutputFiles" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setSettingCacheOutputFiles", propOrder = {
    "cacheOutputFiles"
})
public class SetSettingCacheOutputFiles {

    protected boolean cacheOutputFiles;

    /**
     * Gets the value of the cacheOutputFiles property.
     * 
     */
    public boolean isCacheOutputFiles() {
        return cacheOutputFiles;
    }

    /**
     * Sets the value of the cacheOutputFiles property.
     * 
     */
    public void setCacheOutputFiles(boolean value) {
        this.cacheOutputFiles = value;
    }

}
