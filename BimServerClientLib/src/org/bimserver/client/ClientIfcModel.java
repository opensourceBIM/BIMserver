package org.bimserver.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.ifc.IfcModel;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcGloballyUniqueId;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.shared.ListWaitingObject;
import org.bimserver.shared.SingleWaitingObject;
import org.bimserver.shared.WaitingList;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
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

import com.google.gson.stream.JsonReader;

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

	public ClientIfcModel(BimServerClient bimServerClient, long poid, long roid, boolean deep) throws ServerException, UserException, BimServerClientException {
		super();
		this.bimServerClient = bimServerClient;
		this.roid = roid;
		try {
			tid = bimServerClient.getServiceInterface().startTransaction(poid);
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		}
		if (deep) {
			loadDeep();
		}
	}

	public BimServerClient getBimServerClient() {
		return bimServerClient;
	}

	public long commit(String comment) throws ServerException, UserException {
		return bimServerClient.getServiceInterface().commitTransaction(tid, comment);
	}

	public long getIfcSerializerOid() throws ServerException, UserException {
		if (ifcSerializerOid == -1) {
			SSerializerPluginConfiguration serializerPluginConfiguration = bimServerClient.getServiceInterface().getSerializerByPluginClassName(
					"org.bimserver.serializers.JsonSerializerPlugin");
			if (serializerPluginConfiguration != null) {
				ifcSerializerOid = serializerPluginConfiguration.getOid();
			}
		}
		return ifcSerializerOid;
	}

	private void loadDeep() throws ServerException, UserException, BimServerClientException {
		modelState = ModelState.LOADING;
		Long download = bimServerClient.getServiceInterface().download(roid, getIfcSerializerOid(), true, true);
		processDownload(download);
		modelState = ModelState.FULLY_LOADED;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void processDownload(Long download) throws BimServerClientException, UserException, ServerException {
		WaitingList<Long> waitingList = new WaitingList<Long>();
		try {
			InputStream downloadData = bimServerClient.getDownloadData(download, getIfcSerializerOid());
			JsonReader jsonReader = new JsonReader(new InputStreamReader(downloadData));
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
								IdEObject object = (IdEObject) Ifc2x3tc1Factory.eINSTANCE.create(eClass);
								((IdEObjectImpl) object).setDelegate(new ClientDelegate(this, object, null));
								((IdEObjectImpl) object).setOid(oid);
								add(object.getOid(), object);
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
												object.eSet(asStringFeature, "" + x); // TODO this is losing precision, maybe also send the string value?
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
									try {
										waitingList.updateNode(oid, eClass, object);
									} catch (DeserializeException e) {
										LOGGER.error("", e);
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
		} finally {
			bimServerClient.getServiceInterface().cleanupLongAction(download);
		}
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

	@Override
	public <T extends EObject> List<T> getAll(EClass eClass) {
		if (modelState == ModelState.NONE) {
			try {
				loadDeep();
			} catch (ServerException e) {
				e.printStackTrace();
			} catch (UserException e) {
				e.printStackTrace();
			} catch (BimServerClientException e) {
				e.printStackTrace();
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
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (BimServerClientException e) {
			e.printStackTrace();
		}
		return super.size();
	}

	@Override
	public Set<Long> keySet() {
		try {
			loadDeep();
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (BimServerClientException e) {
			e.printStackTrace();
		}
		return super.keySet();
	}

	@Override
	public IdEObject get(long oid) {
		IdEObject idEObject = super.get(oid);
		if (idEObject == null) {
			try {
				modelState = ModelState.LOADING;
				Long downloadByOids = bimServerClient.getServiceInterface().downloadByOids(Collections.singleton(roid), Collections.singleton(oid), getIfcSerializerOid(), true,
						false);
				processDownload(downloadByOids);
				modelState = ModelState.NONE;
				return super.get(oid);
			} catch (ServerException e) {
				e.printStackTrace();
			} catch (UserException e) {
				e.printStackTrace();
			} catch (BimServerClientException e) {
				e.printStackTrace();
			}
		}
		return idEObject;
	}

	@Override
	public Collection<IdEObject> getValues() {
		try {
			loadDeep();
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (BimServerClientException e) {
			e.printStackTrace();
		}
		return super.getValues();
	}

	@Override
	public <T extends EObject> List<T> getAllWithSubTypes(EClass eClass) {
		if (!loadedClasses.contains(eClass.getName()) && modelState != ModelState.FULLY_LOADED) {
			try {
				modelState = ModelState.LOADING;
				Long downloadByTypes = bimServerClient.getServiceInterface().downloadByTypes(Collections.singleton(roid), Collections.singleton(eClass.getName()),
						getIfcSerializerOid(), true, false, false, true);
				processDownload(downloadByTypes);
				loadedClasses.add(eClass.getName());
				modelState = ModelState.NONE;
			} catch (ServerException e) {
				e.printStackTrace();
			} catch (UserException e) {
				e.printStackTrace();
			} catch (BimServerClientException e) {
				e.printStackTrace();
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

	@Override
	public boolean containsGuid(String guid) {
		getByGuid(guid);
		return super.containsGuid(guid);
	}

	@Override
	public int count(EClass eClass) {
		getAllWithSubTypes(eClass);
		return super.count(eClass);
	}

	@Override
	public IfcRoot getByGuid(String guid) {
		IfcRoot idEObject = super.getByGuid(guid);
		if (idEObject == null) {
			try {
				modelState = ModelState.LOADING;
				Long downloadByGuids = bimServerClient.getServiceInterface()
						.downloadByGuids(Collections.singleton(roid), Collections.singleton(guid), getIfcSerializerOid(), false);
				processDownload(downloadByGuids);
				modelState = ModelState.NONE;
				return super.getByGuid(guid);
			} catch (ServerException e) {
				e.printStackTrace();
			} catch (UserException e) {
				e.printStackTrace();
			} catch (BimServerClientException e) {
				e.printStackTrace();
			}
		}
		return idEObject;
	}

	@Override
	public void remove(IdEObject idEObject) {
		// TODO
		super.remove(idEObject);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IdEObject> T create(EClass eClass) throws IfcModelInterfaceException {
		IdEObjectImpl object = (IdEObjectImpl) eClass.getEPackage().getEFactoryInstance().create(eClass);
		object.setDelegate(new ClientDelegate(this, object, null));
		try {
			Long oid = bimServerClient.getServiceInterface().createObject(tid, eClass.getName());
			object.setOid(oid);
			add(oid, object);
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		}
		return (T) object;
	}
}