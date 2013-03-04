package org.bimserver.tests;

import java.io.File;
import java.io.IOException;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ChannelConnectionException;
import org.bimserver.client.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServiceException;

public class FileLoader {
	public static void main(String[] args) {
		new FileLoader().load(new File("C:\\Users\\Ruben de Laat\\Dropbox\\Shared\\BIMserver\\LOD modellen"));
	}

	private void load(File dir) {
		JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://sandbox.bimserver.org");
		try {
			BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			for (File file : dir.listFiles()) {
				System.out.println(file.getName());
				SProject project = client.getServiceInterface().addProject(file.getName());
				SDeserializerPluginConfiguration deserializer = client.getServiceInterface().getSuggestedDeserializerForExtension("ifc");
				client.checkin(project.getOid(), file.getName(), deserializer.getOid(), true, false, file);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (ChannelConnectionException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}