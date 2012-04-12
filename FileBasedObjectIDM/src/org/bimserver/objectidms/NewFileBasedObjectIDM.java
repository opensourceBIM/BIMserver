package org.bimserver.objectidms;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.plugins.ObjectIDMException;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;

public class NewFileBasedObjectIDM extends NewObjectIDM {

	public NewFileBasedObjectIDM(SchemaDefinition schemaDefinition, PluginContext pluginContext) throws ObjectIDMException {
		super(schemaDefinition);
		try {
			URL ignoreFile = pluginContext.getResourceAsUrl("objectidm.xml");
			PackageDefinition packageDefinition = PackageDefinition.readFromFile(ignoreFile);
			if (!packageDefinition.getName().equals("Ifc2x3")) {
				throw new ObjectIDMException("Package must be Ifc2x3");
			}
			final Ifc2x3Package ifc2x3Package = Ifc2x3Package.eINSTANCE;
			List<ClassDefinition> classes = new ArrayList<ClassDefinition>(packageDefinition.getClassDefinitions());
			Collections.sort(classes, new Comparator<ClassDefinition>() {
				@Override
				public int compare(ClassDefinition o1, ClassDefinition o2) {
					if (o1.getName().equals("Object")) {
						return -1;
					} else if (o2.getName().equals("Object")) {
						return 1;
					}
					EClassifier eClassifier1 = ifc2x3Package.getEClassifier(o1.getName());
					if (eClassifier1 == null) {
						System.out.println(o1.getName() + " not found");
					}
					EClassifier eClassifier2 = ifc2x3Package.getEClassifier(o2.getName());
					if (eClassifier2 == null) {
						System.out.println(o2.getName() + " not found");
					}
					EClass eClass1 = (EClass) eClassifier1;
					EClass eClass2 = (EClass) eClassifier2;
					if (eClass1.isSuperTypeOf(eClass2)) {
						return 1;
					} else if (eClass2.isSuperTypeOf(eClass1)) {
						return -1;
					}
					return 0;
				}
			});
			for (ClassDefinition classDefinition : classes) {
				if (classDefinition.getOrigin() == null) {
					if (classDefinition.getName().equals("Object")) {
					} else {
						EClassifier eClassifier = ifc2x3Package.getEClassifier(classDefinition.getName());
						if (eClassifier == null) {
							throw new ObjectIDMException("Class not found: " + classDefinition.getName());
						} else if (!(eClassifier instanceof EClass)) {
							throw new ObjectIDMException("Classifier not a valid Class: " + classDefinition.getName());
						}
						EClass eClass = (EClass) eClassifier;
						if (classDefinition.isInclude()) {
							include(eClass);
							for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
								if ((classDefinition.isFollowNonInverses() && !isInverse(eStructuralFeature))
										|| !(classDefinition.isFollowNonInverses() && isInverse(eStructuralFeature))) {
									include(eStructuralFeature);
								} else {
									exclude(eStructuralFeature);
								}
							}
							for (FieldDefinition fieldDefinition : classDefinition.getFieldDefinitions()) {
								EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(fieldDefinition.getName());
								if (eStructuralFeature == null) {
									throw new ObjectIDMException("Field " + fieldDefinition.getName() + " not found on " + eClass.getName());
								}
								if (fieldDefinition.isFollow()) {
									include(eStructuralFeature);
								} else {
									exclude(eStructuralFeature);
								}
							}
						} else {
							exclude(eClass);
						}
					}
				} else {

				}

			}
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(toString());
	}
}