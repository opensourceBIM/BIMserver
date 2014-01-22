package org.bimserver.shared.exceptions;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

public enum ErrorCode {
	SET_REFERENCE_FAILED_OPPOSITE_ALREADY_SET(500);

	private int code;

	ErrorCode(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}

	public static ErrorCode parse(int asInt) {
		// TODO make faster
		for (ErrorCode errorCode : ErrorCode.values()) {
			if (asInt == errorCode.getCode()) {
				return errorCode;
			}
		}
		return null;
	}
}
