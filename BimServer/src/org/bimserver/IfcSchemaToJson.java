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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.bimserver.models.geometry.GeometryPackage;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.shared.IfcDoc;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class IfcSchemaToJson {
	public static void main(String[] args) {
		generateGeometry();
		generateIfc2x3tc1(args[0]);
		generateIfc4(args[1]);
	}

	private static void generateIfc4(String location) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(new File("www/js/ifc4.js"));
			new IfcSchemaToJson().convert(fos, new File(location), Ifc4Package.eINSTANCE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void generateIfc2x3tc1(String location) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(new File("www/js/ifc2x3tc1.js"));
			new IfcSchemaToJson().convert(fos, new File(location), Ifc2x3tc1Package.eINSTANCE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void generateGeometry() {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(new File("www/js/geometry.js"));
			new IfcSchemaToJson().convert(fos, null, GeometryPackage.eINSTANCE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void convert(OutputStream outputStream, File docs, EPackage ePackage) throws IOException {
		IfcDoc ifcDoc = null;
		if (docs != null) {
			ifcDoc = new IfcDoc(docs);
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode root = objectMapper.createObjectNode();
		ObjectNode classes = objectMapper.createObjectNode();
		root.set("classes", classes);
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			ObjectNode classifierNode = objectMapper.createObjectNode();
			classes.set(eClassifier.getName(), classifierNode);
			if (eClassifier instanceof EEnum) {
				
			} else if (eClassifier instanceof EClass) {
				EClass eClass = (EClass)eClassifier;
				String domain = "geometry";
				if (ifcDoc != null) {
					domain = ifcDoc.getDomain(eClass.getName());
				}
				classifierNode.put("domain", domain);
				ArrayNode superClassesNode = objectMapper.createArrayNode();
				classifierNode.set("superclasses", superClassesNode);
				
				for (EClass superClass : eClass.getESuperTypes()) {
					superClassesNode.add(superClass.getName());
				}

				ObjectNode fieldsNode = objectMapper.createObjectNode();
				classifierNode.set("fields", fieldsNode);
				for (EStructuralFeature eStructuralFeature : eClass.getEStructuralFeatures()) {
					ObjectNode fieldNode = objectMapper.createObjectNode();
					fieldsNode.set(eStructuralFeature.getName(), fieldNode);
					fieldNode.put("type", convertType(eStructuralFeature.getEType()));
					fieldNode.put("reference", eStructuralFeature instanceof EReference);
					fieldNode.put("many", eStructuralFeature.isMany());
					fieldNode.put("inverse", eStructuralFeature.getEAnnotation("inverse") != null);
				}
			}
		}
		objectMapper.writerWithDefaultPrettyPrinter().writeValue(outputStream, root);
	}

	private String convertType(EClassifier type) {
		if (type == EcorePackage.eINSTANCE.getEDouble() || type == EcorePackage.eINSTANCE.getEDoubleObject()) {
			return "double";
		} else if (type == EcorePackage.eINSTANCE.getEInt() || type == EcorePackage.eINSTANCE.getEIntegerObject()) {
			return "int";
		} else if (type == EcorePackage.eINSTANCE.getEShort() || type == EcorePackage.eINSTANCE.getEShortObject()) {
			return "short";
		} else if (type == EcorePackage.eINSTANCE.getEBoolean() || type == EcorePackage.eINSTANCE.getEBooleanObject()) {
			return "boolean";
		} else if (type == EcorePackage.eINSTANCE.getEByteArray()) {
			return "bytearray";
		} else if (type == EcorePackage.eINSTANCE.getELong() || type == EcorePackage.eINSTANCE.getELongObject()) {
			return "long";
		} else if (type == EcorePackage.eINSTANCE.getEString()) {
			return "string";
		} else if (type instanceof EEnum) {
			return "enum";
		}
		return type.getName();
	}
}