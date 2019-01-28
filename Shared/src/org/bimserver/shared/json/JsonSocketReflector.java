package org.bimserver.shared.json;

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

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.bimserver.shared.TokenHolder;
import org.bimserver.shared.meta.SServicesMap;
import org.bimserver.shared.reflector.ReflectorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Charsets;

public class JsonSocketReflector extends JsonReflector {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonSocketReflector.class);
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private final String remoteAddress;
	private final HttpClient httpclient;
	private final HttpContext context;
	private TokenHolder tokenHolder;

	public JsonSocketReflector(HttpClient httpclient, SServicesMap servicesMap, String remoteAddress, TokenHolder tokenHolder) {
		super(servicesMap);
		this.httpclient = httpclient;
		this.remoteAddress = remoteAddress;
		this.tokenHolder = tokenHolder;
		this.context = new BasicHttpContext();
	}
	
	public JsonNode call(ObjectNode request) throws ReflectorException {
		try {
			if (tokenHolder.getToken() != null) {
				request.put("token", tokenHolder.getToken());
			}
			HttpPost httppost = new HttpPost(remoteAddress);
			httppost.setHeader("Content-Type", "application/json");
			httppost.setEntity(new StringEntity(request.toString(), Charsets.UTF_8));

			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(request.toString());
			}
			
			HttpResponse response = httpclient.execute(httppost, context);
			try {
				if (response.getStatusLine().getStatusCode() == 200) {
					HttpEntity resultEntity = response.getEntity();
					
					if (LOGGER.isDebugEnabled()) {
						InputStream inputStream = resultEntity.getContent();
						ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
						IOUtils.copy(inputStream, byteArrayOutputStream);
						LOGGER.debug(new String(byteArrayOutputStream.toByteArray(), Charsets.UTF_8));
						ObjectNode resultObject = OBJECT_MAPPER.readValue(byteArrayOutputStream.toByteArray(), ObjectNode.class);
						return resultObject;
					} else {
						return OBJECT_MAPPER.readValue(resultEntity.getContent(), ObjectNode.class);
					}
				} else {
					throw new ReflectorException("Call unsuccessful, status code: " + response.getStatusLine().getStatusCode() + " (" + response.getStatusLine().getReasonPhrase() + "), " + remoteAddress);
				}
			} finally {
				httppost.releaseConnection();
			}
		} catch (Exception e) {
			throw new ReflectorException(e);
		}
	}
}