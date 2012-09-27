package org.bimserver.webservices;

import java.util.Comparator;

import org.bimserver.interfaces.objects.SProject;

public class SProjectComparator implements Comparator<SProject> {

	@Override
	public int compare(SProject o1, SProject o2) {
		return o1.getName().compareTo(o2.getName());
	}
}
