package org.bimserver.database.queries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.Query;
import org.bimserver.database.queries.om.InBoundingBox;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.shared.Reusable;
import org.eclipse.emf.ecore.EClass;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class QueryPartStackFrame extends StackFrame {

	private Iterator<EClass> typeIterator;
	private QueryObjectProvider queryObjectProvider;
	private Query query;
	private PackageMetaData packageMetaData;
	private Reusable reusable;
	private QueryPart partialQuery;
	private final Map<EClass, List<Long>> oids;
	private final Set<String> guids;
	private Map<String, Object> properties;
	private InBoundingBox inBoundingBox;

	public QueryPartStackFrame(QueryObjectProvider queryObjectProvider, PackageMetaData packageMetaData, Query query, QueryPart partialQuery, Reusable reusable) throws BimserverDatabaseException, QueryException {
		this.queryObjectProvider = queryObjectProvider;
		this.packageMetaData = packageMetaData;
		this.query = query;
		this.partialQuery = partialQuery;
		this.reusable = reusable;
		if (partialQuery.getTypes().isEmpty()) {
			typeIterator = query.getOidCounters().keySet().iterator();
		} else {
			typeIterator = partialQuery.getTypes().iterator();
		}
		if (partialQuery.hasOids()) {
			List<Long> oidsList = partialQuery.getOids();
			this.oids = new HashMap<EClass, List<Long>>();
			if (oidsList.size() == 0) {
				throw new QueryException("\"oids\" parameter of type array is of size 0");
			}
			for (int i=0; i<oidsList.size(); i++) {
				long oid = oidsList.get(i);
				EClass eClass = queryObjectProvider.getDatabaseSession().getEClassForOid(oid);
				List<Long> list = this.oids.get(eClass);
				if (list == null) {
					list = new ArrayList<Long>();
					this.oids.put(eClass, list);
				}
				list.add(oid);
			}
		} else {
			oids = null;
		}
		if (this.partialQuery.getGuids() != null) {
			this.guids = partialQuery.getGuids();
		} else {
			guids = null;
		}
		this.properties = partialQuery.getProperties();
		this.inBoundingBox = partialQuery.getInBoundingBox();
	}

	@Override
	public boolean process() throws BimserverDatabaseException, QueryException {
		if (typeIterator == null) {
			return true;
		}
		if (typeIterator.hasNext()) {
			EClass eClass = typeIterator.next();
			if (oids != null) {
				queryObjectProvider.push(new QueryOidsAndTypesStackFrame(queryObjectProvider, eClass, query, partialQuery, packageMetaData, reusable, oids.get(eClass)));
			} else if (guids != null) {
				queryObjectProvider.push(new QueryGuidsAndTypesStackFrame(queryObjectProvider, eClass, query, partialQuery, packageMetaData, reusable, guids));
			} else if (properties != null) {
				queryObjectProvider.push(new QueryPropertiesAndTypesStackFrame(queryObjectProvider, eClass, query, partialQuery, packageMetaData, reusable, properties));
			} else if (inBoundingBox != null) {
				queryObjectProvider.push(new QueryBoundingBoxStackFrame(queryObjectProvider, eClass, query, partialQuery, packageMetaData, reusable, inBoundingBox));
			} else {
				queryObjectProvider.push(new QueryTypeStackFrame(queryObjectProvider, eClass, query, packageMetaData, reusable, partialQuery));
			}
			return false;
		}
		return true;
	}
}