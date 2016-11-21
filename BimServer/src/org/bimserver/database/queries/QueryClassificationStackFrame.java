package org.bimserver.database.queries;

import java.io.IOException;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.shared.QueryContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class QueryClassificationStackFrame extends DatabaseReadingStackFrame {

	public QueryClassificationStackFrame(QueryContext reusable, QueryObjectProvider queryObjectProvider, QueryPart queryPart) {
		super(reusable, queryObjectProvider, queryPart);
	}

	@Override
	boolean process() throws BimserverDatabaseException, QueryException, JsonParseException, JsonMappingException, IOException {
		return false;
	}
}
