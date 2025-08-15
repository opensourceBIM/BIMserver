package org.bimserver.tests.ifc;

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

import java.io.IOException;
import java.nio.file.Paths;

import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SExtendedData;
import org.bimserver.interfaces.objects.SExtendedDataSchema;
import org.bimserver.interfaces.objects.SFile;
import org.bimserver.interfaces.objects.SLongCheckinActionState;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;

import com.google.common.base.Charsets;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

public class TestAddExtendedData {

	@Test
	public void test() throws BimServerClientException, ServiceException, ChannelConnectionException, IOException {
		BimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080");
		BimServerClientInterface client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));

		SFile file = new SFile();
		file.setData("test".getBytes(Charsets.UTF_8));
		file.setMime("text");
		file.setFilename("test.txt");
		long fileId = client.getServiceInterface().uploadFile(file);

		SProject project = client.getServiceInterface().addProject("t2es035442t23", "ifc2x3tc1");
		SDeserializerPluginConfiguration deserializerForExtension = client.getServiceInterface().getSuggestedDeserializerForExtension("ifc", project.getOid());
		SLongCheckinActionState checkinSync = client.checkinSync(project.getOid(), "initial", deserializerForExtension.getOid(), false, Paths.get("../../TestFiles/TestData/data/AC11-FZK-Haus-IFC.ifc"));

		SExtendedDataSchema extendedDataSchemaByNamespace = client.getServiceInterface().getExtendedDataSchemaByName("GEOMETRY_GENERATION_REPORT_JSON_1_1");

		SExtendedData extendedData = new SExtendedData();
		extendedData.setFileId(fileId);
		extendedData.setTitle("test3");
		extendedData.setSchemaId(extendedDataSchemaByNamespace.getOid());

		client.getServiceInterface().addExtendedDataToRevision(checkinSync.getRoid(), extendedData);
	}
}
