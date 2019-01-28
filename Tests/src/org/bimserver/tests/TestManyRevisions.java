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

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.plugins.services.Flow;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class TestManyRevisions {
	public static void main(String[] args) {
		new TestManyRevisions().start(args);
	}

	private void start(String[] args) {
		try {
			Path home = Paths.get("home");
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(home);
			MetaDataManager metaDataManager = new MetaDataManager(home.resolve("tmp"));
			pluginManager.setMetaDataManager(metaDataManager);
			try (BimServerClientFactory factory = new JsonBimServerClientFactory(metaDataManager, "http://localhost:8080")) {
				BimServerClientInterface client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
				try {
					SProject project = client.getServiceInterface().addProject("lots2", "ifc2x3tc1");
					Path[] files = new Path[]{Paths.get("../TestData/data/AC11-Institute-Var-2-IFC.ifc"), Paths.get("../TestData/data/AC11-FZK-Haus-IFC - Alt.ifc")};
					SDeserializerPluginConfiguration deserializer = client.getServiceInterface().getSuggestedDeserializerForExtension("ifc", project.getOid());
					int fn = 0;
					for (int i=0; i<20; i++) {
						System.out.println(i + ": " + files[fn].getFileName().toString());
						client.checkinSync(project.getOid(), "comment" + i, deserializer.getOid(), false, files[fn]);
						fn = 1 - fn;
					}
				} catch (ServerException | UserException | PublicInterfaceNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
