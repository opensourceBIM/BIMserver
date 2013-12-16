package org.bimserver;

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
