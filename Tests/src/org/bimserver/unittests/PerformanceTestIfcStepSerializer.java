package org.bimserver.unittests;

import static org.junit.Assert.fail;

import java.io.File;
import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;
import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.ifc.IfcModel;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.Test;

public class PerformanceTestIfcStepSerializer {
	@Test
	public void performanceTest() {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(new File("home"));
			SerializerPlugin serializerPlugin = pluginManager.getFirstSerializerPlugin("application/ifc", true);
			Serializer serializer = serializerPlugin.createSerializer();
			IfcModel model = new IfcModel();
			EList<EClassifier> classifiers = Ifc2x3tc1Package.eINSTANCE.getEClassifiers();
			for (int i=0; i<100000; i++) {
				EClassifier eClassifier = classifiers.get(new Random().nextInt(classifiers.size()));
				if (eClassifier instanceof EClass && !((EClass) eClassifier).isInterface() && eClassifier != Ifc2x3tc1Package.eINSTANCE.getWrappedValue()) {
					IdEObject eObject = (IdEObject) Ifc2x3tc1Factory.eINSTANCE.create((EClass) eClassifier);
					for (EStructuralFeature eStructuralFeature : eObject.eClass().getEAllStructuralFeatures()) {
						if (!eStructuralFeature.isMany()) {
							if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEString()) {
								eObject.eSet(eStructuralFeature, RandomStringUtils.random(new Random().nextInt(50)));
							}
						}
					}
					try {
						model.add(eObject);
					} catch (IfcModelInterfaceException e) {
						e.printStackTrace();
					}
				}
			}
			serializer.init(model, null, pluginManager, pluginManager.requireIfcEngine().createIfcEngine());
			long start = System.nanoTime();
			serializer.writeToFile(new File("output/test.ifc"));
			System.out.println("Serialize took: " + ((System.nanoTime() - start) / 1000000) + "ms");
		} catch (PluginException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (SerializerException e) {
			e.printStackTrace();
		}
	}
}