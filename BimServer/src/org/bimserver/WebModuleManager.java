package org.bimserver;

import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.actions.ServerSettingsSetter;
import org.bimserver.database.actions.SetServerSettingDatabaseAction;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ServerSettings;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.WebModulePluginConfiguration;
import org.bimserver.plugins.web.WebModulePlugin;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class WebModuleManager {

	private BimServer bimServer;

	public WebModuleManager(BimServer bimServer) {
		this.bimServer = bimServer;
	}
	
	public void setDefault(Long oid) throws BimserverDatabaseException, UserException, ServerException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		try {
			final WebModulePluginConfiguration defaultWebModule = session.get(StorePackage.eINSTANCE.getWebModulePluginConfiguration(), oid, Query.getDefault());
			bimServer.setDefaultWebModule((WebModulePlugin) bimServer.getPluginManager().getPlugin(defaultWebModule.getPluginDescriptor().getPluginClassName(), true));
			SetServerSettingDatabaseAction action = new SetServerSettingDatabaseAction(bimServer, session, AccessMethod.INTERNAL, new ServerSettingsSetter(){
				@Override
				public void set(ServerSettings serverSettings) {
					serverSettings.setWebModule(defaultWebModule);
				}});
			session.executeAndCommitAction(action);
		} finally {
			session.close();
		}

	}
}
