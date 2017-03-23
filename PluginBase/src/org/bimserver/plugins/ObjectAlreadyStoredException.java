package org.bimserver.plugins;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterfaceException;

public class ObjectAlreadyStoredException extends IfcModelInterfaceException {
	private static final long serialVersionUID = -6473300261709590353L;
	private IdEObject newToStore;
	private IdEObject alreadyStored;

	public ObjectAlreadyStoredException(String message, IdEObject alreadyStored, IdEObject newToStore) {
		super(message);
		this.alreadyStored = alreadyStored;
		this.newToStore = newToStore;
	}
	
	public IdEObject getNewToStore() {
		return newToStore;
	}
	
	public IdEObject getAlreadyStored() {
		return alreadyStored;
	}
}
