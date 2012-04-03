package org.bimserver.tests;

import java.io.File;
import java.util.Collection;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.deserializers.EmfDeserializer;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class TestCollada {
	public static void main(String[] args) {
		new TestCollada().start();
	}

	private void start() {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager();
			Collection<SerializerPlugin> plugins = pluginManager.getAllSerializerPlugins("application/collada", true);
			if (!plugins.isEmpty()) {
				SerializerPlugin plugin = plugins.iterator().next();
				EmfSerializer serializer = plugin.createSerializer();
				Collection<DeserializerPlugin> allDeserializerPlugins = pluginManager.getAllDeserializerPlugins("ifc", true);
				if (!allDeserializerPlugins.isEmpty()) {
					DeserializerPlugin deserializerPlugin = allDeserializerPlugins.iterator().next();
					EmfDeserializer deserializer = deserializerPlugin.createDeserializer();
					deserializer.init(pluginManager.requireSchemaDefinition());
					IfcModelInterface model = deserializer.read(TestFile.AC11.getFile(), false);
					serializer.init(model, null, pluginManager, pluginManager.requireIfcEngine().createIfcEngine());
					serializer.writeToFile(new File("output/ac11.dae"));
				}
			}
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (SerializerException e) {
			e.printStackTrace();
		} catch (DeserializeException e) {
			e.printStackTrace();
		}
	}
}
