package org.bimserver.ifc;

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
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.bimserver.emf.IdEObject;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcGloballyUniqueId;
import org.bimserver.models.ifc2x3.IfcProject;
import org.bimserver.models.ifc2x3.IfcRoot;
import org.bimserver.models.ifc2x3.WrappedValue;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class IfcModel {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IfcModel.class);

	private BiMap<Long, IdEObject> objects;
	private Map<String, IfcRoot> guidIndexed;
	private byte[] checksum;
	private IdEObject eObject;
	private int revisionNr;
	private String authorizedUser;
	private Date date;
	private final Set<IfcModelChangeListener> changeListeners = new LinkedHashSet<IfcModelChangeListener>();

	private static final Map<Class<?>, Class<?>> interfaceClassMap = initInterfaceClassMap();
	private Map<Class<?>, List<? extends EObject>> index;
	private Map<EClass, Map<String, IdEObject>> guidIndex;
	private Map<EClass, Map<String, IdEObject>> nameIndex;
	private FieldIgnoreMap fieldIgnoreMap;

	public IfcModel(BiMap<Long, IdEObject> objects) {
		this.objects = objects;
	}
	
	public IfcModel() {
		this.objects = HashBiMap.create();
	}

	public IfcModel(int size) {
		this.objects = HashBiMap.create(size);
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
		index = new HashMap<Class<?>, List<? extends EObject>>();
		for (Long key : objects.keySet()) {
			EObject value = objects.get((Long) key);
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
		guidIndex = new HashMap<EClass, Map<String,IdEObject>>();
		for (EClassifier classifier : objects.values().iterator().next().eClass().getEPackage().getEClassifiers()) {
			if (classifier instanceof EClass) {
				Map<String, IdEObject> map = new TreeMap<String, IdEObject>();
				guidIndex.put((EClass) classifier, map);
			}
		}
		for (Long key : objects.keySet()) {
			IdEObject value = objects.get((Long) key);
			if (value instanceof IfcRoot) {
				IfcRoot ifcRoot = (IfcRoot) value;
				sortAllAggregates(ifcRoot);
				guidIndex.get(value.eClass()).put(ifcRoot.getGlobalId().getWrappedValue(), value);
			}
		}
	}

	public void buildNameIndex() {
		nameIndex = new HashMap<EClass, Map<String,IdEObject>>();
		for (EClassifier classifier : objects.values().iterator().next().eClass().getEPackage().getEClassifiers()) {
			if (classifier instanceof EClass) {
				Map<String, IdEObject> map = new TreeMap<String, IdEObject>();
				nameIndex.put((EClass) classifier, map);
			}
		}
		for (Long key : objects.keySet()) {
			IdEObject value = objects.get((Long) key);
			if (value instanceof IfcRoot) {
				IfcRoot ifcRoot = (IfcRoot) value;
				sortAllAggregates(ifcRoot);
				if (ifcRoot.getName() != null) {
					nameIndex.get(value.eClass()).put(ifcRoot.getName(), value);
				}
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
		if (index == null) {
			buildIndex();
		}
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

	public Set<String> getNames(EClass eClass) {
		if (nameIndex == null) {
			buildNameIndex();
		}
		return nameIndex.get(eClass).keySet();
	}

	public IdEObject getByName(EClass eClass, String name) {
		if (nameIndex == null) {
			buildNameIndex();
		}
		return nameIndex.get(eClass).get(name);
	}
	
	public IdEObject getByGuid(EClass eClass, String guid) {
		if (guidIndex == null) {
			indexGuids();
		}
		return guidIndex.get(eClass).get(guid);
	}

	public long size() {
		return objects.size();
	}

	public Set<Long> keySet() {
		return objects.keySet();
	}

	public IdEObject get(Long key) {
		return objects.get(key);
	}

	public Collection<IdEObject> getValues() {
		return objects.values();
	}

	public void add(Long key, IdEObject eObject) {
		add(key, eObject, false);
	}
	
	public void add(Long key, IdEObject eObject, boolean ignoreDuplicateOids) {
		if (objects.containsKey(key)) {
			if (!ignoreDuplicateOids) {
				throw new RuntimeException("Oid already stored: " + key + " " + eObject + " (old: " + objects.get(key));
			}
		} else {
			objects.put(key, eObject);
			if (guidIndexed != null) {
				indexGuid(eObject);
			}
		}
		if (!changeListeners.isEmpty()) {
			for (IfcModelChangeListener ifcModelChangeListener : changeListeners) {
				ifcModelChangeListener.objectAdded();
			}
		}
	}
	
	public Map<Long, IdEObject> getObjects() {
		return objects;
	}

	public BiMap<Long, ? extends IdEObject> getMap() {
		return (BiMap<Long, ? extends IdEObject>) objects;
	}

	public byte[] getChecksum() {
		return checksum;
	}

	public void setChecksum(byte[] checksum) {
		this.checksum = checksum;
	}

	public boolean contains(Long key) {
		return objects.containsKey(key);
	}

	public IdEObject getMainObject() {
		return eObject;
	}

	public void setMainObject(IdEObject eObject) {
		this.eObject = eObject;
	}

	public int getSize() {
		return objects.size();
	}

	public boolean contains(IdEObject eObject) {
		return objects.inverse().containsKey(eObject);
	}

	public Long get(IdEObject eObject) {
		return objects.inverse().get(eObject);
	}

	public void indexGuids() {
		guidIndexed = new HashMap<String, IfcRoot>();
		for (IdEObject idEObject : objects.values()) {
			indexGuid(idEObject);
		}
	}

	private void indexGuid(IdEObject idEObject) {
		if (idEObject instanceof IfcRoot) {
			IfcRoot ifcRoot = (IfcRoot)idEObject;
			if (ifcRoot.getGlobalId() != null) {
				guidIndexed.put(ifcRoot.getGlobalId().getWrappedValue(), ifcRoot);
			}
		}
	}

	public String getAuthorizedUser() {
		return authorizedUser;
	}

	public int getRevisionNr() {
		return revisionNr;
	}

	public boolean isValid() {
		return true;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Date getDate() {
		return date;
	}

	public void setAuthorizedUser(String authorizedUser) {
		this.authorizedUser = authorizedUser;
	}
	
	public void setRevisionNr(int revisionNr) {
		this.revisionNr = revisionNr;
	}

	public void dumpObject(IdEObject idEObject) {
		dumpObject(idEObject, 0, new HashSet<IdEObject>());
	}
	
	@SuppressWarnings("unchecked")
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
				List list = (List)referencedObject;
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
		for (int i=0; i<indention; i++) {
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
	
	@SuppressWarnings("unchecked")
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
				List list = (List)val;
				for (Object o : list) {
					dumpPlusReferences(done, (IdEObject) o);
				}
			} else {
				dumpPlusReferences(done, (IdEObject) val);
			}
		}
	}

	public void remove(IdEObject idEObject) {
		objects.inverse().remove(idEObject);
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
	
	@SuppressWarnings("unchecked")
	private void fixOids(IdEObject idEObject, OidProvider oidProvider, BiMap<Long, IdEObject> temp) {
		if (idEObject == null) {
			return;
		}
		if (temp.containsValue(idEObject)) {
			return;
		}
		idEObject.setOid(oidProvider.newOid());
		if (objects.containsValue(idEObject)) {
			temp.put(idEObject.getOid(), idEObject);
		}
		for (EReference eReference : idEObject.eClass().getEAllReferences()) {
			Object val = idEObject.eGet(eReference);
			if (eReference.isMany()) {
				List list = (List)val;
				for (Object o : list) {
					fixOids((IdEObject) o, oidProvider, temp);
				}
			} else {
				fixOids((IdEObject) val, oidProvider, temp);
			}
		}
	}
	
	public void setObjectOids() {
		for (long oid : objects.keySet()) {
			objects.get(oid).setOid(oid);
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

	public IfcRoot get(String guid) {
		if (guidIndexed == null) {
			throw new RuntimeException("Not indexed on guids");
		}
		return guidIndexed.get(guid);
	}

	public boolean contains(String guid) {
		if (guidIndexed == null) {
			throw new RuntimeException("Not indexed on guids");
		}
		return guidIndexed.containsKey(guid);
	}

	public IdEObject get(Class<IfcProject> class1) {
		for (IdEObject idEObject : objects.values()) {
			if (class1.isInstance(idEObject)) {
				return idEObject;
			}
		}
		return null;
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
	
	@SuppressWarnings("unchecked")
	private void checkDoubleOidsPlusReferences(BiMap<IdEObject, Long> done, IdEObject idEObject) {
		if (idEObject == null) {
			return;
		}
		if (idEObject instanceof WrappedValue || idEObject instanceof IfcGloballyUniqueId) {
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
				List list = (List)idEObject.eGet(eReference);
				for (Object o : list) {
					checkDoubleOidsPlusReferences(done, (IdEObject) o);
				}
			} else {
				checkDoubleOidsPlusReferences(done, (IdEObject) idEObject.eGet(eReference));
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void showBackReferences(IdEObject idEObject) {
		System.out.println("Showing back references to: " + idEObject);
		for (IdEObject object : getValues()) {
			for (EReference eReference : object.eClass().getEAllReferences()) {
				if (eReference.isMany()) {
					List list = (List)object.eGet(eReference);
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

	public void resetOids() {
		Set<IdEObject> done = new HashSet<IdEObject>();
		for (IdEObject idEObject : objects.values()) {
			resetOids(idEObject, done);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void resetOids(IdEObject idEObject, Set<IdEObject> done) {
		if (idEObject == null) {
			return;
		}
		if (done.contains(idEObject)) {
			return;
		}
		idEObject.setOid(-1);
		done.add(idEObject);
		for (EReference eReference : idEObject.eClass().getEAllReferences()) {
			Object val = idEObject.eGet(eReference);
			if (eReference.isMany()) {
				List list = (List)val;
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
}