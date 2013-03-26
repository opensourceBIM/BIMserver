package org.bimserver.shared.pb;

public class ServiceMethodNotFoundException extends Exception {

	private static final long serialVersionUID = -2992295005684966985L;

	public ServiceMethodNotFoundException(String message) {
		super(message);
	}
}
