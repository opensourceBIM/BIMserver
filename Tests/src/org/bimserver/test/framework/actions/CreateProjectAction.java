package org.bimserver.test.framework.actions;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateProjectAction extends Action {
	private static final Logger LOGGER = LoggerFactory.getLogger(CreateSubProjectAction.class);

	public CreateProjectAction(TestFramework testFramework) {
		super(testFramework);
		
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
		String name = "Project " + randomString();
		LOGGER.info("Creating new project: " + name);
		SProject project = virtualUser.getBimServerClient().getServiceInterface().addProject(name);
		virtualUser.getCreatedProjects().add(project);
	}
}
