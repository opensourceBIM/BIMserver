package org.bimserver.database.actions;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ModelCheckerInstance;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class AddModelCheckerToProjectDatabaseAction extends BimDatabaseAction<Void> {

	private long poid;
	private ModelCheckerInstance modelChecker;

	public AddModelCheckerToProjectDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long poid, ModelCheckerInstance modelChecker, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.poid = poid;
		this.modelChecker = modelChecker;
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Project project = getDatabaseSession().get(StorePackage.eINSTANCE.getProject(), poid, OldQuery.getDefault());
		project.getModelCheckers().add(modelChecker);
		getDatabaseSession().store(modelChecker);
		getDatabaseSession().store(project);
		return null;
	}
}