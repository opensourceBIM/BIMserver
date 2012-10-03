package org.bimserver;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.File;

import org.bimserver.plugins.ResourceFetcher;

public class BimServerConfig {
	private boolean startEmbeddedWebServer;
	private File homeDir;
	private ResourceFetcher resourceFetcher;
	private String classPath;
	private int port;
	private boolean startCommandLine = false;
	private int initialProtocolBuffersPort;
	
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

	public void setPort(int port) {
		this.port = port;
	}
	
	public int getPort() {
		return port;
	}

	public boolean isStartCommandLine() {
		return startCommandLine;
	}

	public void setStartCommandLine(boolean startCommandLine) {
		this.startCommandLine = startCommandLine;
	}

	public int getInitialProtocolBuffersPort() {
		return initialProtocolBuffersPort;
	}
	
	public void setInitialProtocolBuffersPort(int initialProtocolBuffersPort) {
		this.initialProtocolBuffersPort = initialProtocolBuffersPort;
	}
}