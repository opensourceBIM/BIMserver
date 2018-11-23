package org.bimserver.utils;

import java.io.BufferedInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class ByteUtils {
	public static byte[] extractHead(BufferedInputStream bufferedInputStream, int maxSize) throws IOException {
		bufferedInputStream.mark(maxSize);
		byte[] initialBytes = new byte[maxSize];
		int read = IOUtils.read(bufferedInputStream, initialBytes);
		if (read != maxSize) {
			byte[] trimmed = new byte[read];
			System.arraycopy(initialBytes, 0, trimmed, 0, read);
			initialBytes = trimmed;
		}
		bufferedInputStream.reset();
		return initialBytes;
	}
}
