package org.bimserver.test.framework.actions;

import org.bimserver.interfaces.objects.SUser;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;

public class CreateUserAction extends Action {

	public CreateUserAction(TestFramework testFramework) {
		super(testFramework);
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
		String username = randomString() + "@bimserver.org";
		virtualUser.getLogger().info("Creating new user: " + username);
		SUser user = virtualUser.getBimServerClient().getServiceInterface().addUser(username, randomString(), SUserType.values()[nextInt(SUserType.values().length)], nextBoolean());
		virtualUser.getBimServerClient().getServiceInterface().changePassword(user.getOid(), "", "test");
		virtualUser.getCreatedUsers().add(user);
	}
}
