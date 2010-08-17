package org.bimserver.database;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

public class EnhancedClassReader {
	public static void main(String[] args) {
		new EnhancedClassReader().read();
	}

	void read() {
		ResourceSet rst = new ResourceSetImpl();
		Resource.Factory ecoreResourceFactory = new EcoreResourceFactoryImpl();
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", ecoreResourceFactory);
		EPackage ecorepack = EcorePackage.eINSTANCE;
		URI file = URI.createFileURI("enhanced/Enhanced.ecore");
		Resource rs = rst.getResource(file, true);
		ecorepack = (EPackage) rs.getContents().get(0);
		rst.setResourceFactoryRegistry(reg);
		for (EClassifier eClassifier : ecorepack.getEClassifiers()) {
			System.out.println(eClassifier.getName());
		}
	}
}
