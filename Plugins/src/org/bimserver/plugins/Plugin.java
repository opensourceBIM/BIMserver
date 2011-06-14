package org.bimserver.plugins;

public interface Plugin {
	void init();
	String getName();
	String getDescription();
	String getVersion();
}