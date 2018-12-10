package org.bimserver;

import java.net.MalformedURLException;

import org.bimserver.plugins.OptionsParser;
import org.bimserver.plugins.ResourceFetcher;
import org.bimserver.resources.ClasspathResourceFetcher;

/**
 * @author Ruben de Laat
 *
 *	Use this class to start a BIMserver in your development environment when you have not checked-out the BIMserver source code, but simply linked to it from your pom.xml
 *	There is a slight difference to LocalDevBimServerStarter since some resources need to be loaded from a JAR file and not from regular files on disk
 *
 */
public class LocalDevBimServerStarterJar extends AbstractLocalDevBimServerStarter {
	public static void main(String[] args) {
		OptionsParser optionsParser = new OptionsParser(args);
		ResourceFetcher resourceFetcher = new ClasspathResourceFetcher();
		
		try {
			String resourceBase = resourceFetcher.getURL("www").toExternalForm();
			new LocalDevBimServerStarterJar().start(-1, "127.0.0.1", "LocalDev BIMserver (8080)", 8080, 8085, optionsParser.getPluginDirectories(), optionsParser.getHome(), resourceFetcher, resourceBase);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
