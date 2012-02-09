package org.bimserver.test.framework.actions;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateSubProjectAction extends Action {
	private static final Logger LOGGER = LoggerFactory.getLogger(CreateSubProjectAction.class);

	public CreateSubProjectAction(TestFramework testFramework) {
		super(testFramework);
		
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
		if (!virtualUser.getCreatedProjects().isEmpty()) {
			SProject parentProject = virtualUser.getRandomProject();
			String name = "Project " + randomString();
			LOGGER.info("Creating new project: " + name + " as subproject of " + parentProject.getName());
			SProject project = virtualUser.getBimServerClient().getServiceInterface().addProjectAsSubProject(name, parentProject.getOid());
			virtualUser.getCreatedProjects().add(project);
		}
	}

}
