package org.bimserver.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.activation.DataHandler;

import org.apache.commons.io.IOUtils;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.ConnectionException;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.ServiceInterface;

public class TestBimQlSoap {
	public static void main(String[] args) {
		BimServerClient bimServerClient;
		try {
			bimServerClient = new BimServerClient("", null);
			bimServerClient.setAuthentication(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			bimServerClient.connectSoap(false);
			ServiceInterface service = bimServerClient.getServiceInterface();
			List<SProject> projects = service.getAllProjects(true);
			if (projects.isEmpty()) {
				throw new RuntimeException("No projects");
			}
			for (SProject project : projects) {
				List<SRevision> revisionsOfProject = service.getAllRevisionsOfProject(project.getOid());
				if (!revisionsOfProject.isEmpty()) {
					SRevision revision = revisionsOfProject.get(0);
					SSerializerPluginConfiguration serializerPluginConfiguration = service.getSerializerByContentType("application/ifc");
					SQueryEnginePluginConfiguration queryEngine = service.getQueryEngineByName("BimQL Engine");
					if (queryEngine == null) {
						throw new RuntimeException("No BIMQL query engines found");
					}
					Long downloadId = service.downloadQuery(revision.getOid(), queryEngine.getOid(), "Select $Var1Where $Var1.EntityType = IfcDoor", true, serializerPluginConfiguration.getOid());
					SDownloadResult downloadData = service.getDownloadData(downloadId);
					DataHandler dataHandler = downloadData.getFile();
					IOUtils.copy(dataHandler.getInputStream(), new FileOutputStream(new File("test.ifc")));
				}
			}
		} catch (ConnectionException e) {
			e.printStackTrace();
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
