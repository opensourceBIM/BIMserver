package org.bimserver.test.framework.actions;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.File;
import java.io.IOException;

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
		File randomFile = getTestFramework().getTestFile();
		String fileName = randomFile.getName();
		String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
		SDeserializerPluginConfiguration suggestedDeserializerForExtension = virtualUser.getBimServerClient().getBimsie1ServiceInterface().getSuggestedDeserializerForExtension(extension);
		
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