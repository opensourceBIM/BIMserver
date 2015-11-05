package org.bimserver.shared;

import org.eclipse.emf.ecore.EStructuralFeature;

public class SingleWaitingVirtualObject extends WaitingVirtualObject {

	private int pos;

	public SingleWaitingVirtualObject(int lineNumber, VirtualObject object, EStructuralFeature structuralFeature, int bufferPosition) {
		super(lineNumber, object, structuralFeature, bufferPosition);
	}
}