package org.bimserver.ifcgeometryremover;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;

import com.opencsv.CSVWriter;

public class GetNrTriangles {
	public static void main(String[] args) {
		try {
			CSVWriter csvWriter = new CSVWriter(new PrintWriter(new File("elasstic-geometry.csv")));
			
			Path home = Paths.get("home");
			if (!Files.isDirectory(home)) {
				Files.createDirectory(home);
			}
			PluginManager pluginManager = new PluginManager(home.resolve("tmp"), System.getProperty("java.class.path"), null, null, null);
			pluginManager.loadAllPluginsFromEclipseWorkspace(Paths.get("../"), true);
			
			MetaDataManager metaDataManager = new MetaDataManager(pluginManager);
			pluginManager.setMetaDataManager(metaDataManager);
			metaDataManager.init();
			
			pluginManager.initAllLoadedPlugins();
			
			BimServerClientFactory factory = new JsonBimServerClientFactory(metaDataManager, args[0]);
			BimServerClientInterface client = factory.create(new UsernamePasswordAuthenticationInfo(args[1], args[2]));
			
			SProject mainProject = client.getBimsie1ServiceInterface().getProjectsByName("Elasstic Ribon").get(0);
			
			csvWriter.writeNext(new String[]{"Project", "Nr Primitives", "Nr Triangles"});
			for (long poid : mainProject.getSubProjects()) {
				SProject subProject = client.getBimsie1ServiceInterface().getProjectByPoid(poid);
				for (long poid2 : subProject.getSubProjects()) {
					SProject subProject2 = client.getBimsie1ServiceInterface().getProjectByPoid(poid2);
					long roid = subProject2.getLastRevisionId();
					if (roid != -1) {
						long nrPrimitives = client.getServiceInterface().getNrPrimitives(roid);
						System.out.println(subProject2.getName() + ": " + nrPrimitives);
						csvWriter.writeNext(new String[]{mainProject.getName() + "." + subProject.getName() + "." + subProject2.getName(), "" + nrPrimitives, "" + (nrPrimitives * 3)});
					}
				}		
			}
			
			csvWriter.close();
		} catch (ServiceException | ChannelConnectionException e) {
			e.printStackTrace();
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		}
	}
}
