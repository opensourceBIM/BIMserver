package org.bimserver;

public class GeometryGeneratingException extends Exception {

	private static final long serialVersionUID = -7096730211434827172L;

	public GeometryGeneratingException(String message) {
		super(message);
	}

	public GeometryGeneratingException(Exception e) {
		super(e);
	}
}
