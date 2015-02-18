package org.bimserver.tests.serviceinterface;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.bimserver.interfaces.objects.SActionState;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class QueryJava extends TestWithEmbeddedServer {
	@Test
	public void test() throws ServiceException, ChannelConnectionException {
		// Create a new BimServerClient with authentication
		BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
		
		// Create a new project
		SProject newProject;
		try {
			newProject = bimServerClient.getBimsie1ServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			// This is the file we will be checking in
			File ifcFile = new File("../TestData/data/AC11-FZK-Haus-IFC.ifc");
			
			// Find a deserializer to use
			SDeserializerPluginConfiguration deserializer = bimServerClient.getBimsie1ServiceInterface().getSuggestedDeserializerForExtension("ifc", newProject.getOid());
			
			// Checkin
			Long progressId = -1L;
			progressId = bimServerClient.checkin(newProject.getOid(), "test", deserializer.getOid(), false, true, ifcFile);
			
			// Get the status
			SLongActionState longActionState = bimServerClient.getRegistry().getProgress(progressId);
			if (longActionState.getState() == SActionState.FINISHED) {
				// Find a serializer
				SSerializerPluginConfiguration serializer = bimServerClient.getBimsie1ServiceInterface().getSerializerByContentType("application/ifc");
				
				// Read our example query file
				String code = FileUtils.readFileToString(new File("../JavaQueryEngine/examples/Doors.java"));
				
				long qeid = -1;
				for (SQueryEnginePluginConfiguration qe : bimServerClient.getPluginInterface().getAllQueryEngines(true)) {
					if (qe.getName().equals("JavaQueryEnginePlugin")) {
						qeid = qe.getOid();
					}
				}
				
				// Get the project details
				newProject = bimServerClient.getBimsie1ServiceInterface().getProjectByPoid(newProject.getOid());
				
				Long downloadQuery = bimServerClient.getBimsie1ServiceInterface().downloadQuery(newProject.getLastRevisionId(), qeid, code, true, serializer.getOid());
				
				InputStream downloadData = bimServerClient.getDownloadData(downloadQuery, serializer.getOid());
				IOUtils.copy(downloadData, new FileOutputStream(new File("onlydoorslt2.ifc")));
			}
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
