package org.bimserver.plugins.serializers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public abstract class RemovableFileOutputStream extends FileOutputStream {

	private File file;

	public RemovableFileOutputStream(File file) throws FileNotFoundException {
		super(file);
		this.file = file;
	}
	
	public void remove() {
		file.delete();
	}
}