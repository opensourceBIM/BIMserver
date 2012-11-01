package org.bimserver.ifcengine.executable;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LoggingDataInputStream implements DataInput {

	private LogWriter logWriter;
	private DataInputStream dataInputStream;

	public LoggingDataInputStream(InputStream in, LogWriter logWriter) {
		this.logWriter = logWriter;
		dataInputStream = new DataInputStream(in);
	}

	@Override
	public void readFully(byte[] b) throws IOException {
		dataInputStream.readFully(b);
		logWriter.write("read fully");
	}

	@Override
	public void readFully(byte[] b, int off, int len) throws IOException {
		dataInputStream.readFully(b, off, len);
		logWriter.write("read fully");
	}

	@Override
	public int skipBytes(int n) throws IOException {
		int skipBytes = dataInputStream.skipBytes(n);
		logWriter.write("skip bytes " + n);
		return skipBytes;
	}

	@Override
	public boolean readBoolean() throws IOException {
		boolean readBoolean = dataInputStream.readBoolean();
		logWriter.write("read boolean " + readBoolean);
		return readBoolean;
	}

	@Override
	public byte readByte() throws IOException {
		byte readByte = dataInputStream.readByte();
		logWriter.write("read byte " + readByte);
		return readByte;
	}

	@Override
	public int readUnsignedByte() throws IOException {
		int readUnsignedByte = dataInputStream.readUnsignedByte();
		logWriter.write("read unsigned byte " + readUnsignedByte);
		return readUnsignedByte;
	}

	@Override
	public short readShort() throws IOException {
		short value = dataInputStream.readShort();
		logWriter.write("read short " + value);
		return value;
	}

	@Override
	public int readUnsignedShort() throws IOException {
		int readUnsignedShort = dataInputStream.readUnsignedShort();
		logWriter.write("read unsigned short " + readUnsignedShort);
		return readUnsignedShort;
	}

	@Override
	public char readChar() throws IOException {
		char readChar = dataInputStream.readChar();
		logWriter.write("read char " + readChar);
		return readChar;
	}

	@Override
	public int readInt() throws IOException {
		int readInt = dataInputStream.readInt();
		logWriter.write("read int " + readInt);
		return readInt;
	}

	@Override
	public long readLong() throws IOException {
		long readLong = dataInputStream.readLong();
		logWriter.write("read long " + readLong);
		return readLong;
	}

	@Override
	public float readFloat() throws IOException {
		float readFloat = dataInputStream.readFloat();
		logWriter.write("read float " + readFloat);
		return readFloat;
	}

	@Override
	public double readDouble() throws IOException {
		double readDouble = dataInputStream.readDouble();
		logWriter.write("read double " + readDouble);
		return readDouble;
	}

	@Override
	public String readLine() throws IOException {
		@SuppressWarnings("deprecation")
		String readLine = dataInputStream.readLine();
		logWriter.write("read line " + readLine);
		return readLine;
	}

	@Override
	public String readUTF() throws IOException {
		String readUTF = dataInputStream.readUTF();
		logWriter.write("read utf " + readUTF);
		return readUTF;
	}
}
