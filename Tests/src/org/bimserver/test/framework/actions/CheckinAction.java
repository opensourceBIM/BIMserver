package org.bimserver.test.framework.actions;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.bimserver.interfaces.objects.SCheckinResult;
import org.bimserver.interfaces.objects.SCheckinStatus;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
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
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
		SProject project = virtualUser.getRandomProject();
		File randomFile = getTestFramework().getTestFile();
		FileDataSource dataSource = new FileDataSource(randomFile);
		String fileName = randomFile.getName();
		String extension = fileName.substring(fileName.indexOf(".") + 1);
		SDeserializerPluginConfiguration suggestedDeserializerForExtension = virtualUser.getBimServerClient().getServiceInterface().getSuggestedDeserializerForExtension(extension);
		
		if (suggestedDeserializerForExtension == null) {
			getActionResults().setText("No deserializer found for extension " + extension + " in file " + fileName);
			return;
		}
		
		boolean sync = !settings.shouldAsync();
		boolean merge = settings.shouldMerge();
		getActionResults().setText("Checking in new revision on project " + project.getName() + " (" + fileName + ") " + "sync: " + sync + ", merge: " + merge);
		long checkinId = virtualUser.getBimServerClient().getServiceInterface()
				.checkin(project.getOid(), randomString(), suggestedDeserializerForExtension.getOid(), randomFile.length(), fileName, new DataHandler(dataSource), merge, sync);
		if (sync) {
			virtualUser.getBimServerClient().getServiceInterface().getCheckinState(checkinId);
		} else {
			while (true) {
				SCheckinResult checkinState = virtualUser.getBimServerClient().getServiceInterface().getCheckinState(checkinId);
				if (checkinState.getStatus() == SCheckinStatus.CH_FINISHED || checkinState.getStatus() == SCheckinStatus.CH_ERROR) {
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
