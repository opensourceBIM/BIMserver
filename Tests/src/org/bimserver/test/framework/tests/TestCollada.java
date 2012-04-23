package org.bimserver.test.framework.tests;

import java.io.File;

import org.bimserver.test.framework.RandomBimServerClientFactory;
import org.bimserver.test.framework.TestConfiguration;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.RandomBimServerClientFactory.Type;

public class TestCollada {
	public static void main(String[] args) {
		TestConfiguration testConfiguration = new TestConfiguration();
		TestFramework testFramework = new TestFramework(testConfiguration);

		testConfiguration.setCleanEnvironmentFirst(true);
		testConfiguration.setNrVirtualUsers(1);
		testConfiguration.setNrRunsPerVirtualUser(50);
		testConfiguration.setStartEmbeddedBimServer(true);
		testConfiguration.setStopOnServerException(true);
		testConfiguration.setStopOnUserException(false);
//		testConfiguration.setActionFactory(new RandomActionFactory(new CheckinAction(testFramework, new CheckinSettings()), new DownloadRevisionAction(testFramework, "Collada")));
		testConfiguration.setOutputFolder(new File("output"));
		testConfiguration.setBimServerClientFactory(new RandomBimServerClientFactory(testFramework, Type.SOAP_NO_HEADERS));

		testFramework.start();
	}
}