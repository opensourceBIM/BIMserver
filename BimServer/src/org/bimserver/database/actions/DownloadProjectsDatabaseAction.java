package org.bimserver.database.actions;

import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.bimserver.SettingsManager;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelChangeListener;
import org.bimserver.ifc.IfcModelSet;
import org.bimserver.merging.Merger;
import org.bimserver.merging.Merger.GuidMergeIdentifier;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.User;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class DownloadProjectsDatabaseAction extends BimDatabaseAction<IfcModel> {

	private final long actingUoid;
	private final Set<Long> roids;
	private int progress;
	private final SettingsManager settingsManager;

	public DownloadProjectsDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod,
			SettingsManager settingsManager, Set<Long> roids, long actingUoid) {
		super(bimDatabaseSession, accessMethod);
		this.settingsManager = settingsManager;
		this.roids = roids;
		this.actingUoid = actingUoid;
	}

	@Override
	public IfcModel execute() throws UserException, BimDeadlockException, BimDatabaseException {
		User user = getUserByUoid(actingUoid);
		Project project = null;
		String projectName = "";
		IfcModelSet ifcModelSet = new IfcModelSet();
		long incrSize = 0;
		for (long roid : roids) {
			Revision revision = getVirtualRevision(roid);
			for (ConcreteRevision subRevision : revision.getConcreteRevisions()) {
				incrSize += subRevision.getSize();
			}
		}
		final long totalSize = incrSize;
		final AtomicLong total = new AtomicLong();

		for (long roid : roids) {
			Revision revision = getVirtualRevision(roid);
			project = revision.getProject();
			if (RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
				for (ConcreteRevision concreteRevision : revision.getConcreteRevisions()) {
					IfcModel subModel = new IfcModel();
					subModel.addChangeListener(new IfcModelChangeListener() {
						@Override
						public void objectAdded() {
							total.incrementAndGet();
							progress = Math.round(100L * total.get() / totalSize);
						}
					});
					getDatabaseSession().getMap(subModel, concreteRevision.getProject().getId(), concreteRevision.getId(), true);
					projectName += concreteRevision.getProject().getName() + "-";
					subModel.setDate(concreteRevision.getDate());
					ifcModelSet.add(subModel);
				}
			} else {
				throw new UserException("User has no rights on project " + project.getOid());
			}
		}
		IfcModel ifcModel = new Merger(new GuidMergeIdentifier()).merge(project, ifcModelSet, settingsManager.getSettings().isIntelligentMerging());
		if (projectName.endsWith("-")) {
			projectName = projectName.substring(0, projectName.length() - 1);
		}
		return ifcModel;
	}

	public int getProgress() {
		return progress;
	}

}