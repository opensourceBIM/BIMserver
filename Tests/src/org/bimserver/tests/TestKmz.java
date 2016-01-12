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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.nio.file.Paths;
import java.util.Collection;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.exceptions.PluginException;

public class TestKmz {
	public static void main(String[] args) {
		new TestKmz().start();
	}

	private void start() {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(Paths.get("home"));
			SerializerPlugin plugin = pluginManager.getSerializerPlugin("org.bimserver.collada.KmzSerializerPlugin", true);
			Serializer serializer = plugin.createSerializer(new PluginConfiguration());
			Collection<DeserializerPlugin> allDeserializerPlugins = pluginManager.getAllDeserializerPlugins("ifc", true);
			// IfcEnginePlugin ifcEngine =
			// pluginManager.getIfcEngine("org.ifcopenshell.IfcOpenShellEnginePlugin",
			// true);
			if (!allDeserializerPlugins.isEmpty()) {
				DeserializerPlugin deserializerPlugin = allDeserializerPlugins.iterator().next();
				Deserializer deserializer = deserializerPlugin.createDeserializer(new PluginConfiguration());
				deserializer.init(pluginManager.getMetaDataManager().getPackageMetaData("ifc2x3tc1"));
				IfcModelInterface model = deserializer.read(TestFile.WALL_ONLY.getFile());
				// IfcModelInterface model =
				// deserializer.read(TestFile.ADTHAUS.getFile(), true);
				serializer.init(model, null, pluginManager, null, false);
				serializer.writeToFile(Paths.get("output/ac11.kmz"), null);
			}
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (SerializerException e) {
			e.printStackTrace();
		} catch (DeserializeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}