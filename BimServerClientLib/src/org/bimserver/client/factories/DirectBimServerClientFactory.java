package org.bimserver.client.factories;

import org.bimserver.client.BimServerClient;
import org.bimserver.plugins.PluginManager;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.exceptions.ServiceException;

public class DirectBimServerClientFactory implements BimServerClientFactory {

	private final PluginManager pluginManager;
	private final String username;
	private final String password;
	private final ServiceInterface serviceInterface;

	public DirectBimServerClientFactory(ServiceInterface serviceInterface, String username, String password) {
		this.serviceInterface = serviceInterface;
		this.username = username;
		this.password = password;
		pluginManager = new PluginManager();
		pluginManager.loadPluginsFromCurrentClassloader();
	}

	public DirectBimServerClientFactory(ServiceInterface serviceInterface, String username, String password, PluginManager pluginManager) {
		this.serviceInterface = serviceInterface;
		this.username = username;
		this.password = password;
		this.pluginManager = pluginManager;
	}

	@Override
	public BimServerClient create() throws ServiceException {
		BimServerClient bimServerClient = new BimServerClient(pluginManager);
		bimServerClient.connectDirect(serviceInterface);
		bimServerClient.login(username, password);
		return bimServerClient;
	}
}