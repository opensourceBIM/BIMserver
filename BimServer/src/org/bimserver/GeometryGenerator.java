package org.bimserver;

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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.NotImplementedException;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.OidProvider;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.Schema;
import org.bimserver.geometry.Matrix;
import org.bimserver.geometry.Vector;
import org.bimserver.ifc.BasicIfcModel;
import org.bimserver.models.geometry.GeometryData;
import org.bimserver.models.geometry.GeometryFactory;
import org.bimserver.models.geometry.GeometryInfo;
import org.bimserver.models.geometry.GeometryPackage;
import org.bimserver.models.geometry.Vector3f;
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
import org.bimserver.plugins.renderengine.RenderEnginePlugin;
import org.bimserver.plugins.renderengine.RenderEngineSettings;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.CollectionUtils;
import org.bimserver.utils.Formatters;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeometryGenerator {
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
		private RenderEnginePlugin renderEnginePlugin;
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

		public Runner(EClass eClass, RenderEnginePlugin renderEnginePlugin, DatabaseSession databaseSession, RenderEngineSettings renderEngineSettings, boolean store, IfcModelInterface targetModel, SerializerPlugin ifcSerializerPlugin, IfcModelInterface model, int pid, int rid, Map<IdEObject, IdEObject> bigMap, RenderEngineFilter renderEngineFilter) {
			this.eClass = eClass;
			this.renderEnginePlugin = renderEnginePlugin;
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
		}
		
		@Override
		public void run() {
			targetModel.generateMinimalExpressIds();

			Serializer ifcSerializer = ifcSerializerPlugin.createSerializer(new PluginConfiguration());
			RenderEngine renderEngine = null;
			try {
				renderEngine = renderEnginePlugin.createRenderEngine(new PluginConfiguration(), model.getPackageMetaData().getSchema().getEPackageName());
			} catch (RenderEngineException e) {
				LOGGER.error("", e);
			}
			try {
				renderEngine.init();
				ifcSerializer.init(targetModel, null, bimServer.getPluginManager(), null, model.getPackageMetaData(), true);

				boolean debug = false;
				InputStream in = null;
				if (debug) {
					File file = new File((eClass == null ? "all" : eClass.getName()) + ".ifc");
					FileOutputStream fos = new FileOutputStream(file);
					IOUtils.copy(ifcSerializer.getInputStream(), fos);
					fos.close();
					in = new FileInputStream(file);
				} else {
					in = ifcSerializer.getInputStream();
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
									GeometryInfo geometryInfo = null;
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

									geometryInfo.setMinBounds(createVector3f(packageMetaData, model, Float.POSITIVE_INFINITY, databaseSession, store, pid, rid));
									geometryInfo.setMaxBounds(createVector3f(packageMetaData, model, Float.NEGATIVE_INFINITY, databaseSession, store, pid, rid));

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
									} catch (NotImplementedException e) {
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
									geometryData.setMaterialIndices(intArrayToByteArray(geometry.getMaterialIndices()));
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

									float[] tranformationMatrix = new float[16];
									if (translate && renderEngineInstance.getTransformationMatrix() != null) {
										tranformationMatrix = renderEngineInstance.getTransformationMatrix();
									} else {
										Matrix.setIdentityM(tranformationMatrix, 0);
									}

									for (int i = 0; i < geometry.getIndices().length; i++) {
										processExtends(geometryInfo, tranformationMatrix, geometry.getVertices(), geometry.getIndices()[i] * 3);
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
								LOGGER.info("Entity not found " + ifcProduct.eClass().getName() + " " + ifcProduct.getExpressId() + "/" + ifcProduct.getOid());
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
				}
			} catch (SerializerException | RenderEngineException | IOException e) {
				LOGGER.error("", e);
			} finally {
				try {
					renderEngine.close();
				} catch (RenderEngineException e) {
					LOGGER.error("", e);
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void generateGeometry(long uoid, final PluginManager pluginManager, final DatabaseSession databaseSession, final IfcModelInterface model, final int pid, final int rid,
			final boolean store, GeometryCache geometryCache) throws BimserverDatabaseException, GeometryGeneratingException {
		packageMetaData = model.getPackageMetaData();
		productClass = packageMetaData.getEClass("IfcProduct");
		productRepresentationClass = packageMetaData.getEClass("IfcProductRepresentation");
		geometryFeature = productClass.getEStructuralFeature("geometry");
		representationFeature = productClass.getEStructuralFeature("Representation");
		representationsFeature = productRepresentationClass.getEStructuralFeature("Representations");

		if (geometryCache != null && !geometryCache.isEmpty()) {
			returnCachedData(model, geometryCache, databaseSession, pid, rid);
			return;
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

			User user = (User) databaseSession.get(uoid, Query.getDefault());
			UserSettings userSettings = user.getUserSettings();
			RenderEnginePluginConfiguration defaultRenderEngine = userSettings.getDefaultRenderEngine();
			if (defaultRenderEngine == null) {
				throw new UserException("No default render engine has been selected for this user");
			}
			final RenderEnginePlugin renderEnginePlugin = pluginManager.getRenderEngine(defaultRenderEngine.getPluginDescriptor().getPluginClassName(), true);
			if (renderEnginePlugin == null) {
				throw new UserException("No (enabled) render engine found of type " + defaultRenderEngine.getPluginDescriptor().getPluginClassName());
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

			if (maxSimultanousThreads == 1) {
				Runner runner = new Runner(null, renderEnginePlugin, databaseSession, settings, store, model, ifcSerializerPlugin, model, pid, rid, null, renderEngineFilter);
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
					return;
				}
				
				classes.remove(packageMetaData.getEClass("IfcAnnotation"));
				classes.remove(packageMetaData.getEClass("IfcOpeningElement"));
				
				LOGGER.debug("Using " + maxSimultanousThreads + " processes for geometry generation");
				ThreadPoolExecutor executor = new ThreadPoolExecutor(maxSimultanousThreads, maxSimultanousThreads, 24, TimeUnit.HOURS, new ArrayBlockingQueue<Runnable>(classes.size()));

				final Map<IdEObject, IdEObject> bigMap = new HashMap<IdEObject, IdEObject>();

				HideAllInversesObjectIDM idm = new HideAllInversesObjectIDM(CollectionUtils.singleSet(packageMetaData.getEPackage()), pluginManager.getMetaDataManager().getPackageMetaData("ifc2x3tc1").getSchemaDefinition());
				OidProvider<Long> oidProvider = new OidProvider<Long>(){
					@Override
					public Long newOid(EClass eClass) {
						return databaseSession.newOid(eClass);
					}};
				for (final EClass eClass : classes) {
					final BasicIfcModel targetModel = new BasicIfcModel(pluginManager.getMetaDataManager().getPackageMetaData("ifc2x3tc1"), null);
					ModelHelper modelHelper = new ModelHelper(bimServer.getMetaDataManager(), targetModel);
					modelHelper.setOidProvider(oidProvider);
					modelHelper.setObjectIDM(idm);
					
					IdEObject newOwnerHistory = modelHelper.copyBasicObjects(model, bigMap);
					
					for (IdEObject idEObject : model.getAll(eClass)) {
						IdEObject newObject = modelHelper.copy(idEObject, false, ModelHelper.createObjectIdm(idEObject.eClass()));
						modelHelper.copyDecomposes(idEObject, newOwnerHistory);
						bigMap.put(newObject, idEObject);
						if (eClass.getName().equals("IfcWallStandardCase")) {
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

					executor.submit(new Runner(eClass, renderEnginePlugin, databaseSession, settings, store, targetModel, ifcSerializerPlugin, model, pid, rid, bigMap, renderEngineFilter));
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

	private void processExtends(GeometryInfo geometryInfo, float[] transformationMatrix, float[] vertices, int index) {
		float x = vertices[index];
		float y = vertices[index + 1];
		float z = vertices[index + 2];
		float[] result = new float[4];
		Matrix.multiplyMV(result, 0, transformationMatrix, 0, new float[] { x, y, z, 1 }, 0);
		x = result[0];
		y = result[1];
		z = result[2];
		geometryInfo.getMinBounds().setX(Math.min(x, geometryInfo.getMinBounds().getX()));
		geometryInfo.getMinBounds().setY(Math.min(y, geometryInfo.getMinBounds().getY()));
		geometryInfo.getMinBounds().setZ(Math.min(z, geometryInfo.getMinBounds().getZ()));
		geometryInfo.getMaxBounds().setX(Math.max(x, geometryInfo.getMaxBounds().getX()));
		geometryInfo.getMaxBounds().setY(Math.max(y, geometryInfo.getMaxBounds().getY()));
		geometryInfo.getMaxBounds().setZ(Math.max(z, geometryInfo.getMaxBounds().getZ()));
	}

	private byte[] floatArrayToByteArray(float[] vertices) {
		if (vertices == null) {
			return null;
		}
		ByteBuffer buffer = ByteBuffer.wrap(new byte[vertices.length * 4]);
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		FloatBuffer asFloatBuffer = buffer.asFloatBuffer();
		for (float f : vertices) {
			asFloatBuffer.put(f);
		}
		return buffer.array();
	}

	private byte[] intArrayToByteArray(int[] indices) {
		if (indices == null) {
			return null;
		}
		ByteBuffer buffer = ByteBuffer.wrap(new byte[indices.length * 4]);
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		IntBuffer asIntBuffer = buffer.asIntBuffer();
		for (int i : indices) {
			asIntBuffer.put(i);
		}
		return buffer.array();
	}

	private void setTransformationMatrix(GeometryInfo geometryInfo, float[] transformationMatrix) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(16 * 4);
		byteBuffer.order(ByteOrder.nativeOrder());
		FloatBuffer asFloatBuffer = byteBuffer.asFloatBuffer();
		for (float f : transformationMatrix) {
			asFloatBuffer.put(f);
		}
		geometryInfo.setTransformation(byteBuffer.array());
	}

	private static boolean almostTheSame(float f1, float f2, float maxDiff) {
		return Math.abs(f1 - f2) < maxDiff;
	}

	/**
	 * This function should return a transformation matrix (with translation and
	 * rotation, no scaling) overlaying triangle V on U Assumed is that the
	 * triangles are indeed the same and the order of the vertices is also the
	 * same (shifts are not allowed) This function can probably be optimized for
	 * speed and also the LOC can probably be reduced
	 * 
	 * @param originalV1
	 * @param originalV2
	 * @param originalV3
	 * @param u1
	 * @param u2
	 * @param u3
	 * @return
	 */
	private static float[] getTransformationMatrix(float[] originalV1, float[] originalV2, float[] originalV3, float[] u1, float[] u2, float[] u3, float maxDiff) {
		float[] v1 = copy(originalV1);
		float[] v2 = copy(originalV2);
		float[] v3 = copy(originalV3);
		u1 = copy(u1);
		u2 = copy(u2);
		u3 = copy(u3);

		float transX = u1[0] - v1[0];
		float transY = u1[1] - v1[1];
		float transZ = u1[2] - v1[2];

		float translation[] = new float[16];
		Matrix.setIdentityM(translation, 0);
		Matrix.translateM(translation, 0, u1[0], u1[1], u1[2]);

		float[] toZeroTranslation = new float[16];
		Matrix.setIdentityM(toZeroTranslation, 0);
		Matrix.translateM(toZeroTranslation, 0, -v1[0], -v1[1], -v1[2]);

		if (almostTheSame(v2[0] + transX, u2[0], maxDiff) && almostTheSame(v2[1] + transY, u2[1], maxDiff) && almostTheSame(v2[2] + transZ, u2[2], maxDiff)
				&& almostTheSame(v3[0] + transX, u3[0], maxDiff) && almostTheSame(v3[1] + transY, u3[1], maxDiff) && almostTheSame(v3[2] + transZ, u3[2], maxDiff)) {
			// The other two points are already the same, to there was no
			// rotation
			return translation;
		}

		// Normalize both triangles to their first vertex
		subtract(u2, u1);
		subtract(u3, u1);
		subtract(u1, u1);

		subtract(v2, v1);
		subtract(v3, v1);
		subtract(v1, v1);

		float[] u2CrossV2 = Vector.crossProduct(u2, v2);
		float[] r2 = new float[16];
		Matrix.setIdentityM(r2, 0);
		float[] r2v2 = new float[4];
		if (!equalsAlmost(u2, v2, maxDiff)) {
			float u2InV2 = Vector.dot(u2, v2);
			float[] axis = u2CrossV2;
			if (axis[0] == 0 && axis[1] == 0 && axis[2] == 0) {
				axis = new float[] { u2[1], -u2[0], 0, 0 };
			}
			Matrix.rotateM(r2, 0, (float) Math.toDegrees(Math.atan2(Vector.length(u2CrossV2), u2InV2)), axis[0], axis[1], axis[2]);

			Matrix.multiplyMV(r2v2, 0, r2, 0, new float[] { v2[0], v2[1], v2[2], 1 }, 0);

			if (!equalsAlmost(r2v2, u2, maxDiff)) {
				Matrix.setIdentityM(r2, 0);
				Matrix.rotateM(r2, 0, -(float) Math.toDegrees(Math.atan2(Vector.length(u2CrossV2), u2InV2)), axis[0], axis[1], axis[2]);
				Matrix.multiplyMV(r2v2, 0, r2, 0, new float[] { v2[0], v2[1], v2[2], 1 }, 0);
				if (!equalsAlmost(r2v2, u2, maxDiff)) {
					return null;
				}
			}
		} else {
			r2v2 = copy(v2);
		}

		float[] r2v3 = new float[4];
		Matrix.multiplyMV(r2v3, 0, r2, 0, new float[] { v3[0], v3[1], v3[2], 1 }, 0);

		float[] r3 = new float[16];
		Matrix.setIdentityM(r3, 0);

		float angleDegrees = (float) Math.toDegrees(getPlaneAngle(v1, r2v2, r2v3, u1, u2, u3));

		Matrix.rotateM(r3, 0, angleDegrees, r2v2[0], r2v2[1], r2v2[2]);

		float[] r3v3 = new float[4];
		Matrix.multiplyMV(r3v3, 0, r3, 0, new float[] { r2v3[0], r2v3[1], r2v3[2], 1 }, 0);

		float[] r2v1 = new float[4];
		Matrix.multiplyMV(r2v1, 0, r2, 0, new float[] { v1[0], v1[1], v1[2], 1 }, 0);

		float[] r3v1 = new float[4];
		Matrix.multiplyMV(r3v1, 0, r3, 0, new float[] { r2v1[0], r2v1[1], r2v1[2], 1 }, 0);

		if (!equalsAlmost(r3v3, u3, maxDiff)) {
			Matrix.setIdentityM(r3, 0);
			Matrix.rotateM(r3, 0, -angleDegrees, r2v2[0], r2v2[1], r2v2[2]);
			Matrix.multiplyMV(r3v3, 0, r3, 0, new float[] { r2v3[0], r2v3[1], r2v3[2], 1 }, 0);
			float[] r3v2 = new float[4];
			Matrix.multiplyMV(r3v2, 0, r3, 0, new float[] { r2v2[0], r2v2[1], r2v2[2], 1 }, 0);
			if (!equalsAlmost(r3v3, u3, maxDiff) || !equalsAlmost(r3v2, u2, maxDiff)) {
				return null;
			}
		}
		float[] subResult = new float[16];
		float[] subResult2 = new float[16];
		float[] subResult3 = new float[16];
		float[] totalResult = new float[16];
		float[] startMatrix = new float[16];
		Matrix.setIdentityM(startMatrix, 0);

		Matrix.multiplyMM(subResult, 0, toZeroTranslation, 0, startMatrix, 0);
		Matrix.multiplyMM(subResult2, 0, r2, 0, subResult, 0);
		Matrix.multiplyMM(subResult3, 0, r3, 0, subResult2, 0);
		Matrix.multiplyMM(totalResult, 0, translation, 0, subResult3, 0);

		return totalResult;
	}

	/**
	 * Get the angle in radians between two planes
	 * 
	 * @param v1
	 * @param v2
	 * @param v3
	 * @param u1
	 * @param u2
	 * @param u3
	 * @return
	 */
	private static double getPlaneAngle(float[] v1, float[] v2, float[] v3, float[] u1, float[] u2, float[] u3) {
		float[] cross1 = Vector.crossProduct(new float[] { v2[0] - v1[0], v2[1] - v1[1], v2[2] - v1[2] }, new float[] { v3[0] - v1[0], v3[1] - v1[1], v3[2] - v1[2] });
		float[] cross2 = Vector.crossProduct(new float[] { u2[0] - u1[0], u2[1] - u1[1], u2[2] - u1[2] }, new float[] { u3[0] - u1[0], u3[1] - u1[1], u3[2] - u1[2] });

		float num = Vector.dot(cross1, cross2);
		float den = Vector.length(cross1) * Vector.length(cross2);

		float a = num / den;
		if (a > 1) {
			a = 1;
		}
		if (a < -1) {
			a = -1;
		}
		double result = Math.acos(a);

		if (Double.isNaN(result)) {
			System.out.println();
		}
		return result;
	}

	private static boolean equalsAlmost(float[] r2v2, float[] u2, float maxDiff) {
		for (int i = 0; i < 3; i++) {
			if (!almostTheSame(r2v2[i], u2[i], maxDiff)) {
				return false;
			}
		}
		return true;
	}

	private static float[] copy(float[] v1) {
		float[] result = new float[v1.length];
		System.arraycopy(v1, 0, result, 0, v1.length);
		return result;
	}

	private static boolean test(float[] v1, float[] v2, float[] transformationMatrix, float maxDiff) {
		float[] resultVector = new float[4];
		Matrix.multiplyMV(resultVector, 0, transformationMatrix, 0, new float[] { v1[0], v1[1], v1[2], 1 }, 0);
		normalize(resultVector);
		boolean theSame = true;
		for (int i = 0; i < 3; i++) {
			if (!almostTheSame(resultVector[i], v2[i], maxDiff)) {
				theSame = false;
			}
		}
		if (!theSame) {
			System.out.println("Difference");
			Vector.dump("Was", v1);
			Vector.dump("Became", resultVector);
			Vector.dump("Should be", v2);
			System.out.println();
			return false;
		}
		return true;
	}

	private static void normalize(float[] resultVector) {
		resultVector[0] = resultVector[0] * resultVector[3];
		resultVector[1] = resultVector[1] * resultVector[3];
		resultVector[2] = resultVector[2] * resultVector[3];
		resultVector[3] = 1;
	}

	private static void subtract(float[] u2, float[] v1) {
		u2[0] = u2[0] - v1[0];
		u2[1] = u2[1] - v1[1];
		u2[2] = u2[2] - v1[2];
	}

	public static void main(String[] args) {
		float maxDiff = 0.1f;

		test1(maxDiff);
		test2(maxDiff);

		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			float[] matrix = new float[16];
			Matrix.setIdentityM(matrix, 0);
			for (int j = 0; j < 10; j++) {
				Matrix.rotateM(matrix, 0, random.nextFloat() * 360, random.nextFloat(), random.nextFloat(), random.nextFloat());
			}

			float[] v1 = new float[] { random.nextFloat(), random.nextFloat(), random.nextFloat(), 1 };
			float[] v2 = new float[] { random.nextFloat(), random.nextFloat(), random.nextFloat(), 1 };
			float[] v3 = new float[] { random.nextFloat(), random.nextFloat(), random.nextFloat(), 1 };
			float[] r1 = new float[4];
			float[] r2 = new float[4];
			float[] r3 = new float[4];
			Matrix.multiplyMV(r1, 0, matrix, 0, v1, 0);
			Matrix.multiplyMV(r2, 0, matrix, 0, v2, 0);
			Matrix.multiplyMV(r3, 0, matrix, 0, v3, 0);

			float[] calculatedMatrix = getTransformationMatrix(v1, v2, v3, r1, r2, r3, maxDiff);

			test(v1, r1, calculatedMatrix, maxDiff);
			test(v2, r2, calculatedMatrix, maxDiff);
			test(v3, r3, calculatedMatrix, maxDiff);

			for (int j = 0; j < 10; j++) {
				float[] q1 = new float[] { random.nextFloat(), random.nextFloat(), random.nextFloat(), 1 };
				float[] q2 = new float[] { random.nextFloat(), random.nextFloat(), random.nextFloat(), 1 };
				float[] q3 = new float[] { random.nextFloat(), random.nextFloat(), random.nextFloat(), 1 };
				float[] b1 = new float[4];
				float[] b2 = new float[4];
				float[] b3 = new float[4];
				Matrix.multiplyMV(b1, 0, matrix, 0, q1, 0);
				Matrix.multiplyMV(b2, 0, matrix, 0, q2, 0);
				Matrix.multiplyMV(b3, 0, matrix, 0, q3, 0);

				test(q1, b1, calculatedMatrix, maxDiff);
				test(q2, b2, calculatedMatrix, maxDiff);
				test(q3, b3, calculatedMatrix, maxDiff);
			}
		}
	}

	private static void test1(float maxDiff) {
		float[] v1 = new float[] { 1, 2, 0 };
		float[] v2 = new float[] { 1, 1, 0 };
		float[] v3 = new float[] { 3, 2, 0 };
		float[] u1 = new float[] { 0, 2, 0 };
		float[] u2 = new float[] { -1, 2, 0 };
		float[] u3 = new float[] { 0, 2, 2 };

		float[] transformationMatrix = getTransformationMatrix(v1, v2, v3, u1, u2, u3, maxDiff);

		test(v1, u1, transformationMatrix, maxDiff);
		test(v2, u2, transformationMatrix, maxDiff);
		test(v3, u3, transformationMatrix, maxDiff);
	}

	private static void test2(float maxDiff) {
		float[] v1 = new float[] { 3, 0, 0 };
		float[] v2 = new float[] { 4, 0, 0 };
		float[] v3 = new float[] { 4, 1, 0 };
		float[] u1 = new float[] { 1, 3, 0 };
		float[] u2 = new float[] { 0, 3, 0 };
		float[] u3 = new float[] { 0, 2, 0 };

		float[] transformationMatrix = getTransformationMatrix(v1, v2, v3, u1, u2, u3, maxDiff);

		test(v1, u1, transformationMatrix, maxDiff);
		test(v2, u2, transformationMatrix, maxDiff);
		test(v3, u3, transformationMatrix, maxDiff);
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

	private Vector3f createVector3f(PackageMetaData packageMetaData, IfcModelInterface model, float defaultValue, DatabaseSession session, boolean store, int pid, int rid) throws BimserverDatabaseException, IfcModelInterfaceException {
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