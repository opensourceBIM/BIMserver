package org.bimserver.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {
	public static void writeToFile(byte[] bytes, File file) {
		try {
			FileOutputStream out = new FileOutputStream(file);
			out.write(bytes);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
