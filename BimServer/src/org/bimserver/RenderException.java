package org.bimserver;

public class RenderException extends Exception {

	public RenderException(String message) {
		super(message);
	}

	public RenderException(Exception e) {
		super(e);
	}
}
