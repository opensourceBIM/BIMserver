package org.bimserver.utils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamReader extends Thread {

	private final BufferedInputStream inputStream;

	public StreamReader(String name, InputStream inputStream) {
		this.inputStream = new BufferedInputStream(inputStream);
		setName(name);
	}

	@Override
	public void run() {
		byte[] buffer = new byte[1024];
		int red;
		try {
			red = inputStream.read(buffer);
			while (red != -1) {
				String s = new String(buffer, 0, red);
				System.out.print(s);
				red = inputStream.read(buffer);
			}
		} catch (IOException e) {
		}
	}
}