package org.bimserver.shared;

public class InvalidGuidException extends Exception {

	private static final long serialVersionUID = 4932737417688040012L;
	private String guidString;

	public InvalidGuidException(String guidString) {
		super(guidString);
		this.guidString = guidString;
	}
	
	public InvalidGuidException(String guidString, String message) {
		super(message);
		this.guidString = guidString;
	}
}
