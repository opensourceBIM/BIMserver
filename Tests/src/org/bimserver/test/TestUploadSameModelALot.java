package org.bimserver.test;

import java.io.File;
import java.io.IOException;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServiceException;

public class TestUploadSameModelALot {
	private BimServerClient client;

	public static void main(String[] args) {
		new TestUploadSameModelALot().start();
	}

	private void start() {
		JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080");
		try {
			client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			client.getSettingsInterface().setGenerateGeometryOnCheckin(false);
			SDeserializerPluginConfiguration deserializerForExtension = client.getBimsie1ServiceInterface().getSuggestedDeserializerForExtension("ifc");
			for (int i=0; i<20; i++) {
				SProject project = client.getBimsie1ServiceInterface().addProject("P" + i);
				System.out.println(i);
				client.checkin(project.getOid(), "C" + i, deserializerForExtension.getOid(), false, true, new File("../TestData/data/AC11-FZK-Haus-IFC.ifc"));
			}
		} catch (ServiceException | ChannelConnectionException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}