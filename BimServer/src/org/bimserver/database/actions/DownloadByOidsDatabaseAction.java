package org.bimserver.database.actions;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.bimserver.BimServer;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelChangeListener;
import org.bimserver.ifc.IfcModelSet;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.User;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class DownloadByOidsDatabaseAction extends BimDatabaseAction<IfcModelInterface> {

	private final long actingUoid;
	private final Set<Long> oids;
	private final Set<Long> roids;
	private int progress;
	private final BimServer bimServer;

	public DownloadByOidsDatabaseAction(BimServer bimServer, BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, Set<Long> roids, Set<Long> oids, long actingUoid) {
		super(bimDatabaseSession, accessMethod);
		this.bimServer = bimServer;
		this.roids = roids;
		this.oids = oids;
		this.actingUoid = actingUoid;
	}

	@Override
	public IfcModelInterface execute() throws UserException, BimDeadlockException, BimDatabaseException {
		User user = getUserByUoid(actingUoid);
		IfcModelSet ifcModelSet = new IfcModelSet();
		Project project = null;
		long incrSize = 0L;
		for (Long roid : roids) {
			Revision virtualRevision = getVirtualRevision(roid);
			project = virtualRevision.getProject();
			if (!RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
				throw new UserException("User has insufficient rights to download revisions from this project");
			}
			incrSize += virtualRevision.getConcreteRevisions().size();
			final long totalSize = incrSize;
			final AtomicLong total = new AtomicLong();
			for (ConcreteRevision concreteRevision : virtualRevision.getConcreteRevisions()) {
				IfcModel subModel = new IfcModel();
				subModel.addChangeListener(new IfcModelChangeListener() {
					@Override
					public void objectAdded() {
						total.incrementAndGet();
						progress = Math.round(100L * total.get() / totalSize);
					}
				});
				getDatabaseSession().getMapWithOids(subModel, concreteRevision.getProject().getId(), concreteRevision.getId(), oids, true);
				subModel.setDate(concreteRevision.getDate());
				ifcModelSet.add(subModel);
				// for (Long oid : oids) {
				// IfcModel subModel =
				// bimDatabaseSession.getMapWithOids(concreteRevision.getProject().getId(),
				// concreteRevision.getId(), oid);
				// subModel.setDate(concreteRevision.getDate());
				// ifcModels.add(subModel);
				// }
			}
		}
		IfcModelInterface ifcModel = bimServer.getMergerFactory().createMerger().merge(project, ifcModelSet, bimServer.getSettingsManager().getSettings().isIntelligentMerging());
		ifcModel.setName("Unknown");
		ifcModel.setRevisionNr(1);
		ifcModel.setAuthorizedUser(getUserByUoid(actingUoid).getName());
		ifcModel.setDate(new Date());
		return ifcModel;
	}
	
	public int getProgress() {
		return progress;
	}
}