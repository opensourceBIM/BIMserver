
package org.bimserver.citygml.xbuilding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StairFlightType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StairFlightType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.citygml.org/ade/xbuilding}VisualElementType">
 *       &lt;sequence>
 *         &lt;element name="predefinedType" type="{http://www.citygml.org/ade/xbuilding}StairFlightTypeEnum"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StairFlightType", propOrder = {
    "predefinedType"
})
public class StairFlightType
    extends VisualElementType
{

    @XmlElement(required = true)
    protected StairFlightTypeEnum predefinedType;

    /**
     * Gets the value of the predefinedType property.
     * 
     * @return
     *     possible object is
     *     {@link StairFlightTypeEnum }
     *     
     */
    public StairFlightTypeEnum getPredefinedType() {
        return predefinedType;
    }

    /**
     * Sets the value of the predefinedType property.
     * 
     * @param value
     *     allowed object is
     *     {@link StairFlightTypeEnum }
     *     
     */
    public void setPredefinedType(StairFlightTypeEnum value) {
        this.predefinedType = value;
    }

    public boolean isSetPredefinedType() {
        return (this.predefinedType!= null);
    }

}
