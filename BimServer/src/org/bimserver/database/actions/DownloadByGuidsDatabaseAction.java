package org.bimserver.database.actions;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bimserver.SettingsManager;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.ObjectIdentifier;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelSet;
import org.bimserver.merging.Merger;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.User;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class DownloadByGuidsDatabaseAction extends BimDatabaseAction<IfcModel> {

	private final long actingUoid;
	private final Set<String> guids;
	private final Set<Long> roids;
	private final SettingsManager settingsManager;

	public DownloadByGuidsDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, SettingsManager settingsManager, Set<Long> roids, Set<String> guids, long actingUoid) {
		super(bimDatabaseSession, accessMethod);
		this.settingsManager = settingsManager;
		this.roids = roids;
		this.guids = guids;
		this.actingUoid = actingUoid;
	}

	@Override
	public IfcModel execute() throws UserException, BimDeadlockException, BimDatabaseException {
		User user = getUserByUoid(actingUoid);
		Set<String> foundGuids = new HashSet<String>();
		IfcModelSet ifcModelSet = new IfcModelSet();
		Project project = null;
		for (Long roid : roids) {
			Revision virtualRevision = getVirtualRevision(roid);
			project = virtualRevision.getProject();
			if (!RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
				throw new UserException("User has insufficient rights to download revisions from this project");
			}
			Map<ConcreteRevision, Set<Long>> map = new HashMap<ConcreteRevision, Set<Long>>();
			for (String guid : guids) {
				if (!foundGuids.contains(guid)) {
					for (ConcreteRevision concreteRevision : virtualRevision.getConcreteRevisions()) {
						ObjectIdentifier objectIdentifier = getDatabaseSession().getOidOfGuid(guid, concreteRevision.getProject().getId(), concreteRevision.getId());
						if (objectIdentifier != null) {
							foundGuids.add(guid);
							if (!map.containsKey(concreteRevision)) {
								map.put(concreteRevision, new HashSet<Long>());
							}
							map.get(concreteRevision).add(objectIdentifier.getOid());
						}
					}
				}
			}
			for (ConcreteRevision concreteRevision : map.keySet()) {
				Set<Long> oids = map.get(concreteRevision);
				IfcModel model = getDatabaseSession().getMapWithOids(concreteRevision.getProject().getId(), concreteRevision.getId(), oids, true);
				model.setDate(concreteRevision.getDate());
				ifcModelSet.add(model);
			}
		}
		IfcModel ifcModel = new Merger().merge(project, ifcModelSet, settingsManager.getSettings().isIntelligentMerging());
		for (String guid : guids) {
			if (!foundGuids.contains(guid)) {
				throw new UserException("Guid " + guid + " not found");
			}
		}
		ifcModel.setRevisionNr(1);
		ifcModel.setAuthorizedUser(getUserByUoid(actingUoid).getName());
		ifcModel.setDate(new Date());
		return ifcModel;
	}
}