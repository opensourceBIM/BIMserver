package org.bimserver.client;

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

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
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

import javax.net.ssl.SSLContext;

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
		initHttpClient(null);
	}

	public AbstractBimServerClientFactory(MetaDataManager metaDataManager, URL trustedCertificate) throws BimServerClientException {
		if (metaDataManager == null) {
			try {
				this.metaDataManager = new MetaDataManager(Files.createTempDirectory("bimserver-tmp"));
				this.metaDataManager.init(true);
			} catch (IOException e) {
				throw new BimServerClientException("Problem creating tmp directory");
			}
//			throw new IllegalArgumentException("MetaDataManager cannot be null");
		} else {
			this.metaDataManager = metaDataManager;
		}
		this.servicesMap = new SServicesMap();
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
		initHttpClient(sslContext(trustedCertificate));
	}

	public AbstractBimServerClientFactory(MetaDataManager metaDataManager) throws BimServerClientException {
		this(metaDataManager, null);
	}
	
	public CloseableHttpClient getHttpClient() {
		return httpClient;
	}
	
	private void initHttpClient(SSLContext sslContext) {
		HttpClientBuilder builder = HttpClientBuilder.create();
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
			sslContext == null ? SSLContexts.createSystemDefault() :  sslContext,
			new String[] { "TLSv1.2" },
			null,
			SSLConnectionSocketFactory.getDefaultHostnameVerifier()
		);
		Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
				.register("http", PlainConnectionSocketFactory.getSocketFactory())
				.register("https", sslsf)
				.build();
		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(registry);
		connManager.setMaxTotal(100);
		connManager.setDefaultMaxPerRoute(100);
		builder.setConnectionManager(connManager);
		builder.disableAutomaticRetries();
		// TODO set timeouts? https://hc.apache.org/httpcomponents-client-5.1.x/migration-guide/preparation.html
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

	private SSLContext sslContext(URL trustedCertificate) throws BimServerClientException {
		if(trustedCertificate != null) {
			SSLContextBuilder sslContextBuilder = SSLContexts.custom();
			try {
				KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
				keystore.load(null);  // initializes keystore
				CertificateFactory cf = CertificateFactory.getInstance("X.509");
				Certificate cert = null;
				try (InputStream trustedCertStream = trustedCertificate.openStream()) {
					cert = cf.generateCertificate(trustedCertStream);
				}
				if (cert!=null) keystore.setCertificateEntry("onlyentry", cert);
				sslContextBuilder.loadTrustMaterial(keystore, null);
				return sslContextBuilder.build();
			} catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException | KeyManagementException  e) {
				throw new BimServerClientException("Unable to use provided certificate.");
			}
		} else {
			return SSLContexts.createSystemDefault();
		}
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