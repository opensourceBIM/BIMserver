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

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.bimserver.shared.TokenHolder;
import org.bimserver.shared.json.JsonSocketReflector;
import org.bimserver.shared.meta.SServicesMap;

public class JsonSocketReflectorFactory implements JsonReflectorFactory {
	private SServicesMap servicesMap;
	private CloseableHttpClient httpclient;
	private PoolingHttpClientConnectionManager poolingHttpClientConnectionManager;

	public JsonSocketReflectorFactory(SServicesMap servicesMap, CloseableHttpClient closeableHttpClient) {
		if (servicesMap == null) {
			throw new IllegalArgumentException("servicesMap cannot be null");
		}
		this.servicesMap = servicesMap;
		
		if (closeableHttpClient == null) {
			poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
			
			poolingHttpClientConnectionManager.setDefaultMaxPerRoute(20);
			poolingHttpClientConnectionManager.setMaxTotal(20);
			
			HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
			httpClientBuilder.setConnectionManager(poolingHttpClientConnectionManager);
			
			httpclient = httpClientBuilder.build();
		} else {
			httpclient = closeableHttpClient;
		}
	}

	public JsonSocketReflectorFactory(SServicesMap servicesMap) {
		this(servicesMap, null);
	}
	
	public void close() {
		poolingHttpClientConnectionManager.shutdown();
	}

	public JsonSocketReflector create(String remoteAddress, TokenHolder tokenHolder) {
		return new JsonSocketReflector(httpclient, servicesMap, remoteAddress, tokenHolder);
	}
}