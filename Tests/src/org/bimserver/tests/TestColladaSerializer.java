package org.bimserver.tests;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.Schema;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.utils.PathUtils;

public class TestColladaSerializer {
	public static void main(String[] args) {
		new TestColladaSerializer().start();
	}

	private void start() {
		try {
			Path testFiles = Paths.get("../TestData/data");
			Path output = Paths.get("output");
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(Paths.get("home"));
			
			DeserializerPlugin ifcDeserializerPlugin = pluginManager.getFirstDeserializer("ifc", Schema.IFC2X3TC1, true);
			
			SerializerPlugin serializerPlugin = pluginManager.getSerializerPlugin("org.bimserver.collada.ColladaSerializerPlugin", true);
			for (Path file : PathUtils.list(testFiles)) {
				if (!Files.isDirectory(file) && file.getFileName().toString().endsWith(".ifc") && file.getFileName().toString().equals("Vogel_Gesamt.ifc")) {
					System.out.println(file.getFileName().toString());
					ProjectInfo projectInfo = new ProjectInfo();
					projectInfo.setAuthorName("test");
					projectInfo.setDescription("");
					
					Deserializer ifcDeserializer = ifcDeserializerPlugin.createDeserializer(new PluginConfiguration());
					ifcDeserializer.init(pluginManager.getMetaDataManager().getPackageMetaData("ifc2x3tc1"));
					IfcModelInterface model = ifcDeserializer.read(file);

					Serializer serializer = serializerPlugin.createSerializer(new PluginConfiguration());
					serializer.init(model, projectInfo, pluginManager, null, false);
					serializer.writeToFile(output.resolve(file.getFileName().toString() + ".dae"), null);
				}
			}
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (DeserializeException e) {
			e.printStackTrace();
		} catch (SerializerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
