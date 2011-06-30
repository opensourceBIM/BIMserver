package org.bimserver.tests;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ifcengine.IfcEngine;
import org.bimserver.plugins.ifcengine.IfcEnginePlugin;

public class IfcEngineTest {
	public static void main(String[] args) {
		new IfcEngineTest().start();
	}

	private void start() {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager();
			IfcEnginePlugin ifcEnginePlugin = pluginManager.requireIfcEngine();
			IfcEngine ifcEngine = ifcEnginePlugin.createIfcEngine();
			ifcEngine.close();
		} catch (PluginException e) {
			e.printStackTrace();
		}
	}
}
