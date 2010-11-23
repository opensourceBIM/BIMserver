package org.bimserver.database.actions;

import java.util.Date;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.CommitSet;
import org.bimserver.database.Database;
import org.bimserver.database.store.CheckinState;
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

public class CheckinPart1DatabaseAction extends GenericCheckinDatabaseAction {

	private final long actingUid;
	private final String comment;
	private final IfcModel model;
	private final long poid;

	public CheckinPart1DatabaseAction(AccessMethod accessMethod, long poid, long actingUid, IfcModel model, String comment) {
		super(accessMethod, model);
		this.poid = poid;
		this.actingUid = actingUid;
		this.model = model;
		this.comment = comment;
	}

	@Override
	public ConcreteRevision execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		Project project = bimDatabaseSession.getProjectByPoid(poid);
		User user = bimDatabaseSession.getUserByUoid(actingUid);
		if (project == null) {
			throw new UserException("Project with poid " + poid + " not found");
		}
		if (user.getUserType() == UserType.ANONYMOUS) {
			throw new UserException("User anonymous cannot create new revisions");
		}
		if (!RightsManager.hasRightsOnProjectOrSuperProjects(user, project)) {
			throw new UserException("User has no rights to checkin models to this project");
		}
		checkCheckSum(project);
		if (!project.getRevisions().isEmpty() && project.getRevisions().get(project.getRevisions().size()-1).getState() == CheckinState.STORING) {
			throw new UserException("Another checkin on this project is currently running, please wait and try again");
		}
		ConcreteRevision concreteRevision = bimDatabaseSession.createNewConcreteRevision(model.getSize(), poid, actingUid, comment.trim(), CheckinState.STORING);
		concreteRevision.setChecksum(model.getChecksum());
		NewRevisionAdded newRevisionAdded = LogFactory.eINSTANCE.createNewRevisionAdded();
		newRevisionAdded.setDate(new Date());
		newRevisionAdded.setExecutor(user);
		newRevisionAdded.setRevision(concreteRevision.getRevisions().get(0));
		newRevisionAdded.setAccessMethod(getAccessMethod());
		CommitSet commitSet = new CommitSet(Database.STORE_PROJECT_ID, -1);
		bimDatabaseSession.store(newRevisionAdded, commitSet);
		bimDatabaseSession.store(concreteRevision, commitSet);
		bimDatabaseSession.saveOidCounter();
		return concreteRevision;
	}
}