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

public class BranchToExistingProjectDatabaseAction extends BimDatabaseAction<Integer> {
	private static final Logger LOGGER = LoggerFactory.getLogger(BranchToExistingProjectDatabaseAction.class);
	private final Long roid;
	private final Long destPoid;
	private final String comment;
	private final BimServer bimServer;
	private final Long currentUoid;
	
	public BranchToExistingProjectDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, BimServer bimServer, Long currentUoid, Long roid, Long destPoid, String comment) {
		super(bimDatabaseSession, accessMethod);
		this.bimServer = bimServer;
		this.currentUoid = currentUoid;
		this.roid = roid;
		this.destPoid = destPoid;
		this.comment = comment;
	}

	@Override
	public Integer execute() throws UserException, BimDeadlockException, BimDatabaseException {
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
		BimDatabaseAction<ConcreteRevision> action = new CheckinPart1DatabaseAction(getDatabaseSession(), getAccessMethod(), destPoid, currentUoid, model, comment);
		try {
			ConcreteRevision revision = action.execute();
			CheckinPart2DatabaseAction createCheckinAction = new CheckinPart2DatabaseAction(bimServer, getDatabaseSession(), getAccessMethod(), model, currentUoid, revision.getOid(), false);
			SCheckinResult result = new SCheckinResult();
			result.setProjectId(revision.getProject().getOid());
			// result.setProjectName(revision.getProject().getName());
			LongCheckinAction longAction = new LongCheckinAction(bimServer, user, createCheckinAction);
			bimServer.getLongActionManager().start(longAction);
			return longAction.getId();
		} catch (UserException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		return null;
	}
}