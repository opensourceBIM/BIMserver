package org.bimserver;

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

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.models.store.ModelMergerPluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSettings;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.modelmerger.MergeException;
import org.bimserver.plugins.modelmerger.ModelMergerPlugin;

public class MergerFactory {
	private final BimServer bimServer;

	public MergerFactory(BimServer bimServer) {
		this.bimServer = bimServer;
	}

	public org.bimserver.plugins.modelmerger.ModelMerger createMerger(DatabaseSession databaseSession, Long currentUoid) throws MergeException, BimserverDatabaseException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			User user = databaseSession.get(StorePackage.eINSTANCE.getUser(), currentUoid, Query.getDefault());
			UserSettings userSettings = user.getUserSettings();

			ModelMergerPluginConfiguration modelMergerObject = userSettings.getDefaultModelMerger();
			if (modelMergerObject != null) {
				ModelMergerPlugin modelMergerPlugin = bimServer.getPluginManager().getModelMergerPlugin(modelMergerObject.getClassName(), true);
				if (modelMergerPlugin != null) {
					org.bimserver.plugins.modelmerger.ModelMerger modelMerger = modelMergerPlugin.createModelMerger(new PluginConfiguration(modelMergerObject.getSettings()));
					return modelMerger;
				} else {
					throw new MergeException("No Model Merger found " + modelMergerObject.getClassName());
				}
			} else {
				throw new MergeException("No configured Model Merger found");
			}
		} finally {
			session.close();
		}
	}
}