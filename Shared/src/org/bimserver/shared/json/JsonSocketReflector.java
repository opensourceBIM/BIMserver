package org.bimserver.shared.json;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
import org.bimserver.interfaces.objects.SToken;
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
import com.google.gson.JsonPrimitive;

public class JsonSocketReflector extends JsonReflector {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonSocketReflector.class);
	private SToken token;
	private String remoteAddress;
	private boolean useHttpSession;
	private DefaultHttpClient httpclient;
	private AuthenticationInfo authenticationInfo;
	private HttpContext context;

	public JsonSocketReflector(ServicesMap servicesMap, String remoteAddress, boolean useHttpSession, AuthenticationInfo authenticationInfo) {
		super(servicesMap);
		httpclient = new DefaultHttpClient();
		this.remoteAddress = remoteAddress;
		this.useHttpSession = useHttpSession;
		this.authenticationInfo = authenticationInfo;
		context = new BasicHttpContext();
	}
	
	public SToken getToken() {
		return token;
	}
	
	public void setToken(SToken token) {
		this.token = token;
	}
	
	public void close() {
		httpclient.getConnectionManager().shutdown();
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
					JsonObject tokenObject = new JsonObject();
					tokenObject.add("tokenString", new JsonPrimitive(token.getTokenString()));
					tokenObject.add("expires", new JsonPrimitive(token.getExpires()));
					request.add("token", tokenObject);
				}
			}
			HttpPost httppost = new HttpPost(remoteAddress);
			System.out.println(request.toString());
			httppost.setEntity(new StringEntity(request.toString()));

			HttpResponse response = httpclient.execute(httppost, context);
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
					JsonObject resultObject = (JsonObject) parser.parse(new InputStreamReader(resultEntity.getContent(), Charsets.UTF_8));
					return resultObject;
				}
			} else {
				throw new ReflectorException("Call unsuccessful, status code: " + response.getStatusLine().getStatusCode());
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}