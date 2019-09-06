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

import org.bimserver.plugins.deserializers.DeserializeException;

@WebFault(faultBean="ServiceException", name="ServiceException", targetNamespace="bimserver")
public abstract class ServiceException extends Exception {
	private static final long serialVersionUID = -2820189529963377510L;
	
	private ErrorCode errorCode;
	private String userMessage;
	private String fullMessage;

	public ServiceException(String userMessage) {
		super(userMessage);
		this.setUserMessage(userMessage);
		this.setFullMessage(userMessage);
	}

	public ServiceException(String userMessage, ErrorCode errorCode) {
		super(userMessage);
		this.errorCode = errorCode;
		this.setUserMessage(userMessage);
		this.setFullMessage(userMessage);
	}
	
	public ErrorCode getErrorCode() {
		return errorCode;
	}
	
	public ServiceException(Throwable e) {
		this(e.getMessage(), e);
	}
	
	public ServiceException(String userMessage, Throwable e) {
		super(userMessage, e);
		if (e instanceof DeserializeException) {
			this.errorCode = ((DeserializeException)e).getDeserializerErrorCode();
		}
		this.setUserMessage(userMessage);
		StringBuilder sb = new StringBuilder();
		buildFullMessage(sb, e);
		this.setFullMessage(sb.toString());
	}
	
	private void buildFullMessage(StringBuilder sb, Throwable throwable) {
		sb.append(throwable.getMessage());
		if (throwable.getCause() != null) {
			sb.append(" (");
			buildFullMessage(sb, throwable.getCause());
			sb.append(")");
		}
	}
	
	// Leave getters and setters, needed for JAXB serialisation/deserialisation
	public String getFullMessage() {
		return fullMessage;
	}
	
	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	public void setFullMessage(String fullMessage) {
		this.fullMessage = fullMessage;
	}
}
