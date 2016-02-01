package org.bimserver.ifcgeometryremover;

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

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.bimserver.LocalDevPluginLoader;
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
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(home);
			pluginManager.loadAllPluginsFromEclipseWorkspace(Paths.get("../"), true);
			
			MetaDataManager metaDataManager = new MetaDataManager(home.resolve("tmp"));
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
