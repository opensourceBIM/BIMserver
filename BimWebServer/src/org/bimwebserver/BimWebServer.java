package org.bimwebserver;

import org.bimserver.client.factories.BimServerClientFactory;
import org.bimserver.shared.meta.SService;
import org.bimserver.shared.meta.ServicesMap;

public class BimWebServer {

	private final ServicesMap servicesMap;
	private BimServerClientFactory bimServerClientFactory;
	
	public BimWebServer(ServicesMap servicesMap) {
		this.servicesMap = servicesMap;
	}
	
	public ServicesMap getServicesMap() {
		return servicesMap;
	}

	public SService getServiceInterface(String interfaceName) {
		return servicesMap.get(interfaceName);
	}

	public BimServerClientFactory getBimServerClientFactory() {
		return bimServerClientFactory;
	}

	public void setBimServerClientFactory(BimServerClientFactory bimServerClientFactory) {
		this.bimServerClientFactory = bimServerClientFactory;
	}
}