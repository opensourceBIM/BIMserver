package org.bimserver.test;

import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;

public class TestPorts {
	public static void main(String[] args) throws BimServerClientException, Exception {
		try (BimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080")) {
			try (BimServerClientInterface client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"))) {
				long roid = 262147;
				System.out.println(client.getLowLevelInterface().getDataObjectsByType(roid, "ifc2x3tc1", "IfcDistributionPort", true).size());
			}
		}
	}
}
