package org.bimserver.citygml.objects;

import ade.OpeningElementType;

public class OpeningElement extends VisualElement {

	public OpeningElement(OpeningElementType openingElementType) {
		super(openingElementType);
	}

	public OpeningElement() {
		this(new OpeningElementType());
	}

	public OpeningElementType getJAXBObject() {
		return (OpeningElementType) visualElement;
	}
}
