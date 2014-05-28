package org.bimserver.test;

import java.io.File;
import java.io.IOException;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.json.JsonBimServerClientFactory;
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

public class TestAddExtendedData {
	public static void main(String[] args) {
		new TestAddExtendedData().start();
	}

	private void start() {
		JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080");
		try {
			BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			SFile file = new SFile();
			file.setData("test".getBytes(Charsets.UTF_8));
			file.setMime("text");
			file.setFilename("test.txt");
			long fileId = client.getServiceInterface().uploadFile(file);
			
			System.out.println(client.getServiceInterface().getFile(fileId));
			
			SProject project = client.getBimsie1ServiceInterface().addProject("test23");
			SDeserializerPluginConfiguration deserializerForExtension = client.getBimsie1ServiceInterface().getSuggestedDeserializerForExtension("ifc");
			client.checkin(project.getOid(), "initial", deserializerForExtension.getOid(), false, true, new File("../TestData/data/AC11-FZK-Haus-IFC.ifc"));
			
			project = client.getBimsie1ServiceInterface().getProjectByPoid(project.getOid());
			
			SExtendedDataSchema extendedDataSchemaByNamespace = client.getBimsie1ServiceInterface().getExtendedDataSchemaByNamespace("http://extend.bimserver.org/validationreport");
			
			SExtendedData extendedData = new SExtendedData();
			extendedData.setFileId(fileId);
			extendedData.setTitle("test3");
			extendedData.setSchemaId(extendedDataSchemaByNamespace.getOid());
			
			client.getBimsie1ServiceInterface().addExtendedDataToRevision(project.getLastRevisionId(), extendedData);
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (ChannelConnectionException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
