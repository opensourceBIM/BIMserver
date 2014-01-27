package org.bimserver.test.framework.tests;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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

		testConfiguration.setHomeDir(new File("C:\\Test"));
		testConfiguration.setActionFactory(new AllActionsFactory(testFramework));
		testConfiguration.setBimServerClientFactory(new RandomBimServerClientFactory(testFramework, Type.PROTOCOL_BUFFERS));
		testConfiguration.setTestFileProvider(new TestFileProvider() {
			
			@Override
			public File getNewFile() {
				return new File(TestFileConstants.DATA_FOLDER, "AC11-Institute-Var-2-IFC.ifc");
			}
		});
		testConfiguration.setOutputFolder(new File("output"));
		testConfiguration.setNrVirtualUsers(2);
		
		testFramework.start();
	}
}