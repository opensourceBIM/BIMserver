package org.bimserver.citygml.objects;

import ade.BeamType;

public class Beam extends VisualElement {

	public Beam(BeamType beamType) {
		super(beamType);
	}

	public Beam() {
		this(new BeamType());
	}

	public BeamType getJAXBObject() {
		return (BeamType) visualElement;
	}
}