package org.bimserver.test.framework.actions;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;

public class CreateSubProjectAction extends Action {

	public CreateSubProjectAction(TestFramework testFramework) {
		super(testFramework);
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
		if (!virtualUser.getCreatedProjects().isEmpty()) {
			SProject parentProject = virtualUser.getRandomProject();
			String name = "Project " + randomString();
			virtualUser.getLogger().info("Creating new project: " + name + " as subproject of " + parentProject.getName());
			SProject project = virtualUser.getBimServerClient().getServiceInterface().addProjectAsSubProject(name, parentProject.getOid());
			virtualUser.getCreatedProjects().add(project);
		}
	}
}
