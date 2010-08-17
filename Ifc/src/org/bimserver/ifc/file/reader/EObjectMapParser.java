package org.bimserver.ifc.file.reader;

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

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import nl.tue.buildingsmart.express.dictionary.Attribute;
import nl.tue.buildingsmart.express.dictionary.EntityDefinition;
import nl.tue.buildingsmart.express.dictionary.ExplicitAttribute;
import nl.tue.buildingsmart.express.dictionary.InverseAttribute;
import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;

import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.impl.EEnumImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EObjectMapParser {
	private static final String WRAPPED_VALUE = "wrappedValue";
	private static final Logger LOGGER = LoggerFactory.getLogger(EObjectMapParser.class);
	
	private final SchemaDefinition schemaDefinition;
	private final EPackage ePackage;
	private final Map<String, String> upperToCamelMap = new HashMap<String, String>();
	private final Map<Long, IfcNode> objects;

	public EObjectMapParser(SchemaDefinition schemaDefinition, int capacityHint) {
		this.schemaDefinition = schemaDefinition;
		this.ePackage = EPackage.Registry.INSTANCE.getEPackage(Ifc2x3Package.eNS_URI);
		objects = new HashMap<Long, IfcNode>(capacityHint);
		EList<EClassifier> classifiers = ePackage.getEClassifiers();
		for (EClassifier eClassifier : classifiers) {
			upperToCamelMap.put(eClassifier.getName().toUpperCase(), eClassifier.getName());
		}
	}

	public Map<Long, EObject> getObjects() {
		Map<Long, EObject> result = new TreeMap<Long, EObject>();
		for (Long key : objects.keySet()) {
			result.put(key, objects.get(key).getEObject());
		}
		return result;
	}

	private EObject convert(EStructuralFeature feature, String value) {
		if (feature != null) {
			EClassifier type = feature.getEType();
			if (type instanceof EClassImpl) {
				if (null != ((EClassImpl) type).getEStructuralFeature(WRAPPED_VALUE)) {
					EObject create = ePackage.getEFactoryInstance().create((EClass) feature.getEType());
					Class<?> instanceClass = create.eClass().getEStructuralFeature(WRAPPED_VALUE).getEType().getInstanceClass();
					if (instanceClass == Double.class || instanceClass == double.class) {
						if (!value.equals("")) {
							create.eSet(create.eClass().getEStructuralFeature(WRAPPED_VALUE), Double.parseDouble(value));
						}
					} else if (instanceClass == Integer.class || instanceClass == int.class) {
						create.eSet(create.eClass().getEStructuralFeature(WRAPPED_VALUE), Integer.parseInt(value));
					} else if (instanceClass == Long.class || instanceClass == long.class) {
						create.eSet(create.eClass().getEStructuralFeature(WRAPPED_VALUE), Long.parseLong(value));
					} else if (instanceClass == Boolean.class || instanceClass == boolean.class) {
						create.eSet(create.eClass().getEStructuralFeature(WRAPPED_VALUE), Boolean.parseBoolean(value));
					} else if (instanceClass == Float.class || instanceClass == float.class) {
						create.eSet(create.eClass().getEStructuralFeature(WRAPPED_VALUE), Float.parseFloat(value));
					} else if (instanceClass == String.class) {
						create.eSet(create.eClass().getEStructuralFeature(WRAPPED_VALUE), value);
					}
					return create;
				}
			}
		}
		return null;
	}

	public void parse(Long id, List<IfcPair> currentRecord, String entityName) throws IfcReaderException {
		if (id % 10000 == 0) {
			LOGGER.info("reading id: " + id);
		}
		EClass ec = (EClass) ePackage.getEClassifier(upperToCamelMap.get(entityName));
		EObject eObject = ec.getEPackage().getEFactoryInstance().create(ec);
		EntityDefinition entDef = schemaDefinition.getEntityBN(entityName);
		Iterator<Attribute> attributes = entDef.getAttributes(true).iterator();
		Iterator<IfcPair> records = currentRecord.iterator();
		while (attributes.hasNext()) {
			Attribute attr = attributes.next();
			if (!(attr instanceof InverseAttribute)) {
				IfcPair tmp = records.next();
				if (tmp instanceof IfcSimplePair) {
					String newValue = ((IfcSimplePair) tmp).getName();
					if (newValue.startsWith("#")) {
						readReference(eObject, attr, newValue);
					} else if (newValue.startsWith(".") && newValue.endsWith(".")) {
						readEnumOrBoolean(ec, eObject, attr, newValue);
					} else if (newValue.equals("$")) {
						EStructuralFeature structuralFeature = eObject.eClass().getEStructuralFeature(((ExplicitAttribute) attr).getName());
						eObject.eUnset(structuralFeature);
					} else {
						EStructuralFeature structuralFeature = eObject.eClass().getEStructuralFeature(((ExplicitAttribute) attr).getName());
						if (structuralFeature == null) {
							throw new IfcReaderException("unknown structural feature " + ec.getName() + "." + ((ExplicitAttribute) attr).getName());
						} else {
							eObject.eSet(structuralFeature, convert(structuralFeature, newValue));
						}
					}
				} else if (tmp instanceof IfcListPair) {
					readList(eObject, attr, (IfcListPair) tmp);
				} else if (tmp instanceof IfcOmittedPair) {
					// Object[] ar = (Object[])tmp;
					// Object ob = processArray(eObject, attr, ar);
					// EStructuralFeature structuralFeature =
					// eObject.eClass().getEStructuralFeature(((ExplicitAttribute)
					// attr).getName());
					// eObject.eSet(structuralFeature, ob);
				}
			} else if (attr instanceof InverseAttribute) {
				// Inverses should be handled by EMF
			}
		}
		if (objects.containsKey(id)) {
			updateNode(id, ec, eObject);
		} else {
			objects.put(id, new IfcNode(eObject));
		}
	}

	@SuppressWarnings("unchecked")
	private void updateNode(Long id, EClass ec, EObject eObject) {
		IfcNode ifcNode = objects.get(id);
		ifcNode.setObject(eObject);
		for (WaitingObject waitingObject : ifcNode.getWaiting()) {
			if (waitingObject.getStructuralFeature().getUpperBound() != 1) {
				BasicEList<EObject> list = (BasicEList<EObject>) waitingObject.getObject().eGet(waitingObject.getStructuralFeature());
				if (waitingObject.getIndex() == -1) {
					list.addUnique(eObject);
				} else {
					while (list.size() <= waitingObject.getIndex()) {
						list.addUnique(ec.getEPackage().getEFactoryInstance().create(eObject.eClass()));
					}
					list.setUnique(waitingObject.getIndex(), eObject);
				}
			} else {
				waitingObject.getObject().eSet(waitingObject.getStructuralFeature(), eObject);
			}
		}
		ifcNode.clearWaiting();
	}

	@SuppressWarnings("unchecked")
	private void readList(EObject eObject, Attribute attr, IfcListPair tmp) throws IfcReaderException {
		EStructuralFeature structuralFeature = eObject.eClass().getEStructuralFeature(((ExplicitAttribute) attr).getName());
		if (structuralFeature != null) {
			if (structuralFeature.getUpperBound() == 1) {
				EObject processArray = processArray(eObject, attr, tmp);
				eObject.eSet(structuralFeature, processArray);
			} else {
				BasicEList<EObject> list = new BasicEList<EObject>();
				eObject.eSet(structuralFeature, list);
				list = (BasicEList<EObject>) eObject.eGet(structuralFeature);
				int index = 0;
				for (IfcPair pair : tmp.getList()) {
					if (pair instanceof IfcSimplePair) {
						String val = pair.getName();
						if (val.startsWith("#")) {
							Long referenceId = Long.parseLong(val.substring(1));
							if (objects.containsKey(referenceId)) {
								// assign
								EObject object = objects.get(referenceId).getEObject();
								while (list.size() <= index) {
									list.addUnique(ePackage.getEFactoryInstance().create(object.eClass()));
								}
								list.setUnique(index, object);
							} else {
								// put in waiting list
								IfcNode node = new IfcNode();
								node.addWaiting(eObject, structuralFeature, index);
								objects.put(referenceId, node);
							}
						} else if (val.startsWith("(") && val.endsWith(")")) {
							String[] l = val.substring(1, val.length() - 1).split(",");
							for (String a : l) {
								if (a.startsWith("#")) {
									Long referenceId = Long.parseLong(a.substring(1));
									if (objects.containsKey(referenceId)) {
										// assign
										list.addUnique(objects.get(referenceId).getEObject());
									} else {
										// put in waiting list
										IfcNode node = new IfcNode();
										node.addWaiting(eObject, structuralFeature);
										objects.put(referenceId, node);
									}
								}
							}
						} else {
							EObject convert = convert(structuralFeature, val);
							if (convert != null) {
								list.addUnique(convert);
							}
						}
					} else {
						// LOGGER.info(pair);
						// } else if (pair instanceof Object[]) {
						// EObject ob = processArray(eObject, attr,
						// (Object[])pair);
						// list.addUnique(ob);
					}
					index++;
				}
			}
		} else {
			throw new IfcReaderException("StructuralFeature " + ((ExplicitAttribute) attr).getName() + " not found on " + eObject.eClass().getName());
		}
	}

	private void readEnumOrBoolean(EClass ec, EObject eObject, Attribute attr, String newValue) {
		EStructuralFeature structuralFeature = eObject.eClass().getEStructuralFeature(((ExplicitAttribute) attr).getName());
		if (structuralFeature == null) {
			new Exception("feature not found: " + ec.getName() + "." + ((ExplicitAttribute) attr).getName()).printStackTrace();
		}
		if (newValue.equals(".T.")) {
//			IfcBoolean createIfcBoolean = Ifc2x3Factory.eINSTANCE.createIfcBoolean();
//			createIfcBoolean.setWrappedValue(true);
//			eObject.eSet(structuralFeature, createIfcBoolean);
		} else if (newValue.equals(".F.")) {
//			IfcBoolean createIfcBoolean = Ifc2x3Factory.eINSTANCE.createIfcBoolean();
//			createIfcBoolean.setWrappedValue(false);
//			eObject.eSet(structuralFeature, createIfcBoolean);
		} else if (newValue.equals(".U.")) {
			if (structuralFeature.getEType().getName().equals("IfcLogical")) {
				eObject.eUnset(structuralFeature);
			} else {
				eObject.eUnset(structuralFeature);
			}
		} else {
			String realEnumValue = newValue.substring(1, newValue.length() - 1);
			EEnumLiteral enumValue = (((EEnumImpl) structuralFeature.getEType()).getEEnumLiteral(realEnumValue));
			eObject.eSet(structuralFeature, enumValue.getInstance());
		}
	}

	private void readReference(EObject eObject, Attribute attr, String newValue) {
		Long referenceId = Long.parseLong(newValue.substring(1));
		EStructuralFeature structuralFeature = eObject.eClass().getEStructuralFeature(((ExplicitAttribute) attr).getName());
		if (objects.containsKey(referenceId)) {
			// assign
			eObject.eSet(structuralFeature, objects.get(referenceId).getEObject());
		} else {
			// put in waiting list
			IfcNode node = new IfcNode();
			node.addWaiting(eObject, structuralFeature);
			objects.put(referenceId, node);
		}
	}

	private EObject processArray(EObject eObject, Attribute attr, IfcListPair pair) {
		EClass cl = (EClass) ePackage.getEClassifier(upperToCamelMap.get(pair.getName()));
		EObject o = cl.getEPackage().getEFactoryInstance().create(cl);
		if (o.eClass().getEStructuralFeature(WRAPPED_VALUE) != null) {
			String v = pair.getList().get(0).getName();
			Class<?> instanceClass = o.eClass().getEStructuralFeature(WRAPPED_VALUE).getEType().getInstanceClass();
			if (instanceClass == Double.class || instanceClass == double.class) {
				Double result = Double.parseDouble(v);
				if (result != null) {
					o.eSet(o.eClass().getEStructuralFeature(WRAPPED_VALUE), result);
				}
			} else if (instanceClass == String.class) {
				if (v != null) {
					o.eSet(o.eClass().getEStructuralFeature(WRAPPED_VALUE), v);
				}
			} else if (instanceClass == Integer.class || instanceClass == int.class) {
				if (v != null) {
					o.eSet(o.eClass().getEStructuralFeature(WRAPPED_VALUE), Integer.parseInt(v));
				}
			} else if (instanceClass == Float.class || instanceClass == float.class) {
				if (v != null) {
					o.eSet(o.eClass().getEStructuralFeature(WRAPPED_VALUE), Float.parseFloat(v));
				}
			}
		}
		return o;
	}
}