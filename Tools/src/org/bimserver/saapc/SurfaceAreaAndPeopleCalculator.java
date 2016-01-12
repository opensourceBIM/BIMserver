package org.bimserver.saapc;

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
import java.nio.file.Paths;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcRelContainedInSpatialStructure;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.utils.PathUtils;

public class SurfaceAreaAndPeopleCalculator {
	public static void main(String[] args) {
		new SurfaceAreaAndPeopleCalculator().start();
	}

	private void start() {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(Paths.get("home"));
			DeserializerPlugin ifcDeserializerPlugin = pluginManager.getDeserializerPlugin("org.bimserver.ifc.step.deserializer.Ifc2x3tc1StepDeserializerPlugin", true);
			Deserializer ifcDeserializer = ifcDeserializerPlugin.createDeserializer(null);
			ifcDeserializer.init(pluginManager.getMetaDataManager().getPackageMetaData("ifc2x3tc1"));
			java.nio.file.Path baseDirectory = Paths.get("C:\\Arch");
			for (java.nio.file.Path originalIfcFile : PathUtils.list(baseDirectory)) {
				processFile(ifcDeserializer, originalIfcFile);
			}
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (DeserializeException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void processFile(Deserializer ifcDeserializer, java.nio.file.Path originalIfcFile)
			throws DeserializeException {
		IfcModelInterface model = ifcDeserializer.read(originalIfcFile);
		for (IfcSpace ifcSpace : model.getAllWithSubTypes(IfcSpace.class)) {
			for (IfcRelContainedInSpatialStructure ifcRelContainedInSpatialStructure : ifcSpace.getContainsElements()) {
				ifcRelContainedInSpatialStructure.getRelatedElements();
			}
		}
	}
}
