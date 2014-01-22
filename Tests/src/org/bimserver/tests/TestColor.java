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
import java.util.Random;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.models.ifc2x3tc1.IfcColourRgb;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class TestColor {
	public static void main(String[] args) {
		PluginManager pluginManager;
		try {
			pluginManager = LocalDevPluginLoader.createPluginManager(new File("home"));
			DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", true);
			Deserializer deserializer = deserializerPlugin.createDeserializer(new PluginConfiguration());
			deserializer.init(pluginManager.requireSchemaDefinition());
//			IfcModelInterface model = deserializer.read(new File("../TestData/data/AC11-Institute-Var-2-IFC.ifc"));
			IfcModelInterface model = deserializer.read(new File("D:\\Dropbox\\Shared\\BIMserver\\IFC modellen\\top secret statsbygg\\SB_11873_6_ARK_PNN_2012.02.13.ifc"));
			model.fixOidCounter();
//			ModelColorizer modelColorizer = new ModelColorizer(model);
			Random random = new Random();
//			for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
//				modelColorizer.setColor(ifcProduct, new double[]{random.nextFloat(), random.nextFloat(), random.nextFloat()}, random.nextFloat());
//			}

			model.setUseDoubleStrings(false);
			IfcColourRgb gray = model.create(IfcColourRgb.class);
			gray.setRed(0.5);
			gray.setGreen(0.5);
			gray.setBlue(0.5);
			for (IfcSurfaceStyleRendering surfaceStyleRendering : model.getAll(IfcSurfaceStyleRendering.class)) {
				System.out.println(surfaceStyleRendering);
				if (random.nextInt(10) > 2) {
					surfaceStyleRendering.setDiffuseColour(gray);
					surfaceStyleRendering.setReflectionColour(gray);
					surfaceStyleRendering.setSpecularColour(gray);
					surfaceStyleRendering.setSurfaceColour(gray);
					surfaceStyleRendering.setTransmissionColour(gray);
					surfaceStyleRendering.setTransparency(0.95);
				} else {
					
				}
			}
			SerializerPlugin serializerPlugin = pluginManager.getSerializerPlugin("org.bimserver.ifc.step.serializer.IfcStepSerializerPlugin", true);
			Serializer serializer = serializerPlugin.createSerializer(null);
			model.generateMinimalExpressIds();
			serializer.init(model, null, pluginManager, pluginManager.requireRenderEngine(), false);
			serializer.writeToFile(new File("color.ifc"));
		} catch (PluginException e1) {
			e1.printStackTrace();
		} catch (DeserializeException e) {
			e.printStackTrace();
		} catch (SerializerException e) {
			e.printStackTrace();
		} catch (IfcModelInterfaceException e) {
			e.printStackTrace();
		}
	}
}
