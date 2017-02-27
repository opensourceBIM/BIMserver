package org.bimserver.validationreport;

import java.io.IOException;

public interface IssueInterface {

	Issue add(Type messageType, String type, String guid, Long oid, String message, Object is, String shouldBe) throws IssueException;

	void add(Type messageType, String message, Object is, String shouldBe) throws IssueException;

	void addHeader(String translate);

	byte[] getBytes() throws IOException;

	void validate() throws IssueValidationException;
	
	void setCheckValid(String identifier, boolean valid);

	boolean isValid();
}