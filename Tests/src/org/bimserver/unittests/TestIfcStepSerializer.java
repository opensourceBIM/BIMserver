package org.bimserver.unittests;

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

import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.ifc.BasicIfcModel;
import org.bimserver.ifc.IfcModel;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcWall;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.utils.SerializerUtils;
import org.junit.Test;

public class TestIfcStepSerializer {
	@Test
	public void testSerializer() throws IfcModelInterfaceException {
		try {
			Path home = Paths.get("home");
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(home);
			SerializerPlugin serializerPlugin = pluginManager.getSerializerPlugin("org.bimserver.ifc.step.serializer.IfcStepSerializerPlugin", true);
			Serializer serializer = serializerPlugin.createSerializer(new PluginConfiguration());
			
			MetaDataManager metaDataManager = new MetaDataManager(home.resolve("tmp"));
			PackageMetaData packageMetaData = metaDataManager.getPackageMetaData("ifc2x3tc1");
			
			IfcModel model = new BasicIfcModel(packageMetaData, null);
			IfcWall wall = model.create(Ifc2x3tc1Package.eINSTANCE.getIfcWall());
			wall.setName("Test with 'quotes");
			serializer.init(model, null, pluginManager, false);
			SerializerUtils.writeToFile(serializer, Paths.get("output/test.ifc"));
		} catch (PluginException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (SerializerException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}