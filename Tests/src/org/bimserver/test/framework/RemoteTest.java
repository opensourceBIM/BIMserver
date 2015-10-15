package org.bimserver.test.framework;

import java.nio.file.Paths;

import org.bimserver.plugins.OptionsParser;
import org.bimserver.test.framework.RandomBimServerClientFactory.Type;
import org.bimserver.test.framework.actions.AllActionsFactory;

public class RemoteTest {
	public static void main(String[] args) {
		TestConfiguration testConfiguration = new TestConfiguration();
		TestFramework testFramework = new TestFramework(testConfiguration, new OptionsParser(args).getPluginDirectories());

		testConfiguration.setHomeDir(Paths.get("/opt/bimservertest"));
		testConfiguration.setActionFactory(new AllActionsFactory(testFramework));
		testConfiguration.setBimServerClientFactory(new RandomBimServerClientFactory(testFramework, Type.values()));
		testConfiguration.setTestFileProvider(new FolderWalker(Paths.get("/mnt/sata1/ifcselected"), testFramework));
		testConfiguration.setOutputFolder(Paths.get("/opt/output"));
		testConfiguration.setNrVirtualUsers(4);
		
		testFramework.start();
	}
}
