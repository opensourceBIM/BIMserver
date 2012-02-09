package org.bimserver.test.framework.actions;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;

public class RemoveUserFromProjectAction extends Action {

	public RemoveUserFromProjectAction(TestFramework testFramework) {
		super(testFramework);
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
		if (!virtualUser.getCreatedProjects().isEmpty()) {
			SProject project = virtualUser.getRandomProject();
			if (!project.getHasAuthorizedUsers().isEmpty()) {
				Long uoid = project.getHasAuthorizedUsers().get(nextInt(project.getHasAuthorizedUsers().size()));
				virtualUser.getLogger().info("Removing user " + uoid + " from project " + project.getName());
				virtualUser.getBimServerClient().getServiceInterface().removeUserFromProject(uoid, project.getOid());
			}
		}
	}
}