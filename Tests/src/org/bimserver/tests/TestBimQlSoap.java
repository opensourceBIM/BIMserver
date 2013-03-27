package org.bimserver.tests;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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
import java.util.List;

import javax.activation.DataHandler;

import org.apache.commons.io.IOUtils;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.BimServerClientFactory;
import org.bimserver.client.ChannelConnectionException;
import org.bimserver.client.SoapBimServerClientFactory;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.ServiceInterface;

public class TestBimQlSoap {
	public static void main(String[] args) {
		BimServerClientFactory factory = new SoapBimServerClientFactory("localhost");
		try {
			BimServerClient bimServerClient = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			ServiceInterface service = bimServerClient.getService();
			List<SProject> projects = service.getAllProjects(true);
			if (projects.isEmpty()) {
				throw new RuntimeException("No projects");
			}
			for (SProject project : projects) {
				List<SRevision> revisionsOfProject = service.getAllRevisionsOfProject(project.getOid());
				if (!revisionsOfProject.isEmpty()) {
					SRevision revision = revisionsOfProject.get(0);
					SSerializerPluginConfiguration serializerPluginConfiguration = bimServerClient.getPlugin().getSerializerByContentType("application/ifc");
					SQueryEnginePluginConfiguration queryEngine = bimServerClient.getPlugin().getQueryEngineByName("BimQL Engine");
					if (queryEngine == null) {
						throw new RuntimeException("No BIMQL query engines found");
					}
					Long downloadId = service.downloadQuery(revision.getOid(), queryEngine.getOid(), "Select $Var1Where $Var1.EntityType = IfcDoor", true, serializerPluginConfiguration.getOid());
					SDownloadResult downloadData = service.getDownloadData(downloadId);
					DataHandler dataHandler = downloadData.getFile();
					IOUtils.copy(dataHandler.getInputStream(), new FileOutputStream(new File("test.ifc")));
				}
			}
		} catch (ChannelConnectionException e) {
			e.printStackTrace();
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		}
	}
}