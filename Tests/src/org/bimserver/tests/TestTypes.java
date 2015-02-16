package org.bimserver.tests;

import org.bimserver.LocalDevSetup;
import org.bimserver.interfaces.objects.SServiceType;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;

public class TestTypes {
	public static void main(String[] args) {
		new TestTypes().start();
	}

	private void start() {
		try {
			BimServerClientInterface client = LocalDevSetup.setupJson("http://localhost:8080");
			for (SServiceType serviceType : client.getMeta().getServiceTypes()) {
				System.out.println(serviceType.getSimpleName());
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		}
	}
}
