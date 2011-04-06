package org.bimserver.longaction;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataSource;

import org.bimserver.ServerInitializer;

public class CacheFileSerializer implements DataSource {
	private static final String HOME_DIR = ServerInitializer.getHomeDir().getAbsolutePath();
	private final String longActionID;

	public CacheFileSerializer(String longActionID) {
		this.longActionID = longActionID;
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return longActionID;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		File cachefile = new File(HOME_DIR + File.separator + "cache" + File.separator + longActionID);
		return new FileInputStream(cachefile);
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	public void writeToOutputStream(OutputStream outputStream) throws IOException {
		byte[] buf = new byte[1024];
		InputStream inputStream = getInputStream();
		int bytesRead = inputStream.read(buf);
		while (bytesRead != -1) {
			outputStream.write(buf, 0, bytesRead);
			bytesRead = inputStream.read(buf);
		}
		inputStream.close();
		outputStream.close();
	}
}
