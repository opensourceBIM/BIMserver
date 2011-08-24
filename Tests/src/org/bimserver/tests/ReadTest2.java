package org.bimserver.tests;

import java.util.List;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IdEObject;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.deserializers.EmfDeserializer;
import org.bimserver.plugins.serializers.IfcModelInterface;

public class ReadTest2 {
	public static void main(String[] args) {
		new ReadTest2().start();
	}

	private void start() {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager();
			DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", true);
			EmfDeserializer deserializer = deserializerPlugin.createDeserializer();
			deserializer.init(pluginManager.requireSchemaDefinition());
			IfcModelInterface model =  deserializer.read(TestFile.HAUS_SOURCE_FILE.getFile(), true);

			List<IdEObject> windows = model.getAllWithSubTypes(IdEObject.class);
			System.out.println(windows.size());

			// List<IfcBuildingStorey> stories =
			// model.getAll(IfcBuildingStorey.class);
			// for (IfcBuildingStorey storey : stories) {
			// for (IfcRelContainedInSpatialStructure rel :
			// storey.getContainsElements()) {
			// for (IfcProduct product : rel.getRelatedElements()) {
			// if (product instanceof IfcOpeningElement) {
			// IfcOpeningElement openingElement = (IfcOpeningElement)product;
			// for (IfcRelDefines defines : openingElement.getIsDefinedBy()) {
			// if (defines instanceof IfcRelDefinesByProperties) {
			// IfcRelDefinesByProperties definesByProperties =
			// (IfcRelDefinesByProperties)defines;
			// IfcPropertySetDefinition relatingPropertyDefinition =
			// definesByProperties.getRelatingPropertyDefinition();
			// if (relatingPropertyDefinition instanceof IfcElementQuantity) {
			// IfcElementQuantity elementQuantity =
			// (IfcElementQuantity)relatingPropertyDefinition;
			// EList<IfcPhysicalQuantity> quantities =
			// elementQuantity.getQuantities();
			// for (IfcPhysicalQuantity physicalQuantity : quantities) {
			// if (physicalQuantity instanceof IfcQuantityArea) {
			// IfcQuantityArea area = (IfcQuantityArea)physicalQuantity;
			// float areaValue = area.getAreaValue();
			// }
			// }
			// }
			// }
			// }
			// }
			// }
			// }
			// }
		} catch (DeserializeException e) {
			e.printStackTrace();
		} catch (PluginException e) {
			e.printStackTrace();
		}
	}
}
