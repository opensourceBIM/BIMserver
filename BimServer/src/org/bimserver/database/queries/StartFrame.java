package org.bimserver.database.queries;

import java.util.Iterator;
import java.util.Set;

import org.bimserver.BimserverDatabaseException;

public class StartFrame extends StackFrame {

	private Iterator<Long> roidsIterator;
	private QueryObjectProvider queryObjectProvider;

	public StartFrame(QueryObjectProvider queryObjectProvider, Set<Long> roids) {
		this.queryObjectProvider = queryObjectProvider;
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