//package org.bimserver.ifc.berkeley.writer;

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

//import java.io.UnsupportedEncodingException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import org.bimserver.emf2codb.BerkeleyColumnDatabase;
//import org.bimserver.utils.BinUtils;
//import org.bimserver.utils.DoubleHashMapWithValue;
//import org.bimserver.utils.StringUtils;
//import org.eclipse.emf.ecore.EAttribute;
//import org.eclipse.emf.ecore.EClass;
//import org.eclipse.emf.ecore.EEnum;
//import org.eclipse.emf.ecore.EObject;
//import org.eclipse.emf.ecore.EReference;
//import org.eclipse.emf.ecore.util.EObjectEList;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.sleepycat.je.DatabaseException;
//import com.sleepycat.je.Transaction;
//
//public class BerkeleyIfcWriter {
//	private static final Logger LOGGER = LoggerFactory.getLogger(BerkeleyIfcWriter.class);
//
//	private DoubleHashMapWithValue<EObject, Long, Boolean> storing;
//	private final BerkeleyColumnDatabase database;
//	private long projectIdCounter;
//
//	public BerkeleyIfcWriter(BerkeleyColumnDatabase database) {
//		this.database = database;
//	}
//
//	public long store(Map<Long, EObject> map, Transaction transaction) throws DatabaseException {
//		long s = System.nanoTime();
//		storing = new DoubleHashMapWithValue<EObject, Long, Boolean>(map.size());
//		List<Long> keys = new ArrayList<Long>();
//		for (Long key : map.keySet()) {
//			storing.put(map.get(key), key, false);
//		}
//		for (Long key : map.keySet()) {
//			keys.add(store(key, map.get(key), transaction));
//		}
//		StringBuilder projectString = new StringBuilder();
//		for (Long key : keys) {
//			projectString.append(key + ",");
//		}
//		StringUtils.stripEnd(projectString, ",");
//		long projectId = this.projectIdCounter++;
//		database.store("", "P" + projectId, projectString.toString(), transaction);
//		long e = System.nanoTime();
//		LOGGER.info(map.size() + " objects (" + database.getTotalWrites() + " records) written to BDB in " + ((e - s) / 1000000) + " ms");
//		return projectId;
//	}
//	
//	public long store(long key, EObject eObject, Transaction transaction) throws DatabaseException {
//		if (storing.containsA(eObject) && storing.getC(eObject)) {
//			return storing.getB(eObject);
//		}
//		if (key % 10000 == 0) {
//			LOGGER.info("bdb write id: " + key);
//		}
//		EClass eClass = eObject.eClass();
//		database.store("", "I" + key, eClass.getName(), transaction);
//		storing.put(eObject, key, true);
//		int i = 0;
//		for (EReference reference : eClass.getEAllReferences()) {
//			storeReference(eObject, transaction, key, i, reference);
//			i++;
//		}
//		for (EAttribute attribute : eClass.getEAllAttributes()) {
//			storeAttribute(eObject, transaction, key, i, attribute);
//			i++;
//		}
//		return key;
//	}
//
//	private void storeAttribute(EObject eObject, Transaction transaction, long id, int i, EAttribute attribute) throws DatabaseException {
//		String name = attribute.getEType().getName();
//		if (name.equals("EString")) {
//			try {
//				database.store("", "A" + id + "." + i, attribute.getName(), 47, ((String)eObject.eGet(attribute)).getBytes("UTF-8"), transaction);
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
//		} else if (name.equals("EInt")) {
//			database.store("", "A" + id + "." + i, attribute.getName(), 47, BinUtils.intToByteArray(((Integer) eObject.eGet(attribute))), transaction);
//		} else if (name.equals("EFloat")) {
//			database.store("", "A" + id + "." + i, attribute.getName(), 47, BinUtils.floatToByteArray(((Float) eObject.eGet(attribute))), transaction);
//		} else if (name.equals("EDouble")) {
//			database.store("", "A" + id + "." + i, attribute.getName(), 47, BinUtils.doubleToByteArray(((Double) eObject.eGet(attribute))), transaction);
//		} else if (attribute.getEType() instanceof EEnum) {
//			try {
//				database.store("", "A" + id + "." + i, attribute.getName(), 47, eObject.eGet(attribute).toString().getBytes("UTF-8"), transaction);
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
//		} else {
//		}
//	}
//
//	@SuppressWarnings("unchecked")
//	private void storeReference(EObject eObject, Transaction transaction, long id, int i, EReference reference) throws DatabaseException {
//		Object referencedObject = eObject.eGet(reference);
//		if (referencedObject instanceof EObject) {
//			if (storing.containsA((EObject)referencedObject)) {
//				long referenceId = storing.getB((EObject) referencedObject);
//				database.store("", "R" + id + "." + i, "I" + StringUtils.fill(((EObject)referencedObject).eClass().getName(), 47, " ") + referenceId, transaction);
//			} else {
//				Object o = convert(((EObject) referencedObject));
//				if (o != null) {
//					database.storeObject("", "E" + id + "." + i, ((EObject)referencedObject).eClass().getName(), 47, o, transaction);							
////
////					database.storeObject("E" + id + "." + i, o, transaction);
//				}
//			}
//		} else if (referencedObject instanceof EObjectEList) {
//			EObjectEList<EObject> list = (EObjectEList<EObject>) referencedObject;
//			int size = list.size();
//			int j = 0;
//			for (Object ob : list) {
//				if (storing.containsA((EObject) ob)) {
//					long referenceId = storing.getB((EObject) ob);
//					database.store("", "L" + id + "." + i + "." + j, "" + referenceId, transaction);
//				} else {
//					Object o = convert((EObject)ob);
//					if (o != null) {
//						database.storeObject("", "L" + id + "." + i + "." + j, ((EObject)ob).eClass().getName(), 47, o, transaction);							
//					}
//				}
//				j++;
//			}
//			database.store("", "L" + id + "." + i, "" + size, transaction);
//		}
//	}
//
//	private Object convert(EObject eObject) {
//		EClass ec = eObject.eClass();
//		if (ec.getEStructuralFeature("wrappedValue") != null) {
//			Object get = eObject.eGet(ec.getEStructuralFeature("wrappedValue"));
//			return get;
//		}
//		return null;
//	}
//}