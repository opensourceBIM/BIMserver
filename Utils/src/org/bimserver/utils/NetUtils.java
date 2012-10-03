package org.bimserver.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;

import com.google.common.base.Charsets;

public class NetUtils {
	public static String getContent(URL url, int timeOut) throws IOException {
		URLConnection openConnection = url.openConnection();
		openConnection.setConnectTimeout(timeOut);
		openConnection.setReadTimeout(timeOut);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		InputStream in = openConnection.getInputStream();
		IOUtils.copy(in, byteArrayOutputStream);
		in.close();
		return new String(byteArrayOutputStream.toByteArray(), Charsets.UTF_8);
	}
}
