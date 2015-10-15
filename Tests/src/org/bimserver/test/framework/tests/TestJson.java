package org.bimserver.test.framework.tests;

import java.nio.file.Paths;

import org.bimserver.plugins.OptionsParser;
import org.bimserver.test.framework.FolderWalker;
import org.bimserver.test.framework.RandomBimServerClientFactory;
import org.bimserver.test.framework.RandomBimServerClientFactory.Type;
import org.bimserver.test.framework.TestConfiguration;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.actions.AllActionsFactory;

public class TestJson {
	public static void main(String[] args) {
		TestConfiguration testConfiguration = new TestConfiguration();
		TestFramework testFramework = new TestFramework(testConfiguration, new OptionsParser(args).getPluginDirectories());

		testConfiguration.setHomeDir(Paths.get("G:\\Testing"));
		testConfiguration.setCleanEnvironmentFirst(true);
		testConfiguration.setActionFactory(new AllActionsFactory(testFramework));
		testConfiguration.setBimServerClientFactory(new RandomBimServerClientFactory(testFramework, Type.JSON));
		testConfiguration.setTestFileProvider(new FolderWalker(Paths.get("G:\\Ifc Files"), testFramework));
		testConfiguration.setOutputFolder(Paths.get("G:\\Output"));
		testConfiguration.setNrVirtualUsers(8);
		
		testFramework.start();
	}
}