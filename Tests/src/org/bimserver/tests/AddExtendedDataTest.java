package org.bimserver.tests;

import java.io.File;
import java.io.IOException;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.soap.SoapBimServerClientFactory;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SExtendedData;
import org.bimserver.interfaces.objects.SExtendedDataSchema;
import org.bimserver.interfaces.objects.SFile;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServiceException;

import com.google.common.base.Charsets;

public class AddExtendedDataTest {
	public static void main(String[] args) {
		new AddExtendedDataTest().start();
	}

	private void start() {
		SoapBimServerClientFactory factory = new SoapBimServerClientFactory("http://localhost:8080");
		try {
			BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			SFile file = new SFile();
			file.setData("test".getBytes(Charsets.UTF_8));
			file.setFilename("test");
			file.setMime("test");
			
			Long fid = client.getServiceInterface().uploadFile(file);
			
			SFile fileX = client.getServiceInterface().getFile(fid);
			
			SProject project = client.getBimsie1ServiceInterface().addProject("test33s");
			SDeserializerPluginConfiguration deserializer = client.getBimsie1ServiceInterface().getSuggestedDeserializerForExtension("ifc");
			
			client.checkin(project.getOid(), "test", deserializer.getOid(), false, true, new File("../TestData/data/AC11-FZK-Haus-IFC.ifc"));
			
			project = client.getBimsie1ServiceInterface().getProjectByPoid(project.getOid());

			SExtendedDataSchema eds = client.getBimsie1ServiceInterface().getExtendedDataSchemaByNamespace("csv");
			
			SExtendedData extendedData = new SExtendedData();
			extendedData.setFileId(fid);
			extendedData.setSchemaId(eds.getOid());
			extendedData.setTitle("test");
			
			client.getBimsie1ServiceInterface().addExtendedDataToRevision(project.getLastRevisionId(), extendedData);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ChannelConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
