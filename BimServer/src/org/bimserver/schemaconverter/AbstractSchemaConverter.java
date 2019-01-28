package org.bimserver.schemaconverter;

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

import java.util.HashMap;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.plugins.ObjectAlreadyExistsException;
import org.eclipse.emf.common.util.AbstractEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractSchemaConverter implements SchemaConverter {
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractSchemaConverter.class);
	private final HashMap<IdEObject, IdEObject> converted = new HashMap<IdEObject, IdEObject>();
	private IfcModelInterface source;
	private IfcModelInterface target;

	public AbstractSchemaConverter(IfcModelInterface source, IfcModelInterface target) {
		this.source = source;
		this.target = target;
	}

	@SuppressWarnings("unchecked")
	protected IdEObject copy(IdEObject original) throws IfcModelInterfaceException, ObjectAlreadyExistsException {
		if (!((IdEObjectImpl)original).isLoadedOrLoading()) {
			return null;
		}
		if (converted.containsKey(original)) {
			return converted.get(original);
		}
		if (original.eClass().getName().equals("GeometryInfo") || original.eClass().getName().equals("GeometryData") || original.eClass().getName().equals("Vector3f")) {
			return null;
		}
		EClass eClass = (EClass) target.getPackageMetaData().getEPackage().getEClassifier(original.eClass().getName());
		if (eClass == null) {
			LOGGER.info("No class " + original.eClass().getName() + " in " + target.getPackageMetaData().getEPackage().getName());
			return null;
		}
		IdEObject newObject = (IdEObject) eClass.getEPackage().getEFactoryInstance().create(eClass);
		((IdEObjectImpl)newObject).setOid(original.getOid());
		converted.put(original, newObject);
		if (newObject.eClass().getEAnnotation("wrapped") == null) {
			target.add(newObject.getOid(), newObject);
		}
		for (EStructuralFeature eStructuralFeature : original.eClass().getEAllStructuralFeatures()) {
			EStructuralFeature targetFeature = newObject.eClass().getEStructuralFeature(eStructuralFeature.getName());
			if (targetFeature == null) {
				continue;
			}
			Object get = original.eGet(eStructuralFeature);
			if (eStructuralFeature instanceof EAttribute) {
				if (get instanceof Double) {
					EStructuralFeature doubleStringFeature = original.eClass().getEStructuralFeature("wrappedValueAsString");
					EStructuralFeature targetDoubleStringFeature = newObject.eClass().getEStructuralFeature("wrappedValueAsString");
					if (doubleStringFeature != null && targetDoubleStringFeature != null) {
						Object doubleString = original.eGet(doubleStringFeature);
						newObject.eSet(targetDoubleStringFeature, doubleString);
					} else {
						newObject.eSet(targetFeature, get);
					}
				} else {
					if (eStructuralFeature.getEType() instanceof EEnum) {
						EEnum targetEnum = (EEnum) targetFeature.getEType();
						EEnumLiteral newLiteral = targetEnum.getEEnumLiteral(get.toString());
						if (newLiteral != null) {
							newObject.eSet(targetFeature, newLiteral.getInstance());
						}
					} else {
						if (targetFeature instanceof EAttribute) {
							newObject.eSet(targetFeature, get);
						}
					}
				}
			} else if (eStructuralFeature instanceof EReference) {
				if (get == null) {
				} else {
					if (eStructuralFeature.isMany()) {
						EList<EObject> list = (EList<EObject>) get;
						AbstractEList<EObject> toList = (AbstractEList<EObject>) newObject.eGet(targetFeature);
						if (toList != null) {
							for (Object o : list) {
								IdEObject ref = (IdEObject)o;
								if (targetFeature.getEType().isInstance(ref)) {
									if (converted.containsKey(o)) {
										toList.addUnique(converted.get(o));
									} else {
										IdEObject result = copy((IdEObject) o);
										if (result != null) {
											toList.addUnique(result);
										}
									}
								}
							}
						}
					} else {
						if (targetFeature.isMany()) {
							LOGGER.info("Different multiplicity");
						} else {
							if (converted.containsKey(get)) {
								newObject.eSet(targetFeature, converted.get(get));
							} else {
								newObject.eSet(targetFeature, copy((IdEObject) get));
							}
						}
					}
				}
			}
		}
		return newObject;
	}

	public IfcModelInterface getSource() {
		return source;
	}
	
	public IfcModelInterface getTarget() {
		return target;
	}
}