package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.Query;
import org.bimserver.database.Query.Deep;
import org.bimserver.database.queries.QueryObjectProvider;
import org.bimserver.database.queries.QueryStackFrame;
import org.bimserver.database.queries.StackFrame;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Revision;
import org.bimserver.shared.Reusable;

public class ConcreteRevisionStackFrame implements StackFrame {

	private QueryObjectProvider queryObjectProvider;
	private PackageMetaData packageMetaData;
	private Query query;
	private Reusable reusable;
	private boolean hasRun = false;

	public ConcreteRevisionStackFrame(QueryObjectProvider queryObjectProvider, ConcreteRevision concreteRevision) {
		this.queryObjectProvider = queryObjectProvider;
		int highestStopId = AbstractDownloadDatabaseAction.findHighestStopRid(concreteRevision.getProject(), concreteRevision);
		packageMetaData = queryObjectProvider.getMetaDataManager().getPackageMetaData(concreteRevision.getProject().getSchema());
		Revision revision = concreteRevision.getRevisions().get(0);
		query = new Query(packageMetaData, concreteRevision.getProject().getId(), concreteRevision.getId(), revision.getOid(), null, Deep.NO, highestStopId);
		query.updateOidCounters(concreteRevision, queryObjectProvider.getDatabaseSession());
		reusable = new Reusable(queryObjectProvider.getDatabaseSession(), packageMetaData, query.getPid(), query.getRid(), revision.getOid());
	}

	@Override
	public StackFrame process() throws BimserverDatabaseException {
		if (hasRun) {
			return null;
		} else {
			hasRun = true;
			return new QueryStackFrame(queryObjectProvider, packageMetaData, query, reusable);
		}
	}
}
