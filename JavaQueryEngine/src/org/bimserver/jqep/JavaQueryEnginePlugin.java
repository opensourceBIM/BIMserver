package org.bimserver.jqep;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.queryengine.QueryEngine;
import org.bimserver.plugins.queryengine.QueryEnginePlugin;

public class JavaQueryEnginePlugin implements QueryEnginePlugin {
	private boolean initialized = false;
	private final Map<String, String> examples = new LinkedHashMap<String, String>();
	private PluginManager pluginManager;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		this.pluginManager = pluginManager;
		initialized = true;
		initExamples(pluginManager);
	}

	private void initExamples(PluginManager pluginManager) {
		PluginContext pluginContext = pluginManager.getPluginContext(this);
		String[] keys = new String[]{"DefaultQuery.java", "Doors.java", "Plumbing.java"};
		for (String key : keys) {
			InputStream resourceAsInputStream = pluginContext.getResourceAsInputStream("examples/" + key);
			StringWriter sw = new StringWriter();
			try {
				IOUtils.copy(resourceAsInputStream, sw);
			} catch (IOException e) {
				e.printStackTrace();
			}
			examples.put(key, sw.toString());
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
	public QueryEngine getQueryEngine() {
		PluginContext pluginContext = pluginManager.getPluginContext(this);
		return new JavaQueryEngine(pluginContext.getClassLoader(), pluginContext.getFileManager());
	}

	@Override
	public String getDefaultQueryEngineName() {
		return "JavaQueryEnginePlugin";
	}
}