package org.bimserver.webservices.authorization;

public class AuthenticationException extends Exception {

	public AuthenticationException(String message) {
		super(message);
	}

	public AuthenticationException(Exception e) {
		super(e);
	}

	public AuthenticationException(String message, Exception cause) {
		super(message, cause);
	}
}