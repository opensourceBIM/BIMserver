package org.bimserver.ifc.database;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.FieldIgnoreMap;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package;
import org.bimserver.ifc.emf.Ifc2x3.IfcRoot;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IfcDatabase {

	private static final Logger LOGGER = LoggerFactory.getLogger(IfcDatabase.class);
	private static final Map<Class<?>, Class<?>> interfaceClassMap = initInterfaceClassMap();
	private final Map<Class<?>, List<? extends EObject>> index = new HashMap<Class<?>, List<? extends EObject>>();
	private final IfcModel model;
	private final Map<EClass, Map<String, IdEObject>> guidIndex = new HashMap<EClass, Map<String, IdEObject>>();
	private final FieldIgnoreMap fieldIgnoreMap;

	public IfcDatabase(IfcModel model, FieldIgnoreMap fieldIgnoreMap) {
		this.model = model;
		this.fieldIgnoreMap = fieldIgnoreMap;
		buildIndex();
	}

	private static Map<Class<?>, Class<?>> initInterfaceClassMap() {
		Map<Class<?>, Class<?>> interfaceClassMap = new HashMap<Class<?>, Class<?>>();
		for (EClassifier eClassifier : Ifc2x3Package.eINSTANCE.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass)eClassifier;
				if (!eClass.isInterface()) {
					try {
						Class<?> implementationClass = Class.forName(eClassifier.getInstanceClass().getPackage().getName() + ".impl." + eClassifier.getInstanceClass().getSimpleName() + "Impl");
						interfaceClassMap.put(implementationClass, eClassifier.getInstanceClass());
					} catch (ClassNotFoundException e) {
						LOGGER.error("", e);
					}
				}
			}
		}
		return interfaceClassMap;
	}

	@SuppressWarnings("unchecked")
	private void buildIndex() {
		for (Long key : model.keySet()) {
			EObject value = model.get((Long) key);
			if (value != null) {
				Class<?> clazz = interfaceClassMap.get(value.getClass());
				if (!index.containsKey(clazz)) {
					index.put(clazz, new ArrayList<EObject>());
				}
				((List<EObject>) index.get(clazz)).add(value);
			}
		}
	}

	public void buildGuidIndex() {
		for (EClassifier classifier : model.getValues().iterator().next().eClass().getEPackage().getEClassifiers()) {
			if (classifier instanceof EClass) {
				Map<String, IdEObject> map = new TreeMap<String, IdEObject>();
				guidIndex.put((EClass) classifier, map);
			}
		}
		for (Long key : model.keySet()) {
			IdEObject value = model.get((Long) key);
			if (value instanceof IfcRoot) {
				IfcRoot ifcRoot = (IfcRoot) value;
				sortAllAggregates(ifcRoot);
				guidIndex.get(value.eClass()).put(ifcRoot.getGlobalId().getWrappedValue(), value);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void sortAllAggregates(IfcRoot ifcRoot) {
		for (EStructuralFeature eStructuralFeature : ifcRoot.eClass().getEAllStructuralFeatures()) {
			if (!fieldIgnoreMap.shouldIgnoreField(ifcRoot.eClass(), ifcRoot.eClass(), eStructuralFeature)) {
				if (eStructuralFeature.getUpperBound() == -1 || eStructuralFeature.getUpperBound() > 1) {
					if (eStructuralFeature.getEType() instanceof EClass) {
						if (Ifc2x3Package.eINSTANCE.getWrappedValue().isSuperTypeOf((EClass) eStructuralFeature.getEType())) {
							EList<EObject> list = (EList<EObject>) ifcRoot.eGet(eStructuralFeature);
							sortPrimitiveList(list);
						} else {
							EList<EObject> list = (EList<EObject>) ifcRoot.eGet(eStructuralFeature);
							sortComplexList(ifcRoot.eClass(), list, eStructuralFeature);
						}
					}
				}
			}
		}
	}

	private void sortPrimitiveList(EList<EObject> list) {
		ECollections.sort(list, new Comparator<EObject>() {
			@Override
			public int compare(EObject o1, EObject o2) {
				return comparePrimitives(o1, o2);
			}
		});
	}

	private void sortComplexList(final EClass originalQueryClass, EList<EObject> list, EStructuralFeature eStructuralFeature) {
		final EClass type = (EClass) eStructuralFeature.getEType();
		ECollections.sort(list, new Comparator<EObject>() {
			@Override
			public int compare(EObject o1, EObject o2) {
				int i=1;
				for (EStructuralFeature eStructuralFeature : type.getEAllStructuralFeatures()) {
					if (!fieldIgnoreMap.shouldIgnoreField(originalQueryClass, type, eStructuralFeature)) {
						Object val1 = o1.eGet(eStructuralFeature);
						Object val2 = o2.eGet(eStructuralFeature);
						if (val1 != null && val2 != null) {
							if (eStructuralFeature.getEType() instanceof EClass) {
								if (Ifc2x3Package.eINSTANCE.getWrappedValue().isSuperTypeOf((EClass) eStructuralFeature.getEType())) {
									int compare = comparePrimitives((EObject) val1, (EObject) val2);
									if (compare != 0) {
										return compare * i;
									}
								}
							}
						}
						i++;
					}
				}
				return 0;
			}
		});
	}

	private int comparePrimitives(EObject o1, EObject o2) {
		EClass eClass = o1.eClass();
		EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature("wrappedValue");
		Object val1 = o1.eGet(eStructuralFeature);
		Object val2 = o2.eGet(eStructuralFeature);
		if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEString()) {
			return ((String) val1).compareTo((String) val2);
		} else if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEInt()) {
			return ((Integer) val1).compareTo((Integer) val2);
		} else {
			throw new RuntimeException("ni");
		}
	}

	@SuppressWarnings("unchecked")
	public <T extends EObject> List<T> getAll(Class<T> clazz) {
		List<? extends EObject> list = index.get(clazz);
		if (list == null) {
			return new ArrayList<T>();
		} else {
			return (List<T>) list;
		}
	}

	public Set<String> getGuids(EClass eClass) {
		return guidIndex.get(eClass).keySet();
	}

	public IdEObject getByGuid(EClass eClass, String guid) {
		return guidIndex.get(eClass).get(guid);
	}
}