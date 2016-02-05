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
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.Schema;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.tests.TestFile;
import org.bimserver.utils.DeserializerUtils;
import org.bimserver.utils.SerializerUtils;
import org.junit.Test;

public class TestIfcStepDeserializer {
	@Test
	public void testSpaceEndOfLineBeforeSemiColon() {
		try {
			Path home = Paths.get("home");
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(home);
			DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", Schema.IFC2X3TC1, true);
			Deserializer deserializer = deserializerPlugin.createDeserializer(new PluginConfiguration());
			
			MetaDataManager metaDataManager = new MetaDataManager(home.resolve("tmp"));
			PackageMetaData packageMetaData = metaDataManager.getPackageMetaData("ifc2x3tc1");
			
			deserializer.init(packageMetaData);
			IfcModelInterface modelInterface = DeserializerUtils.readFromFile(deserializer, TestFile.AC11.getFile());
			
			SerializerPlugin serializerPlugin = pluginManager.getSerializerPlugin("org.bimserver.ifc.step.serializer.IfcStepSerializerPlugin", true);
			Serializer serializer = serializerPlugin.createSerializer(new PluginConfiguration());
			serializer.init(modelInterface, null, pluginManager, false);
			SerializerUtils.writeToFile(serializer, Paths.get("output/test.ifc"));
		} catch (PluginException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (DeserializeException e) {
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