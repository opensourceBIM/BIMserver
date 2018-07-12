package org.bimserver.database.queries;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

public class GeometryAccellerator {
	private final Map<OctreeKey, Octree<Long>> octries = new HashMap<>();
	private BimServer bimServer;

	public GeometryAccellerator(BimServer bimServer) {
		this.bimServer = bimServer;
	}
	
	public Octree<Long> getOctree(Set<Long> roids, Set<String> excludedClasses, int maxDepth, float minimumThreshold) {
		OctreeKey key = new OctreeKey(roids, excludedClasses, maxDepth, minimumThreshold);
		if (!octries.containsKey(key)) {
			octries.put(key, generateOctree(key));
		}
		return octries.get(key);
	}

	private Octree<Long> generateOctree(OctreeKey key) {
		try (DatabaseSession databaseSession = bimServer.getDatabase().createSession()) {
			org.bimserver.database.queries.Bounds totalBounds = new org.bimserver.database.queries.Bounds();
			
			// TODO not taking into account a density here, so potentially, this will come back with too many tiles with > 0 object, not really a problem though
			
			for (long roid : key.getRoids()) {
				Revision revision = databaseSession.get(roid, OldQuery.getDefault());
				totalBounds.integrate(revision.getBoundsMm());
			}

			Octree<Long> octree = new Octree<>(totalBounds, key.getMaxDepth());

			// Assuming all given roids are of projects that all have the same schema
			Revision revision = databaseSession.get(key.getRoids().iterator().next(), OldQuery.getDefault());
			PackageMetaData packageMetaData = bimServer.getMetaDataManager().getPackageMetaData(revision.getProject().getSchema());
			
			Set<EClass> excluded = new HashSet<>();
			for (String exclude : key.getExcludedClasses()) {
				excluded.add(packageMetaData.getEClass(exclude));
			}
			
			Query query = new Query(packageMetaData);
			
			QueryPart queryPart = query.createQueryPart();
			queryPart.addType(packageMetaData.getEClass("IfcProduct"), true, excluded);

			Include product = queryPart.createInclude();
			product.addType(packageMetaData.getEClass("IfcProduct"), true);
			product.addFieldDirect("geometry");
			Include geometryInfo = product.createInclude();
			geometryInfo.addType(GeometryPackage.eINSTANCE.getGeometryInfo(), false);
			geometryInfo.addFieldDirect("boundsMm");
			Include boundsInclude = geometryInfo.createInclude();
			boundsInclude.addType(GeometryPackage.eINSTANCE.getBounds(), false);
			boundsInclude.addFieldDirect("min");
			boundsInclude.addFieldDirect("max");
			
			QueryObjectProvider queryObjectProvider = new QueryObjectProvider(databaseSession, bimServer, query, key.getRoids(), packageMetaData);
			HashMapVirtualObject next = queryObjectProvider.next();
			while (next != null) {
				AbstractHashMapVirtualObject geometry = next.getDirectFeature(packageMetaData.getEReference("IfcProduct", "geometry"));
				if (geometry != null) {
					float density = (float) geometry.get("density");
					if (density < key.getMinimumThreshold()) {
						continue;
					}
					AbstractHashMapVirtualObject boundsMm = geometry.getDirectFeature(GeometryPackage.eINSTANCE.getGeometryInfo_BoundsMm());
					if (boundsMm != null) {
						AbstractHashMapVirtualObject min = boundsMm.getDirectFeature(GeometryPackage.eINSTANCE.getBounds_Min());
						AbstractHashMapVirtualObject max = boundsMm.getDirectFeature(GeometryPackage.eINSTANCE.getBounds_Max());
						
						org.bimserver.database.queries.Bounds objectBounds = new org.bimserver.database.queries.Bounds((double)min.get("x"), (double)min.get("y"), (double)min.get("z"), (double)max.get("x"), (double)max.get("y"), (double)max.get("z"));

						octree.add(next.getOid(), objectBounds);
					}
				}
				next = queryObjectProvider.next();
			}
			
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
}
