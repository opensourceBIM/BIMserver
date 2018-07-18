package org.bimserver.database.queries;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.queries.om.Include;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.geometry.GeometryPackage;
import org.bimserver.models.store.Revision;
import org.bimserver.shared.AbstractHashMapVirtualObject;
import org.bimserver.shared.HashMapVirtualObject;
import org.eclipse.emf.ecore.EClass;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class GeometryAccellerator {
	private BimServer bimServer;
	private LoadingCache<OctreeKey, Octree<Long>> octrees;
	private LoadingCache<ReuseKey, ReuseSet> reuseSets;

	public GeometryAccellerator(BimServer bimServer) {
		this.bimServer = bimServer;

		octrees = CacheBuilder.newBuilder().maximumSize(10000).build(new CacheLoader<OctreeKey, Octree<Long>>() {
			public Octree<Long> load(OctreeKey key) {
				return generateOctree(key);
			}
		});
		
		reuseSets = CacheBuilder.newBuilder().maximumSize(10000).build(new CacheLoader<ReuseKey, ReuseSet>() {
			public ReuseSet load(ReuseKey key) {
				return generateReuseSet(key);
			}
		});
	}

	public Octree<Long> getOctree(Set<Long> roids, Set<String> excludedClasses, Set<Long> geometryIdsToReuse, int maxDepth, float minimumThreshold) {
		OctreeKey key = new OctreeKey(roids, excludedClasses, geometryIdsToReuse, maxDepth, minimumThreshold);
		try {
			return octrees.get(key);
		} catch (ExecutionException e) {
			e.printStackTrace();
			return null;
		}
	}

	private Octree<Long> generateOctree(OctreeKey key) {
		long start = System.nanoTime();
		try (DatabaseSession databaseSession = bimServer.getDatabase().createSession()) {
			org.bimserver.database.queries.Bounds totalBounds = new org.bimserver.database.queries.Bounds();

			// TODO not taking into account a density here, so potentially, this
			// will come back with too many tiles with > 0 object, not really a
			// problem though

			for (long roid : key.getRoids()) {
				Revision revision = databaseSession.get(roid, OldQuery.getDefault());
				totalBounds.integrate(revision.getBoundsMm());
			}

			Octree<Long> octree = new Octree<>(totalBounds, key.getMaxDepth());

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
			while (next != null) {
				AbstractHashMapVirtualObject geometry = next.getDirectFeature(packageMetaData.getEReference("IfcProduct", "geometry"));
				if (geometry != null) {
					float density = (float) geometry.get("density");
					if (density >= key.getMinimumThreshold()) {
						long geometryDataId = (long) geometry.get("data");
						AbstractHashMapVirtualObject boundsMm = geometry.getDirectFeature(GeometryPackage.eINSTANCE.getGeometryInfo_BoundsMm());
						if (key.getGeometryIdsToReuse().contains(geometryDataId)) {
							// Special case, we now have to use the complete
							// bounding box of all reused objects, instead of using
							// the object's aabb
							HashMapVirtualObject geometryData = queryObjectProvider.getByOid(geometryDataId);
							boundsMm = geometryData.getDirectFeature(GeometryPackage.eINSTANCE.getGeometryData_BoundsMm());
						}
						if (boundsMm != null) {
							AbstractHashMapVirtualObject min = boundsMm.getDirectFeature(GeometryPackage.eINSTANCE.getBounds_Min());
							AbstractHashMapVirtualObject max = boundsMm.getDirectFeature(GeometryPackage.eINSTANCE.getBounds_Max());
	
							org.bimserver.database.queries.Bounds objectBounds = new org.bimserver.database.queries.Bounds((double) min.get("x"), (double) min.get("y"), (double) min.get("z"), (double) max.get("x"), (double) max.get("y"),
									(double) max.get("z"));
							octree.add(next.getOid(), objectBounds);
						}
					}
				}
				next = queryObjectProvider.next();
			}

			long end = System.nanoTime();
			System.out.println("generateOctree " + ((end - start) / 1000000) + " ms");

			return octree;
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (QueryException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Set<Long> getGeometryDataToReuse(Set<Long> roids, Set<String> excludedTypes, Integer trianglesToSave) {
		ReuseKey key = new ReuseKey(roids, excludedTypes);
		try {
			return reuseSets.get(key).getListOfGeometryDataIds(trianglesToSave);
		} catch (ExecutionException e) {
			e.printStackTrace();
			return null;
		}
	}

	private ReuseSet generateReuseSet(ReuseKey key) {
		long start = System.nanoTime();
		ReuseSet reuseSet = new ReuseSet();
		try (DatabaseSession databaseSession = bimServer.getDatabase().createSession()) {
			// Assuming all given roids are of projects that all have the same
			// schema

			Map<Long, HashMapVirtualObject> geometryDataMap = listGeometryData(databaseSession, key.getRoids());

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
			geometryInfo.addFieldDirect("data");

			QueryObjectProvider queryObjectProvider = new QueryObjectProvider(databaseSession, bimServer, query, key.getRoids(), packageMetaData);
			HashMapVirtualObject next = queryObjectProvider.next();
			while (next != null) {
				AbstractHashMapVirtualObject geometry = next.getDirectFeature(packageMetaData.getEReference("IfcProduct", "geometry"));
				if (geometry != null) {
					Long dataId = (Long) geometry.get("data");
					HashMapVirtualObject data = geometryDataMap.get(dataId);
					if (data != null) {
						reuseSet.add(data.getOid(), (int) data.get("reused"), (int) geometry.get("primitiveCount"));
					} else {
						System.out.println("No data");
					}
				}
				next = queryObjectProvider.next();
			}
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		} catch (QueryException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		long end = System.nanoTime();
		System.out.println("generateReuseSet: " + ((end - start) / 1000000) + " ms");
		return reuseSet;
	}

	private Map<Long, HashMapVirtualObject> listGeometryData(DatabaseSession databaseSession, Set<Long> roids) throws BimserverDatabaseException, IOException, QueryException {
		Map<Long, HashMapVirtualObject> map = new HashMap<>();

		Revision revision = databaseSession.get(roids.iterator().next(), OldQuery.getDefault());
		PackageMetaData packageMetaData = bimServer.getMetaDataManager().getPackageMetaData(revision.getProject().getSchema());

		Query query = new Query(packageMetaData);

		QueryPart queryPart = query.createQueryPart();
		queryPart.addType(GeometryPackage.eINSTANCE.getGeometryData(), false);

		QueryObjectProvider queryObjectProvider = new QueryObjectProvider(databaseSession, bimServer, query, roids, packageMetaData);
		HashMapVirtualObject next = queryObjectProvider.next();
		while (next != null) {
			map.put(next.getOid(), next);
			next = queryObjectProvider.next();
		}
		return map;
	}
}
