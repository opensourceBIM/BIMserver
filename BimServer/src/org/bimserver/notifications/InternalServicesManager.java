package org.bimserver.notifications;

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

import java.util.HashMap;
import java.util.Map;

import org.bimserver.BimServer;
import org.bimserver.client.SimpleTokenHolder;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.InternalServicePluginConfiguration;
import org.bimserver.models.store.Service;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.models.store.StorePackage;
import org.bimserver.plugins.NotificationsManagerInterface;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.plugins.services.NewRevisionHandler;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.ServiceMapInterface;
import org.bimserver.shared.TokenAuthentication;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.Bimsie1RemoteServiceInterfaceAdaptor;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1RemoteServiceInterface;
import org.bimserver.webservices.ServiceMap;
import org.eclipse.emf.ecore.EClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InternalServicesManager implements NotificationsManagerInterface {
	private static final Logger LOGGER = LoggerFactory.getLogger(InternalServicesManager.class);

	private final Map<String, ServiceDescriptor> internalServices = new HashMap<String, ServiceDescriptor>();
	private final Map<String, Bimsie1RemoteServiceInterface> internalRemoteServiceInterfaces = new HashMap<String, Bimsie1RemoteServiceInterface>();
	private BimServer bimServer;

	private String url;

	public InternalServicesManager(BimServer bimServer, String url) {
		this.bimServer = bimServer;
		this.url = url;
//		for (String s : internalServices.keySet()) {
//			internalServices.get(s).setUrl(url);
//		}
	}
	
	@Override
	public void register(ServiceDescriptor serviceDescriptor, Bimsie1RemoteServiceInterface remoteServiceInterface) {
		serviceDescriptor.setUrl(url);
		internalServices.put(serviceDescriptor.getName(), serviceDescriptor);
		internalRemoteServiceInterfaces.put(serviceDescriptor.getIdentifier(), remoteServiceInterface);
	}
	
	public ServiceDescriptor getInternalService(String serviceIdentifier) {
		return internalServices.get(serviceIdentifier);
	}
	
	public Map<String, ServiceDescriptor> getInternalServices() {
		return internalServices;
	}
	
	public Bimsie1RemoteServiceInterface getLocalRemoteServiceInterface(String serviceIdentifier) {
		return internalRemoteServiceInterfaces.get(serviceIdentifier);
	}
	
	@Override
	public void registerInternalNewRevisionHandler(ServiceDescriptor serviceDescriptor, final NewRevisionHandler newRevisionHandler) {
		register(serviceDescriptor, new Bimsie1RemoteServiceInterfaceAdaptor(){
			@Override
			public void newRevision(final Long poid, final Long roid, Long soid, String serviceIdentifier, String profileIdentifier, final String userToken, String token, String apiUrl) throws UserException, ServerException {
				ServiceMapInterface serviceMapInterface = new ServiceMap(bimServer, null, AccessMethod.JSON);
				serviceMapInterface.add(Bimsie1RemoteServiceInterface.class, internalRemoteServiceInterfaces.get(serviceIdentifier));
				final InternalChannel internalChannel = new InternalChannel(bimServer.getServiceFactory(), bimServer.getServicesMap());
				try {
					internalChannel.connect(new SimpleTokenHolder());
				} catch (ChannelConnectionException e) {
					LOGGER.error("", e);
				}
				try {
					DatabaseSession session = bimServer.getDatabase().createSession();
					try {
						long profileId = Long.parseLong(profileIdentifier);
						EClass eClassForOid = session.getEClassForOid(profileId);
						InternalServicePluginConfiguration internalServicePluginConfiguration = null;
						if (eClassForOid == StorePackage.eINSTANCE.getInternalServicePluginConfiguration()) {
							internalServicePluginConfiguration = session.get(profileId, Query.getDefault());
						} else if (eClassForOid == StorePackage.eINSTANCE.getService()) {
							Service service = session.get(profileId, Query.getDefault());
							internalServicePluginConfiguration = service.getInternalService();
						} else {
							throw new RuntimeException("Oid is neither an InternalServicePluginConfiguration nor a Server");
						}
						final SObjectType settings = bimServer.getSConverter().convertToSObject(internalServicePluginConfiguration.getSettings());
						
						final InternalServicePluginConfiguration finalInternalServicePluginConfiguration = internalServicePluginConfiguration;
						
						BimServerClientInterface bimServerClient = null;
						if (apiUrl == null) {
							bimServerClient = bimServer.getBimServerClientFactory().create(new TokenAuthentication(token));
						} else {
							bimServerClient = new JsonBimServerClientFactory(apiUrl).create(new TokenAuthentication(token));
						}
						
						final BimServerClientInterface finalClient = bimServerClient;
						
						// TODO this should somehow be managed...
						// This must be asynchronous because we don't want the BIMserver's notifications processor to wait for this to finish...
						new Thread(){
							@Override
							public void run() {
								try {
									newRevisionHandler.newRevision(finalClient, poid, roid, userToken, finalInternalServicePluginConfiguration.getOid(), settings);
								} catch (ServerException e) {
									LOGGER.error("", e);
								} catch (UserException e) {
									LOGGER.error("", e);
								}
							}
						}.start();
					} finally {
						session.close();
					}
				} catch (Exception e) {
					LOGGER.error("", e);
				}
			}
		});
	}
}