package org.bimserver.test.framework.tests;

import java.io.File;

import org.bimserver.test.framework.FolderWalker;
import org.bimserver.test.framework.RandomBimServerClientFactory;
import org.bimserver.test.framework.RandomBimServerClientFactory.Type;
import org.bimserver.test.framework.TestConfiguration;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.actions.AllActionsFactory;

public class TestJson {
	public static void main(String[] args) {
		TestConfiguration testConfiguration = new TestConfiguration();
		TestFramework testFramework = new TestFramework(testConfiguration);

		testConfiguration.setHomeDir(new File("G:\\Testing"));
		testConfiguration.setCleanEnvironmentFirst(true);
		testConfiguration.setActionFactory(new AllActionsFactory(testFramework));
		testConfiguration.setBimServerClientFactory(new RandomBimServerClientFactory(testFramework, Type.JSON_SESSION_BASED));
		testConfiguration.setTestFileProvider(new FolderWalker(new File("G:\\Ifc Files"), testFramework));
		testConfiguration.setOutputFolder(new File("G:\\Output"));
		testConfiguration.setNrVirtualUsers(8);
		
		testFramework.start();
	}
}