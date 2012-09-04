package org.bimserver.objectidms;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.objectidms.AbstractObjectIDM;
import org.bimserver.plugins.objectidms.ObjectIDMException;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;

public class FileBasedObjectIDM extends AbstractObjectIDM {

	public FileBasedObjectIDM(SchemaDefinition schemaDefinition, PluginContext pluginContext) throws ObjectIDMException {
		super(schemaDefinition);
		try {
			URL ignoreFile = pluginContext.getResourceAsUrl("objectidm.xml");
			PackageDefinition packageDefinition = PackageDefinition.readFromFile(ignoreFile);
			if (!packageDefinition.getName().equals("Ifc2x3")) {
				throw new ObjectIDMException("Package must be Ifc2x3");
			}
			final Ifc2x3tc1Package ifc2x3tc1Package = Ifc2x3tc1Package.eINSTANCE;
			List<ClassDefinition> classes = new ArrayList<ClassDefinition>(packageDefinition.getClassDefinitions());
			for (ClassDefinition classDefinition : classes) {
				if (!classDefinition.getName().equals("Object")) {
					EClassifier eClassifier = ifc2x3tc1Package.getEClassifier(classDefinition.getName());
					if (eClassifier == null) {
						throw new ObjectIDMException(classDefinition.getName() + " not found");
					} else if (!(eClassifier instanceof EClass)) {
						throw new ObjectIDMException(classDefinition.getName() + " not an EClass");
					}
				}
				if (classDefinition.getOrigin() != null) {
					EClassifier eClassifier = ifc2x3tc1Package.getEClassifier(classDefinition.getOrigin());
					if (eClassifier == null) {
						throw new ObjectIDMException(classDefinition.getName() + " not found");
					} else if (!(eClassifier instanceof EClass)) {
						throw new ObjectIDMException(classDefinition.getName() + " not an EClass");
					}
				}
			}
			Collections.sort(classes, new Comparator<ClassDefinition>() {
				@Override
				public int compare(ClassDefinition o1, ClassDefinition o2) {
					if (o1.getName().equals("Object")) {
						return -1;
					} else if (o2.getName().equals("Object")) {
						return 1;
					}
					EClass eClass1 = (EClass) ifc2x3tc1Package.getEClassifier(o1.getName());
					EClass eClass2 = (EClass) ifc2x3tc1Package.getEClassifier(o2.getName());
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
						for (EClassifier eClassifier : ifc2x3tc1Package.getEClassifiers()) {
							if (eClassifier instanceof EClass) {
								processClassDefinition(this, classDefinition, (EClass) eClassifier);
							}
						}
					} else {
						processClassDefinition(this, classDefinition, (EClass) ifc2x3tc1Package.getEClassifier(classDefinition.getName()));
					}
				} else {
					EClass originClass = (EClass) ifc2x3tc1Package.getEClassifier(classDefinition.getOrigin());
					processClassDefinition(getOrigin(originClass), classDefinition, (EClass) ifc2x3tc1Package.getEClassifier(classDefinition.getName()));
				}
			}
		} catch (JAXBException e) {
			throw new ObjectIDMException(e);
		} catch (IOException e) {
			throw new ObjectIDMException(e);
		}
	}

	private void processClassDefinition(AbstractObjectIDM abstractObjectIDM, ClassDefinition classDefinition, EClass eClass) throws ObjectIDMException {
		if (classDefinition.isInclude()) {
			abstractObjectIDM.include(eClass);
			for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
				if ((classDefinition.isFollowNonInverses() && !isInverse(eStructuralFeature)) || !(classDefinition.isFollowNonInverses() && isInverse(eStructuralFeature))) {
					abstractObjectIDM.include(eClass, eStructuralFeature);
				} else {
					abstractObjectIDM.exclude(eClass, eStructuralFeature);
				}
			}
			for (FieldDefinition fieldDefinition : classDefinition.getFieldDefinitions()) {
				EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(fieldDefinition.getName());
				if (eStructuralFeature == null) {
					throw new ObjectIDMException("Field " + fieldDefinition.getName() + " not found on " + eClass.getName());
				}
				if (fieldDefinition.isFollow()) {
					abstractObjectIDM.include(eClass, eStructuralFeature);
				} else {
					abstractObjectIDM.exclude(eClass, eStructuralFeature);
				}
			}
		} else {
			abstractObjectIDM.exclude(eClass);
		}
	}
}