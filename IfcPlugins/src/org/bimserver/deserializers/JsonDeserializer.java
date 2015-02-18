package org.bimserver.deserializers;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.ifc.IfcModel;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcGloballyUniqueId;
import org.bimserver.plugins.deserializers.ByteProgressReporter;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.EmfDeserializer;
import org.bimserver.plugins.schema.Attribute;
import org.bimserver.plugins.schema.EntityDefinition;
import org.bimserver.plugins.schema.InverseAttribute;
import org.bimserver.shared.ListWaitingObject;
import org.bimserver.shared.SingleWaitingObject;
import org.bimserver.shared.WaitingList;
import org.eclipse.emf.common.util.AbstractEList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

public class JsonDeserializer extends EmfDeserializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonDeserializer.class);

	@SuppressWarnings("rawtypes")
	@Override
	public IfcModelInterface read(InputStream in, String filename, long fileSize, ByteProgressReporter progressReporter) throws DeserializeException {
		IfcModelInterface model = new IfcModel(getPackageMetaData(), null);
		WaitingList<Long> waitingList = new WaitingList<Long>();
		JsonReader jsonReader = new JsonReader(new InputStreamReader(in, Charsets.UTF_8));
		try {
			jsonReader.beginObject();
			if (jsonReader.nextName().equals("objects")) {
				jsonReader.beginArray();
				while (jsonReader.hasNext()) {
					processObject(model, waitingList, jsonReader);
				}
				jsonReader.endArray();
			}
			jsonReader.endObject();
		} catch (IOException e) {
			LOGGER.error("", e);
		} catch (IfcModelInterfaceException e) {
			LOGGER.error("", e);
		} finally {
			try {
				jsonReader.close();
			} catch (IOException e) {
				LOGGER.error("", e);
			}
		}
		for (IdEObject idEObject : model.getValues()) {
			for (EStructuralFeature eStructuralFeature : idEObject.eClass().getEAllStructuralFeatures()) {
				Object value = idEObject.eGet(eStructuralFeature);
				if (eStructuralFeature instanceof EReference) {
					if (eStructuralFeature.isMany()) {
						List list = (List)value;
						if (eStructuralFeature.isUnique()) {
							Set<Object> t = new HashSet<>();
							for (Object v : list) {
								if (t.contains(v)) {
									LOGGER.error("NOT UNIQUE " + idEObject.eClass().getName() + "." + eStructuralFeature.getName());
								}
								t.add(v);
							}
						}
					}
				}
			}
		}
		if (waitingList.size() > 0) {
			throw new DeserializeException("Waitinglist should be empty (" + waitingList.size() + ")");
		}
		return model;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void processObject(IfcModelInterface model, WaitingList<Long> waitingList, JsonReader jsonReader) throws IOException, DeserializeException,
			IfcModelInterfaceException {
		jsonReader.beginObject();
		if (jsonReader.nextName().equals("_i")) {
			long oid = jsonReader.nextLong();
			if (jsonReader.nextName().equals("_t")) {
				String type = jsonReader.nextString();
				EClass eClass = getPackageMetaData().getEClass(type);
				if (eClass == null) {
					throw new DeserializeException("No class found with name " + type);
				}
				IdEObject object = (IdEObject) getPackageMetaData().create(eClass);
//				((IdEObjectImpl)object).setOid(oid);
				model.add(oid, object);
				if (jsonReader.nextName().equals("_s")) {
					int state = jsonReader.nextInt();
					if (state == 1) {
						while (jsonReader.hasNext()) {
							String featureName = jsonReader.nextName();
							boolean embedded = false;
							if (featureName.startsWith("_r")) {
								featureName = featureName.substring(2);
							} else if (featureName.startsWith("_e")) {
								embedded = true;
								featureName = featureName.substring(2);
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
									AbstractEList list = (AbstractEList) object.eGet(eStructuralFeature);
									while (jsonReader.hasNext()) {
										if (embedded) {
											jsonReader.beginObject();
											if (jsonReader.nextName().equals("_t")) {
												String t = jsonReader.nextString();
												IdEObject wrappedObject = (IdEObject) getPackageMetaData().create(getPackageMetaData().getEClass(t));
												model.add(-1, wrappedObject);
												if (jsonReader.nextName().equals("_v")) {
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
											EntityDefinition entityBN = getPackageMetaData().getSchemaDefinition().getEntityBN(object.eClass().getName());
											Attribute attributeBN = entityBN.getAttributeBNWithSuper(eStructuralFeature.getName());
											if (!(attributeBN instanceof InverseAttribute)) {
												if (model.contains(refOid)) {
													EObject referencedObject = model.get(refOid);
													if (referencedObject != null) {
														EClass referenceEClass = referencedObject.eClass();
														if (((EClass) eStructuralFeature.getEType()).isSuperTypeOf(referenceEClass)) {
															while (list.size() <= index) {
																list.addUnique(referencedObject);
															}
														} else {
															throw new DeserializeException(-1, referenceEClass.getName() + " cannot be stored in " + eStructuralFeature.getName());
														}
													}
												} else {
													waitingList.add(refOid, new ListWaitingObject(-1, object, eStructuralFeature, index));
												}
											}
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
										if (jsonReader.nextName().equals("_t")) {
											String t = jsonReader.nextString();
											IdEObject wrappedObject = (IdEObject) getPackageMetaData().create(getPackageMetaData().getEClass(t));
											model.add(-1, wrappedObject);
											if (jsonReader.nextName().equals("_v")) {
												EStructuralFeature wv = wrappedObject.eClass().getEStructuralFeature("wrappedValue");
												wrappedObject.eSet(wv, readPrimitive(jsonReader, wv));
												object.eSet(eStructuralFeature, wrappedObject);
											} else {
												// error
											}
										}
										jsonReader.endObject();
									} else {
										long refOid = jsonReader.nextLong();
										EntityDefinition entityBN = getPackageMetaData().getSchemaDefinition().getEntityBN(object.eClass().getName());
										Attribute attributeBN = entityBN.getAttributeBNWithSuper(eStructuralFeature.getName());
										if (!(attributeBN instanceof InverseAttribute)) {
											if (model.contains(refOid)) {
												object.eSet(eStructuralFeature, model.get(refOid));
											} else {
												waitingList.add(refOid, new SingleWaitingObject(-1, object, eStructuralFeature));
											}
										}
									}
								}
							}
						}
					} else {
						LOGGER.info("State != 1");
					}
					if (waitingList.containsKey(oid)) {
						waitingList.updateNode(oid, eClass, object);
					}
				} else {
					LOGGER.info("_s expected");
				}
			} else {
				LOGGER.info("_t expected");
			}
		} else {
			LOGGER.info("_i expected");
		}
		jsonReader.endObject();
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
			if (jsonReader.peek() == JsonToken.BOOLEAN) {
				return eEnum.getEEnumLiteral(jsonReader.nextBoolean() ? "TRUE" : "FALSE").getInstance();
			} else {
				return eEnum.getEEnumLiteral(jsonReader.nextString()).getInstance();
			}
		} else {
			throw new RuntimeException("Unimplemented type " + eStructuralFeature.getEType().getName());
		}
	}
}