package org.bimserver.database.actions;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.GeometryCache;
import org.bimserver.SummaryMap;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.PostCommitAction;
import org.bimserver.database.Query;
import org.bimserver.database.queries.QueryException;
import org.bimserver.database.queries.QueryObjectProvider;
import org.bimserver.database.queries.om.Namespace;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.mail.MailSystem;
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
import org.bimserver.shared.Reusable;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;
import org.bimserver.webservices.authorization.ExplicitRightsAuthorization;
import org.eclipse.emf.ecore.EClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class StreamingCheckinDatabaseAction extends GenericCheckinDatabaseAction {

	private static final Logger LOGGER = LoggerFactory.getLogger(StreamingCheckinDatabaseAction.class);
	private final String comment;
	private final long poid;
	private final boolean merge;
	private final BimServer bimServer;
	private ConcreteRevision concreteRevision;
	private Project project;
	private Authorization authorization;
	private final GeometryCache geometryCache = new GeometryCache();
	private String fileName;
	private long fileSize;
	private InputStream inputStream;
	private StreamingDeserializer deserializer;

	public StreamingCheckinDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long poid, Authorization authorization, String comment, String fileName, boolean merge, InputStream inputStream, StreamingDeserializer deserializer) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.poid = poid;
		this.authorization = authorization;
		this.comment = comment;
		this.fileName = fileName;
		this.merge = merge;
		this.inputStream = inputStream;
		this.deserializer = deserializer;
	}

	public HashMapVirtualObject getByOid(PackageMetaData packageMetaData, DatabaseSession databaseSession, long roid, long oid) throws JsonParseException, JsonMappingException, IOException, QueryException, BimserverDatabaseException {
		Namespace query = new Namespace("test");
		QueryPart queryPart = query.createQueryPart(packageMetaData);
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

			// TODO fix inverse mismatches
			// TODO checksum
			// TODO generate geometry
			// TODO opposites
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
			Reusable reusable = new Reusable(getDatabaseSession(), packageMetaData, result.getConcreteRevision().getProject().getId(), result.getConcreteRevision().getId(), newRoid); // TODO check
			long size = deserializer.read(inputStream, fileName, fileSize, reusable);

			Set<EClass> eClasses = deserializer.getSummaryMap().keySet();
			Map<EClass, Long> startOids = getDatabaseSession().getStartOids();
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
					buffer.putShort(getDatabaseSession().getCid(eClass));
					buffer.putLong(oid);
				}
			}
			
			concreteRevision = result.getConcreteRevision();
			concreteRevision.setOidCounters(buffer.array());

//			for (EClass eClass : packageMetaData.getAllEClassesThatHaveInverses()) {
//				Namespace query = new Namespace("test");
//				QueryPart queryPart = query.createQueryPart(packageMetaData);
//				queryPart.addType(eClass, true);
//				QueryObjectProvider queryObjectProvider = new QueryObjectProvider(getDatabaseSession(), bimServer, query, Collections.singleton(newRoid), packageMetaData);
//				HashMapVirtualObject next = queryObjectProvider.next();
//				while (next != null) {
//					for (EReference eReference : packageMetaData.getAllHasInverseReferences(eClass)) {
//						Object reference = next.eGet(eReference);
//						if (reference != null) {
//							if (eReference.isMany()) {
//								List<Long> references = (List<Long>)reference;
//								for (Long refOid : references) {
//									HashMapVirtualObject referencedObject = getByOid(packageMetaData, getDatabaseSession(), newRoid, refOid);
//									EReference oppositeReference = packageMetaData.getInverseOrOpposite(referencedObject.eClass(), eReference);
//									if (oppositeReference.isMany()) {
//										Object existingList = referencedObject.eGet(oppositeReference);
//										if (existingList != null) {
//											int currentSize = ((List<?>)existingList).size();
//											referencedObject.setListItemReference(oppositeReference, currentSize + 1, next.eClass(), next.getOid(), 0);
//										} else {
//											referencedObject.setListItemReference(oppositeReference, 0, next.eClass(), next.getOid(), 0);
//										}
//									} else {
//										referencedObject.setReference(oppositeReference, next.getOid(), 0);
//									}
//									referencedObject.saveOverwrite();
//								}
//							} else {
//								Long refOid = (Long)reference;
//								HashMapVirtualObject referencedObject = getByOid(packageMetaData, getDatabaseSession(), newRoid, refOid);
//								EReference oppositeReference = packageMetaData.getInverseOrOpposite(referencedObject.eClass(), eReference);
//								if (oppositeReference.isMany()) {
//									Object existingList = referencedObject.eGet(oppositeReference);
//									if (existingList != null) {
//										int currentSize = ((List<?>)existingList).size();
//										referencedObject.setListItemReference(oppositeReference, currentSize + 1, next.eClass(), next.getOid(), 0);
//									} else {
//										referencedObject.setListItemReference(oppositeReference, 0, next.eClass(), next.getOid(), 0);
//									}
//								} else {
//									referencedObject.setReference(oppositeReference, next.getOid(), 0);
//								}
//								referencedObject.saveOverwrite();
//							}
//						}
//					}
//					next = queryObjectProvider.next();
//				}
//			}
			
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
					Service service = getDatabaseSession().get(explicitRightsAuthorization.getSoid(), Query.getDefault());
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

			if (nrConcreteRevisionsBefore != 0 && !merge) {
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