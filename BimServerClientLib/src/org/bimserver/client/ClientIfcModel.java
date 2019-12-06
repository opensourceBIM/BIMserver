package org.bimserver.client;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.database.queries.om.Include;
import org.bimserver.database.queries.om.Include.TypeDef;
import org.bimserver.database.queries.om.JsonQueryObjectModelConverter;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.IdEObjectImpl.State;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.ModelMetaData;
import org.bimserver.emf.OidProvider;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.SharedJsonDeserializer;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelChangeListener;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.models.geometry.GeometryInfo;
import org.bimserver.models.geometry.GeometryPackage;
import org.bimserver.plugins.HeaderTakingSerializer;
import org.bimserver.plugins.ObjectAlreadyExistsException;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerInputstream;
import org.bimserver.shared.PluginClassLoaderProvider;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ClientIfcModel extends IfcModel implements GeometryTarget {
	public enum ModelState {
		NONE, LOADING, FULLY_LOADED
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientIfcModel.class);
	private BimServerClient bimServerClient;
	private ModelState modelState = ModelState.NONE;
	private long tid = -1;
	private long roid;
	private final Set<String> loadedClasses = new HashSet<String>();
	private int cachedObjectCount = -1;
	private boolean recordChanges;
	private boolean includeGeometry;
	private Set<Long> geometryTried = new HashSet<>();

	private ClientDebugInfo clientDebugInfo = new ClientDebugInfo();
	private boolean deep;

	public ClientIfcModel(BimServerClient bimServerClient, long poid, long roid, boolean deep, PackageMetaData packageMetaData, boolean recordChanges, boolean includeGeometry)
			throws ServerException, UserException, PublicInterfaceNotFoundException {
		super(packageMetaData, null);
		this.deep = deep;
		this.recordChanges = recordChanges;
		this.bimServerClient = bimServerClient;
		this.roid = roid;
		this.includeGeometry = includeGeometry;
		if (recordChanges) {
			try {
				tid = bimServerClient.getLowLevelInterface().startTransaction(poid);
			} catch (Exception e) {
				LOGGER.error("", e);
			}
		}
		if (deep) {
			try {
				loadDeep();
			} catch (QueryException e) {
				LOGGER.error("", e);
			}
		}
		pluginClassLoaderProvider = new PluginClassLoaderProvider() {
			@Override
			public ClassLoader getClassLoaderFor(String pluginName) {
				return ClientIfcModel.class.getClassLoader();
			}
		};
	}

	@Override
	public ModelMetaData getModelMetaData() {
		if (this.modelMetaData == null) {
			this.modelMetaData = new ModelMetaData();
			try {
				this.modelMetaData.setMinBounds(getBimServerClient().getServiceInterface().getModelMinBounds(roid));
				this.modelMetaData.setMaxBounds(getBimServerClient().getServiceInterface().getModelMaxBounds(roid));
			} catch (ServerException e1) {
				e1.printStackTrace();
			} catch (UserException e1) {
				e1.printStackTrace();
			} catch (PublicInterfaceNotFoundException e1) {
				e1.printStackTrace();
			}

			Query query = new Query(getPackageMetaData());

			JsonQueryObjectModelConverter converter = new JsonQueryObjectModelConverter(getPackageMetaData());
			try {
				long topicId = bimServerClient.getServiceInterface().download(Collections.singleton(roid), converter.toJson(query).toString(), bimServerClient.getJsonSerializerOid(), false);
				bimServerClient.waitForDonePreparing(topicId);
				processDownload(topicId);
				bimServerClient.getServiceInterface().cleanupLongAction(topicId);
			} catch (ServerException e) {
				e.printStackTrace();
			} catch (UserException e) {
				e.printStackTrace();
			} catch (PublicInterfaceNotFoundException e) {
				e.printStackTrace();
			} catch (IfcModelInterfaceException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return this.modelMetaData;
	}

	private ClientIfcModel(BimServerClient bimServerClient, PackageMetaData packageMetaData, long poid, boolean recordChanges) {
		super(packageMetaData, null);
		this.bimServerClient = bimServerClient;
		this.recordChanges = recordChanges;
		if (recordChanges) {
			try {
				tid = bimServerClient.getLowLevelInterface().startTransaction(poid);
			} catch (Exception e) {
				LOGGER.error("", e);
			}
		}
	}

	private EContentAdapter adapter = new EContentAdapter() {
		public void notifyChanged(Notification notification) {
			super.notifyChanged(notification);
			IdEObject idEObject = (IdEObject) notification.getNotifier();
			EStructuralFeature eFeature = (EStructuralFeature) notification.getFeature();
			if (notification.getEventType() == Notification.ADD) {
				if (getModelState() != ModelState.LOADING) {
					try {
						if (eFeature.getEType() == EcorePackage.eINSTANCE.getEString()) {
							bimServerClient.getLowLevelInterface().addStringAttribute(getTransactionId(), idEObject.getOid(), eFeature.getName(), notification.getNewStringValue());
						} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getELong() || eFeature.getEType() == EcorePackage.eINSTANCE.getELongObject()) {
							throw new UnsupportedOperationException();
						} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEDouble() || eFeature.getEType() == EcorePackage.eINSTANCE.getEDoubleObject()) {
							bimServerClient.getLowLevelInterface().addDoubleAttribute(getTransactionId(), idEObject.getOid(), eFeature.getName(), (Double) notification.getNewValue());
						} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEBoolean() || eFeature.getEType() == EcorePackage.eINSTANCE.getEBooleanObject()) {
							bimServerClient.getLowLevelInterface().addBooleanAttribute(getTransactionId(), idEObject.getOid(), eFeature.getName(), notification.getNewBooleanValue());
						} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEInt() || eFeature.getEType() == EcorePackage.eINSTANCE.getEIntegerObject()) {
							bimServerClient.getLowLevelInterface().addIntegerAttribute(getTransactionId(), idEObject.getOid(), eFeature.getName(), notification.getNewIntValue());
						} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEByteArray()) {
							throw new UnsupportedOperationException();
						} else if (eFeature.getEType() instanceof EEnum) {
							throw new UnsupportedOperationException();
						} else if (eFeature instanceof EReference) {
							if (notification.getNewValue() == null) {
							} else {
								bimServerClient.getLowLevelInterface().addReference(getTransactionId(), idEObject.getOid(), eFeature.getName(), ((IdEObject) notification.getNewValue()).getOid());
							}
						} else {
							throw new RuntimeException("Unimplemented " + eFeature.getEType().getName() + " " + notification.getNewValue());
						}
					} catch (ServiceException e) {
						LOGGER.error("", e);
					} catch (PublicInterfaceNotFoundException e) {
						LOGGER.error("", e);
					}
				}
			} else if (notification.getEventType() == Notification.REMOVE) {
				if (getModelState() != ModelState.LOADING) {
					try {
						if (eFeature instanceof EReference) {
							IdEObject oldValue = (IdEObject) notification.getOldValue();
							bimServerClient.getLowLevelInterface().removeReferenceByOid(getTransactionId(), idEObject.getOid(), eFeature.getName(), oldValue.getOid());
						} else {
							throw new RuntimeException("Unimplemented " + eFeature.getEType().getName() + " " + notification.getNewValue());
						}
					} catch (ServiceException e) {
						LOGGER.error("", e);
					} catch (PublicInterfaceNotFoundException e) {
						LOGGER.error("", e);
					}
				}
			}
		}
	};
	private boolean assumeCompletePreload;
	private PluginClassLoaderProvider pluginClassLoaderProvider;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ClientIfcModel branch(long poid, boolean recordChanges) {
		// TODO this should of course be done server side, without any copying
		ClientIfcModel branch = new ClientIfcModel(bimServerClient, getPackageMetaData(), poid, recordChanges);
		try {
			loadDeep();
		} catch (ServerException e) {
			LOGGER.error("", e);
		} catch (UserException e) {
			LOGGER.error("", e);
		} catch (PublicInterfaceNotFoundException e) {
			LOGGER.error("", e);
		} catch (QueryException e) {
			LOGGER.error("", e);
		}
		Map<IdEObject, IdEObject> map = new HashMap<IdEObject, IdEObject>();
		for (IdEObject sourceObject : getValues()) {
			try {
				IdEObjectImpl targetObject = branch.create(sourceObject.eClass());
				targetObject.setLoadingState(State.LOADED);
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
						List sourceList = (List) sourceValue;
						List targetList = (List) targetObject.eGet(eStructuralFeature);
						for (Object sourceItem : sourceList) {
							IdEObject e = map.get(sourceItem);
							if (e != null) {
								targetList.add(e);
							}
						}
					} else {
						targetObject.eSet(eStructuralFeature, map.get(sourceValue));
					}
				} else {
					if (eStructuralFeature.isMany()) {
						List sourceList = (List) sourceValue;
						List targetList = (List) targetObject.eGet(eStructuralFeature);
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
		if (tid == -1) {
			throw new UserException("No transaction was started");
		}
		return bimServerClient.getLowLevelInterface().commitTransaction(tid, comment, true);
	}

	private void loadDeep() throws ServerException, UserException, PublicInterfaceNotFoundException, QueryException {
		long start = System.nanoTime();
		if (modelState != ModelState.FULLY_LOADED && modelState != ModelState.LOADING) {
			modelState = ModelState.LOADING;
			Query query = new Query("test", getPackageMetaData());
			QueryPart queryPart = query.createQueryPart();
			queryPart.setIncludeAllFields(true);

			ObjectNode queryNode = new JsonQueryObjectModelConverter(query.getPackageMetaData()).toJson(query);
			Long topicId = bimServerClient.getServiceInterface().download(Collections.singleton(roid), queryNode.toString(), bimServerClient.getJsonSerializerOid(), false);
			bimServerClient.waitForDonePreparing(topicId);
			try {
				processDownload(topicId);
				bimServerClient.getServiceInterface().cleanupLongAction(topicId);
				buildIndex();
				loadGeometry();
				modelState = ModelState.FULLY_LOADED;
			} catch (IfcModelInterfaceException | IOException e) {
				LOGGER.error("", e);
			} catch (QueryException e) {
				LOGGER.error("", e);
			} catch (GeometryException e) {
				LOGGER.error("", e);
			}
		}
		long end = System.nanoTime();
//		LOGGER.info((((end - start) / 1000000) + " ms"));
	}

	public void loadGeometry() throws QueryException, ServerException, UserException, PublicInterfaceNotFoundException, IOException, GeometryException, IfcModelInterfaceException {
		if (includeGeometry) {
			if (modelState == ModelState.FULLY_LOADED) {
				return;
			}
			Query query = new Query("test", getPackageMetaData());
			ObjectNode settings = new ObjectMapper().createObjectNode();
			query.setGeometrySettings(settings);
			query.getGeometrySettings().put("useSmallInts", false);
			query.getGeometrySettings().put("splitGeometry", false);
			query.getGeometrySettings().put("quantizeColors", true);
			QueryPart queryPart = query.createQueryPart();

			EClass ifcProductClass = getPackageMetaData().getEClass("IfcProduct");
			EStructuralFeature geometryFeature = ifcProductClass.getEStructuralFeature("geometry");
			List<IdEObject> allWithSubTypes = new ArrayList<>(super.getAllWithSubTypes(ifcProductClass));
			for (IdEObject ifcProduct : allWithSubTypes) {
				GeometryInfo geometry = (GeometryInfo) ifcProduct.eGet(geometryFeature);
				if (geometry != null) {
					if (!geometryTried.contains(geometry.getOid())) {
						queryPart.addOid(geometry.getOid());
						geometryTried.add(geometry.getOid());
					}
				}
			}

			if (queryPart.getOids() == null) {
				return;
			}
			LOGGER.info("Loading geometry for " + queryPart.getOids().size() + " objects");
			EClass geometryInfoClass = getPackageMetaData().getEClassIncludingDependencies("GeometryInfo");
			Include include = queryPart.createInclude();
			include.addType(geometryInfoClass, false);
			include.addField("data");
			Include geometryData = include.createInclude();
			geometryData.addType(getPackageMetaData().getEClassIncludingDependencies("GeometryData"), false);
			geometryData.addFieldDirect("indices");
			geometryData.addFieldDirect("normals");
			geometryData.addFieldDirect("vertices");
			geometryData.addFieldDirect("colorsQuantized");

			long serializerOid = bimServerClient.getBinaryGeometryMessagingStreamingSerializerOid();

			long topicId = bimServerClient.query(query, roid, serializerOid);
			// TODO use websocket notifications
			bimServerClient.waitForDonePreparing(topicId);
			try (InputStream inputStream = bimServerClient.getDownloadData(topicId)) {
				clientDebugInfo.incrementGeometryGetDownloadData();
				try {
					processGeometryInputStream(inputStream);
				} catch (Throwable e) {
					e.printStackTrace();
				} finally {
					bimServerClient.getServiceInterface().cleanupLongAction(topicId);
				}
			}
		}
	}

	public ClientDebugInfo getClientDebugInfo() {
		return clientDebugInfo;
	}

	private void processGeometryInputStream(InputStream inputStream) throws IOException, GeometryException, IfcModelInterfaceException {
		new GeometryLoader(bimServerClient, getPackageMetaData(), this).load(inputStream);
	}

	private void processDownload(Long topicId) throws UserException, ServerException, PublicInterfaceNotFoundException, IfcModelInterfaceException, IOException {
		InputStream inputStream = bimServerClient.getDownloadData(topicId);
		if (inputStream == null) {
			throw new IfcModelInterfaceException("No InputStream to read from for topicId " + topicId);
		}
		InputStream downloadData = new org.bimserver.utils.CountingInputStream(inputStream) {
			public void close() throws IOException {
				ClientIfcModel.this.clientDebugInfo.incBytesOverTheLine(getCount());
				super.close();
			}
		};
		try {
			new SharedJsonDeserializer(false).read(downloadData, this, false);
		} catch (DeserializeException e) {
			throw new IfcModelInterfaceException(e);
		} catch (Exception e) {
			throw new IfcModelInterfaceException(e);
		} finally {
			if (downloadData != null) {
				downloadData.close();
			}
		}
	}

	@Override
	public <T extends IdEObject> List<T> getAll(EClass eClass) {
		if (!loadedClasses.contains(eClass.getName()) && modelState != ModelState.FULLY_LOADED && !assumeCompletePreload) {
			try {
				modelState = ModelState.LOADING;

				Query query = new Query(getPackageMetaData());
				QueryPart queryPart = query.createQueryPart();
				queryPart.addType(eClass, false);
				if (includeGeometry && getPackageMetaData().getEClass("IfcProduct").isSuperTypeOf(eClass)) {
					Include include = queryPart.createInclude();
					include.addType(eClass, false);
					include.addField("geometry");
					Include include2 = include.createInclude();
					include2.addType(new TypeDef(GeometryPackage.eINSTANCE.getGeometryInfo(), false));
					include2.addField("data");
				}

				JsonQueryObjectModelConverter converter = new JsonQueryObjectModelConverter(getPackageMetaData());
				long topicId = bimServerClient.getServiceInterface().download(Collections.singleton(roid), converter.toJson(query).toString(), bimServerClient.getJsonSerializerOid(), false);

				bimServerClient.waitForDonePreparing(topicId);

				clientDebugInfo.incrementGetAll();

				processDownload(topicId);
				bimServerClient.getServiceInterface().cleanupLongAction(topicId);

				loadedClasses.add(eClass.getName());
				rebuildIndexPerClass(eClass);
				modelState = ModelState.NONE;
				
				try {
					loadGeometry();
				} catch (ServerException e) {
					e.printStackTrace();
				} catch (UserException e) {
					e.printStackTrace();
				} catch (PublicInterfaceNotFoundException e) {
					e.printStackTrace();
				} catch (QueryException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (GeometryException e) {
					e.printStackTrace();
				} catch (IfcModelInterfaceException e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				LOGGER.error("", e);
			}
		}
		List<T> result = super.getAll(eClass);
		return result;
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
		if (cachedObjectCount == -1) {
			try {
				cachedObjectCount = bimServerClient.getLowLevelInterface().count(roid, "[ALL]");
			} catch (Exception e) {
				LOGGER.error("", e);
			}
		}
		return cachedObjectCount;
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
			if (idEObjectImpl != null && !idEObjectImpl.isLoadedOrLoading() && !assumeCompletePreload) {
				idEObjectImpl.setLoadingState(State.LOADING);
				modelState = ModelState.LOADING;

				Query query = new Query(getPackageMetaData());
				QueryPart queryPart = query.createQueryPart();
				queryPart.addOid(oid);

				JsonQueryObjectModelConverter converter = new JsonQueryObjectModelConverter(getPackageMetaData());

				long topicId = bimServerClient.getServiceInterface().download(Collections.singleton(roid), converter.toJson(query).toString(), bimServerClient.getJsonSerializerOid(), false);
				bimServerClient.waitForDonePreparing(topicId);
				clientDebugInfo.incExplicit();
				processDownload(topicId);
				bimServerClient.getServiceInterface().cleanupLongAction(topicId);
				idEObjectImpl.setLoadingState(State.LOADED);
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
		if (!loadedClasses.contains(eClass.getName()) && modelState != ModelState.FULLY_LOADED && !assumeCompletePreload) {
			try {
				modelState = ModelState.LOADING;

				Query query = new Query(getPackageMetaData());
				QueryPart queryPart = query.createQueryPart();
				queryPart.addType(eClass, true);

				if (includeGeometry && getPackageMetaData().getEClass("IfcProduct").isSuperTypeOf(eClass)) {
					Include include = queryPart.createInclude();
					include.addType(eClass, true);
					include.addField("geometry");
					Include include2 = include.createInclude();
					include2.addType(new TypeDef(GeometryPackage.eINSTANCE.getGeometryInfo(), false));
					include2.addField("data");
				}

				JsonQueryObjectModelConverter converter = new JsonQueryObjectModelConverter(getPackageMetaData());
				long topicId = bimServerClient.getServiceInterface().download(Collections.singleton(roid), converter.toJson(query).toString(), bimServerClient.getJsonSerializerOid(), false);

				bimServerClient.waitForDonePreparing(topicId);
				processDownload(topicId);
				clientDebugInfo.incrementGetAll();
				bimServerClient.getServiceInterface().cleanupLongAction(topicId);

				for (EClass subClass : bimServerClient.getMetaDataManager().getPackageMetaData(eClass.getEPackage().getName()).getAllSubClasses(eClass)) {
					loadedClasses.add(subClass.getName());
					rebuildIndexPerClass(eClass);
				}
				loadedClasses.add(eClass.getName());
				modelState = ModelState.NONE;
				loadGeometry();
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
		try {
			return bimServerClient.getLowLevelInterface().count(roid, eClass.getName());
		} catch (UserException e) {
			e.printStackTrace();
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		}
		return super.count(eClass);
	}

	@Override
	public IdEObject getByGuid(String guid) {
		IdEObject idEObject = super.getByGuid(guid);
		if (idEObject == null && !assumeCompletePreload) {
			try {
				modelState = ModelState.LOADING;

				Query query = new Query(getPackageMetaData());
				QueryPart queryPart = query.createQueryPart();
				queryPart.addGuid(guid);

				JsonQueryObjectModelConverter converter = new JsonQueryObjectModelConverter(getPackageMetaData());

				long topicId = bimServerClient.getServiceInterface().download(Collections.singleton(roid), converter.toJson(query).toString(), bimServerClient.getJsonSerializerOid(), false);

				bimServerClient.waitForDonePreparing(topicId);
				processDownload(topicId);
				clientDebugInfo.incGuid();
				bimServerClient.getServiceInterface().cleanupLongAction(topicId);

				modelState = ModelState.NONE;
				return super.getByGuid(guid);
			} catch (Exception e) {
				LOGGER.error("", e);
			}
		}
		return idEObject;
	}

	public <T extends IdEObject> T create(Class<T> clazz) throws IfcModelInterfaceException, ObjectAlreadyExistsException {
		EClassifier eClassifier = getPackageMetaData().getEPackage().getEClassifier(clazz.getSimpleName());
		if (eClassifier == null) {
			eClassifier = GeometryPackage.eINSTANCE.getEClassifier(clazz.getSimpleName());
		}
		if (eClassifier == null) {
			throw new IfcModelInterfaceException("EClass not found " + clazz);
		}
		return create((EClass) eClassifier);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IdEObject> T create(EClass eClass, long oid) throws IfcModelInterfaceException {
		IdEObjectImpl object = super.create(eClass, oid);
		if (recordChanges) {
			object.eAdapters().add(adapter);
		}
		return (T) object;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IdEObject> T create(EClass eClass) throws IfcModelInterfaceException, ObjectAlreadyExistsException {
		final IdEObjectImpl idEObject = (IdEObjectImpl) eClass.getEPackage().getEFactoryInstance().create(eClass);
		idEObject.setModel(this);

		if (recordChanges) {
			idEObject.eAdapters().add(adapter);
			try {
				Long oid = bimServerClient.getLowLevelInterface().createObject(tid, eClass.getName(), eClass.getEStructuralFeature("GlobalId") != null);
				idEObject.setOid(oid);
			} catch (Exception e) {
				LOGGER.error("", e);
			}
			add(idEObject.getOid(), idEObject);
		}
		return (T) idEObject;
	}

	@Override
	public void set(IdEObject idEObject, EStructuralFeature eFeature, Object newValue) {
		if (!recordChanges) {
			return;
		}
		if (!eFeature.isMany()) {
			if (getModelState() != ModelState.LOADING && ((IdEObjectImpl) idEObject).getLoadingState() != State.LOADING) {
				try {
					if (newValue != EStructuralFeature.Internal.DynamicValueHolder.NIL) {
						LowLevelInterface lowLevelInterface = getBimServerClient().getLowLevelInterface();
						if (eFeature.getName().equals("wrappedValue")) {
							// Wrapped objects get the same oid as their
							// "parent" object, so we know which object the
							// client wants to update. That's why we can use
							// idEObject.getOid() here
							// We are making this crazy hack ever crazier, let's
							// iterate over our parents features, and see if
							// there is one matching our wrapped type...
							// Seriously, when there are multiple fields of the
							// same type, this fails miserably, a real fix
							// should probably store the parent-oid + feature
							// name in the wrapped object (requires two extra,
							// volatile, fields),
							// or we just don't support this (just create a new
							// wrapped object too), we could even throw some
							// sort of exception. Hack morally okay because it's
							// client-side...
							EReference foundReference = null;
							if (contains(idEObject.getOid())) {
								IdEObject parentObject = get(idEObject.getOid());
								int found = 0;
								foundReference = null;
								for (EReference testReference : parentObject.eClass().getEAllReferences()) {
									if (((EClass) testReference.getEType()).isSuperTypeOf(idEObject.eClass())) {
										foundReference = testReference;
										found++;
										if (found > 1) {
											throw new RuntimeException(
													"Sorry, crazy hack could not resolve the right field, please let BIMserver developer know (debug info: " + parentObject.eClass().getName() + ", " + idEObject.eClass().getName() + ")");
										}
									}
								}
								if (eFeature.getEType() == EcorePackage.eINSTANCE.getEString()) {
									lowLevelInterface.setWrappedStringAttribute(getTransactionId(), idEObject.getOid(), foundReference.getName(), idEObject.eClass().getName(), (String) newValue);
								} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getELong() || eFeature.getEType() == EcorePackage.eINSTANCE.getELongObject()) {
									lowLevelInterface.setWrappedLongAttribute(getTransactionId(), idEObject.getOid(), foundReference.getName(), idEObject.eClass().getName(), (Long) newValue);
								} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEDouble() || eFeature.getEType() == EcorePackage.eINSTANCE.getEDoubleObject()) {
									lowLevelInterface.setWrappedDoubleAttribute(getTransactionId(), idEObject.getOid(), foundReference.getName(), idEObject.eClass().getName(), (Double) newValue);
								} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEBoolean() || eFeature.getEType() == EcorePackage.eINSTANCE.getEBooleanObject()) {
									lowLevelInterface.setWrappedBooleanAttribute(getTransactionId(), idEObject.getOid(), foundReference.getName(), idEObject.eClass().getName(), (Boolean) newValue);
								} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEInt() || eFeature.getEType() == EcorePackage.eINSTANCE.getEIntegerObject()) {
									lowLevelInterface.setWrappedIntegerAttribute(getTransactionId(), idEObject.getOid(), foundReference.getName(), idEObject.eClass().getName(), (Integer) newValue);
								} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEByteArray()) {
									throw new RuntimeException("Unimplemented " + eFeature.getEType().getName() + " " + newValue);
								}
							} else {
								if (eFeature.getEType() == EcorePackage.eINSTANCE.getEString()) {
									lowLevelInterface.setStringAttribute(getTransactionId(), idEObject.getOid(), eFeature.getName(), (String) newValue);
								} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getELong() || eFeature.getEType() == EcorePackage.eINSTANCE.getELongObject()) {
									lowLevelInterface.setLongAttribute(getTransactionId(), idEObject.getOid(), eFeature.getName(), (Long) newValue);
								} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEDouble() || eFeature.getEType() == EcorePackage.eINSTANCE.getEDoubleObject()) {
									lowLevelInterface.setDoubleAttribute(getTransactionId(), idEObject.getOid(), eFeature.getName(), (Double) newValue);
								} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEBoolean() || eFeature.getEType() == EcorePackage.eINSTANCE.getEBooleanObject()) {
									lowLevelInterface.setBooleanAttribute(getTransactionId(), idEObject.getOid(), eFeature.getName(), (Boolean) newValue);
								} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEInt() || eFeature.getEType() == EcorePackage.eINSTANCE.getEIntegerObject()) {
									lowLevelInterface.setIntegerAttribute(getTransactionId(), idEObject.getOid(), eFeature.getName(), (Integer) newValue);
								} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEByteArray()) {
									lowLevelInterface.setByteArrayAttribute(getTransactionId(), idEObject.getOid(), eFeature.getName(), (Byte[]) newValue);
								} else if (eFeature.getEType() instanceof EEnum) {
									lowLevelInterface.setEnumAttribute(getTransactionId(), idEObject.getOid(), eFeature.getName(), ((Enum<?>) newValue).toString());
								} else if (eFeature instanceof EReference) {
									if (newValue == null) {
										lowLevelInterface.setReference(getTransactionId(), idEObject.getOid(), eFeature.getName(), -1L);
									} else {
										lowLevelInterface.setReference(getTransactionId(), idEObject.getOid(), eFeature.getName(), ((IdEObject) newValue).getOid());
									}
								} else {
									throw new RuntimeException("Unimplemented " + eFeature.getEType().getName() + " " + newValue);
								}
							}
						} else {
							if (eFeature.getEType() == EcorePackage.eINSTANCE.getEString()) {
								lowLevelInterface.setStringAttribute(getTransactionId(), idEObject.getOid(), eFeature.getName(), (String) newValue);
							} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getELong() || eFeature.getEType() == EcorePackage.eINSTANCE.getELongObject()) {
								lowLevelInterface.setLongAttribute(getTransactionId(), idEObject.getOid(), eFeature.getName(), (Long) newValue);
							} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEDouble() || eFeature.getEType() == EcorePackage.eINSTANCE.getEDoubleObject()) {
								lowLevelInterface.setDoubleAttribute(getTransactionId(), idEObject.getOid(), eFeature.getName(), (Double) newValue);
							} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEBoolean() || eFeature.getEType() == EcorePackage.eINSTANCE.getEBooleanObject()) {
								lowLevelInterface.setBooleanAttribute(getTransactionId(), idEObject.getOid(), eFeature.getName(), (Boolean) newValue);
							} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEInt() || eFeature.getEType() == EcorePackage.eINSTANCE.getEIntegerObject()) {
								lowLevelInterface.setIntegerAttribute(getTransactionId(), idEObject.getOid(), eFeature.getName(), (Integer) newValue);
							} else if (eFeature.getEType() == EcorePackage.eINSTANCE.getEByteArray()) {
								if (newValue instanceof byte[]) {
									Byte[] n = new Byte[((byte[]) newValue).length];
									for (int i = 0; i < n.length; i++) {
										n[i] = ((byte[]) newValue)[i];
									}
									newValue = n;
								}
								lowLevelInterface.setByteArrayAttribute(getTransactionId(), idEObject.getOid(), eFeature.getName(), (Byte[]) newValue);
							} else if (eFeature.getEType() instanceof EEnum) {
								lowLevelInterface.setEnumAttribute(getTransactionId(), idEObject.getOid(), eFeature.getName(), ((Enum<?>) newValue).toString());
							} else if (eFeature instanceof EReference) {
								if (newValue == null) {
									lowLevelInterface.setReference(getTransactionId(), idEObject.getOid(), eFeature.getName(), -1L);
								} else {
									lowLevelInterface.setReference(getTransactionId(), idEObject.getOid(), eFeature.getName(), ((IdEObject) newValue).getOid());
								}
							} else {
								throw new RuntimeException("Unimplemented " + eFeature.getEType().getName() + " " + newValue);
							}
						}
					}
				} catch (ServiceException e) {
					LOGGER.error("", e);
				} catch (PublicInterfaceNotFoundException e) {
					LOGGER.error("", e);
				}
			}
		}
	}

	/**
	 * 
	 * This method requires IfcPlugins to be loaded (either on the default cp, or a a BIMserver plugin)
	 * 
	 */
	public void checkin(long poid, String comment) throws ServerException, UserException, PublicInterfaceNotFoundException {
		this.fixOids(new OidProvider() {
			private long c = 1;

			@Override
			public long newOid(EClass eClass) {
				return c++;
			}
		});
		try {
			Class<?> stepSerializerClass = getPluginClassLoaderProvider().getClassLoaderFor("org.bimserver.ifc.step.serializer.Ifc2x3tc1StepSerializerPlugin").loadClass("org.bimserver.ifc.step.serializer.IfcStepSerializer");
			Constructor<Serializer> constructor = (Constructor<Serializer>) stepSerializerClass.getConstructor(PluginConfiguration.class);
			Serializer ifcStepSerializer = (Serializer) constructor.newInstance(new PluginConfiguration());
			ProjectInfo projectInfo = new ProjectInfo();
			ifcStepSerializer.init(this, projectInfo, true);
			((HeaderTakingSerializer)ifcStepSerializer).setHeaderSchema(getPackageMetaData().getSchema().getHeaderName());
			SDeserializerPluginConfiguration deserializer = bimServerClient.getServiceInterface().getSuggestedDeserializerForExtension("ifc", poid);
			bimServerClient.checkinSync(poid, comment, deserializer.getOid(), false, -1, "test", new SerializerInputstream(ifcStepSerializer));
		} catch (SerializerException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public void load(IdEObject object) {
		if (((IdEObjectImpl) object).getLoadingState() == State.LOADING) {
			return;
		}
		loadExplicit(object.getOid());
	}

	@Override
	public void remove(IdEObject object) {
		try {
			bimServerClient.getLowLevelInterface().removeObject(getTransactionId(), object.getOid());
		} catch (PublicInterfaceNotFoundException e) {
			LOGGER.error("", e);
		} catch (ServerException e) {
			LOGGER.error("", e);
		} catch (UserException e) {
			LOGGER.error("", e);
		}
	}

	// @Override
	// public void query(ObjectNode query) {
	// try {
	// modelState = ModelState.LOADING;
	// Long downloadByTypes =
	// bimServerClient.getServiceInterface().downloadByJsonQuery(Collections.singleton(roid),
	// query.toString(), getJsonSerializerOid(), true);
	// processDownload(downloadByTypes);
	// modelState = ModelState.NONE;
	// } catch (Exception e) {
	// LOGGER.error("", e);
	// }
	// }

	@Override
	public void query(ObjectNode query, boolean assumeCompletePreload) throws ServerException, UserException, PublicInterfaceNotFoundException, IfcModelInterfaceException, IOException {
		this.assumeCompletePreload = assumeCompletePreload;
		modelState = ModelState.LOADING;
		Long topicId = bimServerClient.getServiceInterface().download(Collections.singleton(roid), query.toString(), bimServerClient.getJsonSerializerOid(), false);
		bimServerClient.waitForDonePreparing(topicId);

		processDownload(topicId);
		bimServerClient.getServiceInterface().cleanupLongAction(topicId);

		modelState = ModelState.NONE;
	}
	
	public void queryNew(Query query, IfcModelChangeListener ifcModelChangeListener, boolean assumeCompletePreload) {
		this.assumeCompletePreload = assumeCompletePreload;
		try {
			modelState = ModelState.LOADING;
			JsonQueryObjectModelConverter converter = new JsonQueryObjectModelConverter(getPackageMetaData());
			Long topicId = bimServerClient.getServiceInterface().download(Collections.singleton(roid), converter.toJson(query).toString(), bimServerClient.getJsonSerializerOid(), false);
			bimServerClient.waitForDonePreparing(topicId);

			if (ifcModelChangeListener != null) {
				addChangeListener(ifcModelChangeListener);
			}
			processDownload(topicId);
			bimServerClient.getServiceInterface().cleanupLongAction(topicId);
			loadGeometry();
			buildIndex();
			if (ifcModelChangeListener != null) {
				removeChangeListener(ifcModelChangeListener);
			}

			modelState = ModelState.NONE;
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}

	// @Override
	// public SIfcHeader getIfcHeader() {
	// SIfcHeader ifcHeader = super.getIfcHeader();
	// if (ifcHeader == null) {
	// try {
	// SRevision revision =
	// bimServerClient.getServiceInterface().getRevision(roid);
	// if (revision.getConcreteRevisions().size() == 1) {
	// ifcHeader =
	// bimServerClient.getServiceInterface().getIfcHeader(revision.getConcreteRevisions().get(0));
	// if (ifcHeader != null) {
	// setIfcHeader(ifcHeader);
	// }
	// return ifcHeader;
	// }
	// } catch (ServerException e) {
	// LOGGER.error("", e);
	// } catch (UserException e) {
	// LOGGER.error("", e);
	// } catch (PublicInterfaceNotFoundException e) {
	// LOGGER.error("", e);
	// }
	// }
	// return null;
	// }
	
	@Override
	public void dumpDebug() {
		clientDebugInfo.dump();
	}

	public PluginClassLoaderProvider getPluginClassLoaderProvider() {
		return pluginClassLoaderProvider;
	}

	public void setPluginClassLoaderProvider(PluginClassLoaderProvider pluginClassLoaderProvider) {
		this.pluginClassLoaderProvider = pluginClassLoaderProvider;
	}
}