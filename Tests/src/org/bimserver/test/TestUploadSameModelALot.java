package org.bimserver.test;

import java.io.IOException;
import java.nio.file.Paths;

import org.bimserver.LocalDevSetup;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;

public class TestUploadSameModelALot {

	public static void main(String[] args) {
		new TestUploadSameModelALot().start();
	}

	private void start() {
		try {
			BimServerClientInterface client = LocalDevSetup.setupJson("http://localhost:8080");
			client.getSettingsInterface().setGenerateGeometryOnCheckin(false);
			for (int i=0; i<20; i++) {
				SProject project = client.getBimsie1ServiceInterface().addProject("P" + i, "ifc2x3tc1");
				SDeserializerPluginConfiguration deserializerForExtension = client.getBimsie1ServiceInterface().getSuggestedDeserializerForExtension("ifc", project.getOid());
				System.out.println(i);
				client.checkin(project.getOid(), "C" + i, deserializerForExtension.getOid(), false, true, Paths.get("../TestData/data/AC11-FZK-Haus-IFC.ifc"));
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}