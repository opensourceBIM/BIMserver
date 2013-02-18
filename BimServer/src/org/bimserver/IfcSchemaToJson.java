package org.bimserver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.shared.IfcDoc;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import com.google.gson.stream.JsonWriter;

public class IfcSchemaToJson {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(new File("www/js/ifc2x3tc1.json"));
			new IfcSchemaToJson().convert(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void convert(OutputStream outputStream) throws IOException {
		IfcDoc ifcDoc = new IfcDoc(new File("C:\\Users\\Ruben de Laat\\Downloads\\IFC2x3_TC1_HTML_distribution-pset_errata\\R2x3_TC1"));
		
		JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(outputStream));
		jsonWriter.setIndent("  ");
		try {
			jsonWriter.beginObject();
			jsonWriter.name("classes");
			jsonWriter.beginObject();
			for (EClassifier eClassifier : Ifc2x3tc1Package.eINSTANCE.getEClassifiers()) {
				jsonWriter.name(eClassifier.getName());
				jsonWriter.beginObject();
				if (eClassifier instanceof EEnum) {
					
				} else if (eClassifier instanceof EClass) {
					EClass eClass = (EClass)eClassifier;
					String domain = ifcDoc.getDomain(eClass.getName());
					jsonWriter.name("domain");
					jsonWriter.value(domain);
					jsonWriter.name("superclasses");
					jsonWriter.beginArray();
					for (EClass superClass : eClass.getESuperTypes()) {
						jsonWriter.value(superClass.getName());
					}
					jsonWriter.endArray();
					
					jsonWriter.name("fields");
					jsonWriter.beginObject();
					for (EStructuralFeature eStructuralFeature : eClass.getEStructuralFeatures()) {
						jsonWriter.name(eStructuralFeature.getName());
						jsonWriter.beginObject();
						jsonWriter.name("type");
						jsonWriter.value(convertType(eStructuralFeature.getEType()));
						jsonWriter.name("reference");
						jsonWriter.value(eStructuralFeature instanceof EReference);
						jsonWriter.name("many");
						jsonWriter.value(eStructuralFeature.isMany());
						jsonWriter.endObject();
					}
					jsonWriter.endObject();
				}
				jsonWriter.endObject();
			}
			jsonWriter.endObject();
			jsonWriter.endObject();
		} finally {
			jsonWriter.close();
		}
	}

	private String convertType(EClassifier type) {
		if (type == EcorePackage.eINSTANCE.getEDouble() || type == EcorePackage.eINSTANCE.getEDoubleObject()) {
			return "double";
		} else if (type == EcorePackage.eINSTANCE.getEInt() || type == EcorePackage.eINSTANCE.getEIntegerObject()) {
			return "int";
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