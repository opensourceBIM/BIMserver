package org.bimserver.database;

public class BimserverThreadInterruptedException extends BimserverDatabaseException {

	private static final long serialVersionUID = 3336636289433642178L;

	public BimserverThreadInterruptedException(String message) {
		super(message);
	}
}
