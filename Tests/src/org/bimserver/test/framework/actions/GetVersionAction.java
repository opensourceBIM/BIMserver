package org.bimserver.test.framework.actions;

import org.bimserver.interfaces.objects.SVersion;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;

public class GetVersionAction extends Action {

	public GetVersionAction(TestFramework testFramework) {
		super(testFramework);
		
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
		virtualUser.getLogger().info("Getting version");
		SVersion version = virtualUser.getBimServerClient().getServiceInterface().getVersion();
		virtualUser.getLogger().info(version.getMajor() + "." + version.getMinor() + "." + version.getRevision() + " " + version.getDate());
	}
}
