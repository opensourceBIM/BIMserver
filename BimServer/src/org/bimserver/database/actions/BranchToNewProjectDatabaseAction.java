package org.bimserver.database.actions;

import org.bimserver.BimServer;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelSet;
import org.bimserver.interfaces.objects.SCheckinResult;
import org.bimserver.longaction.CannotBeScheduledException;
import org.bimserver.longaction.LongCheckinAction;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.exceptions.UserException;

public class BranchToNewProjectDatabaseAction extends BimDatabaseAction<Integer> {
	private final BimServer bimServer;
	private final Long currentUoid;
	private final Long roid;
	private final String projectName;
	private final String comment;
	
	public BranchToNewProjectDatabaseAction(BimDatabaseSession session, AccessMethod accessMethod, BimServer bimServer, Long currentUoid, Long roid, String projectName,
			String comment) {
		super(session, accessMethod);
		this.bimServer = bimServer;
		this.currentUoid = currentUoid;
		this.roid = roid;
		this.projectName = projectName;
		this.comment = comment;
	}

	@Override
	public Integer execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Revision oldRevision = getDatabaseSession().get(StorePackage.eINSTANCE.getRevision(), roid, false, null);
		Project oldProject = oldRevision.getProject();
		final User user = getDatabaseSession().get(StorePackage.eINSTANCE.getUser(), currentUoid, false, null);
		if (!RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, oldProject)) {
			throw new UserException("User has insufficient rights to download revisions from this project");
		}
		IfcModelSet ifcModelSet = new IfcModelSet();
		for (ConcreteRevision subRevision : oldRevision.getConcreteRevisions()) {
			IfcModel subModel = new IfcModel();
			getDatabaseSession().getMap(subModel, subRevision.getProject().getId(), subRevision.getId(), true, null);
			subModel.setDate(subRevision.getDate());
			ifcModelSet.add(subModel);
		}
		final IfcModelInterface model = bimServer.getMergerFactory().createMerger().merge(oldRevision.getProject(), ifcModelSet, bimServer.getSettingsManager().getSettings().isIntelligentMerging());
		model.resetOids();
		final Project newProject = new AddProjectDatabaseAction(bimServer, getDatabaseSession(), getAccessMethod(), projectName, currentUoid).execute();
		BimDatabaseAction<ConcreteRevision> action = new CheckinPart1DatabaseAction(getDatabaseSession(), getAccessMethod(), newProject.getOid(), currentUoid, model, comment);
		ConcreteRevision revision = action.execute();
		CheckinPart2DatabaseAction createCheckinAction = new CheckinPart2DatabaseAction(bimServer, bimServer.getDatabase().createSession(true), getAccessMethod(), model, currentUoid, revision.getOid(), false, true);
		SCheckinResult result = new SCheckinResult();
		result.setProjectId(revision.getProject().getOid());
		// result.setProjectName(revision.getProject().getName());
		LongCheckinAction longAction = new LongCheckinAction(bimServer, user, createCheckinAction);
		try {
			bimServer.getLongActionManager().start(longAction);
		} catch (CannotBeScheduledException e) {
			e.printStackTrace();
		}
		return longAction.getId();
	}
}