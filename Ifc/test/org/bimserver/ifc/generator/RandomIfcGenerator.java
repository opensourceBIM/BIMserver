package org.bimserver.ifc.generator;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.ifc.IfcModel;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RandomIfcGenerator {
	private static final Logger LOGGER = LoggerFactory.getLogger(RandomIfcGenerator.class);
	private List<IdEObject> objects;
	private final ExtendedMetaModel metaModel = new ExtendedMetaModel(Ifc2x3tc1Package.eINSTANCE);
	private final Random random = new Random();
	
	public static void main(String[] args) {
		new RandomIfcGenerator().generate(4000000);
	}
	
	public void generate(int nrObjects) {
		objects = new ArrayList<IdEObject>(nrObjects);
		IfcProject ifcProject = Ifc2x3tc1Factory.eINSTANCE.createIfcProject();
		objects.add(ifcProject);
		for (int i=1; i<nrObjects; i++) {
			if (!createObject()) {
				i--;
			}
		}
		IfcModel ifcModel = new IfcModel(objects.size());
		long i=0;
		for (IdEObject idEObject : objects) {
			try {
				ifcModel.add(i++, idEObject);
			} catch (IfcModelInterfaceException e) {
				LOGGER.error("", e);
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private boolean createObject() {
		IdEObject baseObject = objects.get(random.nextInt(objects.size()));
		EList<EReference> eAllReferences = baseObject.eClass().getEAllReferences();
		if (!eAllReferences.isEmpty()) {
			EReference eReference = eAllReferences.get(random.nextInt(eAllReferences.size()));
			EClass randomInstantiableSubClassOrSelf = metaModel.getRandomInstantiableSubClassOrSelf((EClass) eReference.getEType());
			IdEObject idEObject = (IdEObject) Ifc2x3tc1Factory.eINSTANCE.create(randomInstantiableSubClassOrSelf);
			if (randomInstantiableSubClassOrSelf == Ifc2x3tc1Package.eINSTANCE.getIfcPixelTexture()) {
				return false;
			}
			if (eReference.isMany()) {
				((List)baseObject.eGet(eReference)).add(idEObject);
			} else {
				baseObject.eSet(eReference, idEObject);
			}
			for (EAttribute eAttribute : idEObject.eClass().getEAllAttributes()) {
				if (eAttribute.isMany()) {
					List list = (List)idEObject.eGet(eAttribute);
					list.add(createAttributeValue(eAttribute));
				} else {
					idEObject.eSet(eAttribute, createAttributeValue(eAttribute));
				}
			}
			if (idEObject.eClass().getEAnnotation("wrapped") == null) {
				objects.add(idEObject);
				return true;
			}
		}
		return false;
	}
	
	private Object createAttributeValue(EAttribute eAttribute) {
		if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEString()) {
			if (eAttribute.getName().endsWith("AsString")) {
				return "" + random.nextFloat();
			}
			return newRandomString();
		} else if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEInt()) {
			return random.nextInt();
		} else if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEFloat()) {
			return random.nextFloat();
		} else if (eAttribute.getEType() instanceof EEnum) {
			EEnum eEnum = (EEnum) eAttribute.getEType();
			return eEnum.getELiterals().get(random.nextInt(eEnum.getELiterals().size())).getInstance();
		} else if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEBoolean()) {
			return random.nextBoolean();
		} else {
			throw new RuntimeException("Unimplemented type " + eAttribute.getEType());
		}
	}

	private String newRandomString() {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<random.nextInt(255); i++) {
			sb.append((char)(97 + random.nextInt(26)));
		}
		return sb.toString();
	}
}