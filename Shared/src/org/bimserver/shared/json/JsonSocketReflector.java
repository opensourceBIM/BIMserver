package org.bimserver.shared.json;

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