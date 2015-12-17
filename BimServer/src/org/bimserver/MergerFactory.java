package org.bimserver;

import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
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
			User user = databaseSession.get(StorePackage.eINSTANCE.getUser(), currentUoid, OldQuery.getDefault());
			UserSettings userSettings = user.getUserSettings();

			ModelMergerPluginConfiguration modelMergerObject = userSettings.getDefaultModelMerger();
			if (modelMergerObject != null) {
				ModelMergerPlugin modelMergerPlugin = bimServer.getPluginManager().getModelMergerPlugin(modelMergerObject.getPluginDescriptor().getPluginClassName(), true);
				if (modelMergerPlugin != null) {
					org.bimserver.plugins.modelmerger.ModelMerger modelMerger = modelMergerPlugin.createModelMerger(new PluginConfiguration(modelMergerObject.getSettings()));
					return modelMerger;
				} else {
					throw new MergeException("No Model Merger found " + modelMergerObject.getPluginDescriptor().getPluginClassName());
				}
			} else {
				throw new MergeException("No configured Model Merger found");
			}
		} finally {
			session.close();
		}
	}
}