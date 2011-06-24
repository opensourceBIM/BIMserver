package org.bimserver.tests;

import java.util.List;

import nl.tue.buildingsmart.emf.SchemaLoader;

import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.step.deserializer.IfcStepDeserializer;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.schema.SchemaDefinition;

public class ReadTest2 {
	public static void main(String[] args) {
		new ReadTest2().start();
	}

	private void start() {
		SchemaDefinition schema = SchemaLoader.loadDefaultSchema();
		IfcStepDeserializer fastIfcFileReader = new IfcStepDeserializer();
		fastIfcFileReader.init(schema);
		try {
			fastIfcFileReader.read(TestFile.HAUS_SOURCE_FILE.getFile());
		} catch (DeserializeException e) {
			e.printStackTrace();
		}
		IfcModel model = fastIfcFileReader.getModel();
		
		List<IdEObject> windows = model.getAllWithSubTypes(IdEObject.class);
		System.out.println(windows.size());
		
//		List<IfcBuildingStorey> stories = model.getAll(IfcBuildingStorey.class);
//		for (IfcBuildingStorey storey : stories) {
//			for (IfcRelContainedInSpatialStructure rel : storey.getContainsElements()) {
//				for (IfcProduct product : rel.getRelatedElements()) {
//					if (product instanceof IfcOpeningElement) {
//						IfcOpeningElement openingElement = (IfcOpeningElement)product;
//						for (IfcRelDefines defines : openingElement.getIsDefinedBy()) {
//							if (defines instanceof IfcRelDefinesByProperties) {
//								IfcRelDefinesByProperties definesByProperties = (IfcRelDefinesByProperties)defines;
//								IfcPropertySetDefinition relatingPropertyDefinition = definesByProperties.getRelatingPropertyDefinition();
//								if (relatingPropertyDefinition instanceof IfcElementQuantity) {
//									IfcElementQuantity elementQuantity = (IfcElementQuantity)relatingPropertyDefinition;
//									EList<IfcPhysicalQuantity> quantities = elementQuantity.getQuantities();
//									for (IfcPhysicalQuantity physicalQuantity : quantities) {
//										if (physicalQuantity instanceof IfcQuantityArea) {
//											IfcQuantityArea area = (IfcQuantityArea)physicalQuantity;
//											float areaValue = area.getAreaValue();
//										}
//									}
//								}
//							}
//						}
//					}
//				}
//			}
//		}
	}
}
