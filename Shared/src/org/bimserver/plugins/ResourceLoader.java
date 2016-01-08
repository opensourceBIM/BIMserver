package org.bimserver.plugins;

import java.io.InputStream;

public interface ResourceLoader {
	InputStream load(String name);
}
