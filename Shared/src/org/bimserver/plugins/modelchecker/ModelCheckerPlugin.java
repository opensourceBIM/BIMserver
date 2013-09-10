package org.bimserver.plugins.modelchecker;

import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginConfiguration;

public interface ModelCheckerPlugin extends Plugin {
	ModelChecker createModelChecker(PluginConfiguration pluginConfiguration);
}
