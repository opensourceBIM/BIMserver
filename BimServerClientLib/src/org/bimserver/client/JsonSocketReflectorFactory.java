package org.bimserver.client;

import org.apache.http.HttpVersion;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.CoreProtocolPNames;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.json.JsonSocketReflector;
import org.bimserver.shared.meta.ServicesMap;

public class JsonSocketReflectorFactory {
	private ServicesMap servicesMap;
	private DefaultHttpClient httpclient;
	private PoolingClientConnectionManager connectionManager;

	public JsonSocketReflectorFactory(ServicesMap servicesMap) {
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

	public JsonSocketReflector create(String remoteAddress, boolean useHttpSession, AuthenticationInfo authenticationInfo) {
		return new JsonSocketReflector(httpclient, servicesMap, remoteAddress, useHttpSession, authenticationInfo);
	}
}
