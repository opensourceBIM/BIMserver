package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.CommitSet;
import org.bimserver.database.Database;
import org.bimserver.database.store.User;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.shared.UserException;
import org.bimserver.utils.GeneratorUtils;
import org.bimserver.utils.Hashers;

public class ResetPasswordDatabaseAction extends BimDatabaseAction<String> {

	private final String emailAddress;

	public ResetPasswordDatabaseAction(AccessMethod accessMethod, String emailAddress) {
		super(accessMethod);
		this.emailAddress = emailAddress;
	}
	
	@Override
	public String execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		User user = bimDatabaseSession.getUserByUserName(emailAddress);
		if (user == null) {
			throw new UserException("No user found with provided e-mail address");
		}
		String newPassword = GeneratorUtils.generateToken();
		user.setPassword(Hashers.getSha256Hash(newPassword));
		bimDatabaseSession.store(user, new CommitSet(Database.STORE_PROJECT_ID, -1));
		return newPassword;
	}
}