package org.bimserver.interfaces.objects;

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

public enum SServiceSimpleType {
	ENUM(0),
	STRING(1),
	LONG(2),
	INT(3),
	BOOLEAN(4),
	FLOAT(5),
	DOUBLE(6),
	DATE(7),
	CLASS(8),
	DATAHANDLER(9),
	BYTEARRAY(10),
	LIST(11),
	SET(12),
	VOID(13),
	UNKNOWN(14);
	int ordinal;

	SServiceSimpleType(int ordinal) {
		this.ordinal = ordinal;
	}
	
	public int getOrdinal() {
		return ordinal;
	}
}