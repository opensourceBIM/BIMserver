package org.bimserver.database.migrations;

public class MigrationException extends Exception {

	private static final long serialVersionUID = -3484080453807141317L;

	public MigrationException(String message) {
		super(message);
	}

	public MigrationException(Exception e) {
		super(e);
	}
}
