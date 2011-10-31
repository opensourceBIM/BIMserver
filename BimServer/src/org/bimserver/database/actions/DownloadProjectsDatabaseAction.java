package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelChangeListener;
import org.bimserver.ifc.IfcModelSet;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.User;
import org.bimserver.plugins.guidanceproviders.GuidanceProvider;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.exceptions.UserException;

public class DownloadProjectsDatabaseAction extends BimDatabaseAction<IfcModelInterface> {

	private final long actingUoid;
	private final Set<Long> roids;
	private int progress;
	private final BimServer bimServer;
	private final GuidanceProvider guidanceProvider;

	public DownloadProjectsDatabaseAction(BimServer bimServer, BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, Set<Long> roids, long actingUoid, GuidanceProvider guidanceProvider) {
		super(bimDatabaseSession, accessMethod);
		this.bimServer = bimServer;
		this.roids = roids;
		this.actingUoid = actingUoid;
		this.guidanceProvider = guidanceProvider;
	}

	@Override
	public IfcModelInterface execute() throws UserException, BimDeadlockException, BimDatabaseException {
		User user = getUserByUoid(actingUoid);
		Project project = null;
		String projectName = "";
		IfcModelSet ifcModelSet = new IfcModelSet();
		long incrSize = 0;
		for (long roid : roids) {
			Revision revision = getVirtualRevision(roid);
			for (ConcreteRevision subRevision : revision.getConcreteRevisions()) {
				incrSize += subRevision.getSize();
			}
		}
		final long totalSize = incrSize;
		final AtomicLong total = new AtomicLong();

		for (long roid : roids) {
			Revision revision = getVirtualRevision(roid);
			project = revision.getProject();
			if (RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
				for (ConcreteRevision concreteRevision : revision.getConcreteRevisions()) {
					IfcModel subModel = new IfcModel();
					subModel.addChangeListener(new IfcModelChangeListener() {
						@Override
						public void objectAdded() {
							total.incrementAndGet();
							progress = Math.round(100L * total.get() / totalSize);
						}
					});
					getDatabaseSession().getMap(subModel, concreteRevision.getProject().getId(), concreteRevision.getId(), true, guidanceProvider);
					projectName += concreteRevision.getProject().getName() + "-";
					subModel.setDate(concreteRevision.getDate());
					ifcModelSet.add(subModel);
				}
			} else {
				throw new UserException("User has no rights on project " + project.getOid());
			}
		}
		IfcModelInterface ifcModel = bimServer.getMergerFactory().createMerger().merge(project, ifcModelSet, bimServer.getSettingsManager().getSettings().isIntelligentMerging());
		if (projectName.endsWith("-")) {
			projectName = projectName.substring(0, projectName.length() - 1);
		}
		return ifcModel;
	}

	public int getProgress() {
		return progress;
	}

}