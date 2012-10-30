package org.bimserver.tests;

import java.io.File;
import java.util.Collection;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.ifcengine.IfcEnginePlugin;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class TestCollada {
	public static void main(String[] args) {
		new TestCollada().start();
	}

	private void start() {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(new File("home"));
			Collection<SerializerPlugin> plugins = pluginManager.getAllSerializerPlugins("application/collada", true);
			if (!plugins.isEmpty()) {
				SerializerPlugin plugin = plugins.iterator().next();
				Serializer serializer = plugin.createSerializer();
				Collection<DeserializerPlugin> allDeserializerPlugins = pluginManager.getAllDeserializerPlugins("ifc", true);
//				IfcEnginePlugin ifcEngine = pluginManager.getIfcEngine("org.ifcopenshell.IfcOpenShellEnginePlugin", true);
				IfcEnginePlugin ifcEngine = pluginManager.getIfcEngine("org.bimserver.ifcengine.TNOIfcEnginePlugin", true);
				if (!allDeserializerPlugins.isEmpty()) {
					DeserializerPlugin deserializerPlugin = allDeserializerPlugins.iterator().next();
					Deserializer deserializer = deserializerPlugin.createDeserializer();
					deserializer.init(pluginManager.requireSchemaDefinition());
//					IfcModelInterface model = deserializer.read(new File("C:\\Users\\Ruben de Laat\\Dropbox\\Logic Labs\\Clients\\TNO\\m1-bevinding\\M1_project.ifc"), true);
					IfcModelInterface model = deserializer.read(TestFile.WALL_ONLY.getFile(), true);
					serializer.init(model, null, pluginManager, ifcEngine.createIfcEngine(), false);
					serializer.writeToFile(new File("output/ac11.dae"));
				}
			}
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (SerializerException e) {
			e.printStackTrace();
		} catch (DeserializeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}