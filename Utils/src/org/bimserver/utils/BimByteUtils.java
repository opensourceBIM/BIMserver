package org.bimserver.utils;

public class BimByteUtils {

	public static int extractPid(byte[] key) {
		byte[] buffer = new byte[4];
		System.arraycopy(key, 0, buffer, 0, 4);
		return BinUtils.byteArrayToInt(buffer);
	}

	public static long extractOid(byte[] key) {
		byte[] buffer = new byte[8];
		System.arraycopy(key, 4, buffer, 0, 8);
		return BinUtils.byteArrayToLong(buffer);
	}

	public static int extractRid(byte[] key) {
		byte[] buffer = new byte[4];
		System.arraycopy(key, 12, buffer, 0, 4);
		return BinUtils.byteArrayToInt(buffer);
	}
}