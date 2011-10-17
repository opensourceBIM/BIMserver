package org.bimserver.client.factories;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ConnectionException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.shared.exceptions.ServiceException;

public class ProtocolBuffersBimServerClientFactory implements BimServerClientFactory {

	private final PluginManager pluginManager;
	private final String address;
	private final int port;

	public ProtocolBuffersBimServerClientFactory(String address, int port) {
		this.address = address;
		this.port = port;
		pluginManager = new PluginManager();
		pluginManager.loadPluginsFromCurrentClassloader();
	}

	public ProtocolBuffersBimServerClientFactory(String address, int port, PluginManager pluginManager) {
		this.address = address;
		this.port = port;
		this.pluginManager = pluginManager;
	}

	@Override
	public BimServerClient create(AuthenticationInfo authenticationInfo, String remoteAddress) throws ServiceException, ConnectionException {
		BimServerClient bimServerClient = new BimServerClient(pluginManager);
		bimServerClient.setAuthentication(authenticationInfo);
		bimServerClient.connectProtocolBuffers(address, port);
		return bimServerClient;
	}
}