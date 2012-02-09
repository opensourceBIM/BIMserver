package org.bimserver.test.framework.actions;

import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;

public class GetServerLogAction extends Action {

	public GetServerLogAction(TestFramework testFramework) {
		super(testFramework);
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
		virtualUser.getLogger().info("Getting server log");
		String serverLog = virtualUser.getBimServerClient().getServiceInterface().getServerLog();
		virtualUser.getLogger().info("Server log " + serverLog.length() + " characters long");
	}
}
