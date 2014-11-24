package org.bimserver.tests;

import java.util.List;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SDataObject;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServiceException;

public class TestGetDataObjects {
	public static void main(String[] args) {
		new TestGetDataObjects().start();
	}

	private void start() {
		JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080");
		try {
			BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			long roid = 262147l;
			List<SDataObject> dataObjects = client.getBimsie1LowLevelInterface().getDataObjects(roid);
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (ChannelConnectionException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		}
	}
}
