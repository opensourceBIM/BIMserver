package org.bimserver;

/******************************************************************************
 * Copyright (C) 2009-2017  BIMserver.org
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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.actions.ProgressListener;
import org.bimserver.database.queries.QueryObjectProvider;
import org.bimserver.database.queries.om.Include;
import org.bimserver.database.queries.om.JsonQueryObjectModelConverter;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.Schema;
import org.bimserver.geometry.Matrix;
import org.bimserver.geometry.Vector;
import org.bimserver.models.geometry.GeometryPackage;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.store.RenderEnginePluginConfiguration;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSettings;
import org.bimserver.plugins.PluginConfiguration;
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
import org.bimserver.plugins.serializers.ObjectProvider;
import org.bimserver.plugins.serializers.OidConvertingSerializer;
import org.bimserver.plugins.serializers.StreamingSerializer;
import org.bimserver.plugins.serializers.StreamingSerializerPlugin;
import org.bimserver.renderengine.RenderEnginePool;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.HashMapWrappedVirtualObject;
import org.bimserver.shared.QueryContext;
import org.bimserver.shared.VirtualObject;
import org.bimserver.shared.WrappedVirtualObject;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.Formatters;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StreamingGeometryGenerator extends GenericGeometryGenerator {
	private static final Logger LOGGER = LoggerFactory.getLogger(StreamingGeometryGenerator.class);
	
	private final BimServer bimServer;
	private final Map<Integer, Long> hashes = new ConcurrentHashMap<>();

	private EClass productClass;
	private EStructuralFeature geometryFeature;
	private EStructuralFeature representationFeature;
	private PackageMetaData packageMetaData;

	private AtomicLong bytesSavedByHash = new AtomicLong();
	private AtomicLong bytesSavedByTransformation = new AtomicLong();
	private AtomicLong bytesSavedByMapping = new AtomicLong();
	private AtomicLong totalBytes = new AtomicLong();

	private AtomicInteger jobsDone = new AtomicInteger();
	private AtomicInteger jobsTotal = new AtomicInteger();

	private ProgressListener progressListener;

	private volatile boolean allJobsPushed;

	private int maxObjectsPerFile = 10;
	private volatile boolean running = true;

	private String debugIdentifier;

	private EStructuralFeature representationsFeature;

	private EStructuralFeature itemsFeature;

	private EStructuralFeature mappingSourceFeature;

	private String renderEngineName;

	private Long eoid = -1L;

	public StreamingGeometryGenerator(final BimServer bimServer, ProgressListener progressListener, Long eoid) {
		this.bimServer = bimServer;
		this.progressListener = progressListener;
		this.eoid = eoid;
	}
	
	public class Runner implements Runnable {

		private EClass eClass;
		private RenderEngineSettings renderEngineSettings;
		private RenderEngineFilter renderEngineFilter;
		private StreamingSerializerPlugin ifcSerializerPlugin;
		private GenerateGeometryResult generateGeometryResult;
		private ObjectProvider objectProvider;
		private QueryContext queryContext;
		private DatabaseSession databaseSession;
		private RenderEnginePool renderEnginePool;
		private boolean geometryReused;
		private Map<Long, ProductDef> map;

		public Runner(EClass eClass, RenderEnginePool renderEnginePool, DatabaseSession databaseSession, RenderEngineSettings renderEngineSettings, ObjectProvider objectProvider, StreamingSerializerPlugin ifcSerializerPlugin, RenderEngineFilter renderEngineFilter, GenerateGeometryResult generateGeometryResult, QueryContext queryContext, Query originalQuery, boolean geometryReused, Map<Long, ProductDef> map) {
			this.eClass = eClass;
			this.renderEnginePool = renderEnginePool;
			this.databaseSession = databaseSession;
			this.renderEngineSettings = renderEngineSettings;
			this.objectProvider = objectProvider;
			this.ifcSerializerPlugin = ifcSerializerPlugin;
			this.renderEngineFilter = renderEngineFilter;
			this.generateGeometryResult = generateGeometryResult;
			this.queryContext = queryContext;
			this.geometryReused = geometryReused;
			this.map = map;
		}

		@Override
		public void run() {
			try {
				HashMapVirtualObject next = objectProvider.next();
				Query query = new Query("Double buffer query " + eClass.getName(), packageMetaData);
				QueryPart queryPart = query.createQueryPart();
				while (next != null) {
					queryPart.addOid(next.getOid());
	//						for (EReference eReference : next.eClass().getEAllReferences()) {
	//							Object ref = next.eGet(eReference);
	//							if (ref != null) {
	//								if (eReference.isMany()) {
	//									List<?> list = (List<?>)ref;
	//									int index = 0;
	//									for (Object o : list) {
	//										if (o != null) {
	//											if (o instanceof Long) {
	//												if (next.useFeatureForSerialization(eReference, index)) {
	//													queryPart.addOid((Long)o);
	//												}
	//											}
	//										} else {
	//											System.out.println();
	//										}
	//										index++;
	//									}
	//								} else {
	//									if (ref instanceof Long) {
	//										if (next.useFeatureForSerialization(eReference)) {
	//											queryPart.addOid((Long)ref);
	//										}
	//									}
	//								}
	//							}
	//						}
					next = objectProvider.next();
				}
				
				objectProvider = new QueryObjectProvider(databaseSession, bimServer, query, Collections.singleton(queryContext.getRoid()), packageMetaData);
	
				StreamingSerializer ifcSerializer = ifcSerializerPlugin.createSerializer(new PluginConfiguration());
				RenderEngine renderEngine = null;
				byte[] bytes = null;
				try {
					final Set<HashMapVirtualObject> objects = new HashSet<>();
					ObjectProviderProxy proxy = new ObjectProviderProxy(objectProvider, new ObjectListener() {
						@Override
						public void newObject(HashMapVirtualObject next) {
							if (eClass.isSuperTypeOf(next.eClass())) {
								if (next.eGet(representationFeature) != null) {
									objects.add(next);
								}
							}
						}
					});
					ifcSerializer.init(proxy, null, null, bimServer.getPluginManager(), packageMetaData);
	
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					IOUtils.copy(ifcSerializer.getInputStream(), baos);
					bytes = baos.toByteArray();
					InputStream in = new ByteArrayInputStream(bytes);
					Map<Integer, String> notFoundObjects = new HashMap<>();
					
					Set<Range> reusableGeometryData = new HashSet<>();
					
					Map<Long, Q> productToData = new HashMap<>();
					try {
						if (!objects.isEmpty()) {
							renderEngine = renderEnginePool.borrowObject();
							try (RenderEngineModel renderEngineModel = renderEngine.openModel(in, bytes.length)) {
								renderEngineModel.setSettings(renderEngineSettings);
								renderEngineModel.setFilter(renderEngineFilter);
		
								try {
									renderEngineModel.generateGeneralGeometry();
								} catch (RenderEngineException e) {
									if (e.getCause() instanceof java.io.EOFException) {
										if (objects.isEmpty() || eClass.getName().equals("IfcAnnotation")) {
											// SKIP
										} else {
											LOGGER.error("Error in " + eClass.getName(), e);
										}
									}
								}
								
								OidConvertingSerializer oidConvertingSerializer = (OidConvertingSerializer)ifcSerializer;
								Map<Long, Integer> oidToEid = oidConvertingSerializer.getOidToEid();
								Map<Long, double[]> matrices = new HashMap<>();
								
								for (HashMapVirtualObject ifcProduct : objects) {
									if (!running) {
										return;
									}
									Integer expressId = oidToEid.get(ifcProduct.getOid());
									try {
										RenderEngineInstance renderEngineInstance = renderEngineModel.getInstanceFromExpressId(expressId);
										RenderEngineGeometry geometry = renderEngineInstance.generateGeometry();
										boolean translate = true;
	//									if (geometry == null || geometry.getIndices().length == 0) {
	//										LOGGER.info("Running again...");
	//										renderEngineModel.setFilter(renderEngineFilterTransformed);
	//										geometry = renderEngineInstance.generateGeometry();
	//										if (geometry != null) {
	//											translate = false;
	//										}
	//										renderEngineModel.setFilter(renderEngineFilter);
	//									}
										
										if (geometry != null && geometry.getNrIndices() > 0) {
											VirtualObject geometryInfo = new HashMapVirtualObject(queryContext, GeometryPackage.eINSTANCE.getGeometryInfo());
											
											WrappedVirtualObject minBounds = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getVector3f());
											WrappedVirtualObject maxBounds = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getVector3f());
											
											minBounds.set("x", Double.POSITIVE_INFINITY);
											minBounds.set("y", Double.POSITIVE_INFINITY);
											minBounds.set("z", Double.POSITIVE_INFINITY);
											
											maxBounds.set("x", -Double.POSITIVE_INFINITY);
											maxBounds.set("y", -Double.POSITIVE_INFINITY);
											maxBounds.set("z", -Double.POSITIVE_INFINITY);
											
											geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_MinBounds(), minBounds);
											geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_MaxBounds(), maxBounds);

											WrappedVirtualObject minBoundsUntranslated = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getVector3f());
											WrappedVirtualObject maxBoundsUntranslated = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getVector3f());

											minBoundsUntranslated.set("x", Double.POSITIVE_INFINITY);
											minBoundsUntranslated.set("y", Double.POSITIVE_INFINITY);
											minBoundsUntranslated.set("z", Double.POSITIVE_INFINITY);
											
											maxBoundsUntranslated.set("x", -Double.POSITIVE_INFINITY);
											maxBoundsUntranslated.set("y", -Double.POSITIVE_INFINITY);
											maxBoundsUntranslated.set("z", -Double.POSITIVE_INFINITY);
											
											geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_MinBoundsUntranslated(), minBoundsUntranslated);
											geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_MaxBoundsUntranslated(), maxBoundsUntranslated);
											
											geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_Area(), renderEngineInstance.getArea());
											geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_Volume(), renderEngineInstance.getVolume());
											
											VirtualObject geometryData = new HashMapVirtualObject(queryContext, GeometryPackage.eINSTANCE.getGeometryData());
	
											int[] indices = geometry.getIndices();
											geometryData.setAttribute(GeometryPackage.eINSTANCE.getGeometryData_Indices(), intArrayToByteArray(indices));
											float[] vertices = geometry.getVertices();
											geometryData.setAttribute(GeometryPackage.eINSTANCE.getGeometryData_Vertices(), floatArrayToByteArray(vertices));
											geometryData.setAttribute(GeometryPackage.eINSTANCE.getGeometryData_Normals(), floatArrayToByteArray(geometry.getNormals()));
											
											geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_PrimitiveCount(), indices.length / 3);

											Set<Color4f> usedColors = new HashSet<>();
											
											if (geometry.getMaterialIndices() != null && geometry.getMaterialIndices().length > 0) {
												boolean hasMaterial = false;
												float[] vertex_colors = new float[vertices.length / 3 * 4];
												for (int i = 0; i < geometry.getMaterialIndices().length; ++i) {
													int c = geometry.getMaterialIndices()[i];
													for (int j = 0; j < 3; ++j) {
														int k = indices[i * 3 + j];
														if (c > -1) {
															hasMaterial = true;
															Color4f color = new Color4f();
															for (int l = 0; l < 4; ++l) {
																float val = geometry.getMaterials()[4 * c + l];
																vertex_colors[4 * k + l] = val;
																color.set(l, val);
															}
															usedColors.add(color);
														}
													}
												}
												if (usedColors.size() == 1) {
													WrappedVirtualObject color = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getVector4f());
													Color4f firstColor = usedColors.iterator().next();
													color.set("x", firstColor.getR());
													color.set("y", firstColor.getG());
													color.set("z", firstColor.getB());
													color.set("w", firstColor.getA());
													geometryData.setAttribute(GeometryPackage.eINSTANCE.getGeometryData_Color(), color);
													hasMaterial = false;
												}
												if (hasMaterial) {
													geometryData.setAttribute(GeometryPackage.eINSTANCE.getGeometryData_Materials(), floatArrayToByteArray(vertex_colors));
												}
											}
	
											double[] productTranformationMatrix = new double[16];
											if (translate && renderEngineInstance.getTransformationMatrix() != null) {
												productTranformationMatrix = renderEngineInstance.getTransformationMatrix();
											} else {
												Matrix.setIdentityM(productTranformationMatrix, 0);
											}

											geometryInfo.setReference(GeometryPackage.eINSTANCE.getGeometryInfo_Data(), geometryData.getOid(), 0);
	
											long size = getSize(geometryData);
											
											for (int i = 0; i < indices.length; i++) {
												processExtends(geometryInfo, productTranformationMatrix, vertices, indices[i] * 3, generateGeometryResult);
												processExtendsUntranslated(geometryInfo, vertices, indices[i] * 3, generateGeometryResult);
											}
											
											double[] mibu = new double[]{(double) minBoundsUntranslated.eGet(GeometryPackage.eINSTANCE.getVector3f_X()), (double) minBoundsUntranslated.eGet(GeometryPackage.eINSTANCE.getVector3f_Y()), (double) minBoundsUntranslated.eGet(GeometryPackage.eINSTANCE.getVector3f_Z()), 1d};
											double[] mabu = new double[]{(double) maxBoundsUntranslated.eGet(GeometryPackage.eINSTANCE.getVector3f_X()), (double) maxBoundsUntranslated.eGet(GeometryPackage.eINSTANCE.getVector3f_Y()), (double) maxBoundsUntranslated.eGet(GeometryPackage.eINSTANCE.getVector3f_Z()), 1d};
											
											if (bimServer.getServerSettingsCache().getServerSettings().isReuseGeometry()) {
												int hash = hash(geometryData);
												float[] firstVertex = new float[]{vertices[indices[0]], vertices[indices[0] + 1], vertices[indices[0] + 2]};
												float[] lastVertex = new float[]{vertices[indices[indices.length-1] * 3], vertices[indices[indices.length-1] * 3 + 1], vertices[indices[indices.length-1] * 3 + 2]};
												Range range = new Range(firstVertex, lastVertex);
												if (hashes.containsKey(hash)) {
													geometryInfo.setReference(GeometryPackage.eINSTANCE.getGeometryInfo_Data(), hashes.get(hash), 0);
													bytesSavedByHash.addAndGet(size);
												} else if (geometryReused) {
													boolean found = false;
//													for (Range r : reusableGeometryData) {
//														if (r.isSimilar(range)) {
//															geometryInfo.setReference(GeometryPackage.eINSTANCE.getGeometryInfo_Data(), r.getGeometryDataOid(), 0);
//															float[] offset = r.getOffset(range);
//															ProductDef productDef = map.get(ifcProduct.getOid());
//															double[] mappedItemMatrix = null;
//															if (productDef != null && productDef.getMatrix() != null) {
//																mappedItemMatrix = productDef.getMatrix();
//															} else {
//																Matrix.translateM(mappedItemMatrix, 0, offset[0], offset[1], offset[2]);
//															}
//															double[] result = new double[16];
//															Matrix.multiplyMM(result, 0, mappedItemMatrix, 0, productTranformationMatrix, 0);
//															setTransformationMatrix(geometryInfo, result); // Overwritten?
//															bytesSavedByTransformation.addAndGet(size);
//															found = true;
//															break;
//														}
//													}
													if (!found) {
														range.setGeometryDataOid(geometryData.getOid());
														reusableGeometryData.add(range);
														
														geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_Area(), renderEngineInstance.getArea());
														geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_Volume(), renderEngineInstance.getVolume());
														geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_PrimitiveCount(), indices.length / 3);
														
														productToData.put(ifcProduct.getOid(), new Q(geometryData.getOid(), renderEngineInstance.getArea(), renderEngineInstance.getVolume(), indices.length / 3, size, mibu, mabu));
														geometryData.save();
													}
												} else {
	//												if (sizes.containsKey(size) && sizes.get(size).eClass() == ifcProduct.eClass()) {
	//													LOGGER.info("More reuse might be possible " + size + " " + ifcProduct.eClass().getName() + ":" + ifcProduct.getOid() + " / " + sizes.get(size).eClass().getName() + ":" + sizes.get(size).getOid());
	//												}
													if (geometryReused) {
														range.setGeometryDataOid(geometryData.getOid());
														reusableGeometryData.add(range);
														productToData.put(ifcProduct.getOid(), new Q(geometryData.getOid(), renderEngineInstance.getArea(), renderEngineInstance.getVolume(), indices.length / 3, size, mibu, mabu));
													}
													hashes.put(hash, geometryData.getOid());
													geometryData.save();
	//												sizes.put(size, ifcProduct);
												}
											} else {
												geometryData.save();
											}

											calculateObb(geometryInfo, productTranformationMatrix, indices, vertices, generateGeometryResult);
											setTransformationMatrix(geometryInfo, productTranformationMatrix);
											matrices.put(ifcProduct.getOid(), productTranformationMatrix);
											
											geometryInfo.save();
											totalBytes.addAndGet(size);
	
											ifcProduct.setReference(geometryFeature, geometryInfo.getOid(), 0);
											ifcProduct.saveOverwrite();
											
											// Doing a sync here because probably writing large amounts of data, and db only syncs every 100.000 writes by default
//											databaseSession.getKeyValueStore().sync();
										} else {
											// TODO
										}
									} catch (EntityNotFoundException e) {
	//									e.printStackTrace();
										// As soon as we find a representation that is not Curve2D, then we should show a "INFO" message in the log to indicate there could be something wrong
										boolean ignoreNotFound = eClass.getName().equals("IfcAnnotation");
										
	//									for (Object rep : representations) {
	//										if (rep instanceof IfcShapeRepresentation) {
	//											IfcShapeRepresentation ifcShapeRepresentation = (IfcShapeRepresentation)rep;
	//											if (!"Curve2D".equals(ifcShapeRepresentation.getRepresentationType())) {
	//												ignoreNotFound = false;
	//											}
	//										}
	//									}
										if (!ignoreNotFound) {
//											LOGGER.warn("Entity not found " + ifcProduct.eClass().getName() + " " + (expressId) + "/" + ifcProduct.getOid());
											notFoundObjects.put(expressId, ifcProduct.eClass().getName());
										}
									} catch (BimserverDatabaseException | RenderEngineException e) {
										LOGGER.error("", e);
									}
								}
								
								if (geometryReused && map != null) {
									long firstKey = map.keySet().iterator().next();
									ProductDef masterProductDef = map.get(firstKey);
									for (long key : map.keySet()) {
										if (key != firstKey) {
											ProductDef productDef = map.get(key);
											HashMapVirtualObject ifcProduct = productDef.getObject();
											
											Q q = productToData.get(productDef.getMasterOid());
											if (q != null) {
												VirtualObject geometryInfo = new HashMapVirtualObject(queryContext, GeometryPackage.eINSTANCE.getGeometryInfo());
												
												WrappedVirtualObject minBounds = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getVector3f());
												WrappedVirtualObject maxBounds = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getVector3f());
												
												double[] mibu = q.getMibu();
												double[] mabu = q.getMibu();
												
												double[] mibt = new double[4];
												double[] mabt = new double[4];
												
												// TODO
												Matrix.multiplyMV(mibt, 0, productDef.getProductMatrix(), 0, mibu, 0);
												Matrix.multiplyMV(mabt, 0, productDef.getProductMatrix(), 0, mabu, 0);
												
												minBounds.set("x", mibt[0]);
												minBounds.set("y", mibt[1]);
												minBounds.set("z", mibt[2]);
												
												maxBounds.set("x", mabt[0]);
												maxBounds.set("y", mabt[1]);
												maxBounds.set("z", mabt[2]);
												
												geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_MinBounds(), minBounds);
												geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_MaxBounds(), maxBounds);
												
												WrappedVirtualObject minBoundsUntranslated = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getVector3f());
												WrappedVirtualObject maxBoundsUntranslated = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getVector3f());
												
												minBoundsUntranslated.set("x", mibu[0]);
												minBoundsUntranslated.set("y", mibu[1]);
												minBoundsUntranslated.set("z", mibu[2]);
												
												maxBoundsUntranslated.set("x", mabu[0]);
												maxBoundsUntranslated.set("y", mabu[1]);
												maxBoundsUntranslated.set("z", mabu[2]);
												
												geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_MinBoundsUntranslated(), minBoundsUntranslated);
												geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_MaxBoundsUntranslated(), maxBoundsUntranslated);
												
												geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_Area(), q.getArea());
												geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_Volume(), q.getVolume());
												geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_PrimitiveCount(), q.getNrPrimitives());
												
												bytesSavedByMapping.addAndGet(q.getSize());
												totalBytes.addAndGet(q.getSize());
												
												double[] inverted = Matrix.identity();
												if (!Matrix.invertM(inverted, 0, masterProductDef.getMappingMatrix(), 0)) {
													System.out.println("No inverse");
												}
												
												double[] finalMatrix = Matrix.identity();
												double[] totalTranformationMatrix = Matrix.identity();
												Matrix.multiplyMM(finalMatrix, 0, productDef.getMappingMatrix(), 0, inverted, 0);
												Matrix.multiplyMM(totalTranformationMatrix, 0, productDef.getProductMatrix(), 0, finalMatrix, 0);
												
												if (matrices.containsKey(ifcProduct.getOid())) {
													if (!Arrays.equals(matrices.get(ifcProduct.getOid()), totalTranformationMatrix)) {
														System.out.println("Not the same " + ifcProduct.get("GlobalId"));
														Matrix.dump(matrices.get(ifcProduct.getOid()));
														System.out.println();
														Matrix.dump(totalTranformationMatrix);
													}
												}
												
												geometryInfo.setReference(GeometryPackage.eINSTANCE.getGeometryInfo_Data(), q.getOid(), 0);
												
//											for (int i = 0; i < indices.length; i++) {
//												processExtends(geometryInfo, productTranformationMatrix, vertices, indices[i] * 3, generateGeometryResult);
//												processExtendsUntranslated(geometryInfo, vertices, indices[i] * 3, generateGeometryResult);
//											}
												
//											calculateObb(geometryInfo, productTranformationMatrix, indices, vertices, generateGeometryResult);
												setTransformationMatrix(geometryInfo, totalTranformationMatrix);
												
												geometryInfo.save();
//											totalBytes.addAndGet(size);
												
												ifcProduct.setReference(geometryFeature, geometryInfo.getOid(), 0);
												ifcProduct.saveOverwrite();
											}
										}
									}
								}
							}
						}
					} finally {
						try {
							if (!notFoundObjects.isEmpty()) {
								writeDebugFile(bytes, false, notFoundObjects);
							}
							in.close();
						} catch (Throwable e) {
							
						}
						if (renderEngine != null) {
							renderEnginePool.returnObject(renderEngine);
						}
						jobsDone.incrementAndGet();
						updateProgress();
					}
				} catch (Exception e) {
					LOGGER.error("", e);
					writeDebugFile(bytes, true, null);
//					LOGGER.error("Original query: " + originalQuery, e);
				}
			} catch (Exception e) {
				LOGGER.error("", e);
//				LOGGER.error("Original query: " + originalQuery, e);
			}
		}

		private void writeDebugFile(byte[] bytes, boolean error, Map<Integer, String> notFoundObjects) throws FileNotFoundException, IOException {
			boolean debug = true;
			if (debug) {
				Path debugPath = bimServer.getHomeDir().resolve("debug");
				if (!Files.exists(debugPath)) {
					Files.createDirectories(debugPath);
				}

				Path folder = debugPath.resolve(debugIdentifier);
				if (!Files.exists(folder)) {
					Files.createDirectories(folder);
				}
				
				String basefilenamename = "all";
				if (eClass != null) {
					basefilenamename = eClass.getName();
				}
				if (error) {
					basefilenamename += "-error";
				}

				Path file = folder.resolve(basefilenamename + ".ifc");
				int i=0;
				while (Files.exists((file))) {
					file = folder.resolve(basefilenamename + "-" + i + ".ifc");
					i++;
				}

				if (notFoundObjects != null) {
					StringBuilder sb = new StringBuilder();
					for (Integer expressId : notFoundObjects.keySet()) {
						sb.append(notFoundObjects.get(expressId) + ": " + expressId + "\r\n");
					}
					FileUtils.writeStringToFile(Paths.get(file.toAbsolutePath().toString() + ".txt").toFile(), sb.toString());
				}

				LOGGER.info("Writing debug file to " + file.toAbsolutePath().toString());
				FileUtils.writeByteArrayToFile(file.toFile(), bytes);
			}
		}

		private void calculateObb(VirtualObject geometryInfo, double[] tranformationMatrix, int[] indices, float[] vertices, GenerateGeometryResult generateGeometryResult2) {
			
		}
	}

	private void updateProgress() {
		if (allJobsPushed) {
			if (progressListener != null) {
				progressListener.updateProgress("Generating geometry...", (int) (100.0 * jobsDone.get() / jobsTotal.get()));
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public GenerateGeometryResult generateGeometry(long uoid, final DatabaseSession databaseSession, QueryContext queryContext) throws BimserverDatabaseException, GeometryGeneratingException {
		GenerateGeometryResult generateGeometryResult = new GenerateGeometryResult();
		packageMetaData = queryContext.getPackageMetaData();
		productClass = packageMetaData.getEClass("IfcProduct");
		geometryFeature = productClass.getEStructuralFeature("geometry");
		representationFeature = productClass.getEStructuralFeature("Representation");
		representationsFeature = packageMetaData.getEClass("IfcProductDefinitionShape").getEStructuralFeature("Representations");
		itemsFeature = packageMetaData.getEClass("IfcShapeRepresentation").getEStructuralFeature("Items");
		mappingSourceFeature = packageMetaData.getEClass("IfcMappedItem").getEStructuralFeature("MappingSource");

		GregorianCalendar now = new GregorianCalendar();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		debugIdentifier = dateFormat.format(now.getTime());

		long start = System.nanoTime();
		String pluginName = "";
		if (queryContext.getPackageMetaData().getSchema() == Schema.IFC4) {
			pluginName = "org.bimserver.ifc.step.serializer.Ifc4StepStreamingSerializerPlugin";
		} else if (queryContext.getPackageMetaData().getSchema() == Schema.IFC2X3TC1) {
			pluginName = "org.bimserver.ifc.step.serializer.Ifc2x3tc1StepStreamingSerializerPlugin";
		}

		try {
			final StreamingSerializerPlugin ifcSerializerPlugin = (StreamingSerializerPlugin) bimServer.getPluginManager().getPlugin(pluginName, true);
			if (ifcSerializerPlugin == null) {
				throw new UserException("No IFC serializer found");
			}

			User user = (User) databaseSession.get(uoid, org.bimserver.database.OldQuery.getDefault());
			UserSettings userSettings = user.getUserSettings();
			
			RenderEnginePluginConfiguration renderEngine = null;
			if (eoid != -1) {
				renderEngine = databaseSession.get(eoid, OldQuery.getDefault());
			} else {
				renderEngine = userSettings.getDefaultRenderEngine();
			}
			if (renderEngine == null) {
				throw new UserException("No default render engine has been selected for this user");
			}
			renderEngineName = renderEngine.getName();

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

			RenderEnginePool renderEnginePool = bimServer.getRenderEnginePools().getRenderEnginePool(packageMetaData.getSchema(), renderEngine.getPluginDescriptor().getPluginClassName(), new PluginConfiguration(renderEngine.getSettings()));
			
			ThreadPoolExecutor executor = new ThreadPoolExecutor(maxSimultanousThreads, maxSimultanousThreads, 24, TimeUnit.HOURS, new ArrayBlockingQueue<Runnable>(10000000));

			JsonQueryObjectModelConverter jsonQueryObjectModelConverter = new JsonQueryObjectModelConverter(packageMetaData);
			String queryNameSpace = "validifc";
			if (packageMetaData.getSchema() == Schema.IFC4) {
				queryNameSpace = "ifc4stdlib";
			}
			
			Include objectPlacement = jsonQueryObjectModelConverter.getDefineFromFile(queryNameSpace + ":ObjectPlacement");
			// TODO these are cached, so f'ing em up by doing this...
			objectPlacement.makeDirectRecursive(new HashSet<>());

			Set<EClass> classes = null;
			if (queryContext.getOidCounters() != null) {
				classes = queryContext.getOidCounters().keySet();
			} else {
				classes = packageMetaData.getEClasses();
			}
			for (EClass eClass : classes) {
				if (packageMetaData.getEClass("IfcProduct").isSuperTypeOf(eClass)) {
					Query query2 = new Query(eClass.getName() + "Main query", packageMetaData);
					QueryPart queryPart2 = query2.createQueryPart();
					queryPart2.addType(eClass, false);
					Include representationInclude = queryPart2.createInclude();
					representationInclude.addType(eClass, false);
					representationInclude.addFieldDirect("Representation");
					Include representationsInclude = representationInclude.createInclude();
					representationsInclude.addType(Ifc2x3tc1Package.eINSTANCE.getIfcProductRepresentation(), true);
					representationsInclude.addFieldDirect("Representations");
					Include itemsInclude = representationsInclude.createInclude();
					itemsInclude.addType(Ifc2x3tc1Package.eINSTANCE.getIfcShapeRepresentation(), false);
					itemsInclude.addFieldDirect("Items");
					Include mappingSourceInclude = itemsInclude.createInclude();
					mappingSourceInclude.addType(Ifc2x3tc1Package.eINSTANCE.getIfcMappedItem(), false);
					mappingSourceInclude.addFieldDirect("MappingSource");
					mappingSourceInclude.addFieldDirect("MappingTarget");
					Include representationMap = mappingSourceInclude.createInclude();
					representationMap.addType(Ifc2x3tc1Package.eINSTANCE.getIfcRepresentationMap(), false);
					Include targetInclude = mappingSourceInclude.createInclude();
					targetInclude.addType(Ifc2x3tc1Package.eINSTANCE.getIfcCartesianTransformationOperator3D(), false);
					targetInclude.addFieldDirect("Axis1");
					targetInclude.addFieldDirect("Axis2");
					targetInclude.addFieldDirect("Axis3");
					targetInclude.addFieldDirect("LocalOrigin");
					
					queryPart2.addInclude(objectPlacement);
					
					Map<Long, Map<Long, ProductDef>> representationMapToProduct = new HashMap<>();
					
					QueryObjectProvider queryObjectProvider2 = new QueryObjectProvider(databaseSession, bimServer, query2, Collections.singleton(queryContext.getRoid()), packageMetaData);
					HashMapVirtualObject next = queryObjectProvider2.next();
					while (next != null) {
						if (next.eClass() == eClass) {
							HashMapVirtualObject representation = next.getDirectFeature(representationFeature);
							if (representation != null) {
								List<HashMapVirtualObject> representations = representation.getDirectListFeature(representationsFeature);
								if (representations != null) {
									for (HashMapVirtualObject representationItem : representations) {
										if (representationItem.get("RepresentationIdentifier").equals("Body")) {
											List<HashMapVirtualObject> items = representationItem.getDirectListFeature(itemsFeature);
											for (HashMapVirtualObject item : items) {
												HashMapVirtualObject mappingTarget = item.getDirectFeature(Ifc2x3tc1Package.eINSTANCE.getIfcMappedItem_MappingTarget());
												double[] mappingMatrix = Matrix.identity();
												double[] productMatrix = Matrix.identity();
												if (mappingTarget != null) {
													HashMapVirtualObject axis1 = mappingTarget.getDirectFeature(Ifc2x3tc1Package.eINSTANCE.getIfcCartesianTransformationOperator_Axis1());
													HashMapVirtualObject axis2 = mappingTarget.getDirectFeature(Ifc2x3tc1Package.eINSTANCE.getIfcCartesianTransformationOperator_Axis2());
													HashMapVirtualObject axis3 = mappingTarget.getDirectFeature(Ifc2x3tc1Package.eINSTANCE.getIfcCartesianTransformationOperator3D_Axis3());
													HashMapVirtualObject localOrigin = mappingTarget.getDirectFeature(Ifc2x3tc1Package.eINSTANCE.getIfcCartesianTransformationOperator_LocalOrigin());
													
													double[] a1 = null;
													double[] a2 = null;
													double[] a3 = null;

													if (axis3 != null) {
														List<Double> list = (List<Double>) axis3.get("DirectionRatios");
														a3 = new double[]{list.get(0), list.get(1), list.get(2)};
													} else {
														a3 = new double[]{0, 0, 1, 1};
														Vector.normalize(a3);
													}

													if (axis1 != null) {
														List<Double> list = (List<Double>) axis1.get("DirectionRatios");
														a1 = new double[]{list.get(0), list.get(1), list.get(2)};
														Vector.normalize(a1);
													} else {
//														if (a3[0] == 1 && a3[1] == 0 && a3[2] == 0) {
															a1 = new double[]{1, 0, 0, 1};
//														} else {
//															a1 = new double[]{0, 1, 0, 1};
//														}
													}
													
													double[] xVec = Vector.scalarProduct(Vector.dot(a1, a3), a3);
										            double[] xAxis = Vector.subtract(a1, xVec);
										            Vector.normalize(xAxis);

										            if (axis2 != null) {
										            	List<Double> list = (List<Double>) axis2.get("DirectionRatios");
														a2 = new double[]{list.get(0), list.get(1), list.get(2)};
														Vector.normalize(a2);
										            } else {
										            	a2 = new double[]{0, 1, 0, 1};
										            }

										            double[] tmp = Vector.scalarProduct(Vector.dot(a2, a3), a3);
										            double[] yAxis = Vector.subtract(a2, tmp);
										            tmp = Vector.scalarProduct(Vector.dot(a2, xAxis), xAxis);
										            yAxis = Vector.subtract(yAxis, tmp);
										            Vector.normalize(yAxis);

										            a2 = yAxis;
										            a1 = xAxis;
													
													List<Double> t = (List<Double>)localOrigin.get("Coordinates");
													mappingMatrix = new double[]{
														a1[0], a1[1], a1[2], 0,
														a2[0], a2[1], a2[2], 0,
														a3[0], a3[1], a3[2], 0,
														t.get(0).doubleValue(), t.get(1).doubleValue(), t.get(2).doubleValue(), 1
													};
													
//													double[] inverted = new double[16];
//													Matrix.invertM(inverted, 0, mappingMatrix, 0);
//													mappingMatrix = inverted;
													
//													System.out.println(next.get("GlobalId"));
//													Matrix.dumpIfNotId(inverted);
													
//													mappingMatrix = Matrix.identity();
												}
												
												HashMapVirtualObject placement = next.getDirectFeature(Ifc2x3tc1Package.eINSTANCE.getIfcProduct_ObjectPlacement());
												if (placement != null) {
													productMatrix = placementToMatrix(placement);
												}
												
												HashMapVirtualObject mappingSource = item.getDirectFeature(mappingSourceFeature);
												if (mappingSource != null) {
													Map<Long, ProductDef> map = representationMapToProduct.get(mappingSource.getOid());
													if (map == null) {
														map = new LinkedHashMap<>();
														representationMapToProduct.put(mappingSource.getOid(), map);
													}
													ProductDef pd = new ProductDef(next.getOid());
													pd.setObject(next);
													
//													double[] finalMatrix = Matrix.identity();
//													if (next.get("GlobalId").equals("1jYD9F3rxYJRnz0YM$R3YY")) {
//														Matrix.dump(productMatrix);
//														Matrix.dump(mappingMatrix);
//														System.out.println();
//													}
//													Matrix.multiplyMM(finalMatrix, 0, productMatrix, 0, mappingMatrix, 0);
													
//													Matrix.dumpIfNotId(finalMatrix);
													
													pd.setProductMatrix(productMatrix);
													pd.setMappingMatrix(mappingMatrix);
													map.put(next.getOid(), pd);
												}
											}
										}
									}
								}
							}
						}
						next = queryObjectProvider2.next();
					}
					
					Set<Long> done = new HashSet<>();
					
					for (Long repMapId : representationMapToProduct.keySet()) {
						Map<Long, ProductDef> map = representationMapToProduct.get(repMapId);
						
						if (map.size() > 1) {
							Query query = new Query("Reuse query " + eClass.getName(), packageMetaData);
							QueryPart queryPart = query.createQueryPart();
							queryPart.addType(eClass, false);

							long masterOid = map.values().iterator().next().getOid();
							for (ProductDef pd : map.values()) {
								done.add(pd.getOid());
								pd.setMasterOid(masterOid);
							}
							queryPart.addOid(masterOid);
							
							LOGGER.debug("Running " + map.size() + " objects in one batch because of reused geometry " + (eClass.getName()));

							processX(databaseSession, queryContext, generateGeometryResult, ifcSerializerPlugin, settings, renderEngineFilter, renderEnginePool, executor, eClass, query, queryPart, true, map);
						}
					}
					
					Query query3 = new Query("Remaining " + eClass.getName(), packageMetaData);
					QueryPart queryPart3 = query3.createQueryPart();
					queryPart3.addType(eClass, false);
					Include include3 = queryPart3.createInclude();
					include3.addType(eClass, false);
					include3.addFieldDirect("Representation");
					Include rInclude = include3.createInclude();
					rInclude.addType(Ifc2x3tc1Package.eINSTANCE.getIfcProductRepresentation(), false);
					rInclude.addFieldDirect("Representations");
					Include representationsInclude2 = rInclude.createInclude();
					representationsInclude2.addType(Ifc2x3tc1Package.eINSTANCE.getIfcShapeModel(), false);
					
					queryObjectProvider2 = new QueryObjectProvider(databaseSession, bimServer, query3, Collections.singleton(queryContext.getRoid()), packageMetaData);
					next = queryObjectProvider2.next();
					while (next != null) {
						if (next.eClass() == eClass && !done.contains(next.getOid())) {
							HashMapVirtualObject representation = next.getDirectFeature(representationFeature);
							if (representation != null) {
								List<HashMapVirtualObject> list = representation.getDirectListFeature(Ifc2x3tc1Package.eINSTANCE.getIfcProductRepresentation_Representations());
								boolean goForIt = false;
								if (list != null) {
									for (HashMapVirtualObject o : list) {
										if (o.get("RepresentationIdentifier").equals("Body")) {
											goForIt = true;
										}
									}
								}
								if (goForIt) {
									Query query = new Query("Main " + eClass.getName(), packageMetaData);
									QueryPart queryPart = query.createQueryPart();
									queryPart.addType(eClass, false);
									int x = 0;
									queryPart.addOid(next.getOid());
									while (next != null && x < maxObjectsPerFile - 1) {
										next = queryObjectProvider2.next();
										if (next != null) {
											if (next.eClass() == eClass && !done.contains(next.getOid())) {
												representation = next.getDirectFeature(representationFeature);
												if (representation != null) {
													list = representation.getDirectListFeature(Ifc2x3tc1Package.eINSTANCE.getIfcProductRepresentation_Representations());
													boolean goForIt2 = false;
													if (list != null) {
														for (HashMapVirtualObject o : list) {
															if (o.get("RepresentationIdentifier").equals("Body")) {
																goForIt2 = true;
															}
														}
													}
													if (goForIt2) {
														queryPart.addOid(next.getOid());
														x++;
													}
												}
											}
										}
									}
									processX(databaseSession, queryContext, generateGeometryResult, ifcSerializerPlugin, settings, renderEngineFilter, renderEnginePool, executor, eClass, query, queryPart, false, null);
								}
							}
						}
						next = queryObjectProvider2.next();
					}
				}
			}
			
//			for (Long l : counters.keySet()) {
//				LOGGER.info(databaseSession.getEClassForOid(l).getName() + "(" + l + "): " + counters.get(l));
//			}
			
			allJobsPushed = true;
			
			executor.shutdown();
			executor.awaitTermination(24, TimeUnit.HOURS);

			long end = System.nanoTime();
			long total = totalBytes.get() - (bytesSavedByHash.get() + bytesSavedByTransformation.get() + bytesSavedByMapping.get());
			LOGGER.info("Rendertime: " + Formatters.nanosToString(end - start) + ", " + "Reused (by hash): " + Formatters.bytesToString(bytesSavedByHash.get()) + ", Reused (by transformation): " + Formatters.bytesToString(bytesSavedByTransformation.get()) + ", Reused (by mapping): " + Formatters.bytesToString(bytesSavedByMapping.get()) + ", Total: " + Formatters.bytesToString(totalBytes.get()) + ", Final: " + Formatters.bytesToString(total));
		} catch (Exception e) {
			running = false;
			LOGGER.error("", e);
			throw new GeometryGeneratingException(e);
		}
		return generateGeometryResult;
	}

	// Pretty sure this is working correctly
	@SuppressWarnings("unchecked")
	public double[] placement3DToMatrix(HashMapVirtualObject ifcAxis2Placement3D) {
		HashMapVirtualObject location = ifcAxis2Placement3D.getDirectFeature(Ifc2x3tc1Package.eINSTANCE.getIfcPlacement_Location());
		if (ifcAxis2Placement3D.getDirectFeature(Ifc2x3tc1Package.eINSTANCE.getIfcAxis2Placement3D_Axis()) != null && ifcAxis2Placement3D.getDirectFeature(Ifc2x3tc1Package.eINSTANCE.getIfcAxis2Placement3D_RefDirection()) != null) {
			HashMapVirtualObject axis = ifcAxis2Placement3D.getDirectFeature(Ifc2x3tc1Package.eINSTANCE.getIfcAxis2Placement3D_Axis());
			HashMapVirtualObject direction = ifcAxis2Placement3D.getDirectFeature(Ifc2x3tc1Package.eINSTANCE.getIfcAxis2Placement3D_RefDirection());
			List<Double> axisDirectionRatios = (List<Double>) axis.get("DirectionRatios");
			List<Double> directionDirectionRatios = (List<Double>) direction.get("DirectionRatios");
			List<Double> locationCoordinates = (List<Double>) location.get("Coordinates");
			double[] cross = Vector.crossProduct(new double[]{axisDirectionRatios.get(0), axisDirectionRatios.get(1), axisDirectionRatios.get(2), 1}, 
					new double[]{directionDirectionRatios.get(0), directionDirectionRatios.get(1), directionDirectionRatios.get(2), 1});
			return new double[]{
				directionDirectionRatios.get(0), directionDirectionRatios.get(1), directionDirectionRatios.get(2), 0,
				cross[0], cross[1], cross[2], 0,
				axisDirectionRatios.get(0), axisDirectionRatios.get(1), axisDirectionRatios.get(2), 0,
				locationCoordinates.get(0), locationCoordinates.get(1), locationCoordinates.get(2), 1
			};
		} else if (location != null) {
			List<Double> locationCoordinates = (List<Double>) location.get("Coordinates");
			return new double[]{
				1, 0, 0, 0,
				0, 1, 0, 0,
				0, 0, 1, 0,
				locationCoordinates.get(0), locationCoordinates.get(1), locationCoordinates.get(2), 1
			};
		}
		return Matrix.identity();
	}
	
	private double[] placementToMatrix(HashMapVirtualObject placement) {
		HashMapVirtualObject placementRelTo = placement.getDirectFeature(Ifc2x3tc1Package.eINSTANCE.getIfcLocalPlacement_PlacementRelTo());
		double[] matrix = Matrix.identity();
		if (placement.eClass().getName().equals("IfcLocalPlacement")) {
			HashMapVirtualObject relativePlacement = placement.getDirectFeature(Ifc2x3tc1Package.eINSTANCE.getIfcLocalPlacement_RelativePlacement());
			if (relativePlacement != null && relativePlacement.eClass().getName().equals("IfcAxis2Placement3D")) {
				matrix = placement3DToMatrix(relativePlacement);
			}
		}
		if (placementRelTo != null) {
			double[] baseMatrix = placementToMatrix(placementRelTo);
			double[] rhs = matrix;
			matrix = Matrix.identity();
			Matrix.multiplyMM(matrix, 0, baseMatrix, 0, rhs, 0);
		}
		return matrix;
	}

	private void processX(final DatabaseSession databaseSession, QueryContext queryContext, GenerateGeometryResult generateGeometryResult, final StreamingSerializerPlugin ifcSerializerPlugin, final RenderEngineSettings settings,
			final RenderEngineFilter renderEngineFilter, RenderEnginePool renderEnginePool, ThreadPoolExecutor executor, EClass eClass, Query query, QueryPart queryPart, boolean geometryReused, Map<Long, ProductDef> map) throws QueryException, IOException {
		JsonQueryObjectModelConverter jsonQueryObjectModelConverter = new JsonQueryObjectModelConverter(packageMetaData);
		
		String queryNameSpace = "validifc";
		if (packageMetaData.getSchema() == Schema.IFC4) {
			queryNameSpace = "ifc4stdlib";
		}
		
		if (eClass.getName().equals("IfcAnnotation")) {
			// IfcAnnotation also has the field ContainedInStructure, but that is it's own field (looks like a hack on the IFC-spec side)
			queryPart.addInclude(jsonQueryObjectModelConverter.getDefineFromFile(queryNameSpace + ":IfcAnnotationContainedInStructure"));
		} else {
			queryPart.addInclude(jsonQueryObjectModelConverter.getDefineFromFile(queryNameSpace + ":ContainedInStructure"));
		}
		if (packageMetaData.getSchema() == Schema.IFC4) {
			queryPart.addInclude(jsonQueryObjectModelConverter.getDefineFromFile(queryNameSpace + ":IsTypedBy"));
		}
		queryPart.addInclude(jsonQueryObjectModelConverter.getDefineFromFile(queryNameSpace + ":Decomposes"));
		queryPart.addInclude(jsonQueryObjectModelConverter.getDefineFromFile(queryNameSpace + ":OwnerHistory"));
		Include representationInclude = jsonQueryObjectModelConverter.getDefineFromFile(queryNameSpace + ":Representation");
		queryPart.addInclude(representationInclude);
		Include objectPlacement = jsonQueryObjectModelConverter.getDefineFromFile(queryNameSpace + ":ObjectPlacement");
		queryPart.addInclude(objectPlacement);
		if (packageMetaData.getEClass("IfcElement").isSuperTypeOf(eClass)) {
			Include openingsInclude = queryPart.createInclude();
			openingsInclude.addType(packageMetaData.getEClass(eClass.getName()), false);
			openingsInclude.addField("HasOpenings");
			Include hasOpenings = openingsInclude.createInclude();
			hasOpenings.addType(packageMetaData.getEClass("IfcRelVoidsElement"), false);
			hasOpenings.addField("RelatedOpeningElement");
			hasOpenings.addInclude(representationInclude);
			hasOpenings.addInclude(objectPlacement);
			//						Include relatedOpeningElement = hasOpenings.createInclude();
			//						relatedOpeningElement.addType(packageMetaData.getEClass("IfcOpeningElement"), false);
			//						relatedOpeningElement.addField("HasFillings");
			//						Include hasFillings = relatedOpeningElement.createInclude();
			//						hasFillings.addType(packageMetaData.getEClass("IfcRelFillsElement"), false);
			//						hasFillings.addField("RelatedBuildingElement");
		}
		QueryObjectProvider queryObjectProvider = new QueryObjectProvider(databaseSession, bimServer, query, Collections.singleton(queryContext.getRoid()), packageMetaData);
		
		Runner runner = new Runner(eClass, renderEnginePool, databaseSession, settings, queryObjectProvider, ifcSerializerPlugin, renderEngineFilter, generateGeometryResult, queryContext, query, geometryReused, map);
		executor.submit(runner);
		jobsTotal.incrementAndGet();
	}
	
//	private Set<Long> getRepresentationItems(DatabaseSession databaseSession, QueryContext queryContext, HashMapVirtualObject next) throws QueryException, IOException {
//		Set<Long> result = new HashSet<>();
//		Query query = new Query("getRepresentationItems", packageMetaData);
//		
//		Include representation = query.createDefine("Representation");
//		representation.addType(packageMetaData.getEClass("IfcShapeRepresentation"), true);
//		representation.addField("Items");
//		Include mapped = representation.createInclude();
//		mapped.addType(packageMetaData.getEClass("IfcMappedItem"), true);
//		mapped.addField("MappingSource");
//		Include mappingSource = mapped.createInclude();
//		mappingSource.addType(packageMetaData.getEClass("IfcRepresentationMap"), false);
//		mappingSource.addField("MappedRepresentation");
//		mappingSource.addInclude(representation);
//		
//		QueryPart queryPart = query.createQueryPart();
//		queryPart.addOid(next.getOid());
//		Include include = queryPart.createInclude();
//		include.addType(next.eClass(), false);
//		include.addField("Representation");
//		Include representations = include.createInclude();
//		representations.addType(packageMetaData.getEClass("IfcProductDefinitionShape"), true);
//		representations.addField("Representations");
//		representations.addInclude(representation);
//		
//		QueryObjectProvider queryObjectProvider = new QueryObjectProvider(databaseSession, bimServer, query, Collections.singleton(queryContext.getRoid()), packageMetaData);
//		try {
//			HashMapVirtualObject next2 = queryObjectProvider.next();
//			while (next2 != null) {
//				if (packageMetaData.getEClass("IfcRepresentationItem").isSuperTypeOf(next2.eClass())) {
//					result.add(next2.getOid());
//				}
//				next2 = queryObjectProvider.next();
//			}
//		} catch (BimserverDatabaseException e) {
//			e.printStackTrace();
//		}
//		return result;
//	}

	private long getSize(VirtualObject geometryData) {
		long size = 0;
		if (geometryData.has("indices")) {
			size += ((byte[])geometryData.get("indices")).length;
		}
		if (geometryData.has("vertices")) {
			size += ((byte[])geometryData.get("vertices")).length;
		}
		if (geometryData.has("normals")) {
			size += ((byte[])geometryData.get("normals")).length;
		}
		if (geometryData.has("materialIndices")) {
			size += ((byte[])geometryData.get("materialIndices")).length;
		}
		if (geometryData.has("materials")) {
			size += ((byte[])geometryData.get("materials")).length;
		}
		return size;
	}

	private int hash(VirtualObject geometryData) {
		int hashCode = 0;
		if (geometryData.has("indices")) {
			hashCode += Arrays.hashCode((byte[])geometryData.get("indices"));
		}
		if (geometryData.has("vertices")) {
			hashCode += Arrays.hashCode((byte[])geometryData.get("vertices"));
		}
		if (geometryData.has("normals")) {
			hashCode += Arrays.hashCode((byte[])geometryData.get("normals"));
		}
		if (geometryData.has("materialIndices")) {
			hashCode += Arrays.hashCode((byte[])geometryData.get("materialIndices"));
		}
		if (geometryData.has("materials")) {
			hashCode += Arrays.hashCode((byte[])geometryData.get("materials"));
		}
		return hashCode;
	}

	private void processExtendsUntranslated(VirtualObject geometryInfo, float[] vertices, int index, GenerateGeometryResult generateGeometryResult2) throws BimserverDatabaseException {
		double x = vertices[index];
		double y = vertices[index + 1];
		double z = vertices[index + 2];
		
		HashMapWrappedVirtualObject minBounds = (HashMapWrappedVirtualObject) geometryInfo.eGet(GeometryPackage.eINSTANCE.getGeometryInfo_MinBoundsUntranslated());
		HashMapWrappedVirtualObject maxBounds = (HashMapWrappedVirtualObject) geometryInfo.eGet(GeometryPackage.eINSTANCE.getGeometryInfo_MaxBoundsUntranslated());
		
		minBounds.set("x", Math.min(x, (double)minBounds.eGet("x")));
		minBounds.set("y", Math.min(y, (double)minBounds.eGet("y")));
		minBounds.set("z", Math.min(z, (double)minBounds.eGet("z")));
		maxBounds.set("x", Math.max(x, (double)maxBounds.eGet("x")));
		maxBounds.set("y", Math.max(y, (double)maxBounds.eGet("y")));
		maxBounds.set("z", Math.max(z, (double)maxBounds.eGet("z")));
	}

	private void processExtends(VirtualObject geometryInfo, double[] transformationMatrix, float[] vertices, int index, GenerateGeometryResult generateGeometryResult) throws BimserverDatabaseException {
		double x = vertices[index];
		double y = vertices[index + 1];
		double z = vertices[index + 2];
		
		double[] result = new double[4];
		
		Matrix.multiplyMV(result, 0, transformationMatrix, 0, new double[] { x, y, z, 1 }, 0);
		x = result[0];
		y = result[1];
		z = result[2];
		
		HashMapWrappedVirtualObject minBounds = (HashMapWrappedVirtualObject) geometryInfo.eGet(GeometryPackage.eINSTANCE.getGeometryInfo_MinBounds());
		HashMapWrappedVirtualObject maxBounds = (HashMapWrappedVirtualObject) geometryInfo.eGet(GeometryPackage.eINSTANCE.getGeometryInfo_MaxBounds());
		
		minBounds.set("x", Math.min(x, (double)minBounds.eGet("x")));
		minBounds.set("y", Math.min(y, (double)minBounds.eGet("y")));
		minBounds.set("z", Math.min(z, (double)minBounds.eGet("z")));
		maxBounds.set("x", Math.max(x, (double)maxBounds.eGet("x")));
		maxBounds.set("y", Math.max(y, (double)maxBounds.eGet("y")));
		maxBounds.set("z", Math.max(z, (double)maxBounds.eGet("z")));

		generateGeometryResult.setMinX(Math.min(x, generateGeometryResult.getMinX()));
		generateGeometryResult.setMinY(Math.min(y, generateGeometryResult.getMinY()));
		generateGeometryResult.setMinZ(Math.min(z, generateGeometryResult.getMinZ()));
		generateGeometryResult.setMaxX(Math.max(x, generateGeometryResult.getMaxX()));
		generateGeometryResult.setMaxY(Math.max(y, generateGeometryResult.getMaxY()));
		generateGeometryResult.setMaxZ(Math.max(z, generateGeometryResult.getMaxZ()));
	}

	private void setTransformationMatrix(VirtualObject geometryInfo, double[] transformationMatrix) throws BimserverDatabaseException {
		ByteBuffer byteBuffer = ByteBuffer.allocate(16 * 8);
		byteBuffer.order(ByteOrder.nativeOrder());
		DoubleBuffer asDoubleBuffer = byteBuffer.asDoubleBuffer();
		for (double d : transformationMatrix) {
			asDoubleBuffer.put(d);
		}
		geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_Transformation(), byteBuffer.array());
	}
	
	public String getRenderEngineName() {
		return renderEngineName;
	}
}