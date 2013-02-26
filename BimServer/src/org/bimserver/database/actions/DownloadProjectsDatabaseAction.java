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

import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.Query.Deep;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelChangeListener;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.SerializerPluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.plugins.IfcModelSet;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.Reporter;
import org.bimserver.plugins.modelmerger.MergeException;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class DownloadProjectsDatabaseAction extends AbstractDownloadDatabaseAction<IfcModelInterface> {

	private final Set<Long> roids;
	private int progress;
	private final BimServer bimServer;
	private final ObjectIDM objectIDM;
	private long serializerOid;

	public DownloadProjectsDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, Set<Long> roids, long serializerOid, Authorization authorization, ObjectIDM objectIDM, Reporter reporter) {
		super(databaseSession, accessMethod, authorization);
		this.bimServer = bimServer;
		this.roids = roids;
		this.serializerOid = serializerOid;
		this.objectIDM = objectIDM;
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

		SerializerPluginConfiguration serializerPluginConfiguration = getDatabaseSession().get(StorePackage.eINSTANCE.getSerializerPluginConfiguration(), serializerOid, Query.getDefault());

		for (long roid : roids) {
			Revision revision = getRevisionByRoid(roid);
			project = revision.getProject();
			if (getAuthorization().hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
				for (ConcreteRevision concreteRevision : revision.getConcreteRevisions()) {
					IfcModel subModel = new IfcModel();
					int highestStopId = findHighestStopRid(project, concreteRevision);
					Query query = new Query(concreteRevision.getProject().getId(), concreteRevision.getId(), objectIDM, Deep.YES, highestStopId);
					subModel.addChangeListener(new IfcModelChangeListener() {
						@Override
						public void objectAdded() {
							total.incrementAndGet();
							progress = Math.round(100L * total.get() / totalSize);
						}
					});
					getDatabaseSession().getMap(subModel, query);
					projectName += concreteRevision.getProject().getName() + "-";
					subModel.getModelMetaData().setDate(concreteRevision.getDate());

					checkGeometry(serializerPluginConfiguration, bimServer.getPluginManager(), subModel, project, concreteRevision, revision);
					
					ifcModelSet.add(subModel);
				}
			} else {
				throw new UserException("User has no rights on project " + project.getOid());
			}
		}
		IfcModelInterface ifcModel;
		try {
			ifcModel = bimServer.getMergerFactory().createMerger(getDatabaseSession(), getAuthorization().getUoid()).merge(project, ifcModelSet, new ModelHelper());
		} catch (MergeException e) {
			throw new UserException(e);
		}
		if (projectName.endsWith("-")) {
			projectName = projectName.substring(0, projectName.length() - 1);
		}
		ifcModel.getModelMetaData().setName(projectName);
		return ifcModel;
	}

	public int getProgress() {
		return progress;
	}

}