package org.bimserver.tests;

import java.nio.file.Paths;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.Schema;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;

import com.javamex.classmexer.MemoryUtil;

public class TestSize {
	public static void main(String[] args) {
		new TestSize().start();
	}

	private void start() {
		try {
			final PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(Paths.get("home"));
			final DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", Schema.IFC2X3TC1, true);

			Deserializer deserializer = deserializerPlugin.createDeserializer(new PluginConfiguration());
			deserializer.init(pluginManager.getMetaDataManager().getPackageMetaData("ifc2x3tc1"));
			IfcModelInterface model = deserializer.read(TestFile.AC11.getFile());
			System.out.println("Nr Objects: " + model.size());
			System.out.println("Memory: " + MemoryUtil.deepMemoryUsageOf(model));
			while (true) {
				Thread.sleep(1000);
			}
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (DeserializeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
