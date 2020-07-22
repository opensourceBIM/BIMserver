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

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
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
import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.GenerateGeometryResult;
import org.bimserver.GenericGeometryGenerator;
import org.bimserver.GeometryGeneratingException;
import org.bimserver.ProductDef;
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
import org.bimserver.models.geometry.Bounds;
import org.bimserver.models.geometry.GeometryPackage;
import org.bimserver.models.geometry.Vector3f;
import org.bimserver.models.store.RenderEnginePluginConfiguration;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSettings;
import org.bimserver.plugins.renderengine.IndexFormat;
import org.bimserver.plugins.renderengine.Precision;
import org.bimserver.plugins.renderengine.RenderEngine;
import org.bimserver.plugins.renderengine.RenderEngineFilter;
import org.bimserver.plugins.renderengine.RenderEngineSettings;
import org.bimserver.plugins.renderengine.VersionInfo;
import org.bimserver.plugins.serializers.StreamingSerializerPlugin;
import org.bimserver.renderengine.RenderEnginePool;
import org.bimserver.shared.AbstractHashMapVirtualObject;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.HashMapWrappedVirtualObject;
import org.bimserver.shared.QueryContext;
import org.bimserver.shared.VirtualObject;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.Formatters;
import org.bimserver.utils.IfcUtils;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StreamingGeometryGenerator extends GenericGeometryGenerator {
	static final Logger LOGGER = LoggerFactory.getLogger(StreamingGeometryGenerator.class);
	
	final BimServer bimServer;
	final Map<Integer, Long> hashes = new ConcurrentHashMap<>();

	private EClass productClass;
	EReference geometryFeature;
	EStructuralFeature representationFeature;
	PackageMetaData packageMetaData;

	AtomicLong bytesSavedByHash = new AtomicLong();
	private AtomicLong bytesSavedByTransformation = new AtomicLong();
	AtomicLong bytesSavedByMapping = new AtomicLong();
	AtomicLong totalBytes = new AtomicLong();

	AtomicInteger jobsDone = new AtomicInteger();
	private AtomicInteger jobsTotal = new AtomicInteger();

	private ProgressListener progressListener;

	private volatile boolean allJobsPushed;

	volatile boolean running = true;

	private String debugIdentifier;

	private EStructuralFeature representationsFeature;

	private EStructuralFeature itemsFeature;

	private EStructuralFeature mappingSourceFeature;

	private String renderEngineName;

	private Long eoid = -1L;
	private GeometryGenerationReport report;

	private boolean reuseGeometry;
	private boolean optimizeMappedItems;
	
	private final Map<Long, Tuple<HashMapVirtualObject, ByteBuffer>> geometryDataMap = new ConcurrentHashMap<>();

	private GeometryGenerationDebugger geometryGenerationDebugger = new GeometryGenerationDebugger();

	private boolean applyLayerSets;

	private boolean calculateQuantities;

	public StreamingGeometryGenerator(final BimServer bimServer, ProgressListener progressListener, Long eoid, GeometryGenerationReport report) {
		this.bimServer = bimServer;
		this.progressListener = progressListener;
		this.eoid = eoid;
		this.report = report;
	}
	
	void updateProgress() {
		if (allJobsPushed) {
			if (progressListener != null) {
				progressListener.updateProgress("Generating geometry...", (int) (100.0 * jobsDone.get() / jobsTotal.get()));
			}
		}
	}
	
	private boolean hasValidRepresentationIdentifier(AbstractHashMapVirtualObject representationItem) {
		String representationIdentifier = (String) representationItem.get("RepresentationIdentifier");
		return representationIdentifier != null && (representationIdentifier.equals("Body") || representationIdentifier.equals("Facetation") || (applyLayerSets && representationIdentifier.contentEquals("Axis")));
	}
	
	@SuppressWarnings("unchecked")
	public GenerateGeometryResult generateGeometry(long uoid, final DatabaseSession databaseSession, QueryContext queryContext, long nrObjects) throws BimserverDatabaseException, GeometryGeneratingException {
		GenerateGeometryResult generateGeometryResult = new GenerateGeometryResult();
		packageMetaData = queryContext.getPackageMetaData();
		productClass = packageMetaData.getEClass("IfcProduct");
		geometryFeature = (EReference) productClass.getEStructuralFeature("geometry");
		representationFeature = productClass.getEStructuralFeature("Representation");
		representationsFeature = packageMetaData.getEClass("IfcProductDefinitionShape").getEStructuralFeature("Representations");
		itemsFeature = packageMetaData.getEClass("IfcShapeRepresentation").getEStructuralFeature("Items");
		mappingSourceFeature = packageMetaData.getEClass("IfcMappedItem").getEStructuralFeature("MappingSource");

		GregorianCalendar now = new GregorianCalendar();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		debugIdentifier = dateFormat.format(now.getTime()) + " (" + report.getOriginalIfcFileName() + ")";

		long start = System.nanoTime();
		String pluginName = "";
		if (queryContext.getPackageMetaData().getSchema() == Schema.IFC4) {
			pluginName = "org.bimserver.ifc.step.serializer.Ifc4StepStreamingSerializerPlugin";
		} else if (queryContext.getPackageMetaData().getSchema() == Schema.IFC2X3TC1) {
			pluginName = "org.bimserver.ifc.step.serializer.Ifc2x3tc1StepStreamingSerializerPlugin";
		} else {
			throw new GeometryGeneratingException("Unknown schema " + queryContext.getPackageMetaData().getSchema());
		}
		
		reuseGeometry = bimServer.getServerSettingsCache().getServerSettings().isReuseGeometry();
		optimizeMappedItems = bimServer.getServerSettingsCache().getServerSettings().isOptimizeMappedItems();
		
		report.setStart(new GregorianCalendar());
		report.setIfcSchema(queryContext.getPackageMetaData().getSchema());
		report.setUseMappingOptimization(optimizeMappedItems);
		report.setReuseGeometry(reuseGeometry);

		try {
			final StreamingSerializerPlugin ifcSerializerPlugin = (StreamingSerializerPlugin) bimServer.getPluginManager().getPlugin(pluginName, true);
			if (ifcSerializerPlugin == null) {
				throw new UserException("No IFC serializer found");
			}

			User user = (User) databaseSession.get(uoid, org.bimserver.database.OldQuery.getDefault());
			UserSettings userSettings = user.getUserSettings();
			
			report.setUserName(user.getName());
			report.setUserUserName(user.getUsername());
			
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

			int availableProcessors = Runtime.getRuntime().availableProcessors();
			report.setAvailableProcessors(availableProcessors);
			
			int maxSimultanousThreads = Math.min(bimServer.getServerSettingsCache().getServerSettings().getRenderEngineProcesses(), availableProcessors);
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

			RenderEnginePool renderEnginePool = bimServer.getRenderEnginePools().getRenderEnginePool(packageMetaData.getSchema(), renderEngine.getPluginDescriptor().getPluginClassName(), bimServer.getPluginSettingsCache().getPluginSettings(renderEngine.getOid()));
			
			report.setRenderEngineName(renderEngine.getName());
			report.setRenderEnginePluginVersion(renderEngine.getPluginDescriptor().getPluginBundleVersion().getVersion());
			
			VersionInfo versionInfo = renderEnginePool.getRenderEngineFactory().getVersionInfo();
			report.setRenderEngineVersion(versionInfo);

			// TODO there must be a cleaner way of getting this info, since it's in the database...
			RenderEngine engine = renderEnginePool.borrowObject();
			try {
				applyLayerSets = engine.isApplyLayerSets();
				report.setApplyLayersets(applyLayerSets);

				calculateQuantities = engine.isCalculateQuantities();
				report.setCalculateQuantities(calculateQuantities);
			} finally {
				renderEnginePool.returnObject(engine);
			}
			
			// TODO reuse, pool the pools :) Or something smarter
			// TODO reuse queue, or try to determine a realistic size, or don't use a fixed-size queue
			ThreadPoolExecutor executor = new ThreadPoolExecutor(maxSimultanousThreads, maxSimultanousThreads, 24, TimeUnit.HOURS, new ArrayBlockingQueue<Runnable>(10000000));

			JsonQueryObjectModelConverter jsonQueryObjectModelConverter = new JsonQueryObjectModelConverter(packageMetaData);
			String queryNameSpace = packageMetaData.getSchema().name().toLowerCase() + "-stdlib";
			
			// All references should already be direct, since this is now done in BimServer on startup, quite the hack...
			Include objectPlacement = jsonQueryObjectModelConverter.getDefineFromFile(queryNameSpace + ":ObjectPlacement", true);
			
			Set<EClass> classes = null;
			if (queryContext.getOidCounters() != null) {
				classes = queryContext.getOidCounters().keySet();
			} else {
				classes = packageMetaData.getEClasses();
			}

			float multiplierToMm = processUnits(databaseSession, queryContext);
			generateGeometryResult.setMultiplierToMm(multiplierToMm);
			
			// Phase 1 (mapped item detection) sometimes detects that mapped items have invalid (unsupported) RepresentationIdentifier values, this set keeps track of objects to skip in Phase 2 because of that
			Set<Long> toSkip = new HashSet<>();
			
			// Less than 100 objects -> Use 1 object per process (so we have progress indication per 1%)
			// More than 100 objects -> Use # objects / 100 objects per process
			// Unless the amount of objects becomes > 100 / process, than cap it on 100
			
			int regularObjectCount = 0;
			
			Set<EClass> typesToDo = new HashSet<>();
			
			Set<Long> done = new HashSet<>();

			for (EClass eClass : classes) {
				if (packageMetaData.getEClass("IfcProduct").isSuperTypeOf(eClass)) {
					Query query2 = new Query(eClass.getName() + "Main query", packageMetaData);
					QueryPart queryPart2 = query2.createQueryPart();
					queryPart2.addType(eClass, false);
					Include representationInclude = queryPart2.createInclude();
					representationInclude.addType(eClass, false);
					representationInclude.addFieldDirect("Representation");
					Include representationsInclude = representationInclude.createInclude();
					representationsInclude.addType(packageMetaData.getEClass("IfcProductRepresentation"), true);
					representationsInclude.addFieldDirect("Representations");
					Include itemsInclude = representationsInclude.createInclude();
					itemsInclude.addType(packageMetaData.getEClass("IfcShapeRepresentation"), false);
					itemsInclude.addFieldDirect("Items");
					itemsInclude.addFieldDirect("ContextOfItems");
					Include mappingSourceInclude = itemsInclude.createInclude();
					mappingSourceInclude.addType(packageMetaData.getEClass("IfcMappedItem"), false);
					mappingSourceInclude.addFieldDirect("MappingSource");
					mappingSourceInclude.addFieldDirect("MappingTarget");
					Include representationMap = mappingSourceInclude.createInclude();
					representationMap.addType(packageMetaData.getEClass("IfcRepresentationMap"), false);
					representationMap.addFieldDirect("MappedRepresentation");
					Include createInclude = representationMap.createInclude();
					createInclude.addType(packageMetaData.getEClass("IfcShapeRepresentation"), true);
					
					Include targetInclude = mappingSourceInclude.createInclude();
					targetInclude.addType(packageMetaData.getEClass("IfcCartesianTransformationOperator3D"), false);
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
							AbstractHashMapVirtualObject representation = next.getDirectFeature(representationFeature);
							if (representation != null) {
								Set<HashMapVirtualObject> representations = representation.getDirectListFeature(representationsFeature);
								if (representations != null) {
									boolean foundValidContext = false;
									for (HashMapVirtualObject representationItem : representations) {
										if (usableContext(representationItem)) {
											foundValidContext = true;
											break;
										}
									}
									boolean stop = false;
									Set<String> counts = new HashSet<>();
									for (HashMapVirtualObject representationItem : representations) {
										String representationIdentifier = (String) representationItem.get("RepresentationIdentifier");
										if (counts.contains(representationIdentifier)) {
											stop = true;
										} else {
											counts.add(representationIdentifier);
										}
									}
									if (stop) {
										next = queryObjectProvider2.next();
										continue;
									}
									for (HashMapVirtualObject representationItem : representations) {
										if (!usableContext(representationItem) && foundValidContext) {
											continue;
										}
										
										// TODO Geometries that are the same, but have different colors, will result in geometry with the wrong color, for example SampleModelErrorExportLight.ifc
										// So what we need to do is also compare the materials...

										if (hasValidRepresentationIdentifier(representationItem)) {
											Set<HashMapVirtualObject> items = representationItem.getDirectListFeature(itemsFeature);
											if (items == null || items.size() > 1) {
												// Only if there is just one item, we'll store this for reuse
												// TODO actually we could store them for > 1 as well, only they should only be used (2nd stage) for products that use the exact same items, for now
												regularObjectCount++;
												continue;
											}
											// So this next loop always results in 1 (or no) loops
											for (HashMapVirtualObject item : items) {
												report.addRepresentationItem(item.eClass().getName());
												if (!packageMetaData.getEClass("IfcMappedItem").isSuperTypeOf(item.eClass())) {
													regularObjectCount++;
													continue; // All non IfcMappedItem objects will be done in phase 2
												}
												AbstractHashMapVirtualObject mappingTarget = item.getDirectFeature(packageMetaData.getEReference("IfcMappedItem", "MappingTarget"));
												AbstractHashMapVirtualObject mappingSourceOfMappedItem = item.getDirectFeature(packageMetaData.getEReference("IfcMappedItem", "MappingSource"));
												if (mappingSourceOfMappedItem == null) {
													LOGGER.info("No mapping source");
													continue;
												}
												AbstractHashMapVirtualObject mappedRepresentation = mappingSourceOfMappedItem.getDirectFeature(packageMetaData.getEReference("IfcRepresentationMap", "MappedRepresentation"));

												if (!hasValidRepresentationIdentifier(mappedRepresentation)) {
													// Skip this mapping, we should store somewhere that this object should also be skipped in the normal way
													String identifier = (String) mappedRepresentation.get("RepresentationIdentifier");
													report.addSkippedBecauseOfInvalidRepresentationIdentifier(identifier);
													toSkip.add(next.getOid());
													continue;
												}
												double[] mappingMatrix = Matrix.identity();
												double[] productMatrix = Matrix.identity();
												if (mappingTarget != null) {
													AbstractHashMapVirtualObject axis1 = mappingTarget.getDirectFeature(packageMetaData.getEReference("IfcCartesianTransformationOperator", "Axis1"));
													AbstractHashMapVirtualObject axis2 = mappingTarget.getDirectFeature(packageMetaData.getEReference("IfcCartesianTransformationOperator", "Axis2"));
													AbstractHashMapVirtualObject axis3 = mappingTarget.getDirectFeature(packageMetaData.getEReference("IfcCartesianTransformationOperator3D", "Axis3"));
													AbstractHashMapVirtualObject localOrigin = mappingTarget.getDirectFeature(packageMetaData.getEReference("IfcCartesianTransformationOperator", "LocalOrigin"));
													
													double[] a1 = null;
													double[] a2 = null;
													double[] a3 = null;

													if (axis3 != null) {
														List<Double> list = (List<Double>) axis3.get("DirectionRatios");
														a3 = new double[]{list.get(0), list.get(1), list.get(2)};
														Vector.normalize(a3);
													} else {
														a3 = new double[]{0, 0, 1};
													}

													if (axis1 != null) {
														List<Double> list = (List<Double>) axis1.get("DirectionRatios");
														a1 = new double[]{list.get(0), list.get(1), list.get(2)};
														Vector.normalize(a1);
													} else {
														if (a3[0] == 1 && a3[1] == 0 && a3[2] == 0) {
															a1 = new double[]{0, 1, 0};
														} else {
															a1 = new double[]{1, 0, 0};
														}
													}
													
													double[] xVec = Vector.scalarProduct(Vector.dot(a1, a3), a3);
										            double[] xAxis = Vector.subtract(a1, xVec);
										            Vector.normalize(xAxis);

										            if (axis2 != null) {
										            	List<Double> list = (List<Double>) axis2.get("DirectionRatios");
														a2 = new double[]{list.get(0), list.get(1), list.get(2)};
														Vector.normalize(a2);
										            } else {
										            	a2 = new double[]{0, 1, 0};
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
												}
												
												AbstractHashMapVirtualObject placement = next.getDirectFeature(packageMetaData.getEReference("IfcProduct", "ObjectPlacement"));
												if (placement != null) {
													productMatrix = placementToMatrix(placement);
												}
												
												AbstractHashMapVirtualObject mappingSource = item.getDirectFeature(mappingSourceFeature);
												if (mappingSource != null) {
													Map<Long, ProductDef> map = representationMapToProduct.get(((HashMapVirtualObject)mappingSource).getOid());
													if (map == null) {
														map = new LinkedHashMap<>();
														representationMapToProduct.put(((HashMapVirtualObject)mappingSource).getOid(), map);
													}
													ProductDef pd = new ProductDef(next.getOid());
													pd.setMappedItemOid(item.getOid());
													pd.setObject(next);
													
													pd.setProductMatrix(productMatrix);
													pd.setMappingMatrix(mappingMatrix);
													pd.setRepresentationOid(representationItem.getOid());
													map.put(next.getOid(), pd);
												}
											}
										} else {
											report.addSkippedBecauseOfInvalidRepresentationIdentifier((String) representationItem.get("RepresentationIdentifier"));
										}
									}
								}
							}
						}
						next = queryObjectProvider2.next();
					}
					
					for (Long repMapId : representationMapToProduct.keySet()) {
						Map<Long, ProductDef> map = representationMapToProduct.get(repMapId);
						
						// When there is more than one instance using this mapping
						if (map.size() > 1) {
							Query query = new Query("Reuse query " + eClass.getName(), packageMetaData);
							query.setDoubleBuffer(true);
							QueryPart queryPart = query.createQueryPart();
//							QueryPart queryPart3 = query.createQueryPart();
							queryPart.addType(eClass, false);
//							queryPart3.addType(packageMetaData.getEClass("IfcMappedItem"), false);

							long masterOid = map.values().iterator().next().getOid();
							
							double[] inverted = Matrix.identity();
							ProductDef masterProductDef = map.get(masterOid);
							if (!Matrix.invertM(inverted, 0, masterProductDef.getMappingMatrix(), 0)) {
								LOGGER.debug("No inverse, this mapping will be skipped and processed as normal");
								// This is probably because of mirroring of something funky
								
								// TODO we should however be able to squeeze out a little more reuse by finding another master...
								continue;
							}
							
							Set<Long> representationOids = new HashSet<>();
							
							for (ProductDef pd : map.values()) {
								done.add(pd.getOid());
								if (!optimizeMappedItems) {
									queryPart.addOid(pd.getOid());
									representationOids.add(pd.getRepresentationOid());
									
									// In theory these should be fused together during querying
//									queryPart3.addOid(pd.getMappedItemOid());
								} else {
									pd.setMasterOid(masterOid);
								}
							}
							if (optimizeMappedItems) {
								queryPart.addOid(masterOid);
								representationOids.add(masterProductDef.getRepresentationOid());
							}
							
							LOGGER.debug("Running " + map.size() + " objects in one batch because of reused geometry " + (eClass.getName()));

//							queryPart3.addInclude(jsonQueryObjectModelConverter.getDefineFromFile("ifc2x3tc1-stdlib:IfcMappedItem"));
							
							processQuery(databaseSession, queryContext, generateGeometryResult, ifcSerializerPlugin, settings, renderEngineFilter, renderEnginePool, executor, eClass, query, queryPart, true, map, map.size(), representationOids);
						}
					}
					
					typesToDo.add(eClass);
				}
			}
			
//			LOGGER.info("Regular object count: " + regularObjectCount);
			
			int maxObjectsPerFile = regularObjectCount / 100;
			if (regularObjectCount < 100) {
				maxObjectsPerFile = 1;
			}
			if (maxObjectsPerFile > 100) {
				maxObjectsPerFile = 100;
			}
			
//			maxObjectsPerFile = 1;
			
			report.setMaxPerFile(maxObjectsPerFile);
			
//			LOGGER.info("Max objects per file: " + maxObjectsPerFile);
			
			for (EClass eClass : typesToDo) {
				Query query3 = new Query("Remaining " + eClass.getName(), packageMetaData);
				QueryPart queryPart3 = query3.createQueryPart();
				queryPart3.addType(eClass, false);
				Include include3 = queryPart3.createInclude();
				include3.addType(eClass, false);
				include3.addFieldDirect("Representation");
				Include rInclude = include3.createInclude();
				rInclude.addType(packageMetaData.getEClass("IfcProductRepresentation"), true);
				rInclude.addFieldDirect("Representations");
				Include representationsInclude2 = rInclude.createInclude();
				representationsInclude2.addType(packageMetaData.getEClass("IfcShapeModel"), true);
				representationsInclude2.addFieldDirect("ContextOfItems");
				
				Query query = new Query("Main " + eClass.getName(), packageMetaData);
				query.setDoubleBuffer(true);
				QueryPart queryPart = query.createQueryPart();
				int written = 0;

				QueryObjectProvider queryObjectProvider2 = new QueryObjectProvider(databaseSession, bimServer, query3, Collections.singleton(queryContext.getRoid()), packageMetaData);
				HashMapVirtualObject next = queryObjectProvider2.next();
				
				Set<Long> representationOids = new HashSet<>();
				while (next != null) {
					// Not sure why the duplicate code in the next 20 lines
					if (next.eClass() == eClass && !done.contains(next.getOid()) && !toSkip.contains(next.getOid())) {
						AbstractHashMapVirtualObject representation = next.getDirectFeature(representationFeature);
						if (representation != null) {
							Set<HashMapVirtualObject> list = representation.getDirectListFeature(packageMetaData.getEReference("IfcProductRepresentation", "Representations"));
							Set<Long> goForIt = goForIt(list);
							if (!goForIt.isEmpty()) {
								if (next.eClass() == eClass && !done.contains(next.getOid())) {
									representation = next.getDirectFeature(representationFeature);
									if (representation != null) {
										list = representation.getDirectListFeature(packageMetaData.getEReference("IfcProductRepresentation", "Representations"));
										Set<Long> goForIt2 = goForIt(list);
										if (!goForIt2.isEmpty()) {
											queryPart.addOid(next.getOid());
											representationOids.addAll(goForIt2);
											written++;
											if (written >= maxObjectsPerFile) {
												processQuery(databaseSession, queryContext, generateGeometryResult, ifcSerializerPlugin, settings, renderEngineFilter, renderEnginePool, executor, eClass, query, queryPart, false, null, written, representationOids);
												query = new Query("Main " + eClass.getName(), packageMetaData);
												query.setDoubleBuffer(true);
												queryPart = query.createQueryPart();
												written = 0;
												representationOids.clear();
											}
										}
									}
								}
							}
						}
					}
					next = queryObjectProvider2.next();
				}
				if (written > 0) {
					processQuery(databaseSession, queryContext, generateGeometryResult, ifcSerializerPlugin, settings, renderEngineFilter, renderEnginePool, executor, eClass, query, queryPart, false, null, written, representationOids);
				}
			}
			
			allJobsPushed = true;
			
			executor.shutdown();
			executor.awaitTermination(24, TimeUnit.HOURS);
//			LOGGER.info(executor.getCompletedTaskCount() + " jobs executed");
			
			// Need total bounds
//			float[] quantizationMatrix = createQuantizationMatrixFromBounds(boundsMm);
//			ByteBuffer verticesQuantized = quantizeVertices(vertices, quantizationMatrix, generateGeometryResult.getMultiplierToMm());
//			geometryData.setAttribute(GeometryPackage.eINSTANCE.getGeometryData_VerticesQuantized(), verticesQuantized.array());

			
			// TODO, disable?
			if (true) {
				LOGGER.debug("Generating quantized vertices");
				double[] quantizationMatrix = createQuantizationMatrixFromBounds(generateGeometryResult.getBoundsUntransformed(), multiplierToMm);
				for (Long id : geometryDataMap.keySet()) {
					Tuple<HashMapVirtualObject, ByteBuffer> tuple = geometryDataMap.get(id);
					
					HashMapVirtualObject buffer = new HashMapVirtualObject(queryContext, GeometryPackage.eINSTANCE.getBuffer());
//				Buffer buffer = databaseSession.create(Buffer.class);
					buffer.set("data", quantizeVertices(tuple.getB().asDoubleBuffer(), quantizationMatrix, multiplierToMm).array());
//				buffer.setData(quantizeVertices(tuple.getB(), quantizationMatrix, multiplierToMm).array());
//				databaseSession.store(buffer);
					buffer.save();
					HashMapVirtualObject geometryData = tuple.getA();
					geometryData.set("verticesQuantized", buffer.getOid());
					int reused = (int) geometryData.eGet(GeometryPackage.eINSTANCE.getGeometryData_Reused());
					int nrTriangles = (int) geometryData.eGet(GeometryPackage.eINSTANCE.getGeometryData_NrIndices()) / 3;
					int saveableTriangles = Math.max(0, (reused - 1)) * nrTriangles;
					geometryData.set("saveableTriangles", saveableTriangles);
//				if (saveableTriangles > 0) {
//					System.out.println("Saveable triangles: " + saveableTriangles);
//				}
					geometryData.saveOverwrite();
				}
			}

			long end = System.nanoTime();
			long total = totalBytes.get() - (bytesSavedByHash.get() + bytesSavedByTransformation.get() + bytesSavedByMapping.get());
			LOGGER.info("Rendertime: " + Formatters.nanosToString(end - start) + ", " + "Reused (by hash): " + Formatters.bytesToString(bytesSavedByHash.get()) + ", Reused (by transformation): " + Formatters.bytesToString(bytesSavedByTransformation.get()) + ", Reused (by mapping): " + Formatters.bytesToString(bytesSavedByMapping.get()) + ", Total: " + Formatters.bytesToString(totalBytes.get()) + ", Final: " + Formatters.bytesToString(total));
			if (report.getNumberOfDebugFiles() > 0) {
				LOGGER.error("[" + report.getOriginalIfcFileName() + "] Number of erroneous files: " + report.getNumberOfDebugFiles());
			}
			SkippedBecauseOfInvalidRepresentation skipped = report.getSkippedBecauseOfInvalidRepresentationIdentifier();
			if (skipped.hasImportant()) {
				LOGGER.warn("[" + report.getOriginalIfcFileName() + "] Number of representations skipped:");
				for (String identifier : skipped.getImportantSet()) {
					LOGGER.warn("\t" + identifier + ": " + skipped.get(identifier));
				}
			}
			String dump = geometryGenerationDebugger.dump();
			if (dump != null) {
				LOGGER.info(dump);
			}
		} catch (Exception e) {
			running = false;
			LOGGER.error("", e);
			report.setEnd(new GregorianCalendar());
			throw new GeometryGeneratingException(e);
		}
		report.setEnd(new GregorianCalendar());
		try {
			if (report.getNumberOfDebugFiles() > 0) {
				writeDebugFile();
			}
		} catch (IOException e) {
			LOGGER.debug("", e);
		}
		return generateGeometryResult;
	}
	
	private double[] createQuantizationMatrixFromBounds(Bounds bounds, float multiplierToMm) {
		double[] matrix = Matrix.identity();
		double scale = 32768;
		
		Vector3f min = bounds.getMin();
		Vector3f max = bounds.getMax();
		
		double[] minArray = new double[] {
			min.getX() * multiplierToMm,
			min.getY() * multiplierToMm,
			min.getZ() * multiplierToMm
		};

		double[] maxArray = new double[] {
			max.getX() * multiplierToMm,
			max.getY() * multiplierToMm,
			max.getZ() * multiplierToMm
		};
		
		// Scale the model to make sure all values fit within a 2-byte signed short
		Matrix.scaleM(matrix, 0, 
				scale / (maxArray[0] - minArray[0]), 
				scale / (maxArray[1] - minArray[1]),
				scale / (maxArray[2] - minArray[2]));

		// Move the model with its center to the origin
		Matrix.translateM(matrix, 0, 
				-(maxArray[0] + minArray[0]) / 2f, 
				-(maxArray[1] + minArray[1]) / 2f, 
				-(maxArray[2] + minArray[2]) / 2f);

		// Scale to mm
//		Matrix.scaleM(matrix, 0, multiplierToMm, multiplierToMm, multiplierToMm);
		
		return matrix;
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

	private ByteBuffer quantizeVertices(DoubleBuffer vertices, double[] quantizationMatrix, double multiplierToMm) {
		ByteBuffer quantizedBuffer = ByteBuffer.wrap(new byte[vertices.capacity() * 2]);
		quantizedBuffer.order(ByteOrder.LITTLE_ENDIAN);
		
		double[] vertex = new double[4];
		double[] result = new double[4];
		vertex[3] = 1;
		int nrVertices = vertices.capacity();
		for (int i=0; i<nrVertices; i+=3) {
			vertex[0] = vertices.get(i);
			vertex[1] = vertices.get(i+1);
			vertex[2] = vertices.get(i+2);
	
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

	private float processUnits(DatabaseSession databaseSession, QueryContext queryContext) throws QueryException, IOException, BimserverDatabaseException {
		Query query = new Query("Unit query", packageMetaData);
		QueryPart unitQueryPart = query.createQueryPart();
		unitQueryPart.addType(packageMetaData.getEClass("IfcProject"), false);
		Include unitsInContextInclude = unitQueryPart.createInclude();
		unitsInContextInclude.addType(packageMetaData.getEClass("IfcProject"), false);
		unitsInContextInclude.addField("UnitsInContext");
		Include units = unitsInContextInclude.createInclude();
		units.addType(packageMetaData.getEClass("IfcUnitAssignment"), false);
		units.addField("Units");
		Include unit = units.createInclude();
		unit.addType(packageMetaData.getEClass("IfcSIUnit"), false);
		
		QueryObjectProvider queryObjectProvider = new QueryObjectProvider(databaseSession, bimServer, query, Collections.singleton(queryContext.getRoid()), packageMetaData);
		HashMapVirtualObject next = queryObjectProvider.next();
		while (next != null) {
			if (packageMetaData.getEClass("IfcSIUnit").isSuperTypeOf(next.eClass())) {
				if (next.get("UnitType") == packageMetaData.getEEnumLiteral("IfcUnitEnum", "LENGTHUNIT").getInstance()) {
					Object prefix = next.get("Prefix");
					if (prefix == null) {
						// Meters, we need to multiply by 1000 to go to mm
						return 1000f;
					}
					return IfcUtils.getLengthUnitPrefixMm(((Enumerator) prefix).getName()) * 1000f;
				}
			}
			next = queryObjectProvider.next();
		}
		// Assume meters, we need to multiply by 1000
		return 1000f;
	}

	private Set<Long> goForIt(Set<HashMapVirtualObject> list) {
		Set<Long> representationOids = new HashSet<>();
		if (list != null) {
			boolean foundValidContext = false;
			for (HashMapVirtualObject representationItem : list) {
				if (usableContext(representationItem)) {
					foundValidContext = true;
				}
			}
			for (HashMapVirtualObject representationItem : list) {
				if (usableContext(representationItem) || !foundValidContext) {
					if (hasValidRepresentationIdentifier(representationItem)) {
						Set<HashMapVirtualObject> directListFeature = representationItem.getDirectListFeature(itemsFeature);
						if (directListFeature != null) {
							int nrItems = directListFeature.size();
							if (nrItems != 0) {
								representationOids.add(representationItem.getOid());
							}
						}
					}
				}
			}
		}
		return representationOids;
	}

	private boolean usableContext(HashMapVirtualObject representationItem) {
		AbstractHashMapVirtualObject context = representationItem.getDirectFeature(representationItem.eClass().getEStructuralFeature("ContextOfItems"));
		if (context == null) {
			LOGGER.debug("No context: " + representationItem);
			return false;
		}
		Object contextType = context.get("ContextType");
		if (contextType == null) {
			LOGGER.debug("No ContextType: " + representationItem);
			return false;
		}
		if (!contextType.equals("Model") && !contextType.equals("Design")) {
			LOGGER.debug("No Model/Design context: " + contextType);
			return false;
		}
		return true;
	}
	
	private void writeDebugFile() throws IOException {
		Path debugPath = bimServer.getHomeDir().resolve("debug");
		if (!Files.exists(debugPath)) {
			Files.createDirectories(debugPath);
		}

		Path folder = debugPath.resolve(debugIdentifier);
		if (!Files.exists(folder)) {
			Files.createDirectories(folder);
		}

		Path file = folder.resolve("generationreport.html");
		FileUtils.writeStringToFile(file.toFile(), report.toHtml());
	}
	
	// Pretty sure this is working correctly
	@SuppressWarnings("unchecked")
	public double[] placement3DToMatrix(AbstractHashMapVirtualObject ifcAxis2Placement3D) {
		EReference refDirectionFeature = packageMetaData.getEReference("IfcAxis2Placement3D", "RefDirection");
		AbstractHashMapVirtualObject location = ifcAxis2Placement3D.getDirectFeature(packageMetaData.getEReference("IfcPlacement", "Location"));
		if (ifcAxis2Placement3D.getDirectFeature(packageMetaData.getEReference("IfcAxis2Placement3D", "Axis")) != null && ifcAxis2Placement3D.getDirectFeature(refDirectionFeature) != null) {
			AbstractHashMapVirtualObject axis = ifcAxis2Placement3D.getDirectFeature(packageMetaData.getEReference("IfcAxis2Placement3D", "Axis"));
			AbstractHashMapVirtualObject direction = ifcAxis2Placement3D.getDirectFeature(refDirectionFeature);
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
	
	private double[] placementToMatrix(AbstractHashMapVirtualObject placement) {
		AbstractHashMapVirtualObject placementRelTo = placement.getDirectFeature(packageMetaData.getEReference("IfcLocalPlacement", "PlacementRelTo"));
		double[] matrix = Matrix.identity();
		if (placement.eClass().getName().equals("IfcLocalPlacement")) {
			AbstractHashMapVirtualObject relativePlacement = placement.getDirectFeature(packageMetaData.getEReference("IfcLocalPlacement", "RelativePlacement"));
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

	private void processQuery(final DatabaseSession databaseSession, QueryContext queryContext, GenerateGeometryResult generateGeometryResult, final StreamingSerializerPlugin ifcSerializerPlugin, final RenderEngineSettings settings,
			final RenderEngineFilter renderEngineFilter, RenderEnginePool renderEnginePool, ThreadPoolExecutor executor, EClass eClass, Query query, QueryPart queryPart, boolean geometryReused, Map<Long, ProductDef> map, int nrObjects, Set<Long> representationOids) throws QueryException, IOException {
		JsonQueryObjectModelConverter jsonQueryObjectModelConverter = new JsonQueryObjectModelConverter(packageMetaData);
		
		String lowerCasePackage = packageMetaData.getSchema().name().toLowerCase();
		String queryNameSpace = lowerCasePackage + "-stdlib";
		
		if (eClass.getName().equals("IfcAnnotation")) {
			// IfcAnnotation also has the field ContainedInStructure, but that is it's own field (looks like a hack on the IFC-spec side)
			queryPart.addInclude(jsonQueryObjectModelConverter.getDefineFromFile(queryNameSpace + ":IfcAnnotationContainedInStructure", true));
		} else {
			queryPart.addInclude(jsonQueryObjectModelConverter.getDefineFromFile(queryNameSpace + ":ContainedInStructure", true));
		}
		if (packageMetaData.getSchema() == Schema.IFC4) {
			queryPart.addInclude(jsonQueryObjectModelConverter.getDefineFromFile(queryNameSpace + ":IsTypedBy", true));
		}

		// TODO this includes all representations, should only include "Body" and "Facetation"
		Include representationInclude = new Include(packageMetaData);
		representationInclude.addType(eClass, false);
		representationInclude.addField("Representation");
		representationInclude.addField("HasAssociations");
		
		representationInclude.addInclude(jsonQueryObjectModelConverter.getDefineFromFile(queryNameSpace + ":IfcRelAssociatesMaterial", true));
		
		QueryPart secondPart = query.insertQueryPart();
		secondPart.addType(packageMetaData.getEClass("IfcRepresentation"), true);
		for (long oid : representationOids) {
			secondPart.addOid(oid);
		}
		
		// TODO addInclude(String) does not seem to work

		secondPart.addInclude(jsonQueryObjectModelConverter.getDefineFromFile(lowerCasePackage + "-geometry:IfcStyleModel", true));
		secondPart.addInclude(jsonQueryObjectModelConverter.getDefineFromFile(lowerCasePackage + "-geometry:IfcStyledRepresentation", true));
		secondPart.addInclude(jsonQueryObjectModelConverter.getDefineFromFile(lowerCasePackage + "-geometry:IfcRepresentation", true));
		secondPart.addInclude(jsonQueryObjectModelConverter.getDefineFromFile(lowerCasePackage + "-geometry:IfcBooleanResult", true));
		secondPart.addInclude(jsonQueryObjectModelConverter.getDefineFromFile(lowerCasePackage + "-geometry:IfcShapeModel", true));
		secondPart.addInclude(jsonQueryObjectModelConverter.getDefineFromFile(lowerCasePackage + "-geometry:IfcShapeRepresentation", true));
		secondPart.addInclude(jsonQueryObjectModelConverter.getDefineFromFile(lowerCasePackage + "-geometry:IfcTopologyRepresentation", true));
		
//		Include representationInclude = jsonQueryObjectModelConverter.getDefineFromFile(queryNameSpace + ":Representation", true);
		Include objectPlacement = jsonQueryObjectModelConverter.getDefineFromFile(queryNameSpace + ":ObjectPlacement", true);
		Include decomposes = jsonQueryObjectModelConverter.getDefineFromFile(queryNameSpace + ":Decomposes", true);
		Include ownerHistory = jsonQueryObjectModelConverter.getDefineFromFile(queryNameSpace + ":OwnerHistory", true);

		if (applyLayerSets) {
			if (packageMetaData.getEClass("IfcElement").isSuperTypeOf(eClass)) {
				Include connected = queryPart.createInclude();
				connected.addType(eClass, false);
				connected.addField("ConnectedTo");
				connected.addField("ConnectedFrom");
				Include connectedTo = connected.createInclude();
				connectedTo.addType(packageMetaData.getEClass("IfcRelConnectsPathElements"), false);
				connectedTo.addField("RelatedElement");
				connectedTo.addField("RelatingElement");
				
				// TODO According to Thomas we only need the "Axis" representation types, too much work for now, so sending all representations for now
				
				connectedTo.addInclude(jsonQueryObjectModelConverter.getDefineFromFile(queryNameSpace + ":Representation", true));
				connectedTo.addInclude(objectPlacement);
				connectedTo.addInclude(ownerHistory);
				connectedTo.addInclude(decomposes);
				
				// Also doing opening to make this query complete, otherwise we could end up not having openings in the referenced walls
				
				Include openingsInclude = connectedTo.createInclude();
				openingsInclude.addType(packageMetaData.getEClass(eClass.getName()), false);
				openingsInclude.addField("HasOpenings");
				Include hasOpenings = openingsInclude.createInclude();
				hasOpenings.addType(packageMetaData.getEClass("IfcRelVoidsElement"), false);
				
				hasOpenings.addField("RelatedOpeningElement");
				hasOpenings.addInclude(jsonQueryObjectModelConverter.getDefineFromFile(queryNameSpace + ":Representation", true));
				hasOpenings.addInclude(objectPlacement);
			}
		}
		
		queryPart.addInclude(decomposes);
		queryPart.addInclude(ownerHistory);
		queryPart.addInclude(representationInclude);
		queryPart.addInclude(objectPlacement);
		
		if (eClass.getName().equals("IfcOpeningElement")) {
			// In this case, we need to use the FillsVoids reference to get to an object on which we can add the decomposes include as well, otherwise we'll never get to the IfcProject level
			Include fillsVoidsInclude = queryPart.createInclude();
			fillsVoidsInclude.addType(eClass, false);
			fillsVoidsInclude.addField("VoidsElements");
			Include fillsInclude = fillsVoidsInclude.createInclude();
			fillsInclude.addType(packageMetaData.getEClass("IfcRelVoidsElement"), false);
			fillsInclude.addField("RelatingBuildingElement");

			fillsInclude.addInclude(decomposes);
			fillsInclude.addInclude(ownerHistory);
			fillsInclude.addInclude(jsonQueryObjectModelConverter.getDefineFromFile(queryNameSpace + ":ContainedInStructure", true));
		}
		
		if (packageMetaData.getEClass("IfcElement").isSuperTypeOf(eClass)) {
			Include openingsInclude = queryPart.createInclude();
			openingsInclude.addType(packageMetaData.getEClass(eClass.getName()), false);
			openingsInclude.addField("HasOpenings");
			Include hasOpenings = openingsInclude.createInclude();
			hasOpenings.addType(packageMetaData.getEClass("IfcRelVoidsElement"), false);
			hasOpenings.addField("RelatedOpeningElement");
			hasOpenings.addInclude(jsonQueryObjectModelConverter.getDefineFromFile(queryNameSpace + ":Representation", true));
			hasOpenings.addInclude(objectPlacement);
		}
		
		if (packageMetaData.getEClass("IfcBuildingElementPart").isSuperTypeOf(eClass)) {
			// For decomposed objects (with element parts) the openings of the parent object should be subtracted from the element parts (which is kind of an assumption)
			Include decomposesStartInclude = queryPart.createInclude();
			decomposesStartInclude.addType(packageMetaData.getEClass(eClass.getName()), false);
			decomposesStartInclude.addField("Decomposes");
			Include decomposesInclude = decomposesStartInclude.createInclude();
			decomposesInclude.addType(packageMetaData.getEClass("IfcRelAggregates"), true);
			decomposesInclude.addField("RelatingObject");
			Include relatingObject = decomposesInclude.createInclude();
			relatingObject.addType(packageMetaData.getEClass("IfcElement"), true);
			relatingObject.addField("HasOpenings");
			Include hasOpenings2 = relatingObject.createInclude();
			hasOpenings2.addType(packageMetaData.getEClass("IfcRelVoidsElement"), false);
			hasOpenings2.addField("RelatedOpeningElement");
			hasOpenings2.addInclude(jsonQueryObjectModelConverter.getDefineFromFile(queryNameSpace + ":Representation", true));
			hasOpenings2.addInclude(objectPlacement);
		}
		
		QueryObjectProvider queryObjectProvider = new QueryObjectProvider(databaseSession, bimServer, query, Collections.singleton(queryContext.getRoid()), packageMetaData);
		
		ReportJob job = report.newJob(eClass.getName(), nrObjects);
		GeometryRunner runner = new GeometryRunner(this, eClass, renderEnginePool, databaseSession, settings, queryObjectProvider, ifcSerializerPlugin, renderEngineFilter, generateGeometryResult, queryContext, geometryReused, map, job, reuseGeometry, geometryGenerationDebugger, query);
		executor.submit(runner);
		jobsTotal.incrementAndGet();
	}

	private void processMappingQuery(final DatabaseSession databaseSession, QueryContext queryContext, GenerateGeometryResult generateGeometryResult, final StreamingSerializerPlugin ifcSerializerPlugin, final RenderEngineSettings settings,
			final RenderEngineFilter renderEngineFilter, RenderEnginePool renderEnginePool, ThreadPoolExecutor executor, EClass eClass, Query query, QueryPart queryPart, boolean geometryReused, Map<Long, ProductDef> map, int nrObjects) throws QueryException, IOException {
		JsonQueryObjectModelConverter jsonQueryObjectModelConverter = new JsonQueryObjectModelConverter(packageMetaData);
		
		String queryNameSpace = packageMetaData.getSchema().name().toLowerCase() + "-stdlib";
		
		if (eClass.getName().equals("IfcAnnotation")) {
			// IfcAnnotation also has the field ContainedInStructure, but that is it's own field (looks like a hack on the IFC-spec side)
			queryPart.addInclude(jsonQueryObjectModelConverter.getDefineFromFile(queryNameSpace + ":IfcAnnotationContainedInStructure", true));
		} else {
			queryPart.addInclude(jsonQueryObjectModelConverter.getDefineFromFile(queryNameSpace + ":ContainedInStructure", true));
		}
		if (packageMetaData.getSchema() == Schema.IFC4) {
			queryPart.addInclude(jsonQueryObjectModelConverter.getDefineFromFile(queryNameSpace + ":IsTypedBy", true));
		}
		queryPart.addInclude(jsonQueryObjectModelConverter.getDefineFromFile(queryNameSpace + ":Decomposes", true));
		queryPart.addInclude(jsonQueryObjectModelConverter.getDefineFromFile(queryNameSpace + ":OwnerHistory", true));
		Include representationInclude = jsonQueryObjectModelConverter.getDefineFromFile(queryNameSpace + ":RepresentationSpecificMapping", true);
		queryPart.addInclude(representationInclude);
		Include objectPlacement = jsonQueryObjectModelConverter.getDefineFromFile(queryNameSpace + ":ObjectPlacement", true);
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
		
		ReportJob job = report.newJob(eClass.getName(), nrObjects);
		GeometryRunner runner = new GeometryRunner(this, eClass, renderEnginePool, databaseSession, settings, queryObjectProvider, ifcSerializerPlugin, renderEngineFilter, generateGeometryResult, queryContext, geometryReused, map, job, reuseGeometry, geometryGenerationDebugger, query);
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

	long getSize(VirtualObject geometryData) {
		long size = 0;
		size += (int)geometryData.get("nrIndices") * 4;
		size += (int)geometryData.get("nrVertices") * (8 + 2);
		size += (int)geometryData.get("nrNormals") * (4 + 1);
		size += (int)geometryData.get("nrColors") * (4 + 1);
		return size;
	}

	// TODO add color??
	int hash(ByteBuffer indices, ByteBuffer vertices, ByteBuffer normals, ByteBuffer colors) {
		int hashCode = 0;
		hashCode += indices.hashCode();
		hashCode += vertices.hashCode();
		hashCode += normals.hashCode();
		hashCode += colors.hashCode();
		
		return hashCode;
	}
	
	int hash(VirtualObject geometryData) {
		int hashCode = 0;
		if (geometryData.has("indices")) {
			hashCode += Arrays.hashCode(extractBufferData(geometryData.get("indices")));
		}
		if (geometryData.has("vertices")) {
			hashCode += Arrays.hashCode(extractBufferData(geometryData.get("vertices")));
		}
		if (geometryData.has("normals")) {
			hashCode += Arrays.hashCode(extractBufferData(geometryData.get("normals")));
		}
		if (geometryData.has("colorsQuantized")) {
			hashCode += Arrays.hashCode(extractBufferData(geometryData.get("colorsQuantized")));
		}
		if (geometryData.has("color")) {
			hashCode += ((HashMapWrappedVirtualObject)geometryData.get("color")).hashCode();
		}
		return hashCode;
	}
	
	private byte[] extractBufferData(Object buffer) {
		if (buffer == null) {
			return new byte[0];
		}
		return (byte[])((HashMapVirtualObject)buffer).get("data");
	}

	void processExtendsUntranslated(VirtualObject geometryInfo, DoubleBuffer vertices, int index, GenerateGeometryResult generateGeometryResult) throws BimserverDatabaseException {
		double x = vertices.get(index);
		double y = vertices.get(index + 1);
		double z = vertices.get(index + 2);
		
		HashMapWrappedVirtualObject bounds = (HashMapWrappedVirtualObject) geometryInfo.eGet(GeometryPackage.eINSTANCE.getGeometryInfo_BoundsUntransformed());
		HashMapWrappedVirtualObject minBounds = (HashMapWrappedVirtualObject) bounds.eGet(GeometryPackage.eINSTANCE.getBounds_Min());
		HashMapWrappedVirtualObject maxBounds = (HashMapWrappedVirtualObject) bounds.eGet(GeometryPackage.eINSTANCE.getBounds_Max());
		
		minBounds.set("x", Math.min(x, (double)minBounds.eGet("x")));
		minBounds.set("y", Math.min(y, (double)minBounds.eGet("y")));
		minBounds.set("z", Math.min(z, (double)minBounds.eGet("z")));
		maxBounds.set("x", Math.max(x, (double)maxBounds.eGet("x")));
		maxBounds.set("y", Math.max(y, (double)maxBounds.eGet("y")));
		maxBounds.set("z", Math.max(z, (double)maxBounds.eGet("z")));
		
		generateGeometryResult.setUntranslatedMinX(Math.min(x, generateGeometryResult.getUntranslatedMinX()));
		generateGeometryResult.setUntranslatedMinY(Math.min(y, generateGeometryResult.getUntranslatedMinY()));
		generateGeometryResult.setUntranslatedMinZ(Math.min(z, generateGeometryResult.getUntranslatedMinZ()));
		generateGeometryResult.setUntranslatedMaxX(Math.max(x, generateGeometryResult.getUntranslatedMaxX()));
		generateGeometryResult.setUntranslatedMaxY(Math.max(y, generateGeometryResult.getUntranslatedMaxY()));
		generateGeometryResult.setUntranslatedMaxZ(Math.max(z, generateGeometryResult.getUntranslatedMaxZ()));
	}

	void processExtends(HashMapWrappedVirtualObject minBounds, HashMapWrappedVirtualObject maxBounds, double[] transformationMatrix, DoubleBuffer vertices, int index, GenerateGeometryResult generateGeometryResult) throws BimserverDatabaseException {
		double x = vertices.get(index);
		double y = vertices.get(index + 1);
		double z = vertices.get(index + 2);
		
		double[] result = new double[4];
		
		Matrix.multiplyMV(result, 0, transformationMatrix, 0, new double[] { x, y, z, 1 }, 0);
		x = result[0];
		y = result[1];
		z = result[2];
		
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

	void setTransformationMatrix(VirtualObject geometryInfo, double[] transformationMatrix) throws BimserverDatabaseException {
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

	public void cacheGeometryData(HashMapVirtualObject geometryData, ByteBuffer vertices) {
		geometryDataMap.put(geometryData.getOid(), new Tuple<>(geometryData, vertices));
	}

	public String getDebugIdentifier() {
		return debugIdentifier;
	}
	
	public boolean isCalculateQuantities() {
		return calculateQuantities;
	}
}
