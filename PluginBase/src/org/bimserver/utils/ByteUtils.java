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

import org.apache.commons.io.IOUtils;

public class ByteUtils {
	public static byte[] extractHead(BufferedInputStream bufferedInputStream, int maxSize) throws IOException {
		bufferedInputStream.mark(maxSize);
		byte[] initialBytes = new byte[maxSize];
		int read = IOUtils.read(bufferedInputStream, initialBytes);
		if (read != maxSize) {
			byte[] trimmed = new byte[read];
			System.arraycopy(initialBytes, 0, trimmed, 0, read);
			initialBytes = trimmed;
		}
		bufferedInputStream.reset();
		return initialBytes;
	}
}
