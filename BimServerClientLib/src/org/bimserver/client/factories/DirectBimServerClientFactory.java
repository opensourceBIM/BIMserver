package org.bimserver.client.factories;

import org.bimserver.client.BimServerClient;
import org.bimserver.plugins.PluginManager;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.exceptions.ServiceException;

public class DirectBimServerClientFactory implements BimServerClientFactory {

	private final PluginManager pluginManager;
	private final ServiceInterface serviceInterface;

	public DirectBimServerClientFactory(ServiceInterface serviceInterface) {
		this.serviceInterface = serviceInterface;
		pluginManager = new PluginManager();
		pluginManager.loadPluginsFromCurrentClassloader();
	}

	public DirectBimServerClientFactory(ServiceInterface serviceInterface, PluginManager pluginManager) {
		this.serviceInterface = serviceInterface;
		this.pluginManager = pluginManager;
	}

	@Override
	public BimServerClient create(AuthenticationInfo authenticationInfo, String remoteAddress) throws ServiceException {
		BimServerClient bimServerClient = new BimServerClient(pluginManager);
		bimServerClient.setAuthentication(authenticationInfo);
		bimServerClient.connectDirect(serviceInterface);
		return bimServerClient;
	}
}