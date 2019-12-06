package org.bimserver.notifications;

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

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.client.SimpleTokenHolder;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.client.json.JsonSocketReflectorFactory;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OperationType;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.InternalServicePluginConfiguration;
import org.bimserver.models.store.Service;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.models.store.StorePackage;
import org.bimserver.plugins.NotificationsManagerInterface;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.plugins.services.NewExtendedDataOnProjectHandler;
import org.bimserver.plugins.services.NewExtendedDataOnRevisionHandler;
import org.bimserver.plugins.services.NewRevisionHandler;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.ServiceMapInterface;
import org.bimserver.shared.TokenAuthentication;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.RemoteServiceInterface;
import org.bimserver.shared.interfaces.RemoteServiceInterfaceAdaptor;
import org.bimserver.webservices.ServiceMap;
import org.eclipse.emf.ecore.EClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InternalServicesManager implements NotificationsManagerInterface {
	private static final Logger LOGGER = LoggerFactory.getLogger(InternalServicesManager.class);

	private final Map<Long, Map<String, ServiceDescriptor>> uoidToInternalServices = new HashMap<Long, Map<String, ServiceDescriptor>>();
	private final Map<String, RemoteServiceInterface> internalRemoteServiceInterfaces = new HashMap<String, RemoteServiceInterface>();
	private final Map<String, BimServerClientFactory> factories = new HashMap<>();
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
	public synchronized void register(long uoid, ServiceDescriptor serviceDescriptor, RemoteServiceInterface remoteServiceInterface) {
		serviceDescriptor.setUrl(url);
		Map<String, ServiceDescriptor> map = uoidToInternalServices.get(uoid);
		if (map == null) {
			map = new HashMap<String, ServiceDescriptor>();
			uoidToInternalServices.put(uoid, map);
		}
		map.put(serviceDescriptor.getIdentifier(), serviceDescriptor);
		internalRemoteServiceInterfaces.put(serviceDescriptor.getIdentifier(), remoteServiceInterface);
	}
	
	public ServiceDescriptor getInternalService(Long uoid, String serviceIdentifier) {
		// Temporary hack, should be used based
		for (Entry<Long, Map<String, ServiceDescriptor>> entry : uoidToInternalServices.entrySet()) {
			if (entry.getValue().containsKey(serviceIdentifier)) {
				return entry.getValue().get(serviceIdentifier);
			}
		}
//		Map<String, ServiceDescriptor> map = internalServices.get(uoid);
//		if (map != null) {
//			return map.get(serviceIdentifier);
//		}
		return null;
	}
	
	public Map<String, ServiceDescriptor> getInternalServices(long uoid) {
		return uoidToInternalServices.get(uoid);
	}
	
	public RemoteServiceInterface getLocalRemoteServiceInterface(String serviceIdentifier) {
		return internalRemoteServiceInterfaces.get(serviceIdentifier);
	}
	
	@Override
	public void registerInternalNewExtendedDataOnRevisionHandler(long uoid, ServiceDescriptor serviceDescriptor, final NewExtendedDataOnRevisionHandler newExtendedDataHandler) {
		register(uoid, serviceDescriptor, new RemoteServiceInterfaceAdaptor(){
			@Override
			public void newExtendedDataOnRevision(Long poid, Long roid, Long edid, Long soid, String serviceIdentifier, String profileIdentifier, String userToken, String token, String apiUrl)
					throws UserException, ServerException {
				final P p = getBimServerClient(serviceIdentifier, profileIdentifier, apiUrl, token);
				newExtendedDataHandler.newExtendedDataOnRevision(p.client, poid, roid, edid, userToken, soid, p.settings);
			}
		});
	}
	
	@Override
	public void registerInternalNewExtendedDataOnProjectHandler(long uoid, ServiceDescriptor serviceDescriptor, final NewExtendedDataOnProjectHandler newExtendedDataHandler) {
		register(uoid, serviceDescriptor, new RemoteServiceInterfaceAdaptor(){
			@Override
			public void newExtendedDataOnProject(Long poid, Long edid, Long soid, String serviceIdentifier, String profileIdentifier, String userToken, String token, String apiUrl)
					throws UserException, ServerException {
				final P p = getBimServerClient(serviceIdentifier, profileIdentifier, apiUrl, token);
				newExtendedDataHandler.newExtendedDataOnProject(p.client, poid, edid, userToken, soid, p.settings);
			}
		});
	}
	
	private class P {
		public BimServerClientInterface client;
		public SObjectType settings;
	}
	
	private P getBimServerClient(String serviceIdentifier, String profileIdentifier, String apiUrl, String token) {
		ServiceMapInterface serviceMapInterface = new ServiceMap(bimServer, null, AccessMethod.JSON, null);
		serviceMapInterface.add(RemoteServiceInterface.class, internalRemoteServiceInterfaces.get(serviceIdentifier));
		P p = new P();
		final InternalChannel internalChannel = new InternalChannel(bimServer.getServiceFactory(), bimServer.getServicesMap());
		try {
			internalChannel.connect(new SimpleTokenHolder());
		} catch (ChannelConnectionException e) {
			LOGGER.error("", e);
		}
		try {
			DatabaseSession session = bimServer.getDatabase().createSession(OperationType.READ_ONLY);
			try {
				long profileId = Long.parseLong(profileIdentifier);
				EClass eClassForOid = session.getEClassForOid(profileId);
				InternalServicePluginConfiguration internalServicePluginConfiguration = null;
				if (eClassForOid == StorePackage.eINSTANCE.getInternalServicePluginConfiguration()) {
					internalServicePluginConfiguration = session.get(profileId, OldQuery.getDefault());
				} else if (eClassForOid == StorePackage.eINSTANCE.getService()) {
					Service service = session.get(profileId, OldQuery.getDefault());
					internalServicePluginConfiguration = service.getInternalService();
				} else {
					throw new RuntimeException("Oid is neither an InternalServicePluginConfiguration nor a Service");
				}
				final SObjectType settings = bimServer.getSConverter().convertToSObject(internalServicePluginConfiguration.getSettings());
				
				BimServerClientInterface bimServerClient = null;
				BimServerClientFactory factory = null;
				if (apiUrl == null) {
					factory = bimServer.getBimServerClientFactory();
				} else {
					if (factories.containsKey(apiUrl)) {
						factory = factories.get(apiUrl);
					} else {
						factory = new JsonBimServerClientFactory(apiUrl, bimServer.getServicesMap(), new JsonSocketReflectorFactory(bimServer.getServicesMap()), bimServer.getReflectorFactory(), bimServer.getMetaDataManager());
						factories.put(apiUrl, factory);
					}
				}
				bimServerClient = factory.create(new TokenAuthentication(token));
				
				p.client = bimServerClient;
				p.settings = settings;
				
				return p;
			} catch (BimserverDatabaseException e) {
				LOGGER.error("", e);
			} catch (ServiceException e) {
				LOGGER.error("", e);
			} catch (ChannelConnectionException e) {
				LOGGER.error("", e);
			} finally {
				session.close();
			}
		} finally {
		}
		return null;
	}
	
	@Override
	public void registerInternalNewRevisionHandler(long uoid, ServiceDescriptor serviceDescriptor, final NewRevisionHandler newRevisionHandler) {
		register(uoid, serviceDescriptor, new RemoteServiceInterfaceAdaptor(){
			@Override
			public void newRevision(final Long poid, final Long roid, final Long soid, String serviceIdentifier, String profileIdentifier, final String userToken, String token, String apiUrl) throws UserException, ServerException {
				final P p = getBimServerClient(serviceIdentifier, profileIdentifier, apiUrl, token);
				
				// TODO this should somehow be managed...
				// This must be asynchronous because we don't want the BIMserver's notifications processor to wait for this to finish...
				new Thread(){
					@Override
					public void run() {
						try {
							newRevisionHandler.newRevision(p.client, poid, roid, userToken, soid, p.settings);
						} catch (ServerException e) {
							LOGGER.error("", e);
						} catch (UserException e) {
							LOGGER.error("", e);
						}
					}
				}.start();
			}
		});
	}
	
	@Override
	public void unregisterInternalNewRevisionHandler(long uoid, String identifier) {
		Map<String, ServiceDescriptor> map = uoidToInternalServices.get(uoid);
		if (map != null) {
			map.remove(identifier);
		}
		internalRemoteServiceInterfaces.remove(identifier);
	}
}