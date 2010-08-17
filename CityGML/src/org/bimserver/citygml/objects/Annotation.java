package org.bimserver.citygml.objects;

import ade.AnnotationType;

public class Annotation extends VisualElement {

	public Annotation(AnnotationType annotationType) {
		super(annotationType);
	}

	public Annotation() {
		this(new AnnotationType());
	}

	public AnnotationType getJAXBObject() {
		return (AnnotationType) visualElement;
	}
}