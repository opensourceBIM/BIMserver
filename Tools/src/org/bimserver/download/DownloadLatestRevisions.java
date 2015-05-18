package org.bimserver.download;

import java.io.File;
import java.io.IOException;
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
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class DownloadLatestRevisions {
	private BimServerClientInterface client;
	private File toDir = new File("D:\\Dropbox\\Shared\\Elasstic Ifc Models");
	private SSerializerPluginConfiguration serializer;

	public static void main(String[] args) {
		new DownloadLatestRevisions().start(args);
	}

	private void start(String[] args) {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(new File("home"));
			MetaDataManager metaDataManager = new MetaDataManager(pluginManager);
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

	private void downloadProject(File baseDir, SProject project) throws ServerException, UserException, PublicInterfaceNotFoundException {
		File projectDir = new File(baseDir, project.getName());
		projectDir.mkdir();
		
		if (!project.getRevisions().isEmpty()) {
			SRevision revision = client.getBimsie1ServiceInterface().getRevision(project.getLastRevisionId());
			System.out.println(revision.getComment());
			if (!revision.getComment().startsWith("generated")) {
				try {
					client.download(project.getLastRevisionId(), serializer.getOid(), new File(projectDir, revision.getComment()));
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