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

public class BimByteUtils {

	public static int extractPid(byte[] key) {
		byte[] buffer = new byte[4];
		System.arraycopy(key, 0, buffer, 0, 4);
		return BinUtils.byteArrayToInt(buffer);
	}

	public static long extractOid(byte[] key) {
		byte[] buffer = new byte[8];
		System.arraycopy(key, 4, buffer, 0, 8);
		return BinUtils.byteArrayToLong(buffer);
	}

	public static int extractRid(byte[] key) {
		byte[] buffer = new byte[4];
		System.arraycopy(key, 12, buffer, 0, 4);
		return BinUtils.byteArrayToInt(buffer);
	}
}