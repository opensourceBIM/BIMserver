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
import java.util.List;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.eclipse.emf.ecore.EStructuralFeature;

public class LargeFileTest {
	public static void main(String[] args) {
		new LargeFileTest().start();
	}

	@SuppressWarnings("rawtypes")
	private void start() {
		PluginManager pluginManager;
		try {
			pluginManager = LocalDevPluginLoader.createPluginManager(new File("home"));
			DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", true);
			Deserializer deserializer = deserializerPlugin.createDeserializer();
			deserializer.init(pluginManager.requireSchemaDefinition());
			IfcModelInterface model = deserializer.read(new File("C:\\Users\\Ruben de Laat\\Documents\\My Dropbox\\Shared\\BIMserver\\arcadis\\KW02.ifc"), true);
			for (IdEObject idEObject : model.getValues()) {
				for (EStructuralFeature eStructuralFeature : idEObject.eClass().getEAllStructuralFeatures()) {
					if (eStructuralFeature.isMany()) {
						List list = (List) idEObject.eGet(eStructuralFeature);
						if (list.size() > 1000) {
							System.out.println(idEObject.getOid() + " " + idEObject.eClass().getName() + " " + eStructuralFeature.getName() + ": " + list.size());
						}
					}
				}
			}
		} catch (PluginException e1) {
			e1.printStackTrace();
		} catch (DeserializeException e) {
			e.printStackTrace();
		}
	}
}