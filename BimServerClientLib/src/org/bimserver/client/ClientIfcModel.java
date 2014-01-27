package org.bimserver.client;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.IdEObjectImpl.State;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.ifc.IfcModel;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerInputstream;
import org.bimserver.plugins.services.BimServerClientException;
import org.bimserver.shared.ListWaitingObject;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.SingleWaitingObject;
import org.bimserver.shared.WaitingList;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.common.util.AbstractEList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.sun.org.apache.bcel.internal.classfile.LineNumber;

public class ClientIfcModel extends IfcModel {
	public static enum ModelState {
		NONE, LOADING, FULLY_LOADED
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientIfcModel.class);
	private BimServerClient bimServerClient;
	private ModelState modelState = ModelState.NONE;
	private long tid = -1;
	private long roid;
	private final Set<String> loadedClasses = new HashSet<String>();
	private long ifcSerializerOid = -1;
	private long jsonGeometrySerializerOid = -1;
	private ClientEStore eStore;

	public ClientIfcModel(BimServerClient bimServerClient, long poid, long roid, boolean deep) throws ServerException, UserException, BimServerClientException, PublicInterfaceNotFoundException {
		super();
		this.eStore = new ClientEStore(this);
		this.bimServerClient = bimServerClient;
		this.roid = roid;
		try {
			tid = bimServerClient.getBimsie1LowLevelInterface().startTransaction(poid);
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		if (deep) {
			loadDeep();
		}
	}

	private ClientIfcModel(BimServerClient bimServerClient, long poid) {
		this.bimServerClient = bimServerClient;
		try {
			tid = bimServerClient.getBimsie1LowLevelInterface().startTransaction(poid);
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ClientIfcModel branch(long poid) {
		// TODO this should of course be done server side, without any copying
		ClientIfcModel branch = new ClientIfcModel(bimServerClient, poid);
		try {
			loadDeep();
		} catch (ServerException e) {
			LOGGER.error("", e);
		} catch (UserException e) {
			LOGGER.error("", e);
		} catch (BimServerClientException e) {
			LOGGER.error("", e);
		} catch (PublicInterfaceNotFoundException e) {
			LOGGER.error("", e);
		}
		Map<IdEObject, IdEObject> map = new HashMap<IdEObject, IdEObject>();
		for (IdEObject sourceObject : getObjects().values()) {
			try {
				IdEObject targetObject = create(sourceObject.eClass());
				map.put(sourceObject, targetObject);
			} catch (IfcModelInterfaceException e) {
				LOGGER.error("", e);
			}
		}
		for (IdEObject sourceObject : getObjects().values()) {
			IdEObject targetObject = map.get(sourceObject);
			for (EStructuralFeature eStructuralFeature : sourceObject.eClass().getEAllStructuralFeatures()) {
				Object sourceValue = sourceObject.eGet(eStructuralFeature);
				if (eStructuralFeature instanceof EReference) {
					if (eStructuralFeature.isMany()) {
						List sourceList = (List)sourceValue;
						List targetList = (List)targetObject.eGet(eStructuralFeature);
						for (Object sourceItem : sourceList) {
							targetList.add(map.get(sourceItem));
						}
					} else {
						targetObject.eSet(eStructuralFeature, map.get(sourceValue));
					}
				} else {
					if (eStructuralFeature.isMany()) {
						List sourceList = (List)sourceValue;
						List targetList = (List)targetObject.eGet(eStructuralFeature);
						for (Object sourceItem : sourceList) {
							targetList.add(sourceItem);
						}
					} else {
						targetObject.eSet(eStructuralFeature, sourceValue);
					}
				}
			}
		}
		branch.setModelState(ModelState.FULLY_LOADED);
		return branch;
	}
	
	private void setModelState(ModelState modelState) {
		this.modelState = modelState;
	}

	public BimServerClient getBimServerClient() {
		return bimServerClient;
	}

	public long commit(String comment) throws ServerException, UserException, PublicInterfaceNotFoundException {
		return bimServerClient.getBimsie1LowLevelInterface().commitTransaction(tid, comment);
	}

	public long getIfcSerializerOid() throws ServerException, UserException, PublicInterfaceNotFoundException {
		if (ifcSerializerOid == -1) {
			SSerializerPluginConfiguration serializerPluginConfiguration = bimServerClient.getPluginInterface().getSerializerByPluginClassName(
					"org.bimserver.serializers.JsonSerializerPlugin");
			if (serializerPluginConfiguration != null) {
				ifcSerializerOid = serializerPluginConfiguration.getOid();
			}
		}
		return ifcSerializerOid;
	}

	public long getJsonGeometrySerializerOid() throws ServerException, UserException, PublicInterfaceNotFoundException {
		if (jsonGeometrySerializerOid == -1) {
			SSerializerPluginConfiguration serializerPluginConfiguration = bimServerClient.getPluginInterface().getSerializerByPluginClassName(
					"org.bimserver.geometry.json.JsonGeometrySerializerPlugin");
			if (serializerPluginConfiguration != null) {
				jsonGeometrySerializerOid = serializerPluginConfiguration.getOid();
			}
		}
		return jsonGeometrySerializerOid;
	}
	
	private void loadDeep() throws ServerException, UserException, BimServerClientException, PublicInterfaceNotFoundException {
		if (modelState != ModelState.FULLY_LOADED) {
			modelState = ModelState.LOADING;
			Long download = bimServerClient.getBimsie1ServiceInterface().download(roid, getIfcSerializerOid(), true, true);
			processDownload(download);
			modelState = ModelState.FULLY_LOADED;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void processDownload(Long download) throws BimServerClientException, UserException, ServerException, PublicInterfaceNotFoundException {
		WaitingList<Long> waitingList = new WaitingList<Long>();
		try {
			InputStream downloadData = bimServerClient.getDownloadData(download, getIfcSerializerOid());
			boolean log = false;
			// TODO Make this streaming again, make sure the EmfSerializer getInputStream method is working properly
			if (log) {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				if (downloadData instanceof SerializerInputstream) {
					SerializerInputstream serializerInputStream = (SerializerInputstream)downloadData;
					serializerInputStream.getEmfSerializer().writeToOutputStream(baos);
				} else {
					IOUtils.copy((InputStream) downloadData, baos);
				}
				FileOutputStream fos = new FileOutputStream(new File(download + ".json"));
				IOUtils.write(baos.toByteArray(), fos);
				fos.close();
				downloadData = new ByteArrayInputStream(baos.toByteArray());
			} else {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				if (downloadData instanceof SerializerInputstream) {
					SerializerInputstream serializerInputStream = (SerializerInputstream)downloadData;
					serializerInputStream.getEmfSerializer().writeToOutputStream(baos);
				} else {
					IOUtils.copy((InputStream) downloadData, baos);
				}
				downloadData = new ByteArrayInputStream(baos.toByteArray());
			}
			JsonReader jsonReader = new JsonReader(new InputStreamReader(downloadData, Charsets.UTF_8));
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
									throw new BimServerClientException("No class found with name " + type);
								}
								if (jsonReader.nextName().equals("__state")) {
									String state = jsonReader.nextString();
									IdEObject object = null;
									if (containsNoFetch(oid)) {
										object = getNoFetch(oid);
									} else {
										object = (IdEObject) Ifc2x3tc1Factory.eINSTANCE.create(eClass);
										((IdEObjectImpl) object).eSetStore(eStore);
										((IdEObjectImpl) object).setOid(oid);
										add(oid, object);
									}
									if (state.equals("NOT_LOADED")) {
										((IdEObjectImpl) object).setLoadingState(State.TO_BE_LOADED);
									} else {
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
												throw new BimServerClientException("Unknown field (" + featureName + ") on class " + eClass.getName());
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
															stringList.add("" + val); // TODO this is losing precision, maybe also send the string value?
														}
													}
												} else if (eStructuralFeature instanceof EReference) {
													int index = 0;
													while (jsonReader.hasNext()) {
														if (embedded) {
															List list = (List)object.eGet(eStructuralFeature);
															jsonReader.beginObject();
															String n = jsonReader.nextName();
															if (n.equals("__type")) {
																String t = jsonReader.nextString();
																IdEObject wrappedObject = (IdEObject) Ifc2x3tc1Factory.eINSTANCE.create((EClass) Ifc2x3tc1Package.eINSTANCE.getEClassifier(t));
																if (jsonReader.nextName().equals("value")) {
																	EStructuralFeature wv = wrappedObject.eClass().getEStructuralFeature("wrappedValue");
																	wrappedObject.eSet(wv, readPrimitive(jsonReader, wv));
																	list.add(wrappedObject);
																} else {
																	// error
																}
															} else if (n.equals("oid")) {
																// Sometimes embedded is true, bot also referenced are included, those are always embdedded in an object
																long refOid = jsonReader.nextLong();
																if (containsNoFetch(refOid)) {
																	IdEObject refObj = getNoFetch(refOid);
																	AbstractEList l = (AbstractEList)object.eGet(eStructuralFeature);
																	while (l.size() <= index) {
																		l.addUnique(refObj.eClass().getEPackage().getEFactoryInstance().create(refObj.eClass()));
																	}
																	l.setUnique(index, refObj);
																} else {
																	waitingList.add(refOid, new ListWaitingObject(-1, object, eStructuralFeature, index));
																}
															}
															jsonReader.endObject();
														} else {
															long refOid = jsonReader.nextLong();
															if (containsNoFetch(refOid)) {
																IdEObject refObj = getNoFetch(refOid);
																AbstractEList l = (AbstractEList)object.eGet(eStructuralFeature);
																while (l.size() <= index) {
																	l.addUnique(refObj.eClass().getEPackage().getEFactoryInstance().create(refObj.eClass()));
																}
																l.setUnique(index, refObj);
															} else {
																waitingList.add(refOid, new ListWaitingObject(-1, object, eStructuralFeature, index));
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
														object.eSet(asStringFeature, "" + x); // TODO this is losing precision, maybe also send the string value?
													}
													object.eSet(eStructuralFeature, x);
												} else if (eStructuralFeature instanceof EReference) {
													if (embedded) {
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
														long refOid = jsonReader.nextLong();
														if (containsNoFetch(refOid)) {
															IdEObject refObj = getNoFetch(refOid);
															object.eSet(eStructuralFeature, refObj);
														} else {
															waitingList.add(refOid, new SingleWaitingObject(-1, object, eStructuralFeature));
														}
													}
												}
											}
										}
									}
									if (waitingList.containsKey(oid)) {
										try {
											waitingList.updateNode(oid, eClass, object);
										} catch (DeserializeException e) {
											LOGGER.error("", e);
										}
									}
								}
							}
						}
						jsonReader.endObject();
					}
					jsonReader.endArray();
				}
				jsonReader.endObject();
			} catch (IfcModelInterfaceException e1) {
				LOGGER.error("", e1);
			} finally {
				jsonReader.close();
			}
		} catch (IOException e) {
			LOGGER.error("", e);
		} catch (SerializerException e) {
			LOGGER.error("", e);
		} finally {
			waitingList.dumpIfNotEmpty();
			bimServerClient.getServiceInterface().cleanupLongAction(download);
		}
	}

	private Object readPrimitive(JsonReader jsonReader, EStructuralFeature eStructuralFeature) throws IOException {
		EClassifier eClassifier = eStructuralFeature.getEType();
		if (eClassifier == EcorePackage.eINSTANCE.getEString()) {
			return jsonReader.nextString();
		} else if (eClassifier == EcorePackage.eINSTANCE.getEDouble() || eClassifier == EcorePackage.eINSTANCE.getEDoubleObject()) {
			return jsonReader.nextDouble();
		} else if (eClassifier == EcorePackage.eINSTANCE.getEFloat() || eClassifier == EcorePackage.eINSTANCE.getEFloatObject()) {
			return (float)jsonReader.nextDouble();
		} else if (eClassifier == EcorePackage.eINSTANCE.getEBoolean() || eClassifier == EcorePackage.eINSTANCE.getEBooleanObject()) {
			return jsonReader.nextBoolean();
		} else if (eClassifier == EcorePackage.eINSTANCE.getEInt() || eClassifier == EcorePackage.eINSTANCE.getEIntegerObject()) {
			return jsonReader.nextInt();
		} else if (eClassifier == EcorePackage.eINSTANCE.getEEnum()) {
			// TODO DOES THIS EVER HAPPEN??
			if (jsonReader.peek() == JsonToken.BOOLEAN) {
				EEnum eEnum = (EEnum) eStructuralFeature.getEType();
				return eEnum.getEEnumLiteral(("" + jsonReader.nextBoolean()).toUpperCase()).getInstance();
			} else {
				EEnum eEnum = (EEnum) eStructuralFeature.getEType();
				return eEnum.getEEnumLiteral(jsonReader.nextString()).getInstance();
			}
		} else if (eClassifier instanceof EClass) {
			throw new RuntimeException();
		} else if (eClassifier == EcorePackage.eINSTANCE.getEByteArray()) {
			return Base64.decodeBase64(jsonReader.nextString().getBytes(Charsets.UTF_8));
		} else if (eClassifier instanceof EEnum) {
			if (jsonReader.peek() == JsonToken.BOOLEAN) {
				EEnum eEnum = (EEnum) eStructuralFeature.getEType();
				return eEnum.getEEnumLiteral(("" + jsonReader.nextBoolean()).toUpperCase()).getInstance();
			} else {
				EEnum eEnum = (EEnum) eStructuralFeature.getEType();
				return eEnum.getEEnumLiteral(jsonReader.nextString()).getInstance();
			}
		} else {
			throw new RuntimeException("Unimplemented type " + eStructuralFeature.getEType().getName());
		}
	}

	@Override
	public <T extends IdEObject> List<T> getAll(EClass eClass) {
		if (!loadedClasses.contains(eClass.getName()) && modelState != ModelState.FULLY_LOADED) {
			LOGGER.info("Loading all " + eClass.getName());
			try {
				modelState = ModelState.LOADING;
				Long downloadByTypes = bimServerClient.getBimsie1ServiceInterface().downloadByTypes(Collections.singleton(roid), Collections.singleton(eClass.getName()),
						getIfcSerializerOid(), false, false, false, true);
				processDownload(downloadByTypes);
				loadedClasses.add(eClass.getName());
				rebuildIndexPerClass(eClass);
				modelState = ModelState.NONE;
			} catch (Exception e) {
				LOGGER.error("", e);
			}
		}
		return super.getAll(eClass);
	}

	@Override
	public Set<String> getGuids(EClass eClass) {
		getAllWithSubTypes(eClass);
		return super.getGuids(eClass);
	}

	@Override
	public Set<String> getNames(EClass eClass) {
		getAllWithSubTypes(eClass);
		return super.getNames(eClass);
	}

	@Override
	public IdEObject getByName(EClass eClass, String name) {
		// TODO
		return super.getByName(eClass, name);
	}

	@Override
	public long size() {
		try {
			loadDeep();
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		return super.size();
	}

	@Override
	public Set<Long> keySet() {
		try {
			loadDeep();
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		return super.keySet();
	}

	@Override
	public IdEObject get(long oid) {
		IdEObject idEObject = super.get(oid);
		if (idEObject == null) {
			loadExplicit(oid);
			return super.get(oid);
		}
		return idEObject;
	}

	public void loadExplicit(long oid) {
		try {
			IdEObjectImpl idEObjectImpl = (IdEObjectImpl) super.get(oid);
			if (!idEObjectImpl.isLoadedOrLoading()) {
				LOGGER.info("Loading " + oid);
				modelState = ModelState.LOADING;
				Long downloadByOids = bimServerClient.getBimsie1ServiceInterface().downloadByOids(Collections.singleton(roid), Collections.singleton(oid), getIfcSerializerOid(), true,
						false);
				processDownload(downloadByOids);
				modelState = ModelState.NONE;
			}
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}

	public IdEObject getNoFetch(long oid) {
		return super.get(oid);
	}
	
	@Override
	public Collection<IdEObject> getValues() {
		try {
			loadDeep();
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		return super.getValues();
	}

	@Override
	public <T extends IdEObject> List<T> getAllWithSubTypes(EClass eClass) {
		if (!loadedClasses.contains(eClass.getName()) && modelState != ModelState.FULLY_LOADED) {
			try {
				modelState = ModelState.LOADING;
				Long downloadByTypes = bimServerClient.getBimsie1ServiceInterface().downloadByTypes(Collections.singleton(roid), Collections.singleton(eClass.getName()),
						getIfcSerializerOid(), true, false, false, true);
				processDownload(downloadByTypes);
				for (EClass subClass : bimServerClient.getMetaDataManager().getAllSubClasses(eClass)) {
					loadedClasses.add(subClass.getName());
					rebuildIndexPerClass(eClass);
				}
				loadedClasses.add(eClass.getName());
				modelState = ModelState.NONE;
			} catch (Exception e) {
				LOGGER.error("", e);
			}
		}
		return super.getAllWithSubTypes(eClass);
	}

	public Long getTransactionId() {
		return tid;
	}

	public ModelState getModelState() {
		return modelState;
	}

	@Override
	public boolean contains(long oid) {
		get(oid);
		return super.contains(oid);
	}

	public boolean containsNoFetch(long oid) {
		return super.contains(oid);
	}
	
	@Override
	public boolean containsGuid(String guid) {
		getByGuid(guid);
		return super.containsGuid(guid);
	}

	@Override
	public int count(EClass eClass) {
		return super.count(eClass);
	}

	@Override
	public IfcRoot getByGuid(String guid) {
		IfcRoot idEObject = super.getByGuid(guid);
		if (idEObject == null) {
			try {
				modelState = ModelState.LOADING;
				Long downloadByGuids = bimServerClient.getBimsie1ServiceInterface()
						.downloadByGuids(Collections.singleton(roid), Collections.singleton(guid), getIfcSerializerOid(), false, false);
				processDownload(downloadByGuids);
				modelState = ModelState.NONE;
				return super.getByGuid(guid);
			} catch (Exception e) {
				LOGGER.error("", e);
			}
		}
		return idEObject;
	}

	@Override
	public void remove(IdEObject idEObject) {
		// TODO
		super.remove(idEObject);
	}

	public <T extends IdEObject> T create(Class<T> clazz) throws IfcModelInterfaceException {
		return create((EClass)Ifc2x3tc1Package.eINSTANCE.getEClassifier(clazz.getSimpleName()));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends IdEObject> T create(EClass eClass) throws IfcModelInterfaceException {
		IdEObjectImpl object = (IdEObjectImpl) eClass.getEPackage().getEFactoryInstance().create(eClass);
		object.eSetStore(eStore);
		try {
			Long oid = bimServerClient.getBimsie1LowLevelInterface().createObject(tid, eClass.getName());
			object.setOid(oid);
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		return (T) object;
	}

	@SuppressWarnings({ "unused", "resource" })
	public void getGeometry(IfcProduct ifcProduct) {
		try {
			Long downloadByOids = bimServerClient.getBimsie1ServiceInterface().downloadByOids(Collections.singleton(roid), Collections.singleton(ifcProduct.getOid()), getJsonGeometrySerializerOid(), true, false);
			InputStream downloadData = bimServerClient.getDownloadData(downloadByOids, getJsonGeometrySerializerOid());
			JsonReader jsonReader = new JsonReader(new InputStreamReader(downloadData));
			jsonReader.beginObject();
			if (jsonReader.nextName().equals("geometry")) {
				jsonReader.beginArray();
				while (jsonReader.hasNext()) {
					jsonReader.beginObject();
					if (jsonReader.nextName().equals("material")) {
						String material = jsonReader.nextString();
						if (jsonReader.nextName().equals("type")) {
							String type = jsonReader.nextString();
							if (jsonReader.nextName().equals("coreId")) {
								String coreid = jsonReader.nextString();
								if (jsonReader.nextName().equals("primitive")) {
									String primitive = jsonReader.nextString();
									if (jsonReader.nextName().equals("positions")) {
										jsonReader.beginArray();
										while (jsonReader.hasNext()) {
											double position = jsonReader.nextDouble();
										}
										jsonReader.endArray();
										if (jsonReader.nextName().equals("normals")) {
											jsonReader.beginArray();
											while (jsonReader.hasNext()) {
												double normal = jsonReader.nextDouble();
											}
											jsonReader.endArray();
											if (jsonReader.nextName().equals("nrindices")) {
												int nrindices = jsonReader.nextInt();
											}
										}
									}
								}
							}
						}
					}
					jsonReader.endObject();
				}
				jsonReader.endArray();
			}
			jsonReader.endObject();
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}
}