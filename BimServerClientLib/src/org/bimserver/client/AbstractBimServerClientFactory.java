package org.bimserver.client;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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

import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.interfaces.SServiceInterfaceService;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.reflector.ReflectorFactoryImpl1;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.interfaces.AdminInterface;
import org.bimserver.shared.interfaces.AuthInterface;
import org.bimserver.shared.interfaces.MetaInterface;
import org.bimserver.shared.interfaces.PluginInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.interfaces.SettingsInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1AuthInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1LowLevelInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1NotificationInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1NotificationRegistryInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1RemoteServiceInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1ServiceInterface;
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

	public AbstractBimServerClientFactory(MetaDataManager metaDataManager) {
		if (metaDataManager == null) {
			throw new IllegalArgumentException("MetaDataManager cannot be null");
		}
		this.metaDataManager = metaDataManager;
		this.servicesMap = new SServicesMap();
		servicesMap.setReflectorFactory(new ReflectorFactoryImpl1());
		SService serviceInterface = new SServiceInterfaceService(servicesMap, null, ServiceInterface.class);
		addService(serviceInterface);
		addService(new SService(servicesMap, null, MetaInterface.class));
		addService(new SService(servicesMap, null, AdminInterface.class));
		addService(new SService(servicesMap, null, AuthInterface.class));
		addService(new SService(servicesMap, null, SettingsInterface.class));
		addService(new SService(servicesMap, null, PluginInterface.class));
		addService(new SService(servicesMap, null, Bimsie1NotificationInterface.class));
		addService(new SService(servicesMap, null, Bimsie1RemoteServiceInterface.class));
		addService(new SService(servicesMap, null, Bimsie1AuthInterface.class));
		addService(new SService(servicesMap, null, Bimsie1LowLevelInterface.class));
		addService(new SService(servicesMap, null, Bimsie1NotificationRegistryInterface.class));
		addService(new SService(servicesMap, null, Bimsie1ServiceInterface.class));
		servicesMap.initialize();
		initHttpClient();
	}
	
	public CloseableHttpClient getHttpClient() {
		return httpClient;
	}
	
	public void initHttpClient() {
		HttpClientBuilder builder = HttpClientBuilder.create();
		
		HttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
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
	
	@Override
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
}