package org.bimserver.deserializers;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.ifc.IfcModel;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcGloballyUniqueId;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.EmfDeserializer;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.shared.ListWaitingObject;
import org.bimserver.shared.SingleWaitingObject;
import org.bimserver.shared.WaitingList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.stream.JsonReader;

public class JsonDeserializer extends EmfDeserializer {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonDeserializer.class);
	
	@Override
	public void init(SchemaDefinition schema) {
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public IfcModelInterface read(InputStream in, String filename, long fileSize) throws DeserializeException {
		IfcModelInterface model = new IfcModel();
		WaitingList<Long> waitingList = new WaitingList<Long>();
		JsonReader jsonReader = new JsonReader(new InputStreamReader(in));
		try {
			jsonReader.beginObject();
			if (jsonReader.nextName().equals("objects")) {
				jsonReader.beginArray();
				while (jsonReader.hasNext()) {
					jsonReader.beginObject();
					if (jsonReader.nextName().equals("__oid")) {
						long oid = jsonReader.nextLong();
						if (jsonReader.nextName().equals("__type")) {
							String type = jsonReader.nextString();
							EClass eClass = (EClass) Ifc2x3tc1Package.eINSTANCE.getEClassifier(type);
							if (eClass == null) {
								throw new DeserializeException("No class found with name " + type);
							}
							IdEObject object = (IdEObject) Ifc2x3tc1Factory.eINSTANCE.create(eClass);
							// ((IdEObjectImpl) object).setDelegate(new
							// ClientDelegate(this, object, null));
							((IdEObjectImpl) object).setOid(oid);
							model.add(object.getOid(), object);
							while (jsonReader.hasNext()) {
								String featureName = jsonReader.nextName();
								boolean embedded = false;
								if (featureName.startsWith("__ref")) {
									featureName = featureName.substring(5);
								} else if (featureName.startsWith("__emb")) {
									embedded = true;
									featureName = featureName.substring(5);
								}
								EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(featureName);
								if (eStructuralFeature == null) {
									throw new DeserializeException("Unknown field (" + featureName + ") on class " + eClass.getName());
								}
								if (eStructuralFeature.isMany()) {
									jsonReader.beginArray();
									if (eStructuralFeature instanceof EAttribute) {
										List list = (List) object.eGet(eStructuralFeature);
										List<String> stringList = null;

										if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEDoubleObject()
												|| eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEDouble()) {
											EStructuralFeature asStringFeature = eClass.getEStructuralFeature(eStructuralFeature.getName() + "AsString");
											stringList = (List<String>) object.eGet(asStringFeature);
										}

										while (jsonReader.hasNext()) {
											Object e = readPrimitive(jsonReader, eStructuralFeature);
											list.add(e);
											if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEDouble()) {
												double val = (Double) e;
												stringList.add("" + val); // TODO
																			// this
																			// is
																			// losing
																			// precision,
																			// maybe
																			// also
																			// send
																			// the
																			// string
																			// value?
											}
										}
									} else if (eStructuralFeature instanceof EReference) {
										int index = 0;
										while (jsonReader.hasNext()) {
											if (embedded) {
												List list = (List) object.eGet(eStructuralFeature);
												jsonReader.beginObject();
												if (jsonReader.nextName().equals("__type")) {
													String t = jsonReader.nextString();
													IdEObject wrappedObject = (IdEObject) Ifc2x3tc1Factory.eINSTANCE.create((EClass) Ifc2x3tc1Package.eINSTANCE.getEClassifier(t));
													if (jsonReader.nextName().equals("value")) {
														EStructuralFeature wv = wrappedObject.eClass().getEStructuralFeature("wrappedValue");
														wrappedObject.eSet(wv, readPrimitive(jsonReader, wv));
														list.add(wrappedObject);
													} else {
														// error
													}
												}
												jsonReader.endObject();
											} else {
												long refOid = jsonReader.nextLong();
												waitingList.add(refOid, new ListWaitingObject(object, eStructuralFeature, index));
												index++;
											}
										}
									}
									jsonReader.endArray();
								} else {
									if (eStructuralFeature instanceof EAttribute) {
										Object x = readPrimitive(jsonReader, eStructuralFeature);
										if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEDouble()) {
											EStructuralFeature asStringFeature = object.eClass().getEStructuralFeature(eStructuralFeature.getName() + "AsString");
											object.eSet(asStringFeature, "" + x); // TODO
																					// this
																					// is
																					// losing
																					// precision,
																					// maybe
																					// also
																					// send
																					// the
																					// string
																					// value?
										}
										object.eSet(eStructuralFeature, x);
									} else if (eStructuralFeature instanceof EReference) {
										if (eStructuralFeature.getName().equals("GlobalId")) {
											IfcGloballyUniqueId globallyUniqueId = Ifc2x3tc1Factory.eINSTANCE.createIfcGloballyUniqueId();
											globallyUniqueId.setWrappedValue(jsonReader.nextString());
											object.eSet(eStructuralFeature, globallyUniqueId);
										} else if (embedded) {
											jsonReader.beginObject();
											if (jsonReader.nextName().equals("__type")) {
												String t = jsonReader.nextString();
												IdEObject wrappedObject = (IdEObject) Ifc2x3tc1Factory.eINSTANCE.create((EClass) Ifc2x3tc1Package.eINSTANCE.getEClassifier(t));
												if (jsonReader.nextName().equals("value")) {
													EStructuralFeature wv = wrappedObject.eClass().getEStructuralFeature("wrappedValue");
													wrappedObject.eSet(wv, readPrimitive(jsonReader, wv));
													object.eSet(eStructuralFeature, wrappedObject);
												} else {
													// error
												}
											}
											jsonReader.endObject();
										} else {
											waitingList.add(jsonReader.nextLong(), new SingleWaitingObject(object, eStructuralFeature));
										}
									}
								}
							}
							if (waitingList.containsKey(oid)) {
								waitingList.updateNode(oid, eClass, object);
							}
						}
					}
					jsonReader.endObject();
				}
				jsonReader.endArray();
			}
			jsonReader.endObject();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (IfcModelInterfaceException e1) {
			e1.printStackTrace();
		} finally {
			try {
				jsonReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return model;
	}

	private Object readPrimitive(JsonReader jsonReader, EStructuralFeature eStructuralFeature) throws IOException {
		EClassifier eClassifier = eStructuralFeature.getEType();
		if (eClassifier == EcorePackage.eINSTANCE.getEString()) {
			return jsonReader.nextString();
		} else if (eClassifier == EcorePackage.eINSTANCE.getEDouble()) {
			return jsonReader.nextDouble();
		} else if (eClassifier == EcorePackage.eINSTANCE.getEBoolean()) {
			return jsonReader.nextBoolean();
		} else if (eClassifier == EcorePackage.eINSTANCE.getEInt()) {
			return jsonReader.nextInt();
		} else if (eClassifier == EcorePackage.eINSTANCE.getEEnum()) {
			EEnum eEnum = (EEnum) eStructuralFeature.getEType();
			return eEnum.getEEnumLiteral(jsonReader.nextString()).getInstance();
		} else if (eClassifier instanceof EClass) {
			if (eStructuralFeature.getEType().getName().equals("IfcGloballyUniqueId")) {
				IfcGloballyUniqueId ifcGloballyUniqueId = Ifc2x3tc1Factory.eINSTANCE.createIfcGloballyUniqueId();
				ifcGloballyUniqueId.setWrappedValue(jsonReader.nextString());
				return ifcGloballyUniqueId;
			} else {
				throw new RuntimeException();
			}
		} else if (eClassifier instanceof EEnum) {
			EEnum eEnum = (EEnum) eStructuralFeature.getEType();
			return eEnum.getEEnumLiteral(jsonReader.nextString()).getInstance();
		} else {
			throw new RuntimeException("Unimplemented type " + eStructuralFeature.getEType().getName());
		}
	}
}