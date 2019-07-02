package org.bimserver;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map.Entry;

import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.Schema;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc4.Ifc4Package;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.io.Files;

public class GenerateGeometryLibrary {
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private ObjectNode rootNode;
	private ObjectNode definesNode;
	private PackageMetaData packageMetaData;
	private EPackage ePackage;
	
	public static void main(String[] args) {
		new GenerateGeometryLibrary().generate(Ifc2x3tc1Package.eINSTANCE, Schema.IFC2X3TC1);
		new GenerateGeometryLibrary().generate(Ifc4Package.eINSTANCE, Schema.IFC4);
	}

	private void generate(EPackage ePackage, Schema schema) {
		this.ePackage = ePackage;
		packageMetaData = new PackageMetaData(ePackage, schema, Paths.get("tmp"));
		rootNode = OBJECT_MAPPER.createObjectNode();
		
		definesNode = OBJECT_MAPPER.createObjectNode();
		rootNode.set("defines", definesNode);

		process((EClass) ePackage.getEClassifier("IfcShapeRepresentation"), (EClass) ePackage.getEClassifier("IfcRepresentation"));
//		cleanup();
		try {
			Files.write(OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsBytes(rootNode), new File("C:\\Users\\Ruben de Laat\\git\\BIMserver\\BimServer\\src\\org\\bimserver\\database\\queries\\json\\" + schema.name().toLowerCase() + "-geometry.json"));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void cleanup() {
		Iterator<Entry<String, JsonNode>> fields = definesNode.fields();
		while (fields.hasNext()) {
			Entry<String, JsonNode> entry = fields.next();
			if (entry.getValue().get("fields").size() == 0) {
				fields.remove();
			}
		}
		fields = definesNode.fields();
		while (fields.hasNext()) {
			Entry<String, JsonNode> entry = fields.next();
			ArrayNode includes = (ArrayNode) entry.getValue().get("includes");
			Iterator<JsonNode> includesIterator = includes.iterator();
			while (includesIterator.hasNext()) {
				JsonNode includeNode = includesIterator.next();
				if (!definesNode.has(includeNode.asText())) {
					// TODO replace the include with the closest super-type? Or don't allow deleting defines that are explicitly referenced (although no fields)
					includesIterator.remove();
				}
			}
		}
	}

	private void process(EClass... eClasses) {
		for (EClass eClass : eClasses) {
			for (EClass subClass : packageMetaData.getAllSubClassesIncludingSelf(eClass)) {
				process(subClass, null);
			}
		}
	}
	
	private void process(EClass eClass, EReference eReferencedFrom) {
		if (definesNode.has(eClass.getName())) {
			return;
		}
//		if (eReferencedFrom != null) {
//			System.out.println(eReferencedFrom.getEContainingClass().getName() + "." + eReferencedFrom.getName() + " -> " + eClass.getName());
//		}
		ObjectNode defineNode = OBJECT_MAPPER.createObjectNode();
		definesNode.set(eClass.getName(), defineNode);
		
		// TODO no type node required, subclasses always used
		ObjectNode typeNode = OBJECT_MAPPER.createObjectNode();
		typeNode.put("name", eClass.getName());
		typeNode.put("includeAllSubTypes", true);
		defineNode.set("type", typeNode);
		
		ArrayNode fieldsNode = OBJECT_MAPPER.createArrayNode();
		defineNode.set("fields", fieldsNode);
		
		ArrayNode includesNode = OBJECT_MAPPER.createArrayNode();
		defineNode.set("includes", includesNode);
		for (EReference eReference : eClass.getEAllReferences()) {
			if (!packageMetaData.isInverse(eReference) || isException(eReference)) {
				EClass eType = (EClass) eReference.getEType();
				if (eType.getEPackage() == ePackage) {
					for (EClass eClass2 : packageMetaData.getAllSubClassesIncludingSelf(eType)) {
						if (eClass2.getEAnnotation("wrapped") == null) {
							process(eClass2);
							includesNode.add(eClass2.getName());
						}
					}
					fieldsNode.add(eReference.getName());
				}
			}
		}
	}

	private boolean isException(EReference eReference) {
		if (eReference.getEContainingClass().getName().contentEquals("IfcRepresentationItem") && eReference.getName().contentEquals("StyledByItem")) {
			return true;
		}
		return false;
	}
}
