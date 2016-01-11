package org.bimserver.plugins.deserializers;

import java.io.InputStream;
import java.nio.file.Path;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;

public interface Deserializer {
	void init(PackageMetaData packageMetaData);
	IfcModelInterface read(Path file, ByteProgressReporter progressReporter) throws DeserializeException;
	IfcModelInterface read(InputStream inputStream, String fileName, long fileSize, ByteProgressReporter progressReporter) throws DeserializeException;
	IfcModelInterface read(Path file) throws DeserializeException;
	IfcModelInterface read(InputStream inputStream, String fileName, long fileSize) throws DeserializeException;
}