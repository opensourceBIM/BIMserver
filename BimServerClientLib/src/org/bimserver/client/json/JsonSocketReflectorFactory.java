package org.bimserver.client.json;

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

import org.apache.http.HttpVersion;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.CoreProtocolPNames;
import org.bimserver.shared.TokenHolder;
import org.bimserver.shared.json.JsonSocketReflector;
import org.bimserver.shared.meta.SServicesMap;

public class JsonSocketReflectorFactory implements JsonReflectorFactory {
	private SServicesMap servicesMap;
	private DefaultHttpClient httpclient;
	private PoolingClientConnectionManager connectionManager;

	public JsonSocketReflectorFactory(SServicesMap servicesMap) {
		this.servicesMap = servicesMap;

		connectionManager = new PoolingClientConnectionManager();
		connectionManager.setDefaultMaxPerRoute(5);
		connectionManager.setMaxTotal(20);

		httpclient = new DefaultHttpClient(connectionManager);
		httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
		httpclient.getParams().setParameter(CoreProtocolPNames.HTTP_CONTENT_CHARSET, "UTF-8");
	}

	public void close() {
		connectionManager.shutdown();
	}

	public JsonSocketReflector create(String remoteAddress, TokenHolder tokenHolder) {
		return new JsonSocketReflector(httpclient, servicesMap, remoteAddress, tokenHolder);
	}
}
