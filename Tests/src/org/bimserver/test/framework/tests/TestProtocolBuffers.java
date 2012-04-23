package org.bimserver.test.framework.tests;

import java.io.File;

import org.bimserver.test.framework.FolderWalker;
import org.bimserver.test.framework.RandomBimServerClientFactory;
import org.bimserver.test.framework.TestConfiguration;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.RandomBimServerClientFactory.Type;
import org.bimserver.test.framework.actions.AllActionsFactory;
import org.bimserver.tests.TestFileConstants;

public class TestProtocolBuffers {
	public static void main(String[] args) {
		TestConfiguration testConfiguration = new TestConfiguration();
		TestFramework testFramework = new TestFramework(testConfiguration);

		testConfiguration.setHomeDir(new File("C:\\Test"));
		testConfiguration.setActionFactory(new AllActionsFactory(testFramework));
		testConfiguration.setBimServerClientFactory(new RandomBimServerClientFactory(testFramework, Type.PROTOCOL_BUFFERS));
		testConfiguration.setTestFileProvider(new FolderWalker(TestFileConstants.DATA_FOLDER, testFramework));
		testConfiguration.setOutputFolder(new File("output"));
		testConfiguration.setNrVirtualUsers(1);
		
		testFramework.start();
	}
}