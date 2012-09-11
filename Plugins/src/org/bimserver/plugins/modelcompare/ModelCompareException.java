package org.bimserver.plugins.modelcompare;

public class ModelCompareException extends Exception {

	public ModelCompareException(Exception e) {
		super(e);
	}

	public ModelCompareException(String message) {
		super(message);
	}
}
