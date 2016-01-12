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
import org.bimserver.test.framework.RandomBimServerClientFactory;
import org.bimserver.test.framework.RandomBimServerClientFactory.Type;
import org.bimserver.test.framework.TestConfiguration;
import org.bimserver.test.framework.TestFramework;

public class TestCollada {
	public static void main(String[] args) {
		TestConfiguration testConfiguration = new TestConfiguration();
		TestFramework testFramework = new TestFramework(testConfiguration, new OptionsParser(args).getPluginDirectories());

		testConfiguration.setCleanEnvironmentFirst(true);
		testConfiguration.setNrVirtualUsers(1);
		testConfiguration.setNrRunsPerVirtualUser(50);
		testConfiguration.setStartEmbeddedBimServer(true);
		testConfiguration.setStopOnServerException(true);
		testConfiguration.setStopOnUserException(false);
//		testConfiguration.setActionFactory(new RandomActionFactory(new CheckinAction(testFramework, new CheckinSettings()), new DownloadRevisionAction(testFramework, "Collada")));
		testConfiguration.setOutputFolder(Paths.get("output"));
		testConfiguration.setBimServerClientFactory(new RandomBimServerClientFactory(testFramework, Type.SOAP));

		testFramework.start();
	}
}