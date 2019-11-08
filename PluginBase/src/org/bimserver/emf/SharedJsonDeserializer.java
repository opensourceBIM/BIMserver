package org.bimserver.emf;

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

import java.io.BufferedReader;

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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.bimserver.emf.IdEObjectImpl.State;
import org.bimserver.models.geometry.GeometryFactory;
import org.bimserver.models.geometry.Vector3f;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcGloballyUniqueId;
import org.bimserver.models.store.IfcHeader;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StorePackage;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.DeserializerErrorCode;
import org.bimserver.shared.ListWaitingObject;
import org.bimserver.shared.WaitingList;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.eclipse.emf.common.util.AbstractEList;
import org.eclipse.emf.common.util.EList;
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

import nl.tue.buildingsmart.schema.Attribute;
import nl.tue.buildingsmart.schema.EntityDefinition;
import nl.tue.buildingsmart.schema.InverseAttribute;

public class SharedJsonDeserializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(SharedJsonDeserializer.class);
	private boolean skipInverses;

	public SharedJsonDeserializer(boolean skipInverses) {
		this.skipInverses = skipInverses;
	}

	@SuppressWarnings("rawtypes")
	public IfcModelInterface read(InputStream in, IfcModelInterface model, boolean checkWaitingList) throws DeserializeException {
		if (model.getPackageMetaData().getSchemaDefinition() == null) {
			throw new DeserializeException(DeserializerErrorCode.INTERNAL_BIMSERVER_ERROR, "No SchemaDefinition available");
		}
		WaitingList<Long> waitingList = new WaitingList<Long>();
		final boolean log = false;
		if (log) {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try {
				IOUtils.copy(in, baos);
				File file = new File("debug.json");
				System.out.println(file.getAbsolutePath());
				FileUtils.writeByteArrayToFile(file, baos.toByteArray());
			} catch (IOException e) {
				e.printStackTrace();
			}
			in = new ByteArrayInputStream(baos.toByteArray());
		}
		JsonReader jsonReader = new JsonReader(new BufferedReader(new InputStreamReader(in, Charsets.UTF_8)));
		int nrObjects = 0;
		try {
			JsonToken peek = jsonReader.peek();
			if (peek != null && peek == JsonToken.BEGIN_OBJECT) {
				jsonReader.beginObject();
				peek = jsonReader.peek();
				while (peek == JsonToken.NAME) {
					String nextName = jsonReader.nextName();
					if (nextName.equals("objects")) {
						jsonReader.beginArray();
						while (jsonReader.hasNext()) {
							nrObjects++;
							processObject(model, waitingList, jsonReader, null);
						}
						jsonReader.endArray();
					} else if (nextName.equals("header")) {
						IfcHeader ifcHeader = (IfcHeader) processObject(model, waitingList, jsonReader, StorePackage.eINSTANCE.getIfcHeader());
						model.getModelMetaData().setIfcHeader(ifcHeader);
					}
					peek = jsonReader.peek();
				}
				jsonReader.endObject();
			}
		} catch (IOException e) {
			LOGGER.error("", e);
		} catch (IfcModelInterfaceException e) {
			LOGGER.error("", e);
		} finally {
			LOGGER.debug("# Objects: " + nrObjects);
			try {
				jsonReader.close();
			} catch (IOException e) {
				LOGGER.error("", e);
			}
		}
		boolean checkUnique = false;
		if (checkUnique) {
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
//									LOGGER.error("NOT UNIQUE " + idEObject.eClass().getName() + "." + eStructuralFeature.getName());
									}
									t.add(v);
								}
							}
						}
					}
				}
			}
		}
		if (checkWaitingList && waitingList.size() > 0) {
			try {
				waitingList.dumpIfNotEmpty();
			} catch (BimServerClientException e) {
				e.printStackTrace();
			}
			throw new DeserializeException(DeserializerErrorCode.NON_EXISTING_ENTITY_REFERENCED, "Waitinglist should be empty (" + waitingList.size() + ")");
		}
		return model;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private IdEObject processObject(IfcModelInterface model, WaitingList<Long> waitingList, JsonReader jsonReader, EClass eClass) throws IOException, DeserializeException, IfcModelInterfaceException {
		IdEObjectImpl object = null;
		jsonReader.beginObject();
		if (jsonReader.nextName().equals("_i")) {
			long oid = jsonReader.nextLong();
			if (jsonReader.nextName().equals("_u")) {
				UUID uuid = UUID.fromString(jsonReader.nextString());
				if (jsonReader.nextName().equals("_r")) {
					int rid = jsonReader.nextInt();
					if (jsonReader.nextName().equals("_t")) {
						String type = jsonReader.nextString();
						if (eClass == null) {
							eClass = model.getPackageMetaData().getEClassIncludingDependencies(type);
						}
						if (eClass == null) {
							throw new DeserializeException(DeserializerErrorCode.UNKNOWN_ENTITY, "No class found with name " + type);
						}
						if (model.containsNoFetch(oid)) {
							object = (IdEObjectImpl) model.getNoFetch(oid);
						} else {
							if (eClass == StorePackage.eINSTANCE.getIfcHeader()) {
								object = (IdEObjectImpl) StoreFactory.eINSTANCE.createIfcHeader();
							} else {
								object = (IdEObjectImpl) model.create(eClass, oid);
							}
						}
						
						object.useInverses(false);
						((IdEObjectImpl)object).setUuid(uuid);
						((IdEObjectImpl)object).setRid(rid);
		
						if (jsonReader.nextName().equals("_s")) {
							int state = jsonReader.nextInt();
							if (state == 1) {
								object.setLoadingState(State.LOADING);
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
										throw new DeserializeException(DeserializerErrorCode.UNKNOWN_FIELD, "Unknown field (" + featureName + ") on class " + eClass.getName());
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
													JsonToken peek = jsonReader.peek();
													if (peek == JsonToken.NUMBER) {
														long refOid = jsonReader.nextLong();
														processRef(model, waitingList, object, eStructuralFeature, index, list, refOid);
													} else if(eStructuralFeature.getEAnnotation("twodimensionalarray")!=null) {
														IdEObjectImpl listObject = model.create(((EReference) eStructuralFeature).getEReferenceType());
														addToList(eStructuralFeature, index, list, listObject);
														EStructuralFeature listFeature = listObject.eClass().getEStructuralFeature("List");
														jsonReader.beginArray();
														AbstractEList innerList = (AbstractEList) listObject.eGet(listFeature);
														if (listFeature instanceof EAttribute){
															while (jsonReader.hasNext()) {
																innerList.add(readPrimitive(jsonReader, listFeature));
															}
														} else {
															while (jsonReader.hasNext()){
																jsonReader.beginObject();
																String nextName = jsonReader.nextName();
																if (nextName.equals("_t")){
																	String t = jsonReader.nextString();
																	IdEObject wrappedObject = model.create(model.getPackageMetaData().getEClass(t), -1);
																	EList<EStructuralFeature> eAllStructuralFeatures = wrappedObject.eClass().getEAllStructuralFeatures();
																	for (EStructuralFeature eStructuralFeature2 : eAllStructuralFeatures) {
																		if (jsonReader.nextName().contentEquals(eStructuralFeature2.getName())) {
																			wrappedObject.eSet(eStructuralFeature2, readPrimitive(jsonReader, eStructuralFeature2));
																		} else {
																			// trouble
																		}
																	}
																	innerList.add(wrappedObject);
																} else if (nextName.equals("_r")) {
																	// Reference
																	long referenceOid = jsonReader.nextLong();
																	if (jsonReader.nextName().equals("_t")) {
																		String refType = jsonReader.nextString();
																		IdEObject refObject = (IdEObject) model.create(model.getPackageMetaData().getEClassIncludingDependencies(refType), referenceOid);
																		((IdEObjectImpl)refObject).setLoadingState(State.OPPOSITE_SETTING);
																		model.add(refObject.getOid(), refObject);
																		addToList(listFeature, index, innerList, refObject);
																		((IdEObjectImpl)refObject).setLoadingState(State.TO_BE_LOADED);
																	}
																}
																jsonReader.endObject();
															}
														}
														jsonReader.endArray();
													} else {
														jsonReader.beginObject();
														String nextName = jsonReader.nextName();
														if (nextName.equals("_t")) {
															String t = jsonReader.nextString();
															if (jsonReader.nextName().equals("_v")) {
																if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
																	// Embedded array
																	jsonReader.beginArray();
																	
																	// Here we are, IfcLineIndex should implement IfcSegmentIndexSelect, just as IfcArcIndex should
																	
																	IdEObjectImpl listObject = model.create(model.getPackageMetaData().getEClassIncludingDependencies(t));
//																	addToList(eStructuralFeature, index, list, listObject);
																	EStructuralFeature listFeature = listObject.eClass().getEStructuralFeature("wrappedValue");
																	AbstractEList innerList = (AbstractEList) listObject.eGet(listFeature);
																	while (jsonReader.hasNext()){
																		innerList.add(readPrimitive(jsonReader, listFeature));
																	}
																	jsonReader.endArray();
																	list.add(listObject);
																} else {
																	IdEObject wrappedObject = (IdEObject) model.create(model.getPackageMetaData().getEClass(t), -1);
																	EStructuralFeature wv = wrappedObject.eClass().getEStructuralFeature("wrappedValue");
																	wrappedObject.eSet(wv, readPrimitive(jsonReader, wv));
																	list.add(wrappedObject);
																}
															} else {
																throw new DeserializeException(DeserializerErrorCode.UNEXPECTED_FIELD, "Expected _v");
															}
														} else if (nextName.equals("_i")) {
															// Not all are embedded...
															long refOid = jsonReader.nextLong();
															if (jsonReader.nextName().equals("_t")) {
																String refType = jsonReader.nextString();
																IdEObject refObject = (IdEObject) model.create(model.getPackageMetaData().getEClassIncludingDependencies(refType), refOid);
																((IdEObjectImpl)refObject).setLoadingState(State.OPPOSITE_SETTING);
																model.add(refObject.getOid(), refObject);
																addToList(eStructuralFeature, index, list, refObject);
																((IdEObjectImpl)refObject).setLoadingState(State.TO_BE_LOADED);
															} else {
																processRef(model, waitingList, object, eStructuralFeature, index, list, refOid);
															}
														}
														jsonReader.endObject();
													}
												} else {
													jsonReader.beginObject();
													if (jsonReader.nextName().equals("_i")) {
														long refOid = jsonReader.nextLong();
														if (jsonReader.nextName().equals("_t")) {
															String refType = jsonReader.nextString();
															EClass referenceEClass = model.getPackageMetaData().getEClassIncludingDependencies(refType);
		
															if (model.getNoFetch(refOid) != null) {
																processRef(model, waitingList, object, eStructuralFeature, index, list, refOid);
															} else {
																IdEObject refObject = (IdEObject) model.create(referenceEClass, refOid);
																((IdEObjectImpl)refObject).setLoadingState(State.OPPOSITE_SETTING);
																model.add(refObject.getOid(), refObject);
																addToList(eStructuralFeature, index, list, refObject);
																((IdEObjectImpl)refObject).setLoadingState(State.TO_BE_LOADED);
															}
														}
													}
													jsonReader.endObject();
												}
												index++;
											}
										}
										jsonReader.endArray();
									} else {
										if (eStructuralFeature instanceof EAttribute) {
											Object x = readPrimitive(jsonReader, eStructuralFeature);
											if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEDouble()) {
												EStructuralFeature asStringFeature = object.eClass().getEStructuralFeature(eStructuralFeature.getName() + "AsString");
												if (asStringFeature != null) {
													object.eSet(asStringFeature, "" + x); // TODO
												}
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
													IdEObject wrappedObject = (IdEObject) model.create(model.getPackageMetaData().getEClassIncludingDependencies(t), -1);
													((IdEObjectImpl)wrappedObject).setLoadingState(State.LOADING);
													if (eStructuralFeature.getEAnnotation("dbembed") != null) {
														for (EStructuralFeature eStructuralFeature2 : wrappedObject.eClass().getEAllStructuralFeatures()) {
															String fn = jsonReader.nextName();
															if (fn.equals(eStructuralFeature2.getName())) {
																wrappedObject.eSet(eStructuralFeature2, readPrimitive(jsonReader, eStructuralFeature2));
															} else {
																throw new DeserializeException(DeserializerErrorCode.UNEXPECTED_FIELD, fn + " / " + eStructuralFeature2.getName());
															}
														}
														object.eSet(eStructuralFeature, wrappedObject);
													} else {
														if (jsonReader.nextName().equals("_v")) {
															EStructuralFeature wv = wrappedObject.eClass().getEStructuralFeature("wrappedValue");
															wrappedObject.eSet(wv, readPrimitive(jsonReader, wv));
															object.eSet(eStructuralFeature, wrappedObject);
														}
													}
													((IdEObjectImpl)wrappedObject).setLoadingState(State.LOADED);
												}
												jsonReader.endObject();
											} else {
												jsonReader.beginObject();
												if (jsonReader.nextName().equals("_i")) {
													long refOid = jsonReader.nextLong();
													if (jsonReader.nextName().equals("_t")) {
														String refType = jsonReader.nextString();
														boolean isInverse = false;
														EntityDefinition entityBN = model.getPackageMetaData().getSchemaDefinition().getEntityBN(object.eClass().getName());
														if (entityBN != null) {
															// Some entities like GeometryInfo/Data are not in IFC schema, but valid
															Attribute attributeBN = entityBN.getAttributeBNWithSuper(eStructuralFeature.getName());
															if (attributeBN != null) {
																if (attributeBN instanceof InverseAttribute) {
																	isInverse = true;
																}
															}
														}
		//												if (!isInverse) {
															if (model.getNoFetch(refOid) != null) {
																object.eSet(eStructuralFeature, model.getNoFetch(refOid));
															} else {
																IdEObject refObject = (IdEObject) model.create(model.getPackageMetaData().getEClassIncludingDependencies(refType), refOid);
																((IdEObjectImpl)refObject).setLoadingState(State.OPPOSITE_SETTING);
																model.add(refObject.getOid(), refObject);
																object.eSet(eStructuralFeature, refObject);
																((IdEObjectImpl)refObject).setLoadingState(State.TO_BE_LOADED);
															}
		//												}
													}
												}
												jsonReader.endObject();
											}
										}
									}
								}
								object.useInverses(true);
								object.setLoadingState(State.LOADED);
							} else {
								// state not_loaded
								object.setLoadingState(State.TO_BE_LOADED);
							}
							if (waitingList.containsKey(oid)) {
								waitingList.updateNode(oid, eClass, object);
							}
							model.add(object.getOid(), object);
						} else {
							LOGGER.info("_s expected");
						}
					} else {
						LOGGER.info("_t expected");
					}
				} else {
					LOGGER.info("_r expected");
				}
			} else {
				LOGGER.info("_u expected");
			}
		} else {
			LOGGER.info("_i expected");
		}
		jsonReader.endObject();
		return object;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void processRef(IfcModelInterface model, WaitingList<Long> waitingList, IdEObjectImpl object,
			EStructuralFeature eStructuralFeature, int index, AbstractEList list, long refOid)
					throws DeserializeException {
		EntityDefinition entityBN = model.getPackageMetaData().getSchemaDefinition().getEntityBN(object.eClass().getName());
		Attribute attributeBN = entityBN.getAttributeBNWithSuper(eStructuralFeature.getName());
		if (skipInverses && attributeBN instanceof InverseAttribute && ((EReference)eStructuralFeature).getEOpposite() != null) {
			// skip
		} else {
			if (model.contains(refOid)) {
				EObject referencedObject = model.get(refOid);
				if (referencedObject != null) {
					addToList(eStructuralFeature, index, list, referencedObject);
				}
			} else {
				waitingList.add(refOid, new ListWaitingObject(-1, object, (EReference) eStructuralFeature, index));
			}
		}
	}

	private void addToList(EStructuralFeature eStructuralFeature, int index, AbstractEList list, EObject referencedObject) throws DeserializeException {
		EClass referenceEClass = referencedObject.eClass();
		if (((EClass) eStructuralFeature.getEType()).isSuperTypeOf(referenceEClass)) {
			while (list.size() <= index) {
				list.addUnique(referencedObject);
			}
		} else {
			throw new DeserializeException(DeserializerErrorCode.REFERENCED_OBJECT_CANNOT_BE_STORED_IN_THIS_FIELD, -1, referenceEClass.getName() + " cannot be stored in " + eStructuralFeature.getName());
		}
	}

	private Object readPrimitive(JsonReader jsonReader, EStructuralFeature eStructuralFeature) throws IOException, DeserializeException {
		EClassifier eClassifier = eStructuralFeature.getEType();
		if (eClassifier == EcorePackage.eINSTANCE.getEString()) {
			return jsonReader.nextString();
		} else if (eClassifier == EcorePackage.eINSTANCE.getEDouble()) {
			return jsonReader.nextDouble();
		} else if (eClassifier == EcorePackage.eINSTANCE.getEBoolean()) {
			return jsonReader.nextBoolean();
		} else if (eClassifier == EcorePackage.eINSTANCE.getEInt()) {
			return jsonReader.nextInt();
		} else if (eClassifier == EcorePackage.eINSTANCE.getEShort()) {
			return (short)jsonReader.nextInt();
		} else if (eClassifier == EcorePackage.eINSTANCE.getELong()) {
			return jsonReader.nextLong();
		} else if (eClassifier == EcorePackage.eINSTANCE.getEIntegerObject()) {
			return jsonReader.nextInt();
		} else if (eClassifier == EcorePackage.eINSTANCE.getEByteArray()) {
			return Base64.decodeBase64(jsonReader.nextString());
		} else if (eClassifier == EcorePackage.eINSTANCE.getEDate()) {
			long timestamp = jsonReader.nextLong();
			return new Date(timestamp);
		} else if (eClassifier == EcorePackage.eINSTANCE.getEFloat()) {
			return (float)jsonReader.nextDouble();
		} else if (eClassifier == EcorePackage.eINSTANCE.getEEnum()) {
			EEnum eEnum = (EEnum) eStructuralFeature.getEType();
			return eEnum.getEEnumLiteral(jsonReader.nextString()).getInstance();
		} else if (eClassifier instanceof EClass) {
			if (eStructuralFeature.getEType().getName().equals("IfcGloballyUniqueId")) {
				IfcGloballyUniqueId ifcGloballyUniqueId = Ifc2x3tc1Factory.eINSTANCE.createIfcGloballyUniqueId();
				ifcGloballyUniqueId.setWrappedValue(jsonReader.nextString());
				return ifcGloballyUniqueId;
			} else if (eStructuralFeature.getEType().getName().equals("Vector3f")) {
				jsonReader.beginObject();
				Vector3f vector3f = GeometryFactory.eINSTANCE.createVector3f();
				jsonReader.nextName();
				jsonReader.nextString();
				jsonReader.nextName();
				vector3f.setX(jsonReader.nextDouble());
				jsonReader.nextName();
				vector3f.setY(jsonReader.nextDouble());
				jsonReader.nextName();
				vector3f.setZ(jsonReader.nextDouble());
				jsonReader.endObject();
				return vector3f;
			} else {
				throw new DeserializeException(DeserializerErrorCode.UNIMPLEMENTED_BIMSERVER_FEATURE, eStructuralFeature.getEType().getName() + " not implemented");
			}
		} else if (eClassifier instanceof EEnum) {
			EEnum eEnum = (EEnum) eStructuralFeature.getEType();
			if (jsonReader.peek() == JsonToken.BOOLEAN) {
				return eEnum.getEEnumLiteral(jsonReader.nextBoolean() ? "TRUE" : "FALSE").getInstance();
			} else {
				return eEnum.getEEnumLiteral(jsonReader.nextString()).getInstance();
			}
		} else {
			throw new DeserializeException(DeserializerErrorCode.UNIMPLEMENTED_BIMSERVER_FEATURE, "Unimplemented type " + eStructuralFeature.getEType().getName());
		}
	}
}