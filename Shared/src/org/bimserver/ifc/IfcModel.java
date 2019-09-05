package org.bimserver.ifc;

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

import java.io.IOException;

/******************************************************************************
 * Copyright (C) 2009-2018  BIMserver.org
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.LinkedBlockingQueue;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.IdEObjectImpl.State;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.ModelMetaData;
import org.bimserver.emf.OidProvider;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.Schema;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.plugins.ObjectAlreadyExistsException;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public abstract class IfcModel implements IfcModelInterface {

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(IfcModel.class);
	protected ModelMetaData modelMetaData = null;
	private final Set<IfcModelChangeListener> changeListeners = new LinkedHashSet<IfcModelChangeListener>();

	// Object with oid
	private BiMap<Long, IdEObject> objects;
	
	// Objects without oid, usually embedded when serialized
	private final Set<IdEObject> unidentifiedObjects = new HashSet<IdEObject>();

	private Map<String, IdEObject> guidIndexed;
	private Map<EClass, List<? extends IdEObject>> indexPerClass;
	private Map<EClass, List<? extends IdEObject>> indexPerClassWithSubTypes;
	private Map<EClass, Map<String, IdEObject>> guidIndex;
	private Map<EClass, Map<String, IdEObject>> nameIndex;
	private long oidCounter = 1;
	private boolean useDoubleStrings = true;
	private PackageMetaData packageMetaData;
	private Map<Integer, Long> pidRoidMap;

	public IfcModel(PackageMetaData packageMetaData, Map<Integer, Long> pidRoidMap, int size) {
		this.pidRoidMap = pidRoidMap;
		if (packageMetaData == null) {
			throw new IllegalArgumentException("PackageMetaData is required");
		}
		this.packageMetaData = packageMetaData;
		this.objects = HashBiMap.create(size);
	}

	public IfcModel(PackageMetaData packageMetaData, Map<Integer, Long> pidRoidMap) {
		this(packageMetaData, pidRoidMap, 16);
	}

	@SuppressWarnings("unchecked")
	protected void buildIndex() {
		indexPerClass = new HashMap<EClass, List<? extends IdEObject>>();
		for (Long key : objects.keySet()) {
			IdEObject value = objects.get((Long) key);
			if (value != null) {
				List<? extends IdEObject> list = indexPerClass.get(value.eClass());
				if (list == null) {
					list = new ArrayList<IdEObject>();
					indexPerClass.put(value.eClass(), list);
				}
				((List<IdEObject>) list).add(value);
			}
		}
	}
	
	public void rebuildIndexPerClass(EClass eClass) {
		if (indexPerClass == null) {
			indexPerClass = new HashMap<EClass, List<? extends IdEObject>>();
		}
		ArrayList<IdEObject> list = new ArrayList<IdEObject>();
		indexPerClass.put((EClass) eClass, list);
		for (Long key : objects.keySet()) {
			IdEObject value = objects.get((Long) key);
			if (eClass == value.eClass()) {
				list.add(value);
			}
		}
	}

	private void buildIndexWithSubTypes() {
		indexPerClassWithSubTypes = new HashMap<EClass, List<? extends IdEObject>>();
		for (Long key : objects.keySet()) {
			IdEObject idEObject = objects.get(key);
			if (idEObject != null) {
				buildIndexWithSuperTypes(idEObject, idEObject.eClass());
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void buildIndexWithSuperTypes(IdEObject eObject, EClass eClass) {
		if (!indexPerClassWithSubTypes.containsKey(eClass)) {
			indexPerClassWithSubTypes.put(eClass, new ArrayList<IdEObject>());
		}
		((List<IdEObject>) indexPerClassWithSubTypes.get(eClass)).add(eObject);
		for (EClass superClass : eClass.getESuperTypes()) {
			buildIndexWithSuperTypes(eObject, superClass);
		}
	}

	public void buildGuidIndex() {
		guidIndex = new HashMap<EClass, Map<String, IdEObject>>();
		if (objects.isEmpty()) {
			return;
		}
		for (EClassifier classifier : objects.values().iterator().next().eClass().getEPackage().getEClassifiers()) {
			if (classifier instanceof EClass) {
				Map<String, IdEObject> map = new TreeMap<String, IdEObject>();
				guidIndex.put((EClass) classifier, map);
			}
		}
		EClass ifcRootEclass = packageMetaData.getEClass("IfcRoot");
		EStructuralFeature guidFeature = ifcRootEclass.getEStructuralFeature("GlobalId");
		for (Long key : objects.keySet()) {
			IdEObject value = objects.get((Long) key);
			if (ifcRootEclass.isSuperTypeOf(value.eClass())) {
				Object guid = value.eGet(guidFeature);
				if (guid != null) {
					guidIndex.get(value.eClass()).put((String)guid, value);
				}
			}
		}
	}

	public void buildNameIndex() {
		nameIndex = new HashMap<EClass, Map<String, IdEObject>>();
		for (EClassifier classifier : objects.values().iterator().next().eClass().getEPackage().getEClassifiers()) {
			if (classifier instanceof EClass) {
				Map<String, IdEObject> map = new TreeMap<String, IdEObject>();
				nameIndex.put((EClass) classifier, map);
			}
		}
		EClass ifcRootEclass = packageMetaData.getEClass("IfcRoot");
		EStructuralFeature nameFeature = ifcRootEclass.getEStructuralFeature("Name");
		for (Long key : objects.keySet()) {
			IdEObject value = objects.get((Long) key);
			if (ifcRootEclass.isSuperTypeOf(value.eClass())) {
				Object name = value.eGet(nameFeature);
				if (name != null) {
					nameIndex.get(value.eClass()).put((String)name, value);
				}
			}
		}
	}

//	@SuppressWarnings("unchecked")
//	public void sortAllAggregates(IdEObject ifcRoot) {
//		for (EStructuralFeature eStructuralFeature : ifcRoot.eClass().getEAllStructuralFeatures()) {
//			if (true) {
//				if (eStructuralFeature.getUpperBound() == -1 || eStructuralFeature.getUpperBound() > 1) {
//					if (eStructuralFeature.getEType() instanceof EClass) {
//						if (eStructuralFeature.getEType().getEAnnotation("wrapped") != null) {
//							EList<IdEObject> list = (EList<IdEObject>) ifcRoot.eGet(eStructuralFeature);
//							sortPrimitiveList(list);
//						} else {
//							EList<IdEObject> list = (EList<IdEObject>) ifcRoot.eGet(eStructuralFeature);
//							sortComplexList(ifcRoot.eClass(), list, eStructuralFeature);
//						}
//					}
//				}
//			}
//		}
//	}

	private void sortPrimitiveList(EList<IdEObject> list) {
		ECollections.sort(list, new Comparator<IdEObject>() {
			@Override
			public int compare(IdEObject o1, IdEObject o2) {
				return comparePrimitives(o1, o2);
			}
		});
	}

//	private void sortComplexList(final EClass originalQueryClass, EList<IdEObject> list, EStructuralFeature eStructuralFeature) {
//		final EClass type = (EClass) eStructuralFeature.getEType();
//		ECollections.sort(list, new Comparator<IdEObject>() {
//			@Override
//			public int compare(IdEObject o1, IdEObject o2) {
//				int i = 1;
//				for (EStructuralFeature eStructuralFeature : type.getEAllStructuralFeatures()) {
//					if (objectIDM.shouldFollowReference(originalQueryClass, type, eStructuralFeature)) {
//						Object val1 = o1.eGet(eStructuralFeature);
//						Object val2 = o2.eGet(eStructuralFeature);
//						if (val1 != null && val2 != null) {
//							if (eStructuralFeature.getEType() instanceof EClass) {
//								if (eStructuralFeature.getEType().getEAnnotation("wrapped") != null) {
//									int compare = comparePrimitives((IdEObject) val1, (IdEObject) val2);
//									if (compare != 0) {
//										return compare * i;
//									}
//								}
//							}
//						}
//						i++;
//					}
//				}
//				return 0;
//			}
//		});
//	}

	private int comparePrimitives(IdEObject o1, IdEObject o2) {
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
	public <T extends IdEObject> List<T> getAll(EClass eClass) {
		if (indexPerClass == null) {
			buildIndex();
		}
		List<? extends IdEObject> list = indexPerClass.get(eClass);
		if (list == null) {
			return Collections.EMPTY_LIST;
		} else {
			return (List<T>) list;
		}
	}

	public <T extends IdEObject> List<T> getAll(Class<T> interfaceClass) {
		return getAll(packageMetaData.getEClassIncludingDependencies(interfaceClass));
	}

	@SuppressWarnings("unchecked")
	public <T extends IdEObject> List<T> getAllWithSubTypes(EClass eClass) {
		if (indexPerClassWithSubTypes == null) {
			buildIndexWithSubTypes();
		}
		List<? extends IdEObject> list = indexPerClassWithSubTypes.get(eClass);
		if (list == null) {
			return Collections.EMPTY_LIST;
		} else {
			return (List<T>) list;
		}
	}

	@Override
	public <T extends IdEObject> List<T> getAllWithSubTypes(Class<T> interfaceClass)  {
		return getAllWithSubTypes(packageMetaData.getEClass(interfaceClass));
	}

	public Set<String> getGuids(EClass eClass) {
		if (guidIndex == null) {
			buildGuidIndex();
		}
		Map<String, IdEObject> map = guidIndex.get(eClass);
		if (map == null) {
			return new HashSet<String>();
		}
		return map.keySet();
	}

	public Set<String> getNames(EClass eClass) {
		if (nameIndex == null) {
			buildNameIndex();
		}
		Map<String, IdEObject> map = nameIndex.get(eClass);
		if (map == null) {
			return new HashSet<>();
		}
		return map.keySet();
	}

	public IdEObject getByName(EClass eClass, String name) {
		if (nameIndex == null) {
			buildNameIndex();
		}
		return nameIndex.get(eClass).get(name);
	}

	public long size() {
		return objects.size() + unidentifiedObjects.size();
	}

	public Set<Long> keySet() {
		return objects.keySet();
	}

	public IdEObject get(long oid) {
		return objects.get(oid);
	}

	public Collection<IdEObject> getValues() {
		return objects.values();
	}

	public Collection<IdEObject> getUnidentifiedValues() {
		return unidentifiedObjects;
	}

	public void add(long oid, IdEObject eObject) throws ObjectAlreadyExistsException {
		add(oid, eObject, false, false);
	}

	@Override
	public void addAllowMultiModel(long oid, IdEObject eObject) throws IfcModelInterfaceException, ObjectAlreadyExistsException {
		add(oid, eObject, false, true);
	}

	@SuppressWarnings("unchecked")
	private void add(long oid, IdEObject eObject, boolean ignoreDuplicateOids, boolean allowMultiModel) throws ObjectAlreadyExistsException {
		if (((IdEObjectImpl) eObject).hasModel() && !allowMultiModel && ((IdEObjectImpl) eObject).getModel() != this) {
			throw new ObjectAlreadyExistsException("This object (" + eObject + ") already belongs to a Model: " + ((IdEObjectImpl) eObject).getModel() + ", not this " + this);
		}
		if (oid == -1 || eObject.eClass().getEAnnotation("wrapped") != null) {
			unidentifiedObjects.add(eObject);
		} else {
			if (objects.containsKey(oid)) {
				if (!ignoreDuplicateOids) {
					if (objects.get(oid) != eObject) {
//						throw new ObjectAlreadyExistsException("Oid already stored: " + oid + " " + eObject + " (old: " + objects.get(oid) + ")", objects.get(oid), eObject);
					}
				}
			} else {
				objects.put(oid, eObject);
				if (!((IdEObjectImpl) eObject).hasModel() || !allowMultiModel) {
					((IdEObjectImpl) eObject).setModel(this);
				}
				if (guidIndexed != null) {
					indexGuid(eObject);
				}
				if (indexPerClassWithSubTypes != null) {
//					if (indexPerClassWithSubTypes.get(eObject.eClass()) != null) {
						buildIndexWithSuperTypes(eObject, eObject.eClass());
//					}
				}
				if (indexPerClass != null) {
					List<IdEObject> list = (List<IdEObject>) indexPerClass.get(eObject.eClass());
					if (list == null) {
						list = new ArrayList<>();
						indexPerClass.put(eObject.eClass(), list);
					}
					list.add(eObject);
				}
			}
			for (IfcModelChangeListener ifcModelChangeListener : changeListeners) {
				ifcModelChangeListener.objectAdded(eObject);
			}
		}
	}

	public BiMap<Long, IdEObject> getObjects() {
		return (BiMap<Long, IdEObject>) objects;
	}

	public boolean contains(long oid) {
		return objects.containsKey(oid);
	}

	public boolean contains(IdEObject eObject) {
		return objects.containsValue(eObject);
	}

	public void indexGuids() {
		guidIndexed = new HashMap<String, IdEObject>();
		for (IdEObject idEObject : objects.values()) {
			indexGuid(idEObject);
		}
	}

	private void indexGuid(IdEObject idEObject) {
		EClass ifcRootEclass = packageMetaData.getEClass("IfcRoot");
		EStructuralFeature guidFeature = ifcRootEclass.getEStructuralFeature("GlobalId");
		if (ifcRootEclass.isSuperTypeOf(idEObject.eClass())) {
			Object guid = idEObject.eGet(guidFeature);
			if (guid != null) {
				guidIndexed.put((String)guid, idEObject);
			}
		}
	}

	public boolean isValid() {
		return true;
	}

	public void dumpObject(IdEObject idEObject) {
		dumpObject(idEObject, 0, new HashSet<IdEObject>());
	}

	@SuppressWarnings("rawtypes")
	private void dumpObject(IdEObject idEObject, int indention, Set<IdEObject> printed) {
		if (printed.contains(idEObject)) {
			printIndention(indention);
			System.out.println("[REFERENCE: " + idEObject.getOid() + "]");
			return;
		}
		printed.add(idEObject);
		printIndention(indention);
		System.out.println(idEObject.eClass().getName() + " (" + idEObject.getOid() + ")");
		for (EAttribute eAttribute : idEObject.eClass().getEAllAttributes()) {
			Object val = idEObject.eGet(eAttribute);
			if (val != null) {
				printIndention(indention + 1);
				System.out.println(eAttribute.getName() + ": " + val);
			}
		}
		for (EReference eReference : idEObject.eClass().getEAllReferences()) {
			Object referencedObject = idEObject.eGet(eReference);
			if (eReference.isMany()) {
				List list = (List) referencedObject;
				if (list.size() > 0) {
					printIndention(indention + 1);
					System.out.println(eReference.getName() + ": ");
					for (Object o : list) {
						dumpObject((IdEObject) o, indention + 2, printed);
					}
				}
			} else {
				if (referencedObject != null) {
					printIndention(indention + 1);
					System.out.println(eReference.getName() + ": ");
					dumpObject((IdEObject) referencedObject, indention + 2, printed);
				}
			}
		}
	}

	private void printIndention(int indention) {
		for (int i = 0; i < indention; i++) {
			System.out.print("  ");
		}
	}

	public void dumpSummary() {
		Map<EClass, Integer> counts = new TreeMap<EClass, Integer>(new Comparator<EClass>() {
			@Override
			public int compare(EClass o1, EClass o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		for (IdEObject idEObject : objects.values()) {
			if (!counts.containsKey(idEObject.eClass())) {
				counts.put(idEObject.eClass(), 1);
			} else {
				counts.put(idEObject.eClass(), counts.get(idEObject.eClass()) + 1);
			}
		}
		for (EClass eClass : counts.keySet()) {
			System.out.println(eClass.getName() + ": " + counts.get(eClass));
		}
	}

	public void dump() {
		System.out.println("Dumping IFC Model");
		for (Long key : objects.keySet()) {
			System.out.println(key + ": " + objects.get(key).eClass().getName());
		}
	}

	public void dumpPlusReferences() {
		System.out.println("Dumping IFC Model + References");
		Set<IdEObject> done = new HashSet<IdEObject>();
		for (Long key : objects.keySet()) {
			dumpPlusReferences(done, objects.get(key));
		}
	}

	@SuppressWarnings("rawtypes")
	private void dumpPlusReferences(Set<IdEObject> done, IdEObject idEObject) {
		if (idEObject == null) {
			return;
		}
		if (done.contains(idEObject)) {
			return;
		}
		done.add(idEObject);
		System.out.println(idEObject.getOid() + ": " + idEObject.eClass().getName());
		for (EReference eReference : idEObject.eClass().getEAllReferences()) {
			Object val = idEObject.eGet(eReference);
			if (eReference.isMany()) {
				List list = (List) val;
				for (Object o : list) {
					dumpPlusReferences(done, (IdEObject) o);
				}
			} else {
				dumpPlusReferences(done, (IdEObject) val);
			}
		}
	}

	public void remove(IdEObject idEObject) {
		unidentifiedObjects.remove(idEObject);
		objects.inverse().remove(idEObject);
		if (indexPerClass != null) {
			indexPerClass.get(idEObject.eClass()).remove(idEObject);
		}
		if (indexPerClassWithSubTypes != null) {
			indexPerClassWithSubTypes.get(idEObject.eClass()).remove(idEObject);
		}
	}

	public void setOid(IdEObject object, Long oid) {
		objects.forcePut(oid, object);
	}

	public void fixOids(OidProvider oidProvider) {
		BiMap<Long, IdEObject> temp = HashBiMap.create();
		for (long oid : objects.keySet()) {
			fixOids(objects.get(oid), oidProvider, temp);
		}
		objects = temp;
	}

	public void fixOidsFlat(OidProvider oidProvider) {
		BiMap<Long, IdEObject> temp = HashBiMap.create();
		for (long oid : objects.keySet()) {
			fixOidsFlat(objects.get(oid), oidProvider, temp);
		}
		objects = temp;
	}

	public void fixOids() {
		BiMap<Long, IdEObject> temp = HashBiMap.create();
		for (IdEObject object : objects.values()) {
			temp.put(object.getOid(), object);
		}
		objects = temp;
	}
	
	@SuppressWarnings("rawtypes")
	private void fixOids(IdEObject idEObject, OidProvider oidProvider, BiMap<Long, IdEObject> temp) {
		if (idEObject == null) {
			return;
		}
		if (temp.containsValue(idEObject)) {
			return;
		}
		((IdEObjectImpl) idEObject).setOid(oidProvider.newOid(idEObject.eClass()));
		if (objects.containsValue(idEObject)) {
			temp.put(idEObject.getOid(), idEObject);
		}
		for (EReference eReference : idEObject.eClass().getEAllReferences()) {
			Object val = idEObject.eGet(eReference);
			if (eReference.isMany()) {
				List list = (List) val;
				for (Object o : list) {
					fixOids((IdEObject) o, oidProvider, temp);
				}
			} else {
				fixOids((IdEObject) val, oidProvider, temp);
			}
		}
	}

	private void fixOidsFlat(IdEObject idEObject, OidProvider oidProvider, BiMap<Long, IdEObject> temp) {
		if (idEObject == null) {
			return;
		}
		if (temp.containsValue(idEObject)) {
			return;
		}
		((IdEObjectImpl) idEObject).setOid(oidProvider.newOid(idEObject.eClass()));
		if (objects.containsValue(idEObject)) {
			temp.put(idEObject.getOid(), idEObject);
		}
	}

	public void setObjectOids() {
		for (long oid : objects.keySet()) {
			((IdEObjectImpl) objects.get(oid)).setOid(oid);
		}
	}

	public long getHighestOid() {
		long max = 0;
		for (long oid : objects.keySet()) {
			if (oid > max) {
				max = oid;
			}
		}
		return max;
	}

	public void changeOid(IdEObject object) {
		objects.inverse().remove(object);
		objects.put(object.getOid(), object);
	}
	
	public IdEObject getByGuid(String guid) {
		if (guidIndexed == null) {
			indexGuids();
		}
		return guidIndexed.get(guid);
	}

	public boolean containsGuid(String guid) {
		if (guidIndexed == null) {
			indexGuids();
		}
		return guidIndexed.containsKey(guid);
	}

	public void checkDoubleOids() {
		Set<Long> oids = new HashSet<Long>();
		for (IdEObject idEObject : objects.values()) {
			if (oids.contains(idEObject.getOid())) {
				throw new RuntimeException("Double oid: " + idEObject.getOid());
			}
			oids.add(idEObject.getOid());
		}
	}

	public void fixOidCounter() {
		oidCounter = getHighestOid() + 1;
	}

	@SuppressWarnings("rawtypes")
	private void checkDoubleOidsPlusReferences(BiMap<IdEObject, Long> done, IdEObject idEObject) {
		if (idEObject == null) {
			return;
		}
		if (idEObject.eClass().getEAnnotation("wrapped") != null) {
			return;
		}
		if (done.containsKey(idEObject)) {
			return;
		}
		if (done.containsValue(idEObject.getOid())) {
			showBackReferences(idEObject);
			IdEObject existing = done.inverse().get(idEObject.getOid());
			showBackReferences(existing);
			throw new RuntimeException("Double oid: " + idEObject.getOid() + " " + idEObject + ", " + existing);
		}
		done.put(idEObject, idEObject.getOid());
		for (EReference eReference : idEObject.eClass().getEAllReferences()) {
			if (eReference.isMany()) {
				List list = (List) idEObject.eGet(eReference);
				for (Object o : list) {
					checkDoubleOidsPlusReferences(done, (IdEObject) o);
				}
			} else {
				checkDoubleOidsPlusReferences(done, (IdEObject) idEObject.eGet(eReference));
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public void showBackReferences(IdEObject idEObject) {
		System.out.println("Showing back references to: " + idEObject);
		for (IdEObject object : getValues()) {
			for (EReference eReference : object.eClass().getEAllReferences()) {
				if (eReference.isMany()) {
					List list = (List) object.eGet(eReference);
					for (Object o : list) {
						if (o == idEObject) {
							System.out.println(object.eClass().getName() + "." + eReference.getName() + " " + object);
						}
					}
				} else {
					Object o = object.eGet(eReference);
					if (o == idEObject) {
						System.out.println(object.eClass().getName() + "." + eReference.getName() + " " + object);
					}
				}
			}
		}
	}

	public void checkDoubleOidsPlusReferences() {
		BiMap<IdEObject, Long> done = HashBiMap.create();
		for (IdEObject idEObject : objects.values()) {
			checkDoubleOidsPlusReferences(done, idEObject);
		}
	}

	public void resetOidsFlat() {
		for (IdEObject idEObject : objects.values()) {
			((IdEObjectImpl) idEObject).setOid(-1);
		}
	}

	public void resetOids() {
		Set<IdEObject> done = new HashSet<IdEObject>();
		for (IdEObject idEObject : objects.values()) {
			resetOids(idEObject, done);
		}
	}

	@SuppressWarnings("rawtypes")
	public void resetOids(IdEObject idEObject, Set<IdEObject> done) {
		if (idEObject == null) {
			return;
		}
		if (done.contains(idEObject)) {
			return;
		}
		((IdEObjectImpl) idEObject).setOid(-1);
		done.add(idEObject);
		for (EReference eReference : idEObject.eClass().getEAllReferences()) {
			Object val = idEObject.eGet(eReference);
			if (eReference.isMany()) {
				List list = (List) val;
				for (Object o : list) {
					resetOids((IdEObject) o, done);
				}
			} else {
				resetOids((IdEObject) val, done);
			}
		}
	}

	public void addChangeListener(IfcModelChangeListener listener) {
		changeListeners.add(listener);
	}

	public void removeChangeListener(IfcModelChangeListener ifcModelChangeListener) {
		changeListeners.remove(ifcModelChangeListener);
	}

	@Override
	public void setUseDoubleStrings(boolean useDoubleStrings) {
		this.useDoubleStrings = useDoubleStrings;
	}

	public boolean isUseDoubleStrings() {
		return useDoubleStrings;
	}

	@Override
	public Iterator<IdEObject> iterator() {
		return objects.values().iterator();
	}

	@Override
	public int countWithSubtypes(EClass eClass) {
		List<IdEObject> list = getAllWithSubTypes(eClass);
		if (list == null) {
			return 0;
		}
		return list.size();
	}

	@Override
	public int count(EClass eClass) {
		List<IdEObject> list = getAll(eClass);
		if (list == null) {
			return 0;
		}
		return list.size();
	}
	
	public Iterator<IdEObject> iterateAllObjects() {
		return new Iterator<IdEObject>() {
			private final Queue<IdEObject> todo = new LinkedBlockingQueue<IdEObject>(getValues());
			private final Set<IdEObject> done = new HashSet<IdEObject>();
			
			@Override
			public boolean hasNext() {
				return !todo.isEmpty();
			}

			@SuppressWarnings("rawtypes")
			@Override
			public IdEObject next() {
				IdEObject idEObject = todo.poll();
				done.add(idEObject);
				for (EReference eReference : idEObject.eClass().getEAllReferences()) {
					Object val = idEObject.eGet(eReference);
					if (eReference.isMany()) {
						List list = (List) val;
						for (Object o : list) {
							if (!done.contains(o)) {
								todo.add((IdEObject) o);
							}
						}
					} else {
						if (val != null && !done.contains(val)) {
							todo.add((IdEObject) val);
						}
					}
				}
				return idEObject;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
	
	@Override
	public void generateMinimalExpressIds() {
		int expressId = 1;
		Iterator<IdEObject> iterateAllObjects = iterateAllObjects();
		while (iterateAllObjects.hasNext()) {
			IdEObject idEObject = iterateAllObjects.next();
			((IdEObjectImpl)idEObject).setExpressId(expressId++);
		}
	}

	@Override
	public ModelMetaData getModelMetaData() {
		if (modelMetaData == null) {
			this.modelMetaData = new ModelMetaData();
		}
		return modelMetaData;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IdEObject> T create(EClass eClass) throws IfcModelInterfaceException {
		IdEObjectImpl object = (IdEObjectImpl) eClass.getEPackage().getEFactoryInstance().create(eClass);
		long oid = oidCounter++;
		((IdEObjectImpl) object).setOid(oid);
		return (T) object;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IdEObject> T createAndAdd(Class<T> clazz) throws IfcModelInterfaceException, ObjectAlreadyExistsException {
		EClass eClass = packageMetaData.getEClass(clazz);
		IdEObjectImpl object = (IdEObjectImpl) eClass.getEPackage().getEFactoryInstance().create(eClass);
		object.setLoadingState(State.LOADED);
		long oid = oidCounter++;
		add(oid, object);
		return (T) object;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends IdEObject> T createAndAdd(EClass eClass) throws IfcModelInterfaceException, ObjectAlreadyExistsException {
		IdEObjectImpl object = (IdEObjectImpl) eClass.getEPackage().getEFactoryInstance().create(eClass);
		object.setLoadingState(State.LOADED);
		long oid = oidCounter++;
		add(oid, object);
		return (T) object;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IdEObject> T create(EClass eClass, long oid) throws IfcModelInterfaceException {
		if (eClass == null) {
			throw new IllegalArgumentException("eClass cannot be null");
		}
		IdEObjectImpl object = (IdEObjectImpl) eClass.getEPackage().getEFactoryInstance().create(eClass);
		object.setModel(this);
		object.setOid(oid);
		return (T) object;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IdEObject> T createAndAdd(EClass eClass, long oid) throws IfcModelInterfaceException, ObjectAlreadyExistsException {
		IdEObjectImpl object = (IdEObjectImpl) eClass.getEPackage().getEFactoryInstance().create(eClass);
		object.setModel(this);
		object.setOid(oid);
		add(oid, object);
		return (T) object;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends IdEObject> T create(EClass eClass, OidProvider oidProvider) throws IfcModelInterfaceException, ObjectAlreadyExistsException {
		IdEObjectImpl object = (IdEObjectImpl) eClass.getEPackage().getEFactoryInstance().create(eClass);
		long oid = oidProvider.newOid(eClass);
		((IdEObjectImpl) object).setOid(oid);
		((IdEObjectImpl) object).setLoadingState(State.LOADED);
		add(oid, object, false, false);
		return (T) object;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends IdEObject> T create(Class<T> clazz) throws IfcModelInterfaceException {
		return (T) create(packageMetaData.getEClassIncludingDependencies(clazz));
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IdEObject> T create(Class<T> clazz, OidProvider oidProvider) throws IfcModelInterfaceException, ObjectAlreadyExistsException {
		return (T) create(packageMetaData.getEClass(clazz), oidProvider);
	}
	
	@Override
	public void clear() {
		if (guidIndex != null) {
			guidIndex.clear();
		}
		if (guidIndexed != null) {
			guidIndexed.clear();
		}
		if (indexPerClass != null) {
			indexPerClass.clear();
		}
		if (nameIndex != null) {
			nameIndex.clear();
		}
		if (indexPerClassWithSubTypes != null) {
			indexPerClassWithSubTypes.clear();
		}
		if (objects != null) {
			objects.clear();
		}
	}

	@Override
	public void resetExpressIds() {
		for (IdEObject idEObject : objects.values()) {
			((IdEObjectImpl)idEObject).setExpressId(-1);
		}
	}

	@Override
	public IfcModelInterface branch(long poid, boolean recordChanges) {
		throw new UnsupportedOperationException();
	}

	@Override
	public long commit(String comment) throws ServerException, UserException, PublicInterfaceNotFoundException {
		throw new UnsupportedOperationException();
	}

	@Override
	public PackageMetaData getPackageMetaData() {
		return packageMetaData;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void fixInverseMismatches() {
		int nrFixes = 0;
		Ifc4Package ifc4 = Ifc4Package.eINSTANCE;
		Ifc2x3tc1Package ifc2x3 = Ifc2x3tc1Package.eINSTANCE;
		Mismatch[] misMatches = packageMetaData.getSchema().equals(Schema.IFC2X3TC1) ? new Mismatch[]{
						new Mismatch(ifc2x3.getIfcRelContainedInSpatialStructure_RelatedElements(), new EReference[]{
										ifc2x3.getIfcElement_ContainedInStructure(),
										ifc2x3.getIfcGrid_ContainedInStructure(),
										ifc2x3.getIfcAnnotation_ContainedInStructure()}),
						new Mismatch(ifc2x3.getIfcPresentationLayerAssignment_AssignedItems(), new EReference[]{
										ifc2x3.getIfcRepresentation_LayerAssignments(),
										ifc2x3.getIfcRepresentationItem_LayerAssignments() }),
						new Mismatch(ifc2x3.getIfcRelAssociates_RelatedObjects(), new EReference[]{
										ifc2x3.getIfcObjectDefinition_HasAssociations(),
										ifc2x3.getIfcPropertyDefinition_HasAssociations() }),
						new Mismatch(ifc2x3.getIfcTerminatorSymbol_AnnotatedCurve(), new EReference[]{
										ifc2x3.getIfcDimensionCurve_AnnotatedBySymbols() }),
						new Mismatch(ifc2x3.getIfcRelReferencedInSpatialStructure_RelatedElements(), new EReference[]{
										ifc2x3.getIfcElement_ReferencedInStructures() }),
						new Mismatch(ifc2x3.getIfcProduct_Representation(), new EReference[]{
										ifc2x3.getIfcProductDefinitionShape_ShapeOfProduct() }),
						new Mismatch(ifc2x3.getIfcRelConnectsElements_RelatingElement(), new EReference[]{
										ifc2x3.getIfcStructuralItem_AssignedStructuralActivity()})
		} : new Mismatch[]{
						new Mismatch(ifc4.getIfcRelContainedInSpatialStructure_RelatedElements(), new EReference[]{
										ifc4.getIfcElement_ContainedInStructure(),
										ifc4.getIfcGrid_ContainedInStructure(),
										ifc4.getIfcAnnotation_ContainedInStructure()}),
						new Mismatch(ifc4.getIfcPresentationLayerAssignment_AssignedItems(), new EReference[]{
										ifc4.getIfcRepresentation_LayerAssignments(),
										ifc4.getIfcRepresentationItem_LayerAssignment() }),
						new Mismatch(ifc4.getIfcRelAssociates_RelatedObjects(), new EReference[]{
										ifc4.getIfcObjectDefinition_HasAssociations(),
										ifc4.getIfcPropertyDefinition_HasAssociations() }),
						new Mismatch(ifc4.getIfcRelReferencedInSpatialStructure_RelatedElements(), new EReference[]{
										ifc4.getIfcElement_ReferencedInStructures() }),
						new Mismatch(ifc4.getIfcProduct_Representation(), new EReference[]{
										ifc4.getIfcProductDefinitionShape_ShapeOfProduct() }),
						new Mismatch(ifc4.getIfcRelConnectsElements_RelatingElement(), new EReference[]{
										ifc4.getIfcStructuralItem_AssignedStructuralActivity()}),
						new Mismatch(ifc4.getIfcExternalReferenceRelationship_RelatedResourceObjects(), new EReference[]{
										ifc4.getIfcActorRole_HasExternalReference(),
										ifc4.getIfcAppliedValue_HasExternalReference(),
										ifc4.getIfcApproval_HasExternalReferences(),
										ifc4.getIfcConstraint_HasExternalReferences(),
										ifc4.getIfcContextDependentUnit_HasExternalReference(),
										ifc4.getIfcConversionBasedUnit_HasExternalReference(),
										ifc4.getIfcMaterialDefinition_HasExternalReferences(),
										ifc4.getIfcPhysicalQuantity_HasExternalReferences(),
										ifc4.getIfcProfileDef_HasExternalReference(),
										ifc4.getIfcPropertyAbstraction_HasExternalReferences(),
										ifc4.getIfcTimeSeries_HasExternalReference()
						}),
						new Mismatch(ifc4.getIfcRelAssociatesClassification_RelatingClassification(), new EReference[]{
										ifc4.getIfcClassification_ClassificationForObjects(),
										ifc4.getIfcClassificationReference_ClassificationRefForObjects()
						}),
						new Mismatch(ifc4.getIfcClassificationReference_ReferencedSource(),new EReference[]{
										ifc4.getIfcClassification_HasReferences(),
										ifc4.getIfcClassificationReference_HasReferences()
						}),
						new Mismatch(ifc4.getIfcRelDefinesByProperties_RelatedObjects(),new EReference[]{
										ifc4.getIfcContext_IsDefinedBy(),
										ifc4.getIfcObject_IsDefinedBy()
						}),
						new Mismatch(ifc4.getIfcRelAssociatesDocument_RelatingDocument(),new EReference[]{
										ifc4.getIfcDocumentInformation_DocumentInfoForObjects(),
										ifc4.getIfcDocumentReference_DocumentRefForObjects()
						}),
						new Mismatch(ifc4.getIfcRelSpaceBoundary_RelatingSpace(),new EReference[]{
										ifc4.getIfcExternalSpatialElement_BoundedBy(),
										ifc4.getIfcSpace_BoundedBy()
						}),
						new Mismatch(ifc4.getIfcRelAssociatesLibrary_RelatingLibrary(),new EReference[]{
										ifc4.getIfcLibraryInformation_LibraryInfoForObjects(),
										ifc4.getIfcLibraryReference_LibraryRefForObjects()
						}),
						new Mismatch(ifc4.getIfcRelAssociatesMaterial_RelatingMaterial(),new EReference[]{
										ifc4.getIfcMaterialDefinition_AssociatedTo(),
										ifc4.getIfcMaterialUsageDefinition_AssociatedTo()
						}),
						new Mismatch(ifc4.getIfcRelDeclares_RelatedDefinitions(),new EReference[]{
										ifc4.getIfcObjectDefinition_HasContext(),
										ifc4.getIfcPropertyDefinition_HasContext()
						}),
						new Mismatch(ifc4.getIfcRelAssignsToProcess_RelatingProcess(),new EReference[]{
										ifc4.getIfcProcess_OperatesOn(),
										ifc4.getIfcTypeProcess_OperatesOn()
						}),
						new Mismatch(ifc4.getIfcShapeAspect_PartOfProductDefinitionShape(),new EReference[]{
										ifc4.getIfcProductDefinitionShape_HasShapeAspects(),
										ifc4.getIfcRepresentationMap_HasShapeAspects()
						}),
						new Mismatch(ifc4.getIfcRelDefinesByProperties_RelatingPropertyDefinition(),new EReference[]{
										ifc4.getIfcPropertySetDefinition_DefinesOccurrence()
						}),
						new Mismatch(ifc4.getIfcRelAssignsToResource_RelatingResource(),new EReference[]{
										ifc4.getIfcResource_ResourceOf(),
										ifc4.getIfcTypeResource_ResourceOf()
						}),
						new Mismatch(ifc4.getIfcCoordinateOperation_SourceCRS(),new EReference[]{
										ifc4.getIfcCoordinateReferenceSystem_HasCoordinateOperation(),
										ifc4.getIfcGeometricRepresentationContext_HasCoordinateOperation()
						}),
						new Mismatch(ifc4.getIfcRelAssignsToProduct_RelatingProduct(),new EReference[]{
										ifc4.getIfcProduct_ReferencedBy()
						}),
						new Mismatch(ifc4.getIfcResourceConstraintRelationship_RelatedResourceObjects(),new EReference[]{
										ifc4.getIfcProperty_HasConstraints()
						}),
						new Mismatch(ifc4.getIfcResourceApprovalRelationship_RelatedResourceObjects(),new EReference[]{
										ifc4.getIfcProperty_HasApprovals()
						})
		};


		for(Mismatch mismatch: misMatches){
			for(IdEObject entityToBeFixed : getAllWithSubTypes(mismatch.forward.getEContainingClass())){
				Object referenced = entityToBeFixed.eGet(mismatch.forward);
				if(referenced != null)
					if (mismatch.forward.isMany()) for (IdEObject referencedInList : (EList<? extends IdEObject>) referenced){
						nrFixes += fixMisMatchInstance(mismatch, entityToBeFixed, referencedInList);
					} else
						nrFixes += fixMisMatchInstance(mismatch, entityToBeFixed, (IdEObject) referenced);
			}
		}
		LOGGER.info("Nr inverse fixes: " + nrFixes);
	}

	private int fixMisMatchInstance(Mismatch mismatch, IdEObject entityToBeFixed, IdEObject referenced) {
		int nrFixes = 0;
		for(EReference inverse: mismatch.inverse) if(inverse.getEContainingClass().isInstance(referenced)){
      if(inverse.isMany()) ((EList<IdEObject>) referenced.eGet(inverse)).add(entityToBeFixed);
      else referenced.eSet(inverse, entityToBeFixed);
      nrFixes++;
    }
		return nrFixes;
	}

	@Override
	public Map<Integer, Long> getPidRoidMap() {
		return pidRoidMap;
	}

	@Override
	public void set(IdEObject idEObject, EStructuralFeature eFeature, Object newValue) {
	}

	@Override
	public void checkin(long poid, String comment) throws ServerException, UserException, PublicInterfaceNotFoundException {
	}

	@Override
	public boolean containsNoFetch(long oid) {
		return contains(oid);
	}

	@Override
	public IdEObject getNoFetch(long oid) {
		return get(oid);
	}

	public abstract void load(IdEObject idEObject);
	
	@Override
	public Set<EClass> getUsedClasses() {
		if (indexPerClass == null) {
			buildIndex();
		}
		return indexPerClass.keySet();
	}
	
	@Override
	public void query(ObjectNode query, boolean assumeCompletePreload) throws ServerException, UserException, PublicInterfaceNotFoundException, IfcModelInterfaceException, IOException {
	}
	
	class Mismatch {
		EReference forward;
		EReference[] inverse;
		Mismatch(EReference forward, EReference[] inverse){
			this.forward = forward;
			this.inverse = inverse;
		}
	}
	@Override
	public <T extends IdEObject> T getFirst(Class<T> class1) {
		return getAll(class1).iterator().next();
	}

	@Override
	public <T extends IdEObject> T getFirst(EClass eClass) {
		return (T) getAll(eClass).iterator().next();
	}
	
	@Override
	public void dumpDebug() {
	}
	
	@Override
	public void close() throws Exception {
	}
}