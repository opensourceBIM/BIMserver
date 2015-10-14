package org.bimserver.plugins.services;

import org.bimserver.models.store.ServiceDescriptor;

public abstract class AbstractModifyRevisionService extends AbstractService {

	public AbstractModifyRevisionService(String name, String description) {
		super(name, description);
	}
	
	@Override
	public void addRequiredRights(ServiceDescriptor serviceDescriptor) {
		serviceDescriptor.setWriteRevision(true);
	}
}
