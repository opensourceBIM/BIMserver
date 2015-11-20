package org.bimserver.database.queries.om;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bimserver.database.queries.QueryException;

public class Namespace {
	private final Map<String, Include> defines = new HashMap<>();
	private final List<QueryPart> queryParts = new ArrayList<>();
	private String name;
	
	public Namespace(String name) throws QueryException {
		this.name = name;
	}

	public void addDefine(String name, Include include) {
		defines.put(name, include);
	}
	
	public void addQueryPart(QueryPart queryPart) {
		queryParts.add(queryPart);
	}
	
	public String getName() {
		return name;
	}

	public Include getDefine(String includeName) {
		return defines.get(includeName);
	}
	
	public List<QueryPart> getQueryParts() {
		return queryParts;
	}
}