package org.bimserver.plugins.deserializers;

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

public class DeserializeException extends Exception {

	private static final long serialVersionUID = -7216984454398041095L;
	private long lineNumber;
	private DeserializerErrorCode deserializerErrorCode;

	public DeserializeException(DeserializerErrorCode deserializerErrorCode, long lineNumber, String message, Exception e) {
		super("Error on line " + lineNumber + ": " + message, e);
		this.deserializerErrorCode = deserializerErrorCode;
		this.lineNumber = lineNumber;
	}

	public DeserializeException(DeserializerErrorCode deserializerErrorCode, String message, Exception e) {
		super(message, e);
		this.deserializerErrorCode = deserializerErrorCode;
	}
	
	public long getLineNumber() {
		return lineNumber;
	}
	
	public DeserializeException(DeserializerErrorCode deserializerErrorCode, String message) {
		super(message);
		this.deserializerErrorCode = deserializerErrorCode;
	}
	
	public DeserializerErrorCode getDeserializerErrorCode() {
		return deserializerErrorCode;
	}
	
	public DeserializeException(DeserializerErrorCode deserializerErrorCode, long lineNumber, String message) {
		super("Error on line " + lineNumber + ": " + message);
		this.deserializerErrorCode = deserializerErrorCode;
		this.lineNumber = lineNumber;
	}

	public DeserializeException(Exception e) {
		super(e);
	}

	public DeserializeException(DeserializerErrorCode deserializerErrorCode, long lineNumber, Exception e) {
		super(e);
		this.deserializerErrorCode = deserializerErrorCode;
		this.lineNumber = lineNumber;
	}
}
