package org.bimserver.tests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.utils.PathUtils;

public class TestColladaSerializer {
	public static void main(String[] args) {
		new TestColladaSerializer().start();
	}

	private void start() {
		try {
			Path testFiles = Paths.get("../TestData/data");
			Path output = Paths.get("output");
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(Paths.get("home"));
			
			DeserializerPlugin ifcDeserializerPlugin = pluginManager.getFirstDeserializer("ifc", Schema.IFC2X3TC1, true);
			
			SerializerPlugin serializerPlugin = pluginManager.getSerializerPlugin("org.bimserver.collada.ColladaSerializerPlugin", true);
			for (Path file : PathUtils.getDirectories(testFiles)) {
				if (!Files.isDirectory(file) && file.getFileName().toString().endsWith(".ifc") && file.getFileName().toString().equals("Vogel_Gesamt.ifc")) {
					System.out.println(file.getFileName().toString());
					ProjectInfo projectInfo = new ProjectInfo();
					projectInfo.setAuthorName("test");
					projectInfo.setDescription("");
					
					Deserializer ifcDeserializer = ifcDeserializerPlugin.createDeserializer(new PluginConfiguration());
					ifcDeserializer.init(pluginManager.getMetaDataManager().getPackageMetaData("ifc2x3tc1"));
					IfcModelInterface model = ifcDeserializer.read(file);

					Serializer serializer = serializerPlugin.createSerializer(new PluginConfiguration());
					serializer.init(model, projectInfo, pluginManager, pluginManager.requireRenderEngine(), null, false);
					serializer.writeToFile(output.resolve(file.getFileName().toString() + ".dae"), null);
				}
			}
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (DeserializeException e) {
			e.printStackTrace();
		} catch (SerializerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
