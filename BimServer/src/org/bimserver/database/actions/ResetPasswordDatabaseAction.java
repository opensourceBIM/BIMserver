package org.bimserver.database.actions;

import java.util.Date;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.CommitSet;
import org.bimserver.database.Database;
import org.bimserver.database.store.User;
import org.bimserver.database.store.UserType;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.database.store.log.LogFactory;
import org.bimserver.database.store.log.PasswordReset;
import org.bimserver.shared.UserException;
import org.bimserver.utils.GeneratorUtils;
import org.bimserver.utils.Hashers;

public class ResetPasswordDatabaseAction extends BimDatabaseAction<Void> {

	private final String emailAddress;
	private final long actingUoid;

	public ResetPasswordDatabaseAction(AccessMethod accessMethod, long actingUoid, String emailAddress) {
		super(accessMethod);
		this.actingUoid = actingUoid;
		this.emailAddress = emailAddress;
	}

	@Override
	public Void execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		User actingUser = bimDatabaseSession.getUserByUoid(actingUoid);
		if (actingUser.getUserType() != UserType.ADMIN) {
			throw new UserException("Only admin user can reset passwords");
		}
		User user = bimDatabaseSession.getUserByUserName(emailAddress);
		if (user == null) {
			throw new UserException("No user found with provided e-mail address");
		}
		PasswordReset passwordReset = LogFactory.eINSTANCE.createPasswordReset();
		passwordReset.setAccessMethod(getAccessMethod());
		passwordReset.setDate(new Date());
		passwordReset.setExecutor(actingUser);
		passwordReset.setUser(user);
		String newPassword = GeneratorUtils.generateToken();
		user.setPassword(Hashers.getSha256Hash(newPassword));
		CommitSet commitSet = new CommitSet(Database.STORE_PROJECT_ID, -1);
		bimDatabaseSession.store(passwordReset, commitSet);
		bimDatabaseSession.store(user, commitSet);
		return null;
	}
}