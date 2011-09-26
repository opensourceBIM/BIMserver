package org.bimserver;

import java.io.File;

import org.bimserver.plugins.ResourceFetcher;

public class BimServerConfig {
	private boolean startEmbeddedWebServer;
	private File homeDir;
	private ResourceFetcher resourceFetcher;
	private String classPath;
	
	public boolean isStartEmbeddedWebServer() {
		return startEmbeddedWebServer;
	}

	public void setStartEmbeddedWebServer(boolean startEmbeddedWebServer) {
		this.startEmbeddedWebServer = startEmbeddedWebServer;
	}

	public ResourceFetcher getResourceFetcher() {
		return resourceFetcher;
	}

	public void setResourceFetcher(ResourceFetcher resourceFetcher) {
		this.resourceFetcher = resourceFetcher;
	}

	public File getHomeDir() {
		return homeDir;
	}

	public void setHomeDir(File homeDir) {
		this.homeDir = homeDir;
	}

	public String getClassPath() {
		return classPath;
	}

	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}
}
