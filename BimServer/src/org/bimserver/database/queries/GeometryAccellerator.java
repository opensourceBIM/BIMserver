package org.bimserver.database.queries;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
import org.bimserver.shared.HashMapVirtualObject;

public class GeometryAccellerator {
	private final Map<Long, Octree> octries = new HashMap<>();
	private BimServer bimServer;

	public GeometryAccellerator(BimServer bimServer) {
		this.bimServer = bimServer;
	}
	
	public Octree getOctree(long roid) {
		if (!octries.containsKey(roid)) {
			octries.put(roid, generateOctree(roid));
		}
		return octries.get(roid);
	}

	private Octree generateOctree(long roid) {
		try (DatabaseSession databaseSession = bimServer.getDatabase().createSession()) {
			Revision revision = databaseSession.get(roid, OldQuery.getDefault());
			
			Octree<Long> octree = new Octree<>(new Bounds(revision.getBounds()), 5);
			
			PackageMetaData packageMetaData = bimServer.getMetaDataManager().getPackageMetaData(revision.getProject().getSchema());
			Query query = new Query(packageMetaData);
			
			QueryPart queryPart = query.createQueryPart();
			queryPart.addType(packageMetaData.getEClass("IfcProduct"), true);
			Include product = queryPart.createInclude();
			product.addType(packageMetaData.getEClass("IfcProduct"), true);
			product.addFieldDirect("geometry");
			Include geometryInfo = product.createInclude();
			geometryInfo.addType(packageMetaData.getEClass("GeometryInfo"), false);
			geometryInfo.addFieldDirect("bounds");
			Include boundsInclude = geometryInfo.createInclude();
			boundsInclude.addType(packageMetaData.getEClass("Bounds"), false);
			boundsInclude.addFieldDirect("min");
			boundsInclude.addFieldDirect("max");
			
			QueryObjectProvider queryObjectProvider = new QueryObjectProvider(databaseSession, bimServer, query, java.util.Collections.singleton(roid), packageMetaData);
			HashMapVirtualObject next = queryObjectProvider.next();
			while (next != null) {
				HashMapVirtualObject geometry = next.getDirectFeature(packageMetaData.getEReference("IfcProduct", "geometry"));
				HashMapVirtualObject min = geometry.getDirectFeature(GeometryPackage.eINSTANCE.getBounds_Min());
				HashMapVirtualObject max = geometry.getDirectFeature(GeometryPackage.eINSTANCE.getBounds_Max());
				
				// TODO convect to mm or add mm fields as well
				
				Bounds bounds = new Bounds((double)min.get("x"), (double)min.get("y"), (double)min.get("z"), (double)max.get("x"), (double)max.get("y"), (double)max.get("z"));
				
				octree.add(next.getOid(), bounds);
				next = queryObjectProvider.next();
			}
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
