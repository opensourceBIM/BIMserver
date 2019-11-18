package org.bimserver.database.queries;

import java.io.IOException;
import java.util.Iterator;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.shared.QueryContext;
import org.eclipse.emf.ecore.EClass;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class AllStackFrame extends DatabaseReadingStackFrame {

	private final Iterator<EClass> typeIterator;

	public AllStackFrame(QueryObjectProvider queryObjectProvider, QueryContext reusable) {
		super(reusable, queryObjectProvider, null);
		if (reusable.getOidCounters() != null) {
			typeIterator = reusable.getOidCounters().keySet().iterator();
		} else {
			throw new RuntimeException("Not implemented");
		}
	}

	@Override
	boolean process() throws BimserverDatabaseException, QueryException, JsonParseException, JsonMappingException, IOException {
		if (typeIterator.hasNext()) {
			EClass eClass = typeIterator.next();
			getQueryObjectProvider().push(new QueryTypeStackFrame(getQueryObjectProvider(), eClass, getReusable(), null));
		}
		return !typeIterator.hasNext();
	}
}