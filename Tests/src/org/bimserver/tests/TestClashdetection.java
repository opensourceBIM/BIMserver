package org.bimserver.tests;

import java.util.Set;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ifcengine.IfcEngine;
import org.bimserver.plugins.ifcengine.IfcEngineClash;
import org.bimserver.plugins.ifcengine.IfcEngineModel;
import org.bimserver.plugins.ifcengine.IfcEnginePlugin;

public class TestClashdetection {
	public static void main(String[] args) {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager();
			IfcEnginePlugin ifcEnginePlugin = pluginManager.getIfcEngine("org.bimserver.ifcengine.TNOIfcEnginePlugin", true);
			IfcEngine ifcEngine = ifcEnginePlugin.createIfcEngine();
			ifcEngine.init();
			IfcEngineModel openModel = ifcEngine.openModel(TestFile.AC11.getFile());
			Set<IfcEngineClash> findClashesWithGuids = openModel.findClashesWithGuids(0.0);
			System.out.println(findClashesWithGuids.size());
			openModel.close();
			ifcEngine.close();
		} catch (PluginException e) {
			e.printStackTrace();
		}
	}
}
