package org.bimserver.geometry;

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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.Color4f;
import org.bimserver.GenerateGeometryResult;
import org.bimserver.ObjectListener;
import org.bimserver.ObjectProviderProxy;
import org.bimserver.ProductDef;
import org.bimserver.Range;
import org.bimserver.TemporaryGeometryData;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.queries.QueryObjectProvider;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.models.geometry.GeometryPackage;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.renderengine.EntityNotFoundException;
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
import org.bimserver.utils.GeometryUtils;
import org.eclipse.emf.ecore.EClass;
import org.slf4j.LoggerFactory;

import com.google.common.base.Joiner;

public class GeometryRunner implements Runnable {

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(GeometryRunner.class);
	private final StreamingGeometryGenerator streamingGeometryGenerator;
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
	private ReportJob job;
	private boolean reuseGeometry;
	private boolean writeOutputFiles = false;
	private GeometryGenerationDebugger geometryGenerationDebugger;

	public GeometryRunner(StreamingGeometryGenerator streamingGeometryGenerator, EClass eClass, RenderEnginePool renderEnginePool, DatabaseSession databaseSession, RenderEngineSettings renderEngineSettings, ObjectProvider objectProvider,
			StreamingSerializerPlugin ifcSerializerPlugin, RenderEngineFilter renderEngineFilter, GenerateGeometryResult generateGeometryResult, QueryContext queryContext, Query originalQuery, boolean geometryReused,
			Map<Long, ProductDef> map, ReportJob job, boolean reuseGeometry, GeometryGenerationDebugger geometryGenerationDebugger) {
		this.streamingGeometryGenerator = streamingGeometryGenerator;
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
		this.job = job;
		this.reuseGeometry = reuseGeometry;
		this.geometryGenerationDebugger = geometryGenerationDebugger;
		this.job.setUsesMapping(map != null);
	}

	@Override
	public void run() {
		long start = System.nanoTime();
		job.setStartNanos(start);
		try {
			HashMapVirtualObject next = objectProvider.next();
			Query query = new Query("Double buffer query " + eClass.getName(), this.streamingGeometryGenerator.packageMetaData);
			QueryPart queryPart = query.createQueryPart();
			while (next != null) {
				queryPart.addOid(next.getOid());
				if (this.streamingGeometryGenerator.packageMetaData.getEClass("IfcProduct").isSuperTypeOf(next.eClass())) {
					job.addObject(next.getOid(), next.eClass().getName());
				}
				next = objectProvider.next();
			}

			objectProvider = new QueryObjectProvider(databaseSession, this.streamingGeometryGenerator.bimServer, query, Collections.singleton(queryContext.getRoid()), this.streamingGeometryGenerator.packageMetaData);

			StreamingSerializer ifcSerializer = ifcSerializerPlugin.createSerializer(new PluginConfiguration());
			RenderEngine renderEngine = null;
			byte[] bytes = null;
			try {
				final Set<HashMapVirtualObject> objects = new HashSet<>();
				ObjectProviderProxy proxy = new ObjectProviderProxy(objectProvider, new ObjectListener() {
					@Override
					public void newObject(HashMapVirtualObject next) {
						if (eClass.isSuperTypeOf(next.eClass())) {
							if (next.eGet(GeometryRunner.this.streamingGeometryGenerator.representationFeature) != null) {
								objects.add(next);
							}
						}
					}
				});
				ifcSerializer.init(proxy, null, null, this.streamingGeometryGenerator.bimServer.getPluginManager(), this.streamingGeometryGenerator.packageMetaData);

				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				IOUtils.copy(ifcSerializer.getInputStream(), baos);
				bytes = baos.toByteArray();
				InputStream in = new ByteArrayInputStream(bytes);
				Map<Integer, String> notFoundObjects = new HashMap<>();

				Set<Range> reusableGeometryData = new HashSet<>();

				Map<Long, TemporaryGeometryData> productToData = new HashMap<>();
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
										StreamingGeometryGenerator.LOGGER.error("Error in " + eClass.getName(), e);
									}
								}
							}

							OidConvertingSerializer oidConvertingSerializer = (OidConvertingSerializer) ifcSerializer;
							Map<Long, Integer> oidToEid = oidConvertingSerializer.getOidToEid();
							Map<Long, DebuggingInfo> debuggingInfo = new HashMap<>();

							for (HashMapVirtualObject ifcProduct : objects) {
								if (!this.streamingGeometryGenerator.running) {
									return;
								}
								Integer expressId = oidToEid.get(ifcProduct.getOid());
								try {
									RenderEngineInstance renderEngineInstance = renderEngineModel.getInstanceFromExpressId(expressId);
									RenderEngineGeometry geometry = renderEngineInstance.generateGeometry();
									boolean translate = true;
									// if (geometry == null ||
									// geometry.getIndices().length == 0) {
									// LOGGER.info("Running again...");
									// renderEngineModel.setFilter(renderEngineFilterTransformed);
									// geometry =
									// renderEngineInstance.generateGeometry();
									// if (geometry != null) {
									// translate = false;
									// }
									// renderEngineModel.setFilter(renderEngineFilter);
									// }

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

										geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_IfcProductOid(), ifcProduct.getOid());
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
										geometryData.setAttribute(GeometryPackage.eINSTANCE.getGeometryData_Reused(), 1);
										geometryData.setAttribute(GeometryPackage.eINSTANCE.getGeometryData_Indices(), GeometryUtils.intArrayToByteArray(indices));
										float[] vertices = geometry.getVertices();
										geometryData.setAttribute(GeometryPackage.eINSTANCE.getGeometryData_Vertices(), GeometryUtils.floatArrayToByteArray(vertices));
										geometryData.setAttribute(GeometryPackage.eINSTANCE.getGeometryData_Normals(), GeometryUtils.floatArrayToByteArray(geometry.getNormals()));

										geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_PrimitiveCount(), indices.length / 3);
										
										job.setTrianglesGenerated(indices.length / 3);
										job.getReport().incrementTriangles(indices.length / 3);

										Set<Color4f> usedColors = new HashSet<>();

										boolean hasTransparency = false;
										
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
														if (color.getA() < 1) {
															hasTransparency = true;
														}
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
												geometryData.setAttribute(GeometryPackage.eINSTANCE.getGeometryData_Materials(), GeometryUtils.floatArrayToByteArray(vertex_colors));
											}
										}

										double[] productTranformationMatrix = new double[16];
										if (translate && renderEngineInstance.getTransformationMatrix() != null) {
											productTranformationMatrix = renderEngineInstance.getTransformationMatrix();
										} else {
											Matrix.setIdentityM(productTranformationMatrix, 0);
										}

										geometryInfo.setReference(GeometryPackage.eINSTANCE.getGeometryInfo_Data(), geometryData.getOid(), 0);
										geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_HasTransparency(), hasTransparency);
										geometryData.setAttribute(GeometryPackage.eINSTANCE.getGeometryData_HasTransparency(), hasTransparency);

										long size = this.streamingGeometryGenerator.getSize(geometryData);

										for (int i = 0; i < indices.length; i++) {
											this.streamingGeometryGenerator.processExtends(geometryInfo, productTranformationMatrix, vertices, indices[i] * 3, generateGeometryResult);
											this.streamingGeometryGenerator.processExtendsUntranslated(geometryInfo, vertices, indices[i] * 3, generateGeometryResult);
										}

										double[] mibu = new double[] { (double) minBoundsUntranslated.eGet(GeometryPackage.eINSTANCE.getVector3f_X()), (double) minBoundsUntranslated.eGet(GeometryPackage.eINSTANCE.getVector3f_Y()),
												(double) minBoundsUntranslated.eGet(GeometryPackage.eINSTANCE.getVector3f_Z()), 1d };
										double[] mabu = new double[] { (double) maxBoundsUntranslated.eGet(GeometryPackage.eINSTANCE.getVector3f_X()), (double) maxBoundsUntranslated.eGet(GeometryPackage.eINSTANCE.getVector3f_Y()),
												(double) maxBoundsUntranslated.eGet(GeometryPackage.eINSTANCE.getVector3f_Z()), 1d };

										if (reuseGeometry) {
											int hash = this.streamingGeometryGenerator.hash(geometryData);
											float[] firstVertex = new float[] { vertices[indices[0]], vertices[indices[0] + 1], vertices[indices[0] + 2] };
											float[] lastVertex = new float[] { vertices[indices[indices.length - 1] * 3], vertices[indices[indices.length - 1] * 3 + 1], vertices[indices[indices.length - 1] * 3 + 2] };
											Range range = new Range(firstVertex, lastVertex);
											if (this.streamingGeometryGenerator.hashes.containsKey(hash)) {
												Long referenceOid = this.streamingGeometryGenerator.hashes.get(hash);
												HashMapVirtualObject referencedData = databaseSession.getFromCache(referenceOid);
												// TODO sometimes referencedData == null, probably a concurrency issue
												Integer currentValue = (Integer) referencedData.get("reused");
												referencedData.set("reused", currentValue + 1);
												referencedData.saveOverwrite();
												geometryInfo.setReference(GeometryPackage.eINSTANCE.getGeometryInfo_Data(), referenceOid, 0);
												this.streamingGeometryGenerator.bytesSavedByHash.addAndGet(size);
											} else if (geometryReused) {
												boolean found = false;
												// for (Range r :
												// reusableGeometryData) {
												// if (r.isSimilar(range)) {
												// geometryInfo.setReference(GeometryPackage.eINSTANCE.getGeometryInfo_Data(),
												// r.getGeometryDataOid(), 0);
												// float[] offset =
												// r.getOffset(range);
												// ProductDef productDef =
												// map.get(ifcProduct.getOid());
												// double[] mappedItemMatrix =
												// null;
												// if (productDef != null &&
												// productDef.getMatrix() !=
												// null) {
												// mappedItemMatrix =
												// productDef.getMatrix();
												// } else {
												// Matrix.translateM(mappedItemMatrix,
												// 0, offset[0], offset[1],
												// offset[2]);
												// }
												// double[] result = new
												// double[16];
												// Matrix.multiplyMM(result, 0,
												// mappedItemMatrix, 0,
												// productTranformationMatrix,
												// 0);
												// setTransformationMatrix(geometryInfo,
												// result); // Overwritten?
												// bytesSavedByTransformation.addAndGet(size);
												// found = true;
												// break;
												// }
												// }
												if (!found) {
													range.setGeometryDataOid(geometryData.getOid());
													reusableGeometryData.add(range);

													geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_Area(), renderEngineInstance.getArea());
													geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_Volume(), renderEngineInstance.getVolume());
													geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_PrimitiveCount(), indices.length / 3);

													productToData.put(ifcProduct.getOid(), new TemporaryGeometryData(geometryData.getOid(), renderEngineInstance.getArea(), renderEngineInstance.getVolume(), indices.length / 3, size, mibu, mabu));
													geometryData.save();
													databaseSession.cache((HashMapVirtualObject) geometryData);
												}
											} else {
												// if (sizes.containsKey(size)
												// && sizes.get(size).eClass()
												// == ifcProduct.eClass()) {
												// LOGGER.info("More reuse might
												// be possible " + size + " " +
												// ifcProduct.eClass().getName()
												// + ":" + ifcProduct.getOid() +
												// " / " +
												// sizes.get(size).eClass().getName()
												// + ":" +
												// sizes.get(size).getOid());
												// }
												if (geometryReused) {
													range.setGeometryDataOid(geometryData.getOid());
													reusableGeometryData.add(range);
													productToData.put(ifcProduct.getOid(), new TemporaryGeometryData(geometryData.getOid(), renderEngineInstance.getArea(), renderEngineInstance.getVolume(), indices.length / 3, size, mibu, mabu));
												} // TODO else??
												this.streamingGeometryGenerator.hashes.put(hash, geometryData.getOid());
												geometryData.save(); // TODO Why??
												databaseSession.cache((HashMapVirtualObject) geometryData);
												// sizes.put(size, ifcProduct);
											}
										} else {
											geometryData.save();
											databaseSession.cache((HashMapVirtualObject) geometryData);
										}

										calculateObb(geometryInfo, productTranformationMatrix, indices, vertices, generateGeometryResult);
										this.streamingGeometryGenerator.setTransformationMatrix(geometryInfo, productTranformationMatrix);
										debuggingInfo.put(ifcProduct.getOid(), new DebuggingInfo(productTranformationMatrix, indices, vertices));

										geometryInfo.save();
										this.streamingGeometryGenerator.totalBytes.addAndGet(size);

										ifcProduct.setReference(this.streamingGeometryGenerator.geometryFeature, geometryInfo.getOid(), 0);
										ifcProduct.saveOverwrite();

										// Doing a sync here because probably
										// writing large amounts of data, and db
										// only syncs every 100.000 writes by
										// default
										// databaseSession.getKeyValueStore().sync();
									} else {
										// TODO
									}
								} catch (EntityNotFoundException e) {
									// e.printStackTrace();
									// As soon as we find a representation that
									// is not Curve2D, then we should show a
									// "INFO" message in the log to indicate
									// there could be something wrong
									boolean ignoreNotFound = eClass.getName().equals("IfcAnnotation");

									// for (Object rep : representations) {
									// if (rep instanceof
									// IfcShapeRepresentation) {
									// IfcShapeRepresentation
									// ifcShapeRepresentation =
									// (IfcShapeRepresentation)rep;
									// if
									// (!"Curve2D".equals(ifcShapeRepresentation.getRepresentationType()))
									// {
									// ignoreNotFound = false;
									// }
									// }
									// }
									if (!ignoreNotFound) {
										// LOGGER.warn("Entity not found " +
										// ifcProduct.eClass().getName() + " " +
										// (expressId) + "/" +
										// ifcProduct.getOid());
										notFoundObjects.put(expressId, ifcProduct.eClass().getName());
									}
								} catch (BimserverDatabaseException | RenderEngineException e) {
									StreamingGeometryGenerator.LOGGER.error("", e);
								}
							}

							if (geometryReused && map != null) {
								// We pick the first product and use that product to try and get the original data
								long firstKey = map.keySet().iterator().next();
								ProductDef masterProductDef = map.get(firstKey);
								for (long key : map.keySet()) {
									if (key != firstKey) {
										ProductDef productDef = map.get(key);
										HashMapVirtualObject ifcProduct = productDef.getObject();

										TemporaryGeometryData masterGeometryData = productToData.get(productDef.getMasterOid());
										if (masterGeometryData != null) {
											VirtualObject geometryInfo = new HashMapVirtualObject(queryContext, GeometryPackage.eINSTANCE.getGeometryInfo());

											WrappedVirtualObject minBounds = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getVector3f());
											WrappedVirtualObject maxBounds = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getVector3f());

											double[] mibu = masterGeometryData.getMibu();
											double[] mabu = masterGeometryData.getMabu();

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

											geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_IfcProductOid(), ifcProduct.getOid());
											
											geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_MinBoundsUntranslated(), minBoundsUntranslated);
											geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_MaxBoundsUntranslated(), maxBoundsUntranslated);

											geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_Area(), masterGeometryData.getArea());
											geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_Volume(), masterGeometryData.getVolume());
											geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_PrimitiveCount(), masterGeometryData.getNrPrimitives());

											this.streamingGeometryGenerator.bytesSavedByMapping.addAndGet(masterGeometryData.getSize());
											this.streamingGeometryGenerator.totalBytes.addAndGet(masterGeometryData.getSize());

											// First, invert the master's mapping matrix
											double[] inverted = Matrix.identity();
											if (!Matrix.invertM(inverted, 0, masterProductDef.getMappingMatrix(), 0)) {
												System.out.println("No inverse");
											}

											double[] finalMatrix = Matrix.identity();
											double[] totalTranformationMatrix = Matrix.identity();
											// Apply the mapping matrix of the product
											Matrix.multiplyMM(finalMatrix, 0, productDef.getMappingMatrix(), 0, inverted, 0);
											// Apply the product matrix of the product
											Matrix.multiplyMM(totalTranformationMatrix, 0, productDef.getProductMatrix(), 0, finalMatrix, 0);

											if (geometryGenerationDebugger != null) {
												if (debuggingInfo.containsKey(ifcProduct.getOid())) {
													DebuggingInfo debuggingInfo2 = debuggingInfo.get(ifcProduct.getOid());
													DebuggingInfo debuggingInfo3 = debuggingInfo.get(productDef.getMasterOid());
													
													if (debuggingInfo2.getIndices().length != debuggingInfo3.getIndices().length) {
														LOGGER.error("Different sizes for indices, weird...");
														LOGGER.error(ifcProduct.getOid() + " / " + productDef.getMasterOid());
													} else {
														for (int i=0; i<debuggingInfo2.getIndices().length; i++) {
															int index = debuggingInfo2.getIndices()[i];
															float[] vertex = new float[]{debuggingInfo2.getVertices()[index * 3], debuggingInfo2.getVertices()[index * 3 + 1], debuggingInfo2.getVertices()[index * 3 + 2], 1};
															float[] transformedOriginal = new float[4];
															Matrix.multiplyMV(transformedOriginal, 0, debuggingInfo2.getProductTranformationMatrix(), 0, vertex, 0);
															float[] transformedNew = new float[4];
															int index2 = debuggingInfo3.getIndices()[i];
															float[] vertex2 = new float[]{debuggingInfo3.getVertices()[index2 * 3], debuggingInfo3.getVertices()[index2 * 3 + 1], debuggingInfo3.getVertices()[index2 * 3 + 2], 1};
															Matrix.multiplyMV(transformedNew, 0, totalTranformationMatrix, 0, vertex2, 0);
															
															// TODO margin should depend on bb of complete model
															if (!almostTheSame((String)ifcProduct.get("GlobalId"), transformedNew, transformedOriginal, 0.05F)) {
																geometryGenerationDebugger.transformedVertexNotMatching(ifcProduct, transformedOriginal, transformedNew, debuggingInfo2.getProductTranformationMatrix(), totalTranformationMatrix);
															}
														}
													}
													
//												almostTheSame((String)ifcProduct.get("GlobalId"), debuggingInfo2.getProductTranformationMatrix(), totalTranformationMatrix, 0.01D);
												}
											}

											HashMapVirtualObject referencedData = databaseSession.getFromCache(masterGeometryData.getOid());
											Integer currentValue = (Integer) referencedData.get("reused");
											referencedData.set("reused", currentValue + 1);
											referencedData.saveOverwrite();
											geometryInfo.setReference(GeometryPackage.eINSTANCE.getGeometryInfo_Data(), masterGeometryData.getOid(), 0);

											// for (int i = 0; i <
											// indices.length; i++) {
											// processExtends(geometryInfo,
											// productTranformationMatrix,
											// vertices, indices[i] * 3,
											// generateGeometryResult);
											// processExtendsUntranslated(geometryInfo,
											// vertices, indices[i] * 3,
											// generateGeometryResult);
											// }

											// calculateObb(geometryInfo,
											// productTranformationMatrix,
											// indices, vertices,
											// generateGeometryResult);
											this.streamingGeometryGenerator.setTransformationMatrix(geometryInfo, totalTranformationMatrix);

											geometryInfo.save();
											// totalBytes.addAndGet(size);

											ifcProduct.setReference(this.streamingGeometryGenerator.geometryFeature, geometryInfo.getOid(), 0);
											ifcProduct.saveOverwrite();
										}
									}
								}
							}
						}
					}
				} finally {
					if (renderEngine != null) {
						renderEnginePool.returnObject(renderEngine);
					}
					try {
						if (!notFoundObjects.isEmpty()) {
							int debugId = writeDebugFile(bytes, false, notFoundObjects);
							job.setException(new Exception("Missing objects in model (" + Joiner.on(", ").join(notFoundObjects.keySet()) + ")"), debugId);
						} else if (writeOutputFiles) {
							int debugId = writeDebugFile(bytes, false, null);
							job.setDebugFile(debugId);
						}
						in.close();
					} catch (Throwable e) {

					} finally {
						
					}
					this.streamingGeometryGenerator.jobsDone.incrementAndGet();
					this.streamingGeometryGenerator.updateProgress();
				}
			} catch (Exception e) {
				StreamingGeometryGenerator.LOGGER.error("", e);
				int debugId = writeDebugFile(bytes, true, null);
				job.setException(e, debugId);
				// LOGGER.error("Original query: " + originalQuery, e);
			}
		} catch (Exception e) {
			StreamingGeometryGenerator.LOGGER.error("", e);
			// LOGGER.error("Original query: " + originalQuery, e);
		}
		long end = System.nanoTime();
		job.setEndNanos(end);
	}

	private boolean almostTheSame(String identifier, double[] a, double[] b, double margin) {
		if (a.length != b.length) {
			throw new RuntimeException("Unequal sizes");
		}
		for (int i=0; i<a.length; i++) {
			double q = a[i];
			double r = b[i];
			if (Math.abs(q - r) < margin) {
				// OK
			} else {
				System.out.println("Not the same " + identifier);
				Matrix.dump(a);
				System.out.println();
				Matrix.dump(b);
				return false;
			}
		}
		return true;
	}
	
	private boolean almostTheSame(String identifier, float[] a, float[] b, float margin) {
		if (a.length != b.length) {
			throw new RuntimeException("Unequal sizes");
		}
		for (int i=0; i<a.length; i++) {
			double q = a[i];
			double r = b[i];
			if (Math.abs(q - r) < margin) {
				// OK
			} else {
				return false;
			}
		}
		return true;
	}
	
	private synchronized int writeDebugFile(byte[] bytes, boolean error, Map<Integer, String> notFoundObjects) throws FileNotFoundException, IOException {
		boolean debug = true;
		if (debug) {
			Path debugPath = this.streamingGeometryGenerator.bimServer.getHomeDir().resolve("debug");
			if (!Files.exists(debugPath)) {
				Files.createDirectories(debugPath);
			}

			Path folder = debugPath.resolve(this.streamingGeometryGenerator.debugIdentifier);
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
			int i = 0;
			while (Files.exists((file))) {
				file = folder.resolve(basefilenamename + "-" + i + ".ifc");
				i++;
			}
			int debugFileId = job.getReport().addDebugFile(file.toString());

//			if (notFoundObjects != null) {
//				StringBuilder sb = new StringBuilder();
//				for (Integer expressId : notFoundObjects.keySet()) {
//					sb.append(notFoundObjects.get(expressId) + ": " + expressId + "\r\n");
//				}
//				FileUtils.writeStringToFile(Paths.get(file.toAbsolutePath().toString() + ".txt").toFile(), sb.toString());
//			}

			StreamingGeometryGenerator.LOGGER.info("Writing debug file to " + file.toAbsolutePath().toString());
			FileUtils.writeByteArrayToFile(file.toFile(), bytes);
			return debugFileId;
		}
		return -1;
	}

	private void calculateObb(VirtualObject geometryInfo, double[] tranformationMatrix, int[] indices, float[] vertices, GenerateGeometryResult generateGeometryResult2) {

	}
}