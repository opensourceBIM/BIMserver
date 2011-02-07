package org.bimserver.database.actions;

import java.util.Date;
import java.util.Set;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.ObjectIdentifier;
import org.bimserver.database.ReadSet;
import org.bimserver.database.store.ConcreteRevision;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.User;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelSet;
import org.bimserver.merging.Merger;
import org.bimserver.rights.RightsManager;
import org.bimserver.settings.ServerSettings;
import org.bimserver.shared.UserException;

public class DownloadByObjectIdentifiersDatabaseAction extends BimDatabaseAction<IfcModel> {

	private final long actingUoid;
	private final Set<ObjectIdentifier> oids;
	private final Set<Long> roids;

	public DownloadByObjectIdentifiersDatabaseAction(AccessMethod accessMethod, Set<Long> roids, Set<ObjectIdentifier> oids, long actingUoid) {
		super(accessMethod);
		this.roids = roids;
		this.oids = oids;
		this.actingUoid = actingUoid;
	}
	
	@Override
	public IfcModel execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		User user = bimDatabaseSession.getUserByUoid(actingUoid);
		IfcModelSet ifcModelSet = new IfcModelSet();
		Project project = null;
		for (Long roid : roids) {
			Revision virtualRevision = bimDatabaseSession.getVirtualRevision(roid);
			project = virtualRevision.getProject();
			if (!RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
				throw new UserException("User has insufficient rights to download revisions from this project");
			}
			for (ConcreteRevision concreteRevision : virtualRevision.getConcreteRevisions()) {
				IfcModel model = bimDatabaseSession.getMapWithObjectIdentifiers(concreteRevision.getProject().getId(), concreteRevision.getId(), oids);
				ifcModelSet.add(model);
				model.setDate(concreteRevision.getDate());
//				for (ObjectIdentifier objectIdentifier : oids) {
//					IfcModel subModel = bimDatabaseSession.getMapWithOid(concreteRevision.getProject().getId(), concreteRevision.getId(), objectIdentifier.getCid(), objectIdentifier.getOid());
//					subModel.setDate(concreteRevision.getDate());
//					ifcModels.add(subModel);
//				}
			}
		}
		IfcModel ifcModel = new Merger().merge(project, ifcModelSet, ServerSettings.getSettings().isIntelligentMerging());
		ifcModel.setRevisionNr(1);
		ifcModel.setAuthorizedUser(bimDatabaseSession.getUserByUoid(actingUoid).getName());
		ifcModel.setDate(new Date());
		return ifcModel;
	}
}