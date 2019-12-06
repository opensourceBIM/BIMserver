package org.bimserver.geometry.accellerator;

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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OperationType;
import org.bimserver.database.queries.Bounds;
import org.bimserver.database.queries.QueryObjectProvider;
import org.bimserver.database.queries.om.Include;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.interfaces.objects.SDensity;
import org.bimserver.models.geometry.GeometryPackage;
import org.bimserver.models.store.Density;
import org.bimserver.models.store.Revision;
import org.bimserver.shared.AbstractHashMapVirtualObject;
import org.bimserver.shared.HashMapVirtualObject;
import org.eclipse.emf.ecore.EClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class GeometryAccellerator {
	private static final Logger LOGGER = LoggerFactory.getLogger(GeometryAccellerator.class);
	private final BimServer bimServer;
	private final LoadingCache<OctreeKey, Octree> octrees;
	private final LoadingCache<DensityThresholdKey, DensityThreshold> densityThresholds;
	private final LoadingCache<ReuseKey, ReuseSet> reuseSets;

	/*
	 * TODO
	 * - Implement cache eviction either
	 * 		- By trying to come up with an estimate as to how many bytes each cache entry uses and simply limiting on for example 10% of MAX heap (and eviction on last used, or least used)
	 * 		- By simply changing the limit on the amount of entries to something smaller
	 * 		- Manually, by adding an API call that cleans up cache entries, this can be useful for clients that already know they won't be querying a model anytime soon
	 * 		- Allowing clients to set the maximumSize
	 */
	
	public GeometryAccellerator(BimServer bimServer) {
		this.bimServer = bimServer;
		
		octrees = CacheBuilder.newBuilder().maximumSize(10000).build(new CacheLoader<OctreeKey, Octree>() {
			public Octree load(OctreeKey key) {
				return generateOctree(key);
			}
		});
		
		reuseSets = CacheBuilder.newBuilder().maximumSize(10000).build(new CacheLoader<ReuseKey, ReuseSet>() {
			public ReuseSet load(ReuseKey key) {
				return generateReuseSet(key);
			}
		});
		
		densityThresholds = CacheBuilder.newBuilder().maximumSize(10000).build(new CacheLoader<DensityThresholdKey, DensityThreshold>() {
			@Override
			public DensityThreshold load(DensityThresholdKey key) throws Exception {
				return generateDensityThreshold(key);
			}
		});
	}

	public Octree getOctree(Set<Long> roids, Set<String> excludedClasses, Set<Long> geometryIdsToReuse, int maxDepth, float minimumThreshold, float maximumThreshold) {
		OctreeKey key = new OctreeKey(roids, excludedClasses, geometryIdsToReuse);
		try {
			return octrees.get(key);
		} catch (ExecutionException e) {
			LOGGER.error("", e);
			return null;
		}
	}

	private Octree generateOctree(OctreeKey key) {
		LOGGER.info("Generating octree: " + key);
		Long start = System.nanoTime();
		try (DatabaseSession databaseSession = bimServer.getDatabase().createSession(OperationType.READ_ONLY)) {
			Bounds totalBounds = new Bounds();

			for (long roid : key.getRoids()) {
				Revision revision = databaseSession.get(roid, OldQuery.getDefault());
				totalBounds.integrate(revision.getBoundsMm());
			}

			Octree octree = new Octree(totalBounds, 9);

			// Assuming all given roids are of projects that all have the same
			// schema
			Revision revision = databaseSession.get(key.getRoids().iterator().next(), OldQuery.getDefault());
			PackageMetaData packageMetaData = bimServer.getMetaDataManager().getPackageMetaData(revision.getProject().getSchema());

			Set<EClass> excluded = new HashSet<>();
			if (key.getExcludedClasses() != null) {
				for (String exclude : key.getExcludedClasses()) {
					excluded.add(packageMetaData.getEClass(exclude));
				}
			}

			Query query = new Query(packageMetaData);

			QueryPart queryPart = query.createQueryPart();
			queryPart.addType(packageMetaData.getEClass("IfcProduct"), true, excluded);

			Include product = queryPart.createInclude();
			product.addType(packageMetaData.getEClass("IfcProduct"), true);
			product.addFieldDirect("geometry");
			Include geometryInfo = product.createInclude();
			geometryInfo.addType(GeometryPackage.eINSTANCE.getGeometryInfo(), false);
			geometryInfo.addFieldDirect("data");
			geometryInfo.addFieldDirect("boundsMm");
			Include boundsInclude = geometryInfo.createInclude();
			boundsInclude.addType(GeometryPackage.eINSTANCE.getBounds(), false);
			boundsInclude.addFieldDirect("min");
			boundsInclude.addFieldDirect("max");
			Include dataInclude = geometryInfo.createInclude();
			dataInclude.addType(GeometryPackage.eINSTANCE.getGeometryData(), false);
			dataInclude.addFieldDirect("boundsMm");
			Include dataBoundsInclude = dataInclude.createInclude();
			dataBoundsInclude.addType(GeometryPackage.eINSTANCE.getBounds(), false);
			dataBoundsInclude.addFieldDirect("min");
			dataBoundsInclude.addFieldDirect("max");

			QueryObjectProvider queryObjectProvider = new QueryObjectProvider(databaseSession, bimServer, query, key.getRoids(), packageMetaData);
			HashMapVirtualObject next = queryObjectProvider.next();
			
			Map<Long, GeometryDataObject> map = new HashMap<>();
			
			while (next != null) {
				AbstractHashMapVirtualObject geometry = next.getDirectFeature(packageMetaData.getEReference("IfcProduct", "geometry"));
				if (geometry != null) {
					float density = (float) geometry.get("density");
					long geometryDataId = (long) geometry.get("data");
					AbstractHashMapVirtualObject boundsMm = geometry.getDirectFeature(GeometryPackage.eINSTANCE.getGeometryInfo_BoundsMm());
					
					GeometryDataObject geometryDataObject = null;
					
					if (key.getGeometryIdsToReuse().contains(geometryDataId)) {
						// Special case, we now have to use the complete
						// bounding box of all reused objects, instead of using
						// the object's aabb
						HashMapVirtualObject geometryData = (HashMapVirtualObject) geometry.getDirectFeature(GeometryPackage.eINSTANCE.getGeometryInfo_Data());
						boundsMm = geometryData.getDirectFeature(GeometryPackage.eINSTANCE.getGeometryData_BoundsMm());
						
						geometryDataObject = map.get(geometryData.getOid());
						if (geometryDataObject == null) {
							geometryDataObject = new GeometryDataObject(geometryData);
							map.put(geometryData.getOid(), geometryDataObject);
						}
					}
					if (boundsMm != null) {
						AbstractHashMapVirtualObject min = boundsMm.getDirectFeature(GeometryPackage.eINSTANCE.getBounds_Min());
						AbstractHashMapVirtualObject max = boundsMm.getDirectFeature(GeometryPackage.eINSTANCE.getBounds_Max());

						HashMapVirtualObject geometryData = (HashMapVirtualObject) geometry.getDirectFeature(GeometryPackage.eINSTANCE.getGeometryInfo_Data());
						int saveableTriangles = (int)geometryData.get("saveableTriangles");
						int reused = (int)geometryData.get("reused");
						int triangles = (int)geometryData.get("nrIndices") / 3;

						org.bimserver.database.queries.Bounds objectBounds = new org.bimserver.database.queries.Bounds((double) min.get("x"), (double) min.get("y"), (double) min.get("z"), (double) max.get("x"), (double) max.get("y"),
								(double) max.get("z"));
						GeometryObject geometryObject = new GeometryObject(next.getOid(), next.eClass(), next.getCroid(), saveableTriangles, reused, triangles, density, objectBounds);
						Node node = octree.add(geometryObject);
						geometryObject.setTileId(node.getId());
						geometryObject.setTileLevel(node.getLevel());
						geometryObject.setGeometryDataObject(geometryDataObject);
					}
				}
				next = queryObjectProvider.next();
			}
			
			AtomicLong totalTriangles = new AtomicLong();
			
			octree.traverseBreathFirst(new Traverser() {
				@Override
				public void traverse(Node node) {
					for (GeometryObject geometryObject : node.getValues()) {
						totalTriangles.addAndGet(geometryObject.getTriangles());
					}
				}
			});
			
			LOGGER.info("Total triangles: " + totalTriangles);
			
			octree.moveGeometryDown(new MoveGeometryDownDecider() {
				@Override
				public boolean shouldMoveDown(GeometryObject geometryObject) {
					GeometryDataObject geometryDataObject = geometryObject.getGeometryDataObject();
					if (geometryDataObject == null) {
						// It's not reused at all
						return false;
					}
					
					// Maybe we should reason the other way around. Each tile can at max be X triangles big. If the amount of triangles is too large, we start moving reusable objects down by splitting them.
					// If that in turn means that reuse in those tiles makes no sense anymore, stop applying reuse altogether.W
					
					// So we have already decided that reuse is going to be useful, but if moving the geometry down a level would result
					
					return false;
				}});
			
			octree.moveUp(new MoveUpDecider() {
				@Override
				public boolean moveUp(Node node) {
					// TODO use more heuristics
					int totalTriangles = 0;
					for (GeometryObject geometryObject : node.getValues()) {
						totalTriangles += geometryObject.getTriangles();
					}
					if (totalTriangles < 1200) {
						return true;
					}
					
					return false;
				}
			});
			
			long end = System.nanoTime();
			LOGGER.info("Octree generated in " + ((end - start) / 1000000) + " ms");
			
			return octree;
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		} catch (IOException e) {
			LOGGER.error("", e);
		} catch (QueryException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	private DensityThreshold generateDensityThreshold(DensityThresholdKey key) {
		long start = System.nanoTime();
		DensityThreshold densityThreshold = new DensityThreshold();
		try (DatabaseSession session = bimServer.getDatabase().createSession(OperationType.READ_ONLY)) {
			Set<Long> roids = key.getRoid();
			List<Density> allDensities = new ArrayList<>();
			for (long roid : roids) {
				Revision revision = session.get(roid, OldQuery.getDefault());
				List<Density> densities = revision.getDensityCollection().getDensities();
				allDensities.addAll(densities);
			}
			if (key.getRoid().size() > 1) {
				// Densities on themselves are sorted, but when combining multiple revisions, we need to sort again
				allDensities.sort(new Comparator<Density>() {
					@Override
					public int compare(Density o1, Density o2) {
						return Float.compare(o1.getDensity(), o2.getDensity());
					}
				});
			}
			long cumulativeTrianglesBelow = 0;
			long cumulativeTrianglesAbove = 0;
			Density densityResult = null;
			int l = 0;
			float ld = -1f;
			for (Density density : allDensities) {
				if (key.getExcludedTypes().contains(density.getType())) {
					continue;
				}
				if (l == 0) {
					if (cumulativeTrianglesBelow + density.getTrianglesBelow() > key.getNrTriangles()) {
						l = 1;
					} else {
						densityResult = density;
						cumulativeTrianglesBelow += density.getTrianglesBelow(); // Not a typo
						ld = density.getDensity();
					}
				} 
				if (l == 1) {
					if (ld == density.getDensity()) {
						cumulativeTrianglesBelow += density.getTrianglesBelow();
						densityResult = density;
					} else {
						cumulativeTrianglesAbove += density.getTrianglesBelow(); // Not a typo
					}
				}
			}
			if (densityResult == null && allDensities.size() > 0) {
				densityResult = allDensities.get(0);
				densityResult.setDensity(-1);
			}
			if (densityResult == null) {
				return null;
			}
			// This is useful information, so the client knows exactly how many triangles will be loaded by using this threshold
			densityResult.setTrianglesBelow(cumulativeTrianglesBelow);
			densityResult.setTrianglesAbove(cumulativeTrianglesAbove);
			densityThreshold.setDensity(bimServer.getSConverter().convertToSObject(densityResult));
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		}
		long end = System.nanoTime();
//		LOGGER.info("Density thresholds generated in " + ((end - start) / 1000000) + "ms");
		return densityThreshold;
	}
	
	public Set<Long> getGeometryDataToReuse(Set<Long> roids, Set<String> excludedTypes, Integer trianglesToSave) {
		ReuseKey key = new ReuseKey(roids, excludedTypes);
		try {
			return reuseSets.get(key).getListOfGeometryDataIds(trianglesToSave);
		} catch (ExecutionException e) {
			LOGGER.error("", e);
			return null;
		}
	}

	private ReuseSet generateReuseSet(ReuseKey key) {
		long start = System.nanoTime();
		ReuseSet reuseSet = new ReuseSet();
		try (DatabaseSession databaseSession = bimServer.getDatabase().createSession(OperationType.READ_ONLY)) {
			// Assuming all given roids are of projects that all have the same schema

			Revision revision = databaseSession.get(key.getRoids().iterator().next(), OldQuery.getDefault());
			PackageMetaData packageMetaData = bimServer.getMetaDataManager().getPackageMetaData(revision.getProject().getSchema());

			Query query = new Query(packageMetaData);

			Set<EClass> excluded = new HashSet<>();
			for (String exclude : key.getExcludedClasses()) {
				excluded.add(packageMetaData.getEClass(exclude));
			}

			QueryPart queryPart = query.createQueryPart();
			queryPart.addType(packageMetaData.getEClass("IfcProduct"), true, excluded);

			Include product = queryPart.createInclude();
			product.addType(packageMetaData.getEClass("IfcProduct"), true);
			product.addFieldDirect("geometry");
			Include geometryInfo = product.createInclude();
			geometryInfo.addType(GeometryPackage.eINSTANCE.getGeometryInfo(), false);

			Map<Long, ReuseObject> map = new HashMap<>();
			
			QueryObjectProvider queryObjectProvider = new QueryObjectProvider(databaseSession, bimServer, query, key.getRoids(), packageMetaData);
			HashMapVirtualObject next = queryObjectProvider.next();
			while (next != null) {
				AbstractHashMapVirtualObject geometry = next.getDirectFeature(packageMetaData.getEReference("IfcProduct", "geometry"));
				if (geometry != null) {
					Long dataId = (Long) geometry.get("data");
					ReuseObject reuseObject = map.get(dataId);
					if (reuseObject == null) {
						reuseObject = new ReuseObject(dataId, 1, (int) geometry.get("primitiveCount"));
						map.put(dataId, reuseObject);
					} else {
						reuseObject.inc();
					}
				}
				next = queryObjectProvider.next();
			}
			for (long dataId : map.keySet()) {
				reuseSet.add(map.get(dataId));
			}
			long end = System.nanoTime();
			LOGGER.info("ReuseSets generated in " + ((end - start) / 1000000) + " ms");
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		} catch (QueryException e) {
			LOGGER.error("", e);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return reuseSet;
	}

	public SDensity getDensityThreshold(Set<Long> roids, Long nrTriangles, Set<String> excludedTypes) {
		DensityThresholdKey key = new DensityThresholdKey(roids, nrTriangles, excludedTypes);
		DensityThreshold generateDensityThreshold = generateDensityThreshold(key);
		if (generateDensityThreshold == null) {
			return null;
		}
		return generateDensityThreshold.getDensity();
//		try {
//			return densityThresholds.get(key).getDensity();
//		} catch (ExecutionException e) {
//			LOGGER.error("", e);
//			return null;
//		}
	}
}