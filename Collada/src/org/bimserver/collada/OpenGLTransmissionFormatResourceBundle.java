package org.bimserver.collada;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.ResourceBundle;

public class OpenGLTransmissionFormatResourceBundle extends ResourceBundle {

	@Override
	protected Object handleGetObject(String key) {
		if (key.equals("WindowsExecutable")) return getWindowsExecutable();
		if (key.equals("MacOSXExecutable")) return getMacOSXExecutable();
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Enumeration<String> getKeys() {
		return (Enumeration<String>) new HashSet<String>(Arrays.asList("MacOSXExecutable", "WindowsExecutable"));
	}

	public InputStream getWindowsExecutable()
	{
		ClassLoader classLoader = OpenGLTransmissionFormatResourceBundle.class.getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream("binaries/collada2gltf.exe");
		return inputStream;
	}

	public boolean writeWindowsExecutable(File file)
	{
		return writeFile(file, getWindowsExecutable());
	}

	public InputStream getMacOSXExecutable()
	{
		ClassLoader classLoader = OpenGLTransmissionFormatResourceBundle.class.getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream("binaries/collada2gltf");
		return inputStream;
	}

	public boolean writeMacOSXExecutable(File file)
	{
		return writeFile(file, getMacOSXExecutable());
	}

	private boolean writeFile(File file, InputStream inputStream) {
		boolean success = true;
		OutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(file);
			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
		} catch (IOException e) {
			success = false;
			//
			e.printStackTrace();
		} finally {
			success = false;
			//
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return success;
	}
}
