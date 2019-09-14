package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.GenerateGeometryResult;
import org.bimserver.GeometryGeneratingException;
import org.bimserver.SummaryMap;
import org.bimserver.changes.Change;
import org.bimserver.changes.CreateObjectChange;
import org.bimserver.changes.RemoveObjectChange;
import org.bimserver.changes.Transaction;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OidCounters;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OldQuery.Deep;
import org.bimserver.database.PostCommitAction;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.geometry.GeometryGenerationReport;
import org.bimserver.geometry.StreamingGeometryGenerator;
import org.bimserver.interfaces.SConverter;
import org.bimserver.mail.MailSystem;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.NewRevisionAdded;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.User;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.QueryContext;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.LongTransaction;
import org.bimserver.webservices.NoTransactionException;
import org.bimserver.webservices.authorization.Authorization;
import org.eclipse.emf.ecore.EClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommitTransactionDatabaseAction extends GenericCheckinDatabaseAction {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommitTransactionDatabaseAction.class);
	private final String comment;
	private final LongTransaction longTransaction;
	private Revision revision;
	private Authorization authorization;

	public CommitTransactionDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, Authorization authorization, LongTransaction longTransaction, String comment) {
		super(bimServer, databaseSession, accessMethod);
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
		Revision previousRevision = project.getLastRevision();
		if (project.getLastRevision() != null) {
			size += project.getLastRevision().getSize();
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
		
		OidCounters originalOidCounters = null;
		PackageMetaData packageMetaData = getBimServer().getMetaDataManager().getPackageMetaData(project.getSchema());
		if (oldLastRevision != null) {
			int highestStopId = AbstractDownloadDatabaseAction.findHighestStopRid(project, oldLastRevision.getLastConcreteRevision());
			OldQuery query = new OldQuery(longTransaction.getPackageMetaData(), project.getId(), oldLastRevision.getId(), -1, Deep.YES, highestStopId);
			originalOidCounters = query.updateOidCounters(oldLastRevision.getLastConcreteRevision(), getDatabaseSession());
		}
		
		getDatabaseSession().addPostCommitAction(new PostCommitAction() {
			@Override
			public void execute() throws UserException {
				getBimServer().getNotificationsManager().notify(new SConverter().convertToSObject(newRevisionAdded));
				try {
					getBimServer().getLongTransactionManager().remove(longTransaction.getTid());
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
		
		Transaction transaction = new Transaction(getBimServer(), previousRevision, project, concreteRevision, getDatabaseSession());
		
		for (Change change : longTransaction.getChanges()) {
			if (change instanceof CreateObjectChange) {
				try {
					CreateObjectChange createObjectChange = (CreateObjectChange)change;
					change.execute(transaction);
					getDatabaseSession().addStartOid(createObjectChange.geteClass(), createObjectChange.getOid());
				} catch (IOException | QueryException e) {
					e.printStackTrace();
				}
				summaryMap.add(((CreateObjectChange)change).geteClass(), 1);
			}
		}
		// Then do the rest
		for (Change change : longTransaction.getChanges()) {
			if (!(change instanceof CreateObjectChange)) {
				if (change instanceof RemoveObjectChange) {
					summaryMap.remove(((RemoveObjectChange)change).geteClass(), 1);
				}
				try {
					change.execute(transaction);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (QueryException e) {
					e.printStackTrace();
				}
			}
		}

		for (HashMapVirtualObject object : transaction.getCreated()) {
			getDatabaseSession().save(object);
		}
		for (HashMapVirtualObject object : transaction.getUpdated()) {
			getDatabaseSession().save(object, concreteRevision.getId());
		}
		for (HashMapVirtualObject object : transaction.getDeleted()) {
			getDatabaseSession().delete(object, concreteRevision.getId());
		}
		
		setProgress("Generating inverses/opposites...", -1);
		Revision newRevision = result.getRevisions().get(0);
		long newRoid = newRevision.getOid();
		try {
			fixInverses(packageMetaData, newRoid, summaryMap.getSummaryMap());
		} catch (QueryException | IOException e1) {
			e1.printStackTrace();
		}

		if (getBimServer().getServerSettingsCache().getServerSettings().isGenerateGeometryOnCheckin() && geometryChanged) {
			setProgress("Generating Geometry...", -1);
			try {
				GeometryGenerationReport report = new GeometryGenerationReport();

				report.setOriginalDeserializer("No deserializer, low level call");
				report.setOriginalIfcFileName("No file, low level call");
				report.setOriginalIfcFileSize(-1);
				
				StreamingGeometryGenerator streamingGeometryGenerator = new StreamingGeometryGenerator(getBimServer(), null, -1L, report);
				int highestStopId = AbstractDownloadDatabaseAction.findHighestStopRid(concreteRevision.getProject(), concreteRevision);

				QueryContext queryContext = new QueryContext(getDatabaseSession(), packageMetaData, project.getId(), concreteRevision.getId(), concreteRevision.getRevisions().get(0).getOid(), concreteRevision.getOid(), highestStopId);

				Map<String, Long> startOids = getDatabaseSession().getStartOids();
				if (startOids == null) {
					throw new BimserverDatabaseException("No objects changed");
				}
				
				for (EClass eClass : packageMetaData.getEClasses()) {
					if (startOids.containsKey(eClass.getName())) {
						long oid = startOids.get(eClass.getName());
						if (!DatabaseSession.perRecordVersioning(eClass)) {
							originalOidCounters.putIfAbsent(eClass, oid);
						}
					}
				}

				queryContext.setOidCounters(originalOidCounters);
				concreteRevision.setOidCounters(originalOidCounters.getBytes());

				GenerateGeometryResult generateGeometry = streamingGeometryGenerator.generateGeometry(authorization.getUoid(), getDatabaseSession(), queryContext, summaryMap.count());
				
				concreteRevision.setMultiplierToMm(generateGeometry.getMultiplierToMm());
				concreteRevision.setBounds(generateGeometry.getBounds());
				concreteRevision.setBoundsUntransformed(generateGeometry.getBoundsUntransformed());
				
				generateDensityAndBounds(result, generateGeometry, concreteRevision);
			} catch (GeometryGeneratingException e) {
				throw new UserException(e);
			}
			revision.setHasGeometry(true);
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
