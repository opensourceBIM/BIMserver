package org.bimserver.citygml.objects;

import ade.RailingType;
import ade.RailingTypeEnum;

public class Railing extends VisualElement {

	public Railing(RailingType railingType) {
		super(railingType);
	}

	public Railing() {
		this(new RailingType());
	}

	public RailingType getJAXBObject() {
		return (RailingType) visualElement;
	}
	
	public void setPredefinedType(RailingTypeEnum railingTypeEnum) {
		((RailingType)visualElement).setPredefinedType(railingTypeEnum);
	}
}