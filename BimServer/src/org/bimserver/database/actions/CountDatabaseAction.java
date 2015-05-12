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

import org.bimserver.SummaryMap;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.RevisionSummary;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class CountDatabaseAction extends BimDatabaseAction<Integer> {

	private Long roid;
	private String className;

	public CountDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, Long roid, String className, Authorization authorization) {
		super(databaseSession, accessMethod);
		this.roid = roid;
		this.className = className;
		
	}

	@Override
	public Integer execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Revision revision = getRevisionByRoid(roid);
		if (revision == null) {
			throw new UserException("Revision with roid " + roid + " not found");
		}
		Project project = revision.getProject();
		if (revision.getConcreteRevisions().size() == 1 && revision.getConcreteRevisions().get(0).getSummary() != null) {
			RevisionSummary summary = revision.getConcreteRevisions().get(0).getSummary();
			SummaryMap summaryMap = new SummaryMap(null, summary);
			return summaryMap.count(getDatabaseSession().getEClass(project.getSchema(), className));
		}
		return null;
	}
}
