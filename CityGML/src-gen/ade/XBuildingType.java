
package ade;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.citygml4j.jaxb.citygml.bldg._1.BuildingType;



/**
 * <p>Java class for XBuildingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="XBuildingType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/citygml/building/1.0}BuildingType">
 *       &lt;sequence>
 *         &lt;element name="stairs" type="{http://www.citygml.org/ade/xbuilding}StairType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XBuildingType", propOrder = {
    "stairs"
})
public class XBuildingType
    extends BuildingType
{

    protected List<StairType> stairs;

    /**
     * Gets the value of the stairs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stairs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStairs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StairType }
     * 
     * 
     */
    public List<StairType> getStairs() {
        if (stairs == null) {
            stairs = new ArrayList<StairType>();
        }
        return this.stairs;
    }

    public boolean isSetStairs() {
        return ((this.stairs!= null)&&(!this.stairs.isEmpty()));
    }

    public void unsetStairs() {
        this.stairs = null;
    }

}
