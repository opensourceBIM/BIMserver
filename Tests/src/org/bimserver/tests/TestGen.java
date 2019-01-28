package org.bimserver.tests;

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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.bimserver.LocalDevSetup;
import org.bimserver.emf.Schema;
import org.bimserver.plugins.PluginManagerInterface;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.renderengine.IndexFormat;
import org.bimserver.plugins.renderengine.Precision;
import org.bimserver.plugins.renderengine.RenderEngine;
import org.bimserver.plugins.renderengine.RenderEngineModel;
import org.bimserver.plugins.renderengine.RenderEnginePlugin;
import org.bimserver.plugins.renderengine.RenderEngineSettings;
import org.bimserver.shared.exceptions.PluginException;

public class TestGen {
	public static void main(String[] args) {
		new TestGen().start(args);
	}

	private void start(String[] args) {
		try {
			PluginManagerInterface pluginManager = LocalDevSetup.setupPluginManager(args);
			DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", Schema.IFC2X3TC1, true);
			Deserializer deserializer = deserializerPlugin.createDeserializer(null);
			deserializer.init(pluginManager.getMetaDataManager().getPackageMetaData("ifc2x3tc1"));
			
			RenderEnginePlugin renderEnginePlugin = pluginManager.getRenderEnginePlugin("org.bimserver.ifcengine.JvmRenderEnginePlugin", true);
			RenderEngine renderEngine = renderEnginePlugin.createRenderEngine(null, "ifc2x3tc1");
			renderEngine.init();
			Path path = Paths.get("../TestData/data/AC11-Institute-Var-2-IFC.ifc");
			RenderEngineModel renderEngineModel = renderEngine.openModel(new FileInputStream(path.toFile()), Files.size(path));
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
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
