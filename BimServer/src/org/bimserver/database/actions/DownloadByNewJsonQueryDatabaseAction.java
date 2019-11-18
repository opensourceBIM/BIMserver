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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.queries.QueryObjectProvider;
import org.bimserver.database.queries.om.CanInclude;
import org.bimserver.database.queries.om.Include;
import org.bimserver.database.queries.om.Include.TypeDef;
import org.bimserver.database.queries.om.JsonQueryObjectModelConverter;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.database.queries.om.Reference;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.geometry.GeometryPackage;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.PluginConfiguration;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.bimserver.plugins.IfcModelSet;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.modelmerger.MergeException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.HashMapWrappedVirtualObject;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;
import org.eclipse.emf.common.util.AbstractEList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Joiner;

public class DownloadByNewJsonQueryDatabaseAction extends AbstractDownloadDatabaseAction<IfcModelInterface> {

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(DownloadByNewJsonQueryDatabaseAction.class);
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private final Set<Long> roids;
	private int progress;
	private String json;
	private long serializerOid;

	public DownloadByNewJsonQueryDatabaseAction(BimServer bimServer, DatabaseSession readOnlyDatabaseSession, AccessMethod accessMethod, Set<Long> roids, String json, long serializerOid, Authorization authorization) {
		super(bimServer, readOnlyDatabaseSession, accessMethod, authorization);
		this.roids = roids;
		this.json = json;
		this.serializerOid = serializerOid;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public IfcModelInterface execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		List<String> projectNames = new ArrayList<>();
		
		PluginConfiguration serializerPluginConfiguration = getDatabaseSession().get(StorePackage.eINSTANCE.getPluginConfiguration(), serializerOid, OldQuery.getDefault());
		SerializerPlugin serializerPlugin = (SerializerPlugin) getBimServer().getPluginManager().getPlugin(serializerPluginConfiguration.getPluginDescriptor().getPluginClassName(), true);
		Set<String> geometryFields = serializerPlugin.getRequiredGeometryFields();
		
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
		Set<CanInclude> updatedIncludes = new HashSet<>();
		for (long roid : roids) {
			Revision revision = getDatabaseSession().get(StorePackage.eINSTANCE.getRevision(), roid, OldQuery.getDefault());
			lastProject = revision.getProject();
			PackageMetaData packageMetaData = getBimServer().getMetaDataManager().getPackageMetaData(revision.getProject().getSchema());
			lastPackageMetaData = packageMetaData;
			JsonQueryObjectModelConverter converter = new JsonQueryObjectModelConverter(packageMetaData);
			try {
				ObjectNode queryObject = OBJECT_MAPPER.readValue(json, ObjectNode.class);
				converter.setCopyExternalDefines(true);
				Query query = converter.parseJson("query", (ObjectNode) queryObject);
				
				// We now have the original user query, we'll amend it a little bit to include geometry, but only if the serializer requires certain fields
				// TODO only checking the base level of the query now, should check recursive and possibly more
				
				
//				System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(new JsonQueryObjectModelConverter(packageMetaData).toJson(query)));

				pidRoidMap.put(revision.getProject().getId(), roid);
				IfcModelInterface ifcModel = getDatabaseSession().createServerModel(packageMetaData, pidRoidMap);

				ifcModelSet.add(ifcModel);
				
				Query secondQuery = new Query("second", query.getPackageMetaData());
				QueryPart queryPart2 = secondQuery.createQueryPart();

				if (geometryFields != null) {
					for (String defineName : query.getDefines().keySet()) {
						Include define = query.getDefine(defineName);
						apply(geometryFields, packageMetaData, define, updatedIncludes);
					}
					for (QueryPart queryPart : query.getQueryParts()) {
						apply(geometryFields, packageMetaData, queryPart, updatedIncludes);
						if (queryPart.hasReferences()) {
							for (Reference reference : queryPart.getReferences()) {
								apply(geometryFields, packageMetaData, reference.getInclude(), updatedIncludes);
							}
						}
						if (queryPart.hasIncludes()) {
							apply(geometryFields, packageMetaData, queryPart, updatedIncludes);
						}
						if (queryPart.hasTypes()) {
							for (TypeDef typeDef : queryPart.getTypes()) {
								if (packageMetaData.getEClass("IfcProduct").isSuperTypeOf(typeDef.geteClass())) {
									Include include = queryPart.createInclude();
									applyFields(geometryFields, new TypeDef(packageMetaData.getEClass("IfcProduct"), true), include);
								}
							}
						}
						if (queryPart.isIncludeAllFields()) {
							Include newInclude = queryPart.createInclude();
							applyFields(geometryFields, new TypeDef(packageMetaData.getEClass("IfcProduct"), true), newInclude);
						}
					}
				}

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
					queryPart2.addOid(next.getOid());
					next = queryObjectProvider.next();
				}
				
				if (geometryFields != null) {
					for (QueryPart queryPart : secondQuery.getQueryParts()) {
						apply(geometryFields, packageMetaData, queryPart, updatedIncludes);
//						if (queryPart.hasReferences()) {
//							for (Reference reference : queryPart.getReferences()) {
//								apply(geometryFields, packageMetaData, reference.getInclude(), updatedIncludes);
//							}
//						}
//						if (queryPart.hasIncludes()) {
//							apply(geometryFields, packageMetaData, queryPart, updatedIncludes);
//						}
//						if (queryPart.hasTypes()) {
//							for (TypeDef typeDef : queryPart.getTypes()) {
//								if (packageMetaData.getEClass("IfcProduct").isSuperTypeOf(typeDef.geteClass())) {
//									Include include = queryPart.createInclude();
//									applyFields(geometryFields, new TypeDef(packageMetaData.getEClass("IfcProduct"), true), include);
//								}
//							}
//						}
//						if (queryPart.isIncludeAllFields()) {
//							Include newInclude = queryPart.createInclude();
//							applyFields(geometryFields, new TypeDef(packageMetaData.getEClass("IfcProduct"), true), newInclude);
//						}
					}
				}
				
				queryObjectProvider = new QueryObjectProvider(getDatabaseSession(), getBimServer(), secondQuery, Collections.singleton(roid), packageMetaData);
				
				System.out.println(converter.toJson(secondQuery));
				
				next = queryObjectProvider.next();
				while (next != null) {
					IdEObject idEObject = ifcModel.get(next.getOid());
					if (idEObject == null) {
						throw new RuntimeException("Object not found");
					}
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
											if (eReference.isUnique()) {
												list.add(ref);
											} else {
												list.addUnique(ref);
											}
//										} else {
//											throw new BimserverDatabaseException("Could not find reference to " + eReference.getName() + " " + refOid);
										}
									} else if (refOid instanceof HashMapWrappedVirtualObject) {
//										IdEObject ref = ifcModel.get(((HashMapWrappedVirtualObject) refOid).get);
//										if (ref != null) {
//											list.add(ref);
//										}
									} else if (refOid instanceof HashMapVirtualObject) {
										HashMapVirtualObject hashMapVirtualObject = (HashMapVirtualObject)refOid;
										IdEObject listObject = packageMetaData.create(hashMapVirtualObject.eClass());
										List subList = (List<?>) hashMapVirtualObject.get("List");
										List newList = (List<?>) listObject.eGet(listObject.eClass().getEStructuralFeature("List"));
										for (Object o : subList) {
											if (o instanceof HashMapWrappedVirtualObject) {
												newList.add(convertWrapped(revision, ifcModel, (HashMapWrappedVirtualObject)o));
											} else if (o instanceof Long) {
												LOGGER.warn("TODO");
												// TODO
											} else {
												newList.add(o);
											}
										}
										list.addUnique(listObject);
									} else {
										throw new BimserverDatabaseException("Unimplemented");
									}
								}
							}
						} else {
							Object r = next.eGet(eReference);
							if (r instanceof Long) {
								long refOid = (Long)r;
								IdEObject referred = ifcModel.get(refOid);
								if (referred == null) {
									System.out.println(eReference.getName() + " " + refOid);
								}
								idEObject.eSet(eReference, referred);
							} else if (r instanceof HashMapWrappedVirtualObject) {
								idEObject.eSet(eReference, convertWrapped(revision, ifcModel, (HashMapWrappedVirtualObject) r));
							} else if (r instanceof HashMapVirtualObject) {
								throw new BimserverDatabaseException("Unimplemented");
							} else if (r == null) {
							} else {
								throw new BimserverDatabaseException("Unimplemented");
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
			} catch (Throwable e) {
				throw new BimserverDatabaseException(e);
			}
		}
		
		IfcModelInterface ifcModel = getDatabaseSession().createServerModel(lastPackageMetaData, pidRoidMap);
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

	private void apply(Set<String> geometryFields, PackageMetaData packageMetaData, CanInclude canInclude, Set<CanInclude> updatedIncludes)
			throws QueryException {
		if (updatedIncludes.contains(canInclude)) {
			return;
		}
		EClass ifcProduct = packageMetaData.getEClass("IfcProduct");
		updatedIncludes.add(canInclude);
		if (canInclude.hasIncludes()) {
			for (Include existingInclude : canInclude.getIncludes()) {
				apply(geometryFields, packageMetaData, existingInclude, updatedIncludes);
			}
		}
		if (canInclude.hasIncludesToResolve()) {
			for (String existingInclude : canInclude.getIncludesToResolve()) {
				// TODO
//				apply(geometryFields, packageMetaData, existingInclude, updatedIncludes);
			}
		}
		if (canInclude.hasOids()) {
			Include newInclude = canInclude.createInclude();
			applyFields(geometryFields, new TypeDef(packageMetaData.getEClass("IfcProduct"), true), newInclude);
		}
		if (canInclude.hasReferences()) {
			for (Reference reference : canInclude.getReferences()) {
				apply(geometryFields, packageMetaData, reference.getInclude(), updatedIncludes);
			}
		}
		if (canInclude instanceof Include) {
			Include inc = ((Include)canInclude);
			if (inc.hasFields()) {
				for (EReference field : inc.getFields()) {
					if (ifcProduct.isSuperTypeOf((EClass)field.getEType()) || ((EClass)field.getEType()).isSuperTypeOf(ifcProduct)) {
						Include newInclude = inc.createInclude();
						applyFields(geometryFields, new TypeDef(ifcProduct, true), newInclude);
					}
				}
			}
		}
		if (canInclude.hasTypes()) {
			for (TypeDef typeDef : canInclude.getTypes()) {
				if (ifcProduct.isSuperTypeOf(typeDef.geteClass()) || ((EClass)typeDef.geteClass()).isSuperTypeOf(ifcProduct)) {
					Include include = canInclude.createInclude();
					applyFields(geometryFields, new TypeDef(ifcProduct, true), include);
				}
			}
		}
	}

	private void applyFields(Set<String> geometryFields, TypeDef typeDef, Include include) throws QueryException {
		include.addType(typeDef);
		include.addField("geometry");
		Include geometryInclude = include.createInclude();
		geometryInclude.addType(GeometryPackage.eINSTANCE.getGeometryInfo(), false);
		geometryInclude.addField("data");
		Include geometryData = geometryInclude.createInclude();
		geometryData.addType(GeometryPackage.eINSTANCE.getGeometryData(), false);
		geometryData.addField("color");
		for (String field : geometryFields) {
			geometryData.addField(field);
		}
	}

	private IdEObject convertWrapped(Revision revision, IfcModelInterface ifcModel, HashMapWrappedVirtualObject hashMapWrappedVirtualObject) throws IfcModelInterfaceException {
		IdEObject embeddedObject = ifcModel.create(hashMapWrappedVirtualObject.eClass());
		((IdEObjectImpl)embeddedObject).setOid(-1);
		((IdEObjectImpl)embeddedObject).setPid(revision.getProject().getId());
		for (EAttribute eAttribute : hashMapWrappedVirtualObject.eClass().getEAllAttributes()) {
			embeddedObject.eSet(eAttribute, hashMapWrappedVirtualObject.eGet(eAttribute));
		}
		return embeddedObject;
	}
	
	public int getProgress() {
		return progress;
	}
}