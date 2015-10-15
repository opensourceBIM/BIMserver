package org.bimserver.plugins;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class OptionsParser {
	private Path[] pluginDirectories;

	public OptionsParser(String... args) {
		Options options = new Options();

		options.addOption("plugins", true, "Directory from which to load plugins");
		
		CommandLineParser parser = new BasicParser();
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
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public Path[] getPluginDirectories() {
		return pluginDirectories;
	}
}
