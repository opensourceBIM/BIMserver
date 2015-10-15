package org.bimserver.tests;

import java.io.IOException;
import java.nio.file.Paths;

import org.bimserver.LocalDevSetup;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class TestGuid {
	public static void main(String[] args) {
		BimServerClientInterface client = LocalDevSetup.setupJson("http://localhost:8080");
		try {
			SProject project = client.getBimsie1ServiceInterface().addProject("testProject2", "ifc2x3tc1");
			
			Long tid = client.getBimsie1LowLevelInterface().startTransaction(project.getOid());
			client.getBimsie1LowLevelInterface().createObject(tid, "IfcWall", false);
			Long roid = client.getBimsie1LowLevelInterface().commitTransaction(tid, "test commit");
			
			SSerializerPluginConfiguration serializer = client.getBimsie1ServiceInterface().getSerializerByContentType("application/ifc");
			client.download(roid, serializer.getOid(), Paths.get("test2.ifc"));
		} catch (ServerException | UserException | PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
