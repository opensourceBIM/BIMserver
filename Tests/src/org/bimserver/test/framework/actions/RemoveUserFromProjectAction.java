package org.bimserver.test.framework.actions;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RemoveUserFromProjectAction extends Action {
	private static final Logger LOGGER = LoggerFactory.getLogger(RemoveUserFromProjectAction.class);

	public RemoveUserFromProjectAction(TestFramework testFramework) {
		super(testFramework);
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
		if (!virtualUser.getCreatedProjects().isEmpty()) {
			SProject project = virtualUser.getRandomProject();
			if (!project.getHasAuthorizedUsers().isEmpty()) {
				Long uoid = project.getHasAuthorizedUsers().get(nextInt(project.getHasAuthorizedUsers().size()));
				LOGGER.info("Removing user " + uoid + " from project " + project.getName());
				virtualUser.getBimServerClient().getServiceInterface().removeUserFromProject(uoid, project.getOid());
			}
		}
	}
}