package org.bimserver.utils;

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
import java.io.InputStream;
import java.io.OutputStream;

public class MultiplexingInputStream extends InputStream {

	private final OutputStream out;
	private final InputStream in;

	public MultiplexingInputStream(InputStream in, OutputStream out) {
		this.in = in;
		this.out = out;
	}
	
	@Override
	public int read() throws IOException {
		int read = in.read();
		if (read != -1) {
			out.write(read);
		}
		return read;
	}
	
	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		int read = in.read(b, off, len);
		if (read != -1) {
			out.write(b, off, read);
		}
		return read;
	}
	
	@Override
	public void close() throws IOException {
		out.flush();
		in.close();
		out.close();
		super.close();
	}
}