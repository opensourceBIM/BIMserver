package org.bimserver.tests.serviceinterface;

import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.apache.commons.io.IOUtils;
import org.bimserver.interfaces.objects.SActionState;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class SingleCheckinAndDownload extends TestWithEmbeddedServer {

	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// When you use the channel for checkin/download calls, all data will have to be converted to the used channel's format, for example for JSON, binary data will be Base64 encoded, which will make things slower and larger
			// The alternative is to use the Servlets, those will also use compression where possible
			boolean useChannel = false; // Using the channel is slower

			// Create a new project
			SProject newProject = bimServerClient.getBimsie1ServiceInterface().addProject("test" + Math.random());
			
			// This is the file we will be checking in
			File ifcFile = new File("../TestData/data/AC11-FZK-Haus-IFC.ifc");
			
			// Find a deserializer to use
			SDeserializerPluginConfiguration deserializer = bimServerClient.getBimsie1ServiceInterface().getSuggestedDeserializerForExtension("ifc");
			
			// Checkin
			Long progressId = -1L;
			if (useChannel) {
				progressId = bimServerClient.getBimsie1ServiceInterface().checkin(newProject.getOid(), "test", deserializer.getOid(), ifcFile.length(), ifcFile.getName(), new DataHandler(new FileDataSource(ifcFile)), true);
			} else {
				progressId = bimServerClient.checkin(newProject.getOid(), "test", deserializer.getOid(), false, true, ifcFile);
			}
			
			// Get the status
			SLongActionState longActionState = bimServerClient.getRegistry().getProgress(progressId);
			if (longActionState.getState() == SActionState.FINISHED) {
				// Find a serializer
				SSerializerPluginConfiguration serializer = bimServerClient.getBimsie1ServiceInterface().getSerializerByContentType("application/ifc");
				
				// Get the project details
				newProject = bimServerClient.getBimsie1ServiceInterface().getProjectByPoid(newProject.getOid());
				
				// Download the latest revision  (the one we just checked in)
				if (useChannel) {
					Long downloadId = bimServerClient.getBimsie1ServiceInterface().download(newProject.getLastRevisionId(), serializer.getOid(), true, true);
					SLongActionState downloadState = bimServerClient.getRegistry().getProgress(downloadId);
					if (downloadState.getState() == SActionState.FINISHED) {
						InputStream inputStream = bimServerClient.getBimsie1ServiceInterface().getDownloadData(downloadId).getFile().getInputStream();
						IOUtils.copy(inputStream, new ByteArrayOutputStream());
						System.out.println("Success");
					}
				} else {
					Long downloadId = bimServerClient.getBimsie1ServiceInterface().download(newProject.getLastRevisionId(), serializer.getOid(), true, false); // Note: sync: false
					InputStream downloadData = bimServerClient.getDownloadData(downloadId, serializer.getOid());
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					IOUtils.copy(downloadData, baos);
					System.out.println(baos.size() + " bytes downloaded");
				}
			} else {
				System.out.println(longActionState.getState());
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}