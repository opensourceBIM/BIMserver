package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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
import java.util.HashSet;
import java.util.Set;

import org.bimserver.BimServer;
import org.bimserver.HideAllInversesObjectIDM;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.Query.Deep;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.SerializerPluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.plugins.IfcModelSet;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.Reporter;
import org.bimserver.plugins.modelmerger.MergeException;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.CollectionUtils;
import org.bimserver.webservices.authorization.Authorization;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DownloadByTypesDatabaseAction extends AbstractDownloadDatabaseAction<IfcModelInterface> {

	private static final Logger LOGGER = LoggerFactory.getLogger(DownloadByTypesDatabaseAction.class);
	private final Set<String> classNames;
	private final Set<Long> roids;
	private int progress;
	private final BimServer bimServer;
	private final ObjectIDM objectIDM;
	private final boolean includeAllSubtypes;
	private long serializerOid;
	private boolean useObjectIDM;
	private Deep deep;

	public DownloadByTypesDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, Set<Long> roids, Set<String> classNames, long serializerOid, boolean includeAllSubtypes, boolean useObjectIDM, Authorization authorization, ObjectIDM objectIDM, Reporter reporter, Deep deep) {
		super(databaseSession, accessMethod, authorization);
		this.bimServer = bimServer;
		this.roids = roids;
		this.serializerOid = serializerOid;
		this.includeAllSubtypes = includeAllSubtypes;
		this.useObjectIDM = useObjectIDM;
		this.classNames = classNames;
		this.objectIDM = objectIDM;
		this.deep = deep;
	}

	@Override
	public IfcModelInterface execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		IfcModelSet ifcModelSet = new IfcModelSet();
		User user = getUserByUoid(getAuthorization().getUoid());
		Project project = null;
		Set<EClass> eClasses = new HashSet<EClass>();
		SerializerPluginConfiguration serializerPluginConfiguration = getDatabaseSession().get(StorePackage.eINSTANCE.getSerializerPluginConfiguration(), serializerOid, Query.getDefault());
		for (String className : classNames) {
			eClasses.add(getDatabaseSession().getEClassForName(className));
			if (includeAllSubtypes) {
				EClassifier eClassifier = Ifc2x3tc1Package.eINSTANCE.getEClassifier(className);
				if (eClassifier == null) {
					throw new UserException("Class " + className + " not found");
				}
				eClasses.addAll(bimServer.getDatabase().getMetaDataManager().getAllSubClasses((EClass)eClassifier));
			}
		}
		String name = "";
		for (Long roid : roids) {
			Revision virtualRevision = getRevisionByRoid(roid);
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
			for (ConcreteRevision concreteRevision : virtualRevision.getConcreteRevisions()) {
				try {
					HideAllInversesObjectIDM hideAllInversesObjectIDM = new HideAllInversesObjectIDM(CollectionUtils.singleSet(Ifc2x3tc1Package.eINSTANCE), bimServer.getPluginManager().requireSchemaDefinition());
					int highestStopId = findHighestStopRid(project, concreteRevision);
					IfcModelInterface subModel = getDatabaseSession().getAllOfTypes(eClasses, new Query(concreteRevision.getProject().getId(), concreteRevision.getId(), useObjectIDM ? objectIDM : hideAllInversesObjectIDM, deep, highestStopId));
					subModel.getModelMetaData().setDate(concreteRevision.getDate());
					checkGeometry(serializerPluginConfiguration, bimServer.getPluginManager(), subModel, project, concreteRevision, virtualRevision);
					ifcModelSet.add(subModel);
				} catch (PluginException e) {
					LOGGER.error("", e);
				}
			}
			IfcModelInterface ifcModel;
			if (ifcModelSet.size() > 1) {
				try {
					ifcModel = bimServer.getMergerFactory().createMerger(getDatabaseSession(), getAuthorization().getUoid()).merge(project, ifcModelSet, new ModelHelper());
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
		IfcModelInterface ifcModel;
		if (ifcModelSet.size() > 1) {
			try {
				ifcModel = bimServer.getMergerFactory().createMerger(getDatabaseSession(), getAuthorization().getUoid()).merge(project, ifcModelSet, new ModelHelper());
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
	
	public int getProgress() {
		return progress;
	}
}