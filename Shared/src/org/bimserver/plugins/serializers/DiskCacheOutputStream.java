package org.bimserver.plugins.serializers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class DiskCacheOutputStream extends FileOutputStream {

	public DiskCacheOutputStream(File file) throws FileNotFoundException {
		super(file);
	}
}