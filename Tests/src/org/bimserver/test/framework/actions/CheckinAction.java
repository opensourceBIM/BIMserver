package org.bimserver.test.framework.actions;

import java.io.File;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckinAction extends Action {
	private static final Logger LOGGER = LoggerFactory.getLogger(CheckinAction.class);
	
	public CheckinAction(TestFramework testFramework) {
		super(testFramework);
	}
	
	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
		if (!virtualUser.getCreatedProjects().isEmpty()) {
			SProject sProject = virtualUser.getRandomProject();
			File randomFile = getTestFramework().getRandomFile();
			FileDataSource dataSource = new FileDataSource(randomFile);
			String deserializerName = null;
			if (randomFile.getName().endsWith(".ifc")) {
				deserializerName = "IfcStepDeserializer";
			} else if (randomFile.getName().endsWith(".ifcxml")) {
				deserializerName = "IfcXmlDeserializer";
			}
			boolean sync = getRandom().nextBoolean();
			boolean merge = getRandom().nextBoolean();
			LOGGER.info("Checking in new revision on project " + sProject.getName() + " (" + randomFile.getName() + ") " + "sync: " + sync + ", merge: " + merge);
			virtualUser.getBimServerClient().getServiceInterface().checkin(sProject.getOid(), randomString(), deserializerName, randomFile.length(), new DataHandler(dataSource), merge, sync);
		}
	}
	
	@Override
	public int getWeight() {
		return 10;
	}
}
