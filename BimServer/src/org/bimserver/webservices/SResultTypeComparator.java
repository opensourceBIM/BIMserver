package org.bimserver.webservices;

import java.util.Comparator;

import org.bimserver.shared.ResultType;

public class SResultTypeComparator implements Comparator<ResultType> {
	public SResultTypeComparator() {
	}

	@Override
	public int compare(ResultType o1, ResultType o2) {
		return o1.getName().compareTo(o2.getName());
	}
}
