package org.bimserver.servlets;

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

import org.bimserver.utils.GrowingByteBuffer;

public class ReusableByteArrayOutputStream extends OutputStream {

	private final GrowingByteBuffer buffer = new GrowingByteBuffer(262144);
	
	@Override
	public void write(int b) throws IOException {
		buffer.put((byte)b);
	}
	
	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		buffer.put(b, off, len);
	}

	public int usedSize() {
		return buffer.position();
	}

	public byte[] getByteArray() {
		return buffer.array();
	}
	
	public void reset() {
		buffer.position(0);
	}

	public void setPosition(int pos) {
		buffer.position(pos);
	}
}
