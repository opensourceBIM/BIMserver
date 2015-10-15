package org.bimserver.plugins.serializers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class RemovableFileOutputStream extends FileOutputStream {

	private Path file;

	public RemovableFileOutputStream(Path file) throws FileNotFoundException {
		super(file.toFile());
		this.file = file;
	}
	
	public void remove() throws IOException {
		Files.delete(file);
	}
}