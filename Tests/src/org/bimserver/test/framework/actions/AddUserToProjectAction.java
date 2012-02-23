package org.bimserver.test.framework.actions;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;

public class AddUserToProjectAction extends Action {

	public AddUserToProjectAction(TestFramework testFramework) {
		super(testFramework);
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
		SProject project = virtualUser.getRandomProject();
		SUser user = virtualUser.getRandomUser();
		virtualUser.getLogger().info("Adding user " + user.getName() + " to project " + project.getName());
		virtualUser.getBimServerClient().getServiceInterface().addUserToProject(user.getOid(), project.getOid());
	}
}