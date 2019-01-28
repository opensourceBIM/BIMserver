package org.bimserver.plugins;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class OptionsParser {
	private Path[] pluginDirectories;
	private Path home;

	public OptionsParser(String... args) {
		Options options = new Options();

		options.addOption("plugins", true, "Directory from which to load a plugin bundle, can be used multiple times for different plugin bundles");
		options.addOption("home", true, "The home directory to use, default is [cwd]/home");
		
		CommandLineParser parser = new DefaultParser();
		pluginDirectories = null;
		try {
			CommandLine cmd = parser.parse(options, args);
			if (cmd.hasOption("plugins")) {
				String[] plugins = cmd.getOptionValues("plugins");
				pluginDirectories = new Path[plugins.length];
				for (int i=0; i<plugins.length; i++) {
					pluginDirectories[i] = Paths.get(plugins[i]);
					if (!Files.isDirectory(pluginDirectories[i])) {
						throw new RuntimeException("plugins parameter must point to a directory (" + pluginDirectories[i] + ")");
					}
				}
			}
			if (cmd.hasOption("home")) {
				home = Paths.get(cmd.getOptionValue("home"));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public Path[] getPluginDirectories() {
		return pluginDirectories;
	}
	
	public Path getHome() {
		return home;
	}
}