package org.bimserver.client;

import org.bimserver.client.factories.BimServerClientFactory;
import org.bimserver.shared.meta.ServicesMap;

public abstract class AbstractBimServerClientFactory implements BimServerClientFactory {

	private ServicesMap servicesMap;

	public AbstractBimServerClientFactory(ServicesMap servicesMap) {
		this.servicesMap = servicesMap;
	}
	
	public ServicesMap getServicesMap() {
		return servicesMap;
	}
}
