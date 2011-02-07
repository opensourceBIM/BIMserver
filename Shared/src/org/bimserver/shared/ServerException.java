package org.bimserver.shared;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "ServerException", name = "ServerException")
public class ServerException extends ServiceException {
	private static final long serialVersionUID = -8757136271196139727L;

	public ServerException(String userMessage) {
		super(userMessage);
	}

	public ServerException(String userMessage, Throwable e) {
		super(userMessage, e);
	}

	public ServerException(Throwable e) {
		super(e);
	}
}