package org.bimserver.geometry;

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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.Color4f;
import org.bimserver.GenerateGeometryResult;
import org.bimserver.GeometryGeneratingException;
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
import org.bimserver.plugins.renderengine.Metrics;
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
import org.bimserver.shared.WrappedVirtualObject;
import org.bimserver.utils.UuidUtils;
import org.eclipse.emf.ecore.EClass;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.primitives.UnsignedBytes;

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
	private Query originalQuery;

	public GeometryRunner(StreamingGeometryGenerator streamingGeometryGenerator, EClass eClass, RenderEnginePool renderEnginePool, DatabaseSession databaseSession, RenderEngineSettings renderEngineSettings, ObjectProvider objectProvider,
			StreamingSerializerPlugin ifcSerializerPlugin, RenderEngineFilter renderEngineFilter, GenerateGeometryResult generateGeometryResult, QueryContext queryContext, boolean geometryReused,
			Map<Long, ProductDef> map, ReportJob job, boolean reuseGeometry, GeometryGenerationDebugger geometryGenerationDebugger, Query query) {
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
		this.originalQuery = query;
	}

	@Override
	public void run() {
		Thread.currentThread().setName("GeometryRunner");
		long start = System.nanoTime();
		job.setStartNanos(start);

		// For all objects "hitchhiking" on this GeometryRunner, we also want to couple them to the job
		if (map != null) {
			for (long oid : map.keySet()) {
				if (map.get(oid).getMasterOid() != oid) {
					try {
						job.addObject(oid, databaseSession.getEClassForOid(oid).getName());
					} catch (BimserverDatabaseException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		try {
			HashMapVirtualObject next = objectProvider.next();
			Query query = new Query("Double buffer query " + eClass.getName(), this.streamingGeometryGenerator.packageMetaData);
			QueryPart queryPart = query.createQueryPart();
			while (next != null) {
				long oid = next.getOid();
				queryPart.addOid(oid);
				if (eClass.isSuperTypeOf(next.eClass())) {
					for (QueryPart qp : originalQuery.getQueryParts()) {
						if (qp.getOids().contains(oid)) {
							job.addObject(next.getOid(), next.eClass().getName());
						}
					}
				}
				next = objectProvider.next();
			}

			objectProvider = new QueryObjectProvider(databaseSession, this.streamingGeometryGenerator.bimServer, query, Collections.singleton(queryContext.getRoid()), this.streamingGeometryGenerator.packageMetaData);

			StreamingSerializer serializer = ifcSerializerPlugin.createSerializer(new PluginConfiguration());
			RenderEngine renderEngine = null;
			byte[] bytes = null;
			try {
				final Set<HashMapVirtualObject> objects = new LinkedHashSet<>();
				ObjectProviderProxy proxy = new ObjectProviderProxy(objectProvider, new ObjectListener() {
					@Override
					public void newObject(HashMapVirtualObject next) {
						if (eClass.isSuperTypeOf(next.eClass())) {
							if (next.eGet(GeometryRunner.this.streamingGeometryGenerator.representationFeature) != null) {
								for (QueryPart qp : originalQuery.getQueryParts()) {
									if (qp.getOids().contains(next.getOid())) {
										objects.add(next);
									}
								}
							}
						}
					}
				});
				serializer.init(proxy, null, null, this.streamingGeometryGenerator.bimServer.getPluginManager(), this.streamingGeometryGenerator.packageMetaData);

				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				IOUtils.copy(serializer.getInputStream(), baos);
				bytes = baos.toByteArray();
				InputStream in = new ByteArrayInputStream(bytes);
				Map<Long, HashMapVirtualObject> notFoundObjects = new HashMap<>();

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

							OidConvertingSerializer oidConvertingSerializer = (OidConvertingSerializer) serializer;
							Map<Long, Long> oidToEid = oidConvertingSerializer.getOidToEid();
							Map<Long, DebuggingInfo> debuggingInfo = new HashMap<>();

							for (HashMapVirtualObject ifcProduct : objects) {
								if (!this.streamingGeometryGenerator.running) {
									return;
								}
								Long expressId = oidToEid.get(ifcProduct.getOid());
								try {
									RenderEngineInstance renderEngineInstance = renderEngineModel.getInstanceFromExpressId(expressId);
									RenderEngineGeometry geometry = renderEngineInstance.generateGeometry();
									boolean translate = true;

									if (geometry != null && geometry.getNrIndices() > 0) {
										HashMapVirtualObject geometryInfo = new HashMapVirtualObject(queryContext, GeometryPackage.eINSTANCE.getGeometryInfo());
										
										HashMapWrappedVirtualObject bounds = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getBounds());
										HashMapWrappedVirtualObject minBounds = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getVector3f());
										HashMapWrappedVirtualObject maxBounds = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getVector3f());

										minBounds.set("x", Double.POSITIVE_INFINITY);
										minBounds.set("y", Double.POSITIVE_INFINITY);
										minBounds.set("z", Double.POSITIVE_INFINITY);

										maxBounds.set("x", -Double.POSITIVE_INFINITY);
										maxBounds.set("y", -Double.POSITIVE_INFINITY);
										maxBounds.set("z", -Double.POSITIVE_INFINITY);

										geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_IfcProductOid(), ifcProduct.getOid());
										geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_IfcProductUuid(), UuidUtils.toByteArray(ifcProduct.getUuid()));
										geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_IfcProductRid(), ifcProduct.getRid());
										
										geometryInfo.setReference(GeometryPackage.eINSTANCE.getGeometryInfo_Bounds(), bounds);
										bounds.setReference(GeometryPackage.eINSTANCE.getBounds_Min(), minBounds);
										bounds.setReference(GeometryPackage.eINSTANCE.getBounds_Max(), maxBounds);

										HashMapWrappedVirtualObject boundsUntransformed = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getBounds());
										WrappedVirtualObject minBoundsUntranslated = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getVector3f());
										WrappedVirtualObject maxBoundsUntranslated = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getVector3f());

										minBoundsUntranslated.set("x", Double.POSITIVE_INFINITY);
										minBoundsUntranslated.set("y", Double.POSITIVE_INFINITY);
										minBoundsUntranslated.set("z", Double.POSITIVE_INFINITY);

										maxBoundsUntranslated.set("x", -Double.POSITIVE_INFINITY);
										maxBoundsUntranslated.set("y", -Double.POSITIVE_INFINITY);
										maxBoundsUntranslated.set("z", -Double.POSITIVE_INFINITY);

										boundsUntransformed.setReference(GeometryPackage.eINSTANCE.getBounds_Min(), minBoundsUntranslated);
										boundsUntransformed.setReference(GeometryPackage.eINSTANCE.getBounds_Max(), maxBoundsUntranslated);
										
										geometryInfo.setReference(GeometryPackage.eINSTANCE.getGeometryInfo_BoundsUntransformed(), boundsUntransformed);

										double volume = 0;
										
										volume = setCalculatedQuantities(renderEngineInstance, geometryInfo, volume);

										HashMapVirtualObject geometryData = new HashMapVirtualObject(queryContext, GeometryPackage.eINSTANCE.getGeometryData());
										
										geometryData.set("type", databaseSession.getCid(eClass));

										ByteBuffer indices = geometry.getIndices();
										ByteBuffer vertices = geometry.getVertices();
										ByteBuffer normals = geometry.getNormals();
										ByteBuffer colorByteBuffer = geometry.getMaterialIndices();

										IntBuffer indicesAsInt = indices.order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
										DoubleBuffer verticesAsDouble = vertices.order(ByteOrder.LITTLE_ENDIAN).asDoubleBuffer();
										FloatBuffer normalsAsFloat = normals.order(ByteOrder.LITTLE_ENDIAN).asFloatBuffer();
										IntBuffer materialIndices = colorByteBuffer.order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();

										if (detectTwoFaceTriangles(ifcProduct, indicesAsInt, verticesAsDouble, 0.001f)) {
											BufferSet bufferSet = appendInvertedGeometry(indicesAsInt, verticesAsDouble, normalsAsFloat, materialIndices);
											
											indices = bufferSet.getIndicesByteBuffer();
											vertices = bufferSet.getVerticesByteBuffer();
											normals = bufferSet.getNormalsByteBuffer();
											colorByteBuffer = bufferSet.getColorsByteBuffer();
											
											indicesAsInt = indices.order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
											verticesAsDouble = vertices.order(ByteOrder.LITTLE_ENDIAN).asDoubleBuffer();
											normalsAsFloat = normals.order(ByteOrder.LITTLE_ENDIAN).asFloatBuffer();
											materialIndices = colorByteBuffer.order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
										}

										geometryData.setAttribute(GeometryPackage.eINSTANCE.getGeometryData_Reused(), 1);
										geometryData.setReference(GeometryPackage.eINSTANCE.getGeometryData_Indices(), createBuffer(queryContext, indices));
										geometryData.setReference(GeometryPackage.eINSTANCE.getGeometryData_Vertices(), createBuffer(queryContext, vertices));
										geometryData.setReference(GeometryPackage.eINSTANCE.getGeometryData_Normals(), createBuffer(queryContext, normals));
										
										geometryData.set("nrIndices", indicesAsInt.capacity());
										geometryData.set("nrVertices", verticesAsDouble.capacity());
										geometryData.set("nrNormals", normalsAsFloat.capacity());
										
										ByteBuffer lineIndices = generateLineRendering(ifcProduct, indicesAsInt, verticesAsDouble, normalsAsFloat, 0.001f);
										geometryData.set("nrLineIndices", lineIndices.capacity() / 4);
										geometryData.setReference(GeometryPackage.eINSTANCE.getGeometryData_LineIndices(), createBuffer(queryContext, lineIndices));
										
										geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_PrimitiveCount(), indicesAsInt.capacity() / 3);
										
										job.setTrianglesGenerated(indicesAsInt.capacity() / 3);
										job.getReport().incrementTriangles(indicesAsInt.capacity() / 3);
										
										streamingGeometryGenerator.cacheGeometryData(geometryData, vertices);

										ColorMap colorMap = new ColorMap();
										
										ByteBuffer colors = ByteBuffer.wrap(new byte[0]);
										
										if (materialIndices != null && materialIndices.capacity() > 0) {
											FloatBuffer materialsAsFloat = geometry.getMaterials().order(ByteOrder.LITTLE_ENDIAN).asFloatBuffer();
											boolean hasMaterial = false;
											colors = ByteBuffer.allocate((verticesAsDouble.capacity() / 3) * 4);
											double[] triangle = new double[9];
											
//											LOGGER.info(ifcProduct.eClass().getName() + " " + ifcProduct.getOid());
//											dump("Material indices", materialIndices);
//											dump("Materials", materialsAsFloat);
											
											for (int i = 0; i < materialIndices.capacity(); ++i) {
												int c = materialIndices.get(i);
												if (c > -1) {
													Color4f color = new Color4f();
													for (int l = 0; l < 4; ++l) {
														float val = fixColor(materialsAsFloat.get(4 * c + l));
														color.set(l, val);
													}
													if (color.isBlack()) {
														continue;
													}
													for (int j = 0; j < 3; ++j) {
														int k = indicesAsInt.get(i * 3 + j);
														triangle[j * 3 + 0] = verticesAsDouble.get(3 * k);
														triangle[j * 3 + 1] = verticesAsDouble.get(3 * k + 1);
														triangle[j * 3 + 2] = verticesAsDouble.get(3 * k + 2);
														hasMaterial = true;
														for (int l = 0; l < 4; ++l) {
															float val = fixColor(materialsAsFloat.get(4 * c + l));
															colors.put(4 * k + l, UnsignedBytes.checkedCast((int)(val * 255)));
														}
													}
													colorMap.addTriangle(triangle, color);
												}
											}
											if (hasMaterial) {
												ColorMap2 colorMap2 = new ColorMap2();
												byte[] colorB = new byte[4];
												for (int i=0; i<colors.capacity(); i+=4) {
													colors.get(colorB);
													colorMap2.addColor(colorB);
												}
												
												HashMapVirtualObject colorPack = new HashMapVirtualObject(queryContext, GeometryPackage.eINSTANCE.getColorPack());
												colorPack.setAttribute(GeometryPackage.eINSTANCE.getColorPack_Data(), colorMap2.toByteArray());
												colorPack.save();
												geometryData.setReference(GeometryPackage.eINSTANCE.getGeometryData_ColorPack(), colorPack.getOid(), 0);
											}
											if (colorMap.usedColors() == 0) {
												if (eClass.getName().contentEquals("IfcWindow") || eClass.getName().contentEquals("IfcOpeningElement") || eClass.getName().contentEquals("IfcSpace")) {
													// To make sure the viewer will but this object in the right buffer (transparent), we override the transparency here
													// This only happens for objects with no color, maybe there are more types that are usually transparent?
													colorMap.setHasTransparency(true);
//												} else {
//													LOGGER.info(ifcProduct.eClass().getName());
												}
											} else if (colorMap.usedColors() == 1) {
												WrappedVirtualObject color = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getVector4f());
												Color4f firstColor = colorMap.getFirstColor();
												color.set("x", firstColor.getR());
												color.set("y", firstColor.getG());
												color.set("z", firstColor.getB());
												color.set("w", firstColor.getA());
												geometryData.setReference(GeometryPackage.eINSTANCE.getGeometryData_Color(), color);
												
												// This tells the code further on to not store this geometry, as it can be easily generated
												hasMaterial = false;
											} else {
												Color4f mostUsed = colorMap.getMostUsedColor();

												WrappedVirtualObject color = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getVector4f());
												color.set("x", mostUsed.getR());
												color.set("y", mostUsed.getG());
												color.set("z", mostUsed.getB());
												color.set("w", mostUsed.getA());
												geometryData.setReference(GeometryPackage.eINSTANCE.getGeometryData_MostUsedColor(), color);
											}
											if (hasMaterial) {
												geometryData.set("nrColors", colors.capacity());
												geometryData.setReference(GeometryPackage.eINSTANCE.getGeometryData_ColorsQuantized(), createBuffer(queryContext, colors), -1);
											} else {
												geometryData.set("nrColors", 0);
											}
										} else {
											geometryData.set("nrColors", 0);
										}
										
										boolean hasTransparency = colorMap.hasTransparency();
										
										double[] productTranformationMatrix = new double[16];
										if (translate && renderEngineInstance.getTransformationMatrix() != null) {
											productTranformationMatrix = renderEngineInstance.getTransformationMatrix();
										} else {
											Matrix.setIdentityM(productTranformationMatrix, 0);
										}

										geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_NrColors(), colors.capacity());
										geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_NrVertices(), verticesAsDouble.capacity());
										geometryInfo.setReference(GeometryPackage.eINSTANCE.getGeometryInfo_Data(), geometryData.getOid(), 0);
										geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_HasTransparency(), hasTransparency);
										geometryData.setAttribute(GeometryPackage.eINSTANCE.getGeometryData_HasTransparency(), hasTransparency);

										long size = this.streamingGeometryGenerator.getSize(geometryData);

										for (int i = 0; i < indicesAsInt.capacity(); i++) {
											this.streamingGeometryGenerator.processExtends(minBounds, maxBounds, productTranformationMatrix, verticesAsDouble, indicesAsInt.get(i) * 3, generateGeometryResult);
											this.streamingGeometryGenerator.processExtendsUntranslated(geometryInfo, verticesAsDouble, indicesAsInt.get(i) * 3, generateGeometryResult);
										}
										
										HashMapWrappedVirtualObject boundsUntransformedMm = createMmBounds(geometryInfo, boundsUntransformed, generateGeometryResult.getMultiplierToMm());
										geometryInfo.set("boundsUntransformedMm", boundsUntransformedMm);
										HashMapWrappedVirtualObject boundsMm = createMmBounds(geometryInfo, bounds, generateGeometryResult.getMultiplierToMm());
										geometryInfo.set("boundsMm", boundsMm);

										ByteBuffer normalsQuantized = quantizeNormals(normalsAsFloat);
										geometryData.setReference(GeometryPackage.eINSTANCE.getGeometryData_NormalsQuantized(), createBuffer(queryContext, normalsQuantized));
										
										HashMapWrappedVirtualObject geometryDataBounds = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getBounds());
										WrappedVirtualObject geometryDataBoundsMin = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getVector3f());
										WrappedVirtualObject geometryDataBoundsMax = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getVector3f());

										geometryDataBoundsMin.set("x", ((HashMapWrappedVirtualObject)boundsMm.get("min")).get("x"));
										geometryDataBoundsMin.set("y", ((HashMapWrappedVirtualObject)boundsMm.get("min")).get("y"));
										geometryDataBoundsMin.set("z", ((HashMapWrappedVirtualObject)boundsMm.get("min")).get("z"));

										geometryDataBoundsMax.set("x", ((HashMapWrappedVirtualObject)boundsMm.get("max")).get("x"));
										geometryDataBoundsMax.set("y", ((HashMapWrappedVirtualObject)boundsMm.get("max")).get("y"));
										geometryDataBoundsMax.set("z", ((HashMapWrappedVirtualObject)boundsMm.get("max")).get("z"));

										geometryDataBounds.setReference(GeometryPackage.eINSTANCE.getBounds_Min(), geometryDataBoundsMin);
										geometryDataBounds.setReference(GeometryPackage.eINSTANCE.getBounds_Max(), geometryDataBoundsMax);
										geometryData.setReference(GeometryPackage.eINSTANCE.getGeometryData_BoundsMm(), geometryDataBounds);

										if (volume == 0) {
											volume = getVolumeFromBounds(boundsUntransformed);
										}
										float nrTriangles = indicesAsInt.capacity() / 3;
										
										Density density = new Density(eClass.getName(), (float) volume, getBiggestFaceFromBounds(boundsUntransformedMm), (long) nrTriangles, geometryInfo.getOid());
										
										geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_Density(), density.getDensityValue());
										
										generateGeometryResult.addDensity(density);

										double[] mibu = new double[] { (double) minBoundsUntranslated.eGet(GeometryPackage.eINSTANCE.getVector3f_X()), (double) minBoundsUntranslated.eGet(GeometryPackage.eINSTANCE.getVector3f_Y()),
												(double) minBoundsUntranslated.eGet(GeometryPackage.eINSTANCE.getVector3f_Z()), 1d };
										double[] mabu = new double[] { (double) maxBoundsUntranslated.eGet(GeometryPackage.eINSTANCE.getVector3f_X()), (double) maxBoundsUntranslated.eGet(GeometryPackage.eINSTANCE.getVector3f_Y()),
												(double) maxBoundsUntranslated.eGet(GeometryPackage.eINSTANCE.getVector3f_Z()), 1d };

										if (reuseGeometry) {
											/* TODO It still happens that geometry that should be reused is not reused, one of the reasons is still concurrency:
											 * 	- When the same geometry is processed concurrently they could both do the hash check at a time when there is no cached version, then they both think it's non-reused geometry
											*/
											int hash = this.streamingGeometryGenerator.hash(indices, vertices, normals, colors);
											int firstIndex = indicesAsInt.get(0);
											int lastIndex = indicesAsInt.get(indicesAsInt.capacity() - 1);
											double[] firstVertex = new double[] { verticesAsDouble.get(firstIndex), verticesAsDouble.get(firstIndex + 1), verticesAsDouble.get(firstIndex + 2) };
											double[] lastVertex = new double[] { verticesAsDouble.get(lastIndex * 3), verticesAsDouble.get(lastIndex * 3 + 1), verticesAsDouble.get(lastIndex * 3 + 2) };
											Range range = new Range(firstVertex, lastVertex);
											Long referenceOid = this.streamingGeometryGenerator.hashes.get(hash);
											if (referenceOid != null) {
												HashMapVirtualObject referencedData = databaseSession.getFromCache(referenceOid);
												if (referencedData == null) {
													LOGGER.error("Object not found in cache: " + referenceOid + " (hash: " + hash + ")");
												}
												synchronized (referencedData) {
													Integer currentValue = (Integer) referencedData.get("reused");
													referencedData.set("reused", currentValue + 1);
												}
												HashMapWrappedVirtualObject dataBounds = (HashMapWrappedVirtualObject) referencedData.get("boundsMm");
												extendBounds(boundsMm, dataBounds);
												referencedData.saveOverwrite();
												geometryInfo.setReference(GeometryPackage.eINSTANCE.getGeometryInfo_Data(), referenceOid, 0);
												this.streamingGeometryGenerator.bytesSavedByHash.addAndGet(size);
											} else if (geometryReused) {
												// This is true when this geometry is part of a mapped item mapping (and used more than once)
												
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

													volume = setCalculatedQuantities(renderEngineInstance, geometryInfo, volume);

													geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_PrimitiveCount(), indicesAsInt.capacity() / 3);

													productToData.put(ifcProduct.getOid(), new TemporaryGeometryData(geometryData.getOid(), renderEngineInstance.getAdditionalData(), indicesAsInt.capacity() / 3, size, mibu, mabu, indicesAsInt, verticesAsDouble, hasTransparency, colors.capacity()));
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
//												if (geometryReused) {
//													range.setGeometryDataOid(geometryData.getOid());
//													reusableGeometryData.add(range);
//													productToData.put(ifcProduct.getOid(), new TemporaryGeometryData(geometryData.getOid(), renderEngineInstance.getArea(), renderEngineInstance.getVolume(), indices.length / 3, size, mibu, mabu, indices, vertices));
//												} // TODO else??
												
												// So reuse is on, the data was not found by hash, and this item is not in a mapped item
												
												// By saving it before putting it in the cache/hashmap, we make sure we won't get a BimserverConcurrentModificationException
												geometryData.save(); // TODO Why??

												databaseSession.cache((HashMapVirtualObject) geometryData);
												this.streamingGeometryGenerator.hashes.put(hash, geometryData.getOid());
												// sizes.put(size, ifcProduct);
											}
										} else {
											geometryData.save();
											databaseSession.cache((HashMapVirtualObject) geometryData);
										}

										this.streamingGeometryGenerator.setTransformationMatrix(geometryInfo, productTranformationMatrix);
										debuggingInfo.put(ifcProduct.getOid(), new DebuggingInfo(productTranformationMatrix, indices.asIntBuffer(), vertices.asFloatBuffer()));

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
										notFoundObjects.put(expressId, ifcProduct);
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
											HashMapVirtualObject geometryInfo = new HashMapVirtualObject(queryContext, GeometryPackage.eINSTANCE.getGeometryInfo());

											HashMapWrappedVirtualObject bounds = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getBounds());
											HashMapWrappedVirtualObject minBounds = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getVector3f());
											HashMapWrappedVirtualObject maxBounds = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getVector3f());
											
											geometryInfo.setReference(GeometryPackage.eINSTANCE.getGeometryInfo_Bounds(), bounds);
											geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_HasTransparency(), masterGeometryData.hasTransparancy());
											
											geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_NrColors(), masterGeometryData.getNrColors());
											geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_NrVertices(), masterGeometryData.getNrVertices());
											
											bounds.set("min", minBounds);
											bounds.set("max", maxBounds);
											
											minBounds.set("x", Double.POSITIVE_INFINITY);
											minBounds.set("y", Double.POSITIVE_INFINITY);
											minBounds.set("z", Double.POSITIVE_INFINITY);

											maxBounds.set("x", -Double.POSITIVE_INFINITY);
											maxBounds.set("y", -Double.POSITIVE_INFINITY);
											maxBounds.set("z", -Double.POSITIVE_INFINITY);

											double[] mibu = masterGeometryData.getMibu();
											double[] mabu = masterGeometryData.getMabu();

											HashMapWrappedVirtualObject boundsUntransformed = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getBounds());
											WrappedVirtualObject minBoundsUntransformed = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getVector3f());
											WrappedVirtualObject maxBoundsUntransformed = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getVector3f());

											minBoundsUntransformed.set("x", mibu[0]);
											minBoundsUntransformed.set("y", mibu[1]);
											minBoundsUntransformed.set("z", mibu[2]);

											maxBoundsUntransformed.set("x", mabu[0]);
											maxBoundsUntransformed.set("y", mabu[1]);
											maxBoundsUntransformed.set("z", mabu[2]);

											geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_IfcProductOid(), ifcProduct.getOid());
											geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_IfcProductUuid(), UuidUtils.toByteArray(ifcProduct.getUuid()));
											geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_IfcProductRid(), ifcProduct.getRid());
											
											boundsUntransformed.setReference(GeometryPackage.eINSTANCE.getBounds_Min(), minBoundsUntransformed);
											boundsUntransformed.setReference(GeometryPackage.eINSTANCE.getBounds_Max(), maxBoundsUntransformed);
											geometryInfo.setReference(GeometryPackage.eINSTANCE.getGeometryInfo_BoundsUntransformed(), boundsUntransformed);

											double volume = 0;
											if (streamingGeometryGenerator.isCalculateQuantities()) {
												ObjectNode additionalData = masterGeometryData.getAdditionalData();
												if (additionalData != null) {
													geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_AdditionalData(), additionalData.toString());
													if (additionalData.has("TOTAL_SURFACE_AREA")) {
														geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_Area(), additionalData.get("TOTAL_SURFACE_AREA").asDouble());
													}
													if (additionalData.has("TOTAL_SHAPE_VOLUME")) {
														volume = additionalData.get("TOTAL_SHAPE_VOLUME").asDouble();
														geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_Volume(), volume);
													}
												}
											}

											geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_PrimitiveCount(), masterGeometryData.getNrPrimitives());

											job.getReport().incrementTriangles(masterGeometryData.getNrPrimitives());
											
											this.streamingGeometryGenerator.bytesSavedByMapping.addAndGet(masterGeometryData.getSize());
											this.streamingGeometryGenerator.totalBytes.addAndGet(masterGeometryData.getSize());

											// First, invert the master's mapping matrix
											double[] inverted = Matrix.identity();
											if (!Matrix.invertM(inverted, 0, masterProductDef.getMappingMatrix(), 0)) {
												LOGGER.info("No inverse, this should not be able to happen at this time, please report");
												continue;
											}

											double[] finalMatrix = Matrix.identity();
											double[] totalTranformationMatrix = Matrix.identity();
											// Apply the mapping matrix of the product
											Matrix.multiplyMM(finalMatrix, 0, productDef.getMappingMatrix(), 0, inverted, 0);
											// Apply the product matrix of the product
											Matrix.multiplyMM(totalTranformationMatrix, 0, productDef.getProductMatrix(), 0, finalMatrix, 0);

											if (geometryGenerationDebugger != null) {
//												if (debuggingInfo.containsKey(ifcProduct.getOid())) {
//													DebuggingInfo debuggingInfo2 = debuggingInfo.get(ifcProduct.getOid());
//													DebuggingInfo debuggingInfo3 = debuggingInfo.get(productDef.getMasterOid());
//													
//													if (debuggingInfo2.getIndices().length != debuggingInfo3.getIndices().length) {
//														LOGGER.error("Different sizes for indices, weird...");
//														LOGGER.error(ifcProduct.getOid() + " / " + productDef.getMasterOid());
//													} else {
//														for (int i=0; i<debuggingInfo2.getIndices().length; i++) {
//															int index = debuggingInfo2.getIndices()[i];
//															float[] vertex = new float[]{debuggingInfo2.getVertices()[index * 3], debuggingInfo2.getVertices()[index * 3 + 1], debuggingInfo2.getVertices()[index * 3 + 2], 1};
//															float[] transformedOriginal = new float[4];
//															Matrix.multiplyMV(transformedOriginal, 0, debuggingInfo2.getProductTranformationMatrix(), 0, vertex, 0);
//															float[] transformedNew = new float[4];
//															int index2 = debuggingInfo3.getIndices()[i];
//															float[] vertex2 = new float[]{debuggingInfo3.getVertices()[index2 * 3], debuggingInfo3.getVertices()[index2 * 3 + 1], debuggingInfo3.getVertices()[index2 * 3 + 2], 1};
//															Matrix.multiplyMV(transformedNew, 0, totalTranformationMatrix, 0, vertex2, 0);
//															
//															// TODO margin should depend on bb of complete model
//															if (!almostTheSame((String)ifcProduct.get("GlobalId"), transformedNew, transformedOriginal, 0.05F)) {
//																geometryGenerationDebugger.transformedVertexNotMatching(ifcProduct, transformedOriginal, transformedNew, debuggingInfo2.getProductTranformationMatrix(), totalTranformationMatrix);
//															}
//														}
//													}
													
//												almostTheSame((String)ifcProduct.get("GlobalId"), debuggingInfo2.getProductTranformationMatrix(), totalTranformationMatrix, 0.01D);
//												}
											}

											IntBuffer indices = masterGeometryData.getIndices();
											for (int i = 0; i < indices.capacity(); i++) {
												this.streamingGeometryGenerator.processExtends(minBounds, maxBounds, totalTranformationMatrix, masterGeometryData.getVertices(), indices.get(i) * 3, generateGeometryResult);
											}

											HashMapWrappedVirtualObject boundsUntransformedMm = createMmBounds(geometryInfo, boundsUntransformed, generateGeometryResult.getMultiplierToMm());
											geometryInfo.set("boundsUntransformedMm", boundsUntransformedMm);
											HashMapWrappedVirtualObject boundsMm = createMmBounds(geometryInfo, bounds, generateGeometryResult.getMultiplierToMm());
											geometryInfo.set("boundsMm", boundsMm);
											
											float nrTriangles = masterGeometryData.getNrPrimitives();

											Density density = new Density(eClass.getName(), (float) volume, getBiggestFaceFromBounds(boundsUntransformedMm), (long) nrTriangles, geometryInfo.getOid());

											geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_Density(), density.getDensityValue());
											
											generateGeometryResult.addDensity(density);
											
											HashMapVirtualObject referencedData = databaseSession.getFromCache(masterGeometryData.getOid());
											Integer currentValue = (Integer) referencedData.get("reused");
											referencedData.set("reused", currentValue + 1);
											HashMapWrappedVirtualObject dataBounds = (HashMapWrappedVirtualObject) referencedData.get("boundsMm");
											extendBounds(boundsMm, dataBounds);
											
											// TODO this keeping track of the amount of reuse, takes it's toll on memory usage. Basically all geometry ends up in memory by the time the Geometry generation is done
											// We should try to see whether we can use BDB's mechanism to do partial retrievals/updates of a records here, because we only need to update just one value
											// Another, simpler option would be to introduce another layer between GeometryInfo and GeometryData, so we don't have to cache the actual data (vertices etc... the bulk)
											// In that case however the BinarySerializer would increase in complexity
											
											// This seems to have been partially solved now since GeometryData does not contain the bulk of the data anymore (the byte[]s are now in "Buffer").
											
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
						Metrics metrics = renderEngine.getMetrics();
						if (metrics != null) {
							job.setCpuTimeMs(metrics.getCpuTimeMs());
							job.setMaxMemoryBytes(metrics.getMaxMemoryBytes());
						}
						renderEnginePool.returnObject(renderEngine);
					}
					try {
						if (!notFoundObjects.isEmpty()) {
							writeDebugFile(bytes, false, notFoundObjects);
							StringBuilder sb = new StringBuilder();
							for (Long key : notFoundObjects.keySet()) {
								sb.append(key + " (" + notFoundObjects.get(key).getOid() + ")");
								sb.append(", ");
							}
							sb.delete(sb.length() - 2, sb.length());
							job.setException(new Exception("Missing objects in model (" + sb.toString() + ")"));
						} else if (writeOutputFiles) {
							writeDebugFile(bytes, false, null);
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
				writeDebugFile(bytes, true, null);
				job.setException(e);
				// LOGGER.error("Original query: " + originalQuery, e);
			}
		} catch (Exception e) {
			StreamingGeometryGenerator.LOGGER.error("", e);
			// LOGGER.error("Original query: " + originalQuery, e);
		}
		long end = System.nanoTime();
		job.setEndNanos(end);
	}

	private BufferSet appendInvertedGeometry(IntBuffer indicesAsInt, DoubleBuffer verticesAsDouble, FloatBuffer normalsAsFloat, IntBuffer colorIndices) {
		indicesAsInt.position(0);
		normalsAsFloat.position(0);
		
		ByteBuffer newVerticesByteBuffer = ByteBuffer.allocate(verticesAsDouble.capacity() * 16);
		DoubleBuffer newVerticesBuffer = newVerticesByteBuffer.order(ByteOrder.LITTLE_ENDIAN).asDoubleBuffer();
		verticesAsDouble.position(0);
		newVerticesBuffer.put(verticesAsDouble);
		verticesAsDouble.position(0);
		newVerticesBuffer.put(verticesAsDouble);
		
		int nrVertices = verticesAsDouble.capacity() / 3;
		
		ByteBuffer newIntByteBuffer = ByteBuffer.allocate(indicesAsInt.capacity() * 8);
		IntBuffer newIntBuffer = newIntByteBuffer.order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
		for (int i=0; i<indicesAsInt.capacity(); i+=3) {
			int index1 = indicesAsInt.get();
			int index2 = indicesAsInt.get();
			int index3 = indicesAsInt.get();
			newIntBuffer.put(i, index1);
			newIntBuffer.put(i + 1, index2);
			newIntBuffer.put(i + 2, index3);
			
			// And draw the same triangle again in a different order
			newIntBuffer.put(i + indicesAsInt.capacity(), index1 + nrVertices);
			newIntBuffer.put(i + indicesAsInt.capacity() + 1, index3 + nrVertices);
			newIntBuffer.put(i + indicesAsInt.capacity() + 2, index2 + nrVertices);
		}

		ByteBuffer newNormalsByteBuffer = ByteBuffer.allocate(normalsAsFloat.capacity() * 8);
		FloatBuffer newNormalsBuffer = newNormalsByteBuffer.order(ByteOrder.LITTLE_ENDIAN).asFloatBuffer();
		normalsAsFloat.position(0);
		newNormalsBuffer.put(normalsAsFloat);
		for (int i=0; i<normalsAsFloat.capacity(); i+=3) {
			float[] normal = new float[] {normalsAsFloat.get(i + 0), normalsAsFloat.get(i + 1), normalsAsFloat.get(i + 2)};
			normal = Vector.invert(normal);
			newNormalsBuffer.put(i + normalsAsFloat.capacity(), normal[0]);
			newNormalsBuffer.put(i + 1 + normalsAsFloat.capacity(), normal[1]);
			newNormalsBuffer.put(i + 2 + normalsAsFloat.capacity(), normal[2]);
		}
		
		ByteBuffer newColorsByteBuffer = ByteBuffer.allocate(colorIndices.capacity() * 8);
		IntBuffer newColorsBuffer = newColorsByteBuffer.order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
		colorIndices.position(0);
		newColorsBuffer.put(colorIndices);
		colorIndices.position(0);
		newColorsBuffer.put(colorIndices);
		
		return new BufferSet(newIntByteBuffer, newVerticesByteBuffer, newNormalsByteBuffer, newColorsByteBuffer);
	}

	private void dump(String string, IntBuffer materialIndices) {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<materialIndices.capacity(); i++) {
			sb.append(materialIndices.get(i) + ", ");
		}
		LOGGER.info(string + ": " + sb.toString());
	}

	private void dump(String string, FloatBuffer floatBuffer) {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<floatBuffer.capacity(); i++) {
			sb.append(floatBuffer.get(i) + ", ");
		}
		LOGGER.info(string + ": " + sb.toString());
	}

	private double setCalculatedQuantities(RenderEngineInstance renderEngineInstance, HashMapVirtualObject geometryInfo, double volume) throws RenderEngineException, BimserverDatabaseException {
		if (streamingGeometryGenerator.isCalculateQuantities()) {
			ObjectNode additionalData = renderEngineInstance.getAdditionalData();
			if (additionalData != null) {
				geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_AdditionalData(), additionalData.toString());
				if (additionalData.has("TOTAL_SURFACE_AREA")) {
					geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_Area(), additionalData.get("TOTAL_SURFACE_AREA").asDouble());
				}
				if (additionalData.has("TOTAL_SHAPE_VOLUME")) {
					volume = additionalData.get("TOTAL_SHAPE_VOLUME").asDouble();
					geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_Volume(), volume);
				}
			}
		}
		return volume;
	}

	private boolean detectTwoFaceTriangles(HashMapVirtualObject ifcProduct, IntBuffer indicesAsInt, DoubleBuffer verticesAsDouble, float margin) {
		Set<ComplexLine2> complexLines = new TreeSet<>();
		for (int i=0; i<indicesAsInt.capacity(); i+=3) {
			for (int j=0; j<3; j++) {
				int index1 = indicesAsInt.get(i + j);
				int index2 = indicesAsInt.get(i + (j + 1) % 3);
				
				ComplexLine2 line2 = new ComplexLine2(index1, index2, verticesAsDouble, margin);
				if (complexLines.contains(line2)) {
					complexLines.remove(line2);
				} else {
					complexLines.add(line2);
				}
			}
		}
		if (!complexLines.isEmpty()) {
			LOGGER.debug("Probably a non-closed object in " + ifcProduct.eClass().getName() + " (" + complexLines.size() + ")");
			return true;
		}
		return false;
	}
	
	private ByteBuffer generateLineRendering(HashMapVirtualObject ifcProduct, IntBuffer indicesAsInt, DoubleBuffer verticesAsDouble, FloatBuffer normalsAsFloat, float margin) {
		Set<ComplexLine> lines = new TreeSet<>();
		for (int i=0; i<indicesAsInt.capacity(); i+=3) {
			for (int j=0; j<3; j++) {
				int index1 = indicesAsInt.get(i + j);
				int index2 = indicesAsInt.get(i + (j + 1) % 3);
				ComplexLine line = new ComplexLine(index1, index2, verticesAsDouble, normalsAsFloat, margin);
				if (lines.contains(line)) {
					lines.remove(line);
				} else {
					lines.add(line);
				}
			}
		}
		
		ComplexLine lastLine = null;
		int size = 0;
		
		for (ComplexLine line : lines) {
			if (lastLine != null && Arrays.equals(lastLine.getV1(), line.getV1()) && Arrays.equals(lastLine.getV2(), line.getV2())) {
				continue;
			}
			lastLine = line;
			size++;
		}
		ByteBuffer byteBuffer = ByteBuffer.allocate(size * 2 * 4).order(ByteOrder.LITTLE_ENDIAN);
		IntBuffer newIndices = byteBuffer.asIntBuffer();
		for (ComplexLine line : lines) {
			if (Arrays.equals(lastLine.getV1(), line.getV1()) && Arrays.equals(lastLine.getV2(), line.getV2())) {
				// Only one line needs to be drawn in the end, regardless of the normal
				continue;
			}
			newIndices.put(line.getIndex1());
			newIndices.put(line.getIndex2());
			lastLine = line;
//			System.out.println(line);
		}
		return byteBuffer;
	}
	
	private ByteBuffer generateLineRendering(IntBuffer indicesAsInt) {
		Set<Line> lines = new HashSet<>();
		for (int i=0; i<indicesAsInt.capacity(); i+=3) {
			for (int j=0; j<3; j++) {
				int index1 = indicesAsInt.get(i + j);
				int index2 = indicesAsInt.get(i + (j + 1) % 3);
				Line line = new Line(index1, index2);
				if (lines.contains(line)) {
					lines.remove(line);
				} else {
					lines.add(line);
				}
			}
		}
		ByteBuffer byteBuffer = ByteBuffer.allocate(lines.size() * 2 * 4).order(ByteOrder.LITTLE_ENDIAN);
		IntBuffer newIndices = byteBuffer.asIntBuffer();
		for (Line line : lines) {
			newIndices.put(line.getIndex1());
			newIndices.put(line.getIndex2());
		}
		return byteBuffer;
	}

	private float fixColor(float input) {
		if (input >= 0 && input <=1) {
			return input;
		}
		return 0.5f;
	}
	
	private long createBuffer(QueryContext queryContext, ByteBuffer data) throws BimserverDatabaseException {
		HashMapVirtualObject buffer = new HashMapVirtualObject(queryContext, GeometryPackage.eINSTANCE.getBuffer());
		buffer.set("data", data.array());
		buffer.save();
		return buffer.getOid();
	}

	private ByteBuffer quantizeColors(byte[] vertex_colors) {
		ByteBuffer quantizedColors = ByteBuffer.wrap(new byte[vertex_colors.length]);
		for (int i=0; i<vertex_colors.length; i++) {
			float c = vertex_colors[i];
			quantizedColors.put(UnsignedBytes.checkedCast((int) (c * 255)));
		}
		return quantizedColors;
	}

	private ByteBuffer quantizeNormals(FloatBuffer normals) {
		ByteBuffer quantizedNormals = ByteBuffer.wrap(new byte[normals.capacity()]);
		quantizedNormals.order(ByteOrder.LITTLE_ENDIAN);
		for (int i=0; i<normals.capacity(); i++) {
			float normal = normals.get(i);
			quantizedNormals.put((byte)(normal * 127));
		}
		return quantizedNormals;
	}

	private float[] createQuantizationMatrixFromBounds(HashMapWrappedVirtualObject boundsMm) {
		float[] matrix = Matrix.identityF();
		float scale = 32768;
		
		HashMapWrappedVirtualObject min = (HashMapWrappedVirtualObject) boundsMm.get("min");
		HashMapWrappedVirtualObject max = (HashMapWrappedVirtualObject) boundsMm.get("max");
		
		// Move the model with its center to the origin
		Matrix.translateM(matrix, 0, (float)(-((double)max.eGet("x") + (double)min.eGet("x")) / 2f), (float)(-((double)max.eGet("y") + (double)min.eGet("y")) / 2f), (float)(-((double)max.eGet("z") + (double)min.eGet("z")) / 2f));

		// Scale the model to make sure all values fit within a 2-byte signed short
		Matrix.scaleM(matrix, 0, (float)(scale / ((double)max.eGet("x") - (double)min.eGet("x"))), (float)(scale / ((double)max.eGet("y") - (double)min.eGet("y"))), (float)(scale / ((double)max.eGet("z") - (double)min.eGet("z"))));

		return matrix;
	}

	private ByteBuffer quantizeVertices(float[] vertices, float[] quantizationMatrix, float multiplierToMm) {
		ByteBuffer quantizedBuffer = ByteBuffer.wrap(new byte[vertices.length * 2]);
		quantizedBuffer.order(ByteOrder.LITTLE_ENDIAN);
		
		float[] vertex = new float[4];
		float[] result = new float[4];
		vertex[3] = 1;
		int nrVertices = vertices.length;
		for (int i=0; i<nrVertices; i+=3) {
			vertex[0] = vertices[i];
			vertex[1] = vertices[i+1];
			vertex[2] = vertices[i+2];
	
			if (multiplierToMm != 1f) {
				vertex[0] = vertex[0] * multiplierToMm;
				vertex[1] = vertex[1] * multiplierToMm;
				vertex[2] = vertex[2] * multiplierToMm;
			}

			Matrix.multiplyMV(result, 0, quantizationMatrix, 0, vertex, 0);
			
			quantizedBuffer.putShort((short)result[0]);
			quantizedBuffer.putShort((short)result[1]);
			quantizedBuffer.putShort((short)result[2]);
		}

		return quantizedBuffer;
	}

	private void extendBounds(HashMapWrappedVirtualObject source, HashMapWrappedVirtualObject target) throws BimserverDatabaseException {
		HashMapWrappedVirtualObject sourceMin = (HashMapWrappedVirtualObject) source.eGet("min");
		HashMapWrappedVirtualObject sourceMax = (HashMapWrappedVirtualObject) source.eGet("max");
		
		HashMapWrappedVirtualObject targetMin = (HashMapWrappedVirtualObject) target.eGet("min");
		HashMapWrappedVirtualObject targetMax = (HashMapWrappedVirtualObject) target.eGet("max");
		
		extendMin(sourceMin, targetMin);
		extendMax(sourceMax, targetMax);
	}
	
	private void extendMin(HashMapWrappedVirtualObject sourceMin, HashMapWrappedVirtualObject targetMin) throws BimserverDatabaseException {
		if (((double)sourceMin.get("x")) < (double)targetMin.get("x")) {
			targetMin.set("x", sourceMin.get("x"));
		}
		if (((double)sourceMin.get("y")) < (double)targetMin.get("y")) {
			targetMin.set("y", sourceMin.get("y"));
		}
		if (((double)sourceMin.get("z")) < (double)targetMin.get("z")) {
			targetMin.set("z", sourceMin.get("z"));
		}
	}

	private void extendMax(HashMapWrappedVirtualObject sourceMax, HashMapWrappedVirtualObject targetMax) throws BimserverDatabaseException {
		if (((double)sourceMax.get("x")) > (double)targetMax.get("x")) {
			targetMax.set("x", sourceMax.get("x"));
		}
		if (((double)sourceMax.get("y")) > (double)targetMax.get("y")) {
			targetMax.set("y", sourceMax.get("y"));
		}
		if (((double)sourceMax.get("z")) > (double)targetMax.get("z")) {
			targetMax.set("z", sourceMax.get("z"));
		}
	}
	
	private float getVolumeFromBounds(HashMapWrappedVirtualObject bounds) throws GeometryGeneratingException { 
		HashMapWrappedVirtualObject min = (HashMapWrappedVirtualObject) bounds.eGet("min");
		HashMapWrappedVirtualObject max = (HashMapWrappedVirtualObject) bounds.eGet("max");
		
		double minX = (double)min.eGet(min.eClass().getEStructuralFeature("x"));
		double minY = (double)min.eGet(min.eClass().getEStructuralFeature("y"));
		double minZ = (double)min.eGet(min.eClass().getEStructuralFeature("z"));

		double maxX = (double)max.eGet(max.eClass().getEStructuralFeature("x"));
		double maxY = (double)max.eGet(max.eClass().getEStructuralFeature("y"));
		double maxZ = (double)max.eGet(max.eClass().getEStructuralFeature("z"));
		
		float volume = (float) (
				(maxX - minX) *
				(maxY - minY) *
				(maxZ - minZ));
		
		if (volume == 0f) {
			volume = 0.00001f;
		}

		return volume;
	}

	private float getBiggestFaceFromBounds(HashMapWrappedVirtualObject bounds) throws GeometryGeneratingException {
		HashMapWrappedVirtualObject min = (HashMapWrappedVirtualObject) bounds.eGet("min");
		HashMapWrappedVirtualObject max = (HashMapWrappedVirtualObject) bounds.eGet("max");

		double minX = (double)min.eGet(min.eClass().getEStructuralFeature("x"));
		double minY = (double)min.eGet(min.eClass().getEStructuralFeature("y"));
		double minZ = (double)min.eGet(min.eClass().getEStructuralFeature("z"));

		double maxX = (double)max.eGet(max.eClass().getEStructuralFeature("x"));
		double maxY = (double)max.eGet(max.eClass().getEStructuralFeature("y"));
		double maxZ = (double)max.eGet(max.eClass().getEStructuralFeature("z"));
		
		float front = (float) ((maxX - minX) * (maxY - minY));
		float top = (float) ((maxX - minX) * (maxZ - minZ));
		float side = (float) ((maxY - minY) * (maxZ - minZ));
		
		return Math.max(Math.max(front, top), side);
	}

	private HashMapWrappedVirtualObject createMmBounds(HashMapVirtualObject geometryInfo, HashMapWrappedVirtualObject boundsUntransformed, float toMmFactor) throws BimserverDatabaseException {
		HashMapWrappedVirtualObject boundsMm = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getBounds());
		WrappedVirtualObject minBoundsMm = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getVector3f());
		WrappedVirtualObject maxBoundsMm = new HashMapWrappedVirtualObject(GeometryPackage.eINSTANCE.getVector3f());
		
		boundsMm.setReference(GeometryPackage.eINSTANCE.getBounds_Min(), minBoundsMm);
		boundsMm.setReference(GeometryPackage.eINSTANCE.getBounds_Max(), maxBoundsMm);
		
		HashMapWrappedVirtualObject min = (HashMapWrappedVirtualObject) boundsUntransformed.eGet("min");
		HashMapWrappedVirtualObject max = (HashMapWrappedVirtualObject) boundsUntransformed.eGet("max");
		
		minBoundsMm.set("x", toMmFactor * (double)min.eGet("x"));
		minBoundsMm.set("y", toMmFactor * (double)min.eGet("y"));
		minBoundsMm.set("z", toMmFactor * (double)min.eGet("z"));

		maxBoundsMm.set("x", toMmFactor * (double)max.eGet("x"));
		maxBoundsMm.set("y", toMmFactor * (double)max.eGet("y"));
		maxBoundsMm.set("z", toMmFactor * (double)max.eGet("z"));
		
		return boundsMm;
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
	
	private synchronized void writeDebugFile(byte[] bytes, boolean error, Map<Long, HashMapVirtualObject> notFoundObjects) throws FileNotFoundException, IOException {
		boolean debug = true;
		if (debug) {
			Path debugPath = this.streamingGeometryGenerator.bimServer.getHomeDir().resolve("debug");
			if (!Files.exists(debugPath)) {
				Files.createDirectories(debugPath);
			}

			Path folder = debugPath.resolve(this.streamingGeometryGenerator.getDebugIdentifier());
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

			Path file = folder.resolve(basefilenamename + "-" + job.getId() + ".ifc");
			job.getReport().addDebugFile(file.toString(), job.getId());

//			if (notFoundObjects != null) {
//				StringBuilder sb = new StringBuilder();
//				for (Integer expressId : notFoundObjects.keySet()) {
//					sb.append(notFoundObjects.get(expressId) + ": " + expressId + "\r\n");
//				}
//				FileUtils.writeStringToFile(Paths.get(file.toAbsolutePath().toString() + ".txt").toFile(), sb.toString());
//			}

//			StreamingGeometryGenerator.LOGGER.info("Writing debug file to " + file.toAbsolutePath().toString());
			FileUtils.writeByteArrayToFile(file.toFile(), bytes);
		}
	}
}