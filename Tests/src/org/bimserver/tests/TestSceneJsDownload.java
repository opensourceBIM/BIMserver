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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.bimserver.LocalDevSetup;
import org.bimserver.database.queries.om.DefaultQueries;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class TestSceneJsDownload {
	public static void main(String[] args) {
		new TestSceneJsDownload().start();
	}

	private void start() {
		try {
			BimServerClientInterface bimServerClient = LocalDevSetup.setupJson("http://localhost:8080");
			bimServerClient.getAuthInterface().login("admin@bimserver.org", "admin");
			SSerializerPluginConfiguration serializerByContentType = bimServerClient.getServiceInterface().getSerializerByContentType("application/json");
			List<SProject> projects = bimServerClient.getServiceInterface().getProjectsByName("test");
			if (!projects.isEmpty()) {
				SProject project = projects.get(0);
				if (project.getLastRevisionId() != -1) {
					long start = System.nanoTime();
					Long download = bimServerClient.getServiceInterface().download(Collections.singleton(project.getLastRevisionId()), DefaultQueries.allAsString(), serializerByContentType.getOid(), true);
					System.out.println(((System.nanoTime() - start) / 1000000) + " ms");
					start = System.nanoTime();
					InputStream inputStream = bimServerClient.getDownloadData(download);
					FileOutputStream fileOutputStream = new FileOutputStream(Paths.get("test.json").toFile());
					IOUtils.copy(inputStream, fileOutputStream);
					fileOutputStream.close();
					System.out.println(((System.nanoTime() - start) / 1000000) + " ms");
				}
			}
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		}
	}
}