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
import java.util.Random;

import org.apache.commons.lang3.RandomUtils;
import org.bimserver.LocalDevSetup;
import org.bimserver.interfaces.objects.SActionState;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SExtendedData;
import org.bimserver.interfaces.objects.SExtendedDataSchema;
import org.bimserver.interfaces.objects.SFile;
import org.bimserver.interfaces.objects.SLongCheckinActionState;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;

import com.google.common.base.Charsets;

public class AsyncTestAddExtendedData2 {
	public static void main(String[] args) {
		new AsyncTestAddExtendedData2().start();
	}

	private void start() {
		try {
			BimServerClientInterface client = LocalDevSetup.setupJson("http://localhost:8080");
			SFile file = new SFile();
			file.setData("test".getBytes(Charsets.UTF_8));
			file.setMime("text");
			file.setFilename("test.txt");
			long fileId = client.getServiceInterface().uploadFile(file);
			
			SProject project = client.getServiceInterface().addProject(RandomUtils.nextInt(1, 100000000) + "", "ifc2x3tc1");
			SDeserializerPluginConfiguration deserializerForExtension = client.getServiceInterface().getSuggestedDeserializerForExtension("ifc", project.getOid());
			long topicId = client.getServiceInterface().initiateCheckin(project.getOid(), deserializerForExtension.getOid());
			client.checkinAsync(project.getOid(), "initial", deserializerForExtension.getOid(), false, Paths.get("C:\\Git\\TestFiles\\TestData\\data\\AC11-FZK-Haus-IFC.ifc"), topicId);
			
			while(true) {
				SLongCheckinActionState progress = (SLongCheckinActionState) client.getNotificationRegistryInterface().getProgress(topicId);
				System.out.println(progress.getState());
				if (progress.getState() == SActionState.FINISHED) {
					SExtendedDataSchema extendedDataSchemaByNamespace = client.getServiceInterface().getExtendedDataSchemaByName("GEOMETRY_GENERATION_REPORT_JSON_1_1");
					
					SExtendedData extendedData = new SExtendedData();
					extendedData.setFileId(fileId);
					extendedData.setTitle("test3");
					extendedData.setSchemaId(extendedDataSchemaByNamespace.getOid());
					
					client.getServiceInterface().addExtendedDataToRevision(progress.getRoid(), extendedData);
					
					break;
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
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
