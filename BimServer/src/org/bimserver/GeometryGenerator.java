package org.bimserver;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.OidProvider;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.Schema;
import org.bimserver.geometry.Matrix;
import org.bimserver.ifc.BasicIfcModel;
import org.bimserver.models.geometry.GeometryData;
import org.bimserver.models.geometry.GeometryFactory;
import org.bimserver.models.geometry.GeometryInfo;
import org.bimserver.models.geometry.GeometryPackage;
import org.bimserver.models.geometry.Vector3f;
import org.bimserver.models.ifc2x3tc1.IfcBoundingBox;
import org.bimserver.models.ifc2x3tc1.IfcShapeRepresentation;
import org.bimserver.models.store.RenderEnginePluginConfiguration;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSettings;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.objectidms.HideAllInversesObjectIDM;
import org.bimserver.plugins.renderengine.EntityNotFoundException;
import org.bimserver.plugins.renderengine.IndexFormat;
import org.bimserver.plugins.renderengine.Precision;
import org.bimserver.plugins.renderengine.RenderEngine;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.plugins.renderengine.RenderEngineFilter;
import org.bimserver.plugins.renderengine.RenderEngineGeometry;
import org.bimserver.plugins.renderengine.RenderEngineInstance;
import org.bimserver.plugins.renderengine.RenderEngineModel;
import org.bimserver.plugins.renderengine.RenderEngineSettings;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerInputstream;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.renderengine.RenderEnginePool;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.CollectionUtils;
import org.bimserver.utils.Formatters;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeometryGenerator extends GenericGeometryGenerator {
	private static final Logger LOGGER = LoggerFactory.getLogger(GeometryGenerator.class);
	
	private final BimServer bimServer;
	private final Map<Integer, GeometryData> hashes = new ConcurrentHashMap<Integer, GeometryData>();

	private EClass productClass;
	private EClass productRepresentationClass;
	private EStructuralFeature geometryFeature;
	private EStructuralFeature representationFeature;
	private EStructuralFeature representationsFeature;
	private PackageMetaData packageMetaData;

	private AtomicLong bytesSaved = new AtomicLong();
	private AtomicLong totalBytes = new AtomicLong();

	public GeometryGenerator(final BimServer bimServer) {
		this.bimServer = bimServer;
	}
	
	public class Runner implements Runnable {

		private EClass eClass;
		private DatabaseSession databaseSession;
		private RenderEngineSettings renderEngineSettings;
		private RenderEngineFilter renderEngineFilter;
		private RenderEngineFilter renderEngineFilterTransformed = new RenderEngineFilter(true);
		private boolean store;
		private IfcModelInterface targetModel;
		private SerializerPlugin ifcSerializerPlugin;
		private IfcModelInterface model;
		private int pid;
		private int rid;
		private Map<IdEObject, IdEObject> bigMap;
		private GenerateGeometryResult generateGeometryResult;
		private RenderEnginePool renderEnginePool;

		public Runner(EClass eClass, RenderEnginePool renderEnginePool, DatabaseSession databaseSession, RenderEngineSettings renderEngineSettings, boolean store, IfcModelInterface targetModel, SerializerPlugin ifcSerializerPlugin, IfcModelInterface model, int pid, int rid, Map<IdEObject, IdEObject> bigMap, RenderEngineFilter renderEngineFilter, GenerateGeometryResult generateGeometryResult) {
			this.eClass = eClass;
			this.renderEnginePool = renderEnginePool;
			this.databaseSession = databaseSession;
			this.renderEngineSettings = renderEngineSettings;
			this.store = store;
			this.targetModel = targetModel;
			this.ifcSerializerPlugin = ifcSerializerPlugin;
			this.model = model;
			this.pid = pid;
			this.rid = rid;
			this.bigMap = bigMap;
			this.renderEngineFilter = renderEngineFilter;
			this.generateGeometryResult = generateGeometryResult;
		}
		
		@Override
		public void run() {
			targetModel.generateMinimalExpressIds();

			Serializer ifcSerializer = ifcSerializerPlugin.createSerializer(new PluginConfiguration());
			RenderEngine renderEngine = null;
			try {
				renderEngine = renderEnginePool.borrowObject();
				ifcSerializer.init(targetModel, null, bimServer.getPluginManager(), true);

				boolean debug = false;
				InputStream in = null;
				if (debug) {
					File file = new File((eClass == null ? "all" : eClass.getName()) + ".ifc");
					FileOutputStream fos = new FileOutputStream(file);
					ifcSerializer.writeToOutputStream(fos, null);
					fos.close();
					in = new FileInputStream(file);
				} else {
					in = new SerializerInputstream(ifcSerializer);
				}
				RenderEngineModel renderEngineModel = renderEngine.openModel(in);
				try {
					renderEngineModel.setSettings(renderEngineSettings);
					renderEngineModel.setFilter(renderEngineFilter);

					renderEngineModel.generateGeneralGeometry();

					List<IdEObject> allWithSubTypes = null;
					if (eClass == null) {
						allWithSubTypes = targetModel.getAllWithSubTypes(packageMetaData.getEClass("IfcProduct"));
					} else {
						allWithSubTypes = targetModel.getAll(eClass);
					}
					for (IdEObject ifcProduct : allWithSubTypes) {
						IdEObject representation = (IdEObject) ifcProduct.eGet(representationFeature);
						if (representation != null && ((List<?>) representation.eGet(representationsFeature)).size() > 0) {
							List<?> representations = (List<?>) representation.eGet(representationsFeature);
							GeometryInfo geometryInfo = null;
							try {
								RenderEngineInstance renderEngineInstance = renderEngineModel.getInstanceFromExpressId(ifcProduct.getExpressId());
								RenderEngineGeometry geometry = renderEngineInstance.generateGeometry();
								boolean translate = true;
								if (geometry == null || geometry.getIndices().length == 0) {
									renderEngineModel.setFilter(renderEngineFilterTransformed);
									geometry = renderEngineInstance.generateGeometry();
									if (geometry != null) {
										translate = false;
									}
									renderEngineModel.setFilter(renderEngineFilter);
								}
								if (geometry != null && geometry.getNrIndices() > 0) {
									if (store) {
										geometryInfo = model.createAndAdd(GeometryPackage.eINSTANCE.getGeometryInfo(), databaseSession.newOid(GeometryPackage.eINSTANCE.getGeometryInfo()));
										databaseSession.store(geometryInfo, pid, rid);
//										geometryInfo = packageMetaData.create(GeometryInfo.class);
//										Long newOid = databaseSession.newOid(GeometryPackage.eINSTANCE.getGeometryInfo());
//										((IdEObjectImpl) geometryInfo).setOid(newOid);
//										model.add(newOid, geometryInfo);
									} else {
										geometryInfo = GeometryFactory.eINSTANCE.createGeometryInfo();
									}

									geometryInfo.setMinBounds(createVector3f(packageMetaData, model, Double.POSITIVE_INFINITY, databaseSession, store, pid, rid));
									geometryInfo.setMaxBounds(createVector3f(packageMetaData, model, -Double.POSITIVE_INFINITY, databaseSession, store, pid, rid));

									try {
										double area = renderEngineInstance.getArea();
										geometryInfo.setArea(area);
										double volume = renderEngineInstance.getVolume();
										if (volume < 0d) {
											volume = -volume;
										}
										geometryInfo.setVolume(volume);
										
//										EStructuralFeature guidFeature = ifcProduct.eClass().getEStructuralFeature("GlobalId");
//										String guid = (String) ifcProduct.eGet(guidFeature);
//										System.out.println(guid + ": " + "Area: " + area + ", Volume: " + volume);
									} catch (UnsupportedOperationException e) {
									}
									
									GeometryData geometryData = null;
									if (store) {
										geometryData = model.createAndAdd(GeometryPackage.eINSTANCE.getGeometryData(), databaseSession.newOid(GeometryPackage.eINSTANCE.getGeometryData()));
										databaseSession.store(geometryData, pid, rid);
									} else {
										geometryData = GeometryFactory.eINSTANCE.createGeometryData();
									}

									geometryData.setIndices(intArrayToByteArray(geometry.getIndices()));
									geometryData.setVertices(floatArrayToByteArray(geometry.getVertices()));
//									geometryData.setMaterialIndices(intArrayToByteArray(geometry.getMaterialIndices()));
									geometryData.setNormals(floatArrayToByteArray(geometry.getNormals()));
									
									geometryInfo.setPrimitiveCount(geometry.getIndices().length / 3);

									if (geometry.getMaterialIndices() != null && geometry.getMaterialIndices().length > 0) {
										boolean hasMaterial = false;
										float[] vertex_colors = new float[geometry.getVertices().length / 3 * 4];
										for (int i = 0; i < geometry.getMaterialIndices().length; ++i) {
											int c = geometry.getMaterialIndices()[i];
											for (int j = 0; j < 3; ++j) {
												int k = geometry.getIndices()[i * 3 + j];
												if (c > -1) {
													hasMaterial = true;
													for (int l = 0; l < 4; ++l) {
														vertex_colors[4 * k + l] = geometry.getMaterials()[4 * c + l];
													}
												}
											}
										}
										if (hasMaterial) {
											geometryData.setMaterials(floatArrayToByteArray(vertex_colors));
										}
									}

									double[] tranformationMatrix = new double[16];
									Matrix.setIdentityM(tranformationMatrix, 0);
									if (translate && renderEngineInstance.getTransformationMatrix() != null) {
										tranformationMatrix = renderEngineInstance.getTransformationMatrix();
									}

									for (int i = 0; i < geometry.getIndices().length; i++) {
										processExtends(geometryInfo, tranformationMatrix, geometry.getVertices(), geometry.getIndices()[i] * 3, generateGeometryResult);
									}

									geometryInfo.setData(geometryData);

									long length = (geometryData.getIndices() != null ? geometryData.getIndices().length : 0) + 
												  (geometryData.getVertices() != null ? geometryData.getVertices().length : 0) + 
												  (geometryData.getNormals() != null ? geometryData.getNormals().length : 0) + 
												  (geometryData.getMaterials() != null ? geometryData.getMaterials().length : 0) +
												  (geometryData.getMaterialIndices() != null ? geometryData.getMaterialIndices().length : 0);

									setTransformationMatrix(geometryInfo, tranformationMatrix);
									if (bimServer.getServerSettingsCache().getServerSettings().isReuseGeometry()) {
										int hash = hash(geometryData);
										if (hashes.containsKey(hash)) {
											databaseSession.removeFromCommit(geometryData);
											geometryInfo.setData(hashes.get(hash));
											bytesSaved.addAndGet(length);
										} else {
											hashes.put(hash, geometryData);
										}
									}
									totalBytes.addAndGet(length);

									if (bigMap == null) {
										ifcProduct.eSet(geometryFeature, geometryInfo);
										if (store) {
											databaseSession.store(ifcProduct, pid, rid);
										}
									} else {
										bigMap.get(ifcProduct).eSet(geometryFeature, geometryInfo);
										ifcProduct.eSet(geometryFeature, geometryInfo); // ??
										if (store) {
											databaseSession.store(bigMap.get(ifcProduct), pid, rid);
										}
									}
								}
							} catch (EntityNotFoundException e) {
								// As soon as we find a representation that is not Curve2D, then we should show a "INFO" message in the log to indicate there could be something wrong
								boolean ignoreNotFound = true;
								for (Object rep : representations) {
									if (rep instanceof IfcShapeRepresentation) {
										IfcShapeRepresentation ifcShapeRepresentation = (IfcShapeRepresentation)rep;
										if (!"Curve2D".equals(ifcShapeRepresentation.getRepresentationType())) {
											ignoreNotFound = false;
										}
//										if (ifcShapeRepresentation.getRepresentationType().equals("BoundingBox") && ifcProduct.eClass().getName().equals("IfcSpace")) {
//											// We try to use the bounding box for geometry
//											
//											for (IfcRepresentationItem ifcRepresentationItem : ifcShapeRepresentation.getItems()) {
//												if (ifcRepresentationItem instanceof IfcBoundingBox) {
//													IfcBoundingBox ifcBoundingBox = (IfcBoundingBox)ifcRepresentationItem;
//													createBoundingBoxGeometry(ifcBoundingBox, ifcProduct);
//													ignoreNotFound = true;
//												}
//											}
//										}
									}
								}
								
								if (!ignoreNotFound) {
									LOGGER.info("Entity not found " + ifcProduct.eClass().getName() + " " + ifcProduct.getExpressId() + "/" + ifcProduct.getOid());
								}
							} catch (BimserverDatabaseException | RenderEngineException e) {
								LOGGER.error("", e);
							} catch (IfcModelInterfaceException e) {
								LOGGER.error("", e);
							}
						}
					}								
				} finally {
					in.close();
					renderEngineModel.close();
					if (renderEngine != null) {
						renderEnginePool.returnObject(renderEngine);
					}
				}
			} catch (Exception e) {
				LOGGER.error("", e);
			}
		}

		private float[] doubleToFloat(double[] tranformationMatrix) {
			float[] result = new float[tranformationMatrix.length];
			for (int i=0; i<tranformationMatrix.length; i++) {
				result[i] = (float) tranformationMatrix[i];
			}
			return result;
		}

		@SuppressWarnings("unused")
		private void createBoundingBoxGeometry(IfcBoundingBox ifcBoundingBox, IdEObject ifcProduct) throws IfcModelInterfaceException, BimserverDatabaseException {
			System.out.println("bb " + ifcProduct.getOid());
			GeometryInfo geometryInfo = model.createAndAdd(GeometryPackage.eINSTANCE.getGeometryInfo(), databaseSession.newOid(GeometryPackage.eINSTANCE.getGeometryInfo()));
			databaseSession.store(geometryInfo, pid, rid);

			geometryInfo.setMinBounds(createVector3f(packageMetaData, model, Double.POSITIVE_INFINITY, databaseSession, store, pid, rid));
			geometryInfo.setMaxBounds(createVector3f(packageMetaData, model, -Double.POSITIVE_INFINITY, databaseSession, store, pid, rid));
			
			GeometryData geometryData = model.createAndAdd(GeometryPackage.eINSTANCE.getGeometryData(), databaseSession.newOid(GeometryPackage.eINSTANCE.getGeometryData()));
			databaseSession.store(geometryData, pid, rid);
			
			int[] indices = new int[]{
				0, 1, 2,
				0, 2, 3,
				5, 6, 1,
				1, 6, 2,
				2, 6, 7,
				2, 7, 3,
				5, 6, 7,
				7, 4, 5,
				1, 5, 4,
				0, 1, 4,
				7, 3, 0,
				0, 4, 7
			};
			
			float[] vertices = new float[]{
				0, 0, 0,
				(float)ifcBoundingBox.getXDim(), 0, 0,
				(float)ifcBoundingBox.getXDim(), (float) ifcBoundingBox.getYDim(), 0,
				0, (float)ifcBoundingBox.getYDim(), 0,
				0, 0, (float) ifcBoundingBox.getZDim(),
				(float)ifcBoundingBox.getXDim(), 0, (float) ifcBoundingBox.getZDim(),
				(float)ifcBoundingBox.getXDim(), (float) ifcBoundingBox.getYDim(), (float) ifcBoundingBox.getZDim(),
				0, (float)ifcBoundingBox.getYDim(), (float) ifcBoundingBox.getZDim()
			};
			
			float[] normals = new float[]{
				0, 0, 0,
				0, 0, 0,
				0, 0, 0,
				0, 0, 0,
				0, 0, 0,
				0, 0, 0,
				0, 0, 0,
				0, 0, 0,
				0, 0, 0,
				0, 0, 0,
				0, 0, 0,
				0, 0, 0
			};
			
			geometryData.setIndices(intArrayToByteArray(indices));
			geometryData.setVertices(floatArrayToByteArray(vertices));
			geometryData.setNormals(floatArrayToByteArray(normals));
			
			geometryInfo.setPrimitiveCount(12);
			geometryInfo.setData(geometryData);
			
			double[] tranformationMatrix = new double[16];
			Matrix.setIdentityM(tranformationMatrix, 0);
			Matrix.translateM(tranformationMatrix, 0, ifcBoundingBox.getCorner().getCoordinates().get(0), ifcBoundingBox.getCorner().getCoordinates().get(1), ifcBoundingBox.getCorner().getCoordinates().get(2));
//			if (translate && renderEngineInstance.getTransformationMatrix() != null) {
//				tranformationMatrix = renderEngineInstance.getTransformationMatrix();
//			}
			
			setTransformationMatrix(geometryInfo, tranformationMatrix);
//			totalBytes.addAndGet(length);

			if (bigMap == null) {
				ifcProduct.eSet(geometryFeature, geometryInfo);
				if (store) {
					databaseSession.store(ifcProduct, pid, rid);
				}
			} else {
				bigMap.get(ifcProduct).eSet(geometryFeature, geometryInfo);
				ifcProduct.eSet(geometryFeature, geometryInfo); // ??
				if (store) {
					databaseSession.store(bigMap.get(ifcProduct), pid, rid);
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public GenerateGeometryResult generateGeometry(long uoid, final PluginManager pluginManager, final DatabaseSession databaseSession, final IfcModelInterface model, final int pid, final int rid,
			final boolean store, GeometryCache geometryCache) throws BimserverDatabaseException, GeometryGeneratingException {
		GenerateGeometryResult generateGeometryResult = new GenerateGeometryResult();
		packageMetaData = model.getPackageMetaData();
		productClass = packageMetaData.getEClass("IfcProduct");
		productRepresentationClass = packageMetaData.getEClass("IfcProductRepresentation");
		geometryFeature = productClass.getEStructuralFeature("geometry");
		representationFeature = productClass.getEStructuralFeature("Representation");
		representationsFeature = productRepresentationClass.getEStructuralFeature("Representations");

		if (geometryCache != null && !geometryCache.isEmpty()) {
			returnCachedData(model, geometryCache, databaseSession, pid, rid);
			return null;
		}
		long start = System.nanoTime();
		String pluginName = "";
		if (model.getPackageMetaData().getSchema() == Schema.IFC4) {
			pluginName = "org.bimserver.ifc.step.serializer.Ifc4StepSerializerPlugin";
		} else if (model.getPackageMetaData().getSchema() == Schema.IFC2X3TC1) {
			pluginName = "org.bimserver.ifc.step.serializer.Ifc2x3tc1StepSerializerPlugin";
		}

		try {
			final SerializerPlugin ifcSerializerPlugin = (SerializerPlugin) pluginManager.getPlugin(pluginName, true);
			if (ifcSerializerPlugin == null) {
				throw new UserException("No IFC serializer found");
			}

			User user = (User) databaseSession.get(uoid, OldQuery.getDefault());
			UserSettings userSettings = user.getUserSettings();
			RenderEnginePluginConfiguration defaultRenderEngine = userSettings.getDefaultRenderEngine();
			if (defaultRenderEngine == null) {
				throw new UserException("No default render engine has been selected for this user");
			}

			int maxSimultanousThreads = Math.min(bimServer.getServerSettingsCache().getServerSettings().getRenderEngineProcesses(), Runtime.getRuntime().availableProcessors());
			if (maxSimultanousThreads < 1) {
				maxSimultanousThreads = 1;
			}

			final RenderEngineSettings settings = new RenderEngineSettings();
			settings.setPrecision(Precision.SINGLE);
			settings.setIndexFormat(IndexFormat.AUTO_DETECT);
			settings.setGenerateNormals(true);
			settings.setGenerateTriangles(true);
			settings.setGenerateWireFrame(false);
			
			final RenderEngineFilter renderEngineFilter = new RenderEngineFilter();

			RenderEnginePool pool = bimServer.getRenderEnginePools().getRenderEnginePool(model.getPackageMetaData().getSchema(), defaultRenderEngine.getPluginDescriptor().getPluginClassName(), new PluginConfiguration(defaultRenderEngine.getSettings()));
			
			if (maxSimultanousThreads == 1) {
				Runner runner = new Runner(null, pool, databaseSession, settings, store, model, ifcSerializerPlugin, model, pid, rid, null, renderEngineFilter, generateGeometryResult);
				runner.run();
			} else {
				Set<EClass> classes = new HashSet<>();
				for (IdEObject object : model.getAllWithSubTypes(packageMetaData.getEClass("IfcProduct"))) {
					IdEObject representation = (IdEObject)object.eGet(representationFeature);
					if (representation != null && ((List<?>)representation.eGet(representationsFeature)).size() > 0) {
						classes.add(object.eClass());
					}
				}
				
				if (classes.size() == 0) {
					return null;
				}
				
				classes.remove(packageMetaData.getEClass("IfcAnnotation"));
				classes.remove(packageMetaData.getEClass("IfcOpeningElement"));
				
				LOGGER.debug("Using " + maxSimultanousThreads + " processes for geometry generation");
				ThreadPoolExecutor executor = new ThreadPoolExecutor(maxSimultanousThreads, maxSimultanousThreads, 24, TimeUnit.HOURS, new ArrayBlockingQueue<Runnable>(classes.size()));

				final Map<IdEObject, IdEObject> bigMap = new HashMap<IdEObject, IdEObject>();

				HideAllInversesObjectIDM idm = new HideAllInversesObjectIDM(CollectionUtils.singleSet(packageMetaData.getEPackage()), model.getPackageMetaData());
				OidProvider oidProvider = new OidProvider(){
					@Override
					public long newOid(EClass eClass) {
						return databaseSession.newOid(eClass);
					}};
				for (final EClass eClass : classes) {
					final BasicIfcModel targetModel = new BasicIfcModel(model.getPackageMetaData(), null);
					ModelHelper modelHelper = new ModelHelper(bimServer.getMetaDataManager(), targetModel);
					modelHelper.setOidProvider(oidProvider);
					modelHelper.setObjectIDM(idm);
					
					IdEObject newOwnerHistory = modelHelper.copyBasicObjects(model, bigMap);
					
					for (IdEObject idEObject : model.getAll(eClass)) {
						IdEObject newObject = modelHelper.copy(idEObject, false, ModelHelper.createObjectIdm(idEObject.eClass()));
						modelHelper.copyDecomposes(idEObject, newOwnerHistory);
						bigMap.put(newObject, idEObject);
						if (packageMetaData.getEClass("IfcElement").isSuperTypeOf(eClass)) {
							EStructuralFeature hasOpeningsFeature = idEObject.eClass().getEStructuralFeature("HasOpenings");
							for (IdEObject ifcRelVoidsElement : ((List<IdEObject>)idEObject.eGet(hasOpeningsFeature))) {
								bigMap.put(modelHelper.copy(ifcRelVoidsElement, false), ifcRelVoidsElement);
								EStructuralFeature relatedOpeningElementFeature = ifcRelVoidsElement.eClass().getEStructuralFeature("RelatedOpeningElement");
								IdEObject relatedOpeningElement = (IdEObject) ifcRelVoidsElement.eGet(relatedOpeningElementFeature);
								if (relatedOpeningElement != null) {
									bigMap.put(modelHelper.copy(relatedOpeningElement, false), relatedOpeningElement);
								}
							}
						}
					}

					executor.submit(new Runner(eClass, pool, databaseSession, settings, store, targetModel, ifcSerializerPlugin, model, pid, rid, bigMap, renderEngineFilter, generateGeometryResult));
				}
				executor.shutdown();
				executor.awaitTermination(24, TimeUnit.HOURS);				
			}
			
			long end = System.nanoTime();
			LOGGER.info("Rendertime: " + ((end - start) / 1000000) + "ms, " + "Reused: " + Formatters.bytesToString(bytesSaved.get()) + ", Total: " + Formatters.bytesToString(totalBytes.get()) + ", Final: " + Formatters.bytesToString(totalBytes.get() - bytesSaved.get()));
		} catch (Exception e) {
			LOGGER.error("", e);
			throw new GeometryGeneratingException(e);
		}
		return generateGeometryResult;
	}
	
	private int hash(GeometryData geometryData) {
		int hashCode = 0;
		if (geometryData.getIndices() != null) {
			hashCode += Arrays.hashCode(geometryData.getIndices());
		}
		if (geometryData.getVertices() != null) {
			hashCode += Arrays.hashCode(geometryData.getVertices());
		}
		if (geometryData.getNormals() != null) {
			hashCode += Arrays.hashCode(geometryData.getNormals());
		}
		if (geometryData.getMaterialIndices() != null) {
			hashCode += Arrays.hashCode(geometryData.getMaterialIndices());
		}
		if (geometryData.getMaterials() != null) {
			hashCode += Arrays.hashCode(geometryData.getMaterials());
		}
		return hashCode;
	}

	private void processExtends(GeometryInfo geometryInfo, double[] transformationMatrix, float[] vertices, int index, GenerateGeometryResult generateGeometryResult) {
		double x = vertices[index];
		double y = vertices[index + 1];
		double z = vertices[index + 2];

		double[] result = new double[4];
		Matrix.multiplyMV(result, 0, transformationMatrix, 0, new double[] { x, y, z, 1 }, 0);
		x = result[0];
		y = result[1];
		z = result[2];
		geometryInfo.getMinBounds().setX(Math.min(x, geometryInfo.getMinBounds().getX()));
		geometryInfo.getMinBounds().setY(Math.min(y, geometryInfo.getMinBounds().getY()));
		geometryInfo.getMinBounds().setZ(Math.min(z, geometryInfo.getMinBounds().getZ()));
		geometryInfo.getMaxBounds().setX(Math.max(x, geometryInfo.getMaxBounds().getX()));
		geometryInfo.getMaxBounds().setY(Math.max(y, geometryInfo.getMaxBounds().getY()));
		geometryInfo.getMaxBounds().setZ(Math.max(z, geometryInfo.getMaxBounds().getZ()));

		generateGeometryResult.setMinX(Math.min(x, generateGeometryResult.getMinX()));
		generateGeometryResult.setMinY(Math.min(y, generateGeometryResult.getMinY()));
		generateGeometryResult.setMinZ(Math.min(z, generateGeometryResult.getMinZ()));
		generateGeometryResult.setMaxX(Math.max(x, generateGeometryResult.getMaxX()));
		generateGeometryResult.setMaxY(Math.max(y, generateGeometryResult.getMaxY()));
		generateGeometryResult.setMaxZ(Math.max(z, generateGeometryResult.getMaxZ()));
	}

	private void setTransformationMatrix(GeometryInfo geometryInfo, double[] transformationMatrix) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(16 * 8);
		byteBuffer.order(ByteOrder.nativeOrder());
		DoubleBuffer asDoubleBuffer = byteBuffer.asDoubleBuffer();
		for (double f : transformationMatrix) {
			asDoubleBuffer.put(f);
		}
		geometryInfo.setTransformation(byteBuffer.array());
	}

	private void returnCachedData(IfcModelInterface model, GeometryCache geometryCache, DatabaseSession databaseSession, int pid, int rid) throws BimserverDatabaseException {
		EClass productClass = model.getPackageMetaData().getEClass("IfcProduct");
		List<IdEObject> products = model.getAllWithSubTypes(productClass);
		for (IdEObject ifcProduct : products) {
			GeometryCacheEntry geometryCacheEntry = geometryCache.get(ifcProduct.getExpressId());
			if (geometryCacheEntry != null) {
				GeometryData geometryData = databaseSession.create(GeometryPackage.eINSTANCE.getGeometryData(), pid, rid);
				geometryData.setVertices(geometryCacheEntry.getVertices().array());
				geometryData.setNormals(geometryCacheEntry.getNormals().array());
				GeometryInfo geometryInfo = databaseSession.create(GeometryPackage.eINSTANCE.getGeometryInfo(), pid, rid);
				Vector3f min = databaseSession.create(GeometryPackage.eINSTANCE.getVector3f(), pid, rid);
				min.setX(geometryCacheEntry.getGeometryInfo().getMinBounds().getX());
				min.setY(geometryCacheEntry.getGeometryInfo().getMinBounds().getY());
				min.setZ(geometryCacheEntry.getGeometryInfo().getMinBounds().getZ());
				Vector3f max = databaseSession.create(GeometryPackage.eINSTANCE.getVector3f(), pid, rid);
				max.setX(geometryCacheEntry.getGeometryInfo().getMaxBounds().getX());
				max.setY(geometryCacheEntry.getGeometryInfo().getMaxBounds().getY());
				max.setZ(geometryCacheEntry.getGeometryInfo().getMaxBounds().getZ());
				geometryInfo.setMinBounds(min);
				geometryInfo.setMaxBounds(max);
				geometryInfo.setData(geometryData);
				ifcProduct.eSet(ifcProduct.eClass().getEStructuralFeature("geometry"), geometryInfo);
			}
		}
	}

	private Vector3f createVector3f(PackageMetaData packageMetaData, IfcModelInterface model, double defaultValue, DatabaseSession session, boolean store, int pid, int rid) throws BimserverDatabaseException, IfcModelInterfaceException {
		Vector3f vector3f = null;
		if (store) {
			vector3f = model.createAndAdd(GeometryPackage.eINSTANCE.getVector3f(), session.newOid(GeometryPackage.eINSTANCE.getVector3f()));
			session.store(vector3f, pid, rid);
		} else {
			vector3f = GeometryFactory.eINSTANCE.createVector3f();
		}
		vector3f.setX(defaultValue);
		vector3f.setY(defaultValue);
		vector3f.setZ(defaultValue);
		return vector3f;
	}
}