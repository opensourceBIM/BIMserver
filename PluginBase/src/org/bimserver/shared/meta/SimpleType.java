package org.bimserver.shared.meta;

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

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.activation.DataHandler;

public enum SimpleType {
	ENUM,
	STRING,
	LONG,
	SHORT,
	INT,
	BOOLEAN,
	FLOAT,
	DOUBLE,
	DATE,
	CLASS,
	DATAHANDLER,
	BYTEARRAY,
	LIST,
	SET,
	VOID,
	UNKNOWN;

	public static SimpleType get(Class<?> instanceClass) {
		if (instanceClass.isEnum()) {
			return ENUM;
		} else if (instanceClass == String.class) {
			return STRING;
		} else if (instanceClass == Long.class) {
			return LONG;
		} else if (instanceClass == Integer.class) {
			return SHORT;
		} else if (instanceClass == Short.class) {
			return INT;
		} else if (instanceClass == Boolean.class) {
			return BOOLEAN;
		} else if (instanceClass == Float.class) {
			return FLOAT;
		} else if (instanceClass == Double.class) {
			return DOUBLE;
		} else if (instanceClass == Date.class) {
			return DATE;
		} else if (instanceClass == DataHandler.class) {
			return DATAHANDLER;
		} else if (instanceClass == byte[].class) {
			return BYTEARRAY;
		} else if (instanceClass == List.class) {
			return LIST;
		} else if (instanceClass == Set.class) {
			return SET;
		} else if (instanceClass == Void.class) {
			return VOID;
		}
		return UNKNOWN;
	}
}
