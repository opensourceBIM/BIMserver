package org.bimserver.ifcengine.executable;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * BIMserver software uses the IFC Engine DLL library build.
 * This binary Engine DLL is NOT open source. The IFC Engine DLL is a closed source product owned by the Netherlands Organisation for Applied Scientifc Research TNO.
 * The latest versions are available for download from http://ifcengine.com.
 * In case of none commercial use there is no license fee and redistribution of the binary is allowed as long as clearly mentioned that the IFC Engine DLL is used. The BIMserver.org software is non-commercial so users of the BIMserver software can use it free of charge.
 * Within the Open Source BIMserver software there is one exception to the normal conditions: A special version of the IFC Engine DLL is used that includes Clashdetection functionality, this version is not commercially available. For more information, please contact the owner at info@ifcengine.com
 *****************************************************************************/

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
