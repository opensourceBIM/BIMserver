package org.bimserver.validationreport;

import java.io.IOException;

public interface IssueInterface {

	void add(Type error, long oid, String message, Object is, String shouldBe) throws IssueException;

	void addHeader(String translate);

	byte[] getBytes() throws IOException;

	void validate() throws IssueValidationException;
}
