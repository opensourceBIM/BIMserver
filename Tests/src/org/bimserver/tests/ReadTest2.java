package org.bimserver.tests;

import java.util.List;

import nl.tue.buildingsmart.emf.SchemaLoader;

import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.step.deserializer.IfcStepDeserializer;
import org.bimserver.ignoreproviders.FileFieldIgnoreMap;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcBuildingStorey;
import org.bimserver.models.ifc2x3.IfcElementQuantity;
import org.bimserver.models.ifc2x3.IfcOpeningElement;
import org.bimserver.models.ifc2x3.IfcPhysicalQuantity;
import org.bimserver.models.ifc2x3.IfcProduct;
import org.bimserver.models.ifc2x3.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3.IfcQuantityArea;
import org.bimserver.models.ifc2x3.IfcRelContainedInSpatialStructure;
import org.bimserver.models.ifc2x3.IfcRelDefines;
import org.bimserver.models.ifc2x3.IfcRelDefinesByProperties;
import org.bimserver.plugins.ResourceFetcher;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.bimserver.utils.CollectionUtils;
import org.eclipse.emf.common.util.EList;

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
		List<IfcBuildingStorey> stories = model.getAll(IfcBuildingStorey.class);
		for (IfcBuildingStorey storey : stories) {
			for (IfcRelContainedInSpatialStructure rel : storey.getContainsElements()) {
				for (IfcProduct product : rel.getRelatedElements()) {
					if (product instanceof IfcOpeningElement) {
						IfcOpeningElement openingElement = (IfcOpeningElement)product;
						for (IfcRelDefines defines : openingElement.getIsDefinedBy()) {
							if (defines instanceof IfcRelDefinesByProperties) {
								IfcRelDefinesByProperties definesByProperties = (IfcRelDefinesByProperties)defines;
								IfcPropertySetDefinition relatingPropertyDefinition = definesByProperties.getRelatingPropertyDefinition();
								if (relatingPropertyDefinition instanceof IfcElementQuantity) {
									IfcElementQuantity elementQuantity = (IfcElementQuantity)relatingPropertyDefinition;
									EList<IfcPhysicalQuantity> quantities = elementQuantity.getQuantities();
									for (IfcPhysicalQuantity physicalQuantity : quantities) {
										if (physicalQuantity instanceof IfcQuantityArea) {
											IfcQuantityArea area = (IfcQuantityArea)physicalQuantity;
											float areaValue = area.getAreaValue();
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
