package org.bimserver.webservices.authorization;

import org.bimserver.shared.exceptions.ErrorCode;
import org.bimserver.shared.exceptions.UserException;

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

public class AuthenticationException extends UserException {

	private static final long serialVersionUID = -402147016943330424L;

	public AuthenticationException(String message) {
		super(message);
	}

	public AuthenticationException(Exception e) {
		super(e);
	}

	public AuthenticationException(String message, Exception cause) {
		super(message, cause);
	}

	public AuthenticationException(String message, ErrorCode errorCode) {
		super(message, errorCode);
	}
}