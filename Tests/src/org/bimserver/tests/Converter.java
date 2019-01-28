//package org.bimserver.tests;

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

//import org.eclipse.emf.common.util.EList;
//import org.eclipse.emf.common.util.URI;
//import org.eclipse.emf.ecore.EClass;
//import org.eclipse.emf.ecore.EEnum;
//import org.eclipse.emf.ecore.EEnumLiteral;
//import org.eclipse.emf.ecore.EObject;
//import org.eclipse.emf.ecore.EPackage;
//import org.eclipse.emf.ecore.EcoreFactory;
//import org.eclipse.emf.ecore.resource.Resource;
//import org.eclipse.emf.ecore.resource.ResourceSet;
//import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
//import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
//import org.eclipse.xsd.XSDComplexTypeDefinition;
//import org.eclipse.xsd.XSDEnumerationFacet;
//import org.eclipse.xsd.XSDSchema;
//import org.eclipse.xsd.XSDSimpleTypeDefinition;
//import org.eclipse.xsd.XSDTypeDefinition;
//import org.eclipse.xsd.util.XSDResourceFactoryImpl;
//import org.eclipse.xsd.util.XSDResourceImpl;
//
//public class Converter {
//	private EcoreFactory ecoreFactory = EcoreFactory.eINSTANCE;
//	private EPackage ePackage;
//
//	public static void main(String[] args) {
//		new Converter().convert();
//	}
//	
//	public void convert() {
//		System.out.println("Starting");
//		ePackage = ecoreFactory.createEPackage();
//		ePackage.setName("ifc2x3");
//		ePackage.setNsPrefix("iai");
//		ePackage.setNsURI("http:///buildingsmart.ifc.ecore");
//
//		ResourceSet resourceSet = new ResourceSetImpl();
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xsd", new XSDResourceFactoryImpl());
//		XSDResourceImpl xsdSchemaResource = (XSDResourceImpl)resourceSet.getResource(URI.createFileURI("IFC2X3.xsd"), true);
//		EList<EObject> contents = xsdSchemaResource.getContents();
//		for (EObject eObject : contents) {
//			if (eObject instanceof XSDSchema) {
//				XSDSchema xsdSchema = (XSDSchema)eObject;
//				
//				
//				
//				for (XSDTypeDefinition xsdTypeDefinition : xsdSchema.getTypeDefinitions()) {
//					if (xsdTypeDefinition instanceof XSDSimpleTypeDefinition) {
//						processSimpleType((XSDSimpleTypeDefinition)xsdTypeDefinition);
//					} else if (xsdTypeDefinition instanceof XSDComplexTypeDefinition) {
//						processComplexType((XSDComplexTypeDefinition)xsdTypeDefinition);
//					}
//				}
//			}
//		}
//		
////		XSDEcoreBuilder xsdEcoreBuilder = new XSDEcoreBuilder();
////		Collection eCorePackages = xsdEcoreBuilder.generate(URI.createFileURI("IFC2X3.xsd"));
////
////		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
////		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
////		Resource resource = resourceSet.createResource(URI.createFileURI("ifc2x3.ecore"));
////
////		for (Iterator iter = eCorePackages.iterator(); iter.hasNext();) {
////			EPackage element = (EPackage) iter.next();
////			resource.getContents().add(element);
////		}
////
////		try {
////			resource.save(null);
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
//
//		writeEMF("ifc2x3.ecore");
//		System.out.println("Finished");
//	}
//	
//	public void writeEMF(String fileName) {
//		ResourceSet metaResourceSet = new ResourceSetImpl();
//		metaResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMLResourceFactoryImpl());
//
//		URI resUri = URI.createURI(fileName);
//		Resource metaResource = metaResourceSet.createResource(resUri);
//		metaResource.getContents().add(ePackage);
//		try {
//			metaResource.save(null);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private void processComplexType(XSDComplexTypeDefinition xsdTypeDefinition) {
//		EClass eClass = ecoreFactory.createEClass();
//		eClass.setName(xsdTypeDefinition.getName());
//		ePackage.getEClassifiers().add(eClass);
//	}
//
//	private void processSimpleType(XSDSimpleTypeDefinition xsdTypeDefinition) {
//		if (!xsdTypeDefinition.getEnumerationFacets().isEmpty()) {
//			EEnum eEnum = ecoreFactory.createEEnum();
//			eEnum.setName(xsdTypeDefinition.getName());
//			int i=0;
//			for (XSDEnumerationFacet enumerationFacet : xsdTypeDefinition.getEnumerationFacets()) {
//				EEnumLiteral eEnumLiteral = ecoreFactory.createEEnumLiteral();
//				eEnumLiteral.setName(enumerationFacet.getLexicalValue());
//				eEnumLiteral.setValue(i++);
//				eEnum.getELiterals().add(eEnumLiteral);
//			}
//			ePackage.getEClassifiers().add(eEnum);
//		}
//	}
//}