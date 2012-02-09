package org.bimserver.test.framework.actions;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSIPrefix;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateProjectAction extends Action {
	private static final Logger LOGGER = LoggerFactory.getLogger(UpdateProjectAction.class);

	public UpdateProjectAction(TestFramework testFramework) {
		super(testFramework);
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
		if (!virtualUser.getCreatedProjects().isEmpty()) {
			SProject project = virtualUser.getRandomProject();
			LOGGER.info("Changing settings of project " + project.getName());
			project.setDescription(randomString());
			project.setExportLengthMeasurePrefix(SSIPrefix.values()[nextInt(SSIPrefix.values().length)]);
			project.setName(randomString());
			virtualUser.getBimServerClient().getServiceInterface().updateProject(project);
		}		
	}
}
