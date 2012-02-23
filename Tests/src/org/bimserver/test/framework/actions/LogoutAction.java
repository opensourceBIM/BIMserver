package org.bimserver.test.framework.actions;

import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;

public class LogoutAction extends Action {

	public LogoutAction(TestFramework testFramework) {
		super(testFramework);
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
		if (!virtualUser.getUserNames().isEmpty()) {
			virtualUser.getLogger().info("Logging out");
			virtualUser.getBimServerClient().getServiceInterface().logout();
		}
	}
}
