package org.bimserver.plugins.modelmerger;


public class MergeException extends Exception {

	public MergeException(Exception e) {
		super(e);
	}
	
	public MergeException(String message) {
		super(message);
	}
}