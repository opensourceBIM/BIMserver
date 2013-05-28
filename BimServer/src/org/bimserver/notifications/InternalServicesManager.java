package org.bimserver.notifications;

import java.util.HashMap;
import java.util.Map;

import org.bimserver.BimServer;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.ChannelConnectionException;
import org.bimserver.client.SimpleTokenHolder;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SService;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.plugins.NotificationsManagerInterface;
import org.bimserver.plugins.services.NewRevisionHandler;
import org.bimserver.shared.ServiceMapInterface;
import org.bimserver.shared.TokenAuthentication;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.Bimsie1RemoteServiceInterfaceAdaptor;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1RemoteServiceInterface;
import org.bimserver.webservices.ServiceMap;
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
			public void newRevision(final Long poid, final Long roid, Long soid, String serviceIdentifier, String profileIdentifier, String token, String apiUrl) throws UserException, ServerException {
				ServiceMapInterface serviceMapInterface = new ServiceMap(bimServer, null, AccessMethod.JSON);
				serviceMapInterface.add(Bimsie1RemoteServiceInterface.class, internalRemoteServiceInterfaces.get(serviceIdentifier));
				final InternalChannel internalChannel = new InternalChannel(bimServer.getServiceFactory(), bimServer.getServicesMap());
				try {
					internalChannel.connect(new SimpleTokenHolder());
				} catch (ChannelConnectionException e2) {
					e2.printStackTrace();
				}
				try {
					final ServiceInterface serviceInterface = bimServer.getService(ServiceInterface.class);
					final SService service = serviceInterface.getService(Long.parseLong(profileIdentifier));
					final SObjectType settings = internalChannel.getPluginInterface().getPluginSettings(service.getInternalServiceId());

					final BimServerClient bimServerClient = bimServer.getBimServerClientFactory().create(new TokenAuthentication(token));
					
					// TODO this should somehow be managed...
					// This must be asynchronous because we don't want the BIMserver's notifications processor to wait for this to finish...
					new Thread(){
						@Override
						public void run() {
							try {
								newRevisionHandler.newRevision(bimServerClient, poid, roid, service.getOid(), settings);
							} catch (ServerException e) {
								LOGGER.error("", e);
							} catch (UserException e) {
								LOGGER.error("", e);
							}
						}
					}.start();
				} catch (Exception e) {
					LOGGER.error("", e);
				}
			}
		});
	}
	
}
