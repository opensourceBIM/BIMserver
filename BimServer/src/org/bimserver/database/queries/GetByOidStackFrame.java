package org.bimserver.database.queries;

import java.io.IOException;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.QueryContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class GetByOidStackFrame extends DatabaseReadingStackFrame {

	private long oid;

	public GetByOidStackFrame(QueryContext reusable, QueryObjectProvider queryObjectProvider, QueryPart queryPart, long oid) {
		super(reusable, queryObjectProvider, queryPart);
		this.oid = oid;
	}

	@Override
	boolean process() throws BimserverDatabaseException, QueryException, JsonParseException, JsonMappingException, IOException {
		HashMapVirtualObject byOid = getByOid(oid);
		return false;
	}
}
