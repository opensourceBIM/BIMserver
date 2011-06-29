
package org.bimserver.citygml.xbuilding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RailingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RailingType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.citygml.org/ade/xbuilding}VisualElementType">
 *       &lt;sequence>
 *         &lt;element name="predefinedType" type="{http://www.citygml.org/ade/xbuilding}RailingTypeEnum"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RailingType", propOrder = {
    "predefinedType"
})
public class RailingType
    extends VisualElementType
{

    @XmlElement(required = true)
    protected RailingTypeEnum predefinedType;

    /**
     * Gets the value of the predefinedType property.
     * 
     * @return
     *     possible object is
     *     {@link RailingTypeEnum }
     *     
     */
    public RailingTypeEnum getPredefinedType() {
        return predefinedType;
    }

    /**
     * Sets the value of the predefinedType property.
     * 
     * @param value
     *     allowed object is
     *     {@link RailingTypeEnum }
     *     
     */
    public void setPredefinedType(RailingTypeEnum value) {
        this.predefinedType = value;
    }

    public boolean isSetPredefinedType() {
        return (this.predefinedType!= null);
    }

}
