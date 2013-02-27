package org.bimserver.webservices;

import java.util.Comparator;

import org.bimserver.interfaces.objects.SService;

public class SServiceComparator implements Comparator<SService> {

	@Override
	public int compare(SService o1, SService o2) {
		int r = o1.getServiceName().compareTo(o2.getServiceName());
		if (r == 0) {
			return o1.getProfileName().compareTo(o2.getProfileName());
		}
		return r;
	}
}