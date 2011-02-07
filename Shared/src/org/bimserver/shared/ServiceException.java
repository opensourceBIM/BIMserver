package org.bimserver.shared;

import javax.xml.ws.WebFault;

@WebFault(faultBean="ServiceException", name="ServiceException")
public abstract class ServiceException extends Exception {
	private static final long serialVersionUID = -2820189529963377510L;
	
	private String userMessage;
	private String fullMessage;

	public ServiceException(String userMessage) {
		super(userMessage);
		this.setUserMessage(userMessage);
		this.setFullMessage(userMessage);
	}

	public ServiceException(Throwable e) {
		this(e.getMessage(), e);
	}
	
	public ServiceException(String userMessage, Throwable e) {
		super(userMessage, e);
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
