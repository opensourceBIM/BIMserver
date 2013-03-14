package org.bimserver.client;

public class ChannelConnectionException extends Exception {

	private static final long serialVersionUID = 5680141767891019803L;

	public ChannelConnectionException(Exception e) {
		super(e);
	}
}