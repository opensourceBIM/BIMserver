package org.bimserver.test.framework.tests;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.bimserver.plugins.OptionsParser;
import org.bimserver.test.framework.RandomBimServerClientFactory;
import org.bimserver.test.framework.RandomBimServerClientFactory.Type;
import org.bimserver.test.framework.TestConfiguration;
import org.bimserver.test.framework.TestFileProvider;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.actions.AllActionsFactory;
import org.bimserver.tests.TestFileConstants;

public class TestProtocolBuffers {
	public static void main(String[] args) {
		TestConfiguration testConfiguration = new TestConfiguration();
		TestFramework testFramework = new TestFramework(testConfiguration, new OptionsParser(args).getPluginDirectories());

		testConfiguration.setHomeDir(Paths.get("C:\\Test"));
		testConfiguration.setActionFactory(new AllActionsFactory(testFramework));
		testConfiguration.setBimServerClientFactory(new RandomBimServerClientFactory(testFramework, Type.PROTOCOL_BUFFERS));
		testConfiguration.setTestFileProvider(new TestFileProvider() {
			
			@Override
			public Path getNewFile() {
				return TestFileConstants.DATA_FOLDER.resolve("AC11-Institute-Var-2-IFC.ifc")	;
			}
		});
		testConfiguration.setOutputFolder(Paths.get("output"));
		testConfiguration.setNrVirtualUsers(2);
		
		testFramework.start();
	}
}