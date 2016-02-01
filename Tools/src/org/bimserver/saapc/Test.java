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

import java.nio.file.Paths;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.bimserver.LocalDevSetup;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.plugins.PluginManagerInterface;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.eclipse.emf.ecore.EObject;

public class Test {
	public static void main(String[] args) {
		new Test().start(args);
	}

	private void start(String[] args) {
		try {
			PluginManagerInterface pluginManager = LocalDevSetup.setupPluginManager(args);
			DeserializerPlugin ifcDeserializerPlugin = pluginManager.getDeserializerPlugin("org.bimserver.ifc.step.deserializer.Ifc2x3tc1StepDeserializerPlugin", true);
			Deserializer ifcDeserializer = ifcDeserializerPlugin.createDeserializer(null);
			PackageMetaData packageMetaData = pluginManager.getMetaDataManager().getPackageMetaData("ifc2x3tc1");
			ifcDeserializer.init(packageMetaData);
			IfcModelInterface model = ifcDeserializer.read(Paths.get("C:\\Arch\\2014-10-22-17-10-14-Archi_Elasstic_ribbon_2.ifc"));
			IfcRoot space = model.getByGuid("360RrcTsD148LBtQ0v7EoT");
			IfcRoot window = model.getByGuid("34twxE9mT4pRJLS4Gz2YhE");
			
			Set<Path> paths = new LinkedHashSet<Path>();
			Path basePath = new Path(space);
			IfcUtils.getAllPaths(basePath, window, paths, new HashSet<EObject>());
			for (Path path : paths) {
				System.out.println(path);
			}
		} catch (DeserializeException e) {
			e.printStackTrace();
		}
	}
}