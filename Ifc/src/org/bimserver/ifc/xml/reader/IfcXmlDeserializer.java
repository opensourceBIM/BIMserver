package org.bimserver.ifc.xml.reader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Factory;
import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package;
import org.bimserver.ifc.file.reader.WaitingObject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

public class IfcXmlDeserializer {

	private IfcModel model = new IfcModel();
	private final Map<Long, List<WaitingObject>> waitingObjects = new HashMap<Long, List<WaitingObject>>();

	public IfcModel read(InputStream inputStream) throws IfcXmlDeserializeException {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		try {
			XMLStreamReader reader = inputFactory.createXMLStreamReader(inputStream);
			parseDocument(reader);
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		return model;
	}

	private void parseDocument(XMLStreamReader reader) throws XMLStreamException, IfcXmlDeserializeException {
		while (reader.hasNext()) {
			reader.next();
			if (reader.getEventType() == XMLStreamReader.START_ELEMENT) {
				if (reader.getLocalName().equalsIgnoreCase("iso_10303_28")) {
					parseIso_10303_28(reader);
				}
			}
		}
	}

	private void parseIso_10303_28(XMLStreamReader reader) throws XMLStreamException, IfcXmlDeserializeException {
		while (reader.hasNext()) {
			reader.next();
			if (reader.getEventType() == XMLStreamReader.START_ELEMENT) {
				if (reader.getLocalName().equalsIgnoreCase("uos")) {
					parseUos(reader);
				}
			} else if (reader.getEventType() == XMLStreamReader.END_ELEMENT) {
				if (reader.getLocalName().equals("iso_10303_28")) {
					return;
				}
			}
		}
	}

	private void parseUos(XMLStreamReader reader) throws XMLStreamException, IfcXmlDeserializeException {
		while (reader.hasNext()) {
			reader.next();
			if (reader.getEventType() == XMLStreamReader.START_ELEMENT) {
				parseObject(reader);
			} else if (reader.getEventType() == XMLStreamReader.END_ELEMENT) {
				if (reader.getLocalName().equalsIgnoreCase("uos")) {
					return;
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private IdEObject parseObject(XMLStreamReader reader) throws XMLStreamException, IfcXmlDeserializeException {
		String className = reader.getLocalName();
		EClassifier eClassifier = Ifc2x3Package.eINSTANCE.getEClassifier(className);
		if (eClassifier == null || !(eClassifier instanceof EClass)) {
			throw new IfcXmlDeserializeException("No class with name " + className + " was found");
		}
		String id = reader.getAttributeValue("", "id");
		if (id == null) {
			throw new IfcXmlDeserializeException("No id attribute found on " + className);
		}
		if (!id.startsWith("i")) {
			throw new IfcXmlDeserializeException("Id " + id + " is not starting with the letter 'i'");
		}
		EClass eClass = (EClass) eClassifier;
		IdEObject object = (IdEObject) Ifc2x3Factory.eINSTANCE.create(eClass);
		long oid = Long.parseLong(id.substring(1));
		model.add(oid, object);
		if (waitingObjects.containsKey(oid)) {
			for (WaitingObject waitingObject : waitingObjects.get(oid)) {
				if (waitingObject.getStructuralFeature().isMany()) {
					List list = (List) waitingObject.getObject().eGet(waitingObject.getStructuralFeature());
					if (waitingObject.getIndex() == -1) {
						list.add(object);
					} else {
						if (list.size() > waitingObject.getIndex()) {
							list.set(waitingObject.getIndex(), object);
						} else {
							for (int i=list.size()-1; i<waitingObject.getIndex()-1; i++) {
								EObject tmp = object.eClass().getEPackage().getEFactoryInstance().create(object.eClass());
								list.add(tmp);
							}
							list.add(object);
						}
					}
				} else {
					waitingObject.getObject().eSet(waitingObject.getStructuralFeature(), object);
				}
			}
			waitingObjects.remove(oid);
		}
		while (reader.hasNext()) {
			reader.next();
			if (reader.getEventType() == XMLStreamReader.START_ELEMENT) {
				parseField(object, reader);
			} else if (reader.getEventType() == XMLStreamReader.END_ELEMENT) {
				if (reader.getLocalName().equalsIgnoreCase(className)) {
					return object;
				}
			}
		}
		return object;
	}

	@SuppressWarnings("unchecked")
	private void parseField(IdEObject object, XMLStreamReader reader) throws XMLStreamException, IfcXmlDeserializeException {
		String fieldName = reader.getLocalName();
		EStructuralFeature eStructuralFeature = object.eClass().getEStructuralFeature(fieldName);
		if (eStructuralFeature == null) {
			throw new IfcXmlDeserializeException("Field " + fieldName + " not found on class " + object.eClass().getName());
		}
		EClassifier realType = null;
		while (reader.hasNext()) {
			reader.next();
			if (reader.getEventType() == XMLStreamReader.START_ELEMENT) {
				if (reader.getAttributeValue("", "id") != null) {
					IdEObject reference = parseObject(reader);
					if (eStructuralFeature.isMany()) {
						((List) object.eGet(eStructuralFeature)).add(reference);
					} else {
						object.eSet(eStructuralFeature, reference);
					}
				} else if (reader.getAttributeValue("", "ref") != null) {
					String ref = reader.getAttributeValue("", "ref");
					if (!ref.startsWith("i")) {
						throw new IfcXmlDeserializeException("Reference id " + ref + " should start with an 'i'");
					}
					Long refId = Long.parseLong(ref.substring(1));
					if (model.containsKey(refId)) {
						IdEObject reference = model.get(refId);
						if (eStructuralFeature.isMany()) {
							String posString = reader.getAttributeValue("urn:iso.org:standard:10303:part(28):version(2):xmlschema:common", "pos");
							int pos;
							if (posString == null) {
								pos = -1;
//								throw new IfcXmlDeserializeException("No pos found on " + object.getOid() + " " + eStructuralFeature.getName());
							} else {
								pos = Integer.parseInt(posString);
							}
							List list = (List) object.eGet(eStructuralFeature);
							if (pos == -1) {
								list.add(reference);
							} else {
								if (list.size() > pos) {
									list.set(pos, reference);
								} else {
									for (int i=list.size()-1; i<pos-1; i++) {
										EObject tmp = reference.eClass().getEPackage().getEFactoryInstance().create(reference.eClass());
										list.add(tmp);
									}
									list.add(reference);
								}
							}
						} else {
							object.eSet(eStructuralFeature, reference);
						}
					} else {
						if (eStructuralFeature.isMany()) {
							String posString = reader.getAttributeValue("urn:iso.org:standard:10303:part(28):version(2):xmlschema:common", "pos");
							int pos;
							if (posString == null) {
								pos = -1;
//								throw new IfcXmlDeserializeException("No pos found on " + object.getOid() + " " + eStructuralFeature.getName());
							} else {
								pos = Integer.parseInt(posString);
							}
							addToWaitingList(object, eStructuralFeature, refId, pos);
						} else {
							addToWaitingList(object, eStructuralFeature, refId, -1);
						}
					}
				} else {
					String realTypeString = reader.getLocalName();
					realType = Ifc2x3Package.eINSTANCE.getEClassifier(realTypeString);
				}
			} else if (reader.getEventType() == XMLStreamReader.END_ELEMENT) {
				if (reader.getLocalName().equalsIgnoreCase(fieldName)) {
					return;
				}
				if (realType != null && reader.getLocalName().equalsIgnoreCase(realType.getName())) {
					realType = null;
				}
			} else if (reader.getEventType() == XMLStreamReader.CHARACTERS) {
				if (!reader.isWhiteSpace()) {
					String text = reader.getText();
					if (eStructuralFeature.getEType() instanceof EDataType) {
						if (eStructuralFeature.isMany()) {
							String[] split = text.split(" ");
							List list = (List) object.eGet(eStructuralFeature);
							for (String s : split) {
								list.add(parsePrimitive(eStructuralFeature.getEType(), s));
							}
						} else {
							object.eSet(eStructuralFeature, parsePrimitive(eStructuralFeature.getEType(), text));
						}
					} else {
						if (realType == null) {
							realType = eStructuralFeature.getEType();
						}
						if (realType instanceof EClass) {
							EClass eClass = (EClass) realType;
							if (Ifc2x3Package.eINSTANCE.getWrappedValue().isSuperTypeOf(eClass)) {
								EObject wrappedObject = Ifc2x3Factory.eINSTANCE.create(eClass);
								EStructuralFeature wrappedValueFeature = eClass.getEStructuralFeature("wrappedValue");
								wrappedObject.eSet(wrappedValueFeature, parsePrimitive(wrappedValueFeature.getEType(), text));
								if (wrappedValueFeature.getEType() == EcorePackage.eINSTANCE.getEFloat()) {
									EStructuralFeature floatStringFeature = eClass.getEStructuralFeature("wrappedValueAsString");
									wrappedObject.eSet(floatStringFeature, text);
								}
								List list = (List) object.eGet(eStructuralFeature);
								if (eStructuralFeature.isMany()) {
									list.add(wrappedObject);
								} else {
									object.eSet(eStructuralFeature, wrappedObject);
								}
							}
						} else {
							if (eStructuralFeature.isMany()) {
								String[] split = text.split(" ");
								List list = (List) object.eGet(eStructuralFeature);
								for (String s : split) {
									list.add(parsePrimitive(realType, s));
								}
							} else {
								object.eSet(eStructuralFeature, parsePrimitive(realType, text));
							}
						}
					}
				}
			}
		}
	}

	private void addToWaitingList(IdEObject object, EStructuralFeature eStructuralFeature, Long refId, int pos) {
		if (!waitingObjects.containsKey(refId)) {
			waitingObjects.put(refId, new ArrayList<WaitingObject>());
		}
		waitingObjects.get(refId).add(new WaitingObject(object, eStructuralFeature, pos));
	}

	private Object parsePrimitive(EClassifier eType, String text) throws IfcXmlDeserializeException {
		if (eType == EcorePackage.eINSTANCE.getEString()) {
			return text;
		} else if (eType == EcorePackage.eINSTANCE.getEInt()) {
			return Integer.parseInt(text);
		} else if (eType == EcorePackage.eINSTANCE.getEFloat()) {
			return Float.parseFloat(text);
		} else if (eType == EcorePackage.eINSTANCE.getEBoolean()) {
			return Boolean.parseBoolean(text);
		} else if (eType instanceof EEnum) {
			return ((EEnum) eType).getEEnumLiteral(text);
		} else {
			throw new IfcXmlDeserializeException("Unimplemented primitive type: " + eType.getName());
		}
	}
}