//package org.bimserver.ifc.berkeley.reader;

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

//import java.util.Comparator;
//import java.util.Map;
//import java.util.TreeMap;
//
//import org.bimserver.emf2codb.BerkeleyColumnDatabase;
//import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Factory;
//import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package;
//import org.bimserver.utils.BinUtils;
//import org.bimserver.utils.DoubleHashMap;
//import org.eclipse.emf.common.util.BasicEList;
//import org.eclipse.emf.ecore.EAttribute;
//import org.eclipse.emf.ecore.EClass;
//import org.eclipse.emf.ecore.EEnum;
//import org.eclipse.emf.ecore.EEnumLiteral;
//import org.eclipse.emf.ecore.EObject;
//import org.eclipse.emf.ecore.EReference;
//import org.eclipse.emf.ecore.EStructuralFeature;
//import org.eclipse.emf.ecore.impl.EEnumImpl;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.sleepycat.je.Transaction;
//
//public class BerkeleyIfcReader {
//	private static Logger logger = LoggerFactory.getLogger(BerkeleyIfcReader.class);
//	
//	private DoubleHashMap<Long, EObject> reading = new DoubleHashMap<Long, EObject>(1000000);
//	private final BerkeleyColumnDatabase database;
//	
//	public BerkeleyIfcReader(BerkeleyColumnDatabase database) {
//		this.database = database;
//	}
//
//	public Map<Long, EObject> restore(long projectId, Transaction transaction) {
//		long s = System.nanoTime();
//		Map<Long, EObject> map = new TreeMap<Long, EObject>(new Comparator<Long>(){
//			@Override
//			public int compare(Long arg0, Long arg1) {
//				return (int)(arg0 - arg1);
//			}});
//		String projectItems = new String(database.get("", "P" + projectId, transaction));
//		String[] items = projectItems.split(",");
//		for (String item : items) {
//			map.put(Long.parseLong(item), readObject(Long.parseLong(item), transaction));
//		}
//		long e = System.nanoTime();
//		logger.info("Reading from BDB in " + ((e - s) / 1000000) + " ms");
//		return map;
//	}
//
//	private EObject readObject(long key, Transaction transaction) {
//		if (reading.containsA(key)) {
//			return reading.getB(key);
//		}
//		if (key % 10000 == 0) {
//			logger.info("bdb read id: " + key);
//		}
//		byte[] data = database.get("", "I" + key, transaction);
//		String className = new String(data);
//		EClass eClass = (EClass)Ifc2x3Package.eINSTANCE.getEClassifier(className);
//		EObject object = Ifc2x3Factory.eINSTANCE.create(eClass);
//		reading.put(key, object);
//		int i = 0;
//		for (EReference reference : eClass.getEAllReferences()) {
//			Object value = readReference(reference, key, i++, transaction);
//			try {
//				object.eSet(reference, value);
//			} catch (Exception e) {
//				
//			}
//		}
//		for (EAttribute attribute : eClass.getEAllAttributes()) {
//			Object value = readAttribute(attribute, key, i++, transaction);
//			object.eSet(attribute, value);
//		}
//		return object;
//	}
//
//	private Object readAttribute(EAttribute attribute, long key, int i, Transaction transaction) {
//		byte[] data = database.get("", "A" + key + "." + i, transaction);
//		if (data == null) {
//			return null;
//		}
//		byte[] newArray = new byte[data.length - 47];
//		System.arraycopy(data, 47, newArray, 0, data.length-47);
//		if (attribute.getEType() instanceof EEnum) {
//			EEnumLiteral enumValue = (((EEnumImpl)attribute.getEType()).getEEnumLiteral(new String(newArray)));							
//			return enumValue.getInstance();
//		} else {
//			return new String(newArray);
//		}
//	}
//
//	private Object readEmbedded(byte[] data, EReference reference) {
//		byte[] newArray = new byte[data.length - 47];
//		System.arraycopy(data, 47, newArray, 0, data.length-47);
//		if (((EClass)reference.getEType()).getEStructuralFeature("wrappedValue") != null) {
//			String className = new String(data, 0, 47).trim();
//			EObject create = Ifc2x3Factory.eINSTANCE.create((EClass)Ifc2x3Package.eINSTANCE.getEClassifier(className));
//			EStructuralFeature structuralFeature = create.eClass().getEStructuralFeature("wrappedValue");
//			Class<?> instanceClass = structuralFeature.getEType().getInstanceClass();
//			
//			if (instanceClass == Integer.class || instanceClass == int.class) {
//				create.eSet(structuralFeature, BinUtils.byteArrayToInt(newArray));
//			} else if (instanceClass == String.class) {
//				create.eSet(structuralFeature, new String(newArray));
//			} else if (instanceClass == Float.class || instanceClass == float.class) {
//				create.eSet(structuralFeature, BinUtils.byteArrayToFloat(newArray));
//			} else if (instanceClass == Boolean.class || instanceClass == boolean.class) {
//				create.eSet(structuralFeature, BinUtils.byteArrayToBoolean(newArray));
//			} else if (instanceClass == Double.class || instanceClass == double.class) {
//				create.eSet(structuralFeature, BinUtils.byteArrayToDouble(newArray));
//			} else {
//			}
//			return create;
//		}
//		String s = new String(newArray);
//		return s;
//	}
//	
//	private Object readReference(EReference reference, long key, int i, Transaction transaction) {
//		if (reference.getUpperBound() == 1) {
//			byte[] data = database.get("", "R" + key + "." + i, transaction);
//			if (data == null) {
//				data = database.get("", "E" + key + "." + i, transaction);
//				if (data == null) {
//					return null;
//				} else {
//					return readEmbedded(data, reference);
//				}
//			} else {
//				long newValue = Long.parseLong(new String(data, 48, data.length-48));
//				if (reading.containsA(newValue)) {
//					return reading.getB(newValue);
//				} else {
//					return readObject(newValue, transaction);
//				}
//			}
//		} else {
//			byte[] data = database.get("", "L" + key + "." + i, transaction);
//			if (data != null && data.length > 0 && new String(data).length() > 0) {
//				int listSize = Integer.parseInt(new String(data));
//				BasicEList<EObject> list = new BasicEList<EObject>();
//				for (int j=0; j<listSize; j++) {
//					byte[] row = database.get("", "L" + key + "." + i + "." + j, transaction);
//					if (row != null) {
//						if (((EClass)reference.getEType()).getEStructuralFeature("wrappedValue") != null) {
////							EObject create = Ifc2x3Factory.eINSTANCE.create(((EClass)reference.getEType()));
////							readEmbedded(row, reference);
////							create.eSet(((EClass)reference.getEType()).getEStructuralFeature("wrappedValue"), newValue);
//							list.addUnique((EObject)readEmbedded(row, reference));
//						} else {
//							long q = Long.parseLong(new String(row));
//							if (reading.containsA(q)) {
//								list.addUnique(reading.getB(q));
//							} else {
//								list.addUnique(readObject(q, transaction));
//							}
//						}
//					}
//				}
//				return list;
//			} else {
//				return null;
//			}
//		}
//	}
//}
