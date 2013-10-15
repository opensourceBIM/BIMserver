package org.bimserver.tests.utils;

import org.bimserver.BimServer;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.tests.AllTests;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class TestWithEmbeddedServer {
	private static BimServer bimServer;
	private static BimServerClientFactory factory;

	@BeforeClass
	public static void beforeClass() {
		bimServer = AllTests.getBimServer();
		factory = AllTests.getFactory();
	}
	
	public BimServer getBimServer() {
		return bimServer;
	}
	
	public BimServerClientFactory getFactory() {
		return factory;
	}
	
	@AfterClass
	public static void afterClass() {
		if (!AllTests.running) {
			bimServer.stop();
		}
	}
}