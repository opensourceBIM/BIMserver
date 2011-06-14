package org.bimserver.shared;

public class PluginException extends Exception {

	private static final long serialVersionUID = 2164002702938048391L;

	public PluginException(String message) {
		super(message);
	}

	public PluginException(Exception e) {
		super(e);
	}

	public PluginException(String message, ClassNotFoundException e) {
		super(message, e);
	}
}
