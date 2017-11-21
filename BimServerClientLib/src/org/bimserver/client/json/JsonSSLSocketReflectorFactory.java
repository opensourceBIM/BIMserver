package org.bimserver.client.json;

import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.bimserver.shared.TokenHolder;
import org.bimserver.shared.json.JsonSocketReflector;
import org.bimserver.shared.meta.SServicesMap;

public class JsonSSLSocketReflectorFactory extends JsonSocketReflectorFactory {

    public JsonSSLSocketReflectorFactory(SServicesMap servicesMap, HttpClientConnectionManager connectionManager) {
        super(servicesMap);
        this.servicesMap = servicesMap;
        sslHttpClientConnectionManager = connectionManager;
        sslHttpClient = HttpClients.custom().setConnectionManager(connectionManager).build();
    }

        private SServicesMap servicesMap;
        private CloseableHttpClient sslHttpClient;
        private HttpClientConnectionManager sslHttpClientConnectionManager;

        public void close() {
            sslHttpClientConnectionManager.shutdown();
        }

        public JsonSocketReflector create(String remoteAddress, TokenHolder tokenHolder) {
            return new JsonSocketReflector(sslHttpClient, servicesMap, remoteAddress, tokenHolder);
        }
}
