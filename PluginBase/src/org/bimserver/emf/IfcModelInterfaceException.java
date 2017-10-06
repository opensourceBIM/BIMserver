package org.bimserver.emf;

public class IfcModelInterfaceException extends Exception {
	private static final long serialVersionUID = -2230831482236508693L;

	public IfcModelInterfaceException(String message) {
		super(message);
	}

	public IfcModelInterfaceException(Exception e) {
		super(e);
	}
}