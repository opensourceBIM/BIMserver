package org.bimserver.database.actions;

import org.bimserver.BimServer;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelSet;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.User;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class DownloadOfTypeDatabaseAction extends BimDatabaseAction<IfcModelInterface> {

	private final String className;
	private final long actingUoid;
	private final long roid;
	private int progress;
	private final BimServer bimServer;

	public DownloadOfTypeDatabaseAction(BimServer bimServer, BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long roid, String className, long actingUoid) {
		super(bimDatabaseSession, accessMethod);
		this.bimServer = bimServer;
		this.roid = roid;
		this.actingUoid = actingUoid;
		this.className = className;
	}

	@Override
	public IfcModelInterface execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Revision virtualRevision = getVirtualRevision(roid);
		Project project = virtualRevision.getProject();
		User user = getUserByUoid(actingUoid);
		if (!RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
			throw new UserException("User has insufficient rights to download revisions from this project");
		}
		IfcModelSet ifcModelSet = new IfcModelSet();
		for (ConcreteRevision concreteRevision : virtualRevision.getConcreteRevisions()) {
			IfcModel subModel = getDatabaseSession().getAllOfType(className, concreteRevision.getProject().getId(), concreteRevision.getId(), true);
			subModel.setDate(concreteRevision.getDate());
			ifcModelSet.add(subModel);
		}
		IfcModelInterface ifcModel = bimServer.getMergerFactory().createMerger().merge(project, ifcModelSet, bimServer.getSettingsManager().getSettings().isIntelligentMerging());
		ifcModel.setName("Unknown");
		ifcModel.setRevisionNr(project.getRevisions().indexOf(virtualRevision) + 1);
		ifcModel.setAuthorizedUser(getUserByUoid(actingUoid).getName());
		ifcModel.setDate(virtualRevision.getDate());
		return ifcModel;
	}
	
	public int getProgress() {
		return progress;
	}
}