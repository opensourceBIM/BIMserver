package org.bimserver.test.framework.tests;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

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