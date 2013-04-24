package org.bimserver.tests.serviceinterface;

import static org.junit.Assert.fail;

import java.io.File;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.bimserver.client.BimServerClient;
import org.bimserver.interfaces.objects.SActionState;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class MultiCheckinAndDownload extends TestWithEmbeddedServer {
	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClient bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));

			// Get the service interface
			ServiceInterface serviceInterface = bimServerClient.getService();

			long s = System.nanoTime();
			for (int i=0; i<3; i++) {
				// Create a new project
				SProject newProject = serviceInterface.addProject("test" + Math.random());
				
				// This is the file we will be checking in
				File ifcFile = new File("../TestData/data/AC11-FZK-Haus-IFC.ifc");
				
				// Find a deserializer to use
				SDeserializerPluginConfiguration deserializer = serviceInterface.getSuggestedDeserializerForExtension("ifc");
				
				// Checkin
				Long progressId = serviceInterface.checkin(newProject.getOid(), "test", deserializer.getOid(), ifcFile.length(), ifcFile.getName(), new DataHandler(new FileDataSource(ifcFile)), false, true);
				
				// Get the status
				SLongActionState longActionState = bimServerClient.getRegistry().getProgress(progressId);
				if (longActionState.getState() == SActionState.FINISHED) {
					// Find a serializer
					SSerializerPluginConfiguration serializer = bimServerClient.getPlugin().getSerializerByContentType("application/ifc");
					
					// Get the project details
					newProject = serviceInterface.getProjectByPoid(newProject.getOid());
					
					// Download the latest revision  (the one we just checked in)
					Long downloadId = serviceInterface.download(newProject.getLastRevisionId(), serializer.getOid(), true, true);
					SLongActionState downloadState = bimServerClient.getRegistry().getProgress(downloadId);
					if (downloadState.getState() == SActionState.FINISHED) {
						// Success
						System.out.println("Success");
					}
				}
			}
			long e = System.nanoTime();
			System.out.println(((e - s) / 1000000) + " ms");
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}