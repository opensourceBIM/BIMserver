package org.bimserver.scenejs.test;

import java.io.File;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class Test1 {
	public static void main(String[] args) {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(new File("home"));
			DeserializerPlugin deserializerPlugin = (DeserializerPlugin) pluginManager.getPlugin("org.bimserver.ifc.step.deserializer.IfcStepDeserializerPlugin", true);
			Deserializer deserializer = deserializerPlugin.createDeserializer();
			deserializer.init(pluginManager.requireSchemaDefinition());
			File file = new File("../TestData/data/AC11-Institute-Var-2-IFC.ifc");
			IfcModelInterface model = deserializer.read(file, true);

//			SerializerPlugin defaultSerializerPlugin = (SerializerPlugin) pluginManager.getPlugin("org.bimserver.scenejs.SceneJSSerializerPlugin", true);
//			Serializer defaultSerializer = defaultSerializerPlugin.createSerializer();
//			defaultSerializer.init(model, null, pluginManager, pluginManager.requireIfcEngine().createIfcEngine());
//			long start = System.nanoTime();
//			defaultSerializer.writeToFile(new File(file.getName() + ".json"));
//			long end = System.nanoTime();
//			System.out.println(((end - start) / 1000000) + " ms");
			
			SerializerPlugin streamingSerializerPlugin = (SerializerPlugin) pluginManager.getPlugin("org.bimserver.scenejs.StreamingSceneJSSerializerPlugin", true);
			Serializer streamingSerializer = streamingSerializerPlugin.createSerializer();
			streamingSerializer.init(model, null, pluginManager, pluginManager.requireIfcEngine().createIfcEngine());
			long start = System.nanoTime();
			streamingSerializer.writeToFile(new File("str-" + file.getName() + ".json"));
			long end = System.nanoTime();

			System.out.println(((end - start) / 1000000) + " ms");
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (DeserializeException e) {
			e.printStackTrace();
		} catch (SerializerException e) {
			e.printStackTrace();
		}
	}
}
