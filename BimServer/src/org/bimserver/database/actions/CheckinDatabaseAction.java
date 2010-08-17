package org.bimserver.database.actions;

import java.util.Date;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.CommitSet;
import org.bimserver.database.Database;
import org.bimserver.database.store.ConcreteRevision;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.User;
import org.bimserver.database.store.UserType;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.database.store.log.LogFactory;
import org.bimserver.database.store.log.NewRevisionAdded;
import org.bimserver.ifc.IfcModel;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class CheckinDatabaseAction extends GenericCheckinDatabaseAction {

	private final String comment;
	private final long actingUoid;
	private final long poid;

	public CheckinDatabaseAction(AccessMethod accessMethod, IfcModel model, long poid, long actingUoid, String comment) {
		super(accessMethod, model);
		this.poid = poid;
		this.actingUoid = actingUoid;
		this.comment = comment;
	}

	@Override
	public ConcreteRevision execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDatabaseException, BimDeadlockException {
		Project project = bimDatabaseSession.getProjectByPoid(poid);
		User user = bimDatabaseSession.getUserByUoid(actingUoid);
		if (user.getUserType() == UserType.ANONYMOUS) {
			throw new UserException("User anonymous cannot create new revisions");
		}
		if (project == null) {
			throw new UserException("Project with pid " + poid + " not found");
		}
		if (!RightsManager.hasRightsOnProjectOrSuperProjects(user, project)) {
			throw new UserException("User has no rights to checkin models to this project");
		}
		if (!project.getRevisions().isEmpty() && !project.getRevisions().get(project.getRevisions().size()-1).isFinalized()) {
			throw new UserException("Another checkin on this project is currently running, please wait and try again");
		}
		checkCheckSum(project);
		ConcreteRevision revision = bimDatabaseSession.createNewConcreteRevision(model.size(), poid, actingUoid, comment);
		revision.setChecksum(model.getChecksum());
		project.setLastConcreteRevision(revision);
		revision.setFinalized(true);
		if (revision.getId() != 1) {
			// There already was a revision, lets go delete em
			bimDatabaseSession.clearProject(project.getId(), revision.getId() - 1, revision.getId());
		}
		NewRevisionAdded newRevisionAdded = LogFactory.eINSTANCE.createNewRevisionAdded();
		newRevisionAdded.setDate(new Date());
		newRevisionAdded.setExecutor(user);
		newRevisionAdded.setRevision(revision.getRevisions().get(0));
		newRevisionAdded.setAccessMethod(getAccessMethod());
		CommitSet commitSet = new CommitSet(Database.STORE_PROJECT_ID, -1);
		bimDatabaseSession.store(newRevisionAdded, commitSet);
		bimDatabaseSession.store(model.getValues(), project.getId(), revision.getId());
		bimDatabaseSession.store(revision, commitSet);
		bimDatabaseSession.saveOidCounter();
		return revision;
	}
}