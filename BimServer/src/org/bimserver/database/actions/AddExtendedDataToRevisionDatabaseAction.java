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

import java.util.Date;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.PostCommitAction;
import org.bimserver.interfaces.SConverter;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.ExtendedDataAddedToRevision;
import org.bimserver.models.store.ExtendedData;
import org.bimserver.models.store.File;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.User;
import org.bimserver.notifications.NewExtendedDataOnRevisionNotification;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class AddExtendedDataToRevisionDatabaseAction extends AddDatabaseAction<ExtendedData> {

	private final Long roid;
	private Authorization authorization;
	private BimServer bimServer;

	public AddExtendedDataToRevisionDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, Long roid, Authorization authorization, ExtendedData extendedData) {
		super(databaseSession, accessMethod, extendedData);
		this.bimServer = bimServer;
		this.roid = roid;
		this.authorization = authorization;
	}
	
	@Override
	public Long execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		authorization.canWriteExtendedData(roid);
		User actingUser = getUserByUoid(authorization.getUoid());
		getIdEObject().setUser(actingUser);
		getIdEObject().setAdded(new Date());
		File file = getIdEObject().getFile();
		getIdEObject().setSize(file.getData().length);
		super.execute();
		Revision revision = getRevisionByRoid(roid);
		if (revision == null) {
			throw new UserException("Revision with roid " + roid + " not found");
		}
		revision.getExtendedData().add(getIdEObject());
		getDatabaseSession().store(revision);
		getIdEObject().setProject(revision.getProject());
		getIdEObject().setRevision(revision);
		
		if (getIdEObject().getSchema() != null) {
			getDatabaseSession().store(getIdEObject().getSchema());
		}

		final ExtendedDataAddedToRevision extendedDataAddedToRevision = getDatabaseSession().create(ExtendedDataAddedToRevision.class);
		extendedDataAddedToRevision.setAccessMethod(getAccessMethod());
		extendedDataAddedToRevision.setDate(new Date());
		extendedDataAddedToRevision.setExecutor(actingUser);
		extendedDataAddedToRevision.setExtendedData(getIdEObject());
		extendedDataAddedToRevision.setRevision(revision);
		final long poid = revision.getProject().getOid();
		final long roid = revision.getOid();
		getDatabaseSession().addPostCommitAction(new PostCommitAction() {
			@Override
			public void execute() throws UserException {
				bimServer.getNotificationsManager().notify(new NewExtendedDataOnRevisionNotification(bimServer, getIdEObject().getOid(), poid, roid, -1));
				bimServer.getNotificationsManager().notify(new SConverter().convertToSObject(extendedDataAddedToRevision));
			}
		});
		
		return null;
	}
}