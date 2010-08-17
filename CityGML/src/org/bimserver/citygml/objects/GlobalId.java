package org.bimserver.citygml.objects;

import org.citygml4j.impl.jaxb.gml._3_1_1.AbstractFeatureImpl;
import org.citygml4j.model.citygml.ade.ADEComponent;

import ade.GlobalIdType;

public class GlobalId extends AbstractFeatureImpl implements ADEComponent {

	private final GlobalIdType globalIdType;

	public GlobalId(GlobalIdType globalIdType) {
		super(globalIdType);
		this.globalIdType = globalIdType;
	}

	public GlobalId() {
		this(new GlobalIdType());
	}

	public String getADENamespaceURI() {
		return "http://www.citygml.org/ade/xbuilding";
	}

	public void setValue(String value) {
		globalIdType.setValue(value);
	}
}