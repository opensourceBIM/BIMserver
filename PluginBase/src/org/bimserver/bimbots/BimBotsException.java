package org.bimserver.bimbots;

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

public class BimBotsException extends Exception {

	private static final long serialVersionUID = -2477117682144897692L;
	private int errorCode;

	public BimBotsException(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public BimBotsException(Exception e, int errorCode) {
		super(e);
		this.errorCode = errorCode;
	}

	public BimBotsException(Exception e, BimBotErrorCode errorCode) {
		super(e);
		this.errorCode = errorCode.getErrorCode();
	}

	public BimBotsException(String message, BimBotErrorCode errorCode) {
		super(message);
		this.errorCode = errorCode.getErrorCode();
	}

	public int getErrorCode() {
		return errorCode;
	}
}
