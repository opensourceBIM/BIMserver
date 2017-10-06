package org.bimserver.database.actions;

import java.util.ArrayList;
import java.util.List;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.PluginDescriptor;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class ListPluginsInBundle extends BimDatabaseAction<List<PluginDescriptor>> {

	private long pluginBundleVersionOid;

	public ListPluginsInBundle(DatabaseSession session, AccessMethod accessMethod, BimServer bimServer, Long pluginBundleVersionOid) {
		super(session, accessMethod);
		this.pluginBundleVersionOid = pluginBundleVersionOid;
	}

	@Override
	public List<PluginDescriptor> execute()
			throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		List<PluginDescriptor> list = new ArrayList<>();
		for (PluginDescriptor pluginDescriptor : getDatabaseSession().getAllOfType(StorePackage.eINSTANCE.getPluginDescriptor(), PluginDescriptor.class, OldQuery.getDefault())) {
			if (pluginDescriptor.getPluginBundleVersion().getOid() == pluginBundleVersionOid) {
				list.add(pluginDescriptor);
			}
		}
		return list;
	}
}