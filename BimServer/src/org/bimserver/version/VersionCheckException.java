package org.bimserver.version;

public class VersionCheckException extends Exception {

	private static final long serialVersionUID = 3421866534363708378L;

	public VersionCheckException(String message) {
		super(message);
	}

	public VersionCheckException(Exception e) {
		super(e);
	}
}
