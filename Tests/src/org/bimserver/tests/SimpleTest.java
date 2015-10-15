package org.bimserver.tests;

import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.Schema;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcDoor;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcRelContainedInSpatialStructure;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;

public class SimpleTest {
	public static void main(String[] args) {
		new SimpleTest().start();
	}

	private void start() {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(Paths.get("home"));
			DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", Schema.IFC2X3TC1, true);
			Deserializer deserializer = deserializerPlugin.createDeserializer(new PluginConfiguration());
			deserializer.init(pluginManager.getMetaDataManager().getPackageMetaData("ifc2x3tc1"));
			IfcModelInterface model = deserializer.read(TestFile.HAUS_SOURCE_FILE.getFile());
            List<IfcBuildingStorey> stories = model.getAll(IfcBuildingStorey.class);
            Map<Double, IfcBuildingStorey> orderedStories = new TreeMap<Double, IfcBuildingStorey>();
            for (IfcBuildingStorey storey : stories) {
                orderedStories.put(storey.getElevation(), storey);
            }
            if (orderedStories.size() > 1) {
                IfcBuildingStorey firstFloor = stories.get(1);
                for (IfcRelContainedInSpatialStructure rel : firstFloor.getContainsElements()) {
                	for (IfcProduct product : rel.getRelatedElements()) {
                		if (product instanceof IfcDoor) {
                			IfcDoor ifcDoor = (IfcDoor)product;
                            if (ifcDoor.getOverallHeight() > 2) {
                                System.out.println(ifcDoor.getName() + " " + ifcDoor.getOverallHeight());
                            }
                		}
                	}
                }
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}