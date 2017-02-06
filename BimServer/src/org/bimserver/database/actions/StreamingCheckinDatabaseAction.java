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
import java.nio.ByteOrder;
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
import org.bimserver.database.OldQuery;
import org.bimserver.database.PostCommitAction;
import org.bimserver.database.queries.ConcreteRevisionStackFrame;
import org.bimserver.database.queries.QueryObjectProvider;
import org.bimserver.database.queries.QueryTypeStackFrame;
import org.bimserver.database.queries.om.Include;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.mail.MailSystem;
import org.bimserver.models.geometry.GeometryPackage;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.NewRevisionAdded;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.IfcHeader;
import org.bimserver.models.store.NewService;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.Service;
import org.bimserver.models.store.User;
import org.bimserver.notifications.NewRevisionNotification;
import org.bimserver.plugins.deserializers.ByteProgressReporter;
import org.bimserver.plugins.deserializers.StreamingDeserializer;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.QueryContext;
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
	private long newServiceId;

	public StreamingCheckinDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long poid, Authorization authorization, String comment, String fileName, InputStream inputStream, StreamingDeserializer deserializer, long fileSize, long newServiceId) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.poid = poid;
		this.authorization = authorization;
		this.comment = comment;
		this.fileName = fileName;
		this.inputStream = inputStream;
		this.deserializer = deserializer;
		this.fileSize = fileSize;
		this.newServiceId = newServiceId;
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
//				setProgress("Deserializing IFC file...", -1);
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
			
			PackageMetaData packageMetaData = bimServer.getMetaDataManager().getPackageMetaData(project.getSchema());

			// TODO checksum
			// TODO modelcheckers
			// TODO test ifc4

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
			
			if (fileSize != -1) {
				deserializer.setProgressReporter(new ByteProgressReporter() {
					@Override
					public void progress(long byteNumber) {
						int perc = (int)(100.0 * byteNumber / fileSize);
						setProgress("Deserializing...", perc);
					}
				});
			}
			
			// This will read the full stream of objects and write to the database directly
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
			ByteBuffer buffer = ByteBuffer.allocate(8 * s);
			buffer.order(ByteOrder.LITTLE_ENDIAN);
			for (EClass eClass : eClasses) {
				long oid = startOids.get(eClass);
				if (!DatabaseSession.perRecordVersioning(eClass)) {
					oidCounters.put(eClass, oid);
					buffer.putLong(oid);
				}
			}
			
			queryContext.setOidCounters(oidCounters);
			
			concreteRevision = result.getConcreteRevision();
			concreteRevision.setOidCounters(buffer.array());

			setProgress("Generating inverses/opposites...", -1);
			
			fixInverses(packageMetaData, newRoid);

			ProgressListener progressListener = new ProgressListener() {
				@Override
				public void updateProgress(String state, int percentage) {
					setProgress("Generating geometry...", percentage);
				}
			};
			StreamingGeometryGenerator geometryGenerator = new StreamingGeometryGenerator(bimServer, progressListener);
			setProgress("Generating geometry...", 0);

			GenerateGeometryResult generateGeometry = geometryGenerator.generateGeometry(getActingUid(), getDatabaseSession(), queryContext);
			
			for (Revision other : concreteRevision.getRevisions()) {
				other.setHasGeometry(true);
			}
			
			concreteRevision.setMinBounds(generateGeometry.getMinBoundsAsVector3f());
			concreteRevision.setMaxBounds(generateGeometry.getMaxBoundsAsVector3f());

			setProgress("Doing other stuff...", -1);
			
			eClasses = deserializer.getSummaryMap().keySet();
			s = 2;
			for (EClass eClass : eClasses) {
				if (!DatabaseSession.perRecordVersioning(eClass)) {
					s++;
				}
			}
			buffer = ByteBuffer.allocate(8 * s);
			buffer.order(ByteOrder.LITTLE_ENDIAN);
			for (EClass eClass : eClasses) {
				long oid = startOids.get(eClass);
				if (!DatabaseSession.perRecordVersioning(eClass)) {
					buffer.putLong(oid);
				}
			}
			buffer.putLong(startOids.get(GeometryPackage.eINSTANCE.getGeometryInfo()));
			buffer.putLong(startOids.get(GeometryPackage.eINSTANCE.getGeometryData()));
			
			concreteRevision = result.getConcreteRevision();
			concreteRevision.setOidCounters(buffer.array());
			
			// Clear the cache, we don't want it to cache incomplete oidcounters
			ConcreteRevisionStackFrame.clearCache(concreteRevision.getOid());
			
			result.getConcreteRevision().setSize(size);
			for (Revision revision : result.getRevisions()) {
				revision.setSize((revision.getSize() == null ? 0 : revision.getSize()) + concreteRevision.getSize());
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
			
			if (newServiceId != -1) {
				NewService newService = getDatabaseSession().get(newServiceId, OldQuery.getDefault());
				revision.getServicesLinked().add(newService);
			}

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
					bimServer.getNotificationsManager().notify(new NewRevisionNotification(bimServer, project.getOid(), revision.getOid(), authorization));
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
			throw new UserException(e);
		}
		return concreteRevision;
	}

	@SuppressWarnings("unchecked")
	private void fixInverses(PackageMetaData packageMetaData, long newRoid) throws QueryException, JsonParseException, JsonMappingException, IOException, BimserverDatabaseException {
		// TODO remove cache, this is essentially a big part of the model in memory again
		Map<Long, HashMapVirtualObject> cache = new HashMap<Long, HashMapVirtualObject>();
		Query query = new Query("test", packageMetaData);
		
		int nrTypes = 0;
		Set<EClass> uniqueTypes = new HashSet<>();
		for (EClass eClass : deserializer.getSummaryMap().keySet()) {
			if (packageMetaData.hasInverses(eClass)) {
				QueryPart queryPart = query.createQueryPart();
				queryPart.addType(eClass, true);
				uniqueTypes.add(eClass);
				nrTypes++;
				for (EReference eReference : packageMetaData.getAllHasInverseReferences(eClass)) {
					Include include = queryPart.createInclude();
					include.addType(eClass, true);
					include.addField(eReference.getName());
				}
			}
		}
		
		QueryObjectProvider queryObjectProvider = new QueryObjectProvider(getDatabaseSession(), bimServer, query, Collections.singleton(newRoid), packageMetaData);
		HashMapVirtualObject next = queryObjectProvider.next();
		EClass lastEClass = null;
		int currentType = 0;
		while (next != null) {
			if (next.eClass() != lastEClass && uniqueTypes.contains(next.eClass()) && queryObjectProvider.getStackFrame() instanceof QueryTypeStackFrame) {
				lastEClass = next.eClass();
				currentType++;
				setProgress("Generating inverses", (100 * currentType / nrTypes));
			}
			if (packageMetaData.hasInverses(next.eClass())) {
				for (EReference eReference : packageMetaData.getAllHasInverseReferences(next.eClass())) {
					Object reference = next.eGet(eReference);
					if (reference != null) {
						if (eReference.isMany()) {
							List<Long> references = (List<Long>)reference;
							for (Long refOid : references) {
								fixInverses(packageMetaData, newRoid, cache, next, eReference, refOid);
							}
						} else {
							fixInverses(packageMetaData, newRoid, cache, next, eReference, (Long)reference);
						}
					}
				}
			}
			next = queryObjectProvider.next();
		}
		
		setProgress("Storing data", -1);
		
		for (HashMapVirtualObject referencedObject : cache.values()) {
			referencedObject.saveOverwrite();
		}
	}

	private void fixInverses(PackageMetaData packageMetaData, long newRoid, Map<Long, HashMapVirtualObject> cache, HashMapVirtualObject next, EReference eReference, long refOid)
			throws JsonParseException, JsonMappingException, IOException, QueryException, BimserverDatabaseException {
		HashMapVirtualObject referencedObject = cache.get(refOid);
		if (referencedObject == null) {
			referencedObject = getByOid(packageMetaData, getDatabaseSession(), newRoid, refOid);
			if (referencedObject == null) {
				throw new BimserverDatabaseException("Referenced object with oid " + refOid + ", referenced from " + next.eClass().getName() + " not found");
			}
			cache.put(refOid, referencedObject);
		}
		EReference oppositeReference = packageMetaData.getInverseOrOpposite(referencedObject.eClass(), eReference);
		if (oppositeReference == null) {
			if (eReference.getName().equals("RelatedElements") && referencedObject.eClass().getName().equals("IfcSpace")) {
				// Ignore, IfcSpace should have  a field called RelatedElements, but it doesn't.
			} else {
//				LOGGER.error("No opposite " + eReference.getName() + " found");
			}
		} else {
			if (oppositeReference.isMany()) {
				Object existingList = referencedObject.eGet(oppositeReference);
				if (existingList != null) {
					int currentSize = ((List<?>)existingList).size();
					referencedObject.setListItemReference(oppositeReference, currentSize, next.eClass(), next.getOid(), 0);
				} else {
					referencedObject.setListItemReference(oppositeReference, 0, next.eClass(), next.getOid(), 0);
				}
			} else {
				referencedObject.setReference(oppositeReference, next.getOid(), 0);
			}
		}
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

	public void close() throws IOException {
		inputStream.close();
	}
}