package org.bimserver.plugins;

import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

public class TestGitHubPluginRepository {
	@Test
	public void test() {
		MavenPluginRepository mavenPluginRepository = new MavenPluginRepository(Paths.get("maven"), "https://repo1.maven.org/maven2", null);
		GitHubPluginRepository gitHubPluginRepository = new GitHubPluginRepository(mavenPluginRepository, "opensourceBIM", "BIMserver-Repository");
		
		List<PluginLocation<?>> pluginLocations = gitHubPluginRepository.listPluginLocations();
		for (PluginLocation<?> pluginLocation : pluginLocations) {
			System.out.println(pluginLocation);
			for (PluginVersion pluginVersion : pluginLocation.getAllVersions()) {
				System.out.println(pluginVersion);
			}
		}
	}
}
