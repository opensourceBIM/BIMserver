package org.bimserver.tests;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServiceException;

// Test downloading with JsonSerializer 2 revisions of model

public class TestJsonSerializerMultipleRevisions {
	public static void main(String[] args) {
		JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080");
		try {
			BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			SSerializerPluginConfiguration jsonSerializer = client.getBimsie1ServiceInterface().getSerializerByContentType("application/json");
			long roid1 = 65539;
			long roid2 = 131075;
			
			Long download1 = client.getBimsie1ServiceInterface().download(roid1, jsonSerializer.getOid(), true, true);
			InputStream downloadData1 = client.getDownloadData(download1, jsonSerializer.getOid());
			IOUtils.copy(downloadData1, new FileOutputStream(new File("roid1.json")));

			Long download2 = client.getBimsie1ServiceInterface().download(roid2, jsonSerializer.getOid(), true, true);
			InputStream downloadData2 = client.getDownloadData(download2, jsonSerializer.getOid());
			IOUtils.copy(downloadData2, new FileOutputStream(new File("roid2.json")));
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
