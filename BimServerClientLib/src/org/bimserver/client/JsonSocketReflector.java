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
import org.bimserver.shared.meta.SService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONTokener;

import com.google.common.base.Charsets;

public class JsonSocketReflector extends JsonReflector {

	private Token token;
	private String remoteAddress;
	private boolean useHttpSession;
	private DefaultHttpClient httpclient;
	private AuthenticationInfo authenticationInfo;
	private HttpContext context;

	public JsonSocketReflector(Map<String, SService> services, String remoteAddress, boolean useHttpSession, AuthenticationInfo authenticationInfo) {
		super(services);
		httpclient = new DefaultHttpClient();
		this.remoteAddress = remoteAddress;
		this.useHttpSession = useHttpSession;
		this.authenticationInfo = authenticationInfo;
		context = new BasicHttpContext();
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
				context.setAttribute(ClientContext.COOKIE_STORE, null);

				if (token != null) {
					// But we have to provide the token ourselves
					JSONObject tokenObject = new JSONObject();
					tokenObject.put("token", token.getTokenString());
					tokenObject.put("expires", token.getExpires());
					request.put("token", tokenObject);
				}
			}

			httppost.setEntity(new StringEntity(request.toString(2)));

			HttpResponse response = httpclient.execute(httppost, context);
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