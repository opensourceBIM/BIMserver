package org.bimserver.client;

import java.io.IOException;

public class ConnectionException extends Exception {

	private static final long serialVersionUID = -6396374636324774956L;

	public ConnectionException(IOException e) {
		super(e);
	}

	public ConnectionException(String message) {
		super(message);
	}
}
