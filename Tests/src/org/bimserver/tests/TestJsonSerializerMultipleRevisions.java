package org.bimserver.tests;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import org.apache.commons.io.IOUtils;
import org.bimserver.LocalDevSetup;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;

// Test downloading with JsonSerializer 2 revisions of model

public class TestJsonSerializerMultipleRevisions {
	public static void main(String[] args) {
		try {
			BimServerClientInterface client = LocalDevSetup.setupJson("http://localhost:8080");
			SSerializerPluginConfiguration jsonSerializer = client.getBimsie1ServiceInterface().getSerializerByContentType("application/json");
			long roid1 = 65539;
			long roid2 = 131075;
			
			Long download1 = client.getBimsie1ServiceInterface().download(roid1, jsonSerializer.getOid(), true, true);
			InputStream downloadData1 = client.getDownloadData(download1, jsonSerializer.getOid());
			IOUtils.copy(downloadData1, new FileOutputStream(Paths.get("roid1.json").toFile()));

			Long download2 = client.getBimsie1ServiceInterface().download(roid2, jsonSerializer.getOid(), true, true);
			InputStream downloadData2 = client.getDownloadData(download2, jsonSerializer.getOid());
			IOUtils.copy(downloadData2, new FileOutputStream(Paths.get("roid2.json").toFile()));
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
