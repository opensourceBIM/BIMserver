package org.bimserver.javamodelchecker;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.VirtualFile;
import org.bimserver.plugins.modelchecker.ModelChecker;
import org.bimserver.plugins.modelchecker.ModelCheckerPlugin;

import com.google.common.base.Charsets;

public class JavaModelCheckerPlugin implements ModelCheckerPlugin {

	private boolean initialized;
	private PluginManager pluginManager;
	private final Map<String, String> examples = new LinkedHashMap<String, String>();
	
	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		this.pluginManager = pluginManager;
		initExamples(pluginManager);
		initialized = true;
	}

	private void initExamples(PluginManager pluginManager) {
		PluginContext pluginContext = pluginManager.getPluginContext(this);
		for (VirtualFile virtualFile : pluginContext.listResources("examples")) {
			if (!virtualFile.getSimpleName().startsWith(".svn")) {
				examples.put(virtualFile.getSimpleName(), new String(virtualFile.getData(), Charsets.UTF_8));
			}
		}
	}

	@Override
	public String getDescription() {
		return "Java Model Checker Plugin";
	}

	@Override
	public String getDefaultName() {
		return "Java Model Checker Plugin";
	}

	@Override
	public String getVersion() {
		return "0.1";
	}

	@Override
	public ObjectDefinition getSettingsDefinition() {
		return null;
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}
	
	public Collection<String> getExampleKeys() {
		return examples.keySet();
	}

	public String getExample(String key) {
		return examples.get(key);
	}
	
	@Override
	public ModelChecker createModelChecker(PluginConfiguration pluginConfiguration) {
		PluginContext pluginContext = pluginManager.getPluginContext(this);
		return new JavaModelChecker(pluginContext.getClassLoader(), pluginContext.getFileManager());
	}
}
