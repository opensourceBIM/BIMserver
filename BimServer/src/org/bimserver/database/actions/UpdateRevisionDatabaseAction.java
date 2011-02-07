package org.bimserver.database.actions;

import java.util.Date;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.User;
import org.bimserver.database.store.UserType;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.database.store.log.LogFactory;
import org.bimserver.database.store.log.RevisionUpdated;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class UpdateRevisionDatabaseAction extends BimDatabaseAction<Void> {

	private final SRevision sRevision;
	private final long actingUoid;

	public UpdateRevisionDatabaseAction(AccessMethod accessMethod, long actingUoid, SRevision sRevision) {
		super(accessMethod);
		this.actingUoid = actingUoid;
		this.sRevision = sRevision;
	}

	@Override
	public Void execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		User actingUser = bimDatabaseSession.getUserByUoid(actingUoid);
		final Revision revision = bimDatabaseSession.getRevisionByRoid(sRevision.getOid());
		if (revision == null) {
			throw new UserException("Revision with pid " + sRevision.getOid() + " not found");
		}
		Project project = revision.getProject();
		if (actingUser.getUserType() == UserType.ANONYMOUS) {
			throw new UserException("User anonymous cannot update revision properties");
		}
		if (!RightsManager.hasRightsOnProjectOrSuperProjects(actingUser, project)) {
			throw new UserException("User has no rights to update project properties");
		}
		RevisionUpdated revisionUpdated = LogFactory.eINSTANCE.createRevisionUpdated();
		revisionUpdated.setRevision(revision);
		revisionUpdated.setDate(new Date());
		revisionUpdated.setExecutor(actingUser);
		revisionUpdated.setAccessMethod(getAccessMethod());
		revision.setTag(sRevision.getTag());
		bimDatabaseSession.store(revisionUpdated);
		bimDatabaseSession.store(revision);
		return null;
	}
}