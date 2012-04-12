package org.bimserver.objectidms;

import java.io.File;

import javax.xml.bind.JAXBException;

public class DefaultWriter {
	public static void main(String[] args) {
		new DefaultWriter().write();
	}

	private void write() {
		PackageDefinition packageDefinition = new PackageDefinition();
		packageDefinition.setName("Ifc2x3");

		ClassDefinition objectDefinition = new ClassDefinition();
		objectDefinition.setName("Object");
		packageDefinition.getClassDefinitions().add(objectDefinition);
		
		ClassDefinition ifcElement = new ClassDefinition();
		ifcElement.setName("IfcElement");
		packageDefinition.getClassDefinitions().add(ifcElement);
		
		FieldDefinition hasOpenings = new FieldDefinition();
		hasOpenings.setName("HasOpenings");
		hasOpenings.setFollow(true);
		ifcElement.getFieldDefinitions().add(hasOpenings);
		
		ClassDefinition ifcObjectDefinition = new ClassDefinition();
		ifcObjectDefinition.setName("IfcObjectDefinition");
		ifcObjectDefinition.setOrigin("IfcBuildingStorey");
		packageDefinition.getClassDefinitions().add(ifcObjectDefinition);
		
		FieldDefinition isDecomposedBy = new FieldDefinition();
		isDecomposedBy.setName("IsDecomposedBy");
		isDecomposedBy.setFollow(true);
		ifcObjectDefinition.getFieldDefinitions().add(isDecomposedBy);

		ClassDefinition ifcSpatialStructureElement = new ClassDefinition();
		ifcSpatialStructureElement.setName("IfcSpatialStructureElement");
		ifcSpatialStructureElement.setOrigin("IfcBuildingStorey");
		packageDefinition.getClassDefinitions().add(ifcSpatialStructureElement);
		
		FieldDefinition containsElements = new FieldDefinition();
		containsElements.setName("ContainsElements");
		containsElements.setFollow(true);
		ifcSpatialStructureElement.getFieldDefinitions().add(containsElements);
		
		try {
			packageDefinition.writeToFile(new File("objectidm.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
