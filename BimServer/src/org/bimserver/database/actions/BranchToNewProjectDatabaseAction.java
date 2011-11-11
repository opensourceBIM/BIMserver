package org.bimserver.database.actions;

import org.bimserver.BimServer;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelSet;
import org.bimserver.interfaces.objects.SCheckinResult;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BranchToNewProjectDatabaseAction extends BimDatabaseAction<SCheckinResult> {
	private static final Logger LOGGER = LoggerFactory.getLogger(BranchToNewProjectDatabaseAction.class);
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
	public SCheckinResult execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Revision oldRevision = getDatabaseSession().get(StorePackage.eINSTANCE.getRevision(), roid, false, null);
		Project oldProject = oldRevision.getProject();
		User user = getDatabaseSession().get(StorePackage.eINSTANCE.getUser(), currentUoid, false, null);
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
		IfcModelInterface model = bimServer.getMergerFactory().createMerger()
				.merge(oldRevision.getProject(), ifcModelSet, bimServer.getSettingsManager().getSettings().isIntelligentMerging());
		model.resetOids();
		Project newProject = new AddProjectDatabaseAction(bimServer, getDatabaseSession(), getAccessMethod(), projectName, currentUoid).execute();
		BimDatabaseAction<ConcreteRevision> action = new CheckinPart1DatabaseAction(getDatabaseSession(), getAccessMethod(), newProject.getOid(), currentUoid, model, comment);
		try {
			ConcreteRevision revision = action.execute();
			CheckinPart2DatabaseAction createCheckinAction = new CheckinPart2DatabaseAction(bimServer, getDatabaseSession(), getAccessMethod(), model, currentUoid, revision.getOid(), false);
			SCheckinResult result = new SCheckinResult();
			result.setProjectId(revision.getProject().getOid());
			// result.setProjectName(revision.getProject().getName());
			bimServer.getLongActionManager().start(new LongCheckinAction(bimServer, user, createCheckinAction));
			return result;
		} catch (UserException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		return null;
	}
}