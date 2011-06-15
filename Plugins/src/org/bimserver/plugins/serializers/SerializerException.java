package org.bimserver.plugins.serializers;

public class SerializerException extends Exception {

	private static final long serialVersionUID = -2850970779897195836L;

	public SerializerException(String message, Throwable e) {
		super(message, e);
	}

	public SerializerException(Throwable e) {
		super(e);
	}

	public SerializerException(String message) {
		super(message);
	}
}