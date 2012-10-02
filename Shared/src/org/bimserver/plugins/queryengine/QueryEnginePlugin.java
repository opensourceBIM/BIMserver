package org.bimserver.plugins.queryengine;

import java.util.Collection;

import org.bimserver.plugins.Plugin;

public interface QueryEnginePlugin extends Plugin {

	/**
	 * @return A usable QueryEngine implementation
	 */
	QueryEngine getQueryEngine();
	
	/**
	 * @return Return a list of keys (usually file names) corresponding to code examples for this plugin
	 */
	Collection<String> getExampleKeys();
	
	/**
	 * @param key
	 * @return Return the code example for the given key
	 */
	String getExample(String key);
}