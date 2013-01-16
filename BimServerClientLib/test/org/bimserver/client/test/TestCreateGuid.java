package org.bimserver.client.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.BimServerClientFactory;
import org.bimserver.client.ChannelConnectionException;
import org.bimserver.client.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.ServiceInterface;

public class TestCreateGuid {
	public static void main(String[] args) {
		test();
	}

	private static void test() {
		try {
			// Create a BimServerClientFactory, change Json to ProtocolBuffers or Soap if you like
			BimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080");
			
			// Create a new BimServerClient with authentication
			BimServerClient bimServerClient = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Get the service interface
			ServiceInterface serviceInterface = bimServerClient.getServiceInterface();
			
			// Create a new project
			SProject newProject = serviceInterface.addProject("test" + Math.random());
			
			// Start a transaction
			Long tid = serviceInterface.startTransaction(newProject.getOid());
			
			// Create a GUID object
			Long globalIdOid = serviceInterface.createObject(tid, "IfcGloballyUniqueId");
			serviceInterface.setStringAttribute(tid, globalIdOid, "wrappedValue", "0uyjn9Jan3nRq36Uj6gwws");
			
			// Create furnishing
			Long furnishingOid = serviceInterface.createObject(tid, "IfcFurnishingElement");
			serviceInterface.setReference(tid, furnishingOid, "GlobalId", globalIdOid);
			
			// Commit the transaction
			Long roid = serviceInterface.commitTransaction(tid, "test");
			
			// Download the IFC file to test.ifc
			SSerializerPluginConfiguration serializerPluginConfiguration = serviceInterface.getSerializerByContentType("application/ifc");
			Long download = serviceInterface.download(roid, serializerPluginConfiguration.getOid(), true, true);
			InputStream downloadData = bimServerClient.getDownloadData(download, serializerPluginConfiguration.getOid());
			FileOutputStream fos = new FileOutputStream(new File("test.ifc"));
			IOUtils.copy(downloadData, fos);
			fos.close();
		} catch (ChannelConnectionException e) {
			e.printStackTrace();
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}