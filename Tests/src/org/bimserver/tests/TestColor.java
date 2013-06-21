package org.bimserver.tests;

import java.io.File;
import java.util.Random;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.ModelColorizer;

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
			ModelColorizer modelColorizer = new ModelColorizer(model);
			Random random = new Random();
			for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
				modelColorizer.setColor(ifcProduct, new double[]{random.nextFloat(), random.nextFloat(), random.nextFloat()}, random.nextFloat());
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
