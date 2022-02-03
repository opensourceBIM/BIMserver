package org.bimserver.client.json;

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

import org.bimserver.client.AbstractBimServerClientFactory;
import org.bimserver.client.BimServerClient;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.meta.SServicesMap;
import org.bimserver.shared.reflector.RealtimeReflectorFactoryBuilder;
import org.bimserver.shared.reflector.ReflectorFactory;
import java.net.URL;

public class JsonBimServerClientFactory extends AbstractBimServerClientFactory {

	private String address;
	private JsonSocketReflectorFactory jsonSocketReflectorFactory;
	private ReflectorFactory reflectorFactory;

	public JsonBimServerClientFactory(String address, SServicesMap servicesMap, JsonSocketReflectorFactory jsonSocketReflectorFactory, ReflectorFactory reflectorFactory, MetaDataManager metaDataManager) {
		super(servicesMap, metaDataManager);
		this.address = address;
		this.jsonSocketReflectorFactory = jsonSocketReflectorFactory;
		this.reflectorFactory = reflectorFactory;
	}

	/**
	 * Create a new JsonBimServerClientFactory
	 * 
	 * @param metaDataManager A MetaDataManager that can be shared over multiple factories
	 * @param address Address of the remote server, must have the format "protocol://address:port[/contextpath]", for example "http://localhost:8080"
	 * @throws BimServerClientException 
	 */

	public JsonBimServerClientFactory(MetaDataManager metaDataManager, String address, URL trustedCertificate) throws BimServerClientException {
		super(metaDataManager);
		this.address = address;
		this.jsonSocketReflectorFactory = new JsonSocketReflectorFactory(getServicesMap(), getHttpClient());
		RealtimeReflectorFactoryBuilder factoryBuilder = new RealtimeReflectorFactoryBuilder(getServicesMap());
		reflectorFactory = factoryBuilder.newReflectorFactory();
		getServicesMap().setReflectorFactory(reflectorFactory);
	}

	public JsonBimServerClientFactory(String address) throws BimServerClientException {
		this(null, address);
	}

	public JsonBimServerClientFactory(String address, URL trustedCertificate) throws BimServerClientException {
		this(null, address, trustedCertificate);
	}

	public JsonBimServerClientFactory(MetaDataManager metaDataManager, String address) throws BimServerClientException {
		this(metaDataManager, address, null);
	}

	@Override
	public BimServerClient create(AuthenticationInfo authenticationInfo) throws ServiceException, ChannelConnectionException {
		JsonChannel jsonChannel = new JsonChannel(getHttpClient(), reflectorFactory, jsonSocketReflectorFactory, address + "/json", getServicesMap());
		BimServerClient bimServerClient = new BimServerClient(this.getMetaDataManager(), address, getServicesMap(), jsonChannel);
		jsonChannel.connect(bimServerClient);
		bimServerClient.setAuthentication(authenticationInfo);
		bimServerClient.connect();
		return bimServerClient;
	}
}