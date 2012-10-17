package org.bimserver.shared.json;

public class ReflectorException extends Exception {

	private String message;

	public ReflectorException(String message) {
		this.message = message;
	}
}
