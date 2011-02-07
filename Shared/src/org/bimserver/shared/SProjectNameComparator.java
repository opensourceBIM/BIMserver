package org.bimserver.shared;

import java.util.Comparator;

import org.bimserver.interfaces.objects.SProject;

public class SProjectNameComparator implements Comparator<SProject> {

	@Override
	public int compare(SProject o1, SProject o2) {
		if (o1 == null && o2 == null) {
			return 0;
		}
		return o1.getName().compareTo(o2.getName());
	}
}