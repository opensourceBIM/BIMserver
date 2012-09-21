package org.bimserver.webservices;

import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;

public class UserAuthorization extends Authorization {

	private UserType userType;

	public UserAuthorization(long uoid) {
		super(uoid);
	}
	
	public UserAuthorization(User user) {
		super(user.getOid());
		userType = user.getUserType();
	}
	
	public UserType getUserType() {
		return userType;
	}
}
