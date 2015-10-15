package org.bimserver.saapc;

import java.nio.file.Paths;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.bimserver.LocalDevSetup;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.eclipse.emf.ecore.EObject;

public class Test {
	public static void main(String[] args) {
		new Test().start(args);
	}

	private void start(String[] args) {
		try {
			PluginManager pluginManager = LocalDevSetup.setupPluginManager(args);
			DeserializerPlugin ifcDeserializerPlugin = pluginManager.getDeserializerPlugin("org.bimserver.ifc.step.deserializer.Ifc2x3tc1StepDeserializerPlugin", true);
			Deserializer ifcDeserializer = ifcDeserializerPlugin.createDeserializer(null);
			PackageMetaData packageMetaData = pluginManager.getMetaDataManager().getPackageMetaData("ifc2x3tc1");
			ifcDeserializer.init(packageMetaData);
			IfcModelInterface model = ifcDeserializer.read(Paths.get("C:\\Arch\\2014-10-22-17-10-14-Archi_Elasstic_ribbon_2.ifc"));
			IfcRoot space = model.getByGuid("360RrcTsD148LBtQ0v7EoT");
			IfcRoot window = model.getByGuid("34twxE9mT4pRJLS4Gz2YhE");
			
			Set<Path> paths = new LinkedHashSet<Path>();
			Path basePath = new Path(space);
			IfcUtils.getAllPaths(basePath, window, paths, new HashSet<EObject>());
			for (Path path : paths) {
				System.out.println(path);
			}
		} catch (DeserializeException e) {
			e.printStackTrace();
		}
	}
}