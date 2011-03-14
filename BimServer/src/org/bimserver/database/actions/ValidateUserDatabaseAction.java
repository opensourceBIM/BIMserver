package org.bimserver.database.actions;

import java.util.Date;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.User;
import org.bimserver.shared.UserException;
import org.bimserver.utils.Hashers;

public class ValidateUserDatabaseAction extends BimDatabaseAction<Void> {

	private static final long VALIDATION_TOKEN_EXPIRE_MILLIS = 1000 * 60 * 60 * 24 * 7; // 7 days
	private final long uoid;
	private final String token;
	private final String password;

	public ValidateUserDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long uoid, String token, String password) {
		super(bimDatabaseSession, accessMethod);
		this.uoid = uoid;
		this.token = token;
		this.password = password;
	}

	@Override
	public Void execute() throws UserException, BimDeadlockException, BimDatabaseException {
		User user = getUserByUoid(uoid);
		if (user.getValidationToken() == null) {
			throw new UserException("This account is already validated");
		}
		if (user.getValidationTokenCreated().getTime() + VALIDATION_TOKEN_EXPIRE_MILLIS < new Date().getTime()) {
			throw new UserException("The validation period of this account has been expired, please contact your administrator");
		}
		if (!user.getValidationToken().equals(Hashers.getSha256Hash(token))) {
			throw new UserException("The given token is not correct");
		}
		if (password == null || password.trim().equals("")) {
			throw new UserException("Invalid password");
		}
		user.setPassword(Hashers.getSha256Hash(password));
		user.setValidationToken(null);
		user.setValidationTokenCreated(null);
		getDatabaseSession().store(user);
		return null;
	}
}