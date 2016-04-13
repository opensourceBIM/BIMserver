package org.bimserver.validationreport;

import javax.xml.datatype.DatatypeConfigurationException;

public class IssueException extends Exception {

	private static final long serialVersionUID = -6816053014987016681L;

	public IssueException(String message) {
		super(message);
	}

	public IssueException(Exception e) {
		super(e);
	}
}
