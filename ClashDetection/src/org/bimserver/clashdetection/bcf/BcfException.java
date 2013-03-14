package org.bimserver.clashdetection.bcf;

public class BcfException extends Exception {

	private static final long serialVersionUID = 179644744977834298L;

	public BcfException(String message) {
		super(message);
	}

	public BcfException(Exception e) {
		super(e);
	}
}