package org.bimserver.citygml.objects;

import ade.StairType;
import ade.StairTypeEnum;

public class Stair extends VisualElement {

	public Stair(StairType stairType) {
		super(stairType);
	}

	public Stair() {
		this(new StairType());
	}

	public StairType getJAXBObject() {
		return (StairType) visualElement;
	}
	
	public void setType(StairTypeEnum stairType) {
		((StairType)visualElement).setShapeType(stairType);
	}
}