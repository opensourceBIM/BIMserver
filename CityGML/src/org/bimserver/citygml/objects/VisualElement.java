package org.bimserver.citygml.objects;

import org.bimserver.models.ifc2x3.IfcGloballyUniqueId;
import org.citygml4j.impl.jaxb.citygml.core._1.CityObjectImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiSurfacePropertyImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.gml.MultiSurfaceProperty;

import ade.VisualElementType;

public class VisualElement extends CityObjectImpl implements ADEComponent {

	protected final VisualElementType visualElement;

	public VisualElement(VisualElementType visualElement) {
		super(visualElement);
		this.visualElement = visualElement;
	}

	public String getADENamespaceURI() {
		return "http://www.citygml.org/ade/xbuilding";
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.ADE;
	}

	public void setLod3MultiSurface(MultiSurfaceProperty multiSurfaceProperty) {
		visualElement.setLod3MultiSurface(((MultiSurfacePropertyImpl) multiSurfaceProperty).getJAXBObject());
	}

	public void setDescription(String description) {
		visualElement.getDescription().setValue(description);
	}

	public void setGlobalId(IfcGloballyUniqueId ifcGloballyUniqueId) {
		if (ifcGloballyUniqueId != null) {
			GlobalId globalId = new GlobalId();
			globalId.setValue(ifcGloballyUniqueId.getWrappedValue());
			getGenericApplicationPropertyOfCityObject().add(globalId);
		}
	}
}