package org.bimserver.plugins;

import net.xeoh.plugins.base.Plugin;

public interface BimPlugin extends Plugin {
	void init();
	String getName();
	String getDescription();
	String getVersion();
}
