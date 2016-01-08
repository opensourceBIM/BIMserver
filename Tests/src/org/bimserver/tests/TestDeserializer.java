package org.bimserver.tests;

import java.nio.file.Paths;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.Schema;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.shared.exceptions.PluginException;

public class TestDeserializer {
	public static void main(String[] args) {
		new TestDeserializer().start();
	}

	private void start() {
		try {
			final PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(Paths.get("home"));
			final DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", Schema.IFC2X3TC1, true);

			Deserializer deserializer = deserializerPlugin.createDeserializer(new PluginConfiguration());
			deserializer.init(pluginManager.getMetaDataManager().getPackageMetaData("ifc2x3tc1"));
			IfcModelInterface model = deserializer.read(Paths.get("C:\\Users\\Ruben de Laat\\Dropbox\\Shared\\BIMserver\\Atrium%20Offices%20-%20PROJETO_EXECUTIVO%20-%202012.05.03.ifc"));
			
			for (IdEObject idEObject : model.getValues()) {
				System.out.println(idEObject);
			}
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (DeserializeException e) {
			e.printStackTrace();
		}
	}
}