package org.bimserver.plugins;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.IOException;
import java.io.OutputStream;

public abstract class SerializerDataOutputStream extends OutputStream {

	public abstract void writeByte(byte val) throws IOException;
	public abstract void writeDouble(double value) throws IOException;
	public abstract void writeDoubleUnchecked(double value) throws IOException;
	public abstract void writeFloat(float value) throws IOException;
	public abstract void writeFloatUnchecked(float value) throws IOException;
	public abstract void writeLong(long value) throws IOException;
	public abstract void writeLongUnchecked(long value) throws IOException;
	public abstract void writeInt(int value) throws IOException;
	public abstract void writeIntUnchecked(int v) throws IOException;
	public abstract void writeShort(short value) throws IOException;
	public abstract void writeShortUnchecked(short value) throws IOException;
	public abstract void writeUTF(String value) throws IOException;
	public abstract void ensureExtraCapacity(int i);
	public abstract void writeUnchecked(byte[] b, int off, int len) throws IOException;
	public abstract void writeByte(int val) throws IOException;
	public abstract void writeByteUnchecked(int val) throws IOException;
	public abstract void align8() throws IOException;
	public abstract void align4() throws IOException;
	public abstract int pos();
}