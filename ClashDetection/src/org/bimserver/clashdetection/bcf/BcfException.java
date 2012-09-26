package org.bimserver.clashdetection.bcf;

public class BcfException extends Exception {

	public BcfException(String message) {
		super(message);
	}

	public BcfException(Exception e) {
		super(e);
	}
}