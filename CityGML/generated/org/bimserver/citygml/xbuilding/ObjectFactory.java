
package org.bimserver.citygml.xbuilding;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.bimserver.citygml.xbuilding package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Annotation_QNAME = new QName("http://www.citygml.org/ade/xbuilding", "Annotation");
    private final static QName _OpeningElement_QNAME = new QName("http://www.citygml.org/ade/xbuilding", "OpeningElement");
    private final static QName _StairFlight_QNAME = new QName("http://www.citygml.org/ade/xbuilding", "StairFlight");
    private final static QName _Beam_QNAME = new QName("http://www.citygml.org/ade/xbuilding", "Beam");
    private final static QName _Stair_QNAME = new QName("http://www.citygml.org/ade/xbuilding", "Stair");
    private final static QName _OverallWidthWindow_QNAME = new QName("http://www.citygml.org/ade/xbuilding", "OverallWidthWindow");
    private final static QName _Column_QNAME = new QName("http://www.citygml.org/ade/xbuilding", "Column");
    private final static QName _OverallWidthDoor_QNAME = new QName("http://www.citygml.org/ade/xbuilding", "OverallWidthDoor");
    private final static QName _Railing_QNAME = new QName("http://www.citygml.org/ade/xbuilding", "Railing");
    private final static QName _GlobalId_QNAME = new QName("http://www.citygml.org/ade/xbuilding", "GlobalId");
    private final static QName _FlowTerminal_QNAME = new QName("http://www.citygml.org/ade/xbuilding", "FlowTerminal");
    private final static QName _OverallHeightDoor_QNAME = new QName("http://www.citygml.org/ade/xbuilding", "OverallHeightDoor");
    private final static QName _OverallHeightWindow_QNAME = new QName("http://www.citygml.org/ade/xbuilding", "OverallHeightWindow");
    private final static QName _TransportElement_QNAME = new QName("http://www.citygml.org/ade/xbuilding", "TransportElement");
    private final static QName _ShapeType_QNAME = new QName("http://www.citygml.org/ade/xbuilding", "ShapeType");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.bimserver.citygml.xbuilding
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StairFlightType }
     * 
     */
    public StairFlightType createStairFlightType() {
        return new StairFlightType();
    }

    /**
     * Create an instance of {@link StairType }
     * 
     */
    public StairType createStairType() {
        return new StairType();
    }

    /**
     * Create an instance of {@link ColumnType }
     * 
     */
    public ColumnType createColumnType() {
        return new ColumnType();
    }

    /**
     * Create an instance of {@link AnnotationType }
     * 
     */
    public AnnotationType createAnnotationType() {
        return new AnnotationType();
    }

    /**
     * Create an instance of {@link VisualElementType }
     * 
     */
    public VisualElementType createVisualElementType() {
        return new VisualElementType();
    }

    /**
     * Create an instance of {@link BeamType }
     * 
     */
    public BeamType createBeamType() {
        return new BeamType();
    }

    /**
     * Create an instance of {@link FlowTerminalType }
     * 
     */
    public FlowTerminalType createFlowTerminalType() {
        return new FlowTerminalType();
    }

    /**
     * Create an instance of {@link TransportElementType }
     * 
     */
    public TransportElementType createTransportElementType() {
        return new TransportElementType();
    }

    /**
     * Create an instance of {@link GlobalIdType }
     * 
     */
    public GlobalIdType createGlobalIdType() {
        return new GlobalIdType();
    }

    /**
     * Create an instance of {@link OpeningElementType }
     * 
     */
    public OpeningElementType createOpeningElementType() {
        return new OpeningElementType();
    }

    /**
     * Create an instance of {@link RailingType }
     * 
     */
    public RailingType createRailingType() {
        return new RailingType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnnotationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/xbuilding", name = "Annotation", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/1.0", substitutionHeadName = "_GenericApplicationPropertyOfAbstractBuilding")
    public JAXBElement<AnnotationType> createAnnotation(AnnotationType value) {
        return new JAXBElement<AnnotationType>(_Annotation_QNAME, AnnotationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OpeningElementType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/xbuilding", name = "OpeningElement", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/1.0", substitutionHeadName = "_GenericApplicationPropertyOfAbstractBuilding")
    public JAXBElement<OpeningElementType> createOpeningElement(OpeningElementType value) {
        return new JAXBElement<OpeningElementType>(_OpeningElement_QNAME, OpeningElementType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StairFlightType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/xbuilding", name = "StairFlight", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/1.0", substitutionHeadName = "_GenericApplicationPropertyOfAbstractBuilding")
    public JAXBElement<StairFlightType> createStairFlight(StairFlightType value) {
        return new JAXBElement<StairFlightType>(_StairFlight_QNAME, StairFlightType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BeamType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/xbuilding", name = "Beam", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/1.0", substitutionHeadName = "_GenericApplicationPropertyOfAbstractBuilding")
    public JAXBElement<BeamType> createBeam(BeamType value) {
        return new JAXBElement<BeamType>(_Beam_QNAME, BeamType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StairType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/xbuilding", name = "Stair", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/1.0", substitutionHeadName = "_GenericApplicationPropertyOfAbstractBuilding")
    public JAXBElement<StairType> createStair(StairType value) {
        return new JAXBElement<StairType>(_Stair_QNAME, StairType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/xbuilding", name = "OverallWidthWindow", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/1.0", substitutionHeadName = "_GenericApplicationPropertyOfWindow")
    public JAXBElement<Double> createOverallWidthWindow(Double value) {
        return new JAXBElement<Double>(_OverallWidthWindow_QNAME, Double.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ColumnType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/xbuilding", name = "Column", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/1.0", substitutionHeadName = "_GenericApplicationPropertyOfAbstractBuilding")
    public JAXBElement<ColumnType> createColumn(ColumnType value) {
        return new JAXBElement<ColumnType>(_Column_QNAME, ColumnType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/xbuilding", name = "OverallWidthDoor", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/1.0", substitutionHeadName = "_GenericApplicationPropertyOfDoor")
    public JAXBElement<Double> createOverallWidthDoor(Double value) {
        return new JAXBElement<Double>(_OverallWidthDoor_QNAME, Double.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RailingType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/xbuilding", name = "Railing", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/1.0", substitutionHeadName = "_GenericApplicationPropertyOfAbstractBuilding")
    public JAXBElement<RailingType> createRailing(RailingType value) {
        return new JAXBElement<RailingType>(_Railing_QNAME, RailingType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GlobalIdType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/xbuilding", name = "GlobalId", substitutionHeadNamespace = "http://www.opengis.net/citygml/1.0", substitutionHeadName = "_GenericApplicationPropertyOfCityObject")
    public JAXBElement<GlobalIdType> createGlobalId(GlobalIdType value) {
        return new JAXBElement<GlobalIdType>(_GlobalId_QNAME, GlobalIdType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FlowTerminalType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/xbuilding", name = "FlowTerminal", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/1.0", substitutionHeadName = "_GenericApplicationPropertyOfAbstractBuilding")
    public JAXBElement<FlowTerminalType> createFlowTerminal(FlowTerminalType value) {
        return new JAXBElement<FlowTerminalType>(_FlowTerminal_QNAME, FlowTerminalType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/xbuilding", name = "OverallHeightDoor", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/1.0", substitutionHeadName = "_GenericApplicationPropertyOfDoor")
    public JAXBElement<Double> createOverallHeightDoor(Double value) {
        return new JAXBElement<Double>(_OverallHeightDoor_QNAME, Double.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/xbuilding", name = "OverallHeightWindow", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/1.0", substitutionHeadName = "_GenericApplicationPropertyOfWindow")
    public JAXBElement<Double> createOverallHeightWindow(Double value) {
        return new JAXBElement<Double>(_OverallHeightWindow_QNAME, Double.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransportElementType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/xbuilding", name = "TransportElement", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/1.0", substitutionHeadName = "_GenericApplicationPropertyOfAbstractBuilding")
    public JAXBElement<TransportElementType> createTransportElement(TransportElementType value) {
        return new JAXBElement<TransportElementType>(_TransportElement_QNAME, TransportElementType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RoofTypeEnum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/xbuilding", name = "ShapeType", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/1.0", substitutionHeadName = "_GenericApplicationPropertyOfRoofSurface")
    public JAXBElement<RoofTypeEnum> createShapeType(RoofTypeEnum value) {
        return new JAXBElement<RoofTypeEnum>(_ShapeType_QNAME, RoofTypeEnum.class, null, value);
    }

}
