package org.bimserver.ifc.compare;

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

public class FileReader {
	private byte[] buffer = new byte[1024];
	private int red;
	private final StringBuilder builder = new StringBuilder();
	private InputStream in;

	public FileReader(InputStream inputStream) throws IOException {
		in = inputStream;
		red = in.read(buffer);
	}
	
	public String getNextLine() throws IOException {
		while (red != -1 && builder.indexOf("\n") == -1) {
			builder.append(new String(buffer, 0, red));
			red = in.read(buffer);
		}
		int indexOfN = builder.indexOf("\n");
		if (indexOfN != -1 && indexOfN != 0) {
			if (builder.charAt(indexOfN - 1) == '\r') {
				String string = builder.substring(0, indexOfN - 1);
				builder.delete(0, indexOfN + 1);
				return string;
			} else {
				String string = builder.substring(0, indexOfN);
				builder.delete(0, indexOfN + 1);
				return string;
			}
		}
		return null;
	}
}
