package org.bimserver.webservices;

import org.bimserver.shared.exceptions.UserException;

public class InvalidTokenException extends UserException {

	public InvalidTokenException(String userMessage) {
		super(userMessage);
	}
}
