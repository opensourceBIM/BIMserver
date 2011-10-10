package org.bimserver.client.factories;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ConnectionException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.shared.exceptions.ServiceException;

public class ProtocolBuffersBimServerClientFactory implements BimServerClientFactory {

	private final PluginManager pluginManager;
	private final String username;
	private final String password;
	private final String address;
	private final int port;

	public ProtocolBuffersBimServerClientFactory(String address, int port, String username, String password) {
		this.address = address;
		this.port = port;
		this.username = username;
		this.password = password;
		pluginManager = new PluginManager();
		pluginManager.loadPluginsFromCurrentClassloader();
	}

	public ProtocolBuffersBimServerClientFactory(String address, int port, String username, String password, PluginManager pluginManager) {
		this.address = address;
		this.port = port;
		this.username = username;
		this.password = password;
		this.pluginManager = pluginManager;
	}

	@Override
	public BimServerClient create() throws ServiceException, ConnectionException {
		BimServerClient bimServerClient = new BimServerClient(pluginManager);
		bimServerClient.connectProtocolBuffers(address, port);
		bimServerClient.login(username, password);
		return bimServerClient;
	}
}