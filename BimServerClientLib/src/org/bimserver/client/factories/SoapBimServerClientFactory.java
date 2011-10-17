package org.bimserver.client.factories;

import org.bimserver.client.BimServerClient;
import org.bimserver.plugins.PluginManager;
import org.bimserver.shared.exceptions.ServiceException;

public class SoapBimServerClientFactory implements BimServerClientFactory {

	private final PluginManager pluginManager;
	private final String address;

	public SoapBimServerClientFactory(String address) {
		this.address = address;
		pluginManager = new PluginManager();
		pluginManager.loadPluginsFromCurrentClassloader();
	}

	public SoapBimServerClientFactory(String address, PluginManager pluginManager) {
		this.address = address;
		this.pluginManager = pluginManager;
	}

	@Override
	public BimServerClient create(AuthenticationInfo authenticationInfo, String remoteAddress) throws ServiceException {
		BimServerClient bimServerClient = new BimServerClient(pluginManager);
		bimServerClient.setAuthentication(authenticationInfo);
		bimServerClient.connectSoap(address, false);
		return bimServerClient;
	}
}