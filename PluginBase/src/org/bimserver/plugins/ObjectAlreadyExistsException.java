package org.bimserver.plugins;

import org.bimserver.emf.IfcModelInterfaceException;

public class ObjectAlreadyExistsException extends IfcModelInterfaceException {

	public ObjectAlreadyExistsException(Exception e) {
		super(e);
	}

	private static final long serialVersionUID = -1591564054698513055L;

}
