package org.bimserver.validationreport;

import java.io.IOException;

public interface IssueContainerSerializer {
	byte[] getBytes(IssueContainer issueContainer) throws IOException;
}