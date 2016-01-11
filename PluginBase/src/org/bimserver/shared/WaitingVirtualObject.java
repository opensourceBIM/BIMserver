package org.bimserver.shared;

import org.eclipse.emf.ecore.EStructuralFeature;

public class WaitingVirtualObject {
	// The object that has a missing reference
	private final VirtualObject object;

	// The structural feature (usually a reference) on which to 'connect' the object on
	private final EStructuralFeature structuralFeature;

	private int lineNumber;

	private int bufferPosition = -1;
	
	public WaitingVirtualObject(int lineNumber, VirtualObject object, EStructuralFeature structuralFeature, int bufferPosition) {
		this.lineNumber = lineNumber;
		this.object = object;
		this.structuralFeature = structuralFeature;
		this.bufferPosition = bufferPosition;
	}

	public VirtualObject getObject() {
		return object;
	}

	public EStructuralFeature getStructuralFeature() {
		return structuralFeature;
	}
	
	public int getLineNumber() {
		return lineNumber;
	}
	
	@Override
	public String toString() {
		return getObject() + " " + getStructuralFeature().getName();
	}
	
	public int getBufferPosition() {
		return bufferPosition;
	}
}