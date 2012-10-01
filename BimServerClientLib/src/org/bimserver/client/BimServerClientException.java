package org.bimserver.client;

public class BimServerClientException extends Exception {

	public BimServerClientException(String message) {
		super(message);
	}

	public BimServerClientException(Exception e) {
		super(e);
	}
}