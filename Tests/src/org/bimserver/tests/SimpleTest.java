package org.bimserver.tests;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.models.ifc2x3.IfcBuildingStorey;
import org.bimserver.models.ifc2x3.IfcDoor;
import org.bimserver.models.ifc2x3.IfcProduct;
import org.bimserver.models.ifc2x3.IfcRelContainedInSpatialStructure;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.deserializers.EmfDeserializer;
import org.bimserver.plugins.serializers.IfcModelInterface;

import com.sun.xml.internal.ws.encoding.soap.DeserializationException;

public class SimpleTest {
	public static void main(String[] args) {
		new SimpleTest().start();
	}

	private void start() {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager();
			DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", true);
			EmfDeserializer deserializer = deserializerPlugin.createDeserializer();
			deserializer.init(pluginManager.requireSchemaDefinition());
			deserializer.read(TestFile.HAUS_SOURCE_FILE.getFile(), true);
			IfcModelInterface model = deserializer.getModel();
            List<IfcBuildingStorey> stories = model.getAll(IfcBuildingStorey.class);
            Map<Float, IfcBuildingStorey> orderedStories = new TreeMap<Float, IfcBuildingStorey>();
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
		} catch (DeserializationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}