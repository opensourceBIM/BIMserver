package org.bimserver.build;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.DefaultHttpClient;
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
			JsonObject gitHubResponse = gitHubClient.post("/repos/" + repo + "/" + project + "/releases", map, JsonObject.class);
			System.out.println(gitHubResponse);
			String id = gitHubResponse.get("id").getAsString();
			
			HttpHost httpHost = new HttpHost("uploads.github.com", 443, "https");

			DefaultHttpClient client = new DefaultHttpClient();
			BasicCredentialsProvider basicCredentialsProvider = new BasicCredentialsProvider();
			basicCredentialsProvider.setCredentials(new AuthScope(httpHost), new UsernamePasswordCredentials(username, password));
			client.setCredentialsProvider(basicCredentialsProvider);
			
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
		}
	}
}