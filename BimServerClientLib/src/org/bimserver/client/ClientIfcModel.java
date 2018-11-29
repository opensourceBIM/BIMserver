package org.bimserver.client;

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

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
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
import org.bimserver.emf.SharedJsonSerializer;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelChangeListener;
import org.bimserver.interfaces.objects.SActionState;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.models.geometry.Bounds;
import org.bimserver.models.geometry.Buffer;
import org.bimserver.models.geometry.GeometryData;
import org.bimserver.models.geometry.GeometryFactory;
import org.bimserver.models.geometry.GeometryInfo;
import org.bimserver.models.geometry.GeometryPackage;
import org.bimserver.plugins.ObjectAlreadyExistsException;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.serializers.SerializerInputstream;
import org.bimserver.plugins.services.Flow;
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
import com.google.common.base.Joiner;

public class ClientIfcModel extends IfcModel {
	public enum ModelState {
		NONE, LOADING, FULLY_LOADED
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientIfcModel.class);
	private BimServerClient bimServerClient;
	private ModelState modelState = ModelState.NONE;
	private long tid = -1;
	private long roid;
	private final Set<String> loadedClasses = new HashSet<String>();
	private long ifcSerializerOid = -1;
	private long binaryGeometrySerializerOid = -1;
	private int cachedObjectCount = -1;
	private boolean recordChanges;
	private boolean includeGeometry;

	private ClientDebugInfo clientDebugInfo = new ClientDebugInfo();

	public ClientIfcModel(BimServerClient bimServerClient, long poid, long roid, boolean deep, PackageMetaData packageMetaData, boolean recordChanges, boolean includeGeometry)
			throws ServerException, UserException, PublicInterfaceNotFoundException {
		super(packageMetaData, null);
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
				long topicId = bimServerClient.getServiceInterface().download(Collections.singleton(roid), converter.toJson(query).toString(), getJsonSerializerOid(), false);
				waitForDonePreparing(topicId);
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
		return bimServerClient.getLowLevelInterface().commitTransaction(tid, comment);
	}

	public long getJsonSerializerOid() throws ServerException, UserException, PublicInterfaceNotFoundException {
		if (ifcSerializerOid == -1) {
			SSerializerPluginConfiguration serializerPluginConfiguration = bimServerClient.getPluginInterface().getSerializerByPluginClassName("org.bimserver.serializers.JsonStreamingSerializerPlugin");
			if (serializerPluginConfiguration != null) {
				ifcSerializerOid = serializerPluginConfiguration.getOid();
			} else {
				throw new UserException("No JSON streaming serializer found");
			}
		}
		return ifcSerializerOid;
	}

	public long getBinaryGeometrySerializerOid() throws ServerException, UserException, PublicInterfaceNotFoundException {
		if (binaryGeometrySerializerOid == -1) {
			SSerializerPluginConfiguration serializerPluginConfiguration = bimServerClient.getPluginInterface().getSerializerByPluginClassName("org.bimserver.serializers.binarygeometry.BinaryGeometrySerializerPlugin");
			if (serializerPluginConfiguration != null) {
				binaryGeometrySerializerOid = serializerPluginConfiguration.getOid();
			} else {
				throw new UserException("No binary geometry serializer found");
			}
		}
		return binaryGeometrySerializerOid;
	}

	private void loadDeep() throws ServerException, UserException, PublicInterfaceNotFoundException, QueryException {
		long start = System.nanoTime();
		if (modelState != ModelState.FULLY_LOADED && modelState != ModelState.LOADING) {
			modelState = ModelState.LOADING;
			Query query = new Query("test", getPackageMetaData());
			QueryPart queryPart = query.createQueryPart();
			queryPart.setIncludeAllFields(true);

			ObjectNode queryNode = new JsonQueryObjectModelConverter(query.getPackageMetaData()).toJson(query);
			Long topicId = bimServerClient.getServiceInterface().download(Collections.singleton(roid), queryNode.toString(), getJsonSerializerOid(), false);
			waitForDonePreparing(topicId);
			try {
				processDownload(topicId);
				bimServerClient.getServiceInterface().cleanupLongAction(topicId);
				modelState = ModelState.FULLY_LOADED;
				buildIndex();
				loadGeometry();
			} catch (IfcModelInterfaceException | IOException e) {
				LOGGER.error("", e);
			} catch (QueryException e) {
				LOGGER.error("", e);
			} catch (GeometryException e) {
				LOGGER.error("", e);
			}
		}
		long end = System.nanoTime();
		LOGGER.info((((end - start) / 1000000) + " ms"));
	}

	private void loadGeometry() throws QueryException, ServerException, UserException, PublicInterfaceNotFoundException, IOException, GeometryException, IfcModelInterfaceException {
		if (includeGeometry) {
			Query query = new Query("test", getPackageMetaData());
			ObjectNode settings = new ObjectMapper().createObjectNode();
			query.setGeometrySettings(settings);
			query.getGeometrySettings().put("useSmallInts", false);
			query.getGeometrySettings().put("splitGeometry", false);
			QueryPart queryPart = query.createQueryPart();

			Map<Long, Long> geometryInfoOidToOid = new HashMap<>();

			EClass ifcProductClass = getPackageMetaData().getEClass("IfcProduct");
			EStructuralFeature geometryFeature = ifcProductClass.getEStructuralFeature("geometry");
			List<IdEObject> allWithSubTypes = new ArrayList<>(super.getAllWithSubTypes(ifcProductClass));
			for (IdEObject ifcProduct : allWithSubTypes) {
				GeometryInfo geometry = (GeometryInfo) ifcProduct.eGet(geometryFeature);
				if (geometry != null) {
					if (geometry.getData() == null || geometry.getData().getIndices() == null) {
						queryPart.addOid(geometry.getOid());
						geometryInfoOidToOid.put(geometry.getOid(), ifcProduct.getOid());
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
			waitForDonePreparing(topicId);
			InputStream inputStream = bimServerClient.getDownloadData(topicId);
			clientDebugInfo.incrementGeometryGetDownloadData();
			try {
				processGeometryInputStream(inputStream, geometryInfoOidToOid);
			} catch (Throwable e) {
				e.printStackTrace();
			} finally {
				bimServerClient.getServiceInterface().cleanupLongAction(topicId);
			}
		}
	}

	public ClientDebugInfo getClientDebugInfo() {
		return clientDebugInfo;
	}

	private void waitForDonePreparing(long topicId) throws UserException, ServerException, PublicInterfaceNotFoundException {
		for (int i = 0; i < 10; i++) {
			SLongActionState progress = bimServerClient.getRegistry().getProgress(topicId);
			if (progress != null) {
				if (progress.getTitle() != null && progress.getTitle().equals("Done preparing")) {
					break;
				} else if (progress.getState() == SActionState.AS_ERROR) {
					throw new UserException(Joiner.on(", ").join(progress.getErrors()));
				}
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void processGeometryInputStream(InputStream inputStream, Map<Long, Long> geometryInfoOidToOid) throws IOException, GeometryException, IfcModelInterfaceException {
		int t = 0;
		CountingLittleEndianDataInputStream dataInputStream = new CountingLittleEndianDataInputStream(inputStream);
		try {
			boolean done = false;
			while (true) {
				byte geometryType = dataInputStream.readByte();
				if (geometryType == 0) {
					String protocol = dataInputStream.readUTF();
					if (!protocol.equals("BGS")) {
						throw new GeometryException("Protocol != BGS (" + protocol + ")");
					}
					byte formatVersion = dataInputStream.readByte();
					if (formatVersion != 16) {
						throw new GeometryException("Unsupported version " + formatVersion + " / 16");
					}

					float multiplierToMm = dataInputStream.readFloat();
					dataInputStream.align8();
					for (int i = 0; i < 6; i++) {
						dataInputStream.readDouble();
					}
				} else if (geometryType == 5) {
					long oid = dataInputStream.readLong();
					String type = dataInputStream.readUTF();
					dataInputStream.align8();
					long roid = dataInputStream.readLong(); // roid
					long geometryInfoOid = dataInputStream.readLong();
					boolean hasTransparency = dataInputStream.readLong() == 1; // transparent
					GeometryInfo geometryInfo = (GeometryInfo) get(geometryInfoOid);
					if (geometryInfo == null) {
						geometryInfo = create(GeometryInfo.class);
					}
					((IdEObjectImpl) geometryInfo).setOid(geometryInfoOid);
					((IdEObjectImpl) geometryInfo).setLoadingState(State.LOADING);
					add(geometryInfoOid, geometryInfo);

					Long ifcProductOid = geometryInfoOidToOid.get(geometryInfoOid);
					if (ifcProductOid == null) {
						throw new GeometryException("Missing geometry info id: " + geometryInfoOid);
					}
					IdEObject ifcProduct = get(ifcProductOid);

					EStructuralFeature geometryFeature = getPackageMetaData().getEClass("IfcProduct").getEStructuralFeature("geometry");
					ifcProduct.eSet(geometryFeature, geometryInfo);

					org.bimserver.models.geometry.Vector3f minBounds = GeometryFactory.eINSTANCE.createVector3f();
					minBounds.setX(dataInputStream.readDouble());
					minBounds.setY(dataInputStream.readDouble());
					minBounds.setZ(dataInputStream.readDouble());

					org.bimserver.models.geometry.Vector3f maxBounds = GeometryFactory.eINSTANCE.createVector3f();
					maxBounds.setX(dataInputStream.readDouble());
					maxBounds.setY(dataInputStream.readDouble());
					maxBounds.setZ(dataInputStream.readDouble());

					Bounds bounds = GeometryFactory.eINSTANCE.createBounds();

					bounds.setMin(minBounds);
					bounds.setMax(maxBounds);

					geometryInfo.setBounds(bounds);

					byte[] transformation = new byte[16 * 8];
					dataInputStream.readFully(transformation);
					geometryInfo.setTransformation(transformation);

					long geometryDataOid = dataInputStream.readLong();
					GeometryData geometryData = (GeometryData) get(geometryDataOid);
					if (geometryData == null) {
						geometryData = GeometryFactory.eINSTANCE.createGeometryData();
						add(geometryDataOid, geometryData);
					}
					geometryInfo.setData(geometryData);
					((IdEObjectImpl) geometryData).setLoadingState(State.LOADED);
				} else if (geometryType == 3) {
					throw new GeometryException("Parts not supported");
				} else if (geometryType == 1) {
					int reused = dataInputStream.readInt();
					String type = dataInputStream.readUTF();
					dataInputStream.align8();
					long roid = dataInputStream.readLong();
					long croid = dataInputStream.readLong();
					boolean hasTransparency = dataInputStream.readLong() == 1; // transparent
					long geometryDataOid = dataInputStream.readLong();

					GeometryData geometryData = (GeometryData) get(geometryDataOid);
					if (geometryData == null) {
						geometryData = GeometryFactory.eINSTANCE.createGeometryData();
						add(geometryDataOid, geometryData);
					}
					((IdEObjectImpl) geometryData).setOid(geometryDataOid);
					((IdEObjectImpl) geometryData).setLoadingState(State.LOADING);

					int nrIndices = dataInputStream.readInt();
					byte[] indices = new byte[nrIndices * 4];
					dataInputStream.readFully(indices);
					Buffer buffer = GeometryFactory.eINSTANCE.createBuffer();
					buffer.setData(indices);
					geometryData.setIndices(buffer);

					int colorType = dataInputStream.readInt();
					if (colorType == 1) {
						dataInputStream.readFloat();
						dataInputStream.readFloat();
						dataInputStream.readFloat();
						dataInputStream.readFloat();
					}

					int nrVertices = dataInputStream.readInt();
					byte[] vertices = new byte[nrVertices * 4];
					dataInputStream.readFully(vertices);
					Buffer verticesBuffer = GeometryFactory.eINSTANCE.createBuffer();
					verticesBuffer.setData(vertices);
					geometryData.setVertices(verticesBuffer);

					int nrNormals = dataInputStream.readInt();
					byte[] normals = new byte[nrNormals * 4];
					dataInputStream.readFully(normals);
					Buffer normalsBuffer = GeometryFactory.eINSTANCE.createBuffer();
					normalsBuffer.setData(normals);
					geometryData.setNormals(normalsBuffer);

					int nrMaterials = dataInputStream.readInt();
					byte[] materials = new byte[nrMaterials * 4];
					dataInputStream.readFully(materials);
					Buffer colorsBuffer = GeometryFactory.eINSTANCE.createBuffer();
					colorsBuffer.setData(materials);
					geometryData.setColorsQuantized(colorsBuffer);
					((IdEObjectImpl) geometryData).setLoadingState(State.LOADED);
				} else if (geometryType == 6) {
					done = true;
				} else {
					throw new GeometryException("Unimplemented type: " + geometryType);
				}
				t++;
				dataInputStream.align8();
			}
		} catch (EOFException e) {
		} catch (IOException e) {
			System.out.println("T: " + t);
			e.printStackTrace();
		} catch (ObjectAlreadyExistsException e) {
			e.printStackTrace();
		} finally {
			dataInputStream.close();
			this.clientDebugInfo.incBytesOverTheLine(dataInputStream.getPos());
		}
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
				long topicId = bimServerClient.getServiceInterface().download(Collections.singleton(roid), converter.toJson(query).toString(), getJsonSerializerOid(), false);

				waitForDonePreparing(topicId);

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

				long topicId = bimServerClient.getServiceInterface().download(Collections.singleton(roid), converter.toJson(query).toString(), getJsonSerializerOid(), false);
				waitForDonePreparing(topicId);
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
				long topicId = bimServerClient.getServiceInterface().download(Collections.singleton(roid), converter.toJson(query).toString(), getJsonSerializerOid(), false);

				waitForDonePreparing(topicId);
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

				long topicId = bimServerClient.getServiceInterface().download(Collections.singleton(roid), converter.toJson(query).toString(), getJsonSerializerOid(), false);

				waitForDonePreparing(topicId);
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

	public void checkin(long poid, String comment) throws ServerException, UserException, PublicInterfaceNotFoundException {
		this.fixOids(new OidProvider() {
			private long c = 1;

			@Override
			public long newOid(EClass eClass) {
				return c++;
			}
		});
		SharedJsonSerializer sharedJsonSerializer = new SharedJsonSerializer(this, false);
		SDeserializerPluginConfiguration deserializer = bimServerClient.getServiceInterface().getSuggestedDeserializerForExtension("json", poid);
		bimServerClient.checkinSync(poid, comment, deserializer.getOid(), false, -1, "test", new SerializerInputstream(sharedJsonSerializer));
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
		Long topicId = bimServerClient.getServiceInterface().download(Collections.singleton(roid), query.toString(), getJsonSerializerOid(), false);
		waitForDonePreparing(topicId);

		processDownload(topicId);
		bimServerClient.getServiceInterface().cleanupLongAction(topicId);

		modelState = ModelState.NONE;
	}
	
	public void queryNew(Query query, IfcModelChangeListener ifcModelChangeListener) {
		try {
			modelState = ModelState.LOADING;
			JsonQueryObjectModelConverter converter = new JsonQueryObjectModelConverter(getPackageMetaData());
			Long topicId = bimServerClient.getServiceInterface().download(Collections.singleton(roid), converter.toJson(query).toString(), getJsonSerializerOid(), false);
			waitForDonePreparing(topicId);

			if (ifcModelChangeListener != null) {
				addChangeListener(ifcModelChangeListener);
			}
			processDownload(topicId);
			bimServerClient.getServiceInterface().cleanupLongAction(topicId);
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
}