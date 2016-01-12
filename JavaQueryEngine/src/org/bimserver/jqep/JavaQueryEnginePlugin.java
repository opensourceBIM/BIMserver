package org.bimserver.jqep;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginManagerInterface;
import org.bimserver.plugins.queryengine.QueryEngine;
import org.bimserver.plugins.queryengine.QueryEnginePlugin;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.utils.PathUtils;

import com.google.common.base.Charsets;

public class JavaQueryEnginePlugin implements QueryEnginePlugin {
	private boolean initialized = false;
	private final Map<String, String> examples = new LinkedHashMap<String, String>();
	private PluginManagerInterface pluginManager;

	@Override
	public void init(PluginManagerInterface pluginManager) throws PluginException {
		this.pluginManager = pluginManager;
		initialized = true;
		initExamples(pluginManager);
	}

	private void initExamples(PluginManagerInterface pluginManager) {
		PluginContext pluginContext = pluginManager.getPluginContext(this);
		try {
			for (Path path : PathUtils.list(pluginContext.getRootPath().resolve("examples"))) {
				InputStream inputStream = Files.newInputStream(path);
				try {
					examples.put(path.getFileName().toString(), IOUtils.toString(inputStream, Charsets.UTF_8.name()));
				} finally {
					inputStream.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Collection<String> getExampleKeys() {
		return examples.keySet();
	}

	public String getExample(String key) {
		return examples.get(key);
	}
	
	@Override
	public String getDescription() {
		return "Java Query Engine Plugin";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public QueryEngine getQueryEngine(PluginConfiguration pluginConfiguration) {
		PluginContext pluginContext = pluginManager.getPluginContext(this);
		return new JavaQueryEngine(pluginContext.getClassLoader(), pluginContext.getRootPath());
	}

	@Override
	public String getDefaultName() {
		return "JavaQueryEnginePlugin";
	}

	@Override
	public ObjectDefinition getSettingsDefinition() {
		return null;
	}
}