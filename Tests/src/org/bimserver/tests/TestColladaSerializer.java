package org.bimserver.tests;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.File;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class TestColladaSerializer {
	public static void main(String[] args) {
		new TestColladaSerializer().start();
	}

	private void start() {
		try {
			File testFiles = new File("../TestData/data");
			File output = new File("output");
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(new File("home"));
			
			DeserializerPlugin ifcDeserializerPlugin = pluginManager.getFirstDeserializer("ifc", true);
			
			SerializerPlugin serializerPlugin = pluginManager.getFirstSerializerPlugin("application/collada", true);
			for (File file : testFiles.listFiles()) {
				if (file.isFile() && file.getName().endsWith(".ifc") && file.getName().equals("Vogel_Gesamt.ifc")) {
					System.out.println(file.getName());
					ProjectInfo projectInfo = new ProjectInfo();
					projectInfo.setAuthorName("test");
					projectInfo.setDescription("");
					
					Deserializer ifcDeserializer = ifcDeserializerPlugin.createDeserializer();
					ifcDeserializer.init(pluginManager.requireSchemaDefinition());
					IfcModelInterface model = ifcDeserializer.read(file, true);

					Serializer serializer = serializerPlugin.createSerializer();
					serializer.init(model, projectInfo, pluginManager, pluginManager.requireIfcEngine().createIfcEngine(), false);
					serializer.writeToFile(new File(output, file.getName() + ".dae"));
				}
			}
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (DeserializeException e) {
			e.printStackTrace();
		} catch (SerializerException e) {
			e.printStackTrace();
		}
	}
}
