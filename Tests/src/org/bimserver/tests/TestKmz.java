package org.bimserver.tests;

import java.nio.file.Paths;
import java.util.Collection;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.exceptions.PluginException;

public class TestKmz {
	public static void main(String[] args) {
		new TestKmz().start();
	}

	private void start() {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(Paths.get("home"));
			SerializerPlugin plugin = pluginManager.getSerializerPlugin("org.bimserver.collada.KmzSerializerPlugin", true);
			Serializer serializer = plugin.createSerializer(new PluginConfiguration());
			Collection<DeserializerPlugin> allDeserializerPlugins = pluginManager.getAllDeserializerPlugins("ifc", true);
			// IfcEnginePlugin ifcEngine =
			// pluginManager.getIfcEngine("org.ifcopenshell.IfcOpenShellEnginePlugin",
			// true);
			if (!allDeserializerPlugins.isEmpty()) {
				DeserializerPlugin deserializerPlugin = allDeserializerPlugins.iterator().next();
				Deserializer deserializer = deserializerPlugin.createDeserializer(new PluginConfiguration());
				deserializer.init(pluginManager.getMetaDataManager().getPackageMetaData("ifc2x3tc1"));
				IfcModelInterface model = deserializer.read(TestFile.WALL_ONLY.getFile());
				// IfcModelInterface model =
				// deserializer.read(TestFile.ADTHAUS.getFile(), true);
				serializer.init(model, null, pluginManager, null, false);
				serializer.writeToFile(Paths.get("output/ac11.kmz"), null);
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