package org.bimserver.tests;

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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.xml.sax.SAXException;

import com.sun.xml.xsom.XSComplexType;
import com.sun.xml.xsom.XSElementDecl;
import com.sun.xml.xsom.XSFacet;
import com.sun.xml.xsom.XSModelGroup;
import com.sun.xml.xsom.XSModelGroupDecl;
import com.sun.xml.xsom.XSParticle;
import com.sun.xml.xsom.XSSchema;
import com.sun.xml.xsom.XSSchemaSet;
import com.sun.xml.xsom.XSSimpleType;
import com.sun.xml.xsom.XSTerm;
import com.sun.xml.xsom.impl.RestrictionSimpleTypeImpl;
import com.sun.xml.xsom.parser.XSOMParser;

public class XSDSchemaReader {
	private EcorePackage ecorePackage = EcorePackage.eINSTANCE;
	private EcoreFactory ecoreFactory = EcoreFactory.eINSTANCE;
	private EPackage ePackage;

	public static void main(String[] args) {
		new XSDSchemaReader().start();
	}

	@SuppressWarnings("deprecation")
	private void start() {
		ePackage = ecoreFactory.createEPackage();
		ePackage.setName("ifc2x3");
		ePackage.setNsPrefix("iai");
		ePackage.setNsURI("http:///buildingsmart.ifc.ecore");

		XSOMParser parser = new XSOMParser();
//		parser.setErrorHandler(new DefaultErrorHandler());

		try {
			parser.parse(getClass().getResource("IFC2X3.xsd"));
			XSSchemaSet schemas = parser.getResult();
			for (XSSchema schema : schemas.getSchemas()) {
				if (schema.getTargetNamespace().equals("http://www.iai-tech.org/ifcXML/IFC2x3/FINAL")) {
					for (XSComplexType type : schema.getComplexTypes().values()) {
						createComplexType(type);
					}
					for (XSSimpleType simpleType : schema.getSimpleTypes().values()) {
						createSimpleType(simpleType);
					}
				}
			}
			for (XSSchema schema : schemas.getSchemas()) {
				if (schema.getTargetNamespace().equals("http://www.iai-tech.org/ifcXML/IFC2x3/FINAL")) {
					for (XSComplexType type : schema.getComplexTypes().values()) {
						fillComplexType(type);
					}
					for (XSModelGroupDecl modelGroupDecl : schema.getModelGroupDecls().values()) {
						createGroup(modelGroupDecl);
					}
				}
			}
			writeEMF("test.ecore");
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}

	private void createGroup(XSModelGroupDecl modelGroupDecl) {
		EClass eClass = ecoreFactory.createEClass();
		eClass.setName(modelGroupDecl.getName());
		ePackage.getEClassifiers().add(eClass);
		for (XSParticle particle : modelGroupDecl.getModelGroup().getChildren()) {
			XSTerm term = particle.getTerm();
			if (term.isElementDecl()) {
				String name = term.asElementDecl().getName();
				EClassifier subClass = ePackage.getEClassifier(name);
				if (subClass != null && subClass instanceof EClass) {
					((EClass) subClass).getESuperTypes().add(eClass);
				}
			}
		}
	}

	private void createSimpleType(XSSimpleType simpleType) {
		if (simpleType instanceof RestrictionSimpleTypeImpl) {
			RestrictionSimpleTypeImpl restrictionSimpleTypeImpl = (RestrictionSimpleTypeImpl) simpleType;
			String typeName = restrictionSimpleTypeImpl.getBaseType().getName();
			if (typeName.equals("string")) {
				EEnum eEnum = ecoreFactory.createEEnum();
				eEnum.setName(simpleType.getName());
				ePackage.getEClassifiers().add(eEnum);
				int i = 0;
				for (XSFacet facet : restrictionSimpleTypeImpl.getDeclaredFacets()) {
					EEnumLiteral eEnumLiteral = ecoreFactory.createEEnumLiteral();
					eEnumLiteral.setValue(i++);
					eEnum.getELiterals().add(eEnumLiteral);
					eEnumLiteral.setName(facet.getValue().toString().toUpperCase());
				}
			} else if (typeName.equals("double")) {
				EClass eClass = ecoreFactory.createEClass();
				eClass.setName(simpleType.getName());
				ePackage.getEClassifiers().add(eClass);
			} else if (typeName.equals("normalizedString")) {
				EClass eClass = ecoreFactory.createEClass();
				eClass.setName(simpleType.getName());
				ePackage.getEClassifiers().add(eClass);
			} else if (typeName.equals("boolean")) {
				EClass eClass = ecoreFactory.createEClass();
				eClass.setName(simpleType.getName());
				ePackage.getEClassifiers().add(eClass);
			} else if (typeName.equals("long")) {
				EClass eClass = ecoreFactory.createEClass();
				eClass.setName(simpleType.getName());
				ePackage.getEClassifiers().add(eClass);
			} else {
				EClass eClass = ecoreFactory.createEClass();
				eClass.setName(simpleType.getName());
				ePackage.getEClassifiers().add(eClass);
			}
		} else {
			System.out.println(simpleType.getName());
		}
	}

	private void fillComplexType(XSComplexType type) {
		EClass eClass = (EClass) ePackage.getEClassifier(type.getName());
		String superTypeName = type.getBaseType().getName();
		EClass superType = (EClass) ePackage.getEClassifier(superTypeName);
		if (superType != null) {
			eClass.getESuperTypes().add(superType);
		} else {
			if (!superTypeName.equals("Entity") && !superTypeName.equals("anyType")) {
				System.out.println("Super type not found: " + superTypeName);
			}
		}
		XSParticle particle = type.getContentType().asParticle();
		if (particle != null) {
			XSTerm term = particle.getTerm();
			if (term.isModelGroup()) {
				XSModelGroup xsModelGroup = term.asModelGroup();
				for (XSParticle p : xsModelGroup.getChildren()) {
					XSTerm pterm = p.getTerm();
					if (pterm.isModelGroup()) {
						XSModelGroup asModelGroup = pterm.asModelGroup();
						for (XSParticle x : asModelGroup.getChildren()) {
							XSTerm term2 = x.getTerm();
							if (term2.isElementDecl()) {
								processElementDecl(eClass, term2.asElementDecl());
							}
						}
					} else if (pterm.isElementDecl()) {
						processElementDecl(eClass, pterm.asElementDecl());
					}
				}
			} else if (term.isModelGroupDecl()) {
				// EReference eReference = ecoreFactory.createEReference();
				// eReference.setName(term.asModelGroupDecl().getName());
				// EClassifier eClassifier =
				// ePackage.getEClassifier(term.asModelGroupDecl().getName());
				// eReference.setEType(eClassifier);
				// eClass.getEStructuralFeatures().add(eReference);
			} else if (term.isElementDecl()) {
				System.out.println("ed");
			} else {
				System.out.println("lala");
			}
		}
	}

	private void processElementDecl(EClass eClass, XSElementDecl asElementDecl) {
		String propertyName = asElementDecl.getName();
		String propertyType = null;
		if (asElementDecl.getType().getName() != null) {
			propertyType = asElementDecl.getType().getName();
			if (propertyType.equals("double")) {
				EAttribute eAttribute = ecoreFactory.createEAttribute();
				eAttribute.setName(propertyName);
				eAttribute.setEType(ecorePackage.getEDouble());
				eClass.getEStructuralFeatures().add(eAttribute);
			} else if (propertyType.equals("long")) {
				EAttribute eAttribute = ecoreFactory.createEAttribute();
				eAttribute.setName(propertyName);
				eAttribute.setEType(ecorePackage.getELong());
				eClass.getEStructuralFeatures().add(eAttribute);
			} else if (propertyType.equals("boolean") || propertyType.equals("logical")) {
				EAttribute eAttribute = ecoreFactory.createEAttribute();
				eAttribute.setName(propertyName);
				eAttribute.setEType(ecorePackage.getEBoolean());
				eClass.getEStructuralFeatures().add(eAttribute);
			} else if (propertyType.equals("anyType")) {
				XSComplexType asComplexType = asElementDecl.getType().asComplexType();
				EReference eReference = ecoreFactory.createEReference();
				eReference.setEType(createComplexType(asComplexType));
				eReference.setName(propertyName);
				eClass.getEStructuralFeatures().add(eReference);
			} else {
				EClassifier eClassifier = ePackage.getEClassifier(propertyType);
				if (eClassifier != null) {
					EReference eReference = ecoreFactory.createEReference();
					eReference.setName(propertyName);
					eReference.setEType(eClassifier);
					eClass.getEStructuralFeatures().add(eReference);
				} else {
					System.out.println(propertyType + " not found");
				}
			}
		}
	}

	public void writeEMF(String fileName) {
		ResourceSet metaResourceSet = new ResourceSetImpl();
		metaResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMLResourceFactoryImpl());

		URI resUri = URI.createURI(fileName);
		Resource metaResource = metaResourceSet.createResource(resUri);
		metaResource.getContents().add(ePackage);
		try {
			metaResource.save(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private EClass createComplexType(XSComplexType type) {
		EClass eClass = ecoreFactory.createEClass();
		eClass.setName(type.getName());
		ePackage.getEClassifiers().add(eClass);
		return eClass;
	}
}