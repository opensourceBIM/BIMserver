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
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class IfcXmlReadTest {
	public static void main(String[] args) {
		new IfcXmlReadTest().start();
	}

	private void start() {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(new File("home"));
			DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifcxml", true);
			Deserializer deserializer = deserializerPlugin.createDeserializer();
			try {
				File file = TestFile.AC11_XML.getFile();
				IfcModelInterface model = deserializer.read(new FileInputStream(file), "ac11.ifcxml", false, file.length());
				
				File outFile = new File("out.ifc");
				SerializerPlugin serializerPlugin = pluginManager.getFirstSerializerPlugin("application/ifc", true);
				Serializer serializer = serializerPlugin.createSerializer();
				serializer.init(model, null, pluginManager, pluginManager.requireIfcEngine().createIfcEngine(), false);
				try {
					serializer.writeToFile(outFile);
				} catch (SerializerException e) {
					e.printStackTrace();
				}
				
				DeserializerPlugin deserializerPlugin2 = pluginManager.getFirstDeserializer("ifc", true);
				Deserializer deserializer2 = deserializerPlugin2.createDeserializer();
				deserializer2.init(pluginManager.requireSchemaDefinition());
				deserializer2.read(outFile, true);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (PluginException e1) {
			e1.printStackTrace();
		}
	}
}