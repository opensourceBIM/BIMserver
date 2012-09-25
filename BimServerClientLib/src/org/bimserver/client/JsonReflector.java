package org.bimserver.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

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
import org.bimserver.client.factories.AuthenticationInfo;
import org.bimserver.client.factories.UsernamePasswordAuthenticationInfo;
import org.bimserver.models.store.Token;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.json.JsonConverter;
import org.bimserver.shared.meta.SService;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONTokener;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

public class JsonReflector implements Reflector {

	private String remoteAddress;
	private AuthenticationInfo authenticationInfo;
	private boolean useHttpSession;
	private Token token;
	private DefaultHttpClient httpclient;
	private HttpContext localContext = new BasicHttpContext();
	private JsonConverter converter;
	private Map<String, SService> services;

	public JsonReflector(Map<String, SService> services, String remoteAddress, boolean useHttpSession, AuthenticationInfo authenticationInfo) {
		this.services = services;
		this.remoteAddress = remoteAddress;
		this.useHttpSession = useHttpSession;
		this.authenticationInfo = authenticationInfo;
		httpclient = new DefaultHttpClient();
		converter = new JsonConverter(services);
	}

	@Override
	public Object callMethod(String interfaceName, String methodName, Class<?> definedReturnType, KeyValuePair... args) throws ServerException, UserException {
		try {
			JSONObject request = new JSONObject();
			request.put("interface", interfaceName);
			request.put("method", methodName);
			for (KeyValuePair arg : args) {
				request.put(arg.getFieldName(), converter.toJson(arg.getValue()));
			}
			JSONObject requestObject = new JSONObject();
			requestObject.put("request", request);
			JSONObject jsonResult = call(requestObject);
			LoggerFactory.getLogger(JsonReflector.class).info(jsonResult.toString(2));
			if (jsonResult.has("exception")) {
				JSONObject exceptionJson = jsonResult.getJSONObject("exception");
				String exceptionType = exceptionJson.getString("__type");
				if (exceptionType.equals(UserException.class.getName())) {
					throw new UserException(exceptionJson.getString("message"));
				} else if (exceptionType.equals(ServerException.class.getName())) {
					throw new ServerException(exceptionJson.getString("message"));
				}
			} else if (jsonResult.has("response")) {
				Object responseObject = jsonResult.get("response");
				return converter.fromJson(services.get(interfaceName).getSMethod(methodName).getBestReturnType(), responseObject);
			} else {
				return null;
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void close() {
		httpclient.getConnectionManager().shutdown();
	}

	public JSONObject call(JSONObject request) throws JSONException {
		try {
			if (authenticationInfo != null && authenticationInfo instanceof UsernamePasswordAuthenticationInfo) {
				UsernamePasswordAuthenticationInfo usernamePasswordAuthenticationInfo = (UsernamePasswordAuthenticationInfo) authenticationInfo;
				UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(usernamePasswordAuthenticationInfo.getUsername(),
						usernamePasswordAuthenticationInfo.getPassword());
				httpclient.getCredentialsProvider().setCredentials(new AuthScope("localhost", 443), credentials);
			}
			HttpPost httppost = new HttpPost(remoteAddress);

			if (useHttpSession) {
			} else {
				// We can disable the use of cookies
				localContext.setAttribute(ClientContext.COOKIE_STORE, null);

				if (token != null) {
					// But we have to provide the token ourselves
					JSONObject tokenObject = new JSONObject();
					tokenObject.put("token", token.getTokenString());
					tokenObject.put("expires", token.getExpires());
					request.put("token", tokenObject);
				}
			}

			httppost.setEntity(new StringEntity(request.toString(2)));

			HttpResponse response = httpclient.execute(httppost, localContext);
			HttpEntity resultEntity = response.getEntity();
			InputStream inputStream = resultEntity.getContent();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			IOUtils.copy(inputStream, baos);
			JSONObject resultObject = new JSONObject(new JSONTokener(new String(baos.toByteArray(), Charsets.UTF_8)));
			return resultObject;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}