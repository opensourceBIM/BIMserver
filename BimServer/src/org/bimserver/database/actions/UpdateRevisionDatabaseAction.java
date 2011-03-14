package org.bimserver.database.actions;

import java.util.Date;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.RevisionUpdated;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class UpdateRevisionDatabaseAction extends BimDatabaseAction<Void> {

	private final SRevision sRevision;
	private final long actingUoid;

	public UpdateRevisionDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long actingUoid, SRevision sRevision) {
		super(bimDatabaseSession, accessMethod);
		this.actingUoid = actingUoid;
		this.sRevision = sRevision;
	}

	@Override
	public Void execute() throws UserException, BimDeadlockException, BimDatabaseException {
		User actingUser = getUserByUoid(actingUoid);
		final Revision revision = getRevisionByRoid(sRevision.getOid());
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
		getDatabaseSession().store(revisionUpdated);
		getDatabaseSession().store(revision);
		return null;
	}
}