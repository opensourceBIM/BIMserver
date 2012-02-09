package org.bimserver.test.framework.actions;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;

public class CreateProjectAction extends Action {

	public CreateProjectAction(TestFramework testFramework) {
		super(testFramework);
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
		String name = "Project " + randomString();
		virtualUser.getLogger().info("Creating new project: " + name);
		SProject project = virtualUser.getBimServerClient().getServiceInterface().addProject(name);
		virtualUser.getCreatedProjects().add(project);
	}
}
