package org.bimserver.database.queries;

import java.io.IOException;
import java.util.Iterator;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.shared.QueryContext;
import org.bimserver.shared.QueryException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class QueryStackFrame extends StackFrame {

	private Iterator<QueryPart> queryIterator;
	private QueryObjectProvider queryObjectProvider;
	private QueryContext reusable;

	public QueryStackFrame(QueryObjectProvider queryObjectProvider, QueryContext reusable) throws JsonParseException, JsonMappingException, IOException {
		this.queryObjectProvider = queryObjectProvider;
		this.reusable = reusable;
		Query query = queryObjectProvider.getQuery();
		queryIterator = query.getQueryParts().iterator();
	}

	@Override
	public boolean process() throws BimserverDatabaseException, QueryException {
		QueryPart next = queryIterator.next();
		queryObjectProvider.push(new QueryPartStackFrame(queryObjectProvider, next, reusable));
		if (queryIterator.hasNext()) {
			return false;
		}
		return true;
	}
}
