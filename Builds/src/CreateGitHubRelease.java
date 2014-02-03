import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
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
			Map<String, String> params = new HashMap<String, String>();
			params.put("Content-Type", "application/zip");
			
			DefaultHttpClient client = new DefaultHttpClient();
			BasicCredentialsProvider basicCredentialsProvider = new BasicCredentialsProvider();
			basicCredentialsProvider.setCredentials(new AuthScope("uploads.github.com", 443), new UsernamePasswordCredentials(username, password));
			client.setCredentialsProvider(basicCredentialsProvider);
			Thread.sleep(10000);
			for (String filename : filenames) {
				File file = new File(filename);
				String url = "https://uploads.github.com/repos/" + repo + "/" + project + "/releases/" + id + "/assets?name=" + file.getName();
				System.out.println(url);
				HttpPost post = new HttpPost(url);
				post.setHeader("Accept", "application/vnd.github.manifold-preview");
				post.setHeader("Content-Type", "application/zip");
				post.setEntity(new InputStreamEntity(new FileInputStream(file), file.length()));
				HttpResponse execute = client.execute(post);
				System.out.println(execute.getStatusLine());
				execute.getEntity().getContent().close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}