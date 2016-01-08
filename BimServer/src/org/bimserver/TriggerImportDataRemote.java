package org.bimserver;

import java.nio.file.Paths;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.plugins.PluginManager;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;

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
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(Paths.get("home"));
			MetaDataManager metaDataManager = new MetaDataManager(pluginManager);
			pluginManager.setMetaDataManager(metaDataManager);
			JsonBimServerClientFactory factory = new JsonBimServerClientFactory(metaDataManager, args[0]);
			BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo(args[1], args[2]));
			client.getServiceInterface().importData(args[3], args[1], args[2], args[4]);
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (ChannelConnectionException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		}
	}
}
