package org.bimserver.test.framework;

import java.io.File;

import org.bimserver.test.framework.RandomBimServerClientFactory.Type;
import org.bimserver.test.framework.actions.AllActionsFactory;

public class RemoteTest {
	public static void main(String[] args) {
		TestConfiguration testConfiguration = new TestConfiguration();
		TestFramework testFramework = new TestFramework(testConfiguration);

		testConfiguration.setHomeDir(new File("/opt/bimservertest"));
		testConfiguration.setActionFactory(new AllActionsFactory(testFramework));
		testConfiguration.setBimServerClientFactory(new RandomBimServerClientFactory(testFramework, Type.values()));
		testConfiguration.setTestFileProvider(new FolderWalker(new File("/mnt/sata1/ifcselected"), testFramework));
		testConfiguration.setOutputFolder(new File("/opt/output"));
		testConfiguration.setNrVirtualUsers(4);
		
		testFramework.start();
	}
}
