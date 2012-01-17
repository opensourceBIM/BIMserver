package org.bimserver.tests;

import java.io.File;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.deserializers.EmfDeserializer;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class TestColladaSerializer {
	public static void main(String[] args) {
		new TestColladaSerializer().start();
	}

	private void start() {
		try {
			File testFiles = new File("../TestData/data");
			File output = new File("output");
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager();
			
			DeserializerPlugin ifcDeserializerPlugin = pluginManager.getFirstDeserializer("ifc", true);
			
			SerializerPlugin serializerPlugin = pluginManager.getFirstSerializerPlugin("application/collada", true);
			for (File file : testFiles.listFiles()) {
				if (file.isFile() && file.getName().endsWith(".ifc") && file.getName().equals("Vogel_Gesamt.ifc")) {
					System.out.println(file.getName());
					ProjectInfo projectInfo = new ProjectInfo();
					projectInfo.setAuthorName("test");
					projectInfo.setDescription("");
					
					EmfDeserializer ifcDeserializer = ifcDeserializerPlugin.createDeserializer();
					ifcDeserializer.init(pluginManager.requireSchemaDefinition());
					IfcModelInterface model = ifcDeserializer.read(file, true);

					EmfSerializer serializer = serializerPlugin.createSerializer();
					serializer.init(model, projectInfo, pluginManager, pluginManager.requireIfcEngine().createIfcEngine());
					serializer.writeToFile(new File(output, file.getName() + ".dae"));
				}
			}
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (DeserializeException e) {
			e.printStackTrace();
		} catch (SerializerException e) {
			e.printStackTrace();
		}
	}
}
