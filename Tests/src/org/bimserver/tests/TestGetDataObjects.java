package org.bimserver.tests;

import java.util.List;

import org.bimserver.LocalDevSetup;
import org.bimserver.interfaces.objects.SDataObject;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;

public class TestGetDataObjects {
	public static void main(String[] args) {
		new TestGetDataObjects().start();
	}

	private void start() {
		try {
			BimServerClientInterface client = LocalDevSetup.setupJson("http://localhost:8080");
			long roid = 262147l;
			List<SDataObject> dataObjects = client.getBimsie1LowLevelInterface().getDataObjects(roid);
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		}
	}
}
