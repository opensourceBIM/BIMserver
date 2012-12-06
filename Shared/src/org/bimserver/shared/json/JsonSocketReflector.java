package org.bimserver.shared.json;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.bimserver.shared.AuthenticationInfo;
import org.bimserver.shared.TokenAuthentication;
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
	private String token;
	private String remoteAddress;
	private boolean useHttpSession;
	private DefaultHttpClient httpclient;
	private AuthenticationInfo authenticationInfo;
	private HttpContext context;

	public JsonSocketReflector(DefaultHttpClient httpclient, ServicesMap servicesMap, String remoteAddress, boolean useHttpSession, AuthenticationInfo authenticationInfo) {
		super(servicesMap);
		this.httpclient = httpclient;
		this.remoteAddress = remoteAddress;
		this.useHttpSession = useHttpSession;
		this.authenticationInfo = authenticationInfo;
		context = new BasicHttpContext();
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
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
					token = ((TokenAuthentication)authenticationInfo).getToken();
				}
				if (token != null) {
					// But we have to provide the token ourselves
					request.addProperty("token", token);
				}
			}
			HttpPost httppost = new HttpPost(remoteAddress);
			httppost.setEntity(new StringEntity(request.toString(), Charsets.UTF_8));

			HttpResponse response = httpclient.execute(httppost, context);
			try {
				if (response.getStatusLine().getStatusCode() == 200) {
					HttpEntity resultEntity = response.getEntity();
					
					JsonParser parser = new JsonParser();
					boolean debug = true;
					if (debug ) {
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
		} catch (ClientProtocolException e) {
			LOGGER.error("", e);
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		return null;
	}
}