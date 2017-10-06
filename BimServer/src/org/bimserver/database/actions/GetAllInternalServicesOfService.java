package org.bimserver.database.actions;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.InternalServicePluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class GetAllInternalServicesOfService extends BimDatabaseAction<Set<InternalServicePluginConfiguration>> {

	private String serviceName;
	private SUser sUser;

	public GetAllInternalServicesOfService(DatabaseSession session, AccessMethod internalAccessMethod, BimServer bimServer, SUser sUser, String serviceName) {
		super(session, internalAccessMethod);
		this.sUser = sUser;
		this.serviceName = serviceName;
	}

	@Override
	public Set<InternalServicePluginConfiguration> execute()
			throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		Set<InternalServicePluginConfiguration> configs = new HashSet<>();
		// TODO use indices
		for (InternalServicePluginConfiguration internalServicePluginConfiguration : getDatabaseSession().getAllOfType(StorePackage.eINSTANCE.getInternalServicePluginConfiguration(), InternalServicePluginConfiguration.class, OldQuery.getDefault())) {
			if (internalServicePluginConfiguration.getPluginDescriptor().getName().equals(serviceName) && internalServicePluginConfiguration.getUserSettings().getOid() == getUserByUoid(sUser.getOid()).getUserSettings().getOid()) {
				configs.add(internalServicePluginConfiguration);
			}
		}
		return configs;
	}
}
