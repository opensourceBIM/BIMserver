package org.bimserver.database.queries;

import java.util.Iterator;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.OldQuery;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;

public class RevisionStackFrame extends StackFrame {

	private Revision currentRevision;
	private Iterator<ConcreteRevision> concreteRevisionIterator;
	private QueryObjectProvider queryObjectProvider;
	private long roid;

	public RevisionStackFrame(QueryObjectProvider queryObjectProvider, long roid) throws BimserverDatabaseException {
		this.queryObjectProvider = queryObjectProvider;
		this.roid = roid;
		currentRevision = (Revision) queryObjectProvider.getDatabaseSession().get(StorePackage.eINSTANCE.getRevision(), roid, OldQuery.getDefault());
		concreteRevisionIterator = currentRevision.getConcreteRevisions().iterator();
	}

	@Override
	public boolean process() {
		if (!concreteRevisionIterator.hasNext()) {
			return true;
		}
		queryObjectProvider.push(new ConcreteRevisionStackFrame(queryObjectProvider, this.concreteRevisionIterator.next(), roid));
		if (concreteRevisionIterator.hasNext()) {
			return false;
		}
		return true;
	}
}