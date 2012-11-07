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

import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.PostCommitAction;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.ifc.IfcModel;
import org.bimserver.interfaces.SConverter;
import org.bimserver.mail.MailSystem;
import org.bimserver.merging.RevisionMerger;
import org.bimserver.models.ifc2x3tc1.GeometryInstance;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.NewRevisionAdded;
import org.bimserver.models.store.Bounds;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Geometry;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.RevisionSummary;
import org.bimserver.models.store.RevisionSummaryContainer;
import org.bimserver.models.store.RevisionSummaryType;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.Vector3f;
import org.bimserver.plugins.IfcModelSet;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.ifcengine.IfcEngine;
import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.bimserver.plugins.ifcengine.IfcEngineGeometry;
import org.bimserver.plugins.ifcengine.IfcEngineInstance;
import org.bimserver.plugins.ifcengine.IfcEngineInstanceVisualisationProperties;
import org.bimserver.plugins.ifcengine.IfcEngineModel;
import org.bimserver.plugins.ifcengine.IfcEnginePlugin;
import org.bimserver.plugins.modelmerger.MergeException;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.IncrementingOidProvider;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.Authorization;
import org.eclipse.emf.ecore.EClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckinDatabaseAction extends GenericCheckinDatabaseAction {

	private static final Logger LOGGER = LoggerFactory.getLogger(CheckinDatabaseAction.class);
	private final String comment;
	private final long poid;
	private ConcreteRevision concreteRevision;
	private final boolean merge;
	private final BimServer bimServer;
	private final boolean clean;
	private Project project;
	private Authorization authorization;
	private RevisionSummaryContainer revisionSummaryContainerEntities;
	private RevisionSummaryContainer revisionSummaryContainerRelations;
	private RevisionSummaryContainer revisionSummaryContainerPrimitives;
	private RevisionSummaryContainer revisionSummaryContainerOther;
	private Map<EClass, Integer> map = new TreeMap<EClass, Integer>(new Comparator<EClass>() {
		@Override
		public int compare(EClass o1, EClass o2) {
			return o1.getName().compareTo(o2.getName());
		}
	});

	public CheckinDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long poid, Authorization authorization, IfcModelInterface model,
			String comment, boolean merge, boolean clean) {
		super(databaseSession, accessMethod, model);
		this.bimServer = bimServer;
		this.poid = poid;
		this.authorization = authorization;
		this.comment = comment;
		this.merge = merge;
		this.clean = clean;
	}

	@Override
	public ConcreteRevision execute() throws UserException, BimserverDatabaseException {
		try {
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
			if (getModel() != null) {
				checkCheckSum(project);
			}
			CreateRevisionResult result = createNewConcreteRevision(getDatabaseSession(), getModel() == null ? 0 : getModel().getSize(), project, user, comment.trim());
			concreteRevision = result.getConcreteRevision();
			project.getConcreteRevisions().add(concreteRevision);
			if (getModel() != null) {
				concreteRevision.setChecksum(getModel().getChecksum());
			}
			final NewRevisionAdded newRevisionAdded = LogFactory.eINSTANCE.createNewRevisionAdded();
			newRevisionAdded.setDate(new Date());
			newRevisionAdded.setExecutor(user);
			Revision revision = concreteRevision.getRevisions().get(0);

			concreteRevision.setSummary(createSummary(getModel()));

			newRevisionAdded.setRevision(revision);
			newRevisionAdded.setProject(project);
			newRevisionAdded.setAccessMethod(getAccessMethod());

			Revision lastRevision = project.getLastRevision();
			IfcModelInterface ifcModel = null;
			if (merge && lastRevision != null) {
				ifcModel = checkinMerge(lastRevision);
			} else {
				ifcModel = getModel();
			}

			setProgress("Generating Geometry...", -1);
			
			Geometry geometry = generateGeometry(ifcModel, project.getId(), concreteRevision.getId(), revision);
			revision.setGeometry(geometry);
			getDatabaseSession().store(geometry);

			for (IdEObject idEObject : ifcModel.getValues()) {
				((IdEObjectImpl) idEObject).setOid(-1);
			}

			if (nrConcreteRevisionsBefore != 0 && !merge && clean) {
				// There already was a revision, lets delete it (only when not
				// merging)
				setProgress("Cleaning up older revision...", -1);
				getDatabaseSession().planClearProject(project.getId(), concreteRevision.getId() - 1, concreteRevision.getId());
			}

			if (ifcModel != null) {
				getDatabaseSession().store(ifcModel.getValues(), project.getId(), concreteRevision.getId());
			}
			getDatabaseSession().addPostCommitAction(new PostCommitAction() {
				@Override
				public void execute() throws UserException {
					bimServer.getNotificationsManager().notify(new SConverter().convertToSObject(newRevisionAdded));
				}
			});

			getDatabaseSession().store(concreteRevision);
			getDatabaseSession().store(newRevisionAdded);
			getDatabaseSession().store(project);
		} catch (Throwable e) {
			if (e instanceof BimserverDatabaseException) {
				// Let this one slide
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

	private Geometry generateGeometry(IfcModelInterface model, int pid, int rid, Revision revision) throws BimserverDatabaseException {
		Collection<SerializerPlugin> allSerializerPlugins = bimServer.getPluginManager().getAllSerializerPlugins("application/ifc", true);
		if (!allSerializerPlugins.isEmpty()) {
			SerializerPlugin serializerPlugin = allSerializerPlugins.iterator().next();
			Serializer serializer = serializerPlugin.createSerializer();
			try {
				serializer.init(model, null, bimServer.getPluginManager(), null, false);
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				serializer.writeToOutputStream(outputStream);
				Collection<IfcEnginePlugin> allIfcEnginePlugins = bimServer.getPluginManager().getAllIfcEnginePlugins(true);
				if (!allIfcEnginePlugins.isEmpty()) {
					IfcEnginePlugin ifcEnginePlugin = allIfcEnginePlugins.iterator().next();
					try {
						IfcEngine ifcEngine = ifcEnginePlugin.createIfcEngine();
						ifcEngine.init();
						try {
							IfcEngineModel ifcEngineModel = ifcEngine.openModel(new ByteArrayInputStream(outputStream.toByteArray()), outputStream.size());
							ifcEngineModel.setPostProcessing(true);
//							ifcEngineModel.setFormat(48, 48);
							try {
								IfcEngineGeometry ifcEngineGeometry = ifcEngineModel.finalizeModelling(ifcEngineModel.initializeModelling());
								Geometry geometry = StoreFactory.eINSTANCE.createGeometry();

//								EList<Integer> indices = geometry.getIndices();
//								List<Integer> indicesList = new ArrayList<Integer>(ifcEngineGeometry.getNrIndices());
//								for (int i = 0; i < ifcEngineGeometry.getNrIndices(); i++) {
//									indicesList.add(ifcEngineGeometry.getIndex(i));
//								}
//								indices.addAll(indicesList);
//
//								EList<Float> vertices = geometry.getVertices();
//								List<Float> verticesList = new ArrayList<Float>(ifcEngineGeometry.getNrVertices());
//								for (int i = 0; i < ifcEngineGeometry.getNrVertices(); i++) {
//									verticesList.add(ifcEngineGeometry.getVertex(i));
//								}
//								vertices.addAll(verticesList);
//
//								EList<Float> normals = geometry.getNormals();
//								List<Float> normalsList = new ArrayList<Float>(ifcEngineGeometry.getNrNormals());
//								for (int i = 0; i < ifcEngineGeometry.getNrNormals(); i++) {
//									normalsList.add(ifcEngineGeometry.getNormal(i));
//								}
//								normals.addAll(normalsList);

								Bounds modelBounds = getDatabaseSession().create(StorePackage.eINSTANCE.getBounds());
								modelBounds.setMin(createVector3f(Float.POSITIVE_INFINITY));
								modelBounds.setMax(createVector3f(Float.NEGATIVE_INFINITY));
								revision.setBounds(modelBounds);
								
								for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
									IfcEngineInstance ifcEngineInstance = ifcEngineModel.getInstanceFromExpressId((int) ifcProduct.getOid());
									IfcEngineInstanceVisualisationProperties visualisationProperties = ifcEngineInstance.getVisualisationProperties();
									GeometryInstance geometryInstance = Ifc2x3tc1Factory.eINSTANCE.createGeometryInstance();
									geometryInstance.setPrimitiveCount(visualisationProperties.getPrimitiveCount());
									geometryInstance.setStartIndex(visualisationProperties.getStartIndex());
									geometryInstance.setStartVertex(visualisationProperties.getStartVertex());
									ByteBuffer verticesBuffer = ByteBuffer.allocate(visualisationProperties.getPrimitiveCount() * 3 * 3 * 4);
									ByteBuffer normalsBuffer = ByteBuffer.allocate(visualisationProperties.getPrimitiveCount() * 3 * 3 * 4);
									Bounds instanceBounds = getDatabaseSession().create(StorePackage.eINSTANCE.getBounds());
									instanceBounds.setMin(createVector3f(Float.POSITIVE_INFINITY));
									instanceBounds.setMax(createVector3f(Float.NEGATIVE_INFINITY));
									ifcProduct.setBounds(instanceBounds);
									for (int i = geometryInstance.getStartIndex(); i < geometryInstance.getPrimitiveCount() * 3 + geometryInstance.getStartIndex(); i++) {
										int index = ifcEngineGeometry.getIndex(i) * 3;
										processExtends(instanceBounds, ifcEngineGeometry, verticesBuffer, normalsBuffer, index);
									}
									processExtends(instanceBounds, modelBounds);
									geometryInstance.setVertices(verticesBuffer.array());
									geometryInstance.setNormals(normalsBuffer.array());
									ifcProduct.setGeometryInstance(geometryInstance);
									getDatabaseSession().store(geometryInstance, pid, rid);
								}
								return geometry;
							} finally {
								ifcEngineModel.close();
							}
						} finally {
							ifcEngine.close();
						}
					} catch (IfcEngineException e) {
						e.printStackTrace();
					}
				}
			} catch (SerializerException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

	private Vector3f createVector3f(float defaultValue) throws BimserverDatabaseException {
		Vector3f vector3f = (Vector3f) getDatabaseSession().create(StorePackage.eINSTANCE.getVector3f());
		vector3f.setX(defaultValue);
		vector3f.setY(defaultValue);
		vector3f.setZ(defaultValue);
		return vector3f;
	}

	private void processExtends(Bounds instanceBounds, Bounds modelBounds) {
		modelBounds.getMin().setX(Math.min(instanceBounds.getMin().getX(), modelBounds.getMin().getX()));
		modelBounds.getMin().setY(Math.min(instanceBounds.getMin().getY(), modelBounds.getMin().getY()));
		modelBounds.getMin().setZ(Math.min(instanceBounds.getMin().getZ(), modelBounds.getMin().getZ()));
		modelBounds.getMax().setX(Math.max(instanceBounds.getMax().getX(), modelBounds.getMax().getX()));
		modelBounds.getMax().setY(Math.max(instanceBounds.getMax().getY(), modelBounds.getMax().getY()));
		modelBounds.getMax().setZ(Math.max(instanceBounds.getMax().getZ(), modelBounds.getMax().getZ()));
	}

	private void processExtends(Bounds bounds, IfcEngineGeometry geometry, ByteBuffer verticesBuffer, ByteBuffer normalsBuffer, int index) {
		float x = geometry.getVertex(index);
		float y = geometry.getVertex(index + 1);
		float z = geometry.getVertex(index + 2);
		verticesBuffer.putFloat(x);
		verticesBuffer.putFloat(y);
		verticesBuffer.putFloat(z);
		normalsBuffer.putFloat(geometry.getNormal(index));
		normalsBuffer.putFloat(geometry.getNormal(index + 1));
		normalsBuffer.putFloat(geometry.getNormal(index + 2));
		bounds.getMin().setX(Math.min(x, bounds.getMin().getX()));
		bounds.getMin().setY(Math.min(y, bounds.getMin().getY()));
		bounds.getMin().setZ(Math.min(z, bounds.getMin().getZ()));
		bounds.getMax().setX(Math.max(x, bounds.getMax().getX()));
		bounds.getMax().setY(Math.max(y, bounds.getMax().getY()));
		bounds.getMax().setZ(Math.max(z, bounds.getMax().getZ()));
	}

	private RevisionSummary createSummary(IfcModelInterface model) throws BimserverDatabaseException {
		RevisionSummary revisionSummary = getDatabaseSession().create(StorePackage.eINSTANCE.getRevisionSummary());
		revisionSummaryContainerEntities = getDatabaseSession().create(StorePackage.eINSTANCE.getRevisionSummaryContainer());
		revisionSummaryContainerEntities.setName("IFC Entities");
		revisionSummary.getList().add(revisionSummaryContainerEntities);
		revisionSummaryContainerRelations = getDatabaseSession().create(StorePackage.eINSTANCE.getRevisionSummaryContainer());
		revisionSummaryContainerRelations.setName("IFC Relations");
		revisionSummary.getList().add(revisionSummaryContainerRelations);
		revisionSummaryContainerPrimitives = getDatabaseSession().create(StorePackage.eINSTANCE.getRevisionSummaryContainer());
		revisionSummaryContainerPrimitives.setName("IFC Primitives");
		revisionSummary.getList().add(revisionSummaryContainerPrimitives);
		revisionSummaryContainerOther = getDatabaseSession().create(StorePackage.eINSTANCE.getRevisionSummaryContainer());
		revisionSummaryContainerOther.setName("Rest");
		revisionSummary.getList().add(revisionSummaryContainerOther);

		for (EClass eClass : getDatabaseSession().getClasses()) {
			add(revisionSummary, eClass, model.count(eClass));
		}
		for (EClass eClass : map.keySet()) {
			RevisionSummaryContainer subMap = null;
			if (Ifc2x3tc1Package.eINSTANCE.getIfcObject().isSuperTypeOf(eClass)) {
				subMap = revisionSummaryContainerEntities;
			} else if (Ifc2x3tc1Package.eINSTANCE.getIfcRelationship().isSuperTypeOf(eClass)) {
				subMap = revisionSummaryContainerRelations;
			} else if (Ifc2x3tc1Package.eINSTANCE.getWrappedValue().isSuperTypeOf(eClass)) {
				subMap = revisionSummaryContainerPrimitives;
			} else {
				subMap = revisionSummaryContainerOther;
			}
			RevisionSummaryType createRevisionSummaryType = getDatabaseSession().create(StorePackage.eINSTANCE.getRevisionSummaryType());
			createRevisionSummaryType.setCount(map.get(eClass));
			createRevisionSummaryType.setName(eClass.getName());
			subMap.getTypes().add(createRevisionSummaryType);
		}
		return revisionSummary;
	}

	public void add(RevisionSummary revisionSummary, EClass eClass, int count) {
		if (count == 0) {
			return;
		}
		if (!map.containsKey(eClass)) {
			map.put(eClass, count);
		}
		map.put(eClass, count);
	}

	private IfcModelInterface checkinMerge(Revision lastRevision) throws BimserverLockConflictException, BimserverDatabaseException, UserException {
		IfcModelInterface ifcModel;
		IfcModelSet ifcModelSet = new IfcModelSet();
		for (ConcreteRevision subRevision : lastRevision.getConcreteRevisions()) {
			if (concreteRevision != subRevision) {
				IfcModel subModel = new IfcModel();
				getDatabaseSession().getMap(subModel, subRevision.getProject().getId(), subRevision.getId(), true, null);
				subModel.setDate(subRevision.getDate());
				ifcModelSet.add(subModel);
			}
		}
		IfcModelInterface newModel = new IfcModel();
		newModel.setDate(new Date());
		newModel.fixOids(getDatabaseSession());
		IfcModelInterface oldModel;
		try {
			oldModel = bimServer.getMergerFactory().createMerger(getDatabaseSession(), authorization.getUoid()).merge(project, ifcModelSet, new ModelHelper());
		} catch (MergeException e) {
			throw new UserException(e);
		}

		oldModel.setObjectOids();
		newModel.setObjectOids();
		oldModel.indexGuids();
		newModel.indexGuids();
		newModel.fixOids(new IncrementingOidProvider(oldModel.getHighestOid() + 1));

		RevisionMerger revisionMerger = new RevisionMerger(oldModel, (IfcModel) newModel);
		try {
			ifcModel = revisionMerger.merge();
		} catch (IfcModelInterfaceException e) {
			throw new UserException(e);
		}
		revisionMerger.cleanupUnmodified();

		for (IdEObject idEObject : ifcModel.getValues()) {
			((IdEObjectImpl) idEObject).setRid(concreteRevision.getId());
			((IdEObjectImpl) idEObject).setPid(concreteRevision.getProject().getId());
		}
		return ifcModel;
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

	public Project getProject() {
		return project;
	}
}