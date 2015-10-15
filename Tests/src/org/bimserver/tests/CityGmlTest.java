package org.bimserver.tests;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class CityGmlTest {
	public static void main(String[] args) {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(Paths.get("home"));
			DeserializerPlugin deserializerPlugin = pluginManager.requireDeserializer("ifc");
			Deserializer deserializer = deserializerPlugin.createDeserializer(new PluginConfiguration());
			deserializer.init(pluginManager.getMetaDataManager().getPackageMetaData("ifc2x3tc1"));
			IfcModelInterface model = deserializer.read(TestFile.AC11.getFile());
			SerializerPlugin serializerPlugin = pluginManager.getSerializerPlugin("org.bimserver.citygml.CityGmlSerializerPlugin", true);
			Serializer serializer = serializerPlugin.createSerializer(new PluginConfiguration());
			serializer.init(model, null, pluginManager, pluginManager.requireRenderEngine(), null, false);
			FileOutputStream fos = new FileOutputStream(Paths.get("out.gml").toFile());
			serializer.writeToOutputStream(fos, null);
			fos.close();
		} catch (PluginException e2) {
			e2.printStackTrace();
		} catch (DeserializeException e) {
			e.printStackTrace();
		} catch (SerializerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}