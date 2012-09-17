package org.bimserver.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.google.common.base.Charsets;

public class NetUtils {
	public static String getContent(URL url) {
		try {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			InputStream in = url.openStream();
			IOUtils.copy(in, byteArrayOutputStream);
			in.close();
			return new String(byteArrayOutputStream.toByteArray(), Charsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
