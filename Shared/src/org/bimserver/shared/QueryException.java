package org.bimserver.shared;

public class QueryException extends Exception {

	private static final long serialVersionUID = -3329743863181492370L;

	public QueryException(String message) {
		super(message);
	}

	public QueryException(Exception e) {
		super(e);
	}
}
