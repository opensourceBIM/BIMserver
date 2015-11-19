package org.bimserver.database.queries;

import java.io.IOException;
import java.util.Iterator;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.Query;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.shared.Reusable;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class QueryStackFrame extends StackFrame {

	private Iterator<JsonNode> queryIterator;
	private QueryObjectProvider queryObjectProvider;
	private PackageMetaData packageMetaData;
	private Query query;
	private Reusable reusable;

	public QueryStackFrame(QueryObjectProvider queryObjectProvider, PackageMetaData packageMetaData, Query query, Reusable reusable) throws JsonParseException, JsonMappingException, IOException {
		this.queryObjectProvider = queryObjectProvider;
		this.packageMetaData = packageMetaData;
		this.query = query;
		this.reusable = reusable;
		ObjectNode fullQuery = queryObjectProvider.getFullQuery();
		if (fullQuery.has("queries")) {
			queryIterator = fullQuery.get("queries").iterator();
		} else if (fullQuery.has("query")) {
			queryIterator = new SingleIterator<JsonNode>(fullQuery.get("query"));
		} else {
			queryIterator = new SingleIterator<JsonNode>(fullQuery);
		}
	}
	
	@Override
	public boolean process() throws BimserverDatabaseException, QueryException {
		JsonNode next = queryIterator.next();
		queryObjectProvider.push(new QueryPartStackFrame(queryObjectProvider,packageMetaData, query, (ObjectNode) next, reusable));
		if (queryIterator.hasNext()) {
			return false;
		}
		return true;
	}
}
