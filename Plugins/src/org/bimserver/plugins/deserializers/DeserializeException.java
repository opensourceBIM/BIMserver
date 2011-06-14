package org.bimserver.plugins.deserializers;


public class DeserializeException extends Exception {

	private static final long serialVersionUID = -7216984454398041095L;

	public DeserializeException(String message, Exception e) {
		super(message, e);
	}

	public DeserializeException(String message) {
		super(message);
	}

	public DeserializeException(Exception e) {
		super(e);
	}
}
