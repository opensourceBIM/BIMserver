package org.bimserver.tests;

import java.nio.file.Paths;
import java.util.Collection;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.renderengine.RenderEnginePlugin;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class TestCollada {
	public static void main(String[] args) {
		new TestCollada().start();
	}

	private void start() {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(Paths.get("home"));
			SerializerPlugin plugin = pluginManager.getSerializerPlugin("org.bimserver.collada.ColladaSerializerPlugin", true);
			Serializer serializer = plugin.createSerializer(new PluginConfiguration());
			Collection<DeserializerPlugin> allDeserializerPlugins = pluginManager.getAllDeserializerPlugins("ifc", true);
			// IfcEnginePlugin ifcEngine =
			// pluginManager.getIfcEngine("org.ifcopenshell.IfcOpenShellEnginePlugin",
			// true);
			RenderEnginePlugin ifcEngine = pluginManager.getRenderEngine("org.bimserver.ifcengine.TNOIfcEnginePlugin", true);
			if (!allDeserializerPlugins.isEmpty()) {
				DeserializerPlugin deserializerPlugin = allDeserializerPlugins.iterator().next();
				Deserializer deserializer = deserializerPlugin.createDeserializer(new PluginConfiguration());
				deserializer.init(pluginManager.getMetaDataManager().getPackageMetaData("ifc2x3tc1"));
				// IfcModelInterface model = deserializer.read(new
				// File("C:\\Users\\Ruben de Laat\\Dropbox\\Logic Labs\\Clients\\TNO\\m1-bevinding\\M1_project.ifc"),
				// true);
				IfcModelInterface model = deserializer.read(TestFile.WALL_ONLY.getFile());
				serializer.init(model, null, pluginManager, ifcEngine, null, false);
				serializer.writeToFile(Paths.get("output/ac11.dae"), null);
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