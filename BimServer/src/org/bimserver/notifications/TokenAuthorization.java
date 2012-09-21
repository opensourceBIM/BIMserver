package org.bimserver.notifications;

import org.bimserver.webservices.Authorization;

public class TokenAuthorization extends Authorization {
	public TokenAuthorization(long uoid) {
		super(uoid);
	}
}
