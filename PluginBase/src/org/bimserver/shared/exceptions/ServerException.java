package org.bimserver.shared.exceptions;

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

import javax.xml.ws.WebFault;

@WebFault(faultBean = "ServerException", name = "ServerException", targetNamespace="bimserver")
public class ServerException extends ServiceException {
	private static final long serialVersionUID = -8757136271196139727L;

	public ServerException(String userMessage) {
		super(userMessage);
	}
	
	public ServerException(String message, ErrorCode errorCode) {
		super(message, errorCode);
	}

	public ServerException(String userMessage, Throwable e) {
		super(userMessage, e);
	}

	public ServerException(Throwable e) {
		super(e);
	}
}