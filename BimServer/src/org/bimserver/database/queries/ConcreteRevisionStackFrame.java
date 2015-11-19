package org.bimserver.database.queries;

import java.io.IOException;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.Query;
import org.bimserver.database.Query.Deep;
import org.bimserver.database.actions.AbstractDownloadDatabaseAction;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Revision;
import org.bimserver.shared.Reusable;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class ConcreteRevisionStackFrame extends StackFrame {

	private QueryObjectProvider queryObjectProvider;
	private PackageMetaData packageMetaData;
	private Query query;
	private Reusable reusable;

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
	public boolean process() throws BimserverDatabaseException, JsonParseException, JsonMappingException, IOException {
		queryObjectProvider.push(new QueryStackFrame(queryObjectProvider, packageMetaData, query, reusable));
		return true;
	}
}