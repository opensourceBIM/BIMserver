package org.bimserver.plugins.services;

import org.bimserver.bimbots.BimBotsServiceInterface;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.plugins.services.AbstractService.RunningService;

public abstract class BimBotAbstractService extends AbstractService implements BimBotsServiceInterface {

	@Override
	public void newRevision(RunningService runningService, BimServerClientInterface bimServerClientInterface, long poid, long roid, String userToken, long soid, SObjectType settings) throws Exception {
	}

	@Override
	public void addRequiredRights(ServiceDescriptor serviceDescriptor) {
	}
}
