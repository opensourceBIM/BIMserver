package org.bimserver.database.queries;

import java.util.Iterator;
import java.util.Set;

import org.bimserver.BimserverDatabaseException;

public class StartFrame implements StackFrame {

	private Iterator<Long> roidsIterator;
	private QueryObjectProvider queryObjectProvider;

	public StartFrame(QueryObjectProvider queryObjectProvider, Set<Long> roids) {
		this.queryObjectProvider = queryObjectProvider;
		this.roidsIterator = roids.iterator();
	}

	@Override
	public StackFrame process() throws BimserverDatabaseException {
		if (this.roidsIterator.hasNext()) {
			return new RevisionStackFrame(queryObjectProvider, this.roidsIterator.next());
		}
		return null;
	}
}