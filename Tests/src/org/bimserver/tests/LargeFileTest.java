package org.bimserver.tests;

import java.io.File;
import java.util.List;

import nl.tue.buildingsmart.emf.SchemaLoader;

import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.step.deserializer.IfcStepDeserializer;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.sun.xml.internal.ws.encoding.soap.DeserializationException;

public class LargeFileTest {
	public static void main(String[] args) {
		new LargeFileTest().start();
	}

	@SuppressWarnings("rawtypes")
	private void start() {
		SchemaDefinition schema = SchemaLoader.loadDefaultSchema();
		IfcStepDeserializer deserializer = new IfcStepDeserializer();
		deserializer.init(schema);
		try {
			IfcModel model = deserializer.read(new File("C:\\Users\\Ruben de Laat\\Documents\\My Dropbox\\Shared\\BIMserver\\arcadis\\KW02.ifc"));
			for (IdEObject idEObject : model.getValues()) {
				for (EStructuralFeature eStructuralFeature : idEObject.eClass().getEAllStructuralFeatures()) {
					if (eStructuralFeature.isMany()) {
						List list = (List)idEObject.eGet(eStructuralFeature);
						if (list.size() > 1000) {
							System.out.println(idEObject.getOid() + " " + idEObject.eClass().getName() + " " + eStructuralFeature.getName() + ": " + list.size());
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
