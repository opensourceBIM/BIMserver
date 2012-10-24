package org.bimserver.ifcengine.executable;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class LoggingDataOutputStream implements DataOutput {

	private DataOutputStream dos;
	private LogWriter logWriter;

	public LoggingDataOutputStream(OutputStream out, LogWriter logWriter) {
		this.logWriter = logWriter;
		dos = new DataOutputStream(out);
	}
	
	public void flush() throws IOException {
		dos.flush();
		logWriter.flush();
	}
	
	@Override
	public void write(int b) throws IOException {
		dos.write(b);
		logWriter.write("write byte " + b);
	}

	@Override
	public void write(byte[] b) throws IOException {
		dos.write(b);
		logWriter.write("write bytes " + Arrays.toString(b));
	}

	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		dos.write(b, off, len);
		logWriter.write("write bytes " + Arrays.toString(b) + ", " + off + ", " + len);
	}

	@Override
	public void writeBoolean(boolean v) throws IOException {
		dos.writeBoolean(v);
		logWriter.write("write boolean " + v);
	}

	@Override
	public void writeByte(int v) throws IOException {
		dos.writeByte(v);
		logWriter.write("write byte " + v);
	}

	@Override
	public void writeShort(int v) throws IOException {
		dos.writeShort(v);
		logWriter.write("write short " + v);
	}

	@Override
	public void writeChar(int v) throws IOException {
		dos.writeChar(v);
		logWriter.write("write char " + v);
	}

	@Override
	public void writeInt(int v) throws IOException {
		dos.writeInt(v);
		logWriter.write("write int " + v);
	}

	@Override
	public void writeLong(long v) throws IOException {
		dos.writeLong(v);
		logWriter.write("write long " + v);
	}

	@Override
	public void writeFloat(float v) throws IOException {
		dos.writeFloat(v);
		logWriter.write("write float " + v);
	}

	@Override
	public void writeDouble(double v) throws IOException {
		dos.writeDouble(v);
		logWriter.write("write double " + v);
	}

	@Override
	public void writeBytes(String s) throws IOException {
		dos.writeBytes(s);
		logWriter.write("write bytes " + s);
	}

	@Override
	public void writeChars(String s) throws IOException {
		dos.writeChars(s);
		logWriter.write("write chars " + s);
	}

	@Override
	public void writeUTF(String s) throws IOException {
		dos.writeUTF(s);
		logWriter.write("write string " + s);
	}
}