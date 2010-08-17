package org.bimserver.ifc;

public class SerializerException extends Exception {

	private static final long serialVersionUID = -2850970779897195836L;

	public SerializerException(String message, Exception e) {
		super(message, e);
	}
}
