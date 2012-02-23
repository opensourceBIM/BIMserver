package org.bimserver.test.framework;

import org.bimserver.client.factories.UsernamePasswordAuthenticationInfo;
import org.bimserver.test.framework.actions.ActionFactory;

public class VirtualUserFactory {
	private final RandomBimServerClientFactory randomBimServerClientFactory;
	private final TestFramework testFramework;
	private ActionFactory actionFactory;

	public VirtualUserFactory(TestFramework testFramework, RandomBimServerClientFactory randomBimServerClientFactory) {
		this.testFramework = testFramework;
		this.randomBimServerClientFactory = randomBimServerClientFactory;
		this.actionFactory = new ActionFactory(testFramework);
	}

	public VirtualUser create(String name) {
		return new VirtualUser(testFramework, randomBimServerClientFactory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"), "localhost"), actionFactory, name);
	}
}