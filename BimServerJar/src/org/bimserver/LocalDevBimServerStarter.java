package org.bimserver;

import java.nio.file.Paths;

import org.bimserver.plugins.OptionsParser;
import org.bimserver.plugins.ResourceFetcher;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;

/**
 * @author Ruben de Laat
 *
 *	Use this class to start a BIMserver in your development environment when you have all the BIMserver source code checked out
 *
 */
public class LocalDevBimServerStarter extends AbstractLocalDevBimServerStarter {
	
	public static void main(String[] args) {
		OptionsParser optionsParser = new OptionsParser(args);
		ResourceFetcher resourceFetcher = new LocalDevelopmentResourceFetcher(Paths.get("../"));
		new LocalDevBimServerStarter().start(-1, "127.0.0.1", "LocalDev BIMserver (8080)", 8080, 8085, optionsParser.getPluginDirectories(), optionsParser.getHome(), resourceFetcher, Paths.get("../BimServer").resolve("www").toAbsolutePath().toString(), true);
	}
}