package org.bimserver.ifc.xml.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Factory;
import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package;
import org.bimserver.ifc.emf.Ifc2x3.Tristate;
import org.bimserver.ifc.file.reader.IncorrectIfcFileException;
import org.bimserver.ifc.file.reader.WaitingObject;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class OldIfcXmlDeserializer {
	private final Map<Long, List<WaitingObject>> waitingObjects = new HashMap<Long, List<WaitingObject>>();

	private static enum State {
		NONE, ISO_10303_28, UOS, OBJECT, FIELD, REFERENCE, DONE, VALUE,
	}

	private State state = State.NONE;

	public OldIfcXmlDeserializer() {

	}

	@SuppressWarnings("unchecked")
	public BiMap<Long, IdEObject> read(File file) throws IfcXmlDeserializeException {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		BiMap<Long, IdEObject> map = HashBiMap.create();
		try {
			XMLStreamReader reader = inputFactory.createXMLStreamReader(new FileInputStream(file));
			IdEObject object = null;
			EObject parentObject = null;
			String valueName = null;
			EStructuralFeature structuralFeature = null;
			while (reader.hasNext()) {
				switch (reader.getEventType()) {
				case XMLStreamReader.START_ELEMENT:
					switch (state) {
					case NONE: {
						if (reader.getLocalName().equalsIgnoreCase("iso_10303_28")) {
							state = State.ISO_10303_28;
						}
						break;
					}
					case ISO_10303_28: {
						if (reader.getLocalName().equalsIgnoreCase("uos")) {
							state = State.UOS;
						}
						break;
					}
					case UOS: {
						EClassifier classifier = Ifc2x3Package.eINSTANCE.getEClassifier(reader.getLocalName());
						if (classifier == null) {
							throw new IfcXmlDeserializeException("No classifier with name " + reader.getLocalName() + " found");
						} else {
							state = State.OBJECT;
							object = (IdEObject) Ifc2x3Factory.eINSTANCE.create((EClass) classifier);
							String idString = reader.getAttributeValue(null, "id");
							if (idString != null) {
								long id = Long.parseLong(idString.substring(1));
								// System.out.println(id + " " +
								// object.eClass().getName());
								map.put(id, object);
								parentObject = object;
							}
							String refString = reader.getAttributeValue(null, "ref");
							if (refString != null) {
								long refId = Long.parseLong(refString.substring(1));
								if (map.containsKey(refId)) {
									// System.out.println(refId);
									EObject object2 = map.get(refId);
									if (structuralFeature != null) {
										if (structuralFeature.getUpperBound() == 1) {
											parentObject.eSet(structuralFeature, object2);
										} else {
											BasicEList<EObject> list = (BasicEList<EObject>) parentObject.eGet(structuralFeature);
											list.addUnique(object2);
										}
									}
								} else {
									if (structuralFeature != null) {
										List<WaitingObject> waitingList = null;
										if (waitingObjects.containsKey(refId)) {
											waitingList = waitingObjects.get(refId);
										} else {
											waitingList = new ArrayList<WaitingObject>();
											waitingObjects.put(refId, waitingList);
										}
										if (reader.getAttributeValue("ex", "pos") != null) {
											waitingList.add(new WaitingObject(parentObject, structuralFeature, Integer.parseInt(reader.getAttributeValue("ex", "pos"))));
										} else {
											waitingList.add(new WaitingObject(parentObject, structuralFeature, -1));
										}
									}
								}
							}
						}
					}
						break;
					case OBJECT: {
						state = State.FIELD;
						structuralFeature = object.eClass().getEStructuralFeature(reader.getLocalName());
						if (structuralFeature == null) {
							throw new IfcXmlDeserializeException("Field with name " + reader.getLocalName() + " not found");
						}
					}
						break;
					case FIELD: {
						if (reader.getAttributeValue("", "ref") != null) {
							state = State.REFERENCE;
						} else {
							state = State.VALUE;
							valueName = reader.getLocalName();
						}
					}
						break;
					}
					break;
				case XMLStreamReader.END_ELEMENT:
					switch (state) {
					case UOS: {
						state = State.ISO_10303_28;
						return map;
					}
					case ISO_10303_28: {
						state = State.DONE;
					}
						break;
					case OBJECT: {
						state = State.UOS;
						object = null;
					}
						break;
					case FIELD: {
						state = State.OBJECT;
						structuralFeature = null;
					}
						break;
					case REFERENCE: {
						state = State.FIELD;
					}
						break;
					}
					break;
				case XMLStreamReader.CHARACTERS:
					if (reader.isWhiteSpace()) {
						break;
					}
					switch (state) {
					case DONE: {

					}
						break;
					case VALUE: {
						if (structuralFeature.isMany()) {
							System.out.println(structuralFeature);
						} else {
							if (structuralFeature.getEType() instanceof EEnum) {

							} else {
								String text = reader.getText().trim();
								Object value = null;
								if (structuralFeature.getEType() == EcorePackage.eINSTANCE.getEFloat()) {
									value = Float.parseFloat(text);
								} else if (structuralFeature.getEType() == EcorePackage.eINSTANCE.getEString()) {
									value = text;
								} else if (structuralFeature.getEType() == EcorePackage.eINSTANCE.getEInt()) {
									value = Integer.parseInt(text);
								} else if (structuralFeature.getEType() == EcorePackage.eINSTANCE.getEBoolean()) {
									value = Boolean.parseBoolean(text);
								} else {
									throw new RuntimeException("Unimplemented type " + structuralFeature.getEType().getName() + " " + object.getClass().getSimpleName() + "."
											+ structuralFeature.getName());
								}
								object.eSet(structuralFeature, value);
							}
						}
					}
						break;
					case OBJECT: {
					}
						break;
					case UOS: {
					}
						break;
					}
					// if (structuralFeature != null) {
					// // System.out.println(object.eClass().getName() + "." +
					// // structuralFeature.getName());
					// if (structuralFeature.getEType() instanceof EClass) {
					// EClass wrappedClass = (EClass)
					// structuralFeature.getEType();
					// EStructuralFeature wrappedValueSf =
					// wrappedClass.getEStructuralFeature("wrappedValue");
					// if (wrappedValueSf != null) {
					// EObject wrappedObject =
					// Ifc2x3Factory.eINSTANCE.create(wrappedClass);
					// String text = reader.getText().trim();
					// if (text.equals("")) {
					// if (wrappedValueSf.getEType() ==
					// EcorePackage.eINSTANCE.getEString()) {
					// wrappedObject.eSet(wrappedValueSf, text);
					// } else if (wrappedValueSf.getEType() ==
					// EcorePackage.eINSTANCE.getEFloat()) {
					// wrappedObject.eSet(wrappedValueSf, 0.0F);
					// wrappedObject.eSet(wrappedClass.getEStructuralFeature("stringValue"
					// + "wrappedValue"), text);
					// }
					// } else {
					// if (wrappedValueSf.getEType() ==
					// EcorePackage.eINSTANCE.getEInt()) {
					// wrappedObject.eSet(wrappedValueSf,
					// Integer.parseInt(text));
					// } else if (wrappedValueSf.getEType() ==
					// EcorePackage.eINSTANCE.getEFloat()) {
					// wrappedObject.eSet(wrappedValueSf,
					// Float.parseFloat(text));
					// wrappedObject.eSet(wrappedClass.getEStructuralFeature("stringValue"
					// + "wrappedValue"), text);
					// } else if (wrappedValueSf.getEType() ==
					// Ifc2x3Package.eINSTANCE.getTristate()) {
					// Tristate tristate = null;
					// if (text.equals("true")) {
					// tristate = Tristate.TRUE;
					// } else if (text.equals("false")) {
					// tristate = Tristate.FALSE;
					// } else {
					// tristate = Tristate.UNDEFINED;
					// }
					// wrappedObject.eSet(wrappedValueSf, tristate);
					// } else if (wrappedValueSf.getEType() ==
					// EcorePackage.eINSTANCE.getEString()) {
					// wrappedObject.eSet(wrappedValueSf, text);
					// } else {
					// System.out.println(wrappedValueSf.getEType());
					// }
					// }
					// if (structuralFeature.getUpperBound() == 1) {
					// parentObject.eSet(structuralFeature, wrappedObject);
					// } else {
					// BasicEList list = (BasicEList)
					// parentObject.eGet(structuralFeature);
					// list.addUnique(wrappedObject);
					// }
					// } else if (structuralFeature.getEType() instanceof EEnum)
					// {
					// EEnum eEnum = (EEnum) structuralFeature.getEType();
					// String text = reader.getText().trim();
					// EEnumLiteral enumLiteral =
					// eEnum.getEEnumLiteral(text.toUpperCase());
					// if (enumLiteral != null) {
					// parentObject.eSet(structuralFeature,
					// enumLiteral.getInstance());
					// }
					// } else if (structuralFeature.getEType() instanceof
					// EDataType) {
					// }
					// }
					// }
					break;
				}
				reader.next();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	private void updateNode(Long id, EClass ec, EObject eObject) throws IncorrectIfcFileException {
		for (WaitingObject waitingObject : waitingObjects.get(id)) {
			if (waitingObject.getStructuralFeature().getUpperBound() != 1) {
				BasicEList<EObject> list = (BasicEList<EObject>) waitingObject.getObject().eGet(waitingObject.getStructuralFeature());
				if (waitingObject.getIndex() == -1) {
					list.addUnique(eObject);
				} else {
					if (((EClass) waitingObject.getStructuralFeature().getEType()).isSuperTypeOf(eObject.eClass())) {
						while (list.size() <= waitingObject.getIndex()) {
							list.addUnique(ec.getEPackage().getEFactoryInstance().create(eObject.eClass()));
						}
						list.setUnique(waitingObject.getIndex(), eObject);
					} else {
						throw new IncorrectIfcFileException("Field " + waitingObject.getStructuralFeature().getName() + " of "
								+ waitingObject.getStructuralFeature().getEContainingClass().getName() + " cannot contain a " + eObject.eClass().getName());
					}
				}
			} else {
				if (((EClass) waitingObject.getStructuralFeature().getEType()).isSuperTypeOf(eObject.eClass())) {
					waitingObject.getObject().eSet(waitingObject.getStructuralFeature(), eObject);
				} else {
					throw new IncorrectIfcFileException("Field " + waitingObject.getStructuralFeature().getName() + " of "
							+ waitingObject.getStructuralFeature().getEContainingClass().getName() + " cannot contain a " + eObject.eClass().getName());
				}
			}
		}
		waitingObjects.remove(id);
	}
}
