package org.bimserver.tests;

import java.io.File;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.OptionsParser;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;

public class TestGen {
	public static void main(String[] args) {
		new TestGen().start(args);
	}

	private void start(String[] args) {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(new File("home"), new OptionsParser(args).getPluginDirectories());
			DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", true);
			Deserializer deserializer = deserializerPlugin.createDeserializer(null);
			deserializer.init(pluginManager.requireSchemaDefinition());
			IfcModelInterface model = deserializer.read(new File("../TestData/data/HITOS_070308.ifc"));
			long start = System.nanoTime();
			System.out.println(model.generateMinimalExpressIds());
			long end = System.nanoTime();
			System.out.println(((end - start) / 1000000) + " ms");
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (DeserializeException e) {
			e.printStackTrace();
		}
	}
}
