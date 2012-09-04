package org.bimserver.plugins.queryengine;

import java.util.Collection;

import org.bimserver.plugins.Plugin;

public interface QueryEnginePlugin extends Plugin {

	QueryEngine getQueryEngine();
	String getDefaultQueryEngineName();
	Collection<String> getExampleKeys();
	String getExample(String key);
}