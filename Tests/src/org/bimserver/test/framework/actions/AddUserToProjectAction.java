package org.bimserver.test.framework.actions;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddUserToProjectAction extends Action {

	private static final Logger LOGGER = LoggerFactory.getLogger(AddUserToProjectAction.class);
	
	public AddUserToProjectAction(TestFramework testFramework) {
		super(testFramework);
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
		if (!virtualUser.getCreatedProjects().isEmpty() && !virtualUser.getCreatedUsers().isEmpty()) {
			SProject project = virtualUser.getRandomProject();
			SUser user = virtualUser.getRandomUser();
			LOGGER.info("Adding user " + user.getName() + " to project " + project.getName());
			virtualUser.getBimServerClient().getServiceInterface().addUserToProject(user.getOid(), project.getOid());
			virtualUser.getCreatedProjects().set(virtualUser.getCreatedProjects().indexOf(project), virtualUser.getBimServerClient().getServiceInterface().getProjectByPoid(project.getOid()));
		}
	}
}