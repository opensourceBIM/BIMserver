package org.bimserver.validationreport;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IssueContainer {
	private final List<Issue> issues = new ArrayList<>();

	public IssueBuilder builder() {
		return new IssueBuilder(this);
	}

	public void add(Issue issue) {
		issues.add(issue);
	}

	public Collection<Issue> list() {
		return issues;
	}
}