package org.bimserver.plugins;

import java.io.IOException;
import java.io.OutputStream;

public abstract class SerializerDataOutputStream extends OutputStream {

	public abstract void writeByte(byte val) throws IOException;
	public abstract void writeDouble(double value) throws IOException;
	public abstract void writeFloat(float value) throws IOException;
	public abstract void writeLong(long value) throws IOException;
	public abstract void writeInt(int value) throws IOException;
	public abstract void writeShort(short value) throws IOException;
	public abstract void writeUTF(String value) throws IOException;
}