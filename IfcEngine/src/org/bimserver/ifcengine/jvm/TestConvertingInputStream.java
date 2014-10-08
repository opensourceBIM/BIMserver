package org.bimserver.ifcengine.jvm;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class TestConvertingInputStream {
	public static void main(String[] args) throws IOException {
		ByteArrayOutputStream testStream = new ByteArrayOutputStream();
		DataOutputStream testDataStream = new DataOutputStream(testStream);
		testDataStream.writeInt(8000);
		testDataStream.write(new byte[8000]);
		testDataStream.writeInt(200);
		testDataStream.write(new byte[200]);
		testDataStream.writeInt(9090);
		testDataStream.write(new byte[9090]);
		testDataStream.writeInt(-1);
		testDataStream.flush();

		ConvertingInputStream convertingInputStream = new ConvertingInputStream(new DataInputStream(new ByteArrayInputStream(testStream.toByteArray())));
		byte[] buffer = new byte[1024];
		int read = convertingInputStream.read(buffer, 0, 1024);
		ByteArrayOutputStream compareStream = new ByteArrayOutputStream();
		while (read != -1) {
			compareStream.write(buffer, 0, read);
			read = convertingInputStream.read(buffer, 0, 1024);
		}
		convertingInputStream.close();

		byte[] compare = new byte[8000 + 200 + 9090];
		if (compare.length != compareStream.size()) {
			System.out.println("FAIL! Size different " + compare.length + "/" + compareStream.size());
		}
		if (Arrays.equals(compareStream.toByteArray(), compare)) {
			System.out.println("OK!");
		} else {
			System.out.println("FAIL!");
		}
	}
}