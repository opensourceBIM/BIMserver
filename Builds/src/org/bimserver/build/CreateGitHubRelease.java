package org.bimserver.build;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.eclipse.egit.github.core.client.GitHubClient;

import com.google.gson.JsonObject;

public class CreateGitHubRelease {
	public static void main(String[] args) {
		String username = args[0];
		String password = args[1];
		String repo = args[2];
		String project = args[3];
		String tagname = args[4];
		String name = args[5];
		String body = args[6];
		String draft = args[7];
		String prerelease = args[8];
		String filesString = args[9];
		String[] filenames = filesString.split(";");
		
		GitHubClient gitHubClient = new GitHubClient("api.github.com");
		gitHubClient.setCredentials(username, password);

		Map<String, String> map = new HashMap<String, String>();
		map.put("tag_name", tagname);
		// map.put("target_commitish", "test");
		map.put("name", name);
		map.put("body", body);
		map.put("draft", draft);
		map.put("prerelease", prerelease);
		try {
			String string = "/repos/" + repo + "/" + project + "/releases";
			System.out.println(string);
			JsonObject gitHubResponse = gitHubClient.post(string, map, JsonObject.class);
			System.out.println(gitHubResponse);
			String id = gitHubResponse.get("id").getAsString();
			
			HttpHost httpHost = new HttpHost("uploads.github.com", 443, "https");

			BasicCredentialsProvider basicCredentialsProvider = new BasicCredentialsProvider();
			basicCredentialsProvider.setCredentials(new AuthScope(httpHost), new UsernamePasswordCredentials(username, password));

			HostnameVerifier hostnameVerifier = new AllowAllHostnameVerifier();

			SSLContextBuilder builder = new SSLContextBuilder();
			builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(builder.build());
			CloseableHttpClient client = HttpClients.custom().setDefaultCredentialsProvider(basicCredentialsProvider)
					.setHostnameVerifier((X509HostnameVerifier) hostnameVerifier).setSSLSocketFactory(sslsf).build();
			
			AuthCache authCache = new BasicAuthCache();
			BasicScheme basicAuth = new BasicScheme();
			authCache.put(httpHost, basicAuth);

			HttpClientContext context = HttpClientContext.create();
			context.setCredentialsProvider(basicCredentialsProvider);
			context.setAuthCache(authCache);
			
			for (String filename : filenames) {
				File file = new File(filename);
				String url = "https://uploads.github.com/repos/" + repo + "/" + project + "/releases/" + id + "/assets?name=" + file.getName();
				HttpPost post = new HttpPost(url);
				post.setHeader("Accept", "application/vnd.github.manifold-preview");
				post.setHeader("Content-Type", "application/zip");
				post.setEntity(new InputStreamEntity(new FileInputStream(file), file.length()));
				HttpResponse execute = client.execute(httpHost, post, context);
				execute.getEntity().getContent().close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}
	}
}