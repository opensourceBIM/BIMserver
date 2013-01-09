package org.bimserver.client.test;

import java.io.File;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.BimServerClientFactory;
import org.bimserver.client.ChannelConnectionException;
import org.bimserver.client.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SActionState;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.ServiceInterface;

public class TestMultiCheckinAndDownload {
	public static void main(String[] args) {
		test();
	}

	private static void test() {
		try {
			BimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080");
			
			// Create a new BimServerClient
			BimServerClient bimServerClient = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));

			// Get the service interface
			ServiceInterface serviceInterface = bimServerClient.getServiceInterface();

			long s = System.nanoTime();
			for (int i=0; i<10; i++) {
				// Create a new project
				SProject newProject = serviceInterface.addProject("test" + Math.random());
				
				// This is the file we will be checking in
				File ifcFile = new File("../TestData/data/AC11-FZK-Haus-IFC.ifc");
				
				// Find a deserializer to use
				SDeserializerPluginConfiguration deserializer = serviceInterface.getSuggestedDeserializerForExtension("ifc");
				
				// Checkin
				Long stateId = serviceInterface.checkin(newProject.getOid(), "test", deserializer.getOid(), ifcFile.length(), ifcFile.getName(), new DataHandler(new FileDataSource(ifcFile)), false, true);
				
				// Get the status
				SLongActionState longActionState = serviceInterface.getLongActionState(stateId);
				if (longActionState.getState() == SActionState.FINISHED) {
					// Find a serializer
					SSerializerPluginConfiguration serializer = serviceInterface.getSerializerByContentType("application/ifc");
					
					// Get the project details
					newProject = serviceInterface.getProjectByPoid(newProject.getOid());
					
					// Download the latest revision  (the one we just checked in)
					Long downloadId = serviceInterface.download(newProject.getLastRevisionId(), serializer.getOid(), true, true);
					SLongActionState downloadState = serviceInterface.getLongActionState(downloadId);
					if (downloadState.getState() == SActionState.FINISHED) {
						// Success
						System.out.println("Success");
					}
				}
			}
			long e = System.nanoTime();
			System.out.println(((e - s) / 1000000) + " ms");
		} catch (ChannelConnectionException e) {
			e.printStackTrace();
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (ServiceException e1) {
			e1.printStackTrace();
		}
	}
}