package org.bimserver.plugins.deserializers;

import java.io.InputStream;

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

//	public IfcModelInterface read(InputStream in, String filename, long fileSize) throws DeserializeException {
//		return read(in, filename, fileSize, null);
//	}
//	
//	@Override
//	public IfcModelInterface read(Path file, ByteProgressReporter progressReporter) throws DeserializeException {
//		try (FileInputStream fileInputStream = new FileInputStream(file.toFile())) {
//			return read(fileInputStream, file.getFileName().toString(), file.toFile().length(), progressReporter);
//		} catch (IOException e) {
//			throw new DeserializeException(e);
//		}
//	}
//	
//	public IfcModelInterface read(Path file) throws DeserializeException {
//		return read(file, null);
//	}
}