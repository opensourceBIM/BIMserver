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

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamReader extends Thread {

	private final BufferedInputStream inputStream;

	public StreamReader(String name, InputStream inputStream) {
		this.inputStream = new BufferedInputStream(inputStream);
		setName(name);
	}

	@Override
	public void run() {
		byte[] buffer = new byte[1024];
		int red;
		try {
			red = inputStream.read(buffer);
			while (red != -1) {
				String s = new String(buffer, 0, red);
				System.out.print(s);
				red = inputStream.read(buffer);
			}
		} catch (IOException e) {
		}
	}
}