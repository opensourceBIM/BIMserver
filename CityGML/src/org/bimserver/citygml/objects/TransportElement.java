package org.bimserver.citygml.objects;

import ade.TransportElementType;

public class TransportElement extends VisualElement {

	public TransportElement(TransportElementType transportElementType) {
		super(transportElementType);
	}

	public TransportElement() {
		this(new TransportElementType());
	}

	public TransportElementType getJAXBObject() {
		return (TransportElementType) visualElement;
	}
}