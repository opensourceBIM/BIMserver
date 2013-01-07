package org.bimserver.test.framework.tests;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.File;

import org.bimserver.test.framework.FolderWalker;
import org.bimserver.test.framework.RandomBimServerClientFactory;
import org.bimserver.test.framework.TestConfiguration;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.RandomBimServerClientFactory.Type;
import org.bimserver.test.framework.actions.AllActionsFactory;

public class TestAll {
	public static void main(String[] args) {
		TestConfiguration testConfiguration = new TestConfiguration();
		TestFramework testFramework = new TestFramework(testConfiguration);

		testConfiguration.setHomeDir(new File("G:\\Test"));
		testConfiguration.setActionFactory(new AllActionsFactory(testFramework));
		testConfiguration.setBimServerClientFactory(new RandomBimServerClientFactory(testFramework, Type.JSON));
		testConfiguration.setTestFileProvider(new FolderWalker(new File("C:\\Users\\Ruben de Laat\\Dropbox\\Logic Labs\\Clients\\TNO\\ifc selected"), testFramework));
		testConfiguration.setOutputFolder(new File("G:\\Output"));
		testConfiguration.setNrVirtualUsers(6);
		
		testFramework.start();
	}
}