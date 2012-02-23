package org.bimserver.test.framework.actions;

import java.io.File;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.bimserver.interfaces.objects.SCheckinResult;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;

public class CheckinAction extends Action {

	public CheckinAction(TestFramework testFramework) {
		super(testFramework);
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
		SProject project = virtualUser.getRandomProject();
		File randomFile = getTestFramework().getRandomFile();
		FileDataSource dataSource = new FileDataSource(randomFile);
		String deserializerName = null;
		if (randomFile.getName().endsWith(".ifc")) {
			deserializerName = "IfcStepDeserializer";
		} else if (randomFile.getName().endsWith(".ifcxml")) {
			deserializerName = "IfcXmlDeserializer";
		} else if (randomFile.getName().endsWith(".ifczip")) {
			deserializerName = "IfcStepDeserializer";
		} else if (randomFile.getName().endsWith(".ifcxmlzip")) {
			deserializerName = "IfcXmlDeserializer";
		} else {
			return;
		}
		boolean sync = getRandom().nextBoolean();
		boolean merge = false;// getRandom().nextBoolean();
		virtualUser.getLogger().info("Checking in new revision on project " + project.getName() + " (" + randomFile.getName() + ") " + "sync: " + sync + ", merge: " + merge);
		Integer checkinId = virtualUser.getBimServerClient().getServiceInterface()
				.checkin(project.getOid(), randomString(), deserializerName, randomFile.length(), new DataHandler(dataSource), merge, sync);
		if (sync) {
			virtualUser.getBimServerClient().getServiceInterface().getCheckinState(checkinId);
		} else {
			while (true) {
				SCheckinResult checkinState = virtualUser.getBimServerClient().getServiceInterface().getCheckinState(checkinId);
				if (checkinState.getProgress() == 100) {
					break;
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public int getWeight() {
		return 10;
	}
}
