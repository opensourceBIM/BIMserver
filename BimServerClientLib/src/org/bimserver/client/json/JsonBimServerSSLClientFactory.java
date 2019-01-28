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

import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import org.bimserver.client.BimServerClient;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.reflector.RealtimeReflectorFactoryBuilder;
import org.bimserver.shared.reflector.ReflectorFactory;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

public class JsonBimServerSSLClientFactory extends JsonBimServerClientFactory {

  private final JsonSSLSocketReflectorFactory jsonReflectorFactory;
  private final ReflectorFactory reflectorFactory;
  private final String address;
  private final SSLConnectionSocketFactory sslsf;
  private CloseableHttpClient sslHttpClient;

  public JsonBimServerSSLClientFactory(String address, URL trustedCertificate) throws BimServerClientException, CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
    super(null, address); // actually we only want to call AbstractBimServerClientFactory(null) to get the service map instantiated
    this.sslsf = new SSLConnectionSocketFactory(sslContext(trustedCertificate));
    this.jsonReflectorFactory = new JsonSSLSocketReflectorFactory(getServicesMap(), newConnectionManager());
    this.reflectorFactory = new RealtimeReflectorFactoryBuilder(getServicesMap()).newReflectorFactory();
    this.address = address;
    sslHttpClient = HttpClients.custom().setConnectionManager(newConnectionManager()).build();
  }

  public CloseableHttpClient getHttpClient() {
    return sslHttpClient;
  }

  @Override
  public BimServerClient create(AuthenticationInfo authenticationInfo) throws ServiceException, ChannelConnectionException {
    JsonChannel jsonChannel = new JsonChannel(getHttpClient(), reflectorFactory, jsonReflectorFactory, address + "/json", getServicesMap());
    BimServerClient bimServerClient = new BimServerClient(this.getMetaDataManager(), address, getServicesMap(), jsonChannel);
    jsonChannel.connect(bimServerClient);
    bimServerClient.setAuthentication(authenticationInfo);
    bimServerClient.connect();
    return bimServerClient;

  }

  private HttpClientConnectionManager newConnectionManager() {
    Registry<ConnectionSocketFactory> r = RegistryBuilder.<ConnectionSocketFactory>create()
      .register("http", PlainConnectionSocketFactory.getSocketFactory())
      .register("https", sslsf)
      .build();
    PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(r);
    connManager.setMaxTotal(100);
    connManager.setDefaultMaxPerRoute(100);
    return connManager;
  }

  private SSLContext sslContext(URL trustedCertificate) throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException, KeyManagementException {
    SSLContextBuilder sslContextBuilder = SSLContexts.custom();
    if(trustedCertificate != null) {
      KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
      keystore.load(null);  // initializes keystore
      CertificateFactory cf = CertificateFactory.getInstance("X.509");
      Certificate cert = null;
      try (InputStream trustedCertStream = trustedCertificate.openStream()) {
        cert = cf.generateCertificate(trustedCertStream);
      }
      if (cert!=null) keystore.setCertificateEntry("onlyentry", cert);
      sslContextBuilder.loadTrustMaterial(keystore, null);
    }
    return sslContextBuilder.build();
  }
}
