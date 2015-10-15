package org.bimserver.test.framework.tests;

import java.nio.file.Paths;

import org.bimserver.plugins.OptionsParser;
import org.bimserver.test.framework.RandomBimServerClientFactory;
import org.bimserver.test.framework.RandomBimServerClientFactory.Type;
import org.bimserver.test.framework.TestConfiguration;
import org.bimserver.test.framework.TestFramework;

public class TestCollada {
	public static void main(String[] args) {
		TestConfiguration testConfiguration = new TestConfiguration();
		TestFramework testFramework = new TestFramework(testConfiguration, new OptionsParser(args).getPluginDirectories());

		testConfiguration.setCleanEnvironmentFirst(true);
		testConfiguration.setNrVirtualUsers(1);
		testConfiguration.setNrRunsPerVirtualUser(50);
		testConfiguration.setStartEmbeddedBimServer(true);
		testConfiguration.setStopOnServerException(true);
		testConfiguration.setStopOnUserException(false);
//		testConfiguration.setActionFactory(new RandomActionFactory(new CheckinAction(testFramework, new CheckinSettings()), new DownloadRevisionAction(testFramework, "Collada")));
		testConfiguration.setOutputFolder(Paths.get("output"));
		testConfiguration.setBimServerClientFactory(new RandomBimServerClientFactory(testFramework, Type.SOAP));

		testFramework.start();
	}
}