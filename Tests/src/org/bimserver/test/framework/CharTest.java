package org.bimserver.test.framework;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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

import java.nio.CharBuffer;

import com.google.common.base.Charsets;

public class CharTest {
	public static void main(String[] args) {
		char c = '\u00E7';
		CharBuffer wrap = CharBuffer.wrap(new char[]{c});
		byte[] array = Charsets.UTF_16.encode(wrap).array();
		System.out.println(array);
	}
}
