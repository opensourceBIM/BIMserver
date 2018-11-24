package org.bimserver.test;

import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;

public class LoginTwice {
	public static void main(String[] args) {
		new LoginTwice().start();
	}

	private void start() {
		try (BimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080")) {
			try (BimServerClientInterface client1 = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"))) {
				try (BimServerClientInterface client2 = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"))) {
					
				}
			}
		} catch (BimServerClientException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
