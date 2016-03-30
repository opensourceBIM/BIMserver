package org.bimserver;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.io.IOUtils;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.actions.ProgressListener;
import org.bimserver.database.queries.QueryObjectProvider;
import org.bimserver.database.queries.om.Include;
import org.bimserver.database.queries.om.JsonQueryObjectModelConverter;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.Schema;
import org.bimserver.geometry.Matrix;
import org.bimserver.geometry.Vector;
import org.bimserver.models.geometry.GeometryPackage;
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
import org.bimserver.shared.QueryException;
import org.bimserver.shared.VirtualObject;
import org.bimserver.shared.WrappedVirtualObject;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.Formatters;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StreamingGeometryGenerator {
	private static final Logger LOGGER = LoggerFactory.getLogger(StreamingGeometryGenerator.class);
	
	private final BimServer bimServer;
	private final Map<Integer, Long> hashes = new ConcurrentHashMap<>();

	private EClass productClass;
	private EStructuralFeature geometryFeature;
	private EStructuralFeature representationFeature;
	private PackageMetaData packageMetaData;

	private AtomicLong bytesSaved = new AtomicLong();
	private AtomicLong totalBytes = new AtomicLong();

	private AtomicInteger jobsDone = new AtomicInteger();
	private AtomicInteger jobsTotal = new AtomicInteger();

	private ProgressListener progressListener;

	private volatile boolean allJobsPushed;

	public StreamingGeometryGenerator(final BimServer bimServer, ProgressListener progressListener) {
		this.bimServer = bimServer;
		this.progressListener = progressListener;
	}
	
	public class Runner implements Runnable {

		private EClass eClass;
		private RenderEngineSettings renderEngineSettings;
		private RenderEngineFilter renderEngineFilter;
		private RenderEngineFilter renderEngineFilterTransformed = new RenderEngineFilter(true);
		private StreamingSerializerPlugin ifcSerializerPlugin;
		private GenerateGeometryResult generateGeometryResult;
		private ObjectProvider objectProvider;
		private QueryContext queryContext;
		private DatabaseSession databaseSession;
		private RenderEnginePool renderEnginePool;
		private Query originalQuery;

		public Runner(EClass eClass, RenderEnginePool renderEnginePool, DatabaseSession databaseSession, RenderEngineSettings renderEngineSettings, ObjectProvider objectProvider, StreamingSerializerPlugin ifcSerializerPlugin, RenderEngineFilter renderEngineFilter, GenerateGeometryResult generateGeometryResult, QueryContext queryContext, Query originalQuery) {
			this.eClass = eClass;
			this.renderEnginePool = renderEnginePool;
			this.databaseSession = databaseSession;
			this.renderEngineSettings = renderEngineSettings;
			this.objectProvider = objectProvider;
			this.ifcSerializerPlugin = ifcSerializerPlugin;
			this.renderEngineFilter = renderEngineFilter;
			this.generateGeometryResult = generateGeometryResult;
			this.queryContext = queryContext;
			this.originalQuery = originalQuery;
		}
		
		@Override
		public void run() {
			try {
				HashMapVirtualObject next;
				next = objectProvider.next();
				Query query = new Query("test", packageMetaData);
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
					renderEngine = renderEnginePool.borrowObject();
					final Set<HashMapVirtualObject> oids = new HashSet<>();
					ObjectProviderProxy proxy = new ObjectProviderProxy(objectProvider, new ObjectListener() {
						@Override
						public void newObject(HashMapVirtualObject next) {
							if (eClass.isSuperTypeOf(next.eClass())) {
								oids.add(next);
							}
						}
					});
					ifcSerializer.init(proxy, null, null, bimServer.getPluginManager(), packageMetaData);
	
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					IOUtils.copy(ifcSerializer.getInputStream(), baos);
					bytes = baos.toByteArray();
					InputStream in = new ByteArrayInputStream(bytes);
					RenderEngineModel renderEngineModel = renderEngine.openModel(in);
					try {
						if (!oids.isEmpty()) {
							renderEngineModel.setSettings(renderEngineSettings);
							renderEngineModel.setFilter(renderEngineFilter);
	
							try {
								renderEngineModel.generateGeneralGeometry();
							} catch (RenderEngineException e) {
								if (e.getCause() instanceof java.io.EOFException) {
									if (oids.isEmpty() || eClass.getName().equals("IfcAnnotation")) {
										// SKIP
									} else {
										LOGGER.error("Error in " + eClass.getName(), e);
									}
								}
							}
							
							OidConvertingSerializer oidConvertingSerializer = (OidConvertingSerializer)ifcSerializer;
							Map<Long, Integer> oidToEid = oidConvertingSerializer.getOidToEid();
							
							for (HashMapVirtualObject ifcProduct : oids) {
								Integer expressId = oidToEid.get(ifcProduct.getOid());
								if (ifcProduct.eGet(representationFeature) != null) {
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
											
											WrappedVirtualObject minBounds = new HashMapWrappedVirtualObject(queryContext, GeometryPackage.eINSTANCE.getVector3f());
											WrappedVirtualObject maxBounds = new HashMapWrappedVirtualObject(queryContext, GeometryPackage.eINSTANCE.getVector3f());
											
											minBounds.set("x", Double.POSITIVE_INFINITY);
											minBounds.set("y", Double.POSITIVE_INFINITY);
											minBounds.set("z", Double.POSITIVE_INFINITY);
											
											maxBounds.set("x", -Double.POSITIVE_INFINITY);
											maxBounds.set("y", -Double.POSITIVE_INFINITY);
											maxBounds.set("z", -Double.POSITIVE_INFINITY);
											
											geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_MinBounds(), minBounds);
											geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_MaxBounds(), maxBounds);
	
	//										try {
	//											double area = renderEngineInstance.getArea();
	//											geometryInfo.setArea(area);
	//											double volume = renderEngineInstance.getVolume();
	//											if (volume < 0d) {
	//												volume = -volume;
	//											}
	//											geometryInfo.setVolume(volume);
	//										} catch (NotImplementedException e) {
	//										}
											
											VirtualObject geometryData = new HashMapVirtualObject(queryContext, GeometryPackage.eINSTANCE.getGeometryData());
	
											geometryData.setAttribute(GeometryPackage.eINSTANCE.getGeometryData_Indices(), intArrayToByteArray(geometry.getIndices()));
											geometryData.setAttribute(GeometryPackage.eINSTANCE.getGeometryData_Vertices(), floatArrayToByteArray(geometry.getVertices()));
											geometryData.setAttribute(GeometryPackage.eINSTANCE.getGeometryData_MaterialIndices(), intArrayToByteArray(geometry.getMaterialIndices()));
											geometryData.setAttribute(GeometryPackage.eINSTANCE.getGeometryData_Normals(), floatArrayToByteArray(geometry.getNormals()));
											
											geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_PrimitiveCount(), geometry.getIndices().length / 3);
	
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
													geometryData.setAttribute(GeometryPackage.eINSTANCE.getGeometryData_Materials(), floatArrayToByteArray(vertex_colors));
												}
											}
	
											double[] tranformationMatrix = new double[16];
											if (translate && renderEngineInstance.getTransformationMatrix() != null) {
												tranformationMatrix = renderEngineInstance.getTransformationMatrix();
											} else {
												Matrix.setIdentityM(tranformationMatrix, 0);
											}
	
											for (int i = 0; i < geometry.getIndices().length; i++) {
												processExtends(geometryInfo, tranformationMatrix, geometry.getVertices(), geometry.getIndices()[i] * 3, generateGeometryResult);
											}
											
											calculateObb(geometryInfo, tranformationMatrix, geometry.getIndices(), geometry.getVertices(), generateGeometryResult);
	
											geometryInfo.setReference(GeometryPackage.eINSTANCE.getGeometryInfo_Data(), geometryData.getOid(), 0);
	
											long size = getSize(geometryData);
	
											setTransformationMatrix(geometryInfo, tranformationMatrix);
											if (bimServer.getServerSettingsCache().getServerSettings().isReuseGeometry()) {
												int hash = hash(geometryData);
												if (hashes.containsKey(hash)) {
													geometryInfo.setReference(GeometryPackage.eINSTANCE.getGeometryInfo_Data(), hashes.get(hash), 0);
													bytesSaved.addAndGet(size);
												} else {
	//												if (sizes.containsKey(size) && sizes.get(size).eClass() == ifcProduct.eClass()) {
	//													LOGGER.info("More reuse might be possible " + size + " " + ifcProduct.eClass().getName() + ":" + ifcProduct.getOid() + " / " + sizes.get(size).eClass().getName() + ":" + sizes.get(size).getOid());
	//												}
													hashes.put(hash, geometryData.getOid());
													geometryData.save();
	//												sizes.put(size, ifcProduct);
												}
											} else {
												geometryData.save();
											}
											geometryInfo.save();
											totalBytes.addAndGet(size);
	
											ifcProduct.setReference(geometryFeature, geometryInfo.getOid(), 0);
											ifcProduct.saveOverwrite();
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
											LOGGER.info("Entity not found " + ifcProduct.eClass().getName() + " " + (expressId) + "/" + ifcProduct.getOid());
										}
									} catch (BimserverDatabaseException | RenderEngineException e) {
										LOGGER.error("", e);
									}
								}
							}						
						}
					} finally {
						in.close();
						renderEngineModel.close();
						if (renderEngine != null) {
							renderEnginePool.returnObject(renderEngine);
						}
						jobsDone.incrementAndGet();
						updateProgress();
					}
				} catch (Exception e) {
					boolean debug = true;
					if (debug) {
						String basefilenamename = "all";
						if (eClass != null) {
							basefilenamename = eClass.getName();
						}
						File file = new File(basefilenamename + ".ifc");
						int i=0;
						while (file.exists()) {
							file = new File(basefilenamename + "-" + i + ".ifc");
							i++;
						}
						FileOutputStream fos = new FileOutputStream(file);
						IOUtils.copy(new ByteArrayInputStream(bytes), fos);
						fos.close();
					}
//					LOGGER.error("Original query: " + originalQuery, e);
				}
			} catch (Exception e) {
//				LOGGER.error("Original query: " + originalQuery, e);
			}
		}

		private void calculateObb(VirtualObject geometryInfo, double[] tranformationMatrix, int[] indices, float[] vertices, GenerateGeometryResult generateGeometryResult2) {
			
		}
	}

	private void updateProgress() {
		if (allJobsPushed) {
			progressListener.updateProgress("Generating geometry...", (int) (100.0 * jobsDone.get() / jobsTotal.get()));
		}
	}
	
	public GenerateGeometryResult generateGeometry(long uoid, final DatabaseSession databaseSession, QueryContext queryContext) throws BimserverDatabaseException, GeometryGeneratingException {
		GenerateGeometryResult generateGeometryResult = new GenerateGeometryResult();
		packageMetaData = queryContext.getPackageMetaData();
		productClass = packageMetaData.getEClass("IfcProduct");
		geometryFeature = productClass.getEStructuralFeature("geometry");
		representationFeature = productClass.getEStructuralFeature("Representation");

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

			RenderEnginePool renderEnginePool = bimServer.getRenderEnginePools().getRenderEnginePool(packageMetaData.getSchema(), defaultRenderEngine.getPluginDescriptor().getPluginClassName());
			
			ThreadPoolExecutor executor = new ThreadPoolExecutor(maxSimultanousThreads, maxSimultanousThreads, 24, TimeUnit.HOURS, new ArrayBlockingQueue<Runnable>(10000000));
			
			for (EClass eClass : queryContext.getOidCounters().keySet()) {
				if (packageMetaData.getEClass("IfcProduct").isSuperTypeOf(eClass)) {
					Query query2 = new Query("test", packageMetaData);
					QueryPart queryPart2 = query2.createQueryPart();
					queryPart2.addType(eClass, false);
					QueryObjectProvider queryObjectProvider2 = new QueryObjectProvider(databaseSession, bimServer, query2, Collections.singleton(queryContext.getRoid()), packageMetaData);
					HashMapVirtualObject next = queryObjectProvider2.next();
					while (next != null) {
						if (next.eClass() == eClass) {
							Query query = new Query("test", packageMetaData);
							QueryPart queryPart = query.createQueryPart();
							queryPart.addType(eClass, false);
							int x = 0;
							queryPart.addOid(next.getOid());
							while (next != null && x < 99) {
								next = queryObjectProvider2.next();
								if (next != null) {
									if (next.eClass() == eClass) {
										x++;
										queryPart.addOid(next.getOid());
									}
								}
							}
							JsonQueryObjectModelConverter jsonQueryObjectModelConverter = new JsonQueryObjectModelConverter(packageMetaData);
							queryPart.addInclude(jsonQueryObjectModelConverter.getDefineFromFile("validifc:ContainedInStructure"));
							queryPart.addInclude(jsonQueryObjectModelConverter.getDefineFromFile("validifc:OwnerHistory"));
							Include representation = jsonQueryObjectModelConverter.getDefineFromFile("validifc:Representation");
							queryPart.addInclude(representation);
							Include objectPlacement = jsonQueryObjectModelConverter.getDefineFromFile("validifc:ObjectPlacement");
							queryPart.addInclude(objectPlacement);
							if (packageMetaData.getEClass("IfcWall").isSuperTypeOf(eClass)) {
								Include ifcWall = queryPart.createInclude();
								ifcWall.addType(packageMetaData.getEClass(eClass.getName()), false);
								ifcWall.addField("HasOpenings");
								Include hasOpenings = ifcWall.createInclude();
								hasOpenings.addType(packageMetaData.getEClass("IfcRelVoidsElement"), false);
								hasOpenings.addField("RelatedOpeningElement");
								hasOpenings.addInclude(representation);
								hasOpenings.addInclude(objectPlacement);
								//						Include relatedOpeningElement = hasOpenings.createInclude();
								//						relatedOpeningElement.addType(packageMetaData.getEClass("IfcOpeningElement"), false);
								//						relatedOpeningElement.addField("HasFillings");
								//						Include hasFillings = relatedOpeningElement.createInclude();
								//						hasFillings.addType(packageMetaData.getEClass("IfcRelFillsElement"), false);
								//						hasFillings.addField("RelatedBuildingElement");
							}
							QueryObjectProvider queryObjectProvider = new QueryObjectProvider(databaseSession, bimServer, query, Collections.singleton(queryContext.getRoid()), packageMetaData);
							
							Runner runner = new Runner(eClass, renderEnginePool, databaseSession, settings, queryObjectProvider, ifcSerializerPlugin, renderEngineFilter, generateGeometryResult, queryContext, query);
							executor.submit(runner);
							jobsTotal.incrementAndGet();
						}
						next = queryObjectProvider2.next();
					}
				}
			}
			
			allJobsPushed = true;
			
			executor.shutdown();
			executor.awaitTermination(24, TimeUnit.HOURS);				

			long end = System.nanoTime();
			LOGGER.info("Rendertime: " + ((end - start) / 1000000) + "ms, " + "Reused: " + Formatters.bytesToString(bytesSaved.get()) + ", Total: " + Formatters.bytesToString(totalBytes.get()) + ", Final: " + Formatters.bytesToString(totalBytes.get() - bytesSaved.get()));
		} catch (Exception e) {
			LOGGER.error("", e);
			throw new GeometryGeneratingException(e);
		}
		return generateGeometryResult;
	}
	
	private long getSize(VirtualObject geometryData) {
		long size = 0;
		if (geometryData.has("indices")) {
			size += ((byte[])geometryData.get("vertices")).length;
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
			hashCode += Arrays.hashCode((byte[])geometryData.get("vertices"));
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

	private void processExtends(VirtualObject geometryInfo, double[] transformationMatrix, float[] vertices, int index, GenerateGeometryResult generateGeometryResult) throws BimserverDatabaseException {
		double x = vertices[index];
		double y = vertices[index + 1];
		double z = vertices[index + 2];
		
		double[] result = new double[4];
		
//		double[] rotationMatrix = new double[16];
//		Matrix.setIdentityM(rotationMatrix, 0);
//		Matrix.rotateM(rotationMatrix, 0, -37.5d, 0d, 0d, 1d);
//		
//		Matrix.multiplyMV(result, 0, rotationMatrix, 0, new double[] { x, y, z, 1 }, 0);
//
//		x = result[0];
//		y = result[1];
//		z = result[2];
		
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

		generateGeometryResult.getMinBounds().setX(Math.min(x, generateGeometryResult.getMinBounds().getX()));
		generateGeometryResult.getMinBounds().setY(Math.min(y, generateGeometryResult.getMinBounds().getY()));
		generateGeometryResult.getMinBounds().setZ(Math.min(z, generateGeometryResult.getMinBounds().getZ()));
		generateGeometryResult.getMaxBounds().setX(Math.max(x, generateGeometryResult.getMaxBounds().getX()));
		generateGeometryResult.getMaxBounds().setY(Math.max(y, generateGeometryResult.getMaxBounds().getY()));
		generateGeometryResult.getMaxBounds().setZ(Math.max(z, generateGeometryResult.getMaxBounds().getZ()));
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

	private void setTransformationMatrix(VirtualObject geometryInfo, double[] transformationMatrix) throws BimserverDatabaseException {
		ByteBuffer byteBuffer = ByteBuffer.allocate(16 * 8);
		byteBuffer.order(ByteOrder.nativeOrder());
		DoubleBuffer asDoubleBuffer = byteBuffer.asDoubleBuffer();
		for (double d : transformationMatrix) {
			asDoubleBuffer.put(d);
		}
		geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_Transformation(), byteBuffer.array());
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
}