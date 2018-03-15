package org.bimserver.validationreport;

/******************************************************************************
 * Copyright (C) 2009-2018  BIMserver.org
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IssueContainer extends Issue {
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