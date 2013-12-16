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

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.bimserver.test.framework.FolderWalker;
import org.bimserver.test.framework.RandomBimServerClientFactory;
import org.bimserver.test.framework.RandomBimServerClientFactory.Type;
import org.bimserver.test.framework.TestConfiguration;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.actions.AllActionsFactory;

public class TestAll {
	public static void main(String[] args) {
		Options options = new Options();

		options.addOption("git", true, "Directory from which to load git plugins");
		
		CommandLineParser parser = new BasicParser();
		File gitDir = null;
		try {
			CommandLine cmd = parser.parse(options, args);
			if (cmd.hasOption("git")) {
				String gitString = cmd.getOptionValue("git");
				gitDir = new File(gitString);
				if (!gitDir.isDirectory()) {
					throw new RuntimeException("git parameter must point to a directory");
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		TestConfiguration testConfiguration = new TestConfiguration();
		TestFramework testFramework = new TestFramework(testConfiguration, gitDir);

		testConfiguration.setHomeDir(new File("E:\\Test"));
		testConfiguration.setActionFactory(new AllActionsFactory(testFramework));
		testConfiguration.setBimServerClientFactory(new RandomBimServerClientFactory(testFramework, Type.JSON));
		testConfiguration.setTestFileProvider(new FolderWalker(new File("E:\\Ifc Files"), testFramework));
		testConfiguration.setOutputFolder(new File("E:\\Output"));
		testConfiguration.setNrVirtualUsers(3);

		testFramework.start();
	}
}