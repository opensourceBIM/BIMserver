package org.bimserver.client.factories;

import org.bimserver.client.BimServerClient;
import org.bimserver.plugins.PluginManager;
import org.bimserver.shared.exceptions.ServiceException;

public class SoapBimServerClientFactory implements BimServerClientFactory {

	private final PluginManager pluginManager;
	private final String username;
	private final String password;
	private final String address;

	public SoapBimServerClientFactory(String address, String username, String password) {
		this.address = address;
		this.username = username;
		this.password = password;
		pluginManager = new PluginManager();
		pluginManager.loadPluginsFromCurrentClassloader();
	}

	public SoapBimServerClientFactory(String address, String username, String password, PluginManager pluginManager) {
		this.address = address;
		this.username = username;
		this.password = password;
		this.pluginManager = pluginManager;
	}

	@Override
	public BimServerClient create() throws ServiceException {
		BimServerClient bimServerClient = new BimServerClient(pluginManager);
		bimServerClient.connectSoap(address, false);
		bimServerClient.login(username, password);
		return bimServerClient;
	}
}