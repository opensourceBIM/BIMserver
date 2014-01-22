package org.bimserver.tests;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;

import com.javamex.classmexer.MemoryUtil;

public class TestSize {
	public static void main(String[] args) {
		new TestSize().start();
	}

	private void start() {
		try {
			final PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(new File("home"));
			final DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", true);

			Deserializer deserializer = deserializerPlugin.createDeserializer(new PluginConfiguration());
			deserializer.init(pluginManager.getFirstSchemaPlugin(true).getSchemaDefinition(new PluginConfiguration()));
			IfcModelInterface model = deserializer.read(TestFile.AC11.getFile());
			System.out.println("Nr Objects: " + model.size());
			System.out.println("Memory: " + MemoryUtil.deepMemoryUsageOf(model));
			while (true) {
				Thread.sleep(1000);
			}
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (DeserializeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
