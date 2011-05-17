package org.bimserver.plugins.ifcengine;

public class IfcEngineException extends Exception {
	private static final long serialVersionUID = 4485210826117178542L;

	public IfcEngineException(String message) {
		super(message);
	}
	
	public IfcEngineException(Exception e) {
		super(e);
	}
}