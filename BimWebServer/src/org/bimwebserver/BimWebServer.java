package org.bimwebserver;

import java.util.Map;

import org.bimserver.client.factories.BimServerClientFactory;
import org.bimserver.shared.meta.SService;

public class BimWebServer {

	private final Map<String, SService> sServices;
	private BimServerClientFactory bimServerClientFactory;
	
	public BimWebServer(Map<String, SService> sServices) {
		this.sServices = sServices;
	}
	
	public Map<String, SService> getServicesInterfaces() {
		return sServices;
	}

	public SService getServiceInterface(String interfaceName) {
		return sServices.get(interfaceName);
	}

	public BimServerClientFactory getBimServerClientFactory() {
		return bimServerClientFactory;
	}

	public void setBimServerClientFactory(BimServerClientFactory bimServerClientFactory) {
		this.bimServerClientFactory = bimServerClientFactory;
	}
}