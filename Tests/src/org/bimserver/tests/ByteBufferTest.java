package org.bimserver.tests;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class ByteBufferTest {
	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.wrap(new byte[8]);
		buffer.position(0);
		buffer.putLong(100000000L);
		buffer.position(6);
		buffer.putShort((short)2000);
		buffer.position(0);
		System.out.println(Arrays.toString(buffer.array()));
		System.out.println(buffer.getLong());
	}
}
