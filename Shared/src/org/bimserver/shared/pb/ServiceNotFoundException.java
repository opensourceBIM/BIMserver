package org.bimserver.shared.pb;

public class ServiceNotFoundException extends Exception {

	private static final long serialVersionUID = -8921587672752489514L;

	public ServiceNotFoundException(String message) {
		super(message);
	}
}
