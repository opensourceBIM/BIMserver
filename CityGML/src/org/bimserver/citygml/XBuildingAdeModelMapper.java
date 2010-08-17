package org.bimserver.citygml;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.bimserver.citygml.objects.Annotation;
import org.bimserver.citygml.objects.Beam;
import org.bimserver.citygml.objects.Column;
import org.bimserver.citygml.objects.FlowTerminal;
import org.bimserver.citygml.objects.GlobalId;
import org.bimserver.citygml.objects.OpeningElement;
import org.bimserver.citygml.objects.Railing;
import org.bimserver.citygml.objects.Stair;
import org.bimserver.citygml.objects.TransportElement;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.ADEModelMapper;

import ade.AnnotationType;
import ade.BeamType;
import ade.ColumnType;
import ade.FlowTerminalType;
import ade.GlobalIdType;
import ade.ObjectFactory;
import ade.OpeningElementType;
import ade.RailingType;
import ade.StairType;
import ade.TransportElementType;

public class XBuildingAdeModelMapper implements ADEModelMapper {

	private ObjectFactory factory = new ObjectFactory();

	@Override
	public ADEComponent toADEComponent(Object jaxbObject, QName arg1) {
		ADEComponent adeComponent = null;
		if (jaxbObject instanceof StairType) {
			adeComponent = new Stair((StairType) jaxbObject);
		} else if (jaxbObject instanceof ColumnType) {
			adeComponent = new Column((ColumnType)jaxbObject);
		} else if (jaxbObject instanceof AnnotationType) {
			adeComponent = new Annotation((AnnotationType)jaxbObject);
		} else if (jaxbObject instanceof RailingType) {
			adeComponent = new Railing((RailingType)jaxbObject);
		} else if (jaxbObject instanceof TransportElementType) {
			adeComponent = new TransportElement((TransportElementType)jaxbObject);
		} else if (jaxbObject instanceof FlowTerminalType) {
			adeComponent = new FlowTerminal((FlowTerminalType)jaxbObject);
		} else if (jaxbObject instanceof BeamType) {
			adeComponent = new Beam((BeamType)jaxbObject);
		} else if (jaxbObject instanceof OpeningElementType) {
			adeComponent = new OpeningElement((OpeningElementType)jaxbObject);
		} else if (jaxbObject instanceof GlobalIdType) {
			adeComponent = new GlobalId((GlobalIdType)jaxbObject);
		}
		return adeComponent;
	}

	@Override
	public JAXBElement<?> toJAXB(ADEComponent adeComponent) {
		JAXBElement<?> jaxbElement = null;
		if (adeComponent instanceof Stair) {
			jaxbElement = factory.createStair(((Stair) adeComponent)
					.getJAXBObject());
		} else if (adeComponent instanceof Column) {
			jaxbElement = factory.createColumn(((Column) adeComponent).getJAXBObject());
		} else if (adeComponent instanceof Railing) {
			jaxbElement = factory.createRailing(((Railing) adeComponent).getJAXBObject());
		} else if (adeComponent instanceof Annotation) {
			jaxbElement = factory.createAnnotation(((Annotation) adeComponent).getJAXBObject());
		} else if (adeComponent instanceof OpeningElement) {
			jaxbElement = factory.createOpeningElement(((OpeningElement) adeComponent).getJAXBObject());
		} else if (adeComponent instanceof Beam) {
			jaxbElement = factory.createBeam(((Beam) adeComponent).getJAXBObject());
		} else if (adeComponent instanceof TransportElement) {
			jaxbElement = factory.createTransportElement(((TransportElement) adeComponent).getJAXBObject());
		} else if (adeComponent instanceof FlowTerminal) {
			jaxbElement = factory.createFlowTerminal((FlowTerminalType) ((FlowTerminal) adeComponent).getJAXBObject());
		} else if (adeComponent instanceof GlobalId) {
			jaxbElement = factory.createGlobalId((GlobalIdType) ((GlobalId) adeComponent).getJAXBObject());
		}
		return jaxbElement;
	}
}