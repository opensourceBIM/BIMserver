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

public class TestCityGML {
	public static void main(String[] args) {
		new TestCityGML().start();
	}

	private void start() {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(Paths.get("home"));
			SerializerPlugin plugin = pluginManager.getSerializerPlugin("org.bimserver.citygml.CityGmlSerializerPlugin", true);
			Serializer serializer = plugin.createSerializer(new PluginConfiguration());
			Collection<DeserializerPlugin> allDeserializerPlugins = pluginManager.getAllDeserializerPlugins("ifc", true);
			if (!allDeserializerPlugins.isEmpty()) {
				DeserializerPlugin deserializerPlugin = allDeserializerPlugins.iterator().next();
				Deserializer deserializer = deserializerPlugin.createDeserializer(new PluginConfiguration());
				deserializer.init(pluginManager.getMetaDataManager().getPackageMetaData("ifc2x3tc1"));
				IfcModelInterface model = deserializer.read(Paths.get("C:\\Users\\Ruben de Laat\\Workspace\\BIMserver\\TestData\\data\\Eindhoven - TUe_model - RevitArch.ifc"));
				serializer.init(model, null, pluginManager, null, false);
				serializer.writeToFile(Paths.get("output/ac11.gml"), null);
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
