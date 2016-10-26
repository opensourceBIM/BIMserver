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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.ServerIfcModel;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.queries.QueryObjectProvider;
import org.bimserver.database.queries.om.JsonQueryObjectModelConverter;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.bimserver.plugins.IfcModelSet;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.modelmerger.MergeException;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.HashMapWrappedVirtualObject;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;
import org.eclipse.emf.common.util.AbstractEList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Joiner;

public class DownloadByNewJsonQueryDatabaseAction extends AbstractDownloadDatabaseAction<IfcModelInterface> {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private final Set<Long> roids;
	private int progress;
	private String json;

	public DownloadByNewJsonQueryDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, Set<Long> roids, String json, long serializerOid, Authorization authorization) {
		super(bimServer, databaseSession, accessMethod, authorization);
		this.roids = roids;
		this.json = json;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public IfcModelInterface execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		List<String> projectNames = new ArrayList<>();
		
		setProgress("Querying database...", -1);
		
		for (long roid : roids) {
			Revision revision = getDatabaseSession().get(StorePackage.eINSTANCE.getRevision(), roid, OldQuery.getDefault());
			projectNames.add(revision.getProject().getName() + "." + revision.getId());
		}
		String name = Joiner.on("-").join(projectNames);
		PackageMetaData lastPackageMetaData = null;
		Project lastProject = null;
		
		IfcModelSet ifcModelSet = new IfcModelSet();
		Map<Integer, Long> pidRoidMap = new HashMap<>();
		for (long roid : roids) {
			Revision revision = getDatabaseSession().get(StorePackage.eINSTANCE.getRevision(), roid, OldQuery.getDefault());
			lastProject = revision.getProject();
			PackageMetaData packageMetaData = getBimServer().getMetaDataManager().getPackageMetaData(revision.getProject().getSchema());
			lastPackageMetaData = packageMetaData;
			JsonQueryObjectModelConverter converter = new JsonQueryObjectModelConverter(packageMetaData);
			ObjectNode queryObject;
			try {
				queryObject = OBJECT_MAPPER.readValue(json, ObjectNode.class);
				Query query = converter.parseJson("query", (ObjectNode) queryObject);
		
				pidRoidMap.put(revision.getProject().getId(), roid);
				IfcModelInterface ifcModel = new ServerIfcModel(packageMetaData, pidRoidMap, getDatabaseSession());

				ifcModelSet.add(ifcModel);
				
				QueryObjectProvider queryObjectProvider = new QueryObjectProvider(getDatabaseSession(), getBimServer(), query, Collections.singleton(roid), packageMetaData);
				HashMapVirtualObject next = queryObjectProvider.next();
				while (next != null) {
					IdEObject newObject = packageMetaData.create(next.eClass());
					IdEObjectImpl idEObjectImpl = (IdEObjectImpl)newObject;
					idEObjectImpl.setPid(revision.getProject().getId());
					idEObjectImpl.setOid(next.getOid());
					for (EAttribute eAttribute : newObject.eClass().getEAllAttributes()) {
						Object value = next.eGet(eAttribute);
						if (eAttribute.isMany()) {
							List<?> list = (List<?>)value;
							if (list != null) {
								AbstractEList targetList = (AbstractEList)newObject.eGet(eAttribute);
								for (Object item : list) {
									targetList.addUnique(item);
								}
							}
						} else {
							if (value != null || eAttribute.isUnsettable()) {
								newObject.eSet(eAttribute, value);
							}
						}
					}
					ifcModel.add(next.getOid(), newObject);
					next = queryObjectProvider.next();
				}
		
				queryObjectProvider = new QueryObjectProvider(getDatabaseSession(), getBimServer(), query, Collections.singleton(roid), packageMetaData);
				next = queryObjectProvider.next();
				while (next != null) {
					IdEObject idEObject = ifcModel.get(next.getOid());
					if (idEObject.eClass() != next.eClass()) {
						// Something is wrong
						throw new RuntimeException("Classes not the same");
					}
					for (EReference eReference : idEObject.eClass().getEAllReferences()) {
						if (eReference.isMany()) {
							List refOids = (List)next.eGet(eReference);
							AbstractEList<IdEObject> list = (AbstractEList<IdEObject>)idEObject.eGet(eReference);
							if (refOids != null) {
								for (Object refOid : refOids) {
									if (refOid instanceof Long) {
										IdEObject ref = ifcModel.get((long) refOid);
										if (ref != null) {
											list.addUnique(ref);
										}
									} else if (refOid instanceof HashMapWrappedVirtualObject) {
//										IdEObject ref = ifcModel.get(((HashMapWrappedVirtualObject) refOid).get);
//										if (ref != null) {
//											list.add(ref);
//										}
									}
								}
							}
						} else {
							Object r = next.eGet(eReference);
							if (r instanceof Long) {
								long refOid = (Long)r;
								idEObject.eSet(eReference, ifcModel.get(refOid));
							} else if (r instanceof HashMapWrappedVirtualObject) {
								HashMapWrappedVirtualObject hashMapWrappedVirtualObject = (HashMapWrappedVirtualObject)r;
								IdEObject embeddedObject = ifcModel.create(hashMapWrappedVirtualObject.eClass());
								idEObject.eSet(eReference, embeddedObject);
								for (EAttribute eAttribute : hashMapWrappedVirtualObject.eClass().getEAllAttributes()) {
									embeddedObject.eSet(eAttribute, hashMapWrappedVirtualObject.eGet(eAttribute));
								}
							}
						}
					}
					next = queryObjectProvider.next();
				}
				
				ifcModel.getModelMetaData().setName(name);
				ifcModel.getModelMetaData().setRevisionId(1);
				if (getAuthorization().getUoid() != -1) {
					ifcModel.getModelMetaData().setAuthorizedUser(getUserByUoid(getAuthorization().getUoid()).getName());
				}
				ifcModel.getModelMetaData().setDate(new Date());
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (IfcModelInterfaceException e) {
				e.printStackTrace();
			} catch (QueryException e) {
				e.printStackTrace();
			}
		}
		
		IfcModelInterface ifcModel = new ServerIfcModel(lastPackageMetaData, pidRoidMap, 0, getDatabaseSession());
		if (ifcModelSet.size() > 1) {
			setProgress("Merging IFC data...", -1);

			try {
				ifcModel = getBimServer().getMergerFactory().createMerger(getDatabaseSession(), getAuthorization().getUoid()).merge(lastProject, ifcModelSet, new ModelHelper(getBimServer().getMetaDataManager(), ifcModel));
			} catch (MergeException e) {
				throw new UserException(e);
			}
		} else {
			ifcModel = ifcModelSet.iterator().next();
		}
		ifcModel.getModelMetaData().setName(name);
//		ifcModel.getModelMetaData().setRevisionId(project.getRevisions().indexOf(virtualRevision) + 1);
		if (getAuthorization().getUoid() != -1) {
			ifcModel.getModelMetaData().setAuthorizedUser(getUserByUoid(getAuthorization().getUoid()).getName());
		}
		ifcModel.getModelMetaData().setDate(new Date());

		return ifcModel;
		
//		for (Long roid : roids) {
//			Revision virtualRevision = getRevisionByRoid(roid);
//			pidRoidMap.put(virtualRevision.getProject().getId(), virtualRevision.getOid());
//			project = virtualRevision.getProject();
//			name += project.getName() + "-" + virtualRevision.getId() + "-";
//			try {
//				getAuthorization().canDownload(roid);
//			} catch (UserException e) {
//				if (!getAuthorization().hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
//					throw new UserException("User has insufficient rights to download revisions from this project");
//				}
//				if (!getAuthorization().hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
//					throw new UserException("User has insufficient rights to download revisions from this project");
//				}
//			}
//			int size = 0;
//			
//			for (ConcreteRevision concreteRevision : virtualRevision.getConcreteRevisions()) {
//				try {
//					int highestStopId = findHighestStopRid(project, concreteRevision);
//					
//					PackageMetaData packageMetaData = getBimServer().getMetaDataManager().getPackageMetaData(concreteRevision.getProject().getSchema());
//					lastPackageMetaData = packageMetaData;
//					IfcModelInterface subModel = new ServerIfcModel(packageMetaData, pidRoidMap, getDatabaseSession());
//					
//					OldQuery databaseQuery = new OldQuery(packageMetaData, concreteRevision.getProject().getId(), concreteRevision.getId(), virtualRevision.getOid(), null, Deep.NO, highestStopId);
//					databaseQuery.updateOidCounters(concreteRevision, getDatabaseSession());
//					JsonObject queryObject = (JsonObject)query;
//					JsonArray queries = queryObject.get("queries").getAsJsonArray();
//					for (JsonElement queryElement : queries) {
//						processQueryPart(packageMetaData, queryObject, (JsonObject) queryElement, subModel, databaseQuery);
//					}
//					
//					size += subModel.size();
//					subModel.getModelMetaData().setDate(concreteRevision.getDate());
//					subModel.fixInverseMismatches();
//					checkGeometry(serializerPluginConfiguration, getBimServer().getPluginManager(), subModel, project, concreteRevision, virtualRevision);
//					ifcModelSet.add(subModel);
//				} catch (GeometryGeneratingException | IfcModelInterfaceException e) {
//					throw new UserException(e);
//				}
//			}
//
//		}
		// TODO check, double merging??
//		IfcModelInterface ifcModel = new BasicIfcModel(lastPackageMetaData, pidRoidMap);
//		if (ifcModelSet.size() > 1) {
//			try {
//				ifcModel = getBimServer().getMergerFactory().createMerger(getDatabaseSession(), getAuthorization().getUoid()).merge(project, ifcModelSet, new ModelHelper(getBimServer().getMetaDataManager(), ifcModel));
//			} catch (MergeException e) {
//				throw new UserException(e);
//			}
//		} else {
//			ifcModel = ifcModelSet.iterator().next();
//		}
//		if (name.endsWith("-")) {
//			name = name.substring(0, name.length()-1);
//		}
	}
	
	public int getProgress() {
		return progress;
	}
}