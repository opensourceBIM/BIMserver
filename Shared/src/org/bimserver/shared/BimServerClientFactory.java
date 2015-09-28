package org.bimserver.shared;

import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.exceptions.ServiceException;

public interface BimServerClientFactory {
	/**
	 * Create a new BimServerClient and authenticate with the given authentication
	 * 
	 * @param authenticationInfo Authentication to use
	 * @return A BimServerClient
	 * @throws ServiceException
	 * @throws ChannelConnectionException
	 */
	
	BimServerClientInterface create(AuthenticationInfo authenticationInfo) throws ServiceException, ChannelConnectionException;

	/**
	 * Create a new BimServerClient without authentication
	 * 
	 * @return A BimServerClient
	 * @throws ServiceException
	 * @throws ChannelConnectionException
	 */
	BimServerClientInterface create() throws ServiceException, ChannelConnectionException;
}