package org.bimserver.test;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.bimserver.LocalDevSetup;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.plugins.services.Flow;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.Formatters;
import org.bimserver.utils.PathUtils;

public class TestUploadDir {
	private BimServerClientInterface client;

	public static void main(String[] args) {
		new TestUploadDir().start();
	}

	private void start() {
		try {
			client = LocalDevSetup.setupJson("http://localhost:8080");
			client.getSettingsInterface().setGenerateGeometryOnCheckin(false);
			
			Path directory = Paths.get("d:\\testfiles");
			for (Path f :  PathUtils.list(directory)) {
				process(f, null);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void process(Path directory, SProject parentProject) throws ServerException, UserException, PublicInterfaceNotFoundException, IOException {
		if (Files.isDirectory(directory)) {
			SProject project = null;
			if (parentProject == null) {
				project = client.getServiceInterface().addProject(directory.getFileName().toString(), "ifc2x3tc1");
			} else {
				project = client.getServiceInterface().addProjectAsSubProject(directory.getFileName().toString(), parentProject.getOid(), "ifc2x3tc1");
			}
			for (Path file : PathUtils.list(directory)) {
				process(file, project);
			}
		} else {
			String lowerCase = directory.getFileName().toString().toLowerCase();
			if (lowerCase.endsWith("ifc") || lowerCase.endsWith("ifcxml") || lowerCase.endsWith("ifczip")) {
				SDeserializerPluginConfiguration deserializerForExtension = client.getServiceInterface().getSuggestedDeserializerForExtension(directory.getFileName().toString().substring(directory.getFileName().toString().lastIndexOf(".") + 1), parentProject.getOid());
				System.out.println("Checking in " + directory.toString() + " - " + Formatters.bytesToString(directory.toFile().length()));
				try {
					client.checkinSync(parentProject.getOid(), "", deserializerForExtension.getOid(), false, directory);
				} catch (UserException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Ignoring " + directory.toString());
			}
		}
	}
}