package org.bimserver;

public class NoSerializerFoundException extends Exception {

	private static final long serialVersionUID = -6382703887519793245L;

	public NoSerializerFoundException(String message) {
		super(message);
	}
}
