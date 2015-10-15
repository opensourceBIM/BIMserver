package org.bimserver.test.framework.actions;

import java.io.IOException;
import java.nio.file.Path;

import org.bimserver.interfaces.objects.SActionState;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;

public class CheckinAction extends Action {

	private final CheckinSettings settings;

	public CheckinAction(TestFramework testFramework, CheckinSettings settings) {
		super(testFramework);
		this.settings = settings;
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException, PublicInterfaceNotFoundException {
		SProject project = virtualUser.getRandomProject();
		Path randomFile = getTestFramework().getTestFile();
		String fileName = randomFile.getFileName().toString();
		String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
		SDeserializerPluginConfiguration suggestedDeserializerForExtension = virtualUser.getBimServerClient().getBimsie1ServiceInterface().getSuggestedDeserializerForExtension(extension, project.getOid());
		
		if (suggestedDeserializerForExtension == null) {
			virtualUser.getActionResults().setText("No deserializer found for extension " + extension + " in file " + fileName);
			return;
		}
		
		boolean sync = !settings.shouldAsync();
		boolean merge = settings.shouldMerge();
		virtualUser.getActionResults().setText("Checking in new revision on project " + project.getName() + " (" + fileName + ") " + "sync: " + sync + ", merge: " + merge);
		long topicId;
		try {
			topicId = virtualUser.getBimServerClient().checkin(project.getOid(), randomString(), suggestedDeserializerForExtension.getOid(), merge, sync, randomFile);
			if (sync) {
				SLongActionState longActionState = virtualUser.getBimServerClient().getRegistry().getProgress(topicId);
				if (longActionState.getState() == SActionState.AS_ERROR) {
					virtualUser.getActionResults().setText("" + longActionState.getErrors());
				}
				virtualUser.getBimServerClient().getServiceInterface().cleanupLongAction(topicId);
			} else {
				while (true) {
					SLongActionState checkinState = virtualUser.getBimServerClient().getRegistry().getProgress(topicId);
					if (checkinState.getState() == SActionState.FINISHED || checkinState.getState() == SActionState.UNKNOWN) {
						virtualUser.getBimServerClient().getServiceInterface().cleanupLongAction(topicId);
						break;
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	@Override
	public int getWeight() {
		return 10;
	}
}