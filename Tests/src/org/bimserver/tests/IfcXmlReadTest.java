package org.bimserver.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.deserializers.EmfDeserializer;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;

import com.sun.xml.internal.ws.encoding.soap.DeserializationException;

public class IfcXmlReadTest {
	public static void main(String[] args) {
		new IfcXmlReadTest().start();
	}

	private void start() {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager();
			DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifcxml", true);
			EmfDeserializer deserializer = deserializerPlugin.createDeserializer();
			try {
				File file = TestFile.AC11_XML.getFile();
				IfcModelInterface model = deserializer.read(new FileInputStream(file), false, file.length());
				
				File outFile = new File("out.ifc");
				SerializerPlugin serializerPlugin = pluginManager.getFirstSerializerPlugin("application/ifc", true);
				EmfSerializer serializer = serializerPlugin.createSerializer();
				serializer.init(model, null, pluginManager);
				try {
					serializer.writeToFile(outFile);
				} catch (SerializerException e) {
					e.printStackTrace();
				}
				
				DeserializerPlugin deserializerPlugin2 = pluginManager.getFirstDeserializer("ifc", true);
				EmfDeserializer deserializer2 = deserializerPlugin2.createDeserializer();
				deserializer2.init(pluginManager.requireSchemaDefinition());
				deserializer2.read(outFile, true);
			} catch (DeserializationException e2) {
				e2.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (PluginException e1) {
			e1.printStackTrace();
		}
	}
}