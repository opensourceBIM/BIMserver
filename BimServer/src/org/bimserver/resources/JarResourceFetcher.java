package org.bimserver.resources;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.bimserver.shared.ResourceFetcher;

public class JarResourceFetcher extends ResourceFetcher {

	@Override
	public URL getResource(String name) {
		try {
			File file = getFile(name);
			if (file != null) {
				return file.getAbsoluteFile().toURI().toURL();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public File getFile(String name) {
		if (name.startsWith("lib")) {
			File file = new File(name);
			if (file.exists()) {
				return file;
			}
		} else {
			File file = new File("config" + File.separator + name);
			if (file.exists()) {
				return file;
			}
		}
		return null;
	}
}