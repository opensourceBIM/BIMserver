package org.bimserver.client;

import java.io.IOException;
import java.nio.file.Files;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.interfaces.SServiceInterfaceService;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.interfaces.AdminInterface;
import org.bimserver.shared.interfaces.AuthInterface;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.bimserver.shared.interfaces.MetaInterface;
import org.bimserver.shared.interfaces.NewServicesInterface;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.interfaces.NotificationRegistryInterface;
import org.bimserver.shared.interfaces.OAuthInterface;
import org.bimserver.shared.interfaces.PluginInterface;
import org.bimserver.shared.interfaces.RemoteServiceInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.interfaces.SettingsInterface;
import org.bimserver.shared.meta.SService;
import org.bimserver.shared.meta.SServicesMap;

public abstract class AbstractBimServerClientFactory implements BimServerClientFactory {

	private final SServicesMap servicesMap;
	private final MetaDataManager metaDataManager;
	private CloseableHttpClient httpClient;

	public AbstractBimServerClientFactory(SServicesMap servicesMap, MetaDataManager metaDataManager) {
		this.servicesMap = servicesMap;
		if (metaDataManager == null) {
			throw new IllegalArgumentException("MetaDataManager cannot be null");
		}
		this.metaDataManager = metaDataManager;
		initHttpClient();
	}

	public AbstractBimServerClientFactory(MetaDataManager metaDataManager) throws BimServerClientException {
		if (metaDataManager == null) {
			try {
				this.metaDataManager = new MetaDataManager(Files.createTempDirectory("bimserver-tmp"));
				this.metaDataManager.init();
			} catch (IOException e) {
				throw new BimServerClientException("Problem creating tmp directory");
			}
//			throw new IllegalArgumentException("MetaDataManager cannot be null");
		} else {
			this.metaDataManager = metaDataManager;
		}
		this.servicesMap = new SServicesMap();
//		servicesMap.setReflectorFactory(new ReflectorFactoryImpl1());
		SService serviceInterface = new SServiceInterfaceService(servicesMap, null, ServiceInterface.class);
		addService(serviceInterface);
		addService(new SService(servicesMap, null, MetaInterface.class));
		addService(new SService(servicesMap, null, AdminInterface.class));
		addService(new SService(servicesMap, null, AuthInterface.class));
		addService(new SService(servicesMap, null, NewServicesInterface.class));
		addService(new SService(servicesMap, null, SettingsInterface.class));
		addService(new SService(servicesMap, null, PluginInterface.class));
		addService(new SService(servicesMap, null, NotificationInterface.class));
		addService(new SService(servicesMap, null, RemoteServiceInterface.class));
		addService(new SService(servicesMap, null, LowLevelInterface.class));
		addService(new SService(servicesMap, null, NotificationRegistryInterface.class));
		addService(new SService(servicesMap, null, OAuthInterface.class));
		servicesMap.initialize();
		initHttpClient();
	}
	
	public CloseableHttpClient getHttpClient() {
		return httpClient;
	}
	
	public void initHttpClient() {
		HttpClientBuilder builder = HttpClientBuilder.create();
		
		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
		connManager.setMaxTotal(100);
		connManager.setDefaultMaxPerRoute(100);
		builder.setConnectionManager(connManager);
		
//		builder.addInterceptorFirst(new HttpRequestInterceptor() {
//			public void process(final HttpRequest request, final HttpContext context) throws HttpException, IOException {
//				if (!request.containsHeader("Accept-Encoding")) {
//					request.addHeader("Accept-Encoding", "gzip");
//				}
//			}
//		});
//
//		builder.addInterceptorFirst(new HttpResponseInterceptor() {
//			public void process(final HttpResponse response, final HttpContext context) throws HttpException, IOException {
//				HttpEntity entity = response.getEntity();
//				if (entity != null) {
//					Header ceheader = entity.getContentEncoding();
//					if (ceheader != null) {
//						HeaderElement[] codecs = ceheader.getElements();
//						for (int i = 0; i < codecs.length; i++) {
//							if (codecs[i].getName().equalsIgnoreCase("gzip")) {
//								response.setEntity(new GzipDecompressingEntity(response.getEntity()));
//								return;
//							}
//						}
//					}
//				}
//			}
//		});

		httpClient = builder.build();
	}
	
	public MetaDataManager getMetaDataManager() {
		return metaDataManager;
	}
	
	@Override
	public BimServerClientInterface create() throws ServiceException, ChannelConnectionException {
		return create(null);
	}

	public void addService(SService sService) {
		servicesMap.add(sService);
	}
	
	public SServicesMap getServicesMap() {
		return servicesMap;
	}
	
	@Override
	public void close() throws Exception {
		httpClient.close();		
	}
}