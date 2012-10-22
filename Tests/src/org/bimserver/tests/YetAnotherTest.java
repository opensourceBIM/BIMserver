package org.bimserver.tests;

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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.ConnectionException;
import org.bimserver.client.Session;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.IfcProject;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class YetAnotherTest {
	public static void main(String[] args) {
		new YetAnotherTest().start();
	}

	private void start() {
		try {
			BimServerClient bimServerClient = new BimServerClient("", null);
			bimServerClient.setAuthentication(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			bimServerClient.connectProtocolBuffers("localhost", 8020);
			String pName = "p java client" + new java.util.Date();
			SProject addProject = bimServerClient.getServiceInterface().addProject(pName);
			Session session = bimServerClient.createSession();
			session.startTransaction(addProject.getId());
			IfcProject ifcProject = session.create(IfcProject.class);
			ifcProject.setName("This is a test");
			long roid = session.commitTransaction("This is a test commitTransaction");

			long downloadId = bimServerClient.getServiceInterface().download(roid, -1L, true, false); // TODO
			SDownloadResult downloadData = bimServerClient.getServiceInterface().getDownloadData(downloadId);
			IOUtils.copy(downloadData.getFile().getInputStream(), new FileOutputStream(new File("model.ifc")));
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (ConnectionException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
