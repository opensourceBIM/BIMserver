package org.bimserver;

import java.nio.file.Path;

import org.bimserver.plugins.ResourceFetcher;

public class BimServerConfig {
	private boolean startEmbeddedWebServer;
	private Path homeDir;
	private ResourceFetcher resourceFetcher;
	private String classPath;
	private int port;
	private boolean startCommandLine = false;
	private boolean localDev;
	private boolean autoMigrate = false;
	
	public boolean isStartEmbeddedWebServer() {
		return startEmbeddedWebServer;
	}

	/**
	 * @param startEmbeddedWebServer Whether to start an embedded web server or not (make sure the port it will be listening on is free, you can set the port with setPort)
	 */
	public void setStartEmbeddedWebServer(boolean startEmbeddedWebServer) {
		this.startEmbeddedWebServer = startEmbeddedWebServer;
	}

	public ResourceFetcher getResourceFetcher() {
		return resourceFetcher;
	}

	/**
	 * @param resourceFetcher A ResourceFetcher is an abstraction layer between BIMserver and (usually) the file system, but some implementations get resources from memory or other places as well
	 */
	public void setResourceFetcher(ResourceFetcher resourceFetcher) {
		this.resourceFetcher = resourceFetcher;
	}

	public Path getHomeDir() {
		return homeDir;
	}

	/**
	 * @param homeDir The home directory is a directory used for: database, logging, tmp and configuration
	 */
	public void setHomeDir(Path homeDir) {
		this.homeDir = homeDir;
	}

	public String getClassPath() {
		return classPath;
	}

	/**
	 * @param classPath When running BIMserver from your IDE, some plugins can be loaded from the default classpath, you can set it here (or another classpath if you want)
	 */
	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}

	/**
	 * @param port The port on which the web server will listen (make sure it is started by calling setStartEmbeddedWebServer(true)
	 */
	public void setPort(int port) {
		this.port = port;
	}
	
	public int getPort() {
		return port;
	}

	public boolean isStartCommandLine() {
		return startCommandLine;
	}

	/**
	 * @param startCommandLine Whether to start the command line (will read commands from stdin, most are for debugging)
	 */
	public void setStartCommandLine(boolean startCommandLine) {
		this.startCommandLine = startCommandLine;
	}

	public boolean isLocalDev() {
		return localDev;
	}

	/**
	 * @param localDev Whether this is a local development environment, it's only used for a hack to attach the webdefault.xml to jetty
	 */
	public void setLocalDev(boolean localDev) {
		this.localDev = localDev;
	}

	public boolean isAutoMigrate() {
		return autoMigrate;
	}

	/**
	 * @param autoMigrate When true, database migrations will be done automatically on BIMserver startup, otherwise will have to be done manually
	 */
	public void setAutoMigrate(boolean autoMigrate) {
		this.autoMigrate = autoMigrate;
	}
}