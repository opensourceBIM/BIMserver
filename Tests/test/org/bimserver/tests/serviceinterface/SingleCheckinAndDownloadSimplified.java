package org.bimserver.tests.serviceinterface;

import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.IOUtils;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class SingleCheckinAndDownloadSimplified extends TestWithEmbeddedServer {

	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));

			// Create a new project
			SProject newProject = bimServerClient.getBimsie1ServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			
			// This is the file we will be checking in
			Path ifcFile = Paths.get("../TestData/data/AC11-FZK-Haus-IFC.ifc");
			
			// Find a deserializer to use
			SDeserializerPluginConfiguration deserializer = bimServerClient.getBimsie1ServiceInterface().getSuggestedDeserializerForExtension("ifc", newProject.getOid());
			
			// Checkin
			bimServerClient.checkin(newProject.getOid(), "test", deserializer.getOid(), false, true, ifcFile);
			
			// Find a serializer
			SSerializerPluginConfiguration colladaSerializer = bimServerClient.getBimsie1ServiceInterface().getSerializerByContentType("application/collada");
			
			// Get the project details
			newProject = bimServerClient.getBimsie1ServiceInterface().getProjectByPoid(newProject.getOid());
			
			// Download the latest revision  (the one we just checked in)
			Long downloadId = bimServerClient.getBimsie1ServiceInterface().download(newProject.getLastRevisionId(), colladaSerializer.getOid(), true, false); // Note: sync: false
			InputStream downloadData = bimServerClient.getDownloadData(downloadId, colladaSerializer.getOid());
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			IOUtils.copy(downloadData, baos);
			System.out.println(baos.size() + " bytes downloaded");
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}