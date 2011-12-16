package org.bimserver.test.framework;

public class VirtualUserFactory {
	private final RandomBimServerClientFactory randomBimServerClientFactory;
	private final TestFramework testFramework;

	public VirtualUserFactory(TestFramework testFramework, RandomBimServerClientFactory randomBimServerClientFactory) {
		this.testFramework = testFramework;
		this.randomBimServerClientFactory = randomBimServerClientFactory;
	}

	public VirtualUser create(String name) {
		return new VirtualUser(testFramework, randomBimServerClientFactory.create(), name);
	}
}
