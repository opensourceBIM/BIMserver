package org.bimserver;

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

import java.nio.file.Path;
import java.nio.file.Paths;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.plugins.PluginManager;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;

public class TriggerImportDataRemote {
	public static void main(String[] args) {
		/*
		 * Args:
		 * 	0: Address of new server
		 *  1: Username
		 *  2: Password
		 *  3: Address of old server
		 *  4: Local path to incoming folder of old server, this local path has to be available on the new server, so you have to copy it from the old server
		 */
		try {
			Path home = Paths.get("home");
			Path tmp = home.resolve("tmp");
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(home);
			MetaDataManager metaDataManager = new MetaDataManager(tmp);
			pluginManager.setMetaDataManager(metaDataManager);
			try (JsonBimServerClientFactory factory = new JsonBimServerClientFactory(metaDataManager, args[0])) {
				BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo(args[1], args[2]));
				client.getServiceInterface().importData(args[3], args[1], args[2], args[4]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		}
	}
}
