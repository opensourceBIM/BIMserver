package org.bimserver.tests;

import java.nio.file.Paths;
import java.util.List;

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
import org.eclipse.emf.ecore.EStructuralFeature;

public class LargeFileTest {
	public static void main(String[] args) {
		new LargeFileTest().start();
	}

	@SuppressWarnings("rawtypes")
	private void start() {
		PluginManager pluginManager;
		try {
			pluginManager = LocalDevPluginLoader.createPluginManager(Paths.get("home"));
			DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", Schema.IFC2X3TC1, true);
			Deserializer deserializer = deserializerPlugin.createDeserializer(new PluginConfiguration());
			deserializer.init(pluginManager.getMetaDataManager().getPackageMetaData("ifc2x3tc1"));
			IfcModelInterface model = deserializer.read(Paths.get("C:\\Users\\Ruben de Laat\\Documents\\My Dropbox\\Shared\\BIMserver\\arcadis\\KW02.ifc"));
			for (IdEObject idEObject : model.getValues()) {
				for (EStructuralFeature eStructuralFeature : idEObject.eClass().getEAllStructuralFeatures()) {
					if (eStructuralFeature.isMany()) {
						List list = (List) idEObject.eGet(eStructuralFeature);
						if (list.size() > 1000) {
							System.out.println(idEObject.getOid() + " " + idEObject.eClass().getName() + " " + eStructuralFeature.getName() + ": " + list.size());
						}
					}
				}
			}
		} catch (PluginException e1) {
			e1.printStackTrace();
		} catch (DeserializeException e) {
			e.printStackTrace();
		}
	}
}