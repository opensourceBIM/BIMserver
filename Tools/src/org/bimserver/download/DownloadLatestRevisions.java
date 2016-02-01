package org.bimserver.download;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class DownloadLatestRevisions {
	private BimServerClientInterface client;
	private Path toDir = Paths.get("D:\\Dropbox\\Shared\\Elasstic Ifc Models");
	private SSerializerPluginConfiguration serializer;

	public static void main(String[] args) {
		new DownloadLatestRevisions().start(args);
	}

	private void start(String[] args) {
		try {
			Path home = Paths.get("home");
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(home);
			MetaDataManager metaDataManager = new MetaDataManager(home.resolve("tmp"));
			pluginManager.setMetaDataManager(metaDataManager);
			BimServerClientFactory factory = new JsonBimServerClientFactory(metaDataManager, "http://elassticbim.eu:8080");
			client = factory.create(new UsernamePasswordAuthenticationInfo("admin@elassticbim.eu", "GIWSELOVSlSWaQ7dSlkp"));
			System.out.println(client.getSettingsInterface().getSiteAddress());
			serializer = client.getBimsie1ServiceInterface().getSerializerByName("Ifc2x3");
			List<SProject> allProjects = client.getBimsie1ServiceInterface().getAllProjects(true, true);
			for (SProject project : allProjects) {
				downloadProject(toDir, project);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void downloadProject(Path baseDir, SProject project) throws ServerException, UserException, PublicInterfaceNotFoundException, IOException {
		Path projectDir = baseDir.resolve(project.getName());
		Files.createDirectory(projectDir);
		
		if (!project.getRevisions().isEmpty()) {
			SRevision revision = client.getBimsie1ServiceInterface().getRevision(project.getLastRevisionId());
			System.out.println(revision.getComment());
			if (!revision.getComment().startsWith("generated")) {
				try {
					client.download(project.getLastRevisionId(), serializer.getOid(), projectDir.resolve(revision.getComment()));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		for (long subProjectOid : project.getSubProjects()) {
			SProject subProject = client.getBimsie1ServiceInterface().getProjectByPoid(subProjectOid);
			downloadProject(projectDir, subProject);
		}
	}
}