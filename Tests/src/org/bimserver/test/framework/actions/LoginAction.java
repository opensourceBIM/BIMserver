package org.bimserver.test.framework.actions;

import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;

public class LoginAction extends Action {

	public LoginAction(TestFramework testFramework) {
		super(testFramework);
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException, PublicInterfaceNotFoundException {
		if (nextInt(virtualUser.getUserNames().size() + 1) == 0) {
			virtualUser.getActionResults().setText("Logging in as admin@bimserver.org");
			virtualUser.getBimServerClient().getBimsie1AuthInterface().login("admin@bimserver.org", "admin");
		} else {
			if (!virtualUser.getUserNames().isEmpty()) {
				String username = virtualUser.getRandomUserName();
				virtualUser.getActionResults().setText("Logging in as " + username);
				virtualUser.getBimServerClient().getBimsie1AuthInterface().login(username, "test");
			}
		}
	}
}
