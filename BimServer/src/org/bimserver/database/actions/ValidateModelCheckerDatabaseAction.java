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

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ModelCheckerInstance;
import org.bimserver.plugins.modelchecker.ModelCheckerPlugin;
import org.bimserver.shared.exceptions.UserException;

public class ValidateModelCheckerDatabaseAction extends BimDatabaseAction<Void> {

	private BimServer bimServer;
	private long modelCheckerInstanceOid;

	public ValidateModelCheckerDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long modelCheckerInstanceOid) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.modelCheckerInstanceOid = modelCheckerInstanceOid;
	}
	
	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		ModelCheckerInstance modelCheckerInstance = getDatabaseSession().get(modelCheckerInstanceOid, OldQuery.getDefault());
		ModelCheckerPlugin modelCheckerPlugin = bimServer.getPluginManager().getModelCheckerPlugin(modelCheckerInstance.getModelCheckerPluginClassName(), true);
		if (modelCheckerPlugin == null) {
			throw new UserException("Model Checker Plugin \"" + modelCheckerInstance.getModelCheckerPluginClassName() + "\" not found/enabled");
		}
//		ModelChecker modelChecker = modelCheckerPlugin.createModelChecker(null);
//		try {
//			byte[] result = modelChecker.compile(modelCheckerInstance.getCode());
			modelCheckerInstance.setValid(true);
//			modelCheckerInstance.setCompiled(result);
			getDatabaseSession().store(modelCheckerInstance);
//		} catch (ModelCheckException e) {
//			throw new UserException(e);
//		}
		return null;
	}
}