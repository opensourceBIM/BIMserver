package org.bimserver;

import java.io.File;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.webservices.authorization.AdminAuthorization;

public class Test {
	public static void main(String[] args) {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(new File("home"));
			MetaDataManager metaDataManager = new MetaDataManager(pluginManager);
			pluginManager.setMetaDataManager(metaDataManager);
			JsonBimServerClientFactory factory = new JsonBimServerClientFactory(metaDataManager, "http://ec.logic-labs.nl");
			BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@elassticbim.eu", "GIWSELOVSlSWaQ7dSlkp"));
			client.getServiceInterface().importData("http://elassticbim.eu", "admin@elassticbim.eu", "GIWSELOVSlSWaQ7dSlkp", "/var/incoming");
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
