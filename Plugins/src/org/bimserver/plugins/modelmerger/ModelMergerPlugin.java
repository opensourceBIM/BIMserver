package org.bimserver.plugins.modelmerger;

import org.bimserver.plugins.Plugin;

public interface ModelMergerPlugin extends Plugin {
	String getDefaultModelMergerName();
	ModelMerger createModelMerger();
}
