package org.bimserver.mail;

public class MailSystemException extends Exception {

	private static final long serialVersionUID = 4276366876739868228L;

	public MailSystemException(Exception e) {
		super(e);
	}
}