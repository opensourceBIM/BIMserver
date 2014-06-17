package org.bimserver.test;

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

import org.bimserver.client.BimServerClient;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.Formatters;

public class TestUploadDir {
	private BimServerClient client;

	public static void main(String[] args) {
		new TestUploadDir().start();
	}

	private void start() {
		JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080");
		try {
			client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			client.getSettingsInterface().setGenerateGeometryOnCheckin(false);
			
			File directory = new File("d:\\testfiles");
			for (File f : directory.listFiles()) {
				process(f, null);
			}
		} catch (ServiceException | ChannelConnectionException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void process(File directory, SProject parentProject) throws ServerException, UserException, PublicInterfaceNotFoundException, IOException {
		if (directory.isDirectory()) {
			SProject project = null;
			if (parentProject == null) {
				project = client.getBimsie1ServiceInterface().addProject(directory.getName(), "ifc4");
			} else {
				project = client.getBimsie1ServiceInterface().addProjectAsSubProject(directory.getName(), parentProject.getOid(), "ifc4");
			}
			for (File file : directory.listFiles()) {
				process(file, project);
			}
		} else {
			String lowerCase = directory.getName().toLowerCase();
			if (lowerCase.endsWith("ifc") || lowerCase.endsWith("ifcxml") || lowerCase.endsWith("ifczip")) {
				SDeserializerPluginConfiguration deserializerForExtension = client.getBimsie1ServiceInterface().getSuggestedDeserializerForExtension(directory.getName().substring(directory.getName().lastIndexOf(".") + 1));
				System.out.println("Checking in " + directory.getAbsolutePath() + " - " + Formatters.bytesToString(directory.length()));
				try {
					client.checkin(parentProject.getOid(), "", deserializerForExtension.getOid(), false, true, directory);
				} catch (UserException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Ignoring " + directory.getAbsolutePath());
			}
		}
	}
}
