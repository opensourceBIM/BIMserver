
package org.bimserver.citygml.xbuilding;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StairType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StairType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.citygml.org/ade/xbuilding}VisualElementType">
 *       &lt;sequence>
 *         &lt;element name="shapeType" type="{http://www.citygml.org/ade/xbuilding}StairTypeEnum"/>
 *         &lt;element name="stairFlights" type="{http://www.citygml.org/ade/xbuilding}StairFlightType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StairType", propOrder = {
    "shapeType",
    "stairFlights"
})
public class StairType
    extends VisualElementType
{

    @XmlElement(required = true)
    protected StairTypeEnum shapeType;
    protected List<StairFlightType> stairFlights;

    /**
     * Gets the value of the shapeType property.
     * 
     * @return
     *     possible object is
     *     {@link StairTypeEnum }
     *     
     */
    public StairTypeEnum getShapeType() {
        return shapeType;
    }

    /**
     * Sets the value of the shapeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link StairTypeEnum }
     *     
     */
    public void setShapeType(StairTypeEnum value) {
        this.shapeType = value;
    }

    public boolean isSetShapeType() {
        return (this.shapeType!= null);
    }

    /**
     * Gets the value of the stairFlights property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stairFlights property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStairFlights().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StairFlightType }
     * 
     * 
     */
    public List<StairFlightType> getStairFlights() {
        if (stairFlights == null) {
            stairFlights = new ArrayList<StairFlightType>();
        }
        return this.stairFlights;
    }

    public boolean isSetStairFlights() {
        return ((this.stairFlights!= null)&&(!this.stairFlights.isEmpty()));
    }

    public void unsetStairFlights() {
        this.stairFlights = null;
    }

}
