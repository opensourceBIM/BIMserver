package org.bimserver;

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

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class OptionsParser {
	private File gitDir;

	public OptionsParser(String... args) {
		Options options = new Options();

		options.addOption("git", true, "Directory from which to load git plugins");
		
		CommandLineParser parser = new BasicParser();
		gitDir = null;
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
	}
	
	public File getGitDir() {
		return gitDir;
	}
}
