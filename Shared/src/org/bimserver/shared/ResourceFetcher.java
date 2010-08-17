package org.bimserver.shared;

import java.io.File;
import java.net.URL;

public abstract class ResourceFetcher {
	public abstract URL getResource(String name);
	public abstract File getFile(String name);
}