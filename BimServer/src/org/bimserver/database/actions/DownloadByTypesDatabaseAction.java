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

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.GeometryGeneratingException;
import org.bimserver.ServerIfcModel;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.Query.Deep;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.PluginConfiguration;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.plugins.IfcModelSet;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.modelmerger.MergeException;
import org.bimserver.plugins.objectidms.HideAllInversesObjectIDM;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.plugins.objectidms.StructuralFeatureIdentifier;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.CollectionUtils;
import org.bimserver.webservices.authorization.Authorization;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;

public class DownloadByTypesDatabaseAction extends AbstractDownloadDatabaseAction<IfcModelInterface> {

	private final Set<String> classNames;
	private final Set<Long> roids;
	private int progress;
	private final ObjectIDM objectIDM;
	private final boolean includeAllSubtypes;
	private long serializerOid;
	private boolean useObjectIDM;
	private Deep deep;
	private String schema;

	public DownloadByTypesDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, Set<Long> roids, String schema, Set<String> classNames, long serializerOid, boolean includeAllSubtypes, boolean useObjectIDM, Authorization authorization, ObjectIDM objectIDM, Deep deep) {
		super(bimServer, databaseSession, accessMethod, authorization);
		this.roids = roids;
		this.schema = schema;
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
		PluginConfiguration serializerPluginConfiguration = getDatabaseSession().get(StorePackage.eINSTANCE.getPluginConfiguration(), serializerOid, Query.getDefault());
		for (String className : classNames) {
			eClasses.add(getDatabaseSession().getEClassForName(schema, className));
			if (includeAllSubtypes) {
				EClassifier eClassifier = Ifc2x3tc1Package.eINSTANCE.getEClassifier(className);
				if (eClassifier == null) {
					throw new UserException("Class " + className + " not found");
				}
				eClasses.addAll(getBimServer().getDatabase().getMetaDataManager().getPackageMetaData(schema).getAllSubClasses((EClass)eClassifier));
			}
		}
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
			for (ConcreteRevision concreteRevision : virtualRevision.getConcreteRevisions()) {
				PackageMetaData packageMetaData = getBimServer().getMetaDataManager().getPackageMetaData(concreteRevision.getProject().getSchema());
				try {
					HideAllInversesObjectIDM hideAllInversesObjectIDM = new HideAllInversesObjectIDM(CollectionUtils.singleSet(Ifc2x3tc1Package.eINSTANCE), getBimServer().getPluginManager().requireSchemaDefinition(schema));
					
					// This hack makes sure the JsonGeometrySerializer can look at the styles, probably more subtypes of getIfcRepresentationItem should be added (not ignored), also this code should not be here at all...
					hideAllInversesObjectIDM.removeFromGeneralIgnoreSet(new StructuralFeatureIdentifier(Ifc2x3tc1Package.eINSTANCE.getIfcRepresentationItem().getName(), Ifc2x3tc1Package.eINSTANCE.getIfcRepresentationItem_StyledByItem().getName()));
					hideAllInversesObjectIDM.removeFromGeneralIgnoreSet(new StructuralFeatureIdentifier(Ifc2x3tc1Package.eINSTANCE.getIfcExtrudedAreaSolid().getName(), Ifc2x3tc1Package.eINSTANCE.getIfcRepresentationItem_StyledByItem().getName()));
					hideAllInversesObjectIDM.removeFromGeneralIgnoreSet(Ifc2x3tc1Package.eINSTANCE.getIfcObject_IsDefinedBy());
					hideAllInversesObjectIDM.removeFromGeneralIgnoreSet(Ifc2x3tc1Package.eINSTANCE.getIfcObjectDefinition_IsDecomposedBy());
					hideAllInversesObjectIDM.removeFromGeneralIgnoreSet(Ifc2x3tc1Package.eINSTANCE.getIfcOpeningElement_HasFillings());
					hideAllInversesObjectIDM.removeFromGeneralIgnoreSet(Ifc2x3tc1Package.eINSTANCE.getIfcObjectDefinition_HasAssociations());
					hideAllInversesObjectIDM.removeFromGeneralIgnoreSet(Ifc2x3tc1Package.eINSTANCE.getIfcGroup_IsGroupedBy());
					
					int highestStopId = findHighestStopRid(project, concreteRevision);
					IfcModelInterface subModel = getDatabaseSession().getAllOfTypes(eClasses, new Query(packageMetaData, concreteRevision.getProject().getId(), concreteRevision.getId(), virtualRevision.getOid(), useObjectIDM ? objectIDM : hideAllInversesObjectIDM, deep, highestStopId));
					size += subModel.size();
					subModel.getModelMetaData().setDate(concreteRevision.getDate());
					checkGeometry(serializerPluginConfiguration, getBimServer().getPluginManager(), subModel, project, concreteRevision, virtualRevision);
					ifcModelSet.add(subModel);
					
					lastPackageMetaData = packageMetaData;
				} catch (PluginException e) {
					throw new UserException(e);
				} catch (GeometryGeneratingException e) {
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
		IfcModelInterface ifcModel = new ServerIfcModel(lastPackageMetaData, pidRoidMap, getDatabaseSession());
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
	
	public int getProgress() {
		return progress;
	}
}
