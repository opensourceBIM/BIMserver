package org.bimserver.tests;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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

public class CityGmlTest {
	public static void main(String[] args) {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager();
			DeserializerPlugin deserializerPlugin = pluginManager.requireDeserializer("ifc");
			EmfDeserializer deserializer = deserializerPlugin.createDeserializer();
			deserializer.init(pluginManager.requireSchemaDefinition());
			IfcModelInterface model = deserializer.read(TestFile.AC11.getFile(), true);
			SerializerPlugin serializerPlugin = pluginManager.getFirstSerializerPlugin("application/gml", true);
			EmfSerializer serializer = serializerPlugin.createSerializer();
			serializer.init(model, null, pluginManager);
			FileOutputStream fos = new FileOutputStream(new File("out.gml"));
			serializer.writeToOutputStream(fos);
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