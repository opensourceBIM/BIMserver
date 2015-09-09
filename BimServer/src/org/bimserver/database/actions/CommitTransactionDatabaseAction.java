package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
import java.util.Map;

import org.bimserver.BimServer;
import org.bimserver.GeometryCache;
import org.bimserver.GeometryGeneratingException;
import org.bimserver.GeometryGenerator;
import org.bimserver.SummaryMap;
import org.bimserver.changes.Change;
import org.bimserver.changes.CreateObjectChange;
import org.bimserver.changes.RemoveObjectChange;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.PostCommitAction;
import org.bimserver.database.Query;
import org.bimserver.database.Query.Deep;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.ifc.BasicIfcModel;
import org.bimserver.interfaces.SConverter;
import org.bimserver.mail.MailSystem;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.NewRevisionAdded;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.LongTransaction;
import org.bimserver.webservices.NoTransactionException;
import org.bimserver.webservices.authorization.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommitTransactionDatabaseAction extends GenericCheckinDatabaseAction {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommitTransactionDatabaseAction.class);
	private final String comment;
	private final LongTransaction longTransaction;
	private Revision revision;
	private Authorization authorization;
	private BimServer bimServer;
	private final GeometryCache geometryCache = new GeometryCache();

	public CommitTransactionDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, Authorization authorization, LongTransaction longTransaction, String comment) {
		super(databaseSession, accessMethod, null);
		this.bimServer = bimServer;
		this.authorization = authorization;
		this.longTransaction = longTransaction;
		this.comment = comment;
	}

	@Override
	public ConcreteRevision execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Project project = getProjectByPoid(longTransaction.getPoid());
		User user = getUserByUoid(authorization.getUoid());
		if (project == null) {
			throw new UserException("Project with poid " + longTransaction.getPoid() + " not found");
		}
		if (!authorization.hasRightsOnProjectOrSuperProjects(user, project)) {
			throw new UserException("User has no rights to checkin models to this project");
		}
		if (!MailSystem.isValidEmailAddress(user.getUsername())) {
			throw new UserException("Users must have a valid e-mail address to checkin");
		}
		long size = 0;
		if (project.getLastRevision() != null) {
			for (ConcreteRevision concreteRevision : project.getLastRevision().getConcreteRevisions()) {
				size += concreteRevision.getSize();
			}
		}
		for (Change change : longTransaction.getChanges()) {
			if (change instanceof CreateObjectChange) {
				size++;
			} else if (change instanceof RemoveObjectChange) {
				size--;
			}
		}
		
		Revision oldLastRevision = project.getLastRevision();
		CreateRevisionResult result = createNewConcreteRevision(getDatabaseSession(), size, project, user, comment.trim());
		ConcreteRevision concreteRevision = result.getConcreteRevision();
		revision = concreteRevision.getRevisions().get(0);
		project.setLastRevision(revision);
		final NewRevisionAdded newRevisionAdded = getDatabaseSession().create(NewRevisionAdded.class);
		newRevisionAdded.setDate(new Date());
		newRevisionAdded.setExecutor(user);
		newRevisionAdded.setRevision(concreteRevision.getRevisions().get(0));
		newRevisionAdded.setProject(project);
		newRevisionAdded.setAccessMethod(getAccessMethod());
		
		PackageMetaData packageMetaData = bimServer.getMetaDataManager().getPackageMetaData(project.getSchema());
		IfcModelInterface ifcModel = new BasicIfcModel(packageMetaData, null);
		if (oldLastRevision != null) {
			int highestStopId = AbstractDownloadDatabaseAction.findHighestStopRid(project, oldLastRevision.getLastConcreteRevision());
			Query query = new Query(longTransaction.getPackageMetaData(), project.getId(), oldLastRevision.getId(), -1, null, Deep.YES, highestStopId);
			query.updateOidCounters(oldLastRevision.getLastConcreteRevision(), getDatabaseSession());
			getDatabaseSession().getMap(ifcModel, query);
		}
		
		getDatabaseSession().addPostCommitAction(new PostCommitAction() {
			@Override
			public void execute() throws UserException {
				bimServer.getNotificationsManager().notify(new SConverter().convertToSObject(newRevisionAdded));
				try {
					bimServer.getLongTransactionManager().remove(longTransaction.getTid());
				} catch (NoTransactionException e) {
					LOGGER.error("", e);
				}
			}
		});

		SummaryMap summaryMap = null;
		if (oldLastRevision != null && oldLastRevision.getConcreteRevisions().size() == 1 && oldLastRevision.getConcreteRevisions().get(0).getSummary() != null) {
			summaryMap = new SummaryMap(packageMetaData, oldLastRevision.getConcreteRevisions().get(0).getSummary());
		} else {
			summaryMap = new SummaryMap(packageMetaData);
		}

		boolean geometryChanged = true;
		// TODO actually change this variable...
		
		// First create all new objects
		Map<Long, IdEObject> created = new HashMap<Long, IdEObject>();
		Map<Long, IdEObject> deleted = new HashMap<Long, IdEObject>();
		for (Change change : longTransaction.getChanges()) {
			if (change instanceof CreateObjectChange) {
				change.execute(ifcModel, project, concreteRevision, getDatabaseSession(), created, deleted);
				summaryMap.add(((CreateObjectChange)change).geteClass(), 1);
			}
		}
		// Then do the rest
		for (Change change : longTransaction.getChanges()) {
			if (!(change instanceof CreateObjectChange)) {
				if (change instanceof RemoveObjectChange) {
					summaryMap.remove(((RemoveObjectChange)change).geteClass(), 1);
				}
				change.execute(ifcModel, project, concreteRevision, getDatabaseSession(), created, deleted);
			}
		}

		ifcModel.fixInverseMismatches();

		if (bimServer.getServerSettingsCache().getServerSettings().isGenerateGeometryOnCheckin() && geometryChanged) {
			setProgress("Generating Geometry...", -1);
			try {
				new GeometryGenerator(bimServer).generateGeometry(authorization.getUoid(), bimServer.getPluginManager(), getDatabaseSession(), ifcModel, project.getId(), concreteRevision.getId(), true, geometryCache);
			} catch (GeometryGeneratingException e) {
				throw new UserException(e);
			}
			revision.setHasGeometry(true);
		}

		if (oldLastRevision != null) {
			concreteRevision.setOidCounters(oldLastRevision.getConcreteRevisions().get(0).getOidCounters());
		}
		concreteRevision.setSummary(summaryMap.toRevisionSummary(getDatabaseSession()));

		getDatabaseSession().store(concreteRevision);
		getDatabaseSession().store(project);
		return concreteRevision;
	}

	public Revision getRevision() {
		return revision;
	}
}
