package org.bimserver.scenejs.test;

import java.io.File;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test1 {
	private static final Logger LOGGER = LoggerFactory.getLogger(Test1.class);
	public static void main(String[] args) {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(new File("home"));
			DeserializerPlugin deserializerPlugin = (DeserializerPlugin) pluginManager.getPlugin("org.bimserver.ifc.step.deserializer.IfcStepDeserializerPlugin", true);
			Deserializer deserializer = deserializerPlugin.createDeserializer(new PluginConfiguration());
			deserializer.init(pluginManager.requireSchemaDefinition());
			File file = new File("../TestData/data/AC11-Institute-Var-2-IFC.ifc");
			IfcModelInterface model = deserializer.read(file);

			SerializerPlugin streamingSerializerPlugin = (SerializerPlugin) pluginManager.getPlugin("org.bimserver.scenejs.StreamingSceneJSSerializerPlugin", true);
			Serializer streamingSerializer = streamingSerializerPlugin.createSerializer(new PluginConfiguration());
			streamingSerializer.init(model, null, pluginManager, pluginManager.requireRenderEngine(), false);
			long start = System.nanoTime();
			streamingSerializer.writeToFile(new File("str-" + file.getName() + ".json"), null);
			long end = System.nanoTime();

			System.out.println(((end - start) / 1000000) + " ms");
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}
}
