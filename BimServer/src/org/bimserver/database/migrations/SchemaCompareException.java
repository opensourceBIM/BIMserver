package org.bimserver.database.migrations;

public class SchemaCompareException extends Exception {

	private static final long serialVersionUID = 5228556466226620203L;

	public SchemaCompareException(String message) {
		super(message);
	}
}