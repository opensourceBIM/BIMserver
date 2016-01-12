package org.bimserver.tests;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import javax.activation.DataHandler;

import org.apache.commons.io.IOUtils;
import org.bimserver.LocalDevSetup;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class TestBimQlSoap {
	public static void main(String[] args) {
		try {
			BimServerClientInterface bimServerClient = LocalDevSetup.setupJson("http://localhost:8080");
			
			List<SProject> projects = bimServerClient.getBimsie1ServiceInterface().getAllProjects(true, true);
			if (projects.isEmpty()) {
				throw new RuntimeException("No projects");
			}
			for (SProject project : projects) {
				List<SRevision> revisionsOfProject = bimServerClient.getBimsie1ServiceInterface().getAllRevisionsOfProject(project.getOid());
				if (!revisionsOfProject.isEmpty()) {
					SRevision revision = revisionsOfProject.get(0);
					SSerializerPluginConfiguration serializerPluginConfiguration = bimServerClient.getBimsie1ServiceInterface().getSerializerByContentType("application/ifc");
					SQueryEnginePluginConfiguration queryEngine = bimServerClient.getBimsie1ServiceInterface().getQueryEngineByName("BimQL Engine");
					if (queryEngine == null) {
						throw new RuntimeException("No BIMQL query engines found");
					}
					Long topicId = bimServerClient.getBimsie1ServiceInterface().downloadQuery(revision.getOid(), queryEngine.getOid(), "Select $Var1Where $Var1.EntityType = IfcDoor", true, serializerPluginConfiguration.getOid());
					SDownloadResult downloadData = bimServerClient.getBimsie1ServiceInterface().getDownloadData(topicId);
					DataHandler dataHandler = downloadData.getFile();
					IOUtils.copy(dataHandler.getInputStream(), new FileOutputStream(Paths.get("test.ifc").toFile()));
				}
			}
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		}
	}
}