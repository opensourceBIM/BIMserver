package org.bimserver.shared;

import java.util.Comparator;

import org.bimserver.interfaces.objects.SUser;

public class SUserNameComparator implements Comparator<SUser> {

	@Override
	public int compare(SUser o1, SUser o2) {
		return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
	}
}