package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.CommitSet;
import org.bimserver.database.Database;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.User;
import org.bimserver.database.store.UserType;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class UpdateRevisionDatabaseAction extends BimDatabaseAction<Void> {

	private final SRevision sRevision;
	private final long actingUoid;

	public UpdateRevisionDatabaseAction(AccessMethod accessMethod, long actingUoid, SRevision sRevision) {
		super(accessMethod);
		this.actingUoid = actingUoid;
		this.sRevision = sRevision;
	}

	@Override
	public Void execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		User actingUser = bimDatabaseSession.getUserByUoid(actingUoid);
		final Revision revision = bimDatabaseSession.getRevisionByRoid(sRevision.getOid());
		Project project = revision.getProject();
		if (revision == null) {
			throw new UserException("Revision with pid " + sRevision.getOid() + " not found");
		}
		if (actingUser.getUserType() == UserType.ANONYMOUS) {
			throw new UserException("User anonymous cannot update revision properties");
		}
		if (!RightsManager.hasRightsOnProjectOrSuperProjects(actingUser, project)) {
			throw new UserException("User has no rights to update project properties");
		}
//		if (project.getParent() == null) {
//			if (!sProject.getName().equals(project.getName())) {
//				for (Project p : bimDatabaseSession.getProjectsByName(sProject.getName())) {
//					if (p.getParent() == null) {
//						throw new UserException("Project name must be unique");
//					}
//				}
//			}
//		} else {
//			Project parent = project.getParent();
//			for (Project subProject : parent.getSubProjects()) {
//				if (subProject.getName().equals(sProject.getName()) && subProject != project) {
//					throw new UserException("Project name must be unique within parent project (" + parent.getName() + ")");
//				}
//			}
//		}
//		project.setName(sProject.getName());
//		project.setDescription(sProject.getDescription());
//		project.setExportLengthMeasurePrefix(SIPrefix.get(sProject.getExportLengthMeasurePrefix().getOrdinal()));
		
		revision.setTag(sRevision.getTag());
		
//		ProjectUpdated projectUpdated = LogFactory.eINSTANCE.createProjectUpdated();
//		projectUpdated.setAccessMethod(getAccessMethod());
//		projectUpdated.setDate(new Date());
//		projectUpdated.setExecutor(actingUser);
//		projectUpdated.setProject(project);
		
		CommitSet commitSet = new CommitSet(Database.STORE_PROJECT_ID, -1);
		bimDatabaseSession.store(revision, commitSet);
//		bimDatabaseSession.store(project, commitSet);
//		bimDatabaseSession.savePidCounter();
//		bimDatabaseSession.saveOidCounter();
		return null;
	}
}