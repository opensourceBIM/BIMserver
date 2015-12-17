package org.bimserver.database.queries;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.OldQuery;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;

public class RevisionStackFrame extends StackFrame {

	private Revision currentRevision;
	private Map<Integer, Long> pidRoidMap = new HashMap<>();
	private Iterator<ConcreteRevision> concreteRevisionIterator;
	private QueryObjectProvider queryObjectProvider;

	public RevisionStackFrame(QueryObjectProvider queryObjectProvider, long roid) throws BimserverDatabaseException {
		this.queryObjectProvider = queryObjectProvider;
		currentRevision = (Revision) queryObjectProvider.getDatabaseSession().get(StorePackage.eINSTANCE.getRevision(), roid, OldQuery.getDefault());
		pidRoidMap.put(currentRevision.getProject().getId(), currentRevision.getOid());
		concreteRevisionIterator = currentRevision.getConcreteRevisions().iterator();
	}

	@Override
	public boolean process() {
		queryObjectProvider.push(new ConcreteRevisionStackFrame(queryObjectProvider, this.concreteRevisionIterator.next()));
		if (concreteRevisionIterator.hasNext()) {
			return false;
		}
		return true;
	}
}