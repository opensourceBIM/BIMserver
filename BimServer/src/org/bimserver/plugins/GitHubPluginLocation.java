package org.bimserver.plugins;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jcabi.github.Coordinates;
import com.jcabi.github.Github;
import com.jcabi.github.Release;
import com.jcabi.github.Repo;
import com.jcabi.github.RtGithub;

public class GitHubPluginLocation extends PluginLocation<GitHubPluginVersion> {

	private final String repository;
	private final String groupId;
	private final String artifactId;
	
	public GitHubPluginLocation(String repository, String groupId, String artifactId) {
		this.repository = repository;
		this.groupId = groupId;
		this.artifactId = artifactId;
	}

	@Override
	public List<GitHubPluginVersion> getAllVersions() {
		List<GitHubPluginVersion> versions = new ArrayList<>();
		Github github = new RtGithub();
		
		String substring = repository.substring(repository.lastIndexOf("/", repository.lastIndexOf("/") - 1) + 1);
		
	    Repo repo = github.repos().get(new Coordinates.Simple(substring));
	    for (Release release : repo.releases().iterate()) {
	    	try {
				System.out.println(release.json());
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
		return versions;
	}

	@Override
	public PluginBundleIdentifier getPluginIdentifier() {
		return new PluginBundleIdentifier(groupId, artifactId);
	}

	public String getRepository() {
		return repository;
	}

	public String getArtifactId() {
		return artifactId;
	}

	public String getGroupId() {
		return groupId;
	}
}