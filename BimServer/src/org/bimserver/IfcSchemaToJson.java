package org.bimserver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

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
						jsonWriter.value(eStructuralFeature.getEType().getName());
						jsonWriter.name("reference");
						jsonWriter.value(eStructuralFeature instanceof EReference && !eStructuralFeature.getName().equals("GlobalId"));
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
}
