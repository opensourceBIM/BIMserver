package org.bimserver.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;

public class SerializerUtils {
	public static void writeToFile(Serializer serializer, Path path) throws FileNotFoundException, IOException, SerializerException {
		try (FileOutputStream fos = new FileOutputStream(path.toFile())) {
			serializer.writeToOutputStream(fos, null);
		}
	}
}