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
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;

public class TestDeserializer {
	public static void main(String[] args) {
		new TestDeserializer().start();
	}

	private void start() {
		try {
			final PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(new File("home"));
			final DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", true);

			Deserializer deserializer = deserializerPlugin.createDeserializer();
			deserializer.init(pluginManager.getFirstSchemaPlugin(true).getSchemaDefinition());
			IfcModelInterface model = deserializer.read(new File("C:\\Users\\Ruben de Laat\\Dropbox\\Shared\\BIMserver\\Atrium%20Offices%20-%20PROJETO_EXECUTIVO%20-%202012.05.03.ifc"), true);
			
			for (IdEObject idEObject : model.getValues()) {
				System.out.println(idEObject);
			}
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (DeserializeException e) {
			e.printStackTrace();
		}
	}
}