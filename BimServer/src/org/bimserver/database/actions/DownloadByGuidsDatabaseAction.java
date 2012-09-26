package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.ObjectIdentifier;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelChangeListener;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.User;
import org.bimserver.plugins.IfcModelSet;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.Reporter;
import org.bimserver.plugins.modelmerger.MergeException;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.Authorization;

public class DownloadByGuidsDatabaseAction extends BimDatabaseAction<IfcModelInterface> {

	private final Set<String> guids;
	private final Set<Long> roids;
	private int progress;
	private final BimServer bimServer;
	private final ObjectIDM objectIDM;
	private Authorization authorization;

	public DownloadByGuidsDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, Set<Long> roids, Set<String> guids, Authorization authorization, ObjectIDM objectIDM, Reporter reporter) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.roids = roids;
		this.guids = guids;
		this.authorization = authorization;
		this.objectIDM = objectIDM;
	}

	@Override
	public IfcModelInterface execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		User user = getUserByUoid(authorization.getUoid());
		Set<String> foundGuids = new HashSet<String>();
		IfcModelSet ifcModelSet = new IfcModelSet();
		Project project = null;
		long incrSize = 0L;
		for (Long roid : roids) {
			Revision virtualRevision = getVirtualRevision(roid);
			project = virtualRevision.getProject();
			if (!authorization.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
				throw new UserException("User has insufficient rights to download revisions from this project");
			}
			Map<ConcreteRevision, Set<Long>> map = new HashMap<ConcreteRevision, Set<Long>>();
			for (String guid : guids) {
				if (!foundGuids.contains(guid)) {
					for (ConcreteRevision concreteRevision : virtualRevision.getConcreteRevisions()) {
						ObjectIdentifier objectIdentifier = getDatabaseSession().getOidOfGuid(guid, concreteRevision.getProject().getId(),
								concreteRevision.getId());
						if (objectIdentifier != null) {
							foundGuids.add(guid);
							if (!map.containsKey(concreteRevision)) {
								map.put(concreteRevision, new HashSet<Long>());
								incrSize += concreteRevision.getSize();
							}
							map.get(concreteRevision).add(objectIdentifier.getOid());
						}
					}
				}
			}
			final long totalSize = incrSize;
			final AtomicLong total = new AtomicLong();

			for (ConcreteRevision concreteRevision : map.keySet()) {
				IfcModel subModel = new IfcModel();
				subModel.addChangeListener(new IfcModelChangeListener() {
					@Override
					public void objectAdded() {
						total.incrementAndGet();
						progress = Math.round(100L * total.get() / totalSize);
					}
				});
				Set<Long> oids = map.get(concreteRevision);
				getDatabaseSession().getMapWithOids(subModel, concreteRevision.getProject().getId(), concreteRevision.getId(), oids, true, objectIDM);
				subModel.setDate(concreteRevision.getDate());
				ifcModelSet.add(subModel);
			}
		}
		IfcModelInterface ifcModel;
		try {
			ifcModel = bimServer.getMergerFactory().createMerger(getDatabaseSession(), authorization.getUoid()).merge(project, ifcModelSet, new ModelHelper());
			ifcModel.setName("query");
			for (String guid : guids) {
				if (!foundGuids.contains(guid)) {
					throw new UserException("Guid " + guid + " not found");
				}
			}
			ifcModel.setRevisionNr(1);
			ifcModel.setAuthorizedUser(getUserByUoid(authorization.getUoid()).getName());
			ifcModel.setDate(new Date());
			return ifcModel;
		} catch (MergeException e) {
			throw new UserException(e);
		}
	}

	public int getProgress() {
		return progress;
	}

}