package org.bimserver.shared.json;

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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.TokenAuthentication;
import org.bimserver.shared.TokenHolder;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.meta.ServicesMap;
import org.codehaus.jettison.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonSocketReflector extends JsonReflector {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonSocketReflector.class);
	private final String remoteAddress;
	private final boolean useHttpSession;
	private final DefaultHttpClient httpclient;
	private final AuthenticationInfo authenticationInfo;
	private final HttpContext context;
	private TokenHolder tokenHolder;

	public JsonSocketReflector(DefaultHttpClient httpclient, ServicesMap servicesMap, String remoteAddress, boolean useHttpSession, AuthenticationInfo authenticationInfo, TokenHolder tokenHolder) {
		super(servicesMap);
		this.httpclient = httpclient;
		this.remoteAddress = remoteAddress;
		this.useHttpSession = useHttpSession;
		this.authenticationInfo = authenticationInfo;
		this.tokenHolder = tokenHolder;
		context = new BasicHttpContext();
	}
	
	public JsonObject call(JsonObject request) throws JSONException, ReflectorException {
		try {
			if (useHttpSession) {
				if (authenticationInfo != null && authenticationInfo instanceof UsernamePasswordAuthenticationInfo) {
					UsernamePasswordAuthenticationInfo usernamePasswordAuthenticationInfo = (UsernamePasswordAuthenticationInfo) authenticationInfo;
					UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(usernamePasswordAuthenticationInfo.getUsername(),
							usernamePasswordAuthenticationInfo.getPassword());
					httpclient.getCredentialsProvider().setCredentials(new AuthScope("localhost", 443), credentials);
				}
			} else {
				// We can disable the use of cookies
				context.setAttribute(ClientContext.COOKIE_STORE, null);
				if (authenticationInfo != null && authenticationInfo instanceof TokenAuthentication) {
					tokenHolder.setToken(((TokenAuthentication)authenticationInfo).getToken());
				}
				if (tokenHolder.getToken() != null) {
					// But we have to provide the token ourselves
					request.addProperty("token", tokenHolder.getToken());
				}
			}
			HttpPost httppost = new HttpPost(remoteAddress);
			httppost.setEntity(new StringEntity(request.toString(), Charsets.UTF_8));

			HttpResponse response = httpclient.execute(httppost, context);
			try {
				if (response.getStatusLine().getStatusCode() == 200) {
					HttpEntity resultEntity = response.getEntity();
					
					JsonParser parser = new JsonParser();
					boolean debug = false;
					if (debug) {
						InputStream inputStream = resultEntity.getContent();
						ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
						IOUtils.copy(inputStream, byteArrayOutputStream);
						LOGGER.info(new String(byteArrayOutputStream.toByteArray(), Charsets.UTF_8));
						JsonObject resultObject = (JsonObject) parser.parse(new InputStreamReader(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), Charsets.UTF_8));
						return resultObject;
					} else {
						return (JsonObject) parser.parse(new InputStreamReader(resultEntity.getContent(), Charsets.UTF_8));
					}
				} else {
					throw new ReflectorException("Call unsuccessful, status code: " + response.getStatusLine().getStatusCode());
				}
			} finally {
				httppost.releaseConnection();
			}
		} catch (Exception e) {
			throw new ReflectorException(e);
		}
	}
}