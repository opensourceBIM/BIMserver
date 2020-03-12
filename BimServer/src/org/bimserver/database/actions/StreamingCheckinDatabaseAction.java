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
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.GenerateGeometryResult;
import org.bimserver.SummaryMap;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OidCounters;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OperationType;
import org.bimserver.database.PostCommitAction;
import org.bimserver.database.Record;
import org.bimserver.database.RecordIterator;
import org.bimserver.database.queries.ConcreteRevisionStackFrame;
import org.bimserver.database.queries.QueryObjectProvider;
import org.bimserver.database.queries.om.Include;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.geometry.GeometryGenerationReport;
import org.bimserver.geometry.Matrix;
import org.bimserver.geometry.StreamingGeometryGenerator;
import org.bimserver.mail.MailSystem;
import org.bimserver.models.geometry.Bounds;
import org.bimserver.models.geometry.Buffer;
import org.bimserver.models.geometry.GeometryPackage;
import org.bimserver.models.geometry.Vector3f;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.NewRevisionAdded;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.IfcHeader;
import org.bimserver.models.store.NewService;
import org.bimserver.models.store.PluginBundleVersion;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.Service;
import org.bimserver.models.store.User;
import org.bimserver.notifications.NewRevisionNotification;
import org.bimserver.plugins.deserializers.ByteProgressReporter;
import org.bimserver.plugins.deserializers.StreamingDeserializer;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.QueryContext;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;
import org.bimserver.webservices.authorization.ExplicitRightsAuthorization;
import org.bimserver.webservices.impl.RestartableInputStream;
import org.eclipse.emf.ecore.EClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

public class StreamingCheckinDatabaseAction extends GenericCheckinDatabaseAction {

	private static final Logger LOGGER = LoggerFactory.getLogger(StreamingCheckinDatabaseAction.class);
	private final String comment;
	private final long poid;
	private ConcreteRevision concreteRevision;
	private Project project;
	private Authorization authorization;
	private String fileName;
	private long fileSize;
	private InputStream inputStream;
	private StreamingDeserializer deserializer;
	private long newServiceId;
	private Revision newRevision;
	private PackageMetaData packageMetaData;
	private PluginBundleVersion pluginBundleVersion;
	private long topicId;

	public StreamingCheckinDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long poid, Authorization authorization, String comment, String fileName, InputStream inputStream, StreamingDeserializer deserializer, long fileSize, long newServiceId, PluginBundleVersion pluginBundleVersion, long topicId) {
		super(bimServer, databaseSession, accessMethod);
		this.poid = poid;
		this.authorization = authorization;
		this.comment = comment;
		this.fileName = fileName;
		this.inputStream = inputStream;
		this.deserializer = deserializer;
		this.fileSize = fileSize;
		this.newServiceId = newServiceId;
		this.pluginBundleVersion = pluginBundleVersion;
		this.topicId = topicId;
	}

	@Override
	public ConcreteRevision execute() throws UserException, BimserverDatabaseException {
		try {
			if (inputStream instanceof RestartableInputStream) {
				((RestartableInputStream)inputStream).restartIfAtEnd();
			}
			
			getDatabaseSession().clearPostCommitActions();
			
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
			
			packageMetaData = getBimServer().getMetaDataManager().getPackageMetaData(project.getSchema());

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

			newRevision = result.getRevisions().get(0);
			long newRoid = newRevision.getOid();
			QueryContext queryContext = new QueryContext(getDatabaseSession(), packageMetaData, result.getConcreteRevision().getProject().getId(), result.getConcreteRevision().getId(), newRoid, result.getConcreteRevision().getOid(), -1); // TODO check
			
			AtomicLong bytesRead = new AtomicLong();
			
			deserializer.setProgressReporter(new ByteProgressReporter() {
				@Override
				public void progress(long byteNumber) {
					bytesRead.set(byteNumber);
					if (fileSize != -1) {
						int perc = (int)(100.0 * byteNumber / fileSize);
						setProgress("Deserializing...", perc);
					}
				}
			});
			
			// This will read the full stream of objects and write to the database directly
			long size = deserializer.read(inputStream, fileName, fileSize, queryContext);
			
			Set<EClass> eClasses = deserializer.getSummaryMap().keySet();
			Map<String, Long> startOids = getDatabaseSession().getStartOids();
			if (startOids == null) {
				throw new BimserverDatabaseException("No objects changed");
			}
			OidCounters oidCounters = new OidCounters();
			for (EClass eClass : eClasses) {
				if (!DatabaseSession.perRecordVersioning(eClass)) {
					oidCounters.put(eClass, startOids.get(fullname(eClass)));
				}
			}
			
			queryContext.setOidCounters(oidCounters);
			
			concreteRevision = result.getConcreteRevision();
			concreteRevision.setOidCounters(oidCounters.getBytes());

			setProgress("Generating inverses/opposites...", -1);
			
			fixInverses(packageMetaData, newRoid, deserializer.getSummaryMap());

			ProgressListener progressListener = new ProgressListener() {
				@Override
				public void updateProgress(String state, int percentage) {
					setProgress("Generating geometry...", percentage);
				}
			};
			
			GeometryGenerationReport report = null;
			if (getBimServer().getServerSettingsCache().getServerSettings().isGenerateGeometryOnCheckin()) {
				report = new GeometryGenerationReport();
				report.setOriginalIfcFileName(fileName);
				report.setOriginalIfcFileSize(bytesRead.get());
				report.setNumberOfObjects(size);
				report.setOriginalDeserializer(pluginBundleVersion.getGroupId() + "." + pluginBundleVersion.getArtifactId() + ":" + pluginBundleVersion.getVersion());
				StreamingGeometryGenerator geometryGenerator = new StreamingGeometryGenerator(getBimServer(), progressListener, -1L, report);
				setProgress("Generating geometry...", 0);

				GenerateGeometryResult generateGeometry = geometryGenerator.generateGeometry(getActingUid(), getDatabaseSession(), queryContext, size);
			
				for (Revision other : concreteRevision.getRevisions()) {
					other.setHasGeometry(true);
				}
				concreteRevision.setMultiplierToMm(generateGeometry.getMultiplierToMm());
				concreteRevision.setBounds(generateGeometry.getBounds());
				concreteRevision.setBoundsUntransformed(generateGeometry.getBoundsUntransformed());
				
				// TODO terrible code, but had to get it going quickly, will cleanup later
				
				generateDensityAndBounds(result, generateGeometry, concreteRevision);
			}
			
			final GeometryGenerationReport finalReport = report;
			
//			float[] quantizationMatrix = createQuantizationMatrixFromBounds(newRevision.getBoundsMm());
			
//			generateQuantizedVertices(getDatabaseSession(), newRevision, quantizationMatrix, generateGeometry.getMultiplierToMm());

			setProgress("Doing other stuff...", -1);
			
			eClasses = deserializer.getSummaryMap().keySet();
			oidCounters = new OidCounters();
			for (EClass eClass : eClasses) {
				String fullname = fullname(eClass);
				Long oid = startOids.get(fullname);
				if (oid == null) {
					// This happens almost never, but it most certainly must be a bug, adding verbose logging to try and identify the problem

					LOGGER.info("");
					LOGGER.info("EClass " + eClass.getName() + " not found in startOids, please report");
					LOGGER.info("eClasses:");
					for (EClass eClass2 : eClasses) {
						LOGGER.info(fullname(eClass2));
					}
					LOGGER.info("");
					LOGGER.info("startOids");
					for (String fullname2 : startOids.keySet()) {
						LOGGER.info(fullname2 + ": " + startOids.get(fullname2));
					}
					
					throw new UserException("EClass " + eClass.getName() + " not found in startOids, please report");
				}
				if (!DatabaseSession.perRecordVersioning(eClass)) {
					oidCounters.put(eClass, oid);
				}
			}
			
			if (startOids.containsKey(fullname(GeometryPackage.eINSTANCE.getGeometryInfo())) && startOids.containsKey(fullname(GeometryPackage.eINSTANCE.getGeometryData()))) {
				oidCounters.put(GeometryPackage.eINSTANCE.getGeometryInfo(), startOids.get(fullname(GeometryPackage.eINSTANCE.getGeometryInfo())));
				oidCounters.put(GeometryPackage.eINSTANCE.getGeometryData(), startOids.get(fullname(GeometryPackage.eINSTANCE.getGeometryData())));
				oidCounters.put(GeometryPackage.eINSTANCE.getBuffer(), startOids.get(fullname(GeometryPackage.eINSTANCE.getBuffer())));
			}
			
			concreteRevision = result.getConcreteRevision();
			concreteRevision.setOidCounters(oidCounters.getBytes());
			
			// Clear the cache, we don't want it to cache incomplete oidcounters
			ConcreteRevisionStackFrame.clearCache(concreteRevision.getOid());
			
			result.getConcreteRevision().setSize(size);
			for (Revision revision : result.getRevisions()) {
				revision.setSize(((revision.getSize() == null || revision.getSize() == -1) ? 0 : revision.getSize()) + concreteRevision.getSize());
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
					try (DatabaseSession tmpSession = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE)) {
						Project project = tmpSession.get(poid, OldQuery.getDefault());
						project.setCheckinInProgress(0);
						tmpSession.store(project);
						tmpSession.commit();
					} catch (BimserverDatabaseException e) {
						LOGGER.error("", e);
					} catch (ServiceException e) {
						LOGGER.error("", e);
					}
					if (finalReport != null) {
						byte[] htmlBytes = finalReport.toHtml().getBytes(Charsets.UTF_8);
						byte[] jsonBytes = finalReport.toJson().toString().getBytes(Charsets.UTF_8);
						try (DatabaseSession tmpSession = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE)) {
							AddGeometryReports addGeometryReports = new AddGeometryReports(tmpSession, AccessMethod.INTERNAL, htmlBytes, jsonBytes, finalReport.getTimeToGenerateMs(), authorization.getUoid(), revision.getOid());
							try {
								tmpSession.executeAndCommitAction(addGeometryReports);
							} catch (ServerException e1) {
								LOGGER.error("", e1);
							}
						} catch (BimserverDatabaseException e1) {
							LOGGER.error("", e1);
						}
					}
					getBimServer().getNotificationsManager().notify(new NewRevisionNotification(getBimServer(), project.getOid(), revision.getOid(), authorization));
				}
			});

			getDatabaseSession().store(concreteRevision);
			getDatabaseSession().store(project);
		} catch (Throwable e) {
			try (DatabaseSession tmpSession = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE)) {
				Project project = tmpSession.get(poid, OldQuery.getDefault());
				project.setCheckinInProgress(0);
				tmpSession.store(project);
				try {
					tmpSession.commit();
				} catch (ServiceException e2) {
					LOGGER.error("", e2);
				}
			} catch (BimserverDatabaseException e1) {
				LOGGER.error("", e1);
			}
			
			if (e instanceof BimserverDatabaseException) {
				throw (BimserverDatabaseException) e;
			}
			if (e instanceof UserException) {
				throw (UserException) e;
			}
			throw new UserException("[" + fileName + "] " + e.getMessage(), e);
		}
		return concreteRevision;
	}

	private String fullname(EClass eClass) {
		return eClass.getEPackage().getName() + "." + eClass.getName();
	}

	private void generateQuantizedVertices(DatabaseSession databaseSession, Revision revision, float[] quantizationMatrix, float multiplierToMm) {
		PackageMetaData packageMetaData = getBimServer().getMetaDataManager().getPackageMetaData(revision.getProject().getSchema());
		Query query = new Query(packageMetaData);
		QueryPart queryPart = query.createQueryPart();
		queryPart.addType(GeometryPackage.eINSTANCE.getGeometryData(), false);
		Include geometryDataInclude = queryPart.createInclude();
		try {
			geometryDataInclude.addType(GeometryPackage.eINSTANCE.getGeometryData(), false);
			geometryDataInclude.addFieldDirect("vertices");
			
			QueryObjectProvider objectProvider = new QueryObjectProvider(getDatabaseSession(), getBimServer(), query, Collections.singleton(revision.getOid()), packageMetaData);

			HashMapVirtualObject next = objectProvider.next();
			while (next != null) {
				HashMapVirtualObject verticesBuffer = (HashMapVirtualObject) next.get("vertices");
				ByteBuffer verticesData = ByteBuffer.wrap((byte[]) verticesBuffer.get("data"));
				verticesData.order(ByteOrder.LITTLE_ENDIAN);
				FloatBuffer vertices = verticesData.asFloatBuffer();
				
				ByteBuffer verticesQuantized = quantizeVertices(vertices.array(), quantizationMatrix, multiplierToMm);
				Buffer buffer = getDatabaseSession().create(Buffer.class);
				buffer.setData(verticesQuantized.array());
				
				next.setReference(GeometryPackage.eINSTANCE.getGeometryData_VerticesQuantized(), buffer.getOid(), -1);
				next.saveOverwrite();
				
				next = objectProvider.next();
				System.out.println("Generating quantized vertices");
			}
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}
	
	private ByteBuffer quantizeVertices(float[] vertices, float[] quantizationMatrix, float multiplierToMm) {
		ByteBuffer quantizedBuffer = ByteBuffer.wrap(new byte[vertices.length * 2]);
		quantizedBuffer.order(ByteOrder.LITTLE_ENDIAN);
		
		float[] vertex = new float[4];
		float[] result = new float[4];
		vertex[3] = 1;
		int nrVertices = vertices.length;
		for (int i=0; i<nrVertices; i+=3) {
			vertex[0] = vertices[i];
			vertex[1] = vertices[i+1];
			vertex[2] = vertices[i+2];
	
			if (multiplierToMm != 1f) {
				vertex[0] = vertex[0] * multiplierToMm;
				vertex[1] = vertex[1] * multiplierToMm;
				vertex[2] = vertex[2] * multiplierToMm;
			}

			Matrix.multiplyMV(result, 0, quantizationMatrix, 0, vertex, 0);
			
			quantizedBuffer.putShort((short)result[0]);
			quantizedBuffer.putShort((short)result[1]);
			quantizedBuffer.putShort((short)result[2]);
		}

		return quantizedBuffer;
	}
	
	private float[] createQuantizationMatrixFromBounds(Bounds bounds) {
		float[] matrix = Matrix.identityF();
		float scale = 32768;
		
		Vector3f min = bounds.getMin();
		Vector3f max = bounds.getMax();
		
		// Move the model with its center to the origin
		Matrix.translateM(matrix, 0, (float)(-((double)max.getX() + (double)min.getX()) / 2f), (float)(-((double)max.getY() + (double)min.getY()) / 2f), (float)(-((double)max.getZ() + (double)min.getZ()) / 2f));

		// Scale the model to make sure all values fit within a 2-byte signed short
		Matrix.scaleM(matrix, 0, (float)(scale / ((double)max.getX() - (double)min.getX())), (float)(scale / ((double)max.getY() - (double)min.getY())), (float)(scale / ((double)max.getZ() - (double)min.getZ())));

		return matrix;
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

	public void rollback() throws BimserverDatabaseException {
		// TODO do we need to remove indices too?
		
		LOGGER.info("Rolling back");
		int pid = newRevision.getProject().getId();
		int rid = newRevision.getRid();
		
		Map<String, Long> startOids = getDatabaseSession().getStartOids();
		if (startOids == null) {
			throw new BimserverDatabaseException("No objects changed");
		}
		int deleted = 0;
		for (String fullName : startOids.keySet()) {
			String packageName = fullName.substring(0, fullName.indexOf("."));
			String className = fullName.substring(fullName.indexOf(".") + 1);
			getDatabaseSession().getEClassForName(packageName, className);
			Long startOid = startOids.get(fullName);
			ByteBuffer mustStartWith = ByteBuffer.wrap(new byte[4]);
			mustStartWith.putInt(pid);
			ByteBuffer startSearchWith = ByteBuffer.wrap(new byte[12]);
			startSearchWith.putInt(pid);
			startSearchWith.putLong(startOid);
			
			String tableName = packageName + "_" + className;
			try {
				if (!getDatabaseSession().getKeyValueStore().isTransactional(getDatabaseSession(), tableName)) {
					// We only need to check the non-transactional tables, the rest is rolled-back by bdb
//					System.out.println("Checking " + tableName);
					try (RecordIterator recordIterator = getDatabaseSession().getKeyValueStore().getRecordIterator(tableName, mustStartWith.array(), startSearchWith.array(), getDatabaseSession())){
						Record record = recordIterator.next();
						while (record != null) {
//							System.out.println("Deleting from " + tableName);
							
							ByteBuffer keyBuffer = ByteBuffer.wrap(record.getKey());
							keyBuffer.getInt(); // pid
							keyBuffer.getLong(); // oid
							int keyRid = -keyBuffer.getInt();
							
							if (keyRid == rid) {
								getDatabaseSession().getKeyValueStore().delete(tableName, record.getKey(), getDatabaseSession());
								deleted++;
							}
							record = recordIterator.next();
						}
					} catch (BimserverLockConflictException e) {
						e.printStackTrace();
					} catch (BimserverDatabaseException e) {
						e.printStackTrace();
					}
				}
			} catch (BimserverDatabaseException e1) {
				e1.printStackTrace();
			}
		}
		LOGGER.info("Deleted " + deleted + " objects in rollback");
//		getDatabaseSession().getKeyValueStore().sync();
	}
}