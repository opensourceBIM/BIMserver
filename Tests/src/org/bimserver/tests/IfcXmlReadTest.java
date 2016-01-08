package org.bimserver.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.Schema;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.exceptions.PluginException;

public class IfcXmlReadTest {
	public static void main(String[] args) {
		new IfcXmlReadTest().start();
	}

	private void start() {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(Paths.get("home"));
			DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifcxml", Schema.IFC2X3TC1, true);
			Deserializer deserializer = deserializerPlugin.createDeserializer(new PluginConfiguration());
			try {
				Path file = TestFile.AC11_XML.getFile();
				IfcModelInterface model = deserializer.read(new FileInputStream(file.toFile()), "ac11.ifcxml", file.toFile().length());
				
				Path outFile = Paths.get("out.ifc");
				SerializerPlugin serializerPlugin = pluginManager.getSerializerPlugin("org.bimserver.ifc.step.serializer.IfcStepSerializerPlugin", true);
				Serializer serializer = serializerPlugin.createSerializer(new PluginConfiguration());
				serializer.init(model, null, pluginManager, null, false);
				try {
					serializer.writeToFile(outFile, null);
				} catch (SerializerException e) {
					e.printStackTrace();
				}
				
				DeserializerPlugin deserializerPlugin2 = pluginManager.getFirstDeserializer("ifc", Schema.IFC2X3TC1, true);
				Deserializer deserializer2 = deserializerPlugin2.createDeserializer(new PluginConfiguration());
				deserializer2.init(pluginManager.getMetaDataManager().getPackageMetaData("ifc2x3tc1"));
				deserializer2.read(outFile);
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