package org.bimserver.test.framework;

import org.bimserver.test.framework.actions.ActionFactory;

public class VirtualUserFactory {
	private final RandomBimServerClientFactory randomBimServerClientFactory;
	private final TestFramework testFramework;
	private ActionFactory actionFactory;

	public VirtualUserFactory(TestFramework testFramework, RandomBimServerClientFactory randomBimServerClientFactory) {
		this.testFramework = testFramework;
		this.randomBimServerClientFactory = randomBimServerClientFactory;
		new ActionFactory(testFramework);
	}

	public VirtualUser create(String name) {
		return new VirtualUser(testFramework, randomBimServerClientFactory.create(), actionFactory, name);
	}
}
