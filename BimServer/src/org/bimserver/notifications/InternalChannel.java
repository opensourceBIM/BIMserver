package org.bimserver.notifications;

import org.bimserver.client.Channel;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.ServiceFactory;
import org.bimserver.shared.TokenHolder;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.meta.SServicesMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InternalChannel extends Channel {

	private static final Logger LOGGER = LoggerFactory.getLogger(InternalChannel.class);
	private ServiceFactory serviceFactory;
	private SServicesMap sServicesMap;

	public InternalChannel(ServiceFactory serviceFactory, SServicesMap sServicesMap) {
		super(null);
		this.serviceFactory = serviceFactory;
		this.sServicesMap = sServicesMap;
	}
	
	@Override
	public void disconnect() {
	}

	@Override
	public void connect(TokenHolder tokenHolder) throws ChannelConnectionException {
		for (Class<? extends PublicInterface> interface1 : sServicesMap.getInterfaceClasses()) {
			try {
				add(interface1.getName(), serviceFactory.get(AccessMethod.INTERNAL).get(interface1));
			} catch (UserException e) {
				LOGGER.error("", e);
			}
		}
	}
}