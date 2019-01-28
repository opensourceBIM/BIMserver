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
