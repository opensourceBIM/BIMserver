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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.GeometryGeneratingException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OldQuery.Deep;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelChangeListener;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.IfcHeader;
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

public class DownloadProjectsDatabaseAction extends AbstractDownloadDatabaseAction<IfcModelInterface> {

	private final Set<Long> roids;
	private long serializerOid;

	public DownloadProjectsDatabaseAction(BimServer bimServer, DatabaseSession readOnlyDatabaseSession, AccessMethod accessMethod, Set<Long> roids, long serializerOid, Authorization authorization) {
		super(bimServer, readOnlyDatabaseSession, accessMethod, authorization);
		this.roids = roids;
		this.serializerOid = serializerOid;
	}

	@Override
	public IfcModelInterface execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		User user = getUserByUoid(getAuthorization().getUoid());
		Project project = null;
		String projectName = "";
		IfcModelSet ifcModelSet = new IfcModelSet();
		long incrSize = 0;
		for (long roid : roids) {
			Revision revision = getRevisionByRoid(roid);
			for (ConcreteRevision subRevision : revision.getConcreteRevisions()) {
				incrSize += subRevision.getSize();
			}
		}
		final long totalSize = incrSize;
		final AtomicLong total = new AtomicLong();

		PluginConfiguration serializerPluginConfiguration = getDatabaseSession().get(StorePackage.eINSTANCE.getPluginConfiguration(), serializerOid, OldQuery.getDefault());
		PackageMetaData lastPackageMetaData = null;
		
		IfcHeader ifcHeader = null;
		
		Map<Integer, Long> pidRoidMap = new HashMap<>();
		for (long roid : roids) {
			Revision revision = getRevisionByRoid(roid);
			project = revision.getProject();
			pidRoidMap.put(project.getId(), roid);
			if (getAuthorization().hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
				for (ConcreteRevision concreteRevision : revision.getConcreteRevisions()) {
					ifcHeader = concreteRevision.getIfcHeader();
					PackageMetaData packageMetaData = getBimServer().getMetaDataManager().getPackageMetaData(concreteRevision.getProject().getSchema());
					lastPackageMetaData = packageMetaData;
					IfcModel subModel = getDatabaseSession().createServerModel(packageMetaData, pidRoidMap);;
					int highestStopId = findHighestStopRid(project, concreteRevision);
					OldQuery query = new OldQuery(packageMetaData, concreteRevision.getProject().getId(), concreteRevision.getId(), revision.getOid(), Deep.YES, highestStopId);
					subModel.addChangeListener(new IfcModelChangeListener() {
						@Override
						public void objectAdded(IdEObject idEObject) {
							total.incrementAndGet();
							if (totalSize == 0) {
								setProgress("Preparing download...", 0);
							} else {
								setProgress("Preparing download...", (int) Math.round(100.0 * total.get() / totalSize));
							}
						}
					});
					query.updateOidCounters(concreteRevision, getDatabaseSession());
					getDatabaseSession().getMap(subModel, query);
					projectName += concreteRevision.getProject().getName() + "-";
					subModel.getModelMetaData().setDate(concreteRevision.getDate());

					try {
						checkGeometry(serializerPluginConfiguration, getBimServer().getPluginManager(), subModel, project, concreteRevision, revision);
					} catch (GeometryGeneratingException e) {
						throw new UserException(e);
					}
					
					ifcModelSet.add(subModel);
				}
			} else {
				throw new UserException("User has no rights on project " + project.getOid());
			}
		}
		IfcModelInterface ifcModel = getDatabaseSession().createServerModel(lastPackageMetaData, pidRoidMap);
		if (ifcModelSet.size() == 1) {
			ifcModel = ifcModelSet.iterator().next();
		} else {
			try {
				ifcModel = getBimServer().getMergerFactory().createMerger(getDatabaseSession(), getAuthorization().getUoid()).merge(project, ifcModelSet, new ModelHelper(getBimServer().getMetaDataManager(), ifcModel));
			} catch (MergeException e) {
				throw new UserException(e);
			}
		}
		if (ifcHeader != null) {
			ifcHeader.load();
			ifcModel.getModelMetaData().setIfcHeader(ifcHeader);
		}
		if (projectName.endsWith("-")) {
			projectName = projectName.substring(0, projectName.length() - 1);
		}
		ifcModel.getModelMetaData().setName(projectName);
		return ifcModel;
	}
}