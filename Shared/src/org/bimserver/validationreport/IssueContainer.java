package org.bimserver.validationreport;

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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IssueContainer extends Issue {
	private static final Logger LOGGER = LoggerFactory.getLogger(IssueContainer.class);
	private final List<Issue> issues = new ArrayList<>();
	private String title;

	public IssueBuilder builder() {
		return new IssueBuilder(this);
	}

	public void add(Issue issue) {
		issues.add(issue);
	}

	public Collection<Issue> list() {
		return issues;
	}

	public void dumpSummary() {
		LOGGER.info("Dumping IssueContainer");
		HashMap<String, AtomicInteger> map = new HashMap<>();
		dumpSummary(map, 0);
		for (String key : map.keySet()) {
			LOGGER.info(key + ": " + map.get(key).get());
		}
	}
	
	public void dumpSummary(Map<String, AtomicInteger> map, int indentation) {
		for (Issue issue : issues) {
			AtomicInteger ai = map.get(issue.getOriginatigModelCheckName());
			if (ai == null) {
				ai = new AtomicInteger(0);
				map.put(issue.getOriginatigModelCheckName(), ai);
			}
			ai.incrementAndGet();
			if (issue instanceof IssueContainer) {
				((IssueContainer)issue).dumpSummary(map, indentation + 1);
			}
		}
	}
 
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
}