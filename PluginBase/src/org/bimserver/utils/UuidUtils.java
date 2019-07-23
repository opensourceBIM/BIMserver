package org.bimserver.utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

public class UuidUtils {

	public static byte[] toByteArray(UUID uuid) {
		ByteBuffer buffer = ByteBuffer.allocate(16).order(ByteOrder.LITTLE_ENDIAN);
		buffer.putLong(uuid.getMostSignificantBits());
		buffer.putLong(uuid.getLeastSignificantBits());
		return buffer.array();
	}
	
	public static UUID fromByteArray(byte[] data) {
		ByteBuffer buffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
		return new UUID(buffer.getLong(), buffer.getLong());
	}
}