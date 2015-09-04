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

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.BimServer;
import org.bimserver.GeometryGeneratingException;
import org.bimserver.ServerIfcModel;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.Query.Deep;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.QueryInterface;
import org.bimserver.ifc.BasicIfcModel;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.PluginConfiguration;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.plugins.IfcModelSet;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.modelmerger.MergeException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class DownloadByJsonQueryDatabaseAction extends AbstractDownloadDatabaseAction<IfcModelInterface> {

	private final Set<Long> roids;
	private int progress;
	private long serializerOid;
	private String json;

	public DownloadByJsonQueryDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, Set<Long> roids, String json, long serializerOid, Authorization authorization) {
		super(bimServer, databaseSession, accessMethod, authorization);
		this.roids = roids;
		this.json = json;
		this.serializerOid = serializerOid;
	}

	@Override
	public IfcModelInterface execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		IfcModelSet ifcModelSet = new IfcModelSet();
		User user = getUserByUoid(getAuthorization().getUoid());
		Project project = null;
		PluginConfiguration serializerPluginConfiguration = getDatabaseSession().get(StorePackage.eINSTANCE.getPluginConfiguration(), serializerOid, Query.getDefault());
		String name = "";
		PackageMetaData lastPackageMetaData = null;
		Map<Integer, Long> pidRoidMap = new HashMap<>();
		for (Long roid : roids) {
			Revision virtualRevision = getRevisionByRoid(roid);
			pidRoidMap.put(virtualRevision.getProject().getId(), virtualRevision.getOid());
			project = virtualRevision.getProject();
			name += project.getName() + "-" + virtualRevision.getId() + "-";
			try {
				getAuthorization().canDownload(roid);
			} catch (UserException e) {
				if (!getAuthorization().hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
					throw new UserException("User has insufficient rights to download revisions from this project");
				}
				if (!getAuthorization().hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
					throw new UserException("User has insufficient rights to download revisions from this project");
				}
			}
			int size = 0;
			
			JsonParser parser = new JsonParser();
			JsonElement query = parser.parse(json);
			for (ConcreteRevision concreteRevision : virtualRevision.getConcreteRevisions()) {
				try {
					int highestStopId = findHighestStopRid(project, concreteRevision);
					
					PackageMetaData packageMetaData = getBimServer().getMetaDataManager().getPackageMetaData(concreteRevision.getProject().getSchema());
					lastPackageMetaData = packageMetaData;
					IfcModelInterface subModel = new ServerIfcModel(packageMetaData, pidRoidMap, getDatabaseSession());
					
					Query databaseQuery = new Query(packageMetaData, concreteRevision.getProject().getId(), concreteRevision.getId(), virtualRevision.getOid(), null, Deep.NO, highestStopId);
					databaseQuery.updateOidCounters(concreteRevision, getDatabaseSession());
					JsonObject queryObject = (JsonObject)query;
					JsonArray queries = queryObject.get("queries").getAsJsonArray();
					for (JsonElement queryElement : queries) {
						processQueryPart(packageMetaData, queryObject, (JsonObject) queryElement, subModel, databaseQuery);
					}
					
					size += subModel.size();
					subModel.getModelMetaData().setDate(concreteRevision.getDate());
					subModel.fixInverseMismatches();
					checkGeometry(serializerPluginConfiguration, getBimServer().getPluginManager(), subModel, project, concreteRevision, virtualRevision);
					ifcModelSet.add(subModel);
				} catch (GeometryGeneratingException | IfcModelInterfaceException e) {
					throw new UserException(e);
				}
			}

			IfcModelInterface ifcModel = new ServerIfcModel(lastPackageMetaData, pidRoidMap, size, getDatabaseSession());
			if (ifcModelSet.size() > 1) {
				try {
					ifcModel = getBimServer().getMergerFactory().createMerger(getDatabaseSession(), getAuthorization().getUoid()).merge(project, ifcModelSet, new ModelHelper(getBimServer().getMetaDataManager(), ifcModel));
				} catch (MergeException e) {
					throw new UserException(e);
				}
			} else {
				ifcModel = ifcModelSet.iterator().next();
			}
			ifcModel.getModelMetaData().setName("Unknown");
			ifcModel.getModelMetaData().setRevisionId(project.getRevisions().indexOf(virtualRevision) + 1);
			if (getAuthorization().getUoid() != -1) {
				ifcModel.getModelMetaData().setAuthorizedUser(getUserByUoid(getAuthorization().getUoid()).getName());
			}
			ifcModel.getModelMetaData().setDate(virtualRevision.getDate());
		}
		// TODO check, double merging??
		IfcModelInterface ifcModel = new BasicIfcModel(lastPackageMetaData, pidRoidMap);
		if (ifcModelSet.size() > 1) {
			try {
				ifcModel = getBimServer().getMergerFactory().createMerger(getDatabaseSession(), getAuthorization().getUoid()).merge(project, ifcModelSet, new ModelHelper(getBimServer().getMetaDataManager(), ifcModel));
			} catch (MergeException e) {
				throw new UserException(e);
			}
		} else {
			ifcModel = ifcModelSet.iterator().next();
		}
		if (name.endsWith("-")) {
			name = name.substring(0, name.length()-1);
		}
		ifcModel.getModelMetaData().setName(name);
		ifcModel.getModelMetaData().setRevisionId(1);
		if (getAuthorization().getUoid() != -1) {
			ifcModel.getModelMetaData().setAuthorizedUser(getUserByUoid(getAuthorization().getUoid()).getName());
		}
		ifcModel.getModelMetaData().setDate(new Date());
		return ifcModel;
	}
	
	private void processQueryPart(PackageMetaData packageMetaData, JsonObject query, JsonObject typeQuery, IfcModelInterface model, QueryInterface queryInterface) throws BimserverDatabaseException, IfcModelInterfaceException {
		if (typeQuery.has("type")) {
			String type = typeQuery.get("type").getAsString();
			EClass typeClass = packageMetaData.getEClassIncludingDependencies(type);
			Set<EClass> eClasses = new HashSet<EClass>();
			eClasses.add(typeClass);
			if (typeQuery.has("includeAllSubtypes") && typeQuery.get("includeAllSubtypes").getAsBoolean()) {
				eClasses.addAll(packageMetaData.getAllSubClasses((EClass)typeClass));
			}
			getDatabaseSession().getAllOfTypes(model, eClasses, queryInterface);
			if (typeQuery.has("include")) {
				processInclude(query, typeQuery, model, queryInterface, model.getAllWithSubTypes(typeClass));
			}
		}
	}

	private void processInclude(JsonObject query, JsonObject queryPart, IfcModelInterface model, QueryInterface queryInterface, List<IdEObject> objects) throws BimserverDatabaseException, IfcModelInterfaceException {
		if (queryPart.get("include").isJsonArray()) {
			JsonArray includes = queryPart.get("include").getAsJsonArray();
			for (JsonElement include : includes) {
				if (include.isJsonPrimitive()) {
					processSingleInclude(query, include, model, queryInterface, objects);
				} else if (include.isJsonObject()) {
					processDefine(query, (JsonObject) include, model, queryInterface, objects);
				}
			}
		} else if (queryPart.get("include").isJsonObject()) {
			processDefine(query, queryPart.get("include").getAsJsonObject(), model, queryInterface, objects);
		}
	}

	private void processSingleInclude(JsonObject query, JsonElement include, IfcModelInterface model, QueryInterface queryInterface, List<IdEObject> objects) throws BimserverDatabaseException, IfcModelInterfaceException {
		if (include.isJsonPrimitive()) {
			String includeName = include.getAsString();
			if (query.has("defines")) {
				JsonObject defines = query.get("defines").getAsJsonObject();
				if (defines.has(includeName)) {
					JsonObject define = defines.get(includeName).getAsJsonObject();
					processDefine(query, define, model, queryInterface, objects);
				} else {
					throw new BimserverDatabaseException("No define with name '" + includeName + "' found");
				}
			} else {
				throw new BimserverDatabaseException("No define with name '" + includeName + "' found");
			}
		}
	}

	private void processDefine(JsonObject query, JsonObject define, IfcModelInterface model, QueryInterface queryInterface, List<IdEObject> objects) throws BimserverDatabaseException, IfcModelInterfaceException {
		for (IdEObject object : objects) {
			if (define.has("field")) {
				String fieldName = define.get("field").getAsString();
				EStructuralFeature eStructuralFeature = object.eClass().getEStructuralFeature(fieldName);
				if (eStructuralFeature == null) {
//				System.out.println("No field " + fieldName + " on " + objectOfType.eClass().getName());
					return;
//				throw new BimserverDatabaseException("No field with name '" + fieldName + "' found in class '" + objectOfType.eClass().getName() + "'");
				}
				Object value = object.eGet(eStructuralFeature);
				if (eStructuralFeature.isMany()) {
					if (eStructuralFeature instanceof EReference) {
						List<?> list = ((List<?>)value);
						for (Object o : list) {
							if (!model.contains(((IdEObject)o).getOid())) {
								model.add(((IdEObject)o).getOid(), ((IdEObject)o));
							}
							((IdEObject)o).load();
							if (define.has("include")) {
								if (define.get("include").isJsonObject()) {
									processDefine(query, define.get("include").getAsJsonObject(), model, queryInterface, Collections.singletonList((IdEObject)o));
								} else if (define.get("include").isJsonArray()) {
									processInclude(query, define, model, queryInterface, Collections.singletonList(((IdEObject)o)));
								} else {
									processSingleInclude(query, define.get("include"), model, queryInterface, Collections.singletonList(((IdEObject)o)));
								}
							}
						}
					}
				} else {
					if (value != null && value instanceof IdEObject) {
						if (!model.contains(((IdEObject)value).getOid())) {
							model.add(((IdEObject)value).getOid(), ((IdEObject)value));
						}
						((IdEObject)value).load();
						if (define.has("include")) {
							processDefine(query, define, model, queryInterface, Collections.singletonList((IdEObject)value));
						}
					}
				}
			}
		}
	}

	public int getProgress() {
		return progress;
	}
}