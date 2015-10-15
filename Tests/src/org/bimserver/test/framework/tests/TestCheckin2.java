package org.bimserver.test.framework.tests;

import java.nio.file.Paths;

import org.bimserver.plugins.OptionsParser;
import org.bimserver.test.framework.FolderWalker;
import org.bimserver.test.framework.RandomBimServerClientFactory;
import org.bimserver.test.framework.RandomBimServerClientFactory.Type;
import org.bimserver.test.framework.TestConfiguration;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.actions.Action;
import org.bimserver.test.framework.actions.ActionCreater;
import org.bimserver.test.framework.actions.AddUserToProjectAction;
import org.bimserver.test.framework.actions.CheckinAction;
import org.bimserver.test.framework.actions.CheckinSettings;
import org.bimserver.test.framework.actions.CreateProjectAction;
import org.bimserver.test.framework.actions.CreateSubProjectAction;
import org.bimserver.test.framework.actions.CreateUserAction;
import org.bimserver.test.framework.actions.LoginAction;
import org.bimserver.test.framework.actions.LogoutAction;
import org.bimserver.test.framework.actions.RandomActionFactory;

public class TestCheckin2 {
	public static void main(String[] args) {
		TestConfiguration testConfiguration = new TestConfiguration();
		final TestFramework testFramework = new TestFramework(testConfiguration, new OptionsParser(args).getPluginDirectories());
		testConfiguration.setStopNoVirtualUsers(false);
//		testConfiguration.setNrRunsPerVirtualUser(30);

		testConfiguration.setHomeDir(Paths.get("D:\\Testing"));
		testConfiguration.setActionFactory(new RandomActionFactory(
			new ActionCreater(){
				public Action create() {
					return new LogoutAction(testFramework);
				}
			}, 
			new ActionCreater(){
				public Action create() {
					return new LoginAction(testFramework);
				}
			}, 
			new ActionCreater(){
				public Action create() {
					return new CreateUserAction(testFramework);
				}
			}, 
			new ActionCreater(){
				public Action create() {
					return new AddUserToProjectAction(testFramework);
				}
			}, 
			new ActionCreater(){
				public Action create() {
					return new CreateProjectAction(testFramework);
				}
			}, 
			new ActionCreater(){
				public Action create() {
					return new CreateSubProjectAction(testFramework);
				}
			}, 
			new ActionCreater(6){
				public Action create() {
					return new CheckinAction(testFramework, new CheckinSettings());
				}
			} 
		));
//		testConfiguration.setActionFactory(new AllActionsFactory(testFramework));
		testConfiguration.setBimServerClientFactory(new RandomBimServerClientFactory(testFramework, Type.SOAP, Type.PROTOCOL_BUFFERS, Type.JSON));
		testConfiguration.setTestFileProvider(new FolderWalker(Paths.get("D:\\ifc selected"), testFramework));
//		testConfiguration.setTestFileProvider(new FolderWalker(new File("C:\\Users\\Ruben de Laat\\Documents\\My Dropbox\\Logic Labs\\Clients\\TNO\\ifc selected")));
		testConfiguration.setOutputFolder(Paths.get("D:\\output"));
		testConfiguration.setNrVirtualUsers(5);
		
		testFramework.start();
	}
}