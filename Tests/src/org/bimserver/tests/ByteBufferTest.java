package org.bimserver.tests;

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

import java.nio.ByteBuffer;
import java.util.Arrays;

public class ByteBufferTest {
	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.wrap(new byte[8]);
		buffer.position(0);
		buffer.putLong(100000000L);
		buffer.position(6);
		buffer.putShort((short)2000);
		buffer.position(0);
		System.out.println(Arrays.toString(buffer.array()));
		System.out.println(buffer.getLong());
	}
}
