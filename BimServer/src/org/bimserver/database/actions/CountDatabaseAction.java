package org.bimserver.database.actions;

import org.bimserver.SummaryMap;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.RevisionSummary;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class CountDatabaseAction extends BimDatabaseAction<Integer> {

	private Long roid;
	private String className;

	public CountDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, Long roid, String className, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.roid = roid;
		this.className = className;
		
	}

	@Override
	public Integer execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Revision revision = getRevisionByRoid(roid);
		if (revision == null) {
			throw new UserException("Revision with roid " + roid + " not found");
		}
		if (revision.getConcreteRevisions().size() == 1 && revision.getConcreteRevisions().get(0).getSummary() != null) {
			RevisionSummary summary = revision.getConcreteRevisions().get(0).getSummary();
			SummaryMap summaryMap = new SummaryMap(summary);
			return summaryMap.count(getDatabaseSession().getEClassForName(className));
		}
		return null;
	}
}
