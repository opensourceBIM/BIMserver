package org.bimserver.tests;

import java.io.File;

import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;

public class PluginTester {
	public static void main(String[] args) {
		PluginManager pluginManager = new PluginManager();
		try {
			pluginManager.loadPluginsFromEclipseProject(new File("../CityGML"));
		} catch (PluginException e) {
			e.printStackTrace();
		}
	}
}
