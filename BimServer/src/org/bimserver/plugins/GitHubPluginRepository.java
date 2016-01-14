package org.bimserver.plugins;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.bimserver.utils.NetUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class GitHubPluginRepository {
	private String organization;
	private String repository;

	public GitHubPluginRepository(String organization, String repository) {
		this.organization = organization;
		this.repository = repository;
	}

	public List<PluginLocation> listPluginLocations() {
		List<PluginLocation> pluginLocations = new ArrayList<>();
		
		String url = "https://github.com/" + organization + "/" + repository + "/raw/master/plugins.json";
		try {
			String content = NetUtils.getContent(new URL(url), 5000);
			ObjectMapper objectMapper = new ObjectMapper();
			ObjectNode objectNode = objectMapper.readValue(content, ObjectNode.class);
			ArrayNode pluginsNode = (ArrayNode) objectNode.get("plugins");
			for (JsonNode pluginNode : pluginsNode) {
				ObjectNode pluginObject = (ObjectNode)pluginNode;
				if (pluginObject.has("maven")) {
					ObjectNode mavenNode = (ObjectNode) pluginObject.get("maven");
					MavenPluginLocation mavenPluginLocation = new MavenPluginLocation(mavenNode.get("defaultrepository").asText(), mavenNode.get("groupId").asText(), mavenNode.get("artifactId").asText());
					pluginLocations.add(mavenPluginLocation);
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return pluginLocations;
	}
}