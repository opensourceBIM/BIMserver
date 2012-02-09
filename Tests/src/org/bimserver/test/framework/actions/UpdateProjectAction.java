package org.bimserver.test.framework.actions;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSIPrefix;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;

public class UpdateProjectAction extends Action {

	public UpdateProjectAction(TestFramework testFramework) {
		super(testFramework);
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
		if (!virtualUser.getCreatedProjects().isEmpty()) {
			SProject project = virtualUser.getRandomProject();
			virtualUser.getLogger().info("Changing settings of project " + project.getName());
			project.setDescription(randomString());
			project.setExportLengthMeasurePrefix(SSIPrefix.values()[nextInt(SSIPrefix.values().length)]);
			project.setName(randomString());
			virtualUser.getBimServerClient().getServiceInterface().updateProject(project);
		}		
	}
}
