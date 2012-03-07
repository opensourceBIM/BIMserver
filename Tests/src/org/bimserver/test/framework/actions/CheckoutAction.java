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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.bimserver.interfaces.objects.SActionState;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializer;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;

public class CheckoutAction extends Action {

	public CheckoutAction(TestFramework testFramework) {
		super(testFramework);

	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
		SProject project = virtualUser.getRandomProject();
		if (project.getLastRevisionId() != -1) {
			List<SSerializer> allSerializers = virtualUser.getBimServerClient().getServiceInterface().getAllSerializers(true);
			SSerializer serializer = allSerializers.get(nextInt(allSerializers.size()));
			boolean sync = nextBoolean();
			virtualUser.getLogger().info(
					"Checking out revision " + project.getLastRevisionId() + " of project " + project.getName() + " with serializer " + serializer.getName() + " sync: " + sync);
			Integer download = virtualUser.getBimServerClient().getServiceInterface().checkout(project.getLastRevisionId(), serializer.getName(), sync);
			while (virtualUser.getBimServerClient().getServiceInterface().getDownloadState(download).getState() != SActionState.FINISHED) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}
			virtualUser.getLogger().info("Done preparing checkout, downloading");
			SDownloadResult downloadData = virtualUser.getBimServerClient().getServiceInterface().getDownloadData(download);
			try {
				ByteArrayOutputStream data = new ByteArrayOutputStream();
				IOUtils.copy(downloadData.getFile().getInputStream(), data);
				virtualUser.getLogger().info(data.size() + " bytes downloaded");
			} catch (IOException e) {
				virtualUser.getLogger().error("", e);
			}
		}
	}

	@Override
	public int getWeight() {
		return 5;
	}
}
