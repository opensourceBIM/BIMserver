package org.bimserver;

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
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
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

	private AtomicLong bytesSaved = new AtomicLong();
	private AtomicLong totalBytes = new AtomicLong();
	private AtomicLong saveableColorBytes = new AtomicLong();

	private AtomicInteger jobsDone = new AtomicInteger();
	private AtomicInteger jobsTotal = new AtomicInteger();

	private ProgressListener progressListener;

	private volatile boolean allJobsPushed;

	private int maxObjectsPerFile = 10;
	private volatile boolean running = true;

	public StreamingGeometryGenerator(final BimServer bimServer, ProgressListener progressListener) {
		this.bimServer = bimServer;
		this.progressListener = progressListener;
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
	
											renderEngineInstance.getArea();
											
											geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_Area(), renderEngineInstance.getArea());
											geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_Volume(), renderEngineInstance.getVolume());
											
											VirtualObject geometryData = new HashMapVirtualObject(queryContext, GeometryPackage.eINSTANCE.getGeometryData());
	
											int[] indices = geometry.getIndices();
											geometryData.setAttribute(GeometryPackage.eINSTANCE.getGeometryData_Indices(), intArrayToByteArray(indices));
											float[] vertices = geometry.getVertices();
											geometryData.setAttribute(GeometryPackage.eINSTANCE.getGeometryData_Vertices(), floatArrayToByteArray(vertices));
//												geometryData.setAttribute(GeometryPackage.eINSTANCE.getGeometryData_MaterialIndices(), intArrayToByteArray(geometry.getMaterialIndices()));
											geometryData.setAttribute(GeometryPackage.eINSTANCE.getGeometryData_Normals(), floatArrayToByteArray(geometry.getNormals()));
											
											geometryInfo.setAttribute(GeometryPackage.eINSTANCE.getGeometryInfo_PrimitiveCount(), indices.length / 3);

											Set<Color4f> usedColors = new HashSet<>();
											
											int saveableColorBytes = 0;
											
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
												if (!usedColors.isEmpty()) {
													if (usedColors.size() == 1) {
														saveableColorBytes = (4 * vertex_colors.length) - 16;
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
	
											for (int i = 0; i < indices.length; i++) {
												processExtends(geometryInfo, tranformationMatrix, vertices, indices[i] * 3, generateGeometryResult);
											}
											
											calculateObb(geometryInfo, tranformationMatrix, indices, vertices, generateGeometryResult);
	
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
													StreamingGeometryGenerator.this.saveableColorBytes.addAndGet(saveableColorBytes);
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
											
											// Doing a sync here because probably writing large amounts of data, and db only syncs every 100.000 writes by default
											databaseSession.getKeyValueStore().sync();
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
											LOGGER.warn("Entity not found " + ifcProduct.eClass().getName() + " " + (expressId) + "/" + ifcProduct.getOid());
										}
									} catch (BimserverDatabaseException | RenderEngineException e) {
										LOGGER.error("", e);
									}
								}
							}
						}
					} finally {
						try {
	//						if (notFoundsObjects) {
//								writeDebugFile(bytes, false);
	//							Thread.sleep(60000);
	//						}
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
					writeDebugFile(bytes, true);
//					LOGGER.error("Original query: " + originalQuery, e);
				}
			} catch (Exception e) {
				LOGGER.error("", e);
//				LOGGER.error("Original query: " + originalQuery, e);
			}
		}

		private void writeDebugFile(byte[] bytes, boolean error) throws FileNotFoundException, IOException {
			boolean debug = true;
			if (debug) {
				Path debugPath = bimServer.getHomeDir().resolve("debug");
				if (!Files.exists(debugPath)) {
					Files.createDirectories(debugPath);
				}
				String basefilenamename = "all";
				if (eClass != null) {
					basefilenamename = eClass.getName();
				}
				if (error) {
					basefilenamename += "-error";
				}
				Path file = debugPath.resolve(basefilenamename + ".ifc");
				int i=0;
				while (Files.exists((file))) {
					file = debugPath.resolve(basefilenamename + "-" + i + ".ifc");
					i++;
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

			RenderEnginePool renderEnginePool = bimServer.getRenderEnginePools().getRenderEnginePool(packageMetaData.getSchema(), defaultRenderEngine.getPluginDescriptor().getPluginClassName(), new PluginConfiguration(defaultRenderEngine.getSettings()));
			
			ThreadPoolExecutor executor = new ThreadPoolExecutor(maxSimultanousThreads, maxSimultanousThreads, 24, TimeUnit.HOURS, new ArrayBlockingQueue<Runnable>(10000000));

			Map<Long, AtomicInteger> counters = new HashMap<>();
			
			for (EClass eClass : queryContext.getOidCounters().keySet()) {
				if (packageMetaData.getEClass("IfcProduct").isSuperTypeOf(eClass)) {
					Query query2 = new Query("test", packageMetaData);
					QueryPart queryPart2 = query2.createQueryPart();
					queryPart2.addType(eClass, false);
					Include include = queryPart2.createInclude();
					include.addType(eClass, false);
					include.addFieldDirect("Representation");
					QueryObjectProvider queryObjectProvider2 = new QueryObjectProvider(databaseSession, bimServer, query2, Collections.singleton(queryContext.getRoid()), packageMetaData);
					HashMapVirtualObject next = queryObjectProvider2.next();
					while (next != null) {
						if (next.eClass() == eClass) {
							Set<Long> representationItems = getRepresentationItems(databaseSession, queryContext, next);
							for (Long l : representationItems) {
								AtomicInteger atomicInteger = counters.get(l);
								if (atomicInteger == null) {
									atomicInteger = new AtomicInteger(0);
									counters.put(l, atomicInteger);
								}
								atomicInteger.incrementAndGet();
							}
							HashMapVirtualObject representation = next.getDirectFeature(representationFeature);
							if (representation != null) {
								List<Long> representations = (List<Long>) representation.get("Representations");
								if (representations != null && !representations.isEmpty()) {
									Query query = new Query("test", packageMetaData);
									QueryPart queryPart = query.createQueryPart();
									queryPart.addType(eClass, false);
									int x = 0;
									queryPart.addOid(next.getOid());
									while (next != null && x < maxObjectsPerFile - 1) {
										next = queryObjectProvider2.next();
										if (next != null) {
											if (next.eClass() == eClass) {
												representation = next.getDirectFeature(representationFeature);
												if (representation != null) {
													representations = (List<Long>) representation.get("Representations");
													if (representations != null && !representations.isEmpty()) {
														queryPart.addOid(next.getOid());
														x++;
													}
												}
											}
										}
									}
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
									
									Runner runner = new Runner(eClass, renderEnginePool, databaseSession, settings, queryObjectProvider, ifcSerializerPlugin, renderEngineFilter, generateGeometryResult, queryContext, query);
									executor.submit(runner);
									jobsTotal.incrementAndGet();
									
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
			LOGGER.info("Rendertime: " + ((end - start) / 1000000) + "ms, " + "Reused: " + Formatters.bytesToString(bytesSaved.get()) + ", Total: " + Formatters.bytesToString(totalBytes.get()) + ", Final: " + Formatters.bytesToString(totalBytes.get() - bytesSaved.get()));
			LOGGER.info("Saveable color data: " + Formatters.bytesToString(saveableColorBytes.get()));
		} catch (Exception e) {
			running = false;
			LOGGER.error("", e);
			throw new GeometryGeneratingException(e);
		}
		return generateGeometryResult;
	}
	
	private Set<Long> getRepresentationItems(DatabaseSession databaseSession, QueryContext queryContext, HashMapVirtualObject next) throws QueryException, IOException {
		Set<Long> result = new HashSet<>();
		Query query = new Query("test", packageMetaData);
		
		Include representation = query.createDefine("Representation");
		representation.addType(packageMetaData.getEClass("IfcShapeRepresentation"), true);
		representation.addField("Items");
		Include mapped = representation.createInclude();
		mapped.addType(packageMetaData.getEClass("IfcMappedItem"), true);
		mapped.addField("MappingSource");
		Include mappingSource = mapped.createInclude();
		mappingSource.addType(packageMetaData.getEClass("IfcRepresentationMap"), false);
		mappingSource.addField("MappedRepresentation");
		mappingSource.addInclude(representation);
		
		QueryPart queryPart = query.createQueryPart();
		queryPart.addOid(next.getOid());
		Include include = queryPart.createInclude();
		include.addType(next.eClass(), false);
		include.addField("Representation");
		Include representations = include.createInclude();
		representations.addType(packageMetaData.getEClass("IfcProductDefinitionShape"), true);
		representations.addField("Representations");
		representations.addInclude(representation);
		
		QueryObjectProvider queryObjectProvider = new QueryObjectProvider(databaseSession, bimServer, query, Collections.singleton(queryContext.getRoid()), packageMetaData);
		try {
			HashMapVirtualObject next2 = queryObjectProvider.next();
			while (next2 != null) {
				if (packageMetaData.getEClass("IfcRepresentationItem").isSuperTypeOf(next2.eClass())) {
					result.add(next2.getOid());
				}
				next2 = queryObjectProvider.next();
			}
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		}
		return result;
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
}