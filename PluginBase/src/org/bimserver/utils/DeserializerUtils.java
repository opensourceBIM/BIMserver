package org.bimserver.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;

public class DeserializerUtils {

	public static IfcModelInterface readFromBytes(Deserializer deserializer, byte[] bytes, String filename) throws DeserializeException {
		return deserializer.read(new ByteArrayInputStream(bytes), filename, bytes.length, null);
	}

	public static IfcModelInterface readFromFile(Deserializer deserializer, Path path) throws DeserializeException, IOException {
		try (InputStream fis = Files.newInputStream(path)) {
			return deserializer.read(fis, path.getFileName().toString(), Files.size(path), null);
		}
	}
}