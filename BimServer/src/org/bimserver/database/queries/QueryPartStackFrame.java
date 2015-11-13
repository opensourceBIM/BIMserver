package org.bimserver.database.queries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.Query;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.shared.Reusable;
import org.eclipse.emf.ecore.EClass;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class QueryPartStackFrame implements StackFrame {

	private Iterator<EClass> typeIterator;
	private QueryObjectProvider queryObjectProvider;
	private Query query;
	private PackageMetaData packageMetaData;
	private Reusable reusable;
	private JsonObject jsonQuery;
	private final Map<EClass, List<Long>> oids;

	public QueryPartStackFrame(QueryObjectProvider queryObjectProvider, PackageMetaData packageMetaData, Query query, JsonObject jsonQuery, Reusable reusable) throws BimserverDatabaseException {
		this.queryObjectProvider = queryObjectProvider;
		this.packageMetaData = packageMetaData;
		this.query = query;
		this.jsonQuery = jsonQuery;
		this.reusable = reusable;
		if (jsonQuery.has("type")) {
			String type = jsonQuery.get("type").getAsString();
			if (type.equals("Object")) {
				typeIterator = query.getOidCounters().keySet().iterator();
			} else {
				EClass typeClass = packageMetaData.getEClassIncludingDependencies(type);
				Set<EClass> eClasses = new HashSet<EClass>();
				eClasses.add(typeClass);
				if (jsonQuery.has("includeAllSubtypes") && jsonQuery.get("includeAllSubtypes").getAsBoolean()) {
					eClasses.addAll(packageMetaData.getAllSubClasses((EClass)typeClass));
				}
				typeIterator = eClasses.iterator();
			}
		}
		if (jsonQuery.has("oids")) {
			oids = new HashMap<EClass, List<Long>>();
			JsonArray oids = jsonQuery.getAsJsonArray("oids");
			System.out.println(oids);
			for (int i=0; i<oids.size(); i++) {
				long oid = oids.get(i).getAsLong();
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
	}

	@Override
	public StackFrame process() throws BimserverDatabaseException, QueryException {
		if (typeIterator == null) {
			return null;
		}
		if (typeIterator.hasNext()) {
			EClass eClass = typeIterator.next();
			if (oids == null) {
				return new QueryTypeStackFrame(queryObjectProvider, eClass, query, jsonQuery, packageMetaData, reusable);
			} else {
				return new QueryOidsAndTypesStackFrame(queryObjectProvider, eClass, query, jsonQuery, packageMetaData, reusable, oids.get(eClass));
			}
		}
		return null;
	}
}