package org.bimserver.test.framework;

import java.io.File;

import org.bimserver.test.framework.RandomBimServerClientFactory.Type;
import org.bimserver.test.framework.actions.CheckinAction;
import org.bimserver.test.framework.actions.CheckinSettings;
import org.bimserver.test.framework.actions.FixedActionFactory;

public class TestAll {
	public static void main(String[] args) {
		TestConfiguration testConfiguration = new TestConfiguration();
		TestFramework testFramework = new TestFramework(testConfiguration);

		testConfiguration.setHomeDir(new File("G:\\Test"));
		testConfiguration.setActionFactory(new FixedActionFactory(new CheckinAction(testFramework, new CheckinSettings())));
//		testConfiguration.setActionFactory(new AllActionsFactory(testFramework));
		testConfiguration.setBimServerClientFactory(new RandomBimServerClientFactory(testFramework, Type.values()));
		testConfiguration.setIfcFilesFolder(new File("C:\\Users\\Ruben de Laat\\Dropbox\\Logic Labs\\Clients\\TNO\\ifc selected"));
		testConfiguration.setOutputFolder(new File("output"));
		testConfiguration.setNrVirtualUsers(8);
		
		testFramework.start();
	}
}