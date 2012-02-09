package org.bimserver.test.framework.actions;

import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginAction extends Action {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginAction.class);

	public LoginAction(TestFramework testFramework) {
		super(testFramework);
		
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
		if (nextInt(virtualUser.getCreatedUsers().size() + 1) == 0) {
			virtualUser.getBimServerClient().getServiceInterface().login("admin@bimserver.or", "admin");
		} else {
			if (!virtualUser.getCreatedUsers().isEmpty()) {
				SUser user = virtualUser.getRandomUser();
				LOGGER.info("Logging in as " + user.getUsername());
				virtualUser.getBimServerClient().getServiceInterface().login(user.getUsername(), "test");
			}
		}
	}

}
