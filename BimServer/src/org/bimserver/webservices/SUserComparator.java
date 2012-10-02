package org.bimserver.webservices;

import java.util.Comparator;

import org.bimserver.interfaces.objects.SUser;

public class SUserComparator implements Comparator<SUser> {

	@Override
	public int compare(SUser o1, SUser o2) {
		return o1.getName().compareTo(o2.getName());
	}
}
