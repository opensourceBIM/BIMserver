package org.bimserver.jqep;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.VirtualFile;
import org.bimserver.plugins.queryengine.QueryEngine;
import org.bimserver.plugins.queryengine.QueryEnginePlugin;

import com.google.common.base.Charsets;

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
		for (VirtualFile virtualFile : pluginContext.listResources("examples")) {
			examples.put(virtualFile.getSimpleName(), new String(virtualFile.getData(), Charsets.UTF_8));
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
	public String getDefaultName() {
		return "JavaQueryEnginePlugin";
	}

	@Override
	public ObjectDefinition getSettingsDefinition() {
		return null;
	}
}