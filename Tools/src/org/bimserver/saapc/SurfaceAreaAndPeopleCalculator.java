package org.bimserver.saapc;

import java.io.File;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcRelContainedInSpatialStructure;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;

public class SurfaceAreaAndPeopleCalculator {
	public static void main(String[] args) {
		new SurfaceAreaAndPeopleCalculator().start();
	}

	private void start() {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(new File("home"));
			DeserializerPlugin ifcDeserializerPlugin = pluginManager.getDeserializerPlugin("org.bimserver.ifc.step.deserializer.Ifc2x3tc1StepDeserializerPlugin", true);
			Deserializer ifcDeserializer = ifcDeserializerPlugin.createDeserializer(null);
			ifcDeserializer.init(pluginManager.getMetaDataManager().getPackageMetaData("ifc2x3tc1"));
			File baseDirectory = new File("C:\\Arch");
			for (File originalIfcFile : baseDirectory.listFiles()) {
				processFile(ifcDeserializer, originalIfcFile);
			}
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (DeserializeException e) {
			e.printStackTrace();
		}
	}

	private void processFile(Deserializer ifcDeserializer, File originalIfcFile)
			throws DeserializeException {
		IfcModelInterface model = ifcDeserializer.read(originalIfcFile);
		for (IfcSpace ifcSpace : model.getAllWithSubTypes(IfcSpace.class)) {
			for (IfcRelContainedInSpatialStructure ifcRelContainedInSpatialStructure : ifcSpace.getContainsElements()) {
				ifcRelContainedInSpatialStructure.getRelatedElements();
			}
		}
	}
}
