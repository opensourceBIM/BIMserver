package org.bimserver.shared;

import org.eclipse.emf.ecore.EStructuralFeature;

/*
 * WaitingObject's are used when while reading, a reference is encountered that has not yet been
 * parsed. In that case a WaitingObject is created and stored in a map. As soon as the referenced
 * object get's parsed, all that object's waiting objects are connected to the original object.
 */
public class ListWaitingVirtualObject extends WaitingVirtualObject {

	// To keep an eventual order intact, for EList's you can store the index at which it should be placed
	private final int index;

	public ListWaitingVirtualObject(int lineNumber, VirtualObject object, EStructuralFeature structuralFeature, int index, int bufferPosition) {
		super(lineNumber, object, structuralFeature, bufferPosition);
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}
}