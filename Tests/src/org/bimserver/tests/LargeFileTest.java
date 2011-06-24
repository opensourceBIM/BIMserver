package org.bimserver.tests;

import java.io.File;
import java.util.List;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IdEObject;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.deserializers.EmfDeserializer;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.eclipse.emf.ecore.EStructuralFeature;

public class LargeFileTest {
	public static void main(String[] args) {
		new LargeFileTest().start();
	}

	@SuppressWarnings("rawtypes")
	private void start() {
		PluginManager pluginManager;
		try {
			pluginManager = LocalDevPluginLoader.createPluginManager();
			DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", true);
			EmfDeserializer deserializer = deserializerPlugin.createDeserializer();
			deserializer.init(pluginManager.requireSchemaDefinition());
			IfcModelInterface model = deserializer.read(new File("C:\\Users\\Ruben de Laat\\Documents\\My Dropbox\\Shared\\BIMserver\\arcadis\\KW02.ifc"), true);
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