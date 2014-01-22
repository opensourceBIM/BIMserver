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