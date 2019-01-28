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
import java.io.OutputStream;

public class MultiplexingOutputStream extends OutputStream {

	private OutputStream a;
	private OutputStream b;

	public MultiplexingOutputStream(OutputStream a, OutputStream b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public void write(int b) throws IOException {
		this.a.write(b);
		this.b.write(b);
	}
	
	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		this.a.write(b, off, len);
		this.b.write(b, off, len);
	}
	
	@Override
	public void close() throws IOException {
		a.close();
		b.close();
	}
	
	public OutputStream getA() {
		return a;
	}
	
	public OutputStream getB() {
		return b;
	}
	
	@Override
	public void flush() throws IOException {
		a.flush();
		b.flush();
	}
}