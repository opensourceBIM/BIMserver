package org.bimserver.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.OptionsParser;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.renderengine.IndexFormat;
import org.bimserver.plugins.renderengine.Precision;
import org.bimserver.plugins.renderengine.RenderEngine;
import org.bimserver.plugins.renderengine.RenderEngineModel;
import org.bimserver.plugins.renderengine.RenderEnginePlugin;
import org.bimserver.plugins.renderengine.RenderEngineSettings;

public class TestGen {
	public static void main(String[] args) {
		new TestGen().start(args);
	}

	private void start(String[] args) {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(new File("home"), new OptionsParser(args).getPluginDirectories());
			DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", true);
			Deserializer deserializer = deserializerPlugin.createDeserializer(null);
			deserializer.init(pluginManager.getMetaDataManager().getPackageMetaData("ifc2x3tc1"));
			IfcModelInterface model = deserializer.read(new File("../TestData/data/HITOS_070308.ifc"));
			
			RenderEnginePlugin renderEnginePlugin = pluginManager.getRenderEngine("org.bimserver.ifcengine.JvmRenderEnginePlugin", true);
			RenderEngine renderEngine = renderEnginePlugin.createRenderEngine(null, "ifc2x3tc1");
			renderEngine.init();
			RenderEngineModel renderEngineModel = renderEngine.openModel(new FileInputStream(new File("../TestData/data/AC11-Institute-Var-2-IFC.ifc")));
			RenderEngineSettings settings = new RenderEngineSettings();
			settings.setPrecision(Precision.SINGLE);
			settings.setIndexFormat(IndexFormat.AUTO_DETECT);
			settings.setGenerateNormals(true);
			settings.setGenerateTriangles(true);
			settings.setGenerateWireFrame(false);
			renderEngineModel.setSettings(settings);
			renderEngineModel.generateGeneralGeometry();
			renderEngineModel.close();
			renderEngine.close();

			long start = System.nanoTime();
			long end = System.nanoTime();
			System.out.println(((end - start) / 1000000) + " ms");
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (DeserializeException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
