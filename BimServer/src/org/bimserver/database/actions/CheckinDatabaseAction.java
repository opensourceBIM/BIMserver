package org.bimserver.database.actions;

import java.util.Date;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.ifc.IfcModel;
import org.bimserver.mail.MailSystem;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.NewRevisionAdded;
import org.bimserver.models.store.CheckinState;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class CheckinDatabaseAction extends GenericCheckinDatabaseAction {

	private final String comment;
	private final long actingUoid;
	private final long poid;

	public CheckinDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, IfcModel model, long poid, long actingUoid, String comment) {
		super(bimDatabaseSession, accessMethod, model);
		this.poid = poid;
		this.actingUoid = actingUoid;
		this.comment = comment;
	}

	@Override
	public ConcreteRevision execute() throws UserException, BimDatabaseException, BimDeadlockException {
		Project project = getProjectByPoid(poid);
		User user = getUserByUoid(actingUoid);
		if (user.getUserType() == UserType.ANONYMOUS_LITERAL) {
			throw new UserException("User anonymous cannot create new revisions");
		}
		if (project == null) {
			throw new UserException("Project with pid " + poid + " not found");
		}
		if (!RightsManager.hasRightsOnProjectOrSuperProjects(user, project)) {
			throw new UserException("User has no rights to checkin models to this project");
		}
		if (!project.getRevisions().isEmpty() && project.getRevisions().get(project.getRevisions().size()-1).getState() == CheckinState.STORING_LITERAL) {
			throw new UserException("Another checkin on this project is currently running, please wait and try again");
		}
		if (!MailSystem.isValidEmailAddress(user.getUsername())) {
			throw new UserException("Users must have a valid e-mail address to checkin");
		}
		checkCheckSum(project);
		ConcreteRevision concreteRevision = createNewConcreteRevision(getDatabaseSession(), model.size(), poid, actingUoid, comment.trim(), CheckinState.DONE_LITERAL);
		Revision virtualRevision = concreteRevision.getRevisions().get(0);
		concreteRevision.setChecksum(model.getChecksum());
		project.setLastConcreteRevision(concreteRevision);
		project.setLastRevision(virtualRevision);
		concreteRevision.setState(CheckinState.STORING_LITERAL);
		if (concreteRevision.getId() != 1) {
			// There already was a revision, lets go delete it
			getDatabaseSession().clearProject(project.getId(), concreteRevision.getId() - 1, concreteRevision.getId());
		}
		NewRevisionAdded newRevisionAdded = LogFactory.eINSTANCE.createNewRevisionAdded();
		newRevisionAdded.setDate(new Date());
		newRevisionAdded.setExecutor(user);
		newRevisionAdded.setRevision(virtualRevision);
		newRevisionAdded.setAccessMethod(getAccessMethod());
		getDatabaseSession().store(newRevisionAdded);
		getDatabaseSession().store(model.getValues(), project.getId(), concreteRevision.getId());
		getDatabaseSession().store(concreteRevision);
		getDatabaseSession().store(project);
		return concreteRevision;
	}
}