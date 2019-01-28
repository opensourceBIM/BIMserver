package org.bimserver.plugins.renderengine;

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

public enum IndexFormat {
	I32(32),
	I64(64), 
	AUTO_DETECT(-1);

	public static final int BIT = 8;
	private int width;

	IndexFormat(int width) {
		this.width = width;
	}
	
	public int getWidth() {
		return width;
	}

	public int getValue() {
		if (this == AUTO_DETECT) {
			if (System.getProperty("sun.arch.data.model").equals("32")) {
				return 0;
			} else {
				return BIT;
			}
		}
		return this == I32 ? 0 : BIT;
	}
}
