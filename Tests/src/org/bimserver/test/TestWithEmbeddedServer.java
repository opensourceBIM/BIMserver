package org.bimserver.test;

import org.bimserver.BimServer;
import org.bimserver.shared.BimServerClientFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class TestWithEmbeddedServer {

	@BeforeClass
	public static void beforeClass() {
	}
	
	public BimServer getBimServer() {
		return AllTests.getBimServer();
	}
	
	public BimServerClientFactory getFactory() {
		return AllTests.getFactory();
	}
	
	@AfterClass
	public static void afterClass() {
		if (!AllTests.running) {
			AllTests.resetBimServer();
		}
	}
}