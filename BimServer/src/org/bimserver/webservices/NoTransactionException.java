package org.bimserver.webservices;

public class NoTransactionException extends Exception {

	private static final long serialVersionUID = -1719446597557023111L;

	public NoTransactionException(String message) {
		super(message);
	}
}
