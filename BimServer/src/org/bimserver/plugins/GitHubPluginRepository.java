package org.bimserver.plugins;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

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

	private String url;

	public GitHubPluginRepository(String organization, String repository) {
		this.url = "https://github.com/" + organization + "/" + repository + "/raw/master/plugins.json";
	}

	public GitHubPluginRepository(String url) {
		this.url = url + "/plugins.json";
	}

	public List<PluginLocation> listPluginLocations() {
		List<PluginLocation> pluginLocations = new ArrayList<>();
		
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