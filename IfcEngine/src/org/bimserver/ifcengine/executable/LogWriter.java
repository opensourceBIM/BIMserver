package org.bimserver.ifcengine.executable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class LogWriter {
	private BufferedWriter writer;

	public LogWriter(File file) {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			writer = new BufferedWriter(new OutputStreamWriter(fos));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public synchronized void write(String s) throws IOException {
		writer.write(s + "\n");
	}

	public void flush() throws IOException {
		writer.flush();
	}
}
