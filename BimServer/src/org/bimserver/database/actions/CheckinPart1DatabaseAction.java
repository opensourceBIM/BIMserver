package org.bimserver.database.actions;

import java.util.Date;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.mail.MailSystem;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.NewRevisionAdded;
import org.bimserver.models.store.CheckinState;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class CheckinPart1DatabaseAction extends GenericCheckinDatabaseAction {

	private final long actingUid;
	private final String comment;
	private final long poid;

	public CheckinPart1DatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long poid, long actingUid, IfcModelInterface model, String comment) {
		super(bimDatabaseSession, accessMethod, model);
		this.poid = poid;
		this.actingUid = actingUid;
		this.comment = comment;
	}

	@Override
	public ConcreteRevision execute() throws UserException, BimDeadlockException, BimDatabaseException {
		try {
			Project project = getProjectByPoid(poid);
			User user = getUserByUoid(actingUid);
			if (project == null) {
				throw new UserException("Project with poid " + poid + " not found");
			}
			if (user.getUserType() == UserType.ANONYMOUS) {
				throw new UserException("User anonymous cannot create new revisions");
			}
			if (!RightsManager.hasRightsOnProjectOrSuperProjects(user, project)) {
				throw new UserException("User has no rights to checkin models to this project");
			}
			if (!MailSystem.isValidEmailAddress(user.getUsername())) {
				throw new UserException("Users must have a valid e-mail address to checkin");
			}
			checkCheckSum(project);
			if (!project.getRevisions().isEmpty() && project.getRevisions().get(project.getRevisions().size() - 1).getState() == CheckinState.STORING) {
				throw new UserException("Another checkin on this project is currently running, please wait and try again");
			}
			ConcreteRevision concreteRevision = createNewConcreteRevision(getDatabaseSession(), getModel().getSize(), poid, actingUid, comment.trim(), CheckinState.STORING);
			concreteRevision.setChecksum(getModel().getChecksum());
			NewRevisionAdded newRevisionAdded = LogFactory.eINSTANCE.createNewRevisionAdded();
			newRevisionAdded.setDate(new Date());
			newRevisionAdded.setExecutor(user);
			newRevisionAdded.setRevision(concreteRevision.getRevisions().get(0));
			newRevisionAdded.setAccessMethod(getAccessMethod());
			getDatabaseSession().store(newRevisionAdded);
			getDatabaseSession().store(concreteRevision);
			getDatabaseSession().store(project);
			return concreteRevision;
		} catch (Exception e) {
			throw new UserException(e);
		}
	}
}