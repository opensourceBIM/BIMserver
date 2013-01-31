package org.bimserver.tests;

import java.io.File;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;

public class CompareTest {
	public static void main(String[] args) {
		new CompareTest().start();
	}

	private void start() {
		File file1 = new File("../TestData/data/AC11-Institute-Var-2-IFC.ifc");
		File file2 = new File("../TestData/data/AC11-FZK-Haus-IFC.ifc");
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(new File("home"));
			IfcModelInterface model1 = readModel(file1, pluginManager);
			IfcModelInterface model2 = readModel(file2, pluginManager);

			if (model1.size() != model2.size()) {
				System.out.println("The models are not the same!");
			}
		} catch (DeserializeException e) {
			e.printStackTrace();
		} catch (PluginException e) {
			e.printStackTrace();
		}
	}

	private IfcModelInterface readModel(File file1, PluginManager pluginManager) throws DeserializeException, PluginException {
		Deserializer deserializer = pluginManager.requireDeserializer("ifc").createDeserializer(new PluginConfiguration());
		deserializer.init(pluginManager.requireSchemaDefinition());
		IfcModelInterface model1 = deserializer.read(file1);
		return model1;
	}
}
