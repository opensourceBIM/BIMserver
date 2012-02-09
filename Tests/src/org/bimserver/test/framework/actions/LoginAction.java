package org.bimserver.test.framework.actions;

import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;

public class LoginAction extends Action {

	public LoginAction(TestFramework testFramework) {
		super(testFramework);
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
		if (nextInt(virtualUser.getCreatedUsers().size() + 1) == 0) {
			virtualUser.getLogger().info("Logging in as admin@bimserver.org");
			virtualUser.getBimServerClient().getServiceInterface().login("admin@bimserver.or", "admin");
		} else {
			if (!virtualUser.getCreatedUsers().isEmpty()) {
				SUser user = virtualUser.getRandomUser();
				virtualUser.getLogger().info("Logging in as " + user.getUsername());
				virtualUser.getBimServerClient().getServiceInterface().login(user.getUsername(), "test");
			}
		}
	}
}
