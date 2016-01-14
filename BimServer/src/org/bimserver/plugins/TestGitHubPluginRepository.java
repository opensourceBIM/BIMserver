package org.bimserver.plugins;

import java.util.List;

import org.junit.Test;

public class TestGitHubPluginRepository {
	@Test
	public void test() {
		GitHubPluginRepository gitHubPluginRepository = new GitHubPluginRepository("opensourceBIM", "BIMserver-Repository");
		
		List<PluginLocation> pluginLocations = gitHubPluginRepository.listPluginLocations();
		for (PluginLocation pluginLocation : pluginLocations) {
			System.out.println(pluginLocation);
			for (PluginVersion pluginVersion : pluginLocation.getAllVersions()) {
				System.out.println(pluginVersion);
			}
		}
	}
}
