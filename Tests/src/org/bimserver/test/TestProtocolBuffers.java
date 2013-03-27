package org.bimserver.test;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ChannelConnectionException;
import org.bimserver.client.SoapBimServerClientFactory;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServiceException;

public class TestProtocolBuffers {
	public static void main(String[] args) {
		SoapBimServerClientFactory factory = new SoapBimServerClientFactory("http://localhost:8080");
		try {
			BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			client.getService().getAllProjects(true);
		} catch (ServiceException | ChannelConnectionException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		}
	}
}
