package org.bimserver.tests;

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
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class TestManyRevisions {
	public static void main(String[] args) {
		new TestManyRevisions().start(args);
	}

	private void start(String[] args) {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(Paths.get("home"));
			MetaDataManager metaDataManager = new MetaDataManager(pluginManager);
			pluginManager.setMetaDataManager(metaDataManager);
			BimServerClientFactory factory = new JsonBimServerClientFactory(metaDataManager, "http://localhost:8080");
			BimServerClientInterface client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			try {
				SProject project = client.getBimsie1ServiceInterface().addProject("lots2", "ifc2x3tc1");
				Path[] files = new Path[]{Paths.get("../TestData/data/AC11-Institute-Var-2-IFC.ifc"), Paths.get("../TestData/data/AC11-FZK-Haus-IFC - Alt.ifc")};
				SDeserializerPluginConfiguration deserializer = client.getBimsie1ServiceInterface().getSuggestedDeserializerForExtension("ifc", project.getOid());
				int fn = 0;
				for (int i=0; i<20; i++) {
					System.out.println(i + ": " + files[fn].getFileName().toString());
					client.checkin(project.getOid(), "comment" + i, deserializer.getOid(), false, true, files[fn]);
					fn = 1 - fn;
				}
			} catch (ServerException | UserException | PublicInterfaceNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
