package org.bimserver.test.framework.actions;

import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;

public class LogoutAction extends Action {

	public LogoutAction(TestFramework testFramework) {
		super(testFramework);
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException, PublicInterfaceNotFoundException {
		if (!virtualUser.getUserNames().isEmpty()) {
			virtualUser.getActionResults().setText("Logging out");
			virtualUser.getBimServerClient().getBimsie1AuthInterface().logout();
		}
	}
}
