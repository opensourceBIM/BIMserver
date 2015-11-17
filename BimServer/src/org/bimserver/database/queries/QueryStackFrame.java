package org.bimserver.database.queries;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.Query;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.shared.Reusable;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class QueryStackFrame implements StackFrame {

	private Iterator<JsonElement> queryIterator;
	private JsonElement jsonQuery;
	private QueryObjectProvider queryObjectProvider;
	private PackageMetaData packageMetaData;
	private Query query;
	private Reusable reusable;

	public QueryStackFrame(QueryObjectProvider queryObjectProvider, PackageMetaData packageMetaData, Query query, Reusable reusable) {
		this.queryObjectProvider = queryObjectProvider;
		this.packageMetaData = packageMetaData;
		this.query = query;
		this.reusable = reusable;
		JsonParser parser = new JsonParser();
		jsonQuery = parser.parse(queryObjectProvider.getJsonString());
		final JsonObject queryObject = (JsonObject)jsonQuery;
		if (queryObject.has("queries")) {
			queryIterator = queryObject.get("queries").getAsJsonArray().iterator();
		} else {
			queryIterator = new SingleIterator<JsonElement>(queryObject);
		}
	}
	
	@Override
	public Set<StackFrame> process() throws BimserverDatabaseException, QueryException {
		if (queryIterator.hasNext()) {
			JsonElement next = queryIterator.next();
			return Collections.<StackFrame>singleton(new QueryPartStackFrame(queryObjectProvider,packageMetaData, query, (JsonObject) next, reusable));
		}
		return null;
	}
}
