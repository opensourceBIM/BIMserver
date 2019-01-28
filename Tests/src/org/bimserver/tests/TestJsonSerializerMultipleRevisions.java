package org.bimserver.tests;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Collections;

import org.apache.commons.io.IOUtils;
import org.bimserver.LocalDevSetup;
import org.bimserver.database.queries.om.DefaultQueries;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;

// Test downloading with JsonSerializer 2 revisions of model

public class TestJsonSerializerMultipleRevisions {
	public static void main(String[] args) {
		try {
			BimServerClientInterface client = LocalDevSetup.setupJson("http://localhost:8080");
			SSerializerPluginConfiguration jsonSerializer = client.getServiceInterface().getSerializerByContentType("application/json");
			long roid1 = 65539;
			long roid2 = 131075;
			
			Long download1 = client.getServiceInterface().download(Collections.singleton(roid1), DefaultQueries.allAsString(), jsonSerializer.getOid(), true);
			InputStream downloadData1 = client.getDownloadData(download1);
			IOUtils.copy(downloadData1, new FileOutputStream(Paths.get("roid1.json").toFile()));

			Long download2 = client.getServiceInterface().download(Collections.singleton(roid2), DefaultQueries.allAsString(), jsonSerializer.getOid(), true);
			InputStream downloadData2 = client.getDownloadData(download2);
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
