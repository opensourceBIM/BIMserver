package org.bimserver.database.queries;

import java.util.Iterator;
import java.util.Set;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.shared.QueryException;

public class StartFrame extends StackFrame {

	private Iterator<Long> roidsIterator;
	private QueryObjectProvider queryObjectProvider;

	public StartFrame(QueryObjectProvider queryObjectProvider, Set<Long> roids) throws QueryException {
		this.queryObjectProvider = queryObjectProvider;
		if (roids.size() == 0) {
			throw new QueryException("At least one roid required");
		}
		this.roidsIterator = roids.iterator();
	}

	@Override
	public boolean process() throws BimserverDatabaseException {
		queryObjectProvider.push(new RevisionStackFrame(queryObjectProvider, this.roidsIterator.next()));
		if (this.roidsIterator.hasNext()) {
			return false;
		}
		return true;
	}
}