package org.bimserver.plugins.deserializers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;

public abstract class EmfDeserializer implements Deserializer {

	private PackageMetaData packageMetaData;
	
	public void init(PackageMetaData packageMetaData) {
		this.packageMetaData = packageMetaData;
	}

	public PackageMetaData getPackageMetaData() {
		return packageMetaData;
	}
	
	public abstract IfcModelInterface read(InputStream in, String filename, long fileSize, ByteProgressReporter progressReporter) throws DeserializeException;

	public IfcModelInterface read(InputStream in, String filename, long fileSize) throws DeserializeException {
		return read(in, filename, fileSize, null);
	}
	
	@Override
	public IfcModelInterface read(Path file, ByteProgressReporter progressReporter) throws DeserializeException {
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(file.toFile());
			try {
				return read(fileInputStream, file.getFileName().toString(), file.toFile().length(), progressReporter);
			} finally {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			throw new DeserializeException(e);
		}
	}
	
	public IfcModelInterface read(Path file) throws DeserializeException {
		return read(file, null);
	}
}