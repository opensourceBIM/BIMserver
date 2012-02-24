package org.bimserver.shared.pb;

public class ConvertException extends Exception {
	public ConvertException(String message) {
		super(message);
	}

	public ConvertException(Throwable e) {
		super(e);
	}
}
