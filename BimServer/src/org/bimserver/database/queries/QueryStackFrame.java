package org.bimserver.database.queries;

import java.io.IOException;
import java.util.Iterator;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.Query;
import org.bimserver.database.queries.om.Namespace;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.shared.Reusable;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class QueryStackFrame extends StackFrame {

	private Iterator<QueryPart> queryIterator;
	private QueryObjectProvider queryObjectProvider;
	private PackageMetaData packageMetaData;
	private Query query;
	private Reusable reusable;

	public QueryStackFrame(QueryObjectProvider queryObjectProvider, PackageMetaData packageMetaData, Query query, Reusable reusable) throws JsonParseException, JsonMappingException, IOException {
		this.queryObjectProvider = queryObjectProvider;
		this.packageMetaData = packageMetaData;
		this.query = query;
		this.reusable = reusable;
		Namespace namespace = queryObjectProvider.getNameSpace();
		queryIterator = namespace.getQueryParts().iterator();
	}
	
	@Override
	public boolean process() throws BimserverDatabaseException, QueryException {
		QueryPart next = queryIterator.next();
		queryObjectProvider.push(new QueryPartStackFrame(queryObjectProvider,packageMetaData, query, next, reusable));
		if (queryIterator.hasNext()) {
			return false;
		}
		return true;
	}
}
