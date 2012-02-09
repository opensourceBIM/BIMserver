package org.bimserver.test.framework.actions;

import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogoutAction extends Action {
	private static final Logger LOGGER = LoggerFactory.getLogger(LogoutAction.class);

	public LogoutAction(TestFramework testFramework) {
		super(testFramework);
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
		if (!virtualUser.getCreatedUsers().isEmpty()) {
			LOGGER.info("Logging out");
			virtualUser.getBimServerClient().getServiceInterface().logout();
		}
	}
}
