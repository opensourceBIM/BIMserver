package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
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
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.GenerateGeometryResult;
import org.bimserver.StreamingGeometryGenerator;
import org.bimserver.SummaryMap;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.PostCommitAction;
import org.bimserver.database.queries.QueryObjectProvider;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.mail.MailSystem;
import org.bimserver.models.geometry.GeometryPackage;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.NewRevisionAdded;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.IfcHeader;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.Service;
import org.bimserver.models.store.User;
import org.bimserver.notifications.NewRevisionNotification;
import org.bimserver.plugins.deserializers.StreamingDeserializer;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.QueryContext;
import org.bimserver.shared.QueryException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;
import org.bimserver.webservices.authorization.ExplicitRightsAuthorization;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class StreamingCheckinDatabaseAction extends GenericCheckinDatabaseAction {

	private static final Logger LOGGER = LoggerFactory.getLogger(StreamingCheckinDatabaseAction.class);
	private final String comment;
	private final long poid;
	private final BimServer bimServer;
	private ConcreteRevision concreteRevision;
	private Project project;
	private Authorization authorization;
	private String fileName;
	private long fileSize;
	private InputStream inputStream;
	private StreamingDeserializer deserializer;

	public StreamingCheckinDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long poid, Authorization authorization, String comment, String fileName, InputStream inputStream, StreamingDeserializer deserializer) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.poid = poid;
		this.authorization = authorization;
		this.comment = comment;
		this.fileName = fileName;
		this.inputStream = inputStream;
		this.deserializer = deserializer;
	}

	public HashMapVirtualObject getByOid(PackageMetaData packageMetaData, DatabaseSession databaseSession, long roid, long oid) throws JsonParseException, JsonMappingException, IOException, QueryException, BimserverDatabaseException {
		Query query = new Query("test", packageMetaData);
		QueryPart queryPart = query.createQueryPart();
		queryPart.addOid(oid);
		QueryObjectProvider queryObjectProvider = new QueryObjectProvider(databaseSession, bimServer, query, Collections.singleton(roid), packageMetaData);
		HashMapVirtualObject first = queryObjectProvider.next();
		return first;
	}
	
	@Override
	public ConcreteRevision execute() throws UserException, BimserverDatabaseException {
		try {
			if (fileSize == -1) {
				setProgress("Deserializing IFC file...", -1);
			} else {
				setProgress("Deserializing IFC file...", 0);
			}
			authorization.canCheckin(poid);
			project = getProjectByPoid(poid);
			int nrConcreteRevisionsBefore = project.getConcreteRevisions().size();
			User user = getUserByUoid(authorization.getUoid());
			if (project == null) {
				throw new UserException("Project with poid " + poid + " not found");
			}
			if (!authorization.hasRightsOnProjectOrSuperProjects(user, project)) {
				throw new UserException("User has no rights to checkin models to this project");
			}
			if (!MailSystem.isValidEmailAddress(user.getUsername())) {
				throw new UserException("Users must have a valid e-mail address to checkin");
			}
//			if (getModel() != null) {
//				checkCheckSum(project);
//			}
			
			PackageMetaData packageMetaData = bimServer.getMetaDataManager().getPackageMetaData("ifc2x3tc1");

			// TODO checksum
			// TODO generate geometry
			// TODO modelcheckers
			// TODO test ifc4
			// TODO store right size

//			long size = 0;
//			if (getModel() != null) {
//				for (IdEObject idEObject : getModel().getValues()) {
//					if (idEObject.eClass().getEAnnotation("hidden") == null) {
//						size++;
//					}
//				}
//				getModel().fixInverseMismatches();
//			}
			
//			for (ModelCheckerInstance modelCheckerInstance : project.getModelCheckers()) {
//				if (modelCheckerInstance.isValid()) {
//					ModelCheckerPlugin modelCheckerPlugin = bimServer.getPluginManager().getModelCheckerPlugin(modelCheckerInstance.getModelCheckerPluginClassName(), true);
//					if (modelCheckerPlugin != null) {
//						ModelChecker modelChecker = modelCheckerPlugin.createModelChecker(null);
//						ModelCheckerResult result = modelChecker.check(getModel(), modelCheckerInstance.getCompiled());
//						if (!result.isValid()) {
//							throw new UserException("Model is not valid according to " + modelCheckerInstance.getName());
//						}
//					}
//				}
//			}
			
			CreateRevisionResult result = createNewConcreteRevision(getDatabaseSession(), -1, project, user, comment.trim());

			long newRoid = result.getRevisions().get(0).getOid();
			QueryContext queryContext = new QueryContext(getDatabaseSession(), packageMetaData, result.getConcreteRevision().getProject().getId(), result.getConcreteRevision().getId(), newRoid, -1); // TODO check
			long size = deserializer.read(inputStream, fileName, fileSize, queryContext);

			Set<EClass> eClasses = deserializer.getSummaryMap().keySet();
			Map<EClass, Long> startOids = getDatabaseSession().getStartOids();
			Map<EClass, Long> oidCounters = new HashMap<>();
			int s = 0;
			for (EClass eClass : eClasses) {
				if (!DatabaseSession.perRecordVersioning(eClass)) {
					s++;
				}
			}
			ByteBuffer buffer = ByteBuffer.allocate(10 * s);
			for (EClass eClass : eClasses) {
				long oid = startOids.get(eClass);
				if (!DatabaseSession.perRecordVersioning(eClass)) {
					oidCounters.put(eClass, oid);
					buffer.putShort(getDatabaseSession().getCid(eClass));
					buffer.putLong(oid);
				}
			}
			
			queryContext.setOidCounters(oidCounters);
			
			concreteRevision = result.getConcreteRevision();
			concreteRevision.setOidCounters(buffer.array());

			setProgress("Generating inverses/opposites", 0);
			int inverseFixes = 0;
			
			int c = 0;
			int writes = 0;
			Set<Long> unq = new HashSet<>();
			for (EClass eClass : deserializer.getSummaryMap().keySet()) {
				if (packageMetaData.hasInverses(eClass)) {
					Query query = new Query("test", packageMetaData);
					QueryPart queryPart = query.createQueryPart();
					queryPart.addType(eClass, true);
					QueryObjectProvider queryObjectProvider = new QueryObjectProvider(getDatabaseSession(), bimServer, query, Collections.singleton(newRoid), packageMetaData);
					HashMapVirtualObject next = queryObjectProvider.next();
					while (next != null) {
						for (EReference eReference : packageMetaData.getAllHasInverseReferences(eClass)) {
							Object reference = next.eGet(eReference);
							if (reference != null) {
								if (eReference.isMany()) {
									List<Long> references = (List<Long>)reference;
									for (Long refOid : references) {
										HashMapVirtualObject referencedObject = getByOid(packageMetaData, getDatabaseSession(), newRoid, refOid);
										EReference oppositeReference = packageMetaData.getInverseOrOpposite(referencedObject.eClass(), eReference);
										if (oppositeReference.isMany()) {
											Object existingList = referencedObject.eGet(oppositeReference);
											if (existingList != null) {
												int currentSize = ((List<?>)existingList).size();
												referencedObject.setListItemReference(oppositeReference, currentSize + 1, next.eClass(), next.getOid(), 0);
												inverseFixes++;
											} else {
												referencedObject.setListItemReference(oppositeReference, 0, next.eClass(), next.getOid(), 0);
												inverseFixes++;
											}
										} else {
											referencedObject.setReference(oppositeReference, next.getOid(), 0);
											inverseFixes++;
										}
										referencedObject.saveOverwrite();
										unq.add(referencedObject.getOid());
										writes++;
									}
								} else {
									Long refOid = (Long)reference;
									HashMapVirtualObject referencedObject = getByOid(packageMetaData, getDatabaseSession(), newRoid, refOid);
									EReference oppositeReference = packageMetaData.getInverseOrOpposite(referencedObject.eClass(), eReference);
									if (oppositeReference.isMany()) {
										Object existingList = referencedObject.eGet(oppositeReference);
										if (existingList != null) {
											int currentSize = ((List<?>)existingList).size();
											referencedObject.setListItemReference(oppositeReference, currentSize + 1, next.eClass(), next.getOid(), 0);
											inverseFixes++;
										} else {
											referencedObject.setListItemReference(oppositeReference, 0, next.eClass(), next.getOid(), 0);
											inverseFixes++;
										}
									} else {
										referencedObject.setReference(oppositeReference, next.getOid(), 0);
										unq.add(referencedObject.getOid());
										inverseFixes++;
									}
									referencedObject.saveOverwrite();
									writes++;
								}
							}
						}
						next = queryObjectProvider.next();
					}
					setProgress("Generating inverses/opposites", (int) (100.0 * c / deserializer.getSummaryMap().keySet().size()));
					c++;
				}
			}
			LOGGER.info("Inverse/opposite fixes: " + inverseFixes + ", writes: " + writes + ", unq: " + unq.size());

			ProgressListener progressListener = new ProgressListener() {
				@Override
				public void updateProgress(String state, int percentage) {
					setProgress("Generating geometry", percentage);
				}
			};
			StreamingGeometryGenerator geometryGenerator = new StreamingGeometryGenerator(bimServer, progressListener);
			setProgress("Generating geometry", 0);

			GenerateGeometryResult generateGeometry = geometryGenerator.generateGeometry(getActingUid(), getDatabaseSession(), queryContext);
			
			concreteRevision.setMinBounds(generateGeometry.getMinBounds());
			concreteRevision.setMaxBounds(generateGeometry.getMaxBounds());

			setProgress("Doing other stuff...", -1);
			
			eClasses = deserializer.getSummaryMap().keySet();
			s = 2;
			for (EClass eClass : eClasses) {
				if (!DatabaseSession.perRecordVersioning(eClass)) {
					s++;
				}
			}
			buffer = ByteBuffer.allocate(10 * s);
			for (EClass eClass : eClasses) {
				long oid = startOids.get(eClass);
				if (!DatabaseSession.perRecordVersioning(eClass)) {
					buffer.putShort(getDatabaseSession().getCid(eClass));
					buffer.putLong(oid);
				}
			}
			buffer.putShort(getDatabaseSession().getCid(GeometryPackage.eINSTANCE.getGeometryInfo()));
			buffer.putLong(startOids.get(GeometryPackage.eINSTANCE.getGeometryInfo()));
			buffer.putShort(getDatabaseSession().getCid(GeometryPackage.eINSTANCE.getGeometryData()));
			buffer.putLong(startOids.get(GeometryPackage.eINSTANCE.getGeometryData()));
			
			concreteRevision = result.getConcreteRevision();
			concreteRevision.setOidCounters(buffer.array());
			
			result.getConcreteRevision().setSize(size);
			for (Revision revision : result.getRevisions()) {
				revision.setSize(size);
			}
			
			IfcHeader ifcHeader = deserializer.getIfcHeader();
			if (ifcHeader != null) {
				getDatabaseSession().store(ifcHeader);
				concreteRevision.setIfcHeader(ifcHeader);
			}
			project.getConcreteRevisions().add(concreteRevision);
//			if (getModel() != null) {
//				concreteRevision.setChecksum(getModel().getModelMetaData().getChecksum());
//			}
			final NewRevisionAdded newRevisionAdded = getDatabaseSession().create(NewRevisionAdded.class);
			newRevisionAdded.setDate(new Date());
			newRevisionAdded.setExecutor(user);
			final Revision revision = concreteRevision.getRevisions().get(0);

			concreteRevision.setSummary(new SummaryMap(packageMetaData, deserializer.getSummaryMap()).toRevisionSummary(getDatabaseSession()));

			// If this revision is being created by an external service, store a link to the service in the revision
			if (authorization instanceof ExplicitRightsAuthorization) {
				ExplicitRightsAuthorization explicitRightsAuthorization = (ExplicitRightsAuthorization)authorization;
				if (explicitRightsAuthorization.getSoid() != -1) {
					Service service = getDatabaseSession().get(explicitRightsAuthorization.getSoid(), org.bimserver.database.OldQuery.getDefault());
					revision.setService(service);
				}
			}
			
			newRevisionAdded.setRevision(revision);
			newRevisionAdded.setProject(project);
			newRevisionAdded.setAccessMethod(getAccessMethod());

//			Revision lastRevision = project.getLastRevision();
//			IfcModelInterface ifcModel = null;
//			if (merge && lastRevision != null) {
//				ifcModel = checkinMerge(lastRevision);
//			} else {
//				ifcModel = getModel();
//			}

//			ifcModel.fixOidsFlat(getDatabaseSession());

//			if (bimServer.getServerSettingsCache().getServerSettings().isGenerateGeometryOnCheckin()) {
//				setProgress("Generating Geometry...", -1);
//				new GeometryGenerator(bimServer).generateGeometry(authorization.getUoid(), bimServer.getPluginManager(), getDatabaseSession(), ifcModel, project.getId(), concreteRevision.getId(), true, geometryCache);
//				for (Revision other : concreteRevision.getRevisions()) {
//					other.setHasGeometry(true);
//				}
//			}

			if (nrConcreteRevisionsBefore != 0) {
				// There already was a revision, lets delete it (only when not merging)
				concreteRevision.setClear(true);
			}

			getDatabaseSession().addPostCommitAction(new PostCommitAction() {
				@Override
				public void execute() throws UserException {
					bimServer.getNotificationsManager().notify(new NewRevisionNotification(bimServer, project.getOid(), revision.getOid()));
				}
			});

			getDatabaseSession().store(concreteRevision);
			getDatabaseSession().store(project);
		} catch (Throwable e) {
			if (e instanceof BimserverDatabaseException) {
				throw (BimserverDatabaseException) e;
			}
			if (e instanceof UserException) {
				throw (UserException) e;
			}
			LOGGER.error("", e);
			throw new UserException(e);
		}
		return concreteRevision;
	}

	public String getFileName() {
		return fileName;
	}
	
	public ConcreteRevision getConcreteRevision() {
		return concreteRevision;
	}

	public Revision getRevision() {
		return concreteRevision.getRevisions().get(0);
	}

	public long getCroid() {
		return concreteRevision.getOid();
	}

	public long getActingUid() {
		return authorization.getUoid();
	}

	public long getPoid() {
		return poid;
	}
}