package org.bimserver.tests;

import java.nio.file.Paths;
import java.util.List;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.Schema;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;

public class ReadTest2 {
	public static void main(String[] args) {
		new ReadTest2().start();
	}

	private void start() {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(Paths.get("home"));
			DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", Schema.IFC2X3TC1, true);
			Deserializer deserializer = deserializerPlugin.createDeserializer(new PluginConfiguration());
			deserializer.init(pluginManager.getMetaDataManager().getPackageMetaData("ifc2x3tc1"));
			IfcModelInterface model =  deserializer.read(TestFile.HAUS_SOURCE_FILE.getFile());

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
